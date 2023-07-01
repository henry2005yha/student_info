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

import com.student.bean.Student;
import com.student.util.DB;

@WebServlet("/Student_list")
public class Student_list extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            ArrayList<Student> students = new ArrayList<Student>();
            con = DB.createConnection();
            ps = con.prepareStatement("SELECT s.student_id, s.name, s.nrc, s.dob, s.phone, s.gender, s.nationality, s.address, COUNT(sd.student_id) AS num_references\r\n"
                    + "FROM students.student AS s\r\n"
                    + "LEFT JOIN (\r\n"
                    + "  SELECT student_id\r\n"
                    + "  FROM student_detail\r\n"
                    + ") AS sd ON s.student_id = sd.student_id\r\n"
                    + "GROUP BY s.student_id;");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student(rs.getInt("student_id"), rs.getString("name"), rs.getString("nrc"),
                        rs.getString("dob"), rs.getString("phone"), rs.getString("gender"),
                        rs.getString("nationality"), rs.getString("address"), rs.getInt("num_references"));
                students.add(s);
            }

            request.setAttribute("students", students);
            request.getRequestDispatcher("Student_list.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        handleRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            ArrayList<Student> students = new ArrayList<Student>();
            con = DB.createConnection();
            ps = con.prepareStatement("SELECT s.student_id, s.name, s.nrc, s.dob, s.phone, s.gender, s.nationality, s.address, COUNT(sd.student_id) AS num_references\r\n"
                    + "FROM students.student AS s\r\n"
                    + "LEFT JOIN (\r\n"
                    + "  SELECT student_id\r\n"
                    + "  FROM student_detail\r\n"
                    + ") AS sd ON s.student_id = sd.student_id\r\n"
                    + "GROUP BY s.student_id;");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student s = new Student(rs.getInt("student_id"), rs.getString("name"), rs.getString("nrc"),
                        rs.getString("dob"), rs.getString("phone"), rs.getString("gender"),
                        rs.getString("nationality"), rs.getString("address"), rs.getInt("num_references"));
                students.add(s);
            }

            request.setAttribute("students", students);
            request.getRequestDispatcher("Student_list.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String requestMethod = request.getMethod();

        if ("GET".equalsIgnoreCase(requestMethod)) {
            // Process GET request
        } else if ("POST".equalsIgnoreCase(requestMethod)) {
            // Process POST request
        }
    }
}
