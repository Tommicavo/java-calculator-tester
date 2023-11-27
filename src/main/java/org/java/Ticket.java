package org.java;

import org.java.exceptions.AgeException;
import org.java.exceptions.KmsException;

public class Ticket {
	
	private static final double TICKET_PRICE_PER_KM = 0.21;
	private int kms;
	private int age;
	private double sale;
	
	public Ticket(int kms, int age) throws KmsException, AgeException {
		checkKms(kms);
		checkAge(age);
		checkSale(age);
	}

	public int getKms() {
		return kms;
	}
	public void setKms(int kms) {
		this.kms = kms;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSale() {
		return sale;
	}
	public void setSale(double sale) {
		this.sale = sale;
	}
		
	private void checkKms(int kms) throws KmsException {
		if (kms < 1) {
			throw new KmsException("You must enter a positive kms value.");
		}
		setKms(kms);
	}
	
	private void checkAge(int age) throws AgeException {
		if (age < 0) {
			throw new AgeException("You must enter a positive age value.");
		}
		setAge(age);
	}
	
	private void checkSale(int age) {
		double sale = 0.0;
		if (age < 18) sale = 0.20;
		else if (age > 65) sale = 0.40;
		setSale(sale);
	}
	
	public double getPrice() {
		double cost = getKms() * TICKET_PRICE_PER_KM;
		double finalCost = cost - (cost * getSale());
		return finalCost;
	}
}
