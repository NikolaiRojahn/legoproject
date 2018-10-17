/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import function.CreateOrderException;
import function.LoginSampleException;
import function.Order;
import function.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nr
 */
public class DataMapper {

    private static final String INSERT_USER_DEFAULT = "INSERT INTO `user` (email, password, role) VALUES (?, ?, ?)";
    private static final String GET_LOGIN_USER = "SELECT id, role FROM user WHERE email=? AND password=?";
    private static final String INSERT_ORDER_ORDERS = "INSERT INTO orders (u_id) VALUES (?)";
    private static final String INSERT_ORDER_ORDER_DETAILS = "INSERT INTO order_details (o_id, length, width, heigth) VALUES (?, ?, ?, ?)";
    private static final String GET_ORDERNUMBERS_BY_USER = "SELECT o.order_id FROM orders o WHERE o.u_id =?";
    private static final String GET_ORDER_DETAILS_BY_ORDERID = "SELECT o.order_id, o.u_id, o.shipped, od.length, od.width, od.heigth FROM orders o, order_details od WHERE o.order_id =?";

    public static User login(String email, String password) throws LoginSampleException {
        try {
            Connection con = DBConnector.connection();
            String SQL = GET_LOGIN_USER;
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                int id = rs.getInt("id");
                User user = new User(email, password, role);
                user.setId(id);
                return user;
            } else {
                throw new LoginSampleException("Could not validate user");
            }
        } catch (SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static void createUser(User user) throws LoginSampleException {
        try {
            Connection con = DBConnector.connection();
            String SQL = INSERT_USER_DEFAULT;
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static List<Integer> getOrdersByUser(User user) {
        Connection con = null;
        List<Integer> listOrderId = new ArrayList();
        try {
            con = DBConnector.connection();
            PreparedStatement pstmt = con.prepareStatement(GET_ORDERNUMBERS_BY_USER);
            pstmt.setInt(1, user.getId());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int invoiceId = rs.getInt("order_id");
                listOrderId.add(invoiceId);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listOrderId;
    }

    public static void createOrder(User user, int length, int width, int heigth) throws CreateOrderException {
        Connection con = null;
        try {
            con = DBConnector.connection();
            PreparedStatement orderPs = con.prepareStatement(INSERT_ORDER_ORDERS, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement orderDetailsPs = con.prepareStatement(INSERT_ORDER_ORDER_DETAILS, Statement.RETURN_GENERATED_KEYS);
            ResultSet rsOrder;
            int orderId = 0;

            orderPs.setInt(1, user.getId());
            con.setAutoCommit(false);
            int resultOrderPs = orderPs.executeUpdate();
            rsOrder = orderPs.getGeneratedKeys();
            rsOrder.next();
            orderId = rsOrder.getInt(1);
            if (resultOrderPs == 1) {
                ResultSet rsOrderDetails;
//                int orderDetailsId = 0;
                orderDetailsPs.setInt(1, orderId);
                orderDetailsPs.setInt(2, length);
                orderDetailsPs.setInt(3, width);
                orderDetailsPs.setInt(4, heigth);
                int resultOrderDetailsPs = orderDetailsPs.executeUpdate();
                rsOrderDetails = orderDetailsPs.getGeneratedKeys();
                con.commit();
            } else {
                con.rollback();
            }

        } catch (SQLException ex) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(DataMapper.class.getName()).log(Level.SEVERE, null, ex1);
                    throw new CreateOrderException("There was an error placing your order.", ex1);
                }
            }
            throw new CreateOrderException("There was an error placing your order.", ex);
        }
    }

    public static Order getOrderDetails(int id) {
        Order order = null;
        Connection con = null;
        try {
            con = DBConnector.connection();
            PreparedStatement pstmt = con.prepareStatement(GET_ORDER_DETAILS_BY_ORDERID);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int order_id = rs.getInt("order_id");
            int u_id = rs.getInt("u_id");
            //String orderdate = rs.getString("orderdate");
            String shipped = rs.getString("shipped");
            int length = rs.getInt("length");
            int width = rs.getInt("width");
            int heigth = rs.getInt("heigth");
            order = new Order(order_id, u_id, shipped, length, width, heigth);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return order;
    }
}
