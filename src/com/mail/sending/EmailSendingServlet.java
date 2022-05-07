package com.mail.sending;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mail.dao.EmailDao;
import com.mail.dao.UserDao;
import com.mail.entities.Email;
import com.mail.metier.IEmail;
import com.mail.metier.IUser;
import com.mail.sha6.SHA6Encryption;

import java.util.Date;
/**
 * A servlet that takes message details from user and send it as a new e-mail
 * through an SMTP server.
 * 
 * @author www.codejava.net
 * 
 */
@WebServlet("/EmailSendingServlet")
public class EmailSendingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String host ="192.168.56.128";
	private String port="25";
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// reads form fields
		HttpSession session=request.getSession();
		String user=(String)session.getAttribute("email");
		String pass=(String)session.getAttribute("password");
		
		String recipient = request.getParameter("recipient");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

		Date createdAt= new Date();
		IUser serviceUser = new UserDao();
		int id = serviceUser.findUserByEmail(user)	;
		 String uuid=Double.toString(Math.random());

	

		try {
			EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
					content);
			//Email email = new Email(user,recipient,content,subject,createdAt);
			Email email = new Email(uuid,id, user, recipient, content, subject, createdAt);

			IEmail service = new EmailDao();
			
			service.add(email);
			
			PrintWriter out = response.getWriter() ;
			out.println("<script type=\"text/javascript\">");
            out.println("alert('Email envoyé avec succès !');");
            out.println("window.location.href = \"Sent\";");
            out.println("</script>");		
            } catch (Exception ex) {
			ex.printStackTrace();
			PrintWriter out = response.getWriter() ;
			out.println("<script type=\"text/javascript\">");
            out.println("alert('Email non envoyé !');");
            out.println("window.location.href = \"emailForm\";");
            out.println("</script>");		} 
	
	}
}