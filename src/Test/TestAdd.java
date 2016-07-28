package Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

import DAO.CustomerDAO;
import Factory.ConnectionFactory;
import Model.Customer;

public class TestAdd {

	public static void main(String[] args) throws SQLException {
		Customer customer = new Customer();
		
		//set customer
		customer.setName("James White");
		customer.setEmail("jamwhite@yahoo.com");
		customer.setAddress("Oxford St, 556");
		customer.setBirth(Calendar.getInstance());
		
		//create dao and add
		CustomerDAO dao = new CustomerDAO();
		dao.add(customer);
		
		System.out.println("Saved!");
	}
	
}
