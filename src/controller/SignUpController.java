package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
//import java.time.LocalDate;
//import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.ConnectionManager;



@WebServlet(urlPatterns= {"/signup"})
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SignUpController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Sign up Controller");
		// Fill your code here
		//create an object for the Connection
		Connection con = null;
		 try {
			con = ConnectionManager.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		 //Display in the console "Connection established",if the connection is not equal to null
		 //else display "Check your connection" in the console.
			if(con!=null)
			 System.out.println(" Connection established");
			else
			 System.out.println("Check your connection");
		
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request,response);
		
	}

}
