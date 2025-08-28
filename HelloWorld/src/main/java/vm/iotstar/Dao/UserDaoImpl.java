package vm.iotstar.Dao;

import vm.iotstar.User;
import java.sql.*;

public class UserDaoImpl implements UserDao {

    // Kết nối tới cơ sở dữ liệu
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=YourDB";
    private static final String USER = "your_db_user";
    private static final String PASSWORD = "your_db_password";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public User getByUsername(String username) {
        String query = "SELECT * FROM Users WHERE userName = ?";
        try (Connection connection = connect();
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
        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
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
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}
}
