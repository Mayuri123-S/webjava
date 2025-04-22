package com.sunbeam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookDao implements AutoCloseable{
	private Connection con;
	
	public BookDao() throws Exception{
		con = DbUtil.getConnection();
		
	}
	
	
	public void close() throws Exception{
		if(con != null)
			con.close();	
	}
	
	public List<Book> findAll() throws Exception{
		List<Book> list = new ArrayList<Book>();
		
		//Create Statement
		String sql = "SELECT * FROM books";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			
			//execute query and process result
			try(ResultSet rs = stmt.executeQuery()){
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String author = rs.getString("author");
					String subject = rs.getString("subject");
					double price = rs.getDouble("price");
				
					Book b = new Book(id, name, author, subject, price);
					list.add(b);
					
				}
			}
		}
		return list;
		
	}
	
	public Book findById(int bookId) throws Exception {
		// create statement
		String sql = "SELECT * FROM books WHERE id = ?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			// execute query and process result
			stmt.setInt(1, bookId);
			try(ResultSet rs = stmt.executeQuery()) {
				if(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String author = rs.getString("author");
					String subject = rs.getString("subject");
					double price = rs.getDouble("price");
					Book b = new Book(id, name, author, subject, price);
					return b;
				}
			} // rs.close();
		} // stmt.close();
		return null;
	}
	
	public int save(Book b) throws Exception {
		// create statement
		String sql = "INSERT INTO books VALUES (?, ?, ?, ?, ?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			// execute query & process result
			stmt.setInt(1, b.getId());
			stmt.setString(2, b.getName());
			stmt.setString(3, b.getAuthor());
			stmt.setString(4, b.getSubject());
			stmt.setDouble(5, b.getPrice());
			int count = stmt.executeUpdate();
			return count;
		} // stmt.close();
	}
	
	public int update(Book b) throws Exception {
		// create statement
		String sql = "UPDATE books SET name = ?, author = ?, subject = ?, price = ? WHERE id = ?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			// execute query & process result
			stmt.setString(1, b.getName());
			stmt.setString(2, b.getAuthor());
			stmt.setString(3, b.getSubject());
			stmt.setDouble(4, b.getPrice());
			stmt.setInt(5, b.getId());
			int count = stmt.executeUpdate();
			return count;
		}
	}
	
	public int deleteById(int bookId) throws Exception {
		// create statement
		String sql = "DELETE FROM books WHERE id = ?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			// execute query & process result
			stmt.setInt(1, bookId);
			int count = stmt.executeUpdate();
			return count;
		} // stmt.close();
	}
}
