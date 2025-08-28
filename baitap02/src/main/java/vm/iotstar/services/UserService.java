package vm.iotstar.services;

import vm.iotstar.User;

public interface UserService {
	 User login(String username, String password);
	    User get(String username);
	    void addUser(User user); 

}
