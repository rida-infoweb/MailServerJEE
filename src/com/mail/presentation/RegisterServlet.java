package com.mail.presentation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
import com.mail.sha6.SHA6Encryption;
import com.mail.ssh.SshCommand;

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
	
			User user = new User(name,email,SHA6Encryption.getSHA6(password));
			
			IUser service = new UserDao();
			if (service.saveUser(user,email)==true) {
			service.saveUser(user,email);
			PrintWriter out = response.getWriter() ;
			out.println("<script type=\"text/javascript\">");
            out.println("alert('Ce compte est créé avec succès !');");
            out.println("window.location.href = \"loginForm\";");
            out.println("</script>");
           

            SshCommand.CreationCompteLinux(email.split("@")[0],password);
			}
			else {
				PrintWriter out = response.getWriter() ;
				out.println("<script type=\"text/javascript\">");
	            out.println("alert('Ce compte existe déjà !');");
	            out.println("window.location.href = \"registerForm\";");
	            out.println("</script>");	
			}
		}
	
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}