package com.interviewprep.java_collections_framework.generics.wildcards_extends_and_super;

import java.util.ArrayList;
import java.util.List;

public class WildcardExample {
  public static void addNumbers(List<? super Integer> list) {
    list.add(5);
  }

  public static void main(String[] args) {
    List<Number> numbers = new ArrayList<>();
    addNumbers(numbers);
    System.out.println(numbers);
  }
}
