package com.interviewprep.data_types_and_variables.primitive_data_types;

/**
 * @author aamir on 8/26/24
 */
public class StringImmutability {
  public static void main(String[] args) {
    String originalString = "Hello";
    String modifiedString = originalString.concat(", World!");

    System.out.println("Original String: " + originalString);
    System.out.println("Modified String: " + modifiedString);

    String str1 = "Hello";
    String str2 = str1;

    str2 = "Hi";

    System.out.println("str1 = " + str1);
    System.out.println("str2 = " + str2);
  }
}
