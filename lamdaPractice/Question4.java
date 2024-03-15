package com.assignment.lamba;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//4.	Sort the given list of decimals in reverse order (higher to lower).

public class Question4 {

	public static void main(String[] args) {
		List<Double> decimals = Arrays.asList(3.14, 1.59, 2.65, 4.92, 0.87);

		List<Double> sortedDecimals = decimals.stream().sorted((d1, d2) -> Double.compare(d2, d1))
				.collect(Collectors.toList());

		System.out.println(sortedDecimals);

	}

}
