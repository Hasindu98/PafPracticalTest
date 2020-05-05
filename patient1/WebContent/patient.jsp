<%@page import="model.Patient"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=ISO-8859-1">
<title>Patient Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/main.js"></script>
</head>
<body>
		<div class="container"> 
		<div class="row">  
		
			<div class="col-8">       
				<h1 class="m-3">Patient Management</h1>        
				
				<form id="formPatient" name="formPatient" method="post" action="patient.jsp">
					Patient ID:  
					<input id="pat_id" name="pat_id" type="text" class="form-control form-control-sm"> 
					
					<br> 
				  
					FirstName:  
					<input id="first_name" name="first_name" type="text" class="form-control form-control-sm">  
					
					<br> 
					LastName:  
					<input id="last_name" name="last_name" type="text" class="form-control form-control-sm">  
					
					<br>
					 NIC:  
					 <input id="pat_nic" name="pat_nic" type="text" class="form-control form-control-sm">  
					 
					 <br> 
					 DateOFBirth:
					  <input id="pat_bday" name="pat_bday" type="text" class="form-control form-control-sm">
					 
					 <br> 
					 PhoneNumber:  
					 <input id="pat_phno" name="pat_phno" type="text" class="form-control form-control-sm">  
					 
					 <br> 
					 Email:  
					 <input id="pat_email" name="pat_email" type="text" class="form-control form-control-sm">
					 
					 <br> 
					<!-- GENDER -->
					<div class="input-group input-group-sm">
						<div class="input-group-prepend">
							<span class="input-group-text" id="pat_gender">Gender: </span>
					</div>
					&nbsp;&nbsp;Male
					<input type="radio" id="rdoGenderMale" name="rdoGender" value="Male">
					&nbsp;&nbsp;Female
					<input type="radio" id="rdoGenderFemale" name="rdoGender" value="Female">
					</div>
					

					 
					 
					 <br>  
					 <input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">  
					 
					 <input type="hidden" id="hidappIDSave" name="hidappIDSave" value=""> 

				</form> 
				
				<div id="alertSuccess" class="alert alert-success"></div>  
				<div id="alertError" class="alert alert-danger"></div> 
				
				<br>  
				<div id="divItemsGrid">   
					<%
					Patient patObj = new Patient();
   					out.print(patObj.readpdetails());
   					%>  
					
				</div> 
				  
 			</div>
 		 
 		</div>    
 		
 
	</div> 
</body>
</html>