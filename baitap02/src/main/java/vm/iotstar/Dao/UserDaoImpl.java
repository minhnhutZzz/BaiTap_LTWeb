package vm.iotstar.Dao;

import vm.iotstar.User;
import SQL_server.DBconnect; // Import lớp DBconnect
import java.sql.*;

public class UserDaoImpl implements UserDao {

    private DBconnect dbConnect = new DBconnect();  // Khởi tạo đối tượng DBconnect

    private Connection connect() throws SQLException {
        try {
            // Lấy kết nối từ DBconnect
            return dbConnect.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Failed to establish connection with the database.");
        }
    }

    @Override
    public User getByUsername(String username) {
        String query = "SELECT * FROM Users WHERE userName = ?";
        try (Connection connection = connect();  // Sử dụng kết nối từ DBconnect
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                    rs.getInt("id"),
                    rs.getString("email"),
                    rs.getString("userName"),
                    rs.getString("fullName"),
                    rs.getString("password"),
                    rs.getString("avatar"),
                    rs.getInt("roleid"),
                    rs.getString("phone"),
                    rs.getDate("createdDate")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getByUsernameAndPassword(String username, String password) {
        String query = "SELECT * FROM Users WHERE userName = ? AND password = ?";
        try (Connection connection = connect();  // Sử dụng kết nối từ DBconnect
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                    rs.getInt("id"),
                    rs.getString("userName"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getString("fullName"),
                    rs.getString("avatar"),
                    rs.getInt("roleid"),
                    rs.getString("phone"),
                    rs.getDate("createdDate")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        // TODO: Implement addUser
    }

    @Override
    public void updateUser(User user) {
        // TODO: Implement updateUser
    }
}
