package ua.homework.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.homework.domain.User;
import ua.homework.domain.UserRole;
import ua.homework.service.UserService;
import ua.homework.sevice.impl.UserServiceImpl;


public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getUserService();
	     
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("laststName");
		String password = request.getParameter("password");
		
		if(!email.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty() && !password.isEmpty()) {
			userService.create(new User(email,firstName, lastName, UserRole.USER.toString(), password));
		}
		
		//request.getRequestDispatcher("account.jsp").forward(request, response);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
