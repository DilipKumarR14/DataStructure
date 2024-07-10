package com.solid;

class Account implements AccountInfo, Transaction {
	private String accountNumber;
	private double balance;

	public Account(String accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	@Override
	public String getAccountNumber() {
		return accountNumber;
	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public void deposit(double amount) {
		balance += amount;
	}

	@Override
	public void withdraw(double amount) {
		balance -= amount;
	}

	@Override
	public void transfer(double amount, Account destinationAccount) {
		if (balance >= amount) {
			withdraw(amount);
			destinationAccount.deposit(amount);
		} else {
			System.out.println("Insufficient funds.");
		}
	}
}