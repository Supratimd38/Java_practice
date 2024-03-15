package com.assignment.lamba;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

//Find first non-repeated character in a string.

public class Question10 {

	public static Optional<Character> findFirstNonRepeated(String str) {
		str = str.toLowerCase();

		Map<Character, Integer> charCountMap = new HashMap<>();
		for (char c : str.toCharArray()) {
			charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
		}

		for (char c : str.toCharArray()) {
			if (charCountMap.get(c) == 1) {
				return Optional.of(c);
			}
		}

		return Optional.empty();
	}

	public static void main(String[] args) {
		String inputString = "This is a java assignment";

		Optional<Character> firstNonRepeated = findFirstNonRepeated(inputString);

		if (firstNonRepeated.isPresent()) {
			System.out.println("First non-repeated character: " + firstNonRepeated.get());
		} else {
			System.out.println("No non-repeated character found.");
		}
	}
}
