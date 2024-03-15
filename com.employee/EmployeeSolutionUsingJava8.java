package com.employee;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeSolutionUsingJava8 {

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.00),
				new Employee(122, "Paul Niksui", 25, "Male", "Sales and Marketing", 2015, 13500.00),
				new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.00),
				new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.00),
				new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.00),
				new Employee(166, "Iqbal Hussain", 43, "Male", "Security and Transport", 2016, 10500.00),
				new Employee(177, "Manu Sharma", 35, "Male", "Account and Finance", 2010, 27000.00),
				new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.00),
				new Employee(199, "Amelia Zoe", 24, "Female", "Sales and Marketing", 2016, 11500.00),
				new Employee(200, "Jaden Dough", 38, "Male", "Security and Transport", 2015, 11000.50),
				new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.00),
				new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.00),
				new Employee(233, "Jyothi Reddy", 27, "Female", "Account and Finance", 2013, 21300.00),
				new Employee(244, "Nicolus Den", 24, "Male", "Sales and Marketing", 2017, 10700.50),
				new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.00),
				new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.00),
				new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.00));

		// How many male and female employees are there in the organization?
		Map<String, Long> genderCount = employees.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("Male employees: " + genderCount.getOrDefault("Male", 0L));
		System.out.println("Female employees: " + genderCount.getOrDefault("Female", 0L));

		System.out.println("====================================================================================");
		// Print the name of all departments in the organization?
		Set<String> departments = employees.stream().map(Employee::getDepartment).collect(Collectors.toSet());
		System.out.println("Departments: \n" + departments);

		System.out.println("====================================================================================");

		// What is the average age of male and female employees?
		Map<String, Double> avgAgeByGender = employees.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
		System.out.println("Average age of Male: " + avgAgeByGender.get("Male"));
		System.out.println("Average age of Female: " + avgAgeByGender.get("Female"));
		System.out.println("====================================================================================");

		// Get the details of highest paid employee in the organization?
		Optional<Employee> highestPaid = employees.stream().max(Comparator.comparingDouble(Employee::getSalary));
		if (highestPaid.isPresent()) {
			System.out.println("Highest paid employee: \n " + highestPaid.get());
		}
		System.out.println("====================================================================================");

		// Get the names of all employees who have joined after 2015?
		List<String> joinedAfter2015 = employees.stream().filter(obj -> obj.getYearOfJoining() > 2015)
				.map(Employee::getName).collect(Collectors.toList());
		System.out.println("Employees joined after 2015: " + joinedAfter2015);

		System.out.println("====================================================================================");

		// Count the number of employees in each department?
		Map<String, Long> employeeCountByDept = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("Employee count by department: \n" + employeeCountByDept);
		System.out.println("====================================================================================");

		// What is the average salary of each department?
		Map<String, Double> averageSalaryofDepartment = employees.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("Average salary:\n " + averageSalaryofDepartment);
		System.out.println("====================================================================================");

		// Get the details of youngest male employee in the product development
		// department?

		Optional<Employee> youngestMaleInProductDev = employees.stream()
				.filter(e -> e.getGender().equals("Male") && e.getDepartment().equals("Product Development"))
				.min(Comparator.comparingInt(Employee::getAge));
		System.out.println("Youngest male in Product Development: " + youngestMaleInProductDev.get());
		System.out.println("====================================================================================");

		// Who has the most working experience in the organization?

		Optional<Employee> longestExp = employees.stream()
				.max(Comparator.comparingInt(e -> LocalDate.now().getYear() - e.getYearOfJoining()));
		int exp = LocalDate.now().getYear() - longestExp.get().getYearOfJoining();
		System.out.println("Employee with most experience: " + longestExp.get());
		System.out.println("Experience in years :" + exp);
		System.out.println("====================================================================================");

		// How many male and female employees are there in the sales and marketing team?

		Map<String, Long> genderCountInSalesMarketing = employees.stream()
				.filter(e -> e.getDepartment().equals("Sales and Marketing"))
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(
				"Male employees in Sales and Marketing: " + genderCountInSalesMarketing.getOrDefault("Male", 0L));
		System.out.println(
				"Female employees in Sales and Marketing: " + genderCountInSalesMarketing.getOrDefault("Female", 0L));

		System.out.println("====================================================================================");

		// What is the average salary of male and female employees?

		Map<String, Double> avgSalaryByGender = employees.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("Average salary (Male): " + avgSalaryByGender.get("Male"));
		System.out.println("Average salary (Female): " + avgSalaryByGender.get("Female"));
		System.out.println("====================================================================================");

		// List down the names of all employees in each department?
		Map<String, List<Employee>> employeesByDept = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		for (String dept : employeesByDept.keySet()) {
			System.out.println("Department: " + dept);
			employeesByDept.get(dept).forEach(System.out::println);
		}
		System.out.println("====================================================================================");

		// What is the average salary and total salary of the whole organization?

		double totalSalary = employees.stream().mapToDouble(Employee::getSalary).sum();
		double averageSalary = totalSalary / employees.size();
		System.out.println("Average salary: " + averageSalary);
		System.out.println("Total salary: " + totalSalary);
		System.out.println("====================================================================================");

		// Separate the employees who are younger or equal to 25 years from those
		// employees who are older than 25 years.

		Map<Boolean, List<Employee>> ageGroups = employees.stream()
				.collect(Collectors.partitioningBy(e -> e.getAge() <= 25));
		System.out.println("Employees <= 25 years: " + ageGroups.get(true));
		System.out.println("Employees > 25 years: " + ageGroups.get(false));
		System.out.println("====================================================================================");

		// Who is the oldest employee in the organization? What is his age and which
		// department he belongs to?

		Optional<Employee> oldestEmployee = employees.stream().max(Comparator.comparingInt(Employee::getAge));
		System.out.println("Oldest employee: " + oldestEmployee.get());

		System.out.println("====================================================================================");
	}

}
