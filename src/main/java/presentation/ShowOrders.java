/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import function.Controller;
import function.LoginSampleException;
import function.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nr
 */
public class ShowOrders extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        
        List<Integer> orderIds = Controller.getOrdersByCustomer(((User) request.getSession().getAttribute("user")));
        request.getSession().setAttribute("listOrderIds", orderIds);
        return ((User) request.getSession().getAttribute("user")).getRole() + "Orders";
        
    }


}
