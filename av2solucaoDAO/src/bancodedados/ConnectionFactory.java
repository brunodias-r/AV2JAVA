package bancodedados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() throws SQLException{
		String url="jdbc:mysql://localhost/av2db";
		String user = "root";
		String password = "";
		return DriverManager.getConnection(url, user, password);

	}
}
