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


@WebServlet("/edit_form")
public class edit_form extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		
		try {
			//for student list
			String name = request.getParameter("name");
			String nrc = request.getParameter("nrc");
			String dob = request.getParameter("dob");
			String phone = request.getParameter("phone");
			String gender = request.getParameter("gender");
			String nation = request.getParameter("nation");
			String address = request.getParameter("address");
			int Student_id = Integer.parseInt(request.getParameter("id"));
			
			int row_count = Integer.parseInt(request.getParameter("row_count"));
			
			con = DB.createConnection();
			ps = con.prepareStatement("UPDATE `students`.`student` SET `name` = ?, `nrc` = ?, `dob` = ?, `phone` = ?, `gender` = ?, `nationality` = ?, `address` = ? WHERE (`student_id` = ?);");
			
			ps.setString(1, name);
			ps.setString(2, nrc);
			ps.setString(3, dob);
			ps.setString(4, phone);
			ps.setString(5, gender);
			ps.setString(6, nation);
			ps.setString(7, address);
			ps.setInt(8, Student_id);
			
			ps.executeUpdate();
			
			
			// for student detail
			
			
			
			
			ps1 = con.prepareStatement("INSERT INTO `students`.`student_detail` (`year`, `mark1`, `mark2`, `mark3`, `remark`, `student_id`) VALUES (?,?,?,?,?,?);");
			ps2 = con.prepareStatement("DELETE FROM `students`.`student_detail` WHERE (`student_id` = ?);");
			
			ps2.setInt(1,Student_id);
			ps2.executeUpdate();
			
			
			
			for (int i = 0; i <= row_count; i++) {
				String year1 = request.getParameter("year" + i);
				String mark11 = request.getParameter("mark1" + i);
				String mark21 = request.getParameter("mark2" + i);
				String mark31 = request.getParameter("mark3" + i);
				String remark1 = request.getParameter("remark" + i);

				// System.out.println(year + " " + mark1 + " " + mark2 + " " + mark3 + " " +
				// remark);

				if (!(year1 == null)) {
					ps1.setString(1, year1);
					ps1.setString(2, mark11);
					ps1.setString(3, mark21);
					ps1.setString(4, mark31);
					ps1.setString(5, remark1);
					ps1.setInt(6, Student_id);

					ps1.executeUpdate();
				}

			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Student_list");
			dispatcher.forward(request, response);
			
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

}
