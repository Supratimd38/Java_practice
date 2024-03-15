package com.assignment.lamba;

import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Question7 {

	public static boolean areAnagrams(String str1, String str2) {

		String lowercase1 = str1.toLowerCase();
		String lowercase2 = str2.toLowerCase();

		if (lowercase1.length() != lowercase2.length()) {
			return false;
		}

		Map<Character, Long> charCountMap = lowercase1.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));

		return lowercase2.chars().mapToObj(c -> (char) c).allMatch(
				c -> charCountMap.getOrDefault(c, 0L) > 0L && charCountMap.put(c, charCountMap.get(c) - 1L) != null);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter first string: ");
		String str1 = scanner.nextLine();

		System.out.print("Enter second string: ");
		String str2 = scanner.nextLine();

		if (areAnagrams(str1, str2)) {
			System.out.println(str1 + " and " + str2 + " are anagrams.");
		} else {
			System.out.println(str1 + " and " + str2 + " are not anagrams.");
		}
	}

}
