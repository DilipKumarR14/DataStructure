package com.design.creational.builder.engineer;

import com.design.creational.builder.HouseBuilder;
import com.design.creational.builder.house.House;

public class CivilEngineer {

	private HouseBuilder houseBuilder;

	public CivilEngineer(HouseBuilder houseBuilder) {
		super();
		this.houseBuilder = houseBuilder;
	}

	public House getHouse() {
		return houseBuilder.getHouse();
	}

	public void constructHouse() {
		this.houseBuilder.buildBasement();
		this.houseBuilder.buildStructure();
		this.houseBuilder.buildRoof();
		this.houseBuilder.buildInterior();
	}

}
