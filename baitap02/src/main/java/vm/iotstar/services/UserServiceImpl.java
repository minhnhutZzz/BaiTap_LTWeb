package vm.iotstar.services;

import vm.iotstar.User;
import vm.iotstar.Dao.UserDao;

public class UserServiceImpl implements UserService {
    private UserDao userDao;  

    // Constructor Injection
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User login(String username, String password) {
        // Kiểm tra đăng nhập
        return userDao.getByUsernameAndPassword(username, password); 
    }

    @Override
    public User get(String username) {
        // Lấy thông tin user
        return userDao.getByUsername(username);
    }

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
			
	}
}
