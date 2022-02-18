package ca.jrvs.practice.dataStructure.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Employee {
	
	private int id, age;
	private long salary;
	private String name;
	
	public Employee() {}
	
	public Employee(int id, String name, int age, long salary) {
		this.id = id;
		this.age = age;
		this.name = name;
		this.salary = salary;
	}
	
	public static void main(String[] args) {
		Map<Employee, List<String>> stringMap = new HashMap<>();
		
		Employee emp1 = new Employee(1, "Andrew", 30, 50000);
		Employee emp2 = new Employee(2, "Will", 35, 100000);
		
		List<String> emp1Companies = Arrays.asList("American Express", "Shopify", "Uber");
		List<String> emp2Companies = Arrays.asList("Ford", "GM", "Toyota");
		
		stringMap.put(emp1, emp1Companies);
		stringMap.put(emp2, emp2Companies);
		
		System.out.println(emp1.name + " hash: " + emp1.hashCode());
		System.out.println(emp1.name + " value: " + stringMap.get(emp1).toString());
		
		System.out.println(emp2.name + " hash: " + emp2.hashCode());
		System.out.println(emp1.name + " value: " + stringMap.get(emp2).toString());
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(age, id, name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return age == other.age && id == other.id && Objects.equals(name, other.name) && salary == other.salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
