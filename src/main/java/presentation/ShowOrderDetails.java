/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import function.Controller;
import function.LoginSampleException;
import function.Order;
import function.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nr
 */
public class ShowOrderDetails extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        request.removeAttribute("build2x4");
        request.removeAttribute("build2x2");
        request.removeAttribute("build2x1");
        request.removeAttribute("orderdetails");
        int id = Integer.parseInt(request.getParameter("orderId"));
        Order order = (Order) Controller.getOrderDetails(id);
        request.setAttribute("build2x4", Controller.getQuantityList2x4(order.getLength(), order.getWidth(), order.getHeigth()));
        request.setAttribute("build2x2", Controller.getQuantityList2x2(order.getLength(), order.getWidth(), order.getHeigth()));
        request.setAttribute("build2x1", Controller.getQuantityList2x1(order.getLength(), order.getWidth(), order.getHeigth()));

        request.setAttribute("orderdetails", order);
        return ((User) request.getSession().getAttribute("user")).getRole() + "OrderDetails";
    }
}
