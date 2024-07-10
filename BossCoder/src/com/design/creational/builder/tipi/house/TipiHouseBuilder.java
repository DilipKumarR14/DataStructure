package com.design.creational.builder.tipi.house;

import com.design.creational.builder.HouseBuilder;
import com.design.creational.builder.house.House;

public class TipiHouseBuilder implements HouseBuilder {

	private House house;

	public TipiHouseBuilder() {
		this.house = new House();
	}

	public void buildBasement() {
		house.setBasement("Wooden Poles");
	}

	public void buildStructure() {
		house.setStructure("Wood and Ice");
	}

	public void buildInterior() {
		house.setInterior("Fire Wood");
	}

	public void buildRoof() {
		house.setRoof("Wood, caribou and seal skins");
	}

	public House getHouse() {
		return this.house;
	}

}
