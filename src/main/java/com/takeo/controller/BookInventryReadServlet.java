package com.takeo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.takeo.model.Book;
import com.takeo.service.BookService;

public class BookInventryReadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookService bookService=new BookService();
		List<Book> books=bookService.readBooks();
		RequestDispatcher rd= req.getRequestDispatcher("/readBooks.jsp");

		req.setAttribute("books", books);
		rd.forward(req, resp);
	}

}
