package service;

import util.User;

public interface UserService {
	 User login(String username, String password);
	 User get(String username);

}
