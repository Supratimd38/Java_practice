package com.assignment.lamba;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//2.	Remove duplicate elements from a list using Java 8 streams.
public class Question2 {

	public static void main(String[] args) {
		List<String> strings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");

		List<String> distinctStrings = strings.stream().distinct().collect(Collectors.toList());

		System.out.println("List without duplicates: " + distinctStrings);

	}

}
