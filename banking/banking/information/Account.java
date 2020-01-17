package banking.information;

import banking.cilent.Land_GUI;

public class Account {
	private double balance;
	private int ID;
	private int password;

	public Account(double init_balance,int ID,int password) {
		balance = init_balance;
		this.ID=ID;
		this.password=password;
	}

	public double getBalance() {
		return balance;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setpassword(int password) {
		this.password=password;
	}
	
	public int getpassword() {
		return password;
	}

	public boolean deposit(double amt) {
		balance += amt;
		return true;
	}

	public boolean  withdraw(double amt)  {
		if (balance - amt >=0) {
			balance -= amt;
			return true;
		} else {
			return false;
			
		}
	}
	
	public boolean transfer(int ID,double money) {
		int i;
		for (i = 0; i < Bank.getBank().getNumOfCustomers(); i++) {
			if(Bank.getBank().getCustomer(i).getAccount().getID()==ID) {
				break;
			}
		}
		if(Bank.getBank().getCustomer(Land_GUI.i).getAccount().withdraw(money)) {
			Bank.getBank().getCustomer(i).getAccount().deposit(money);
			return true;
		}
		else {
			return false;
		}
	}

}










