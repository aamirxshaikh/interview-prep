package com.interviewprep.data_types_and_variables.type_casting;

/**
 * @author aamir on 8/26/24
 */
public class TypeCasting {
  public static void main(String[] args) {
    // Implicit casting (widening)
    int num = 100;
    double numDouble = num;
    System.out.println("Implicit casting: " + numDouble);

    // Explicit casting (narrowing)
    double price = 9.99;
    int roundedPrice = (int) price;
    System.out.println("Explicit casting: " + roundedPrice);

    int a = 257;
    byte b = (byte) a; // Narrowing conversion
    System.out.println("Value of b: " + b); // Outputs 1 (256 is lost)
  }
}
