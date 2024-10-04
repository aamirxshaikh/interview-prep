package com.interviewprep.oop_concepts.enum_types;

enum Gender {
  MALE {
    @Override
    public String getDescription() {
      return "Male Gender";
    }
  },

  FEMALE {
    @Override
    public String getDescription() {
      return "Female Gender";
    }
  },

  OTHER {
    @Override
    public String getDescription() {
      return "Other Gender";
    }
  };

  public abstract String getDescription();
}

public class EnumWithOverriddenMethods {
  public static void main(String[] args) {
    for (Gender gender : Gender.values()) {
      System.out.println(gender + ": " + gender.getDescription());
    }

    // Specific gender example
    Gender male = Gender.MALE;
    System.out.println("Selected gender: " + male + ", Description: " + male.getDescription());

    Gender female = Gender.FEMALE;
    System.out.println("Selected gender: " + female + ", Description: " + female.getDescription());
  }
}
