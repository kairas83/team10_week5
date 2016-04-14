package org.iptime.kairas.phonebill;

import java.util.Iterator;
import java.util.LinkedList;

public class App {
	private App() {
		// hide empty Constructor
	}

	public static void main(String[] args) {
		AppView appView = new AppView();
		PhoneBill phoneBill = new PhoneBill();
		LinkedList<Account> account;

		if (args.length == 0) {
			account = (LinkedList<Account>) appView.readFile("input_default.txt");
		} else {
			account = (LinkedList<Account>) appView.readFile(args[0]);
		}

		for (Iterator<Account> it = account.iterator(); it.hasNext();) {
			phoneBill.setAccount(it.next());
			appView.outputString(phoneBill.getBillForm());
		}
	}
}
