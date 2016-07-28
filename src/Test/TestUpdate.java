package Test;

import java.util.Calendar;
import java.util.Scanner;

import DAO.CustomerDAO;
import Model.Customer;

public class TestUpdate {
	
	static Long id = null;

	public static void main(String[] args) {
		Customer customer = new Customer();
		Scanner in = new Scanner(System.in);
		System.out.println("Type id: ");
		id = in.nextLong();
		
		//set customer
		customer.setName("James Black");
		customer.setEmail("jamblack@yahoo.com");
		customer.setAddress("Oxford St, 655");
		customer.setBirth(Calendar.getInstance());
		customer.setId(id);
		System.out.println("Customer Updated!");
		
		CustomerDAO dao = new CustomerDAO();
		dao.update(customer);
		
	}

}
