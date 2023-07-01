<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.student.bean.*"%>
<%@ page import="com.student.controller.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<style>

#studentList{
	margin:0auto;
	margin-left: auto;
	margin-right:auto;
	width:60%;
	text-decoration: none; 
	-webkit-border-horizontal-spacing:0px;	
	margin-bottom: 5%;
}

#studentList td, #studentList th {
	border: opx;
	padding: 1rem;
	
}

#studentList tr {
	background-color: rgba(255, 255, 255, 0.2);
	color:black;
	border-bottom: 1px doted white;
	
}

#studentList tr:hover {
	background-color: rgba(0, 0, 0, 0.1);
	color:black!important;
}

#studentList th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: rgba(0, 0, 0, 0.5);
	color: white;
	font-weight: 500;
}



 
</style>

</head>
<body>
<jsp:include page="nav.jsp"></jsp:include>
 <div class="container">
        <h1 class="text-center">Register Students</h1><br>
        <table class="table" id="studentList">
            <thead>
                <tr>
                   <th>Student Name</th>
					<th>Student NRC.</th>
					<th>Phone No.</th>
					<th></th>
					<th></th>
                </tr>
            </thead>
            <tbody>
                <% List<Student> students = (List<Student>) request.getAttribute("students"); %>
                <% if (students != null && !students.isEmpty()) { %>
                    <% for (Student student : students) { %>
                        <tr>
                            <td onclick="redirectToDetail(<%= student.getStudent_id() %>)" onclick="redirectToDetail(<%= student.getStudent_id() %>}"><%= student.getName() %></td>
                            <td onclick="redirectToDetail(<%= student.getStudent_id() %>)" onclick="redirectToDetail(<%= student.getStudent_id() %>)"><%= student.getNrc() %></td>
                            <td onclick="redirectToDetail(<%= student.getStudent_id() %>)" onclick="redirectToDetail(<%= student.getStudent_id() %>)"><%= student.getPhone() %></td>
                            <td><a class="link" href="detail_list?id=<%= student.getStudent_id() %>&action=edit&row_count=<%= student.getNum_ref() %>">Edit</a></td>
							<td><a class="link" href="Delete?id=<%= student.getStudent_id() %>">Delete</a></td>
                        </tr>
                    <% } %>
                <% } else { %>
                    <tr>
                        <td colspan="8">No students found.</td>
                    </tr>
                <% } %>
            </tbody>
        </table>
        
        
               
           
        
        </div>


<script>
  function redirectToDetail(studentId) {
    window.location.href = "detail_list?id=" + studentId + "&action=view";
  }
</script>
</body>
</html>