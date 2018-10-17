<%-- 
    Document   : customerShowListOfOrders
    Created on : 16-10-2018, 12:14:03
    Author     : nr
--%>

<%@page import="java.util.List"%>
<%@page import="function.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% User user = (User) request.getSession().getAttribute("user"); %>
        <% List<Integer> orderIds = (List<Integer>) request.getSession().getAttribute("listOrderIds");%>
        <h1>Orders made by: <% out.print(user.getEmail().toString());%>.</h1>

        <form name="showOrderDetails" action="FrontController" method="POST">
            <input type="hidden" name="command" value="showOrderDetails">
            <%
                for (Integer r : orderIds) {

                    out.println("<li><a href=\"FrontController?command=showOrderDetails&orderId=" + r + "\">OrderID: " + r + "</li><br>");
                }
            %>
        </form>

        <form name="backToShop" action="FrontController" method="POST">
            <input type="hidden" name="command" value="backToShop">
            <br>
            <input type="submit" value="Back to shop">
        </form>
    </body>
</html>
