package Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.CustomerDAO;
import Model.Customer;

public class TestList {

	public static void main(String[] args) throws SQLException {
		
		CustomerDAO dao = new CustomerDAO();
		List<Customer> customers = dao.getList();
		
		for (Customer customer : customers){
			System.out.println("Name: " + customer.getName());
			System.out.println("Email: " + customer.getEmail());
			System.out.println("Address: " + customer.getAddress());
			System.out.println("Birth date: " +
					customer.getBirth().getTime() + "\n");
		}
	}

}
