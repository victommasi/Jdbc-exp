package Test;

import java.sql.Connection;
import java.sql.SQLException;

import Factory.ConnectionFactory;

public class TestConnection {

	public static void main(String[] args) throws SQLException {

		Connection conn = null; 
		
			conn = new ConnectionFactory().getConnection();
			System.out.println("Connection Opened");
			conn.close();
	}

}
