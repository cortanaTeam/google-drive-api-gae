package com.infamous.fdsa.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infamous.fdsa.bean.News;
import com.infamous.fdsa.model.news.NewsModel;

public class ViewNewsByIdController  extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NewsModel model = new NewsModel();
		String id =null;
		try {
			id = req.getParameter("id");
			News news = model.findNewsById(id);
			req.setAttribute("model", news);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		req.getRequestDispatcher("view.jsp?id="+id).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
