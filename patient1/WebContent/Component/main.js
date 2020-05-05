$(document).ready(function() {  
	
	if ($("#alertSuccess").text().trim() == "")  {   
		$("#alertSuccess").hide();  
		
	}  
	$("#alertError").hide(); 
	
});

//SAVE ============================================ 

$(document).on("click", "#btnSave", function(event) {  
	
	// Clear status msges-------------  
	
	$("#alertSuccess").text("");  
	$("#alertSuccess").hide();  
	$("#alertError").text("");  
	$("#alertError").hide(); 

	// Form validation---------------- 
	
	var status = validateItemForm(); 

	// If not valid------------------- 
	
	if (status != true)  {   
		$("#alertError").text(status);   
		$("#alertError").show();   
		return;  
	} 

	// If valid-----------------------  
	
	$("#formPatient").submit(); 
	
	$("#alertSuccess").text("Inserted successfully.");  
	$("#alertSuccess").show(); 
	
}); 

//INSERT ============================================ 

function validateItemForm() {  
	
	// PATIENTID  
	if ($("#pat_id").val().trim() == "")  {   
		return "Insert patientId.";  
		
	} 
	
	 // FirstName  
	if ($("#first_name").val().trim() == "")  {   
		return "Insert First name.";  
		
	} 
	 
	
	 
	 // LastName 
	if ($("#last_name").val().trim() == "")  {   
		return "Insert Last name.";  
		
	} 
	
	// NIC  
	if ($("#pat_nic").val().trim() == "")  {   
		return "Insert NIC.";  
		
	} 
	 
	 
	
	// DateOFBirth  
	if ($("#pat_bday").val().trim() == "")  {   
		return "Insert Birth day.";  
		
	} 
	
	// PhoneNumber  
	if ($("#pat_phno").val().trim() == "")  {   
		return "Insert Phone number.";  
		
	}
	
	
	// is numerical value  
	var tmpMobile = $("#pat_phno").val().trim();  
	if (!$.isNumeric(tmpMobile))  {   
		return "Insert a numerical value for Mobile Number.";  
		
	}
	
	// Email 
	if ($("#pat_email").val().trim() == "")  {   
		return "Insert Email.";  
		
	} 
	
	// GENDER
	if ($('input[name="rdoGender"]:checked').length === 0)
	{
	return "Select gender.";
	}
		 return true; 
	 
}


//REMOVE========================================== 
$(document).on("click", ".btnRemove", function(event) {  
	
	$(this).closest("tr").remove();    
	$("#alertSuccess").text("Removed successfully.");  
	$("#alertSuccess").show(); 
	
});

//UPDATE========================================== 
$(document).on("click", ".btnUpdate", function(event) {     
	
	$("#hidappIDSave").val($(this).closest("tr").find('#hidappIDUpdate').val());     
	$("#pat_id").val($(this).closest("tr").find('td:eq(0)').text());    
	$("#first_name").val($(this).closest("tr").find('td:eq(1)').text());     
	$("#last_name").val($(this).closest("tr").find('td:eq(2)').text());     
	$("#pat_nic").val($(this).closest("tr").find('td:eq(3)').text()); 
	$("#pat_bday").val($(this).closest("tr").find('td:eq(4)').text()); 
	$("#pat_phno").val($(this).closest("tr").find('td:eq(5)').text()); 
	$("#pat_email").val($(this).closest("tr").find('td:eq(6)').text()); 
	$('input[name="rdoGender"]:checked').val($(this).closest("tr").find('td:eq(7)').text()); 
	 
	
	$("#alertSuccess").text("Updated successfully.");  
	$("#alertSuccess").show(); 
	
});
