package Test;

import java.sql.SQLException;
import java.util.Scanner;

import DAO.CustomerDAO;
import Model.Customer;

public class TestRemove {
	static Integer id = null;

	public static void main(String[] args) throws SQLException {
		CustomerDAO dao = new CustomerDAO();
		Scanner in = new Scanner(System.in);
		System.out.println("Type id: ");
		id = in.nextInt();
		
		dao.removeById(id);
	}

}
