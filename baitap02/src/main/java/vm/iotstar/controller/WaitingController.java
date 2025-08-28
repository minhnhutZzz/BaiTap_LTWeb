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
@WebServlet(urlPatterns="/waiting")
public class WaitingController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();  // Lấy session hiện tại

        // Kiểm tra nếu session có giá trị "account" (người dùng đã đăng nhập)
        if (session != null && session.getAttribute("account") != null) {
            User u = (User) session.getAttribute("account");  // Lấy thông tin người dùng từ session
            req.setAttribute("username", u.getUserName());  // Gửi tên người dùng đến view

            // Kiểm tra vai trò của người dùng và chuyển hướng đến trang tương ứng
            if (u.getRoleid() == 1) {  // Nếu là admin
                resp.sendRedirect(req.getContextPath() + "/admin/home");
            } else if (u.getRoleid() == 2) {  // Nếu là manager
                resp.sendRedirect(req.getContextPath() + "/manager/home");
            } else {  // Nếu là người dùng bình thường
                resp.sendRedirect(req.getContextPath() + "/home");
            }
        } else {  // Nếu không có session hoặc người dùng chưa đăng nhập
            resp.sendRedirect(req.getContextPath() + "/login");  // Chuyển hướng về trang đăng nhập
        }
    }
}
