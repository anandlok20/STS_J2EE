/**
 * 
 */
package utils;

import java.sql.*;

/**
 * @author Anand Lok
 *
 */
public class DbUtils {
	public static Connection fetchConnection() throws Exception {
		String url = "jdbc:mysql://localhost:3306/test";
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(url, "root", "root");
	}
}