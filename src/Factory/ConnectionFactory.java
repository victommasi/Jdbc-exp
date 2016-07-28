package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection(){
		
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/jdbctest", 
											   "root", "123456");
		} catch(SQLException se){
			throw new RuntimeException(se);
		}
		
	}
}
