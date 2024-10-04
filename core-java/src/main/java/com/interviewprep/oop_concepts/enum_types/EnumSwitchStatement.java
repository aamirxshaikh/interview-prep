package com.interviewprep.oop_concepts.enum_types;

public class EnumSwitchStatement {
  public static void main(String[] args) {
    DefiningEnum gender = DefiningEnum.MALE;

    switch (gender) {
      case MALE:
        System.out.println("Gender is Male");
        break;
      case FEMALE:
        System.out.println("Gender is Female");
        break;
      case OTHER:
        System.out.println("Gender is Other");
        break;
    }
  }
}