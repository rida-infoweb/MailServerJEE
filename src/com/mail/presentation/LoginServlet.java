package com.mail.presentation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mail.dao.UserDao;
import com.mail.entities.User;
import com.mail.metier.IUser;
import com.mail.sha6.SHA6Encryption;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password =request.getParameter("password");
	
			IUser service = new UserDao();
			    User user = service.logUser(email, SHA6Encryption.getSHA6(password));
	             
	            if (user != null) {
	            	HttpSession session = request.getSession();
	    			session.setAttribute("user", user);
	    			session.setMaxInactiveInterval(30*60);
	    			Cookie userName = new Cookie("user", email);
	    			userName.setMaxAge(30*60);
	    			response.addCookie(userName);
//	    		
	    			response.sendRedirect("emailForm");
	            } else {

					PrintWriter out = response.getWriter() ;
					out.println("<script type=\"text/javascript\">");
		            out.println("alert('Les identifiants sont invalides !');");
		            out.println("window.location.href = \"loginForm\";");
		            out.println("</script>");	
	            }
	             
		}

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}