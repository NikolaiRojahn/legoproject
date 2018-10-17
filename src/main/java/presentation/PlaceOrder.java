/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import function.Controller;
import function.CreateOrderException;
import function.Layer;
import function.LoginSampleException;
import function.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nr
 */
public class PlaceOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        //int id = ((User) request.getSession().getAttribute("user")).getId();
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int heigth = Integer.parseInt(request.getParameter("heigth"));
        try {
//            request.getSession().setAttribute("build2x4", Controller.getQuantityList2x4(length, width, heigth));
//            request.getSession().setAttribute("build2x2", Controller.getQuantityList2x2(length, width, heigth));
//            request.getSession().setAttribute("build2x1", Controller.getQuantityList2x1(length, width, heigth));
            Controller.placeOrder(((User) request.getSession().getAttribute("user")), length, width, heigth);
//            request.setAttribute("stykListe", layers.toString());
        } catch (CreateOrderException ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            return ((User) request.getSession().getAttribute("user")).getRole() + "page";
        }
        request.setAttribute("infoMessage", "Successfully order creation");
        return ((User) request.getSession().getAttribute("user")).getRole() + "page";

    }

}
