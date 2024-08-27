package com.interviewprep.data_types_and_variables.primitive_data_types;

import java.util.Arrays;

/**
 * @author aamir on 8/26/24
 */
public class PrimitiveDataTypes {
  public static void main(String[] args) {
    // 8-bit signed integer
    byte byteValue = 10;
    System.out.println("byte: " + byteValue);

    // 16-bit signed integer
    short shortValue = 100;
    System.out.println("short: " + shortValue);

    // 32-bit signed integer
    int intValue = 1000;
    System.out.println("int: " + intValue);

    // 64-bit signed integer
    long longValue = 10000L;
    System.out.println("long: " + longValue);

    // 32-bit floating-point
    float floatValue = 10.5f;
    System.out.println("float: " + floatValue);

    // 64-bit floating-point
    double doubleValue = 100.5;
    System.out.println("double: " + doubleValue);

    // 16-bit Unicode character
    char charValue = 'A';
    System.out.println("char: " + charValue);

    // Boolean value (true or false)
    boolean booleanValue = true;
    System.out.println("boolean: " + booleanValue);
    
    String[] stringArray = new String[] {"Hello", "World"};
    System.out.println("Arrays.toString(stringArray) = " + Arrays.toString(stringArray));
  }
}
