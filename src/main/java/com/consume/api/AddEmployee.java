package com.consume.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AddEmployee {
	
	public void addNewEmployee(int empNr, String name, String profession) throws MalformedURLException {
		
		String newUrl = "http://localhost:8080/UserManagement/rest/UserService/adduser" + "/" + empNr + "/" + name + "/" + profession;
		
		URL url = new URL(newUrl);
		
		try {
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.connect();
			
		} catch (IOException e) {
			System.err.println("ERROR: " + e.getMessage());
			e.getStackTrace();
		}
	}
}