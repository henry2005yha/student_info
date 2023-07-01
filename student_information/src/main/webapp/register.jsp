<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="nav.jsp"></jsp:include>
<div class="container">
  <form action="register" method="post">
    
      <div class="form-group">
      <input type="hidden" value="0" id="row_count" name="row_count">
        <label for="fname">name:</label>
		    <input type="text"id="name" name="name" value="" class="form-control" required>
      </div>
      <div class="form-group">
        <label for="lname">NRC:</label>
		    <input type="text" id="nrc" name="nrc" value="" class="form-control" required>
      </div>
      <div class="form-group">
        <label for="lname">DOB:</label>
		    <input type="date" id="dob" name="dob" value="" class="form-control" required>
      </div>
      <div class="form-group">
        <label for="lname">Phone:</label>
        <input type="text" id="phone" name="phone" value="" class="form-control" required>
      </div>
      <div class="form-group">
        <label for="lname">Gender:</label>
		   <select id="gender" name="gender" class="form-control" required>
  				<option value="male">Male</option>
  				<option value="female">Female</option>
  				<option value="other">Other</option>
			</select>
      </div>
      <div class="form-group">
        <label for="lname">Nationality:</label>
		    <input type="text" id="nation" name="nation" value="" class="form-control" required>
      </div>
      <div class="form-group">
        <label for="lname">Address:</label>
		    <input type="text" id="address" name="address" value="" class="form-control" required>
      </div>
      <div style="background-color: rgba(0,0,0,0.1); padding:20px; margin: 50px 0 25px 0 ;" >
       <div class="form-row" >
       <div class="form-group col-md-6">
        <h3>Student Details</h3>
      </div>
      <div class="form-group col-md-6 text-right" >
        <button class="btn btn-primary"  id="add">Add row</button>
      </div>
      </div>
    
    <div id="dynamic">
    <div class="form-row" >
      <div class="form-group col-md-2">
        <label for="year"><b>Academic Year</b></label>
        <input type="text" class="form-control" id="year" name="year" required>
      </div>
      <div class="form-group col-md-2">
        <label for="mark1">Mark 1</label>
        <input type="number" class="form-control" id="mark1" name="mark1" required>
      </div>
      <div class="form-group col-md-2">
        <label for="mark2">Mark 2</label>
        <input type="number" class="form-control" id="mark2" name="mark2" required>
      </div>
      <div class="form-group col-md-2">
        <label for="mark3">Mark 3</label>
        <input type="number" class="form-control" id="mark3" name="mark3" required>
      </div>
      <div class="form-group col-md-2">
        <label for="remark">Remark</label>
        <input type="text" class="form-control" id="remark" name="remark" required>
      </div>
      
    </div>
  </div>
</div>
    <div class="text-center"><button type="submit" class="btn btn-primary mt-5" style="width:40%">submit</button></div>
  </form>
</div><br><br>
<!-- /////////////////////////////////////////////////////////////////////////////////////// -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>
  $(document).ready(function() {
    var count = 0;

    $("#add").click(function(e) {
      count++;
      e.preventDefault();

      var newRow = $("<div>", {
        class: "form-row",
        id: "row" + count
      });

      var yearFormGroup = $("<div>", {
        class: "form-group col-md-2"
      });

      yearFormGroup.append($("<label>", {
        for: "year",
        html: "<b>Academic Year</b>"
      }));

      yearFormGroup.append($("<input>", {
        type: "text",
        class: "form-control",
        id: "year",
        name: "year" + count,
        required: true
      }));

      newRow.append(yearFormGroup);

      var mark1FormGroup = $("<div>", {
        class: "form-group col-md-2"
      });

      mark1FormGroup.append($("<label>", {
        for: "mark1",
        text: "Mark 1"
      }));

      mark1FormGroup.append($("<input>", {
        type: "number",
        class: "form-control",
        id: "mark1",
        name: "mark1" + count,
        required: true
      }));

      newRow.append(mark1FormGroup);

      var mark2FormGroup = $("<div>", {
        class: "form-group col-md-2"
      });

      mark2FormGroup.append($("<label>", {
        for: "mark2",
        text: "Mark 2"
      }));

      mark2FormGroup.append($("<input>", {
        type: "number",
        class: "form-control",
        id: "mark2",
        name: "mark2" + count,
        required: true
      }));

      newRow.append(mark2FormGroup);

      var mark3FormGroup = $("<div>", {
        class: "form-group col-md-2"
      });

      mark3FormGroup.append($("<label>", {
        for: "mark3",
        text: "Mark 3"
      }));

      mark3FormGroup.append($("<input>", {
        type: "number",
        class: "form-control",
        id: "mark3",
        name: "mark3" + count,
        required: true
      }));

      newRow.append(mark3FormGroup);

      var remarkFormGroup = $("<div>", {
        class: "form-group col-md-2"
      });

      remarkFormGroup.append($("<label>", {
        for: "remark",
        text: "Remark"
      }));

      remarkFormGroup.append($("<input>", {
        type: "text",
        class: "form-control",
        id: "remark",
        name: "remark" + count,
        required: true
      }));

      newRow.append(remarkFormGroup);

      var deleteButton = $('<button>', {
    	  type: 'button',
    	  class: 'btn btn-danger deleteButton',
    	  id: count,
    	  text: 'Delete'
    	});

    	newRow.append($('<div>', {
    	  class: 'form-group col-md-2 text-right'
    	}).append(
    	  $('<label>', {
    	    for: 'delete',
    	    text: 'Delete row'
    	  }),
    	  $('<br>'),
    	  deleteButton
    	));

    	$('#dynamic').append(newRow);
      $('#row_count').val(count);
    });

    $(document).on('click', '.deleteButton', function() {
      var button_id = $(this).attr("id");
      $('#row' + button_id).remove();
      $('#row_count').val(count);
    });
  });
</script>


</body>
</html>