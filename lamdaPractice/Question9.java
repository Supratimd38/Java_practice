package com.assignment.lamba;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//9.	Given a list of strings, find out those strings which start with a number.
public class Question9 {

	public static void main(String[] args) {
		List<String> myList = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");

		List<String> numbersAtStart = myList.stream().filter(str -> Character.isDigit(str.charAt(0)))
				.collect(Collectors.toList());
		System.out.println(numbersAtStart);
	}
}
