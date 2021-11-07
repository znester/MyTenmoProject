package com.techelevator.view;


import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import io.cucumber.java.bs.A;
import io.cucumber.java.en_old.Ac;
import org.springframework.web.client.RestClientResponseException;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ConsoleService {

	private PrintWriter out;
	private Scanner in;
	private User user;

	public ConsoleService(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output, true);
		this.in = new Scanner(input);
	}

	public ConsoleService(User user) {
		this.user = user;
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		out.println();
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print(System.lineSeparator() + "Please choose an option >>> ");
		out.flush();
	}

	public String getUserInput(String prompt) {
		out.print(prompt+": ");
		out.flush();
		return in.nextLine();
	}

	public Integer getUserInputInteger(String prompt) {
		Integer result = null;
		do {
			out.print(prompt+": ");
			out.flush();
			String userInput = in.nextLine();
			try {
				result = Integer.parseInt(userInput);
			} catch(NumberFormatException e) {
				out.println(System.lineSeparator() + "*** " + userInput + " is not valid ***" + System.lineSeparator());
			}
		} while(result == null);
		return result;
	}

	public void displayOtherAccounts(List<Account> accounts, String username) {
		out.println("---------------------------------------------");
		out.println("Users");
		out.printf("%-30s", "ID");
		out.printf("%-10s %n", "Name");
		out.println();
		out.println("---------------------------------------------");
		for (int i = 0; i < accounts.size(); i++) {
			if (!accounts.get(i).getUsername().equals(username)) {
				out.printf("%-30s", accounts.get(i).getUserId());
				out.printf("%-10s %n", accounts.get(i).getUsername());
			}
		}
		out.println("---------------------------------------------");
		out.flush();
	}
	public Integer getTransferUserId(){
		out.println("Write User Id you would like to send money to >>> ");
		int userInput = Integer.parseInt(in.nextLine());
		out.flush();
		return userInput;
	}

	public BigDecimal transferAmount(){
		out.println("Amount of money you will send >>> ");
		double transferredMoney = Double.parseDouble(in.nextLine());
		BigDecimal cashTransferred = new BigDecimal(transferredMoney);
		out.flush();
		return cashTransferred;
	}

	public void insufficientFunds(){
		out.println("---------------------------------------------");
		out.println("Insufficient Funds");
		out.println("---------------------------------------------");
	}
	public void wrongUser(){
		out.println("---------------------------------------------");
		out.println("User Does Not Exist");
		out.println("---------------------------------------------");
	}




	public void transferHistory(List<Transfer> transfers, int accountId) {

		out.println("---------------------------------------------");
		out.println("Transfer History\n");
		out.printf("%-30s", "Account From Username");
		out.printf("%-10s %n", "Account To Username");
		out.println();
		out.println("---------------------------------------------");
		try {
			for (Transfer transfer : transfers) {
				if (1==1) {
					out.printf("%-30s", transfer.getAccountFromId());
					out.printf("%-10s %n", transfer.getAccountToId());
				}
			}
		}catch (RestClientResponseException ex){
			System.out.println("You Have No Transfers");
		}
		out.println("---------------------------------------------");
		out.flush();
	}
}
