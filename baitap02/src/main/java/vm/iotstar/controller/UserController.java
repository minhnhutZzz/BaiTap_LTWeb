package vm.iotstar.controller;

import vm.iotstar.services.UserServiceImpl;
import vm.iotstar.services.UserService;
import vm.iotstar.User;

public class UserController {
    private UserService userService = new UserServiceImpl(null); // Khởi tạo service

    // Đăng nhập người dùng
    public User login(String username, String password) {
        try {
            User user = userService.login(username, password);
            if (user != null) {
                return user;  // Trả về user khi đăng nhập thành công
            } else {
                // Nếu đăng nhập thất bại
                System.out.println("Invalid username or password.");
                return null;
            }
        } catch (Exception e) {
            // Xử lý lỗi đăng nhập
            System.out.println("Error during login process: " + e.getMessage());
            return null;
        }
    }

    // Lấy thông tin người dùng
    public User get(String username) {
        try {
            User user = userService.get(username);
            if (user != null) {
                return user;  // Trả về thông tin người dùng
            } else {
                // Nếu không tìm thấy user
                System.out.println("User not found.");
                return null;
            }
        } catch (Exception e) {
            // Xử lý lỗi lấy thông tin người dùng
            System.out.println("Error retrieving user information: " + e.getMessage());
            return null;
        }
    }
}
