package vm.iotstar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vm.iotstar.User;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {

    public UserService userService = new UserServiceImpl(); // Khởi tạo service để gọi logic đăng nhập

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        // Nếu đã đăng nhập rồi, chuyển hướng đến trang waiting
        if (session != null && session.getAttribute("account") != null) {
            resp.sendRedirect(req.getContextPath() + "/waiting");
            return;
        }

        // Kiểm tra cookie nếu có
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    // Tạo session và set username vào session
                    session = req.getSession(true);
                    session.setAttribute("username", cookie.getValue());
                    resp.sendRedirect(req.getContextPath() + "/waiting");
                    return;
                }
            }
        }

        // Nếu không có session và cookie, chuyển tới trang login
        req.getRequestDispatcher("views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Kiểm tra thông tin đăng nhập
        User user = userService.login(username, password);

        if (user != null) {
            // Đăng nhập thành công, lưu thông tin vào session
            HttpSession session = req.getSession(true);
            session.setAttribute("account", user);

            // Nếu người dùng chọn nhớ đăng nhập, lưu username vào cookie
            String rememberMe = req.getParameter("rememberMe");
            if (rememberMe != null && rememberMe.equals("on")) {
                Cookie usernameCookie = new Cookie("username", username);
                usernameCookie.setMaxAge(60 * 60 * 24 * 30); // Lưu cookie trong 30 ngày
                resp.addCookie(usernameCookie);
            }

            // Chuyển hướng đến trang waiting
            resp.sendRedirect(req.getContextPath() + "/waiting");
        } else {
            // Đăng nhập thất bại, quay lại trang login với thông báo lỗi
            req.setAttribute("error", "Invalid username or password.");
            req.getRequestDispatcher("views/login.jsp").forward(req, resp);
        }
    }
}

