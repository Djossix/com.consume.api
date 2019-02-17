package com.consume.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class GetEmployees {
	
	public void getEmployees() throws IOException {
		
		String newUrl = "http://localhost:8080/UserManagement/rest/UserService/getuser";
		
		URL url = new URL(newUrl);
		String readLine = null;
		ArrayList<User> users = new ArrayList();
		
		try {
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			BufferedReader read = new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuffer response = new StringBuffer();
			while ((readLine = read.readLine()) != null) {
				response.append(readLine);
			}
			
			JSONArray jArr = new JSONArray(response);
			
			for (int i=0; i < jArr.length(); i++) {
				JSONObject jObj = jArr.getJSONObject(i);
				
				int id = jObj.getInt("id");
				String name = jObj.getString("name");
				String profession = jObj.getString("profession");
				
				users.add(new User(id, name, profession));
			}
			
		} catch (IOException e) {
			System.err.println("ERROR: " + e.getMessage());
			e.printStackTrace();
		}
		
		for (User user : users) {
			System.out.println("Employee-number: " + user.getId() + "\nName: " + user.getName() + "\nJob title: " + user.getProfession());
		}
	}
}
