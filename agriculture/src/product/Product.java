package product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

import connection.dbconnect;

/**
 * Servlet implementation class Product
 */
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		   PrintWriter out= response.getWriter();
		   
	
		String username = "ht123";
		String name = "hitesh";   
	   String commodity = request.getParameter("commodity");
	   String quality = request.getParameter("quality");
       int quantity = Integer.parseInt(request.getParameter("quantity"));
       int price = Integer.parseInt(request.getParameter("price"));
       int lotnum = 0;
       String time = request.getParameter("time");
       String state = request.getParameter("state");
       String district = request.getParameter("district");
       String city = request.getParameter("city");
       String status = "unsold";
       Connection con = null;
       PreparedStatement preparedStatement = null;         
       try
       {
           con = dbconnect.createconnection();
           String query ="INSERT INTO `stock`(`p_name`, `s_id`, `s_name`, `lot_num`, `p_quantity`, `p_quality`, `p_price`, `p_delivery`, `state`, `district`, `city`, `status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
           preparedStatement = (PreparedStatement) con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
           preparedStatement.setString(1, commodity);
           preparedStatement.setString(2, username);
           preparedStatement.setString(3, name);
           preparedStatement.setInt(4, lotnum);
           preparedStatement.setInt(5, quantity);
           preparedStatement.setString(6, quality);
           preparedStatement.setInt(7, price);
           preparedStatement.setString(8, time);
           preparedStatement.setString(9, state);
           preparedStatement.setString(10, district);
           preparedStatement.setString(11, city);
           preparedStatement.setString(12, status);
           
           int i= preparedStatement.executeUpdate();
           
           if (i!=0) {
          	 response.sendRedirect("home.html"); }
           else {
          	 out.println("please retry");
          	 
           }
       }
          	 //Just to ensure data has been inserted into the database
       catch(SQLException e)
       {
          e.printStackTrace();
       }       
        // On failure, send a message from here.
   }
           
	}


