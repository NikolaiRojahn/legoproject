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
public class Index extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("length", "");
        request.setAttribute("width", "");
        request.setAttribute("heigth", "");
        return ((User) request.getSession().getAttribute("user")).getRole() + "page";
        
    }

 
    
}
