package com.student.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.bean.*;
import com.student.util.DB;

@WebServlet("/detail_list")
public class detail_list extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        
        try {
            ArrayList<Student> students = new ArrayList<Student>();
            ArrayList<Student_detail> student_details = new ArrayList<Student_detail>();

            int id = Integer.parseInt(request.getParameter("id"));
            String action = request.getParameter("action");
            con = DB.createConnection();
            ps = con.prepareStatement("SELECT * FROM students.student where student_id=?;");
            ps1 = con.prepareStatement("SELECT * FROM students.student_detail where student_id=?;");
            ps.setInt(1, id);
            ps1.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Student s = new Student(rs.getInt("student_id"), rs.getString("name"), rs.getString("nrc"),
                        rs.getString("dob"), rs.getString("phone"), rs.getString("gender"),
                        rs.getString("nationality"), rs.getString("address"));
                students.add(s);
            }
            ResultSet rs1 = ps1.executeQuery();
            while (rs1.next()) {
            	Student_detail sd = new Student_detail(rs1.getInt("id"), rs1.getString("year"), rs1.getInt("mark1"), rs1.getInt("mark2"),rs1.getInt("mark3"), rs1.getString("remark"), rs1.getInt("student_id"));
            	student_details.add(sd);
			}
 
            // Set students as an attribute in the request scope
            request.setAttribute("students", students);
            request.setAttribute("student_details", student_details);
            
            if (action.equals("edit")) {
            	request.getRequestDispatcher("Edit_form.jsp").forward(request, response);
			}
            else {
            	request.getRequestDispatcher("Detail_list.jsp").forward(request, response);
			}
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
