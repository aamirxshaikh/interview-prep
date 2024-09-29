
package com.interviewprep.oop_concepts.class_and_object.object_class;

import java.util.Objects;

// Example class to demonstrate Object class methods
public class ObjectClassExample implements Cloneable {
  private final String name;
  private final int id;

  public ObjectClassExample(String name, int id) {
    this.name = name;
    this.id = id;
  }

  // Overriding equals method
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    ObjectClassExample other = (ObjectClassExample) obj;
    return id == other.id && name.equals(other.name);
  }

  // Overriding hashCode method
  @Override
  public int hashCode() {
    return Objects.hash(name, id);
  }

  // Overriding toString method
  @Override
  public String toString() {
    return "ObjectClassExample{name='" + name + "', id=" + id + "}";
  }

  // Implementing clone method
  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  // Deprecated finalize method (not recommended for use in newer Java versions)
  @Override
  protected void finalize() throws Throwable {
    System.out.println("Finalize method called");
    super.finalize();
  }

  public static void main(String[] args) throws CloneNotSupportedException {
    ObjectClassExample obj1 = new ObjectClassExample("John", 101);
    ObjectClassExample obj2 = (ObjectClassExample) obj1.clone();

    System.out.println("obj1 equals obj2: " + obj1.equals(obj2));
    System.out.println("obj1 hashCode: " + obj1.hashCode());
    System.out.println("obj1 toString: " + obj1.toString());

    obj1 = null;  // Make object eligible for garbage collection

    // Suggest garbage collection
    System.gc();
  }
}
