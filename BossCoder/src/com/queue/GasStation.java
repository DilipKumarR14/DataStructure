package com.queue;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GasStation {

	public static void main(String[] args) {

		int[] gas = { 1, 2, 3, 4, 5 };
		int[] cost = { 3, 4, 5, 1, 2 };

		List<Integer> ll = List.of(1, 2, 3, 4, 5, 6);

		List<Integer> collect = ll.stream().filter(i -> i % 2 == 0).collect(Collectors.toUnmodifiableList());

		String value = null;
		var orElseThrow = Optional.ofNullable(value).orElseThrow();

		System.out.println(orElseThrow);

	}

}
