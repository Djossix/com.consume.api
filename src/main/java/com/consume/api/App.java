package com.consume.api;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		AddEmployee addEmp = new AddEmployee();
		GetEmployees getEmp = new GetEmployees();

		while (true) {
			try {
				Scanner in = new Scanner(System.in);

				System.out.println("Welcome to Employee Management. Here you can add employees or view existing."
						+ "\n\nPress 1 to add new employee.\nPress 2 to view employees\nPress 3 to exit.\n");
				String menu = in.nextLine();

				// Choice 1, add new employee.
				if (menu.equalsIgnoreCase("1")) {
					System.out.print("\nPlease enter employee-number: ");
					int empNr = Integer.parseInt(in.nextLine());

					System.out.print("\nPlease enter the name of the employee: ");
					String name = in.nextLine();

					System.out.print("\nPlease enter job title: ");
					String profession = in.nextLine();

					addEmp.addNewEmployee(empNr, name, profession);
					break;

				// Coice 2, view existing employees.	
				} else if (menu.equalsIgnoreCase("2")) {
					getEmp.getEmployees();
					break;
				// Choice 3, exit application.	
				} else if (menu.equalsIgnoreCase("3")) {
					break;
				}
			} catch (Exception e) {
				System.err.println("ERROR: " + e.getMessage());
				break;
			}
		}
	}
}
