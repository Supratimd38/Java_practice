package com.assignment.lamba;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//3.	Find frequency of each element in an array or a list.
public class Question3 {

	public static void main(String[] args) {
		List<String> strings = Arrays.asList("Pen", "Eraser", "Notebook", "Pen", "Pencil", "Stapler", "Notebook",
				"Pencil", "Pen");

		Map<String, Long> frequencyMap = strings.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(frequencyMap);

	}
}
