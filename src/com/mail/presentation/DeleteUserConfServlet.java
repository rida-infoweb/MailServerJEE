package com.mail.presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mail.dao.UserDao;
import com.mail.metier.IUser;
import com.mail.ssh.SshCommand;

/**
 * Servlet implementation class DeleteUserConfServlet
 */
@WebServlet("/DeleteUserConfServlet")
public class DeleteUserConfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserConfServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();

		String email=(String)session.getAttribute("email");

		int id = Integer.parseInt(request.getParameter("id"));
		
		IUser service = new UserDao();
		
        SshCommand.SuppressionCompteLinux(service.findOne(id).getEmail().split("@")[0]);

		service.delete(id);
		
		response.sendRedirect("ListUserServlet");	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
