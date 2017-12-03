import java.io.*;
import java.util.Scanner;

public class ATM {
		
	public static void ATMOptions(){
		 System.out.printf(" 1 - Account Balance  %n"
 				 + " 2 - WithDrawl %n" 
 				 + " 3 - Change CustomerPin %n"
 				 + " 4 - Check Stock Prices %n"
 				 + " 5 - Logout %n");
	}
	
	public static void main(String[] args) throws Exception {
		
		int passCode;	
		int option;
		int amount;
		boolean x = true;
		String answer; 
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		Customers customer = new Customers();
		Stocks stock = new Stocks();
	 
	 
	 System.out.println("Welcome to the Bank of Joice");
	 
	 while (x){	 
		 System.out.print("Please enter in your 4 digit customer ID: ");
		 passCode = scan.nextInt();
		 boolean y = customer.checkCustomerPin(passCode);
		 x = y;
	 }
	 
		 System.out.printf("%nHi " + customer.getName() + " %n%nPlease select one of the following options: ");
		 System.out.println("");
		 ATMOptions();
		 option = scan.nextInt();
		 
		 while(true){
			 if(option == 1){
				 System.out.println("Your account balance is: " + customer.getAccountAmount());
				 System.out.println("...................loading");
				 ATMOptions();
				 option = scan.nextInt();
			 }else if(option == 2){
				 if(customer.getAccountAmount() < 1){
					 System.out.println("Sorry insufficient funds");
					 System.out.println("...................loading");
					 ATMOptions();
					 option = scan.nextInt();
				 }else{
				 System.out.println("How much would you like to take out?");
				 amount = scan.nextInt();
				 customer.withdrawAmount(amount);
				 customer.save();
				 System.out.println("New amount is " + customer.getAccountAmount());
				 System.out.println("...................loading");
				 ATMOptions();
				 option = scan.nextInt();
				 }
			 }else if(option == 3){
				 System.out.println("Please type in a 4 digit pin");
				 Integer pinA = scan.nextInt();
				 System.out.println("Please re-type in the 4 digit pin");
				 Integer pinB = scan.nextInt();
				 System.out.println("...................loading");
				 customer.setPin(pinA, pinB);
				 customer.save();
				 System.out.println("Pin successfully changed!");
				 ATMOptions();
				 option = scan.nextInt();
			 }else if(option == 4){
				 System.out.println("Loading Stocks");
				 System.out.println("...................");
				 stock.loadStocks();
				 System.out.println("...................");
				 System.out.println("Do you want to return to the main menu? Y/N");
				 scan.nextLine();
				 answer = scan.nextLine();
				if(answer.equalsIgnoreCase("Y")){
						 ATMOptions();
						 option = scan.nextInt();
				   }else{
					   System.out.println("...................");
						 System.out.println("Goodbye " + customer.getName());
						 System.exit(0);
				   }						 	 
			 }else if(option == 5){
				 System.out.println("...................");
				 System.out.println("Goodbye " + customer.getName());
				 System.exit(0);
			 }else{
				 System.out.println("Please select a valid option");
				 System.out.println("...................loading");
				 ATMOptions();
				 option = scan.nextInt();
			 }
			 
		 }
		 
	}
}
