package com.sunbeam;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDao implements AutoCloseable{
	private Connection con;
	
	public CustomerDao() throws Exception{
		con = DbUtil.getConnection();
		
	}
	
	@Override
	public void close() throws Exception {
		if(con != null)
			con.close();
	}
	
	public int add(Customer c) throws Exception{
		//create statement
		String sql = "INSERT INTO customers(id, name, mobile, address, email, birth) VALUES(?, ?, ?, ?, ?, ?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			//execute query and process result
			stmt.setInt(1, c.getId());
			stmt.setString(2, c.getName());
			stmt.setString(3, c.getMobile());
			stmt.setString(4,  c.getAddress());
			stmt.setString(5, c.getEmail());
			stmt.setDate(6, c.getBirth());
			
			int count = stmt.executeUpdate();
			return count;
	
		}	
	}
	
	public Customer findByEmail(String custemail) throws Exception{
		String sql = "SELECT * FROM customers WHERE email = ?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			//execute query and process result
			stmt.setString(1,  custemail);
			try(ResultSet rs = stmt.executeQuery()){
				if(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String mobile = rs.getString("mobile");
					String address = rs.getString("address");
					String email = rs.getString("email");
					Date birth = rs.getDate("birth");
					String password = rs.getString("password");
					
					Customer c = new Customer(id, name, mobile, address, email, birth, password);
					return c;	
				}
			}
			
		}
		return null;
		
	}
	
	public Customer findByEmailPass(String custemail, String custpassword) throws Exception{
		String sql = "SELECT * FROM customers WHERE email = ? and password = ?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1,  custemail);
			stmt.setString(2, custpassword);
			try(ResultSet rs = stmt.executeQuery()){
				if(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String mobile = rs.getString("mobile");
					String address = rs.getString("address");
					String email = rs.getString("email");
					Date birth = rs.getDate("birth");
					String password = rs.getString("password");
					
					Customer c = new Customer(id, name, mobile, address, email, birth, password);
					return c;	
					
				}
			}
			
		}
		return null;
		
	}
	
	public int change(String custemail, String custpassword)throws Exception{
		String sql = "UPDATE customers SET password = ? WHERE email = ?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, custpassword);
			stmt.setString(2, custemail);
			int count = stmt.executeUpdate();
			return count;
				}
	}
	
	public int update(Customer c) throws Exception{
		String sql = "UPDATE customers SET  name = ?, password = ?, mobile = ?, address = ?, email = ?, birth = ? WHERE id = ?";
		
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			
			stmt.setString(1,  c.getName());
			stmt.setString(2,  c.getPassword());
			stmt.setString(3,  c.getMobile());
			stmt.setString(4,  c.getAddress());
			stmt.setString(5,  c.getEmail());
			stmt.setDate(6, c.getBirth());
			stmt.setInt(7, c.getId());
			int count = stmt.executeUpdate();
			return count;
			
			
		}
	}
	
	public int deleteById(int custId) throws Exception{
		String sql = "DELETE FROM customers WHERE id = ?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, custId);
			int count = stmt.executeUpdate();
			return count;
			
		}
	}
}
	 


