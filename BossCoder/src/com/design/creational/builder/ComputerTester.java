package com.design.creational.builder;

public class ComputerTester {

	public static void main(String[] args) {

		Computer cp = new Computer.ComputerBuilder("500GB", "2 GB")
				.setBluetoothEnabled(true)
				.build();
		
		System.out.println(cp);

	}

}
