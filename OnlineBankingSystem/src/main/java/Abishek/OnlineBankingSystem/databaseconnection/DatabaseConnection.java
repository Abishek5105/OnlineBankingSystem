/***
@author Abishek M 
*/
package Abishek.OnlineBankingSystem.databaseconnection;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	
	public static Connection provideConnection() {
		Connection conn =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/bankingsystem";
		
		try {
			conn = DriverManager.getConnection(url, "root","5105");
		}
		catch(Exception e){
			
			System.out.println("Exception occur in Database");
		}
		return conn;
	}

}
