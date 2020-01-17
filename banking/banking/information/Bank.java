package banking.information;

import java.util.*;

public class Bank {
	List customer;
	private static Bank bankInstance = new Bank();

	private Bank() {
		customer = new ArrayList();
	}

	public static Bank getBank() {
		return bankInstance;
	}

	public void addCustomer(String f) {
		customer.add(new Customer(f));

	}
	
	public int getNumOfCustomers() {
		return customer.size();
	}

	public Customer getCustomer(int index) {
		return (Customer) customer.get(index);
	}
	
	public void delCustomer(int index) {
		customer.remove(index);
	}

}
