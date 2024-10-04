package com.interviewprep.oop_concepts.enum_types;

public class EnumIteration {
  public static void main(String[] args) {
    for (EnumWithConstructorsFieldsMethods gender : EnumWithConstructorsFieldsMethods.values()) {
      System.out.println(gender + " : " + gender.getGenderType());
    }
  }
}