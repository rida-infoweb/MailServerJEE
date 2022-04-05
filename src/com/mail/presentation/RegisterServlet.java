package com.mail.presentation;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mail.dao.UserDao;
import com.mail.entities.User;
import com.mail.metier.IUser;

/**
 *
 * @author almam
 */
@WebServlet("/register")

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password =request.getParameter("password");
	
			User user = new User(name,email,password);
			
			IUser service = new UserDao();
			response.sendRedirect("emailForm");
			service.saveUser(user);
		}
	
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}