package com.interviewprep.java_collections_framework.map.treemap;

import java.util.Comparator;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.TreeMap;

public class TreeMapExample {
  public static void main(String[] args) {
    // 1. Natural Ordering (Keys sorted in ascending order)
    TreeMap<Integer, String> naturalOrderMap = new TreeMap<>();
    naturalOrderMap.put(3, "Three");
    naturalOrderMap.put(1, "One");
    naturalOrderMap.put(2, "Two");
    naturalOrderMap.put(4, "Four");

    System.out.println("Natural Order TreeMap: " + naturalOrderMap);

    // 2. Custom Ordering (Descending Order)
    TreeMap<Integer, String> customOrderMap = new TreeMap<>(Comparator.reverseOrder());
    customOrderMap.put(3, "Three");
    customOrderMap.put(1, "One");
    customOrderMap.put(2, "Two");
    customOrderMap.put(4, "Four");

    System.out.println("Custom Order TreeMap (Descending): " + customOrderMap);

    // 3. Retrieving Specific Keys and Values
    System.out.println("First Entry: " + naturalOrderMap.firstEntry());
    System.out.println("Last Entry: " + naturalOrderMap.lastEntry());
    System.out.println("Key less than 3: " + naturalOrderMap.lowerKey(3));
    System.out.println("Key greater than 2: " + naturalOrderMap.higherKey(2));

    // 4. SubMap Operations
    NavigableMap<Integer, String> subMap = naturalOrderMap.subMap(2, true, 4, true);
    System.out.println("SubMap (2 to 4 inclusive): " + subMap);

    // 5. Iteration
    System.out.println("Iterating through TreeMap:");
    for (var entry : naturalOrderMap.entrySet()) {
      System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
    }

    // 6. Removing Elements
    naturalOrderMap.remove(3);
    System.out.println("After Removing Key 3: " + naturalOrderMap);

    // 7. TreeMap with Custom Objects as Keys
    TreeMap<Employee, String> employeeMap = new TreeMap<>();
    employeeMap.put(new Employee(102, "Alice"), "HR");
    employeeMap.put(new Employee(101, "Bob"), "Finance");
    employeeMap.put(new Employee(103, "Charlie"), "IT");

    System.out.println("TreeMap with Custom Objects: " + employeeMap);
  }

  // Custom Key Class (Employee)
  private static class Employee implements Comparable<Employee> {
    private final int id;
    private final String name;

    public Employee(int id, String name) {
      this.id = id;
      this.name = name;
    }

    @Override
    public int compareTo(Employee other) {
      return Integer.compare(this.id, other.id); // Sort by Employee ID
    }

    @Override
    public boolean equals(Object o) {
      if (o == null || getClass() != o.getClass()) return false;
      Employee employee = (Employee) o;
      return id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
      return Objects.hash(id, name);
    }

    @Override
    public String toString() {
      return "Employee{id=" + id + ", name='" + name + "'}";
    }
  }
}
