package com.interviewprep.oop_concepts.enum_types;

public enum EnumWithConstructorsFieldsMethods {
  MALE("Male"),
  FEMALE("Female"),
  OTHER("Other");

  private final String genderType;

  EnumWithConstructorsFieldsMethods(String genderType) {
    this.genderType = genderType;
  }

  public String getGenderType() {
    return genderType;
  }
}