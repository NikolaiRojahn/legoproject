/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import function.LoginSampleException;
import function.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nr
 */
public class BackToShop extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        request.removeAttribute("build2x4");
        request.removeAttribute("build2x2");
        request.removeAttribute("build2x1");
        request.removeAttribute("orderdetails");
        return ((User) request.getSession().getAttribute("user")).getRole() + "page";
    }

}
