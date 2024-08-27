package com.interviewprep.data_types_and_variables.reference_data_types;

/**
 * @author aamir on 8/26/24
 */
public class ReferenceTypes {
  public static void main(String[] args) {
    Person person1 = new Person("John", 30);
    Person person2 = person1;

    System.out.println("Person1's Name: " + person1.getName());
    System.out.println("Person2's Name: " + person2.getName());

    person2.setName("Jane");
    System.out.println("Person1's Name after change: " + person1.getName()); // Notice the change

    int[] arr1 = {1, 2, 3};
    int[] arr2 = arr1;

    arr2[0] = 10;

    System.out.println("arr1[0]: " + arr1[0]); // Outputs 10, not 1
  }
}