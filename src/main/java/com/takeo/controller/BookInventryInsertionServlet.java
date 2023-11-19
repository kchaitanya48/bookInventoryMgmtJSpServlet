package com.takeo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.takeo.model.Book;
import com.takeo.service.BookService;

public class BookInventryInsertionServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	String bName=	req.getParameter("bName");
	String price=	req.getParameter("price");
	System.out.println("bnameee " +bName);
	System.out.println("price " +price);
	
BookService bookService=new BookService();
Book book=new Book(bName, null, Double.parseDouble(price),null);

bookService.addBook(book);
RequestDispatcher rd= req.getRequestDispatcher("/bookInventory.jsp");

req.setAttribute("insertRes", "success");
rd.forward(req, resp);

		
		
	}

}
