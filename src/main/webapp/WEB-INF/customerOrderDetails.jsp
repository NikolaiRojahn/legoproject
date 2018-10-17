<%@page import="function.BuildHouse"%>
<%@page import="function.User"%>
<%@page import="function.Order"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Details</title>

    </head>
    <body>
        <% User user = (User) request.getSession().getAttribute("user"); %>
        <% Order order = (Order) request.getAttribute("orderdetails");%>
        <% List<BuildHouse> house2x4 = (List<BuildHouse>) request.getAttribute("build2x4");%>
        <% List<BuildHouse> house2x2 = (List<BuildHouse>) request.getAttribute("build2x2");%>
        <% List<BuildHouse> house2x1 = (List<BuildHouse>) request.getAttribute("build2x1");%>
        <h1><%= "ORDER: " + order.getId()%></h1>
        <form>
        </form>
    </body>
</html>

<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-body p-0">




                    <div class="row pb-5 p-5">
                        <div class="col-md-6">
                            <div id="logo">
                                <img src="logo2.png">
                            </div>
                            <p class="font-weight-bold mb-4">Client Information</p>
                            <p class="mb-1"><span class="text-muted">Email: </span><%= user.getEmail().toString()%></p>
                            <p class="mb-1"><span class="text-muted">Type: </span><%= user.getRole().toString()%></p>
                            <p class="mb-1"><span class="text-muted">Customer ID: </span><%= order.getU_id()%></p>
                            <p class="mb-1"><span class="text-muted">Length: </span><%=order.getLength()%></p>
                            <p class="mb-1"><span class="text-muted">Width: </span><%=order.getWidth()%></p>
                            <p class="mb-1"><span class="text-muted">Heigth: </span><%=order.getHeigth()%></p>
                            <p class="mb-1"><span class="text-muted">Shipped: </span><%=order.getShipped()%></p>
                        </div>
                    </div>

                    <div class="row p-5">
                        <div class="col-md-12">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th class="border-0 text-uppercase small font-weight-bold">Type</th>
                                        <th class="border-0 text-uppercase small font-weight-bold">Side1</th>
                                        <th class="border-0 text-uppercase small font-weight-bold">Side2</th>
                                        <th class="border-0 text-uppercase small font-weight-bold">Side3</th>
                                        <th class="border-0 text-uppercase small font-weight-bold">Side4</th>
                                        <th class="border-0 text-uppercase small font-weight-bold">Total</th>
                                        <th class="border-0 text-uppercase small font-weight-bold">Total x heigth</th>

                                    <tr>

                                    </tr>    
                                    <tr>

                                        <td><p><%out.print(house2x4.get(0).getType()); %></td>
                                        <td><p><%out.print(house2x4.get(0).getSide1()); %></td>
                                        <td><p><%out.print(house2x4.get(0).getSide2()); %></td>
                                        <td><p><%out.print(house2x4.get(0).getSide3()); %></td>
                                        <td><p><%out.print(house2x4.get(0).getSide4()); %></td>
                                        <td><p><%out.print(house2x4.get(0).getTotal()); %></td>
                                        <td><p><%out.print(house2x4.get(0).getTotalxHeigth()); %></td>

                                    </tr>
                                    <tr>

                                        <td><p><%out.print(house2x2.get(0).getType()); %></td>
                                        <td><p><%out.print(house2x2.get(0).getSide1()); %></td>
                                        <td><p><%out.print(house2x2.get(0).getSide2()); %></td>
                                        <td><p><%out.print(house2x2.get(0).getSide3()); %></td>
                                        <td><p><%out.print(house2x2.get(0).getSide4()); %></td>
                                        <td><p><%out.print(house2x2.get(0).getTotal()); %></td>
                                        <td><p><%out.print(house2x2.get(0).getTotalxHeigth()); %></td>                                    
                                    </tr>
                                    <tr>
                                        <td><p><%out.print(house2x1.get(0).getType()); %></td>
                                        <td><p><%out.print(house2x1.get(0).getSide1()); %></td>
                                        <td><p><%out.print(house2x1.get(0).getSide2()); %></td>
                                        <td><p><%out.print(house2x1.get(0).getSide3()); %></td>
                                        <td><p><%out.print(house2x1.get(0).getSide4()); %></td>
                                        <td><p><%out.print(house2x1.get(0).getTotal()); %></td>
                                        <td><p><%out.print(house2x1.get(0).getTotalxHeigth()); %></td>
                                    </tr>
                                    <tr>


                                    </tr>

                                </thead>

                            </table>

                            <form name="backToOrders" action="FrontController" method="POST">
                                <input type="hidden" name="command" value="backToOrders">
                                <br>
                                <input type="submit" value="Show orders">
                            </form>
                            <form name="backToShop" action="FrontController" method="POST">
                                <input type="hidden" name="command" value="backToShop">
                                <br>
                                <input type="submit" value="Back to shop">
                            </form>
                        </div>
                    </div>

                    <div class="d-flex flex-row-reverse bg-dark text-white p-4">
                        <div class="py-3 px-5 text-right">
                        </div>
                    </div>


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
            </div>
        </div>
    </div>
</div>