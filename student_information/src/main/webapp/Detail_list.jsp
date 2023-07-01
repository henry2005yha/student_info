<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.student.bean.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Details</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
    <div class="container">
        <h1>Student Details</h1><br>
        <table class="table">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>NRC</th>
                    <th>Date of Birth</th>
                    <th>Phone</th>
                    <th>Gender</th>
                    <th>Nationality</th>
                    <th>Address</th>
                </tr>
            </thead>
            <tbody>
            	
                <% List<Student> students = (List<Student>) request.getAttribute("students"); %>
                <% if (students != null && !students.isEmpty()) { %>
                    <% for (Student student : students) { %>
                        <tr>
                            <td><%= student.getName() %></td>
                            <td><%= student.getNrc() %></td>
                            <td><%= student.getDob() %></td>
                            <td><%= student.getPhone() %></td>
                            <td><%= student.getGender() %></td>
                            <td><%= student.getNationality() %></td>
                            <td><%= student.getAddress() %></td>
                        </tr>
                    <% } %>
                <% } else { %>
                    <tr>
                        <td colspan="8">No students found.</td>
                    </tr>
                <% } %>
            </tbody>
        </table><br><br>
        
        <table class="table">
            <thead>
                <tr>
                    <th>Year</th>
                    <th>Mark 1</th>
                    <th>Mark 2</th>
                    <th>Mark 3</th>
                    <th>Remark</th>
                </tr>
            </thead>
            <tbody>
                <% List<Student_detail> student_details = (List<Student_detail>) request.getAttribute("student_details"); %>
                <% int studentId = 0; %>
                <% int rowCount = 0; %>
                <% if (student_details != null && !student_details.isEmpty()) { %>
                 
                    <% for (Student_detail student : student_details) { %>
                        <tr>
                            <td><%= student.getYear() %></td>
                            <td><%= student.getMark1() %></td>
                            <td><%= student.getMark2() %></td>
                            <td><%= student.getMark3() %></td>
                            <td><%= student.getRemark() %></td>
                        </tr>
                         <% 
                            studentId = student.getStudent_id();
                         	rowCount++;
                        %>
                    <% } %>
                <% } else { %>
                    <tr>
                        <td colspan="8">No student detail found.</td>
                    </tr>
                <% } %>
            </tbody>
        </table>
        <br>
        <a href="detail_list?id=<%= studentId %>&action=edit&row_count=<%= rowCount %>"><button class="btn">Edit</button></a>
        <a href="Delete?id=<%= studentId %>"><button class="btn">Delete</button></a>
        <a href="Student_list"><button class="btn">View Student List</button></a>
        
        
    </div>
</body>
</html>
