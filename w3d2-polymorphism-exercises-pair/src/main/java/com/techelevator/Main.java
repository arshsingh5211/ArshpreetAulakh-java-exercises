package com.techelevator;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Worker> payroll = new ArrayList<Worker>();
		payroll.add(new SalaryWorker("Bruce", "Wayne", 10000000000.00));
		payroll.add(new HourlyWorker("Clark", "Kent", 25.00));
		payroll.add(new VolunteerWorker("Laadi", "Kaur"));
		payroll.add(new SalaryWorker("Diana", "Prince", 400000.00));
		payroll.add(new HourlyWorker("Barry", "Allen", 30.00));
		payroll.add(new VolunteerWorker("Harley", "Quinn"));
		payroll.add(new SalaryWorker("Arthur", "Curry", 75000.00));
		payroll.add(new HourlyWorker("Victor", "Stone", 60.00));
		payroll.add(new VolunteerWorker("J'onn", "J'onzz"));
		
		int hoursWorked = 0;
		int totalHours = 0;
		double totalPay = 0.00;
		 NumberFormat myFormat = NumberFormat.getInstance();
	     myFormat.setGroupingUsed(true);
		DecimalFormat df = new DecimalFormat("0.00");
        df.setGroupingUsed(true);
        df.setGroupingSize(3);
		
		
		System.out.println("Name\t\t\tHours Worked\t\t\t\s\sWeekly Pay\t\t\t");
		System.out.println("------------------------------------------------------------------------------------------------");
		for (Worker employee : payroll) {
			hoursWorked = (int)(Math.floor(Math.random()*(60+1))); // used 60 for maxHours and 0 for minHours
			double weekPay = employee.calculateWeeklyPay(hoursWorked);
			totalHours += hoursWorked;
			totalPay += weekPay;
			
			System.out.println(String.format("%-22s", employee.getLastName() + ", " + employee.getFirstName()) + "       " + String.format("%-22s", hoursWorked) + 
					"       " + df.format(weekPay));
		}
		System.out.println("\nTotal Hours: " + totalHours);
		System.out.println("Total Pay: " + df.format(totalPay));
	}

}