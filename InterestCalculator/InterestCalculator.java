import java.util.Scanner;

public class InterestCalculator
{

    public static void main(String[] args)
    {
	/*
        Name:Mustafa Tunahan BAS
        Student ID: 150119055


        This program takes yearly interest rate,initial balance and monthly period of interest as inputs
        and prints final amount,compound interest earnings and monthly interest rate. 
         */
	  
	  Scanner scan = new Scanner(System.in);
	  System.out.print("Enter initial principle balance: ");
	  double initialBalance = scan.nextDouble();
	  System.out.print("Enter yearly interest rate (Ex: 9.45): ");
	  double interestRate = scan.nextDouble();
	  System.out.print("Enter monthly time periods (Ex: 8): ");
	  int months = scan.nextInt();
	  
	  //All the statements so far were for receiving input from the user
	  
	  interestRate/=100; //This statement converts the rate into percentage
	  
	  System.out.println("Initial Balance: " + initialBalance);
	  double monthlyRate = interestRate / 12; //Getting monthly interest rate by dividing by 12
	  
	  System.out.println("Monthly Interest Rate: " + (int)(monthlyRate*10000)/100.0);
	  double finalAmount = Math.pow(1+monthlyRate, months) * initialBalance;
	  System.out.println("Total Compound Interest: " + (int)((finalAmount-initialBalance)*100)/100.0);//Subtracting initial balance from final amount
	                                                                                                  //which is equal to compound interest 
	  
	  System.out.println("Final Balance: " + (int)(finalAmount*100)/100.0);
	  
	  //(int)(foo*100)/100 is used to restrict decimal digits to 2
    }

}
