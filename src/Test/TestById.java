package Test;

import java.sql.SQLException;
import java.util.Scanner;

import DAO.CustomerDAO;
import Model.Customer;

public class TestById {
	static Integer id = null;

	public static void main(String[] args) throws SQLException {
		
		CustomerDAO dao = new CustomerDAO();
		Scanner in = new Scanner(System.in);
		System.out.println("Type id: ");
		id = in.nextInt();
		
		Customer customer = dao.getById(id);
		
		System.out.println("Name: " + customer.getName());
		System.out.println("Email: " + customer.getEmail());
		System.out.println("Address: " + customer.getAddress());
		System.out.println("Birth date: " +
				customer.getBirth().getTime() + "\n");
		
	}

}
