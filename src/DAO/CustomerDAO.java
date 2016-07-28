package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Factory.ConnectionFactory;
import Model.Customer;

public class CustomerDAO {

	private Connection conn;
	PreparedStatement ps = null;
	
	public CustomerDAO(){
		this.conn = new ConnectionFactory().getConnection();
	}
	
	public void add(Customer customer) throws SQLException{
		String sql = "INSERT INTO customers " + 
					 "(name, email, address, birth)" +
					 "VALUES (?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getEmail());
			ps.setString(3, customer.getAddress());
			ps.setDate(4, new Date(customer.getBirth().getTimeInMillis()));
			
			ps.execute();
		} catch (SQLException e){
			throw new RuntimeException(e);
			
		} finally {
			ps.close();
		}
				
	}
	
	public List<Customer> getList() throws SQLException {
		String sql = "SELECT * FROM customers";
		List<Customer> customers = null;
		ResultSet rs = null;
		Customer customer = null;
		
		try {
			ps = this.conn.prepareStatement(sql);
			customers = new ArrayList<Customer>();
			rs = ps.executeQuery();
			
			while(rs.next()){
				customer = new Customer();
				customer.setId(rs.getLong("id"));
				customer.setName(rs.getString("name"));
				customer.setEmail(rs.getString("email"));
				customer.setAddress(rs.getString("address"));
				
				Calendar date = Calendar.getInstance();
				date.setTime(rs.getDate("birth"));
				customer.setBirth(date);
				
				customers.add(customer);
			}
			
			rs.close();
			return customers;
			
		} catch (SQLException e) {
				throw new RuntimeException(e);
		} finally{
			ps.close();
		}
	}
	
	public Customer getById(int id) throws SQLException {
		String sql = "SELECT * FROM customers WHERE id =?";
		ResultSet rs = null;
		Customer customer = null;
		
		try {
			ps = this.conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()){
				customer = new Customer();
				customer.setId(rs.getLong("id"));
				customer.setName(rs.getString("name"));
				customer.setEmail(rs.getString("email"));
				customer.setAddress(rs.getString("address"));
				Calendar date = Calendar.getInstance();
				date.setTime(rs.getDate("birth"));
				customer.setBirth(date);
			}
			
			rs.close();
			return customer;
			
		} catch (SQLException e) {
				throw new RuntimeException(e);
		} finally{
			ps.close();
		}
	}
	
	public void removeById(int id) throws SQLException {
		String sql = "DELETE FROM customers WHERE id =?";
		
		try {
			ps = this.conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
				throw new RuntimeException(e);
		} finally{
			ps.close();
		}
	}
	
	public void update(Customer customer) {
		String sql = "UPDATE customers set name=?, email=?, address=?," +
					"birth=? WHERE id=?";
		
		try {
			ps = this.conn.prepareStatement(sql);
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getEmail());
			ps.setString(3, customer.getAddress());
			ps.setDate(4, new Date(customer.getBirth().getTimeInMillis()));
			ps.setLong(5, customer.getId());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
				throw new RuntimeException(e);
		}
	}
	
}
