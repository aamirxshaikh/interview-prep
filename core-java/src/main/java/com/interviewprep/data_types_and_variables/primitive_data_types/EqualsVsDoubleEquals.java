package com.interviewprep.data_types_and_variables.primitive_data_types;

/**
 * @author aamir on 8/26/24
 */
public class EqualsVsDoubleEquals {
  public static void main(String[] args) {
      String str1 = new String("Hello");
      String str2 = new String("Hello");

      // Using ==
      if (str1 == str2) {
        System.out.println("str1 == str2 is true");
      } else {
        System.out.println("str1 == str2 is false");
      }

      // Using .equals()
      if (str1.equals(str2)) {
        System.out.println("str1.equals(str2) is true");
      } else {
        System.out.println("str1.equals(str2) is false");
      }

      // Stored in the string pool
      String str3 = "Hello";
      String str4 = "Hello";

      // Using ==
      if (str3 == str4) {
        System.out.println("str3 == str4 is true");
      } else {
        System.out.println("str3 == str4 is false");
      }
  }
}
