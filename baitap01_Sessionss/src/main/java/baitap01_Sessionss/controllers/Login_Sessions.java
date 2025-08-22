package baitap01_Sessionss.controllers;

import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet; 
import jakarta.servlet.http.HttpServlet; 
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse; 
import jakarta.servlet.http.HttpSession;

import java.io.IOException; 
import java.io.PrintWriter;

import jakarta.servlet.http.Cookie;
@WebServlet(urlPatterns= {"/login"})

public class Login_Sessions extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	/** 
	 *  @see HttpServlet#HttpServlet() 
	 */
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (username.equals("minhnhut")&& password.equals("123456")) {
			out.print("Chào mừng bạn, " + username);
			HttpSession session = req.getSession();
			session.setAttribute("name", username);
		} else {
			out.print("Tài khoản hoặc mật khẩu không chính xác");
			req.getRequestDispatcher("Login.html").include(req,
					resp);
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().println("<form method='post' action='login'>"
				+ "User: <input type='text' name='username'/><br/>"
				+ "Pass: <input type='password' name='password'/><br/>"
				+ "<input type='submit' value='Login'/>"
				+ "</form>");
	}

}
