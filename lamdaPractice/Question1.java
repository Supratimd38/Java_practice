package com.assignment.lamba;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//1.	Given a list of integers, separate odd and even numbers. 

public class Question1 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);

		List<Integer> evenNumbers = numbers.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());

		List<Integer> oddNumbers = numbers.stream().filter(number -> number % 2 != 0).collect(Collectors.toList());

		System.out.println("Even numbers: " + evenNumbers);
		System.out.println("Odd numbers: " + oddNumbers);

	}

}
