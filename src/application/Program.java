package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> payers = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int numT = sc.nextInt();
		
		for(int i = 1; i <=numT; i++) {
			System.out.println("Tax payer #" + i + " data");
			System.out.print("Individual or company (i/c)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			Double anualIncome = sc.nextDouble();
			
			if(type == 'i' || type == 'I') {
				System.out.print("Health expenditures: ");
				Double healthExpenditures = sc.nextDouble();
				payers.add(new Individual(name, anualIncome, healthExpenditures));
			}
			else if(type == 'c' || type == 'C') {
				System.out.print("Number of employees: ");
				int numberOfEmployee = sc.nextInt();
				payers.add(new Company(name, anualIncome, numberOfEmployee));
			}
		}
		System.out.println("\nTAXES PAID:");
		Double sum = 0.0;
		for(TaxPayer p : payers) {
			System.out.println(p.getName() + ": $" + String.format("%.2f", p.tax()));
			sum += p.tax();
		}
		System.out.println("\nTOTAL TAXES: $" + sum);
		sc.close();
	}

}
