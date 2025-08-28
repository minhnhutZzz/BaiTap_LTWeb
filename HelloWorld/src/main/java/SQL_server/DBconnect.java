package SQL_server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBconnect {
	private final String serverName = "MINH_NHUT\\MINH_NHUT";
	private final String dbName = "LTWebst6";
	private final String portNumber = "1433";
	private final String instance = "";
	private final String userID = "sa";
	private final String password = "123456";

	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + "\\" + instance + ":" + portNumber + ";databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
	}

	public static void main(String[] args) {
		try {
			
			 // connnect to database 'testdb'
			 Connection conn = new DBconnect().getConnection();
			 // crate statement
			 Statement stmt = conn.createStatement();
			 // insert ‘GiaoVien'
			 stmt.executeUpdate("INSERT INTO User(id, username, email) VALUES (1, ‘Trung', ‘HCM')");
			 // get data from table ‘GiaoVien'
			 ResultSet rs = stmt.executeQuery("SELECT * FROM GiaoVien");
			 // show data
			 while (rs.next()) {
			 System.out.println(rs.getInt("id") + " " + rs.getString("username") 
			+ " " + rs.getString("email"));
			 }
			 conn.close(); // close connection
			 } catch (Exception ex) {
			 ex.printStackTrace();
		
		}
	}

}
