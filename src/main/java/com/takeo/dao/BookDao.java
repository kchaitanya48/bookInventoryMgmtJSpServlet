package com.takeo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import com.takeo.model.Book;
import com.takeo.util.DBConnection;

public class BookDao {
	
	
	public void addBook(Book book) {
		PreparedStatement ps=null;
		  Connection con=null;
		try {
		
	     con=DBConnection.getConnection();
	     ps=con.prepareStatement("SELECT MAX(BOOK_ID) FROM bookinventory");
	   ResultSet rs=  ps.executeQuery();
	   int maxId=0;
	   while(rs.next()) {
		   maxId=rs.getInt(1);
	   }
		
       java.sql.Date dob = new java.sql.Date(System.currentTimeMillis()); 
	    
	    
		 ps=	con.prepareStatement("insert into bookinventory(BOOK_ID,BOOK_NAME,BOOK_PRICE,order_date) values"
				+ "(?,?,?,?)");//Insert query
		ps.setInt(1, ++maxId);
		ps.setString(2, book.getBookName());
	
		ps.setDouble(3, book.getPrice());
		ps.setDate(4, dob);
		
		
		ps.execute();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	public List<Book> readBooks() {
		PreparedStatement ps=null;
		  Connection con=null;
		try {
		
	     con=DBConnection.getConnection();
	     ps=con.prepareStatement("SELECT * FROM bookinventory");
	   ResultSet rs=  ps.executeQuery();
	   List<Book> listBook=new ArrayList();
	  while(rs.next()) {
		Book book=new Book(rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getDate(5));
		listBook.add(book);
		
		
	  }
	  return listBook;
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
