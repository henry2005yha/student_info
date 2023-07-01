package com.student.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.util.DB;


@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			con = DB.createConnection();
			ps = con.prepareStatement("DELETE FROM `students`.`student` WHERE (`student_id` = ?);");
			ps.setInt(1, id);
			
			ps.executeUpdate();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Student_list");
			dispatcher.forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
