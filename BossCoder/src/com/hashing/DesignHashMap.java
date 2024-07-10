package com.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DesignHashMap {

	public static void main(String[] args) {
		MyHashMap myHashMap = new MyHashMap();
		myHashMap.put(1, 1); // The map is now [[1,1]]
		myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
		int i = myHashMap.get(1);

		System.out.println(i);// return 1, The map is now [[1,1], [2,2]]
		int j = myHashMap.get(3);

		System.out.println(j);
		System.out.println(myHashMap);

		myHashMap.put(2, 1);

		System.out.println(myHashMap);
	}

}

class MyHashMap {

	int arr[];

	public MyHashMap() {
		arr = new int[1001];
		Arrays.fill(arr, -1);
	}

	public void put(int key, int value) {
		arr[key] = value;
	}

	public int get(int key) {
		return arr[key];
	}

	public void remove(int key) {
		arr[key] = -1;
	}

}
