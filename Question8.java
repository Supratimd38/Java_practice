package com.assignment.lamba;

import java.util.Scanner;

//8.	Take an integer from the user and find sum of all digits of that number.

public class Question8 {

	public static int sumOfDigits(int number) {

		String numberStr = String.valueOf(number);

		int sum = numberStr.chars().mapToObj(obj -> Character.digit(obj, 10)).filter(digit -> digit != null)
				.mapToInt(Integer::valueOf).sum();

		return sum;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter an integer: ");
		int number = scanner.nextInt();

		int digitSum = sumOfDigits(number);
		System.out.println("Sum of digits: " + digitSum);
	}

}
