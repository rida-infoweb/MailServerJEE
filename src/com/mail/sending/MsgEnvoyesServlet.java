package com.mail.sending;


import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
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

/**
 * Servlet implementation class AjouterEtudiantFormServlet
 */
@WebServlet("/Sent")
public class MsgEnvoyesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MsgEnvoyesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("email");
		IUser serviceUser = new UserDao();
		int id = serviceUser.findUserByEmail(email)	;

		IEmail service = new EmailDao();
		Collection<Email> emails = service.findAll(id);
		request.setAttribute("emails", emails);
		RequestDispatcher rd = request.getRequestDispatcher("MessagesEnvoyes.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
