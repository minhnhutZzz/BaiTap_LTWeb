package vm.iotstar.Dao;

import vm.iotstar.User;

public interface UserDao {
    User getByUsername(String username);
    User getByUsernameAndPassword(String username, String password);
    void addUser(User user);
    void updateUser(User user);
}
