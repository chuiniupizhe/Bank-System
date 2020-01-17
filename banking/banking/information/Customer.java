/**
 * @author 琚佸織鏉�?
 * @version 1.0
 */
package banking.information;

import java.util.*;

public class Customer{
	private String name;
	Account account;

	public Customer(String f) {
		name = f;
	}
	
	public String getName() {
		return name;
	}

	public void addAccount(Account acct) {
		account=acct;
	}

	public Account getAccount() {
		return account;
	}

}
