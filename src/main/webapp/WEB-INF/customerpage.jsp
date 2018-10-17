<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LEGO HOUSE - GROUP</title>
    </head>
    <body>
        <div id="customerpage">

            <h1>LEGO HOUSE - GROUP</h1>
            When ordering a lego house, please fill out lenght, width and height.
            <br>
            <br>
            <br>
            <br>

            <form name="placeOrder" action="FrontController" method="POST">
                <input type="hidden" name="command" value="placeOrder">
                Length:<br><br>
                <input type="text" name="length" value="">
                <br><br>
                Width:<br><br>
                <input type="text" name="width" value="">
                <br><br>
                Heigth:<br><br>
                <input type="text" name="heigth" value="">
                <br><br>
                <input type="submit" value="Place order">
            </form>
            <br><br>
            You can see quantity lists on your specific orders.<br><br>
            <form name="showOrders" action="FrontController" method="POST"> 
                <input type="hidden" name="command" value="showOrders">
                <input type="submit" value="Show orders">
            </form>

            <br><br>  

            <% String successfullOrder = (String) request.getAttribute("infoMessage");
                if (successfullOrder != null) {
                    out.println(successfullOrder);
                }
            %>

            <% String errorMessage = (String) request.getAttribute("errorMessage");
                if (errorMessage != null) {
                    out.println(errorMessage);
                }
            %>
        </div>
    </body>
</html>
