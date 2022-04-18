package com.mail.sending;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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


		try {
			EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
					content);
			PrintWriter out = response.getWriter() ;
			out.println("<script type=\"text/javascript\">");
            out.println("alert('Email envoyé avec succès !');");
            out.println("window.location.href = \"MsgEnvoyesServlet\";");
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