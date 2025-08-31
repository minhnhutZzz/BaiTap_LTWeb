package service.impl;

import service.UserService;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import util.User;

public class UserServiceImpl implements UserService {
    // Sử dụng UserDao
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        // Lấy thông tin người dùng từ cơ sở dữ liệu
        User user = this.get(username);
        if (user != null && password.equals(user.getPassWord())) {  // So sánh mật khẩu (có thể mã hóa mật khẩu trước)
            return user;
        }
        return null;  // Nếu không tìm thấy người dùng hoặc mật khẩu sai
    }

    @Override
    public User get(String username) {
        return userDao.get(username);  // Lấy người dùng từ UserDao
    }
}
