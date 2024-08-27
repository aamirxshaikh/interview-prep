package com.interviewprep.data_types_and_variables.reference_data_types;

/**
 * @author aamir on 8/26/24
 */
public class Person {
  private String name;
  private int age;

  Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
