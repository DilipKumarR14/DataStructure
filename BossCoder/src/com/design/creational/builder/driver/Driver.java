package com.design.creational.builder.driver;

import com.design.creational.builder.HouseBuilder;
import com.design.creational.builder.engineer.CivilEngineer;
import com.design.creational.builder.house.House;
import com.design.creational.builder.igloo.house.IglooHouseBuilder;
import com.design.creational.builder.tipi.house.TipiHouseBuilder;

public class Driver {

	public static void main(String[] args) {
		HouseBuilder tipi = new TipiHouseBuilder();
		CivilEngineer engineer = new CivilEngineer(tipi);

		engineer.constructHouse();

		House house = engineer.getHouse();

		HouseBuilder iglooHouseBuilder = new IglooHouseBuilder();
		CivilEngineer iglooEngineer = new CivilEngineer(iglooHouseBuilder);
		iglooEngineer.constructHouse();

		House iglooHouse = iglooEngineer.getHouse();

		System.out.println("Tipi constructed:  " + house);
		System.out.println("iglooHouse constructed: " + iglooHouse);

	}

}
