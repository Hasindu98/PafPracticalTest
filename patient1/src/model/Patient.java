package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
public class Patient {
	
	
			// A common method to connect to the DB
			private Connection connect() {
				Connection con = null;

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					// Provide the correct details: DBServer/DBName, username, password
					
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/healthcare?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
					
				System.out.print("Successfully connected ");
				
				} catch (Exception e) {
					e.printStackTrace();
					
				}

				return con;
			}	
			
			//==================INSERT Patient METHOD==============================
			
			public String insertpdetails(String pat_id, String first_name, String last_name, String pat_NIC, String pat_bday, String pat_phno, String pat_email, String pat_gender ) {
				String output = "";

				try {
					Connection con = connect();

					if (con == null) {
						return "Error while connecting to the database for inserting.";
					}

					// create a prepared statement
					String query = " insert into pdetails (`pat_id`,`first_name`,`last_name`,`pat_NIC`,`pat_bday`, `pat_phno`,`pat_email`,`pat_gender`)"
							+ " values (?, ?, ?, ?, ?, ?, ?, ?)";

							
					PreparedStatement preparedStmt = con.prepareStatement(query);

					// binding values
					preparedStmt.setInt(1, Integer.parseInt(pat_id));
					preparedStmt.setString(2, first_name);
					preparedStmt.setString(3, last_name);
					preparedStmt.setString(4,pat_NIC);
					preparedStmt.setString(5, pat_bday);
					preparedStmt.setInt(6, Integer.parseInt(pat_phno));
					preparedStmt.setString(7, pat_email);
					preparedStmt.setString(8, pat_gender);

					// execute the statement
					preparedStmt.execute();
					con.close();

					String newpdetails = readpdetails();    
					output = "{\"status\":\"success\", \"data\": \"" + newpdetails + "\"}";
					
				} catch (Exception e) {
					output = "{\"status\":\"error\", \"data\":\"Error while inserting newpdetails.\"}";
					System.err.println(e.getMessage());
				}

				return output;
			}
			
			//========VIEW ALL Patient METHOD============
			
			public String readpdetails() {
				String output = "";

				try {
					Connection con = connect();

					if (con == null) {
						return "Error while connecting to the database for reading.";
					}

					// Prepare the html table to be displayed
					output = "<table border='1'><tr><th>pat_id</th>"
							+ "<th>first_name</th><th>last_name</th>"
							+ "<th>pat_NIC</th><th>pat_bday</th>"
							+ "<th>pat_phno</th><th>pat_email</th>"
							+ "<th>pat_gender</th>"
							+ "<th>Update</th><th>Remove</th>";
					
					
					String query = "select * from pdetails";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(query);

					// iterate through the rows in the result set
					while (rs.next()) {
						String pat_id = Integer.toString(rs.getInt("pat_id"));
						String first_name = rs.getString("first_name");
						String last_name = rs.getString("last_name");
						String pat_NIC = rs.getString("pat_NIC");
						String pat_bday = rs.getString("pat_bday");
						String pat_phno = Integer.toString(rs.getInt("pat_phno"));
						String pat_email = rs.getString("pat_email");
						String pat_gender = rs.getString("pat_gender");

						// Add into the html table
						
						output += "<tr><td><input id='hidappIDUpdate' name='hidappIDUpdate' type='hidden' value='" +pat_id+ "'>" + first_name + "</td>";
						
						output += "<td>" + last_name + "</td>";
						output += "<td>" + pat_NIC + "</td>";
						output += "<td>" + pat_bday + "</td>";
						output += "<td>" + pat_phno + "</td>";
						output += "<td>" + pat_email + "</td>";
						output += "<td>" + pat_gender + "</td>";
						
						
						// buttons     
						output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"       
								+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-itemid='" + pat_id + "'>" + "</td></tr>"; 
						
					}

					con.close();

					// Complete the html table
					output += "</table>";
					
				} catch (Exception e) {
					output = "Error while reading the patients.";
					System.err.println(e.getMessage());
				}

				return output;

			}
			
			
			
			
			
			//===========UPDATE Patient METHOD===============
			
			public String updatepdetails(String pat_id, String first_name, String last_name, String pat_NIC, String pat_bday, String pat_phno, String pat_email, String pat_gender ) {
				String output = "";

				try {
					Connection con = connect();

					if (con == null) {
						return "Error while connecting to the database for updating.";
					}

					// create a prepared statement
					String query = "UPDATE pdetails SET first_name=?,last_name=?,pat_NIC=?,pat_bday=?,pat_phno=?,pat_email=?,pat_gender=? WHERE pat_id=?";

					PreparedStatement preparedStmt = con.prepareStatement(query);

					// binding values
					preparedStmt.setInt(1, Integer.parseInt(pat_id));
					preparedStmt.setString(2, first_name);
					preparedStmt.setString(3,last_name);
					preparedStmt.setString(4, pat_NIC);
					preparedStmt.setString(5, pat_bday);
					preparedStmt.setInt(6,Integer.parseInt (pat_phno));
					preparedStmt.setString(7, pat_email);
					preparedStmt.setString(8, pat_gender);

					// execute the statement
					preparedStmt.execute();
					con.close();

					String newpdetails = readpdetails();    
					output = "{\"status\":\"success\", \"data\": \"" + newpdetails + "\"}";
					
				} catch (Exception e) {
					output = "{\"status\":\"error\", \"data\":\"Error while updating pdetails.\"}";
					System.err.println(e.getMessage());
				}

				return output;
			}
			
			//=======DELETE Patient METHOD===============
			
			public String deletepdetails(String pat_id) {
				String output = "";

				try {
					Connection con = connect();

					if (con == null) {
						return "Error while connecting to the database for deleting.";
					}

					// create a prepared statement
					String query = "delete from pdetails where pat_id=?";

					PreparedStatement preparedStmt = con.prepareStatement(query);

					// binding values
					preparedStmt.setInt(1, Integer.parseInt(pat_id));

					// execute the statement
					preparedStmt.execute();
					con.close();

					String newpdetails = readpdetails();    
					output = "{\"status\":\"success\", \"data\": \"" + newpdetails + "\"}";
					
				} catch (Exception e) {
					output = "{\"status\":\"error\", \"data\":\"Error while updating pdetails.\"}";
					System.err.println(e.getMessage());
				}

				return output;
			}
			
			
}
