package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.dbconnect;

/**
 * Servlet implementation class Log
 */
public class Log extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Log() {
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
	    System.out.println("executed class");
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String username = request.getParameter("username");
		   String password = request.getParameter("password");
		   String usertype = request.getParameter("usertype");
		 
		   Connection con = null;
	         
		   try {
//			   Connection con = null;
			   con = dbconnect.createconnection();
			   Statement stm=con.createStatement();
			   ResultSet rs= stm.executeQuery("select * from users where u_username='"+username+"' and u_password='"+password+"' and usertype='"+usertype+"'  ");
			   if(rs.next()) {
				 
				   
				   
			    	System.out.println("Loggedin");
			    	response.sendRedirect("home.html");
			    	
			    	
			    }else {
			    	out.println("wrong user name and password");
			    	
			    }
		        // now we will get data from Login page using query
			    con.close();

	          }catch(Exception e) {
		         System.out.println(e.getMessage());

              }
     }//end class
}
