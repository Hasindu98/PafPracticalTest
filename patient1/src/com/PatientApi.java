package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Patient;

import java.util.HashMap; 
import java.util.Map; 
import java.util.Scanner;


/**
 * Servlet implementation class PatientApi
 */
@WebServlet("/PatientApi")
public class PatientApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Patient patObj = new Patient();
	
    public PatientApi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = patObj.insertpdetails(request.getParameter("pat_id"), 
				request.getParameter("first_name"), 
				request.getParameter("last_name"), 
				request.getParameter("pat_NIC"), 
				request.getParameter("pat_bday"), 
				request.getParameter("pat_phno"), 
				request.getParameter("pat_email"), 
				request.getParameter("pat_gender")); 
 
		response.getWriter().write(result); 
 

		
	}
	private  Map<String, String> getParasMap(HttpServletRequest request) {  
		
		Map<String, String> map = new HashMap<String, String>();  
		
		try  {   
			
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");   
			String queryString = scanner.hasNext() ?        		
			scanner.useDelimiter("\\A").next() : "";   
			scanner.close(); 
	 
			String[] params = queryString.split("&");   
			
			for (String param : params)   { 
				String[] p = param.split("=");    
				map.put(p[0], p[1]);   
				
			}  
			
		}  catch (Exception e)  {  
			
		}  
		
		return map; 
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, String> param = getParasMap(request); 
		 
		 String result = patObj.updatePatient(param.get("hidappIDSave").toString(),     
				 param.get("pat_id").toString(),     
				 param.get("first_name").toString(),        
				 param.get("last_name").toString(),        
				 param.get("pat_NIC").toString(),
				 param.get("pat_bday").toString(),
				 param.get("pat_phno").toString(),
				 param.get("pat_email").toString(),
				 param.get("pat_gender").toString());
		 
		 response.getWriter().write(result);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> param = getParasMap(request); 
		 
		 String result = patObj.deletepdetails(param.get("pat_id").toString()); 
		 
		 response.getWriter().write(result);
	}

}
