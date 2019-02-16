package com.consume.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetEmployees {
	
	public void getEmployees() throws IOException {
		
		String newUrl = "http://localhost:8080/UserManagement/rest/UserService/getuser";
		
		URL url = new URL(newUrl);
		String readLine = null;
		
		try {
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			BufferedReader read = new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuffer response = new StringBuffer();
			while ((readLine = read.readLine()) != null) {
				response.append(readLine);
			}
			
			int lenght = response.length();
			for (int i=0; i < lenght; i++) {
				System.out.println(response.toString());
			}
			
		} catch (IOException e) {
			System.err.println("ERROR: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

}
