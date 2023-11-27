package org.java;

import java.util.Scanner;

import org.java.exceptions.AgeException;
import org.java.exceptions.KmsException;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (true) {
			System.out.println("How many kms do you want to ride?");
			int kms = Integer.valueOf(in.nextLine());
			
			System.out.println("How old are you?");
			int age = Integer.valueOf(in.nextLine());
			
			try {
				Ticket ticket = new Ticket(kms, age);
				double ticketPrice = ticket.getPrice();
				System.out.println("Price: " + ticketPrice);
				break;
			} catch (KmsException e) {
				System.out.println("Kms Error: " + e.getMessage());
				System.out.println("Enter a valid Kms value\n");
				continue;
			} catch (AgeException e) {
				System.out.println("Age Error: " + e.getMessage());
				System.out.println("Enter a valid Age value\n");
				continue;
			}
		}
		in.close();
	}
}
