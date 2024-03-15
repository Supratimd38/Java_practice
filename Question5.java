package com.assignment.lamba;

import java.util.Arrays;
import java.util.Comparator;

//5.	Find second largest number in an integer array.
public class Question5 {

	public static void main(String[] args) {
		
		int[] numbers = {45, 12, 56, 15, 24, 75, 31, 89};
		
		int secondLargest = Arrays.stream(numbers)
				  .boxed()  
				  .sorted(Comparator.reverseOrder())
				  .skip(1)  
				  .findFirst() 
				  .orElse(-1);  

		System.out.println("Second Largest :" + secondLargest);


	}

}
