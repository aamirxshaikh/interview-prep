package com.interviewprep.java_basics.static_import;

import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

/**
 * Static import is used to import the static members of a class. It is used to access static members without using the class name.
 *
 * @author aamir on 8/24/24
 */
public class StaticImport {
  public static void main(String[] args) {
    double radius = 5.0;
    double area = PI * radius * radius;
    double root = sqrt(16);

    System.out.println("Area of the circle: " + area);
    System.out.println("Square root of 16: " + root);
  }
}
