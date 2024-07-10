package com.solid;

interface Transaction {
	void deposit(double amt);

	void withdraw(double amt);

	void transfer(double amt, Account destinationAccount);
}