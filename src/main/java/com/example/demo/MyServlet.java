package com.example.demo;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String name = req.getParameter("name");
	    resp.setContentType("text/html");
	    if (name != null) {
	        resp.getWriter().write("Hello, " + name + "!");
	    } else {
	        resp.getWriter().write("Hello, World!");
	    }
	}

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write("Hello, this is my Servlet response to a POST request!");
    }

}
