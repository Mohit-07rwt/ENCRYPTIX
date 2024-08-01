package tasks;
import java.util.Scanner;
class ATM{
	private BankAcc acc;
	private int pin;
	
	public ATM(BankAcc ac,int pin){
		this.acc = ac;
		this.pin=pin;
	}
	
	public void menu() {
		System.out.println("\n\tATM interface");
		System.out.println("1.Check Balance");
		System.out.println("2.Depost");
		System.out.println("3.Withdraw");
		System.out.println("4.Exit!!!");
	}
	
	public boolean verifyPin(int entered_pin) {
		return this.pin==entered_pin;
	}
	
	public void bank_process() {
		Scanner sc=new Scanner(System.in);
		int entered_pin;
		
		System.out.print("enter your pin");
		entered_pin=sc.nextInt();
		if (verifyPin(entered_pin)) {
			int opt=0;
			while (opt !=4) {
				menu();
				System.out.print("Enter your choice:");
				opt=sc.nextInt();
				
				switch(opt) {
				case 1:
					System.out.println("The remaining balance is:"+acc.getBalance());
					break;
				case 2:
					System.out.println("Enter the amount to deposit in the account:");
					double Amount_to_deposit=sc.nextDouble();
					acc.deposit_bal(Amount_to_deposit);
					break;
				case 3:
					System.out.println("Enter amount to widthdraw :");
					double Amount_to_widthdraw=sc.nextDouble();
					acc.widthdraw_bal(Amount_to_widthdraw);
					break;
				case 4:
					System.out.println(" Thank you!");
					break;
				default:
					System.out.println("\n\tInvalid choice.Try again");
					break;
				}
			}
		}
		else {
			System.out.print("incorrect pin");
		}
		sc.close();
		}
}

class BankAcc{
	private double bal;
	
	public BankAcc(double initial_Bal) {
		this.bal=initial_Bal;
	}
	
	public double getBalance() {
		return bal;
	}
	
	public void deposit_bal(double amount) {
		if(amount>0) {
			bal+=amount;
			System.out.println("The amount"+ amount+"is deposited successfully:");
		}
		else {
			System.out.println("Cannot deposit amount less than 0");
		}
	}
	
	public void widthdraw_bal(double amount) {
		if(amount>0 && amount<=bal) {
			bal-=amount;
			System.out.println("The amount"+amount+"is widthdrawn successfully");
		}
		else {
			System.out.println("unsufficient balance");
		}
	}
}

public class ATM_Machine{
	public static void main(String[] args) 
	{
		BankAcc user=new BankAcc(1000.0);
		int actual_pin= 1234;
		ATM atm =new ATM(user,actual_pin);
		atm.bank_process();
	}
}


