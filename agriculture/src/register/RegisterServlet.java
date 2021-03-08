package register;

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
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		// TODO Auto-generated method stub
		 response.setContentType("text/html");
		   PrintWriter out= response.getWriter();
		   System.out.println("registerclass");
	   String firstName = request.getParameter("u_name");
	   String lName = request.getParameter("ul_name");
       String email = request.getParameter("email");
       String userName = request.getParameter("username");
       String password = request.getParameter("password");
       String usertype = request.getParameter("usertype");
       String gender = request.getParameter("gender");
       String phone = request.getParameter("phone");
       String age = request.getParameter("age");
       String state = request.getParameter("state");
       String district = request.getParameter("district");
       String city = request.getParameter("city");
       String pincode = request.getParameter("pincode");
       String license = request.getParameter("license");
       String adhaar = request.getParameter("adhaar");
       String bankname = request.getParameter("bname");
       String accountnum = request.getParameter("accnum");
       String accountname = request.getParameter("accname");
       String ifsc = request.getParameter("ifsc");
       
       Connection con = null;
       PreparedStatement preparedStatement = null;         
       try
       {
           con = dbconnect.createconnection();
           String query = "insert into users(usertype,u_username,u_password,u_name,ul_name,age, u_gender, u_phone, u_email, u_state, u_disitrict, u_city, u_pincode, u_b_name, b_acc_num, u_acc_name, u_ifsc, u_reg_num, u_adhaar) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
           preparedStatement = (PreparedStatement) con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
           preparedStatement.setString(1, usertype);
           preparedStatement.setString(2, userName);
           preparedStatement.setString(3, password);
           preparedStatement.setString(4, firstName);
           preparedStatement.setString(5, lName);
           preparedStatement.setString(6, age);
           preparedStatement.setString(7, gender);
           preparedStatement.setString(8, phone);
           preparedStatement.setString(9, email);
           preparedStatement.setString(10, state);
           preparedStatement.setString(11, district);
           preparedStatement.setString(12, city);
           preparedStatement.setString(13, pincode);
           preparedStatement.setString(14, bankname);
           preparedStatement.setString(15, accountnum);
           preparedStatement.setString(16, accountname);
           preparedStatement.setString(17, ifsc);
           preparedStatement.setString(18, license);
           preparedStatement.setString(19, adhaar);
           
           
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


