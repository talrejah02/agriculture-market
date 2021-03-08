<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="connection.dbconnect" %>
<%@page import="java.sql.*"%>  
<%

String state = request.getParameter("state");
String commodity = request.getParameter("commodity");
int quantity = Integer.parseInt(request.getParameter("quantity"));
String city = request.getParameter("city");
System.out.println(state);
System.out.println(commodity);
System.out.println(city);
System.out.println(quantity);

Connection con = null;
con = dbconnect.createconnection();
String query= "  SELECT * FROM `stock` WHERE p_name='"+commodity+"' and state='"+state+"' and city='"+city+"' and p_quantity>='quantity' ";
Statement stm=con.createStatement();
ResultSet rs= stm.executeQuery(query);


%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="style.css">
</head>
<body>
 
 <header>
        <div class="part">
           <div class="part1">
               <p>NATIONAL  LIVE  AGRICULTURAL  MARKET</p>
           </div>

           <div class="part2">
               <i class="fa fa-phone" style="float: left;"></i>
               <p style="font-weight: 600; font-size: 25px; margin-top: 150px; margin-left: 75px; ">Call Us</p>
               <p style="font-weight: 600; font-size: 20px; margin-left: 170px; margin-top: -50px;">8473688364</p>
               
              <img src="images/touch.png" style="height: 30px; width: 30px; margin-left: 50px; float: left;">
              <p style="font-weight: 600; font-size: 20px; margin-left: 10px; margin-top: 5px; float: left;"><a href="registration.html" style="text-decoration: none;color:black;"> Registration</a></p>

              <img src="images/login.png" style="height: 30px; width: 30px; margin-left: 2px; float: left;margin-right: 10px;">
              <p style="font-weight: 600; font-size: 20px; margin-left: 100px; margin-top: 25px;"><a href="login.html" style="text-decoration: none;color:black;">Login</a></p>

           </div>
           
        </div>

         <nav class="nav">
            <ul class="ul">
                <li class="li"><a href="home.html" style="text-decoration: none; color: black;"> Home</a></li>
                <li class="li" ><a href="home.html" style="text-decoration: none; color: black;"> Transportation</a></li>
                <li class="li" ><a href="live trade.html" style="text-decoration: none; color: black;"> Live Trade</a></li>
                <li class="li" ><a href="offline trade.html" style="text-decoration: none; color: black;"> Offline Trade</a></li>
                <li class="li" ><a href="sell.html" style="text-decoration: none; color: black;"> Sell</a></li>
                <li class="li" ><a href="home.html" style="text-decoration: none; color: black;"> Order</a>
                    <ul class="ul1">
                         <li class="li1"><a href="#" style="text-decoration: none; color: black;"> Pending</a></li>  
                         <li class="li1"><a href="#" style="text-decoration: none; color: black;"> Past Order</a></li>     
                    </ul>
                </li>
                <li class="li" style="margin-left: 20px;"><a href="#" style="text-decoration: none; color: black;"> Dash Board</a>
                    <ul class="ul2">
                        <li class="li2"><a href="#" style="text-decoration: none; color: black;"> Tradind Details</a></li>  
                        <li class="li2"><a href="#" style="text-decoration: none; color: black;"> Stack Holder Data</a></li>     
                   </ul>
                </li>
                <li class="li" style="margin-left: 20px;"><a href="#" style="text-decoration: none; color: black;"> Commodity</a>
                    <ul class="ul3">
                        <li class="li3"><a href="#" style="text-decoration: none; color: black;"> List of Commodity</a></li>  
                        <li class="li3"><a href="#" style="text-decoration: none; color: black;"> Commodity Quality</a></li>     
                   </ul>
                </li>
                <li class="li" style="margin-left: 20px;"><a href="#" style="text-decoration: none; color: black;"> Price Detail</a></li>
                <li class="li" style="margin-left: 20px;"><a href="#" style="text-decoration: none; color: black;"> Contact Us</a></li>

            </ul>
         </nav>

         
        </header>
 <!-- -------------------------------------------Header Over ----------------------->
    
    <div class="trade">
    

        <div class="trade3">
            <h1 style="margin: 0; margin-left: 30px; line-height: 50px;">Result</h1>
        </div>

        <div class="trade4">
        <div class="checkbox">
    </div>

        <table  class="table">
            <tr>
                <th>Select</th>
                <th>Commodity Name</th>
                <th>Seller Name</th>
                <th>Lot Number</th>
                <th>Seller price</th>
                <th>Delivery</th>
                <th>Quality</th>
                <th>Quantity</th>
            </tr>
            <% 
            int i=1;
            while(rs.next()){
            
            
            %>
            <tr>
                <td><input type="checkbox"></td>
                <td><%=rs.getString("p_name") %></td>
                <td><%=rs.getString("s_name") %></td>
                <td><%=rs.getInt("lot_num") %></td>
                <td><%=rs.getInt("p_price") %></td>
                <td><%=rs.getString("p_delivery") %></td>
                <td><%=rs.getString("p_quality") %></td>
                <td><%=rs.getInt("p_quantity") %></td>
            </tr>
            <% 
                i++;
              }
            %>
            <%
            con.close();
            %>
        </table>

        <button class="ofbtn1">Buy Now</button>
        </div>
    </div>


    <footer>
        <div class="foot">
            <a href="#">About Us</a>
            <a href="#">Our Work</a>
        </div>
        <div class="copy">
            <p style="margin: 0;">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Fuga eos neque magni! Eveniet perspiciatis eius quod, ut sequi dignissimos qui aut, sit praesentium ullam libero consequatur facilis ea ipsam recusandae! Lorem ipsum dolor sit amet consectetur adipisicing elit. Sint aut aperiam natus sequi vel deleniti laborum, inventore fuga ipsam, quaerat, repellendus reiciendis harum magnam molestias doloribus optio beatae facere iste!</p>
        </div>
    </footer>


</body>
</html>