package com.assignment.lamba;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//6.	Given a list of strings, sort them according to increasing order of their length.

public class Question6 {

	public static void main(String[] args) {
		List<String> strings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");

		List<String> sortedByLength = strings.stream().sorted((s1, s2) -> s1.length() - s2.length())
				.collect(Collectors.toList());

		System.out.println(sortedByLength);

	}

}
