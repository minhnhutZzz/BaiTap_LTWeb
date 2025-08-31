package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.User;

import java.io.IOException;

@WebServlet(urlPatterns = "/waiting")  // Đảm bảo rằng chỉ cần khai báo @WebServlet một lần cho lớp
public class WaitingController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(); // Lấy session hiện tại
        if (session != null && session.getAttribute("account") != null) { // Kiểm tra xem session có tồn tại và có account không
            User u = (User) session.getAttribute("account"); // Lấy thông tin người dùng từ session
            req.setAttribute("username", u.getUserName()); // Đặt tên người dùng vào request để hiển thị

            // Điều hướng người dùng dựa trên vai trò của họ
            if (u.getRoleid() == 1) {
                resp.sendRedirect(req.getContextPath() + "/admin/home"); // Điều hướng admin
            } else if (u.getRoleid() == 2) {
                resp.sendRedirect(req.getContextPath() + "/manager/home"); // Điều hướng manager
            } else {
                resp.sendRedirect(req.getContextPath() + "/home"); // Điều hướng người dùng thông thường
            }
        } else {
            resp.sendRedirect(req.getContextPath() + "/login"); // Nếu không có session hoặc không có account, chuyển hướng về trang login
        }
    }
}
