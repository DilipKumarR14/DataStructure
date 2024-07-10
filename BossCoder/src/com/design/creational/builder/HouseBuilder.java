package com.design.creational.builder;

import com.design.creational.builder.house.House;

public interface HouseBuilder {

	public void buildBasement();

	public void buildStructure();

	public void buildRoof();

	public void buildInterior();

	public House getHouse();

}
