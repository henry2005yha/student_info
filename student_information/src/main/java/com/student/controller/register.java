package com.student.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.student.bean.Student;
import com.student.util.DB;

@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		int id = 0;

		try {
			String name = request.getParameter("name");
			String nrc = request.getParameter("nrc");
			String dob = request.getParameter("dob");
			String phone = request.getParameter("phone");
			String gender = request.getParameter("gender");
			String nation = request.getParameter("nation");
			String address = request.getParameter("address");
			int row_count = Integer.parseInt(request.getParameter("row_count"));

			con = DB.createConnection();
			ps1 = con.prepareStatement(
					"INSERT INTO `students`.`student_detail` (`year`, `mark1`, `mark2`, `mark3`, `remark`, `student_id`) VALUES (?,?,?,?,?,?);");
			ps2 = con.prepareStatement("SELECT student_id FROM students.student where name=?;");
			ps = con.prepareStatement(
					"INSERT INTO `students`.`student` (`name`, `nrc`, `dob`, `phone`, `gender`, `nationality`, `address`) VALUES (?, ?, ?, ?, ?, ?, ?);");

			ps.setString(1, name);
			ps.setString(2, nrc);
			ps.setString(3, dob);
			ps.setString(4, phone);
			ps.setString(5, gender);
			ps.setString(6, nation);
			ps.setString(7, address);

			ps.executeUpdate();

			ps2.setString(1, name);

			ResultSet rs = ps2.executeQuery();
			while (rs.next()) {
				id = rs.getInt("student_id");
			}

			String year = request.getParameter("year");
			int mark1 = Integer.parseInt(request.getParameter("mark1"));
			int mark2 = Integer.parseInt(request.getParameter("mark2"));
			int mark3 = Integer.parseInt(request.getParameter("mark3"));
			String remark = request.getParameter("remark");

			// System.out.println(year + " " + mark1 + " " + mark2 + " " + mark3 + " " +
			// remark);

			ps1.setString(1, year);
			ps1.setInt(2, mark1);
			ps1.setInt(3, mark2);
			ps1.setInt(4, mark3);
			ps1.setString(5, remark);
			ps1.setInt(6, id);

			ps1.executeUpdate();

			for (int i = 1; i <= row_count; i++) {
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
					ps1.setInt(6, id);

					ps1.executeUpdate();
				}

			}

			/*
			 * System.out.println(name + nrc + dob + phone + gender + nation + address);
			 * System.out.println(row_count);
			 */
			
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Student_list");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
