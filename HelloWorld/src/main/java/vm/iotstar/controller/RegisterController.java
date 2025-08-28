package vm.iotstar.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");

        // Kiểm tra nếu tài khoản đã tồn tại
        if (userService.get(username) != null) {
            req.setAttribute("error", "Tài khoản đã tồn tại");
            req.getRequestDispatcher("views/register.jsp").forward(req, resp);
            return;
        }

        // Đăng ký người dùng mới
        User newUser = new User(username, email, fullName, password);
        userService.addUser(newUser);

        // Chuyển hướng đến trang đăng nhập sau khi đăng ký thành công
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
