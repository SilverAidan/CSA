import java.util.Scanner;

public class TaxCalculator {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		// Get the gross income from the user
		System.out.println("What is your gross income");
		final int grossIncome = console.nextInt();
		
		// Determine the filing status (single or married)
		System.out.println("Are you filing (1) single or (2) married jointly");
		final int married = console.nextByte();
		final int standardDeduction = (married * 13850);
		
		// Get the number of dependents
		System.out.println("How many dependants do you have");
		final int dependants = console.nextByte();
		
		// Get the amount withheld
		System.out.println("How much was withheld");
		final int amountWithheld = console.nextInt();
		
		// Get the amount that can be deducted from taxable income
		System.out.println("How much did you deduct from your taxable income.");
		final int amountDeducted = console.nextInt();
		
		int deduction = standardDeduction;
		
		// Determine the higher deduction if applicable
		if (standardDeduction < amountDeducted) {
			deduction = amountDeducted;
		}
		
		// Calculate taxable income
		final int taxableIncome = grossIncome - deduction;
		
		// Calculate tax owed based on taxable income
		final double taxOwed = (taxableIncome * 0.1) + 
				Math.max(((taxableIncome - (married * 11000)) * 0.02), 0) +
				Math.max(((taxableIncome - (married * 44725)) * 0.10), 0) + 
				Math.max(((taxableIncome - (married * 95375)) * 0.13), 0);
		
		// Calculate the final amount owed or refunded
		final double finalAmount = amountWithheld - (taxOwed - (dependants * 2000));
		if (finalAmount > 0) {
			System.out.println("The government owes you $" + Math.abs(finalAmount));
		} else if (finalAmount < 0) {
			System.out.println("You owe $" + Math.abs(finalAmount));
		} else {
			System.out.println("You're good hundo p.");
		}
		console.close();
	}
}
