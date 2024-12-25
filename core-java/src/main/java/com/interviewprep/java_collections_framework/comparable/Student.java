package com.interviewprep.java_collections_framework.comparable;

import java.util.Objects;

public class Student implements Comparable<Student> {
  private final String name;
  private final int age;

  public Student(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  @Override
  public String toString() {
    return "Student{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return age == student.age && Objects.equals(name, student.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age);
  }

  /**
   * Sorts the students by age.
   *
   * @param student the object to be compared.
   * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
   */
  @Override
  public int compareTo(Student student) {
    return Integer.compare(this.age, student.age);
  }
}
