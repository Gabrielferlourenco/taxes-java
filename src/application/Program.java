package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Tax Payer #" + i + " data: ");
			
			System.out.print("Individual or company (i/c)? ");
			char type = sc.next().charAt(0);
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("Anual Income: ");
			double anualIncome = sc.nextDouble();
			
			if(type == 'i') {
				System.out.print("Health Expenditures: ");
				double healthExpenditures = sc.nextDouble();
				
				list.add(new Individual(name, anualIncome, healthExpenditures));
			}
			
			else if(type == 'c') {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				
				list.add(new Company(name, anualIncome, numberOfEmployees));
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		
		for(TaxPayer payers : list) {
			System.out.println(payers.getName() + ": $ " + String.format("%.2f", payers.tax()));
		}
		
		double totalTaxes = 0.0;
		
		for(TaxPayer payers : list) {
			totalTaxes += payers.tax();
		}
		
		System.out.println();
		System.out.printf("TOTAL TAXES: $ %.2f%n", totalTaxes );
		
		sc.close();
	}
}
