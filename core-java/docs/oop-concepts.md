# [Object-Oriented Programming (OOP) Concepts](https://github.com/aamirxshaikh/interview-prep/tree/main/core-java/src/main/java/com/interviewprep/oop_concepts)

## 1. Class and Object

### Defining a Class and Creating Objects

- **Class**: A blueprint for creating objects, containing variables (attributes) and methods (functions).
- **Object**: An instance of a class.

**Example:**

```java
class Car {
  String model;
  int year;

  void start() {
    System.out.println("Car is starting");
  }
}

public class Main {
  public static void main(String[] args) {
    Car myCar = new Car(); // Creating an object
    myCar.model = "Tesla";
    myCar.year = 2024;
    myCar.start();
  }
}
```

### Constructors and Initialization Blocks

- **Constructor**: A special method invoked when an object is created. It initializes the object.

- **Example:**

```java
class Car {
  String model;
  int year;

  Car(String model, int year) {
    this.model = model;
    this.year = year;
  }
}
```

- **Initialization Blocks**: Used to initialize instance variables.

**Example:**

```java
class Car {
  String model;
  int year;

  {
    model = "Default Model";
    year = 2024;
  }
}
```

### `this` Keyword

- Refers to the current object instance.
- Used to avoid naming conflicts and to pass the current object as a parameter.

**Example:**

```java
class Car {
  String model;
  int year;

  Car(String model, int year) {
    this.model = model;
    this.year = year;
  }
}
```

### Static Context in OOP

#### Accessing Static Members

- Static members belong to the class rather than any object.
- Can be accessed directly using the class name.

**Example:**

```java
class Car {
  static int numberOfCars;

  Car() {
    numberOfCars++;
  }
}

public class Main {
  public static void main(String[] args) {
    System.out.println("Cars created: " + Car.numberOfCars);
  }
}
```

#### Restrictions in Static Context

- **Cannot** access instance (non-static) members directly.
- **Cannot** use `this` or `super` keywords.

**Example:**

```java
class Car {
  int speed;
  static int numberOfCars;

  static void display() {
    // System.out.println(speed); // Error: Cannot make a static reference to the non-static field speed
  }
}
```

#### Static vs. Instance Context

- **Static**: Belongs to the class.
- **Instance**: Belongs to an object.

**Example:**

```java
class Car {
  static int numberOfCars;
  int speed;

  static void displayNumberOfCars() {
    System.out.println("Number of cars: " + numberOfCars);
  }

  void displaySpeed() {
    System.out.println("Speed: " + speed);
  }
}
```

#### Method Hiding

Method hiding in Java occurs when a subclass defines a static method with the same name and signature as a static method
in its superclass. Unlike method overriding, which involves instance methods and is resolved at runtime, method hiding
is determined at compile time based on the reference type. Here’s a detailed explanation of method hiding, its
characteristics, and how it differs from method overriding.

##### Definition of Method Hiding

When a subclass defines a static method that has the same name and parameters as a static method in its superclass, the
subclass's method hides the superclass's method. This means that if you call the static method using a reference of the
superclass type, the superclass's version will be executed, while if you call it using a reference of the subclass type,
the subclass's version will be executed.

##### Characteristics of Method Hiding

1. **Static Methods**: Method hiding only applies to static methods. Instance methods cannot hide static methods.

2. **Compile-Time Resolution**: The method to be called is determined at compile time based on the reference type, not
   at runtime based on the object type.

3. **No Polymorphism**: Unlike overriding, where polymorphism allows for dynamic method resolution, method hiding does
   not exhibit polymorphic behavior.

**Example:**

```java
class Parent {
  public static void display() {
    System.out.println("Static method in Parent class");
  }
}

class Child extends Parent {
  public static void display() {
    System.out.println("Static method in Child class");
  }
}

public class Main {
  public static void main(String[] args) {
    Parent parent = new Parent();
    Parent childAsParent = new Child(); // Reference of Parent type pointing to Child object
    Child child = new Child();

    // Calling static methods
    parent.display(); // Output: Static method in Parent class
    childAsParent.display(); // Output: Static method in Parent class (method hiding)
    child.display(); // Output: Static method in Child class
  }
}
```

### Nested Classes and Static Classes

In Java, classes can be nested within other classes. Nested classes are divided into two categories:

1. **Inner Classes (Non-static Nested Classes)**
2. **Static Nested Classes**

#### Inner Classes (Non-static Nested Classes)

An inner class is a class defined within another class that is not declared as `static`. Inner classes have access to
all members (including private members) of the outer class. However, an inner class is associated with an instance of
the outer class, meaning it cannot exist independently of an instance of the outer class.

##### Types of Inner Classes

1. **Member Inner Class**: A non-static class defined directly within another class.
2. **Local Inner Class**: A class defined within a method or a block of code.
3. **Anonymous Inner Class**: A class defined on the fly without a name, often used for implementing interfaces or
   extending classes.

##### Example of Member Inner Class

```java
class OuterClass {
  private String outerField = "Outer Field";

  class InnerClass {
    void display() {
      System.out.println("Accessing from InnerClass: " + outerField);
    }
  }

  void createInnerInstance() {
    InnerClass inner = new InnerClass();
    inner.display();
  }
}

public class Main {
  public static void main(String[] args) {
    OuterClass outer = new OuterClass();
    outer.createInnerInstance();
  }
}
```

##### Example of Local Inner Class

```java
class OuterClass {
  void outerMethod() {
    class LocalInnerClass {
      void display() {
        System.out.println("Inside Local Inner Class");
      }
    }

    LocalInnerClass localInner = new LocalInnerClass();
    localInner.display();
  }
}

public class Main {
  public static void main(String[] args) {
    OuterClass outer = new OuterClass();
    outer.outerMethod();
  }
}
```

##### Example of Anonymous Inner Class

```java
abstract class Animal {
  abstract void sound();
}

public class Main {
  public static void main(String[] args) {
    Animal dog = new Animal() {
      void sound() {
        System.out.println("Bark");
      }
    };
    dog.sound();
  }
}
```

##### Characteristics of Inner Classes

- Inner classes have access to the members of the outer class, including private members.
- Inner classes are tied to an instance of the outer class.
- They can be used to logically group classes that are only used in one place.
- They can lead to more readable and maintainable code by keeping related classes together.

#### Static Nested Classes

A static nested class is a class defined within another class with the static modifier. Unlike inner classes, a `static`
nested class does not have access to the instance variables and methods of the outer class. It behaves like any other
top-level class but is logically grouped with its outer class.

##### Example of Static Nested Class

```java
class OuterClass {
  private static String staticOuterField = "Static Outer Field";

  static class StaticNestedClass {
    void display() {
      System.out.println("Accessing from StaticNestedClass: " + staticOuterField);
    }
  }
}

public class Main {
  public static void main(String[] args) {
    OuterClass.StaticNestedClass nested = new OuterClass.StaticNestedClass();
    nested.display();
  }
}
```

##### Characteristics of Static Nested Class

- Static nested classes do not have access to non-static members of the outer class.
- They can be instantiated without an instance of the outer class.
- They are used when the nested class does not need to access the outer class's instance members.
- Like top-level classes, they can contain static members.

### Object Class and Its Methods

#### equals() and hashCode()

- In Java, `equals()` and `hashCode()` are methods inherited from the `Object` class. They are fundamental for comparing
  objects and storing them efficiently in collections like `HashSet`, `HashMap`, and `Hashtable`.

##### `equals()` method

The `equals()` method is used to compare the equality of two objects. By default, the `equals()` method in the `Object`
class compares the memory addresses of objects (reference equality). However, in many cases, you want to compare the
actual data of objects (value equality), so you override this method to provide a custom equality check.

### Example:

```java
class Person {
  private String name;
  private int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  // Override equals() to compare based on name and age
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true; // If both references are the same
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false; // If obj is not the same type
    }
    Person person = (Person) obj;
    return age == person.age && name.equals(person.name);
  }
}

public class EqualsExample {
  public static void main(String[] args) {
    Person p1 = new Person("Alice", 25);
    Person p2 = new Person("Alice", 25);
    Person p3 = new Person("Bob", 30);

    System.out.println(p1.equals(p2)); // true
    System.out.println(p1.equals(p3)); // false
  }
}
```

### `hashCode()` Method

The `hashCode()` method returns an integer value (hash code) that represents the object. It is used in hashing-based
collections like `HashMap` and `HashSet` to determine the bucket location of the object. The general contract of
`hashCode()` is:

- If two objects are considered equal according to `equals()`, they **must** have the same `hashCode()`.
- If two objects are not equal, they may have different `hashCode()`, but it is not required.

The default implementation in `Object` class generates a hash code based on the memory address. For proper functioning
of hash-based collections, it is important to override both `equals()` and `hashCode()`.

### Example:

```java
class Person {
  private String name;
  private int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  // Override equals() for value-based equality
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Person person = (Person) obj;
    return age == person.age && name.equals(person.name);
  }

  // Override hashCode() to return a consistent hash value for equal objects
  @Override
  public int hashCode() {
    return Objects.hash(name, age); // Using the name and age to generate a hash code
  }
}

public class HashCodeExample {
  public static void main(String[] args) {
    Person p1 = new Person("Alice", 25);
    Person p2 = new Person("Alice", 25);
    Person p3 = new Person("Bob", 30);

    // Using HashSet to demonstrate hashCode's role
    Set<Person> set = new HashSet<>();
    set.add(p1);
    set.add(p2);
    set.add(p3);

    System.out.println("Set size: " + set.size()); // 2 (p1 and p2 are equal, p3 is different)
  }
}
```

#### toString()

- Provides a string representation of an object.
- Example:
  ```java
  @Override
  public String toString() {
      return "Car{" +
              "color='" + color + ''' +
              ", model='" + model + ''' +
              '}';
  }
  ```

#### clone() and Cloning in Java

- The `clone()` method is used to create a copy of an object. To use this method, the class must implement the
  `Cloneable` interface. By default, `clone()` performs a shallow copy.

- Example:

  Consider a class `Person` that has a reference to an `Address` object. A shallow copy of a `Person` object would
  create a new `Person` object but still reference the same `Address` object as the original.

  ```java
  class Address {
    String city;
    
    public Address(String city) {
        this.city = city;
    }
  }

  class Person implements Cloneable {
    String name;
    Address address;
  
    public Person(String name, Address address) {
      this.name = name;
      this.address = address;
    }
  
    @Override
    protected Object clone() throws CloneNotSupportedException {
      return super.clone(); // This performs a shallow copy
    }
  }
  
  public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
      Address address = new Address("Mumbai");
      Person original = new Person("Aamir", address);
  
      // Shallow copy
      Person shallowCopy = (Person) original.clone();
          
      // Modifying the address in shallowCopy
      shallowCopy.address.city = "Pune";
          
      System.out.println(original.address.city);  // Output: Pune
    }
  }
  ```

  In the above example, shallowCopy is a new `Person` object, but both original and shallowCopy share the same `Address`
  object. When the city field in shallowCopy is modified, it also affects the original object, because they both point
  to the same `Address` object in memory.

#### finalize() Method

- The `finalize()` method is called by the garbage collector before an object is reclaimed. It can be overridden to
  perform cleanup operations before the object is destroyed. However, its use is discouraged in modern Java due to
  unpredictability in garbage collection timing.

- Example:

  ```java
  class MyClass {
    // Override finalize to define cleanup logic
    @Override
    protected void finalize() throws Throwable {
      try {
        System.out.println("Finalize method called.");
      } finally {
        super.finalize();
      }
    }
  }
  
  public class Main {
    public static void main(String[] args) {
      MyClass obj = new MyClass();
      obj = null;  // Make object eligible for garbage collection
  
      // Suggest garbage collection
      System.gc();
  
      // Give time for the Garbage Collector to run (optional)
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  ```

## 2. Enum Types

Enums in Java are special data types that represent a collection of constants. They are implicitly `final` and `static`,
providing a way to group related values under one type.

### Defining an Enum

An `enum` is defined using the `enum` keyword. Each constant in an enum is a public static final instance of the enum
type.

```java
public enum Day {
  SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}
```

### Enum with Constructors, Fields, and Methods

Enums can have constructors, fields, and methods, making them more powerful than basic constants. The constructors are
always `private` or `default`.

```java
public enum Planet {
  MERCURY(3.303e+23, 2.4397e6),
  VENUS(4.869e+24, 6.0518e6),
  EARTH(5.976e+24, 6.37814e6);

  private final double mass;    // in kilograms
  private final double radius;  // in meters

  // Enum constructor
  Planet(double mass, double radius) {
    this.mass = mass;
    this.radius = radius;
  }

  public double getMass() {
    return mass;
  }

  public double getRadius() {
    return radius;
  }
}
```

### Using Enums in Switch Statements

Enums can be used in `switch` statements to control program flow based on specific enum values.

```java
Day day = Day.MONDAY;

switch (day) {
  case MONDAY:
    System.out.println("Start of the work week!");
    break;
    
  case FRIDAY:
    System.out.println("Almost weekend!");
    break;
    
  case SUNDAY:
    System.out.println("It's a rest day!");
    break;
  
  default:
    System.out.println("Midweek day.");
}
```

### Enum Constants as Static Final Fields

Each constant in an enum is implicitly `public`, `static`, and `final`. Therefore, enum constants are instances of the
enum type itself, and their values cannot be changed after being created.

```java
public enum TrafficSignal {
  RED, GREEN, YELLOW
}
```

Here, `TrafficSignal.RED`, `TrafficSignal.GREEN`, and `TrafficSignal.YELLOW` are static final fields.

### Iterating Over Enum Values

You can use the `values()` method to iterate over all the constants in an enum.

```java
for(Day day :Day.values()) {
  System.out.println(day);
}
```

### Enum with Overridden Methods

Enums can have methods, and you can override them for specific enum constants. This can be useful when different
behavior is needed for each constant.

```java
public enum Operation {
  PLUS {
    @Override
    public double apply(double x, double y) {
      return x + y;
    }
  },
  MINUS {
    @Override
    public double apply(double x, double y) {
      return x - y;
    }
  },
  MULTIPLY {
    @Override
    public double apply(double x, double y) {
      return x * y;
    }
  },
  DIVIDE {
    @Override
    public double apply(double x, double y) {
      return x / y;
    }
  };

  // Abstract method to be overridden
  public abstract double apply(double x, double y);
}
```

In this example, each enum constant overrides the `apply` method to perform different arithmetic operations.

## 3. Encapsulation

### Access Modifiers (private, public, protected, default)

- **private**: Accessible within the same class only.
- **public**: Accessible from any other class.
- **protected**: Accessible within the same package and subclasses.
- **default**: Accessible within the same package.

**Example:**

```java
class Car {
  private String model; // private
  public int year; // public

  private void start() {
    System.out.println("Car is starting");
  }
}
```

### Getters and Setters

- Used to access and update private variables.

**Example:**

```java
class Car {
  private String model;

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }
}
```

### Data Hiding

- Hiding the internal state of the object and requiring all interaction to be performed through methods.

**Example:**

```java
class Car {
  private String model;

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    if (model != null && !model.isEmpty()) {
      this.model = model;
    }
  }
}
```

### Immutable Classes

To create a fully immutable class in Java, you should follow a set of best practices that ensure the object's state
cannot be modified after it has been created. Below are the detailed steps and an example demonstrating how to implement
an immutable class.

#### Steps to Create an Immutable Class

1. **Declare the Class as Final**: This prevents subclasses from modifying the behavior of the class.

2. **Declare All Fields as Private and Final**: This ensures that the fields cannot be accessed directly from outside
   the class and cannot be changed once initialized.

3. **Initialize All Fields in the Constructor**: All fields should be assigned values through a constructor, ensuring
   that they are set when the object is created.

4. **Do Not Provide Setter Methods**: To maintain immutability, do not provide any methods that would allow modification
   of the fields.

5. **Defensive Copies for Mutable Objects**: If your class contains fields that are mutable objects (like arrays or
   collections), ensure that you create defensive copies of these objects in both the constructor and any getter
   methods. This prevents external code from modifying the internal state.

- Example:
  ```java
  final class Address {
    private final String city;
    private final String state;

    public Address(String city, String state) {
      this.city = city;
      this.state = state;
    }

    public String getCity() {
      return city;
    }

    public String getState() {
      return state;
    }
  }

  final class Person {
    private final String name;
    private final int age;
    private final Address address;

    public Person(String name, int age, Address address) {
      this.name = name;
        this.age = age;
        // Create a defensive copy of Address
        this.address = new Address(address.getCity(), address.getState());
    }

    public String getName() {
      return name;
    }

    public int getAge() {
      return age;
    }

    public Address getAddress() {
      // Return a defensive copy of Address
      return new Address(address.getCity(), address.getState());
    }
  }

  public class Main {
    public static void main(String[] args) {
      Address address = new Address("New York", "NY");
      Person person1 = new Person("John", 30, address);

      // Displaying original data
      System.out.println(person1.getName()); // Output: John
      System.out.println(person1.getAddress().getCity()); // Output: New York

      // Attempting to modify the address will not affect person1
      Address address2 = person1.getAddress();
      System.out.println(address2.getCity()); // Output: New York
      // address2.setCity("San Francisco"); // This line would cause a compilation error if set methods existed

      // Modifying address2 does not affect person1's address
      System.out.println(person1.getAddress().getCity()); // Output: New York
    }
  }
  ```

- Benefits of Immutability
    - **Thread-Safety**: Immutable objects are inherently thread-safe since their state cannot change after creation.
    - **Simplicity**: They simplify reasoning about code since you can be sure that once created, their state cannot
      change.
    - **Caching and Performance**: Immutable objects can be cached and reused without concern for their state changing
      unexpectedly.

## 4. Inheritance

### Single Inheritance

- A class inherits from one superclass.

**Example:**

```java
class Vehicle {
  String brand;

  void honk() {
    System.out.println("Honk! Honk!");
  }
}

class Car extends Vehicle {
  String model;
}
```

### Multilevel Inheritance

- A class is derived from a class that is also derived from another class.

**Example:**

```java
class Vehicle {
  String brand;
}

class Car extends Vehicle {
  String model;
}

class ElectricCar extends Car {
  int batteryCapacity;
}
```

### Method Overriding

- Subclass provides a specific implementation of a method already defined in its superclass.

**Example:**

```java
class Vehicle {
  void honk() {
    System.out.println("Honk! Honk!");
  }
}

class Car extends Vehicle {
  @Override
  void honk() {
    System.out.println("Car is honking!");
  }
}
```

### `super` Keyword

- Refers to the superclass of the object and is used to access superclass methods and constructors.

**Example:**

```java
class Vehicle {
  String brand = "Ford";

  void displayBrand() {
    System.out.println("Brand: " + brand);
  }
}

class Car extends Vehicle {
  String brand = "Tesla";

  void displayBrand() {
    super.displayBrand(); // Calls superclass method
    System.out.println("Car Brand: " + brand);
  }
}
```

### Hierarchical Inheritance

- Inheritance with Multiple Subclasses
    - Multiple subclasses inherit from a single parent class.
    - Allows for specialization of common properties and behaviors.

**Example:**

```java
class Vehicle {
  String brand;

  void start() {
    System.out.println("Vehicle starting");
  }
}

class Car extends Vehicle {
  int numberOfDoors;
}

class Motorcycle extends Vehicle {
  boolean hasSidecar;
}

class Truck extends Vehicle {
  int cargoCapacity;
}
```

### Composition vs. Inheritance

- When to Use Composition Over Inheritance
    - Use composition to reuse code when inheritance does not model a true "is-a" relationship.
    - You need more flexibility in your design.
    - You want to avoid the limitations of single inheritance.

**Example:**

```java
class Engine {
  void start() {
    System.out.println("Engine starting");
  }
}

class Car {
  private Engine engine;

  Car() {
    this.engine = new Engine();
  }

  void startCar() {
    engine.start();
    System.out.println("Car is ready to go");
  }
}
```

In this example, a `Car` has an `Engine` (composition) instead of being an `Engine` (inheritance).

## 5. Polymorphism

### Compile-Time Polymorphism (Method Overloading)

- Multiple methods in the same class with the same name but different parameters.

**Example:**

```java
class Calculator {
  int add(int a, int b) {
    return a + b;
  }

  double add(double a, double b) {
    return a + b;
  }
}
```

### Runtime Polymorphism (Method Overriding)

- Subclass provides a specific implementation of a method that is already defined in its superclass.

**Example:**

```java
class Animal {
  void sound() {
    System.out.println("Animal makes a sound");
  }
}

class Dog extends Animal {
  @Override
  void sound() {
    System.out.println("Dog barks");
  }
}
```

### Covariant Return Types

- Method Overriding with Covariant Return Types.
    - Allows an overriding method to return a subtype of the return type declared in the superclass method.
    - Introduced in Java 5 to provide more type-specific return values.

**Example:**

```java
class Animal {
  Animal reproduce() {
    return new Animal();
  }
}

class Dog extends Animal {
  @Override
  Dog reproduce() {  // Covariant return type
    return new Dog();
  }
}
```

In this example, `Dog.reproduce()` returns a `Dog` instead of an `Animal`, which is more specific and type-safe.

## 6. Abstraction

### Abstract Classes and Methods

- **Abstract Class**: An abstract class in Java is a class that cannot be instantiated on its own and may contain
  abstract methods (methods without implementation) and/or concrete methods (methods with implementation).
- **Abstract Method**: A method without implementation.

**Example:**

```java
abstract class Animal {
  abstract void sound();

  void eat() {
    System.out.println("Animal is eating");
  }
}

class Dog extends Animal {
  @Override
  void sound() {
    System.out.println("Dog barks");
  }
}
```

### Characteristics of an Abstract Class

1. **Cannot be instantiated:**
    - You cannot create an instance of an abstract class using the `new` keyword. Abstract classes are meant to be
      inherited by other classes.
    - Example:
      ```java
      public abstract class Animal {
          public abstract void makeSound(); // Abstract method
          public void sleep() {
              System.out.println("Sleeping..."); // Concrete method
          }
      }
      ```

2. **May have abstract methods:**
    - Abstract methods don’t have an implementation in the abstract class. The concrete (non-abstract) subclasses are
      required to implement these methods.
    - Example:
      ```java
      public abstract void makeSound(); // No implementation
      ```

3. **Can have concrete methods:**
    - Abstract classes can have fully implemented methods (concrete methods), and subclasses can optionally override
      them.
    - Example:
      ```java
      public void sleep() {
          System.out.println("Sleeping...");
      }
      ```

4. **Can have constructors:**
    - Abstract classes can have constructors, but these constructors are called when a subclass is instantiated, not the
      abstract class itself.
    - Example:
      ```java
      public abstract class Animal {
          public Animal() {
              System.out.println("Animal constructor called");
          }
      }
      ```

5. **Can have member variables:**
    - Unlike interfaces (before Java 8), abstract classes can have instance variables and static fields. These variables
      can be private, protected, or public.
    - Example:
      ```java
      public abstract class Animal {
          protected String name;
      }
      ```

6. **Can have access modifiers:**
    - Abstract classes can define methods and variables with any access modifier (private, protected, public, etc.).
      This provides more flexibility in controlling access to its members.

7. **Single inheritance:**
    - In Java, a class can inherit only one abstract class. This is due to Java’s single inheritance model. However, an
      abstract class can implement multiple interfaces.

### What You Can and Cannot Do with Abstract Classes

- **You Can:**
    - Extend an abstract class.
    - Define both abstract and non-abstract methods.
    - Have fields, constructors, and access modifiers (private, protected, public).
    - Use static methods and fields.

- **You Cannot:**
    - Instantiate an abstract class directly.
    - Have abstract methods without marking the class as `abstract`.

### Interfaces and Multiple Inheritance

- **Interface**: An interface in Java is a completely abstract class (before Java 8) that defines a contract or
  blueprint for behavior that implementing classes must follow. Since Java 8, interfaces can contain default methods (
  with implementation) and static methods.
- Java supports multiple inheritance through interfaces.

**Example:**

```java
interface Animal {
  void sound();
}

interface Pet {
  void play();
}

class Dog implements Animal, Pet {
  @Override
  public void sound() {
    System.out.println("Dog barks");
  }

  @Override
  public void play() {
    System.out.println("Dog is playing");
  }
}
```

### Characteristics of an Interface

1. **Cannot be instantiated:**
    - Like abstract classes, interfaces cannot be instantiated. They must be implemented by concrete classes.

2. **All methods were abstract (before Java 8):**
    - Before Java 8, all methods in an interface were abstract and public by default. Implementing classes were required
      to provide implementations for all interface methods.
    - Example (pre-Java 8):
      ```java
      public interface Animal {
          void makeSound(); // Abstract by default
      }
      ```

3. **Default methods (since Java 8):**
    - Java 8 introduced default methods in interfaces, allowing interfaces to have method implementations. This provided
      more flexibility and backward compatibility without breaking existing code.
    - Example:
      ```java
      public interface Animal {
          default void sleep() {
              System.out.println("Sleeping...");
          }
      }
      ```

4. **Static methods (since Java 8):**
    - Interfaces can also have static methods that can be called independently of any instance of the class implementing
      the interface.
    - Example:
      ```java
      public interface Animal {
          static void showInfo() {
              System.out.println("This is an animal interface.");
          }
      }
      ```

5. **No constructors:**
    - Interfaces cannot have constructors because they cannot be instantiated. All methods within an interface are
      essentially "blueprints" for behavior.

6. **Can contain constants:**
    - All fields in an interface are `public`, `static`, and `final` by default, meaning that any variable declared in
      an interface is essentially a constant.
    - Example:
      ```java
      public interface Animal {
          int LIFESPAN = 10; // Public, static, and final by default
      }
      ```

7. **Multiple inheritance (through interfaces):**
    - Unlike abstract classes, interfaces support multiple inheritance. A class can implement multiple interfaces,
      enabling the use of polymorphism in Java.
    - Example:
      ```java
      public class Dog implements Animal, Mammal {
          // Implement methods from both interfaces
      }
      ```

8. **No instance variables:**
    - Interfaces cannot have instance variables. Any fields are implicitly `public`, `static`, and `final`, meaning they
      must be constants.

### What You Can and Cannot Do with Interfaces

- **You Can:**
    - Implement multiple interfaces in a class.
    - Define abstract methods (implicitly public and abstract).
    - Use default and static methods (since Java 8).
    - Have constant fields (implicitly public, static, and final).

- **You Cannot:**
    - Have instance variables or constructors.
    - Have methods with any access modifier other than `public` (for abstract methods).
    - Directly instantiate an interface.

### Comparison: Abstract Class vs Interface

| Feature          | Abstract Class                                                    | Interface                                                                   |
|------------------|-------------------------------------------------------------------|-----------------------------------------------------------------------------|
| Instantiation    | Cannot be instantiated                                            | Cannot be instantiated                                                      |
| Method Types     | Can have both abstract and concrete methods                       | Can have abstract, default, and static methods                              |
| Variables        | Can have instance variables                                       | Can only have constants (public, static, final)                             |
| Constructors     | Can have constructors                                             | Cannot have constructors                                                    |
| Inheritance      | Can extend only one class (single inheritance)                    | Can implement multiple interfaces (multiple inheritance)                    |
| Access Modifiers | Can have any access modifier (private, protected, public)         | Methods are public by default                                               |
| Usage            | Best for classes that are closely related and share some behavior | Best for defining a contract for unrelated classes                          |
| State (Fields)   | Can maintain state through instance variables                     | Cannot maintain state; only defines behavior                                |
| Default Methods  | Not allowed (methods need explicit implementation)                | Allowed (since Java 8)                                                      |
| Static Methods   | Can have static methods                                           | Can have static methods (since Java 8)                                      |
| Performance      | Slightly faster than interfaces (direct inheritance)              | Interfaces might have a small performance overhead due to method resolution |

### When to Use Abstract Classes vs Interfaces

- **Use an abstract class**:
    - When you want to share code among closely related classes.
    - When you want to provide default behavior that subclasses can inherit or override.
    - When you want to define state (instance variables).
    - When you expect to add more methods in the future and do not want to break existing classes (since adding new
      methods to interfaces can break classes implementing them).

- **Use an interface**:
    - When you want to define a contract for unrelated classes.
    - When you want to take advantage of multiple inheritance.
    - When you only need to define behavior and not state.
    - When you want to ensure that a class implements specific methods (e.g., `Comparable`, `Runnable`).

---

# Interview Questions

## 1. Class and Object

### 1.1 Defining a Class and Creating Objects

#### 1.1.1. What is a class in Java, and how is it different from an object?

A class in Java is a blueprint for creating objects. It defines properties (fields) and behaviors (methods) that the
objects created from the class will have. An object is an instance of a class, representing a concrete entity with state
and behavior defined by the class.

#### 1.1.2. How do you define a class in Java?

A class in Java is defined using the `class` keyword followed by the class name, as in the following example:

```java
public class Car {
  // Fields and methods
}
```

#### 1.1.3. How do you create an object of a class?

An object is created using the `new` keyword followed by the constructor of the class, like this:

```java
Car myCar = new Car();
```

#### 1.1.4. Can you explain the process of memory allocation when an object is created?

When an object is created, memory is allocated on the heap for the object's instance variables, and the reference to
this object is stored in the stack. The object's methods are stored in the method area.

#### 1.1.5. What is the significance of a constructor in object creation?

A constructor initializes the newly created object. It sets up the initial state of the object by assigning values to
its fields or executing other initialization logic.

#### 1.1.6. How can you create an anonymous object in Java, and when would you use it?

An anonymous object is an object that is created but not assigned to a reference variable. It is typically used when the
object is needed for a single operation:

```java
new Car().start();
```

#### 1.1.7. Can a class be defined inside another class in Java? What are inner classes?

Yes, a class can be defined inside another class, and such a class is called an inner class. Inner classes are
categorized into member inner classes, static nested classes, local inner classes, and anonymous inner classes.

### 1.2 Constructors and Initialization Blocks

#### 1.2.1. What is a constructor in Java, and how is it different from a method?

A constructor is a special type of method that is called when an object is created. Unlike regular methods, constructors
do not have a return type, and their name must match the class name.

#### 1.2.2. How do you define a constructor in a class?

A constructor is defined with the same name as the class and no return type:

```java
public class Car {
  public Car() {
    // Initialization code
  }
}
```

#### 1.2.3. What is a default constructor, and when is it provided by the compiler?

A default constructor is a no-argument constructor that is automatically provided by the compiler if no constructors are
explicitly defined in the class.

#### 1.2.4. Can you explain the use of initialization blocks in Java?

Initialization blocks are blocks of code that are executed when an object is created. They are used for common
initialization code that needs to be executed regardless of which constructor is used.

#### 1.2.5. How do initialization blocks differ from constructors?

Initialization blocks are executed before the constructor and can be used to share common initialization logic across
all constructors. Constructors, on the other hand, are specific to the object creation process.

#### 1.2.6. What is a copy constructor, and how do you implement it in Java?

A copy constructor creates a new object as a copy of an existing object. It can be implemented by passing an object of
the same class as a parameter:

```java
public Car(Car otherCar) {
  this.model = otherCar.model;
}
```

#### 1.2.7. Can constructors be overloaded? Provide examples.

Yes, constructors can be overloaded by defining multiple constructors with different parameter lists:

```java
public Car() {
}

public Car(String model) {
  this.model = model;
}
```

#### 1.2.8. How does constructor chaining work in Java?

Constructor chaining is the process of calling one constructor from another using `this()` for constructors within the
same class or `super()` for constructors in the superclass.

### 1.3 this Keyword

#### 1.3.1. What is the `this` keyword in Java, and when would you use it?

The `this` keyword refers to the current instance of the class. It is used to avoid naming conflicts, to pass the
current object as a parameter, or to call constructors within the same class.

#### 1.3.2. How does `this` help in resolving naming conflicts within a class?

When a method parameter has the same name as a class field, `this` is used to differentiate between the field and the
parameter:

```java
public Car(String model) {
  this.model = model;  // 'this.model' refers to the class field
}
```

#### 1.3.3. Can you explain how `this` can be used to call another constructor within the same class?

The `this()` keyword can be used to call another constructor from within a constructor:

```java
public Car() {
  this("defaultModel");  // Calls another constructor with a parameter
}
```

#### 1.3.4. How would you pass the current object as an argument to a method using `this`?

You can pass the current object as an argument using `this`:

```java
public void showDetails(Car car) {
  car.print();
}

public void display() {
  showDetails(this);  // Passing the current object
}
```

#### 1.3.5. Can `this` be used in a static method? Why or why not?

No, `this` cannot be used in a static method because `this` refers to the current object, and static methods belong to
the class, not to any specific object.

### 1.4 Static Context in OOP

### 1.4.1 Accessing Static Members

##### 1.4.1.1. What are static members in Java, and how do they differ from instance members?

Static members (variables and methods) belong to the class itself rather than any particular instance of the class. This
means all instances of the class share the same static members. In contrast, instance members are tied to individual
objects and every instance has its own copy.

##### 1.4.1.2. How do you access static variables and methods within a class?

Static variables and methods can be accessed using the class name itself (e.g., `ClassName.staticMethod()`), and they
can also be accessed directly within the class without needing to instantiate an object.

##### 1.4.1.3. Can static methods be overridden in Java? Why or why not?

No, static methods cannot be overridden in Java. They are bound to the class, not instances, and overriding applies to
instance methods. Instead, static methods can be hidden by redefining them in a subclass.

##### 1.4.1.4. How are static blocks different from static methods?

Static blocks are executed when the class is loaded, and they are used to initialize static variables. Static methods,
on the other hand, are invoked explicitly to perform actions and are not tied to class loading.

### 1.4.2 Restrictions in Static Context

##### 1.4.2.1. What are the restrictions of using static methods in Java?

- Static methods cannot access instance variables or instance methods directly.
- They cannot use `this` or `super` keywords.
- They can only directly access other static members (variables, methods).

##### 1.4.2.2. Why can't you use `this` or `super` in a static context?

`this` refers to the current object, and `super` refers to the parent class’s object. Since static methods are not tied
to any specific instance of the class, using `this` or `super` is meaningless and thus not allowed.

##### 1.4.2.3. Can a static method access instance variables? Explain your answer.

No, a static method cannot directly access instance variables because they belong to a specific instance of the class,
and static methods do not operate on any instance.

##### 1.4.2.4. Why can't you declare abstract static methods in Java?

Abstract methods are meant to be overridden by subclasses, and static methods cannot be overridden, only hidden. Hence,
a method cannot be both abstract and static.

### 1.4.3 Static vs. Instance Context

##### 1.4.3.1. What is the difference between a static context and an instance context in Java?

A static context relates to the class itself, whereas an instance context refers to a specific object of that class.
Static members are shared across all instances, while instance members are unique to each object.

##### 1.4.3.2. How does memory allocation differ for static and instance members?

Static members are stored in the static memory area and are loaded once when the class is loaded. Instance members are
stored in the heap memory, and every object gets its own copy.

##### 1.4.3.3. When would you prefer to use static methods over instance methods?

Static methods are preferred when you don’t need to work with object-specific data, such as utility or helper methods
that perform general tasks (e.g., `Math.sqrt()` or `Arrays.sort()`).

##### 1.4.3.4. What are some common use cases for static methods in utility classes?

- Utility classes like `Math`, `Collections`, `Arrays`, and `Objects` often use static methods.
- Factory methods are often static.
- Methods that do not modify class or instance state, such as conversions or validations.

### 1.4.4 Method Hiding

##### 1.4.4.1. Explain the concept of method hiding and how it differs from method overriding.

Method hiding occurs when a static method in a subclass has the same signature as a static method in its superclass.
Unlike overriding, the method to be executed is determined by the class reference, not the object.

##### 1.4.4.2. Explain how Java resolves method calls when both superclass and subclass have static methods with the same name.

Java resolves the method call based on the reference type. If the reference is of the superclass, the superclass’s
static method is called, even if the object is of the subclass.

##### 1.4.4.3. Discuss whether polymorphism applies to method hiding and why.

Polymorphism does not apply to static methods because they are not tied to object instances but to classes. Method
hiding is resolved at compile time, while polymorphism (overriding) is resolved at runtime.

##### 1.4.4.4. Suggest best practices to differentiate between when to use overriding versus hiding, particularly for developers new to Java.

- Use overriding for instance methods when the behavior needs to be different for subclasses.
- Avoid hiding static methods unless there's a specific need to redefine a static method in a subclass.
- Use static methods in classes where behavior is general and does not depend on object state.

### 1.5 Nested Classes and Static Classes

### 1.5.1 Inner Classes (Non-static Nested Classes)

##### 1.5.1.1. What is an inner class in Java, and how does it differ from a static nested class?

An inner class is a class defined within another class without using the `static` modifier, allowing it to access the
outer class's instance members. A static nested class, on the other hand, cannot access instance members of the outer
class without an explicit reference.

##### 1.5.1.2. How do you define an inner class in Java?

An inner class is defined inside another class using the `class` keyword, but without the `static` modifier.

##### 1.5.1.3. What are the different types of inner classes in Java?

The four types of inner classes in Java are: member inner classes, local inner classes, anonymous inner classes, and
static nested classes.

##### 1.5.1.4. Can you explain the difference between member inner classes, local inner classes, and anonymous inner classes?

- Member inner classes are non-static classes defined at the member level of the outer class.
- Local inner classes are defined within a method or block.
- Anonymous inner classes are inner classes without a class name, defined and instantiated at the same time.

##### 1.5.1.5. How does an inner class access the members of its outer class?

An inner class can directly access both the static and non-static members of the outer class, including private members.

##### 1.5.1.6. Provide an example of when to use an inner class.

Inner classes are useful when they logically belong to the outer class and are tightly coupled with the outer class’s
members, such as for event handling or encapsulating helper logic.

##### 1.5.1.7. What are the limitations or challenges of using inner classes?

Inner classes can lead to increased complexity and tightly coupled code, which may be harder to maintain. They also
require an instance of the outer class to be instantiated, which could be restrictive.

### 1.5.2 Static Nested Classes

#### 1.5.2.1. What is a static nested class in Java?

A static nested class is a nested class declared with the `static` modifier. It can access the outer class's static
members but cannot directly access the instance members of the outer class.

#### 1.5.2.2. How does a static nested class differ from an inner class?

Unlike inner classes, static nested classes are not tied to an instance of the outer class and can be instantiated
independently.

#### 1.5.2.3. Can you provide an example of a static nested class?

```java
class OuterClass {
  static class StaticNestedClass {
    void display() {
      System.out.println("Inside static nested class");
    }
  }
}
```

#### 1.5.2.4. How do static nested classes interact with the outer class's static members?

Static nested classes can access the outer class's static members directly without needing an instance of the outer
class.

#### 1.5.2.5. What are the benefits of using a static nested class?

Static nested classes reduce memory overhead since they do not require an instance of the outer class. They are useful
for grouping related classes that are only used within the outer class.

#### 1.5.2.6. When would you choose a static nested class over an inner class?

You would use a static nested class when the nested class does not require access to instance members of the outer
class, especially in scenarios where the nested class is utility-based.

### 1.6 Object Class and Its Methods

### 1.6.1 equals() and hashCode()

#### 1.6.1.1. What is the purpose of the `equals()` method in Java?

The `equals()` method is used to check whether two objects are meaningfully equivalent, comparing their values instead
of their memory references.

#### 1.6.1.2. How does the `equals()` method differ from the `==` operator?

The `==` operator checks for reference equality, meaning whether two object references point to the same memory
location, while `equals()` checks for value equality.

#### 1.6.1.3. Why is it important to override `hashCode()` when overriding `equals()`?

The `hashCode()` method ensures that equal objects must have the same hash code for them to work correctly in hash-based
collections like `HashMap` and `HashSet`.

#### 1.6.1.4. Can you explain the contract between `equals()` and `hashCode()`?

If two objects are equal according to the `equals()` method, then their hash codes must also be equal. However, two
objects having the same hash code does not necessarily imply that they are equal.

#### 1.6.1.5. What are the potential issues if `equals()` and `hashCode()` are not overridden properly?

If not overridden properly, objects may behave unexpectedly in collections such as `HashMap`, leading to incorrect
results when comparing or storing objects.

#### 1.6.1.6. How would you implement a custom `equals()` and `hashCode()` method for a complex object?

A custom implementation should ensure that all significant fields that contribute to equality are checked in both
methods. You can use `Objects.equals()` and `Objects.hash()` for simplicity.

### 1.6.2 toString()

#### 1.6.2.1. What is the purpose of the `toString()` method in Java?

The `toString()` method returns a string representation of an object, which can be used for debugging, logging, or
displaying meaningful information about the object.

#### 1.6.2.2. How does overriding `toString()` benefit your code?

Overriding `toString()` allows you to provide a more readable and useful string representation of your object’s state,
which can assist in debugging and logging.

#### 1.6.2.3. Provide an example of how `toString()` is used in logging and debugging.

In logging frameworks, `toString()` is often called to include object details in log entries. For example:

```java
System.out.println("Object details: "+obj);
```

#### 1.6.2.4. How does the default `toString()` implementation work for an object?

The default implementation returns the class name followed by the object’s hash code in hexadecimal form, which is often
not very informative.

#### 1.6.2.5. How would you design a `toString()` method to avoid exposing sensitive information?

When overriding `toString()`, be cautious about including fields that may contain sensitive data like passwords or
security tokens. Only include non-sensitive fields that provide meaningful insight.

### 1.6.3 clone() and Cloning in Java

#### 1.6.3.1. What is cloning in Java, and how do you achieve it?

Cloning creates a new instance of an object that is a copy of the original. This is typically achieved using the
`clone()` method from the `Object` class.

#### 1.6.3.2. What is the difference between a shallow copy and a deep copy?

- A shallow copy copies an object’s reference types as references, meaning both the original and the copy will point to
  the same objects.
- A deep copy creates completely independent copies of reference types, so changes to one object do not affect the
  other.

#### 1.6.3.3. What is the purpose of the `Cloneable` interface?

The `Cloneable` interface serves as a marker interface indicating that a class can be cloned using the `clone()` method.

#### 1.6.3.4. Can you explain the `clone()` method and when to override it?

The `clone()` method creates a shallow copy of an object by default. You should override it if you need custom cloning
behavior, such as implementing a deep copy.

#### 1.6.3.5. What are the challenges and pitfalls of implementing the `clone()` method?

Cloning can be complex due to the need to handle mutable fields correctly, especially when dealing with deep copies,
inheritance hierarchies, and classes without `Cloneable`.

#### 1.6.3.6. How would you implement deep cloning in Java without using the `Cloneable` interface?

To implement deep cloning in Java without using the `Cloneable` interface, you can utilize a copy constructor or
serialization. A copy constructor allows you to create a new instance of a class by passing an existing instance,
copying all mutable fields manually. For example, in an `Employee` class, you would define a constructor that takes
another `Employee` object and initializes the new object's fields accordingly. Alternatively, if your class implements
`Serializable`, you can achieve deep cloning by serializing the object to a byte stream and then deserializing it back
to create a completely independent copy. This method is straightforward but may incur performance overhead due to the
serialization process.

### 1.6.4 finalize() Method

#### 1.6.4.1. What is the `finalize()` method in Java?

The `finalize()` method is called by the garbage collector before an object is removed from memory, allowing resource
cleanup, such as closing files or releasing system resources.

#### 1.6.4.2. Why is the `finalize()` method considered deprecated or unreliable in modern Java?

The `finalize()` method is unreliable because it may not be called at all or may be called too late, leading to resource
leaks. Java 9 introduced alternatives such as `AutoCloseable` and `try-with-resources`.

#### 1.6.4.3. How does garbage collection work in relation to `finalize()`?

When the garbage collector determines that an object is no longer reachable, it calls the `finalize()` method, but there
is no guarantee on when or if it will be called.

#### 1.6.4.4. Can you manually call the `finalize()` method? What are the implications?

You can call `finalize()` manually, but this is not recommended because it bypasses the garbage collector’s normal
process and can lead to unpredictable behavior.

#### 1.6.4.5. What are alternatives to using the `finalize()` method for resource cleanup?

Modern alternatives include implementing the `AutoCloseable` interface and using the `try-with-resources` statement,
which ensures that resources are closed automatically.

## 2. Encapsulation

### 2.1 Access Modifiers (private, public, protected, default)

#### 2.1.1. What are access modifiers in Java, and why are they important?

Access modifiers in Java control the visibility of classes, methods, and variables. They are important as they enforce
encapsulation, restricting access to the internal workings of a class, thus protecting data integrity and promoting
maintainability.

#### 2.1.1. Can you explain the difference between `private`, `public`, `protected`, and default access?

- `private`: The member is accessible only within the same class.
- `public`: The member is accessible from any class.
- `protected`: The member is accessible within the same package and subclasses.
- Default (no modifier): The member is accessible within the same package.

#### 2.1.1. How do access modifiers contribute to encapsulation in OOP?

Access modifiers restrict access to class members, allowing control over who can modify or view data. This ensures that
the internal representation of an object is hidden, preserving data integrity.

#### 2.1.1. What are the limitations of using access modifiers in inheritance?

- `private` members cannot be inherited directly.
- `protected` members can be inherited but may not be accessible outside the package unless via subclassing.
- `public` members are accessible everywhere.

#### 2.1.1. How does Java handle access control for classes in different packages?

Java restricts access across packages unless the member is public or protected with inheritance. Members with default
access are not visible outside their package.

### 2.2 Getters and Setters

#### 2.2.1. What are getters and setters in Java, and why are they used?

Getters and setters are methods used to access and update private variables. They allow controlled access to an object's
attributes, ensuring encapsulation.

#### 2.2.1. How do getters and setters help in encapsulating data?

By using getters and setters, you can enforce validation, modify data before returning it, or trigger other operations
when the data is changed, thus maintaining control over how an object's state is accessed or modified.

#### 2.2.1. Can you explain how to implement a getter and setter for a private variable?

A getter returns the value of a private variable, while a setter assigns a new value to the variable. Example:

```java
public class Person {
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
```

#### 2.2.1. How can you enforce validation in setters to ensure data integrity?

You can add logic inside the setter method to validate the input before assigning it to the variable.

```java
public void setAge(int age) {
  if (age > 0) {
    this.age = age;
  } else {
    throw new IllegalArgumentException("Age cannot be negative.");
  }
}
```

#### 2.2.1. What is the use of read-only and write-only properties in a class?

- Read-only properties provide a getter but no setter.
- Write-only properties provide a setter but no getter.
  These properties can restrict or limit how an object’s data is accessed or modified.

### 2.3 Data Hiding

#### 2.3.1. What is data hiding in Java, and how does it relate to encapsulation?

Data hiding refers to restricting access to an object's internal state, usually by making fields private. This is a key
principle of encapsulation, preventing external code from directly modifying an object’s state.

#### 2.3.1. How do private fields contribute to data hiding?

Private fields ensure that only methods inside the class can access or modify the data, keeping the object's state
hidden from outside interference.

#### 2.3.1. Can you provide an example of how data hiding improves security in your code?

By restricting direct access to sensitive information, data hiding prevents unintended or malicious manipulation. For
example, a banking application might hide the account balance from direct access and instead provide controlled access
through methods.

#### 2.3.1. How does data hiding differ from data abstraction?

Data hiding focuses on restricting access to an object's internal state, while abstraction focuses on exposing only the
essential features of an object while hiding the complex implementation details.

### 2.4 Immutable Classes

### 2.4.1 Creating Immutable Classes

#### 2.4.1.1. What is an immutable class in Java?

An immutable class is a class whose objects cannot be modified after creation. Once all fields are set in the
constructor, they cannot be changed.

#### 2.4.1.2. How do you create an immutable class, and what are the necessary conditions?

To create an immutable class:

- Declare all fields private and final.
- Do not provide setters.
- Ensure that methods do not modify the object.
- Return deep copies of mutable fields (if any) to prevent external modification.

#### 2.4.1.3. Why are immutable objects considered thread-safe?

Immutable objects cannot be modified after creation, making them inherently thread-safe. Multiple threads can access
them without synchronization because no thread can change their state.

#### 2.4.1.4. What are the common practices to ensure immutability in a class?

- Use final fields.
- Avoid exposing mutable fields.
- Provide only getters, not setters.

#### 2.4.1.5. Can you explain the advantages and disadvantages of immutability?

Advantages:

- Simplicity: Objects remain consistent after creation.
- Thread-safety: No need for synchronization.

Disadvantages:

- Performance: Creating new objects for each modification can be costly.
- Memory usage: Requires more memory due to the creation of new objects.

### 2.4.2 Benefits of Immutability

#### 2.4.2.1. What are the advantages of using immutable classes in Java?

Immutable classes provide simplicity, thread safety, and guarantee that the object's state remains consistent throughout
its lifecycle.

#### 2.4.2.2. How does immutability help in creating a simpler and more robust codebase?

Immutable objects remove the complexity of managing state changes and synchronization, reducing bugs and making the code
easier to reason about.

#### 2.4.2.3. Can you explain how immutability can prevent common bugs related to shared mutable state?

Shared mutable state can lead to race conditions and inconsistent data. Immutability ensures that objects cannot be
modified once created, eliminating such issues.

#### 2.4.2.4. How does immutability relate to functional programming principles?

Functional programming encourages the use of immutable data structures. Immutability aligns with the principle of
avoiding side effects and promoting predictable, stateless functions.

## 3. Enum Types

### 3.1. Defining an Enum

#### 3.1.1. What is an enum in Java, and how do you define it?

An enum in Java is a special data type that represents a collection of constants. Enums are defined using the `enum`
keyword and are used when we need to represent a fixed set of known values (like days of the week, directions, etc.).

#### 3.1.2. How does an enum differ from a class in Java?

Unlike classes, enums are implicitly `final` and cannot be extended. Enums provide a predefined set of instances (
constants) that are immutable. Also, enum values are automatically created as `public static final` constants.

#### 3.1.3. Can you provide an example of a basic enum definition?

```java
public enum Gender {
  MALE, FEMALE
}
```

#### 3.1.4. Why are enums used instead of integer constants?

Enums improve code readability and type safety. Unlike integers, enums are strongly typed and cannot be assigned
arbitrary values, reducing bugs caused by invalid values.

### 3.2. Enum with Constructors, Fields, and Methods

#### 3.2.1. Can an enum in Java have constructors and fields?

Yes, enums can have constructors, fields, and methods just like regular classes. Enum constructors are implicitly
private and cannot be called explicitly.

#### 3.2.2. How do you define a constructor for an enum?

You define a constructor in an enum just like a regular class, except it must be `private`. Enums can have fields, and
you can pass values to the constructor when defining the enum constants.

#### 3.2.3. What are some use cases for enums with fields and methods?

Enums with fields and methods can be used to associate additional data with constants, such as assigning different
values for each enum instance.

#### 3.2.4. Provide an example of an enum with constructors, fields, and methods.

```java
public enum Day {
  MONDAY("Weekday"),
  SATURDAY("Weekend");

  private String type;

  Day(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}
```

#### 3.2.5. Can an enum in Java have private or public constructors?

Enum constructors can only be `private` in Java. `public` constructors are not allowed since enum constants are
predefined and created at the time of class loading.

### 3.3. Using Enums in Switch Statements

#### 3.3.1. How do you use an enum in a switch statement?

You can use enums in switch statements just like primitive values (e.g., `int`, `char`). The switch statement evaluates
the enum constant, making the code more readable and type-safe.

#### 3.3.2. What are the advantages of using enums in switch cases instead of string or integer literals?

Using enums ensures that only valid values can be passed in a switch case, reducing the risk of errors and improving
maintainability. Enums also prevent arbitrary values, unlike strings or integers.

#### 3.3.3. Can you show an example of a switch statement using enums?

```java
public void printDay(Day day) {
  switch (day) {
    case MONDAY:
      System.out.println("Start of the week");
      break;
    case SATURDAY:
      System.out.println("Weekend!");
      break;
    default:
      System.out.println("Mid-week day");
      break;
  }
}
```

### 3.4. Enum Constants as Static Final Fields

#### 3.4.1. Why are enum constants treated as static final fields in Java?

Enum constants are `static` because they belong to the enum class itself and are shared by all instances. They are
`final` because enum values are constant and cannot be changed after creation.

#### 3.4.2. How does the static and final nature of enum constants impact memory management?

Enum constants are created once when the enum class is loaded and are not recreated, saving memory and ensuring that
only a single instance of each constant exists.

#### 3.4.3. Can you explain the significance of the ordinal value of enum constants?

The ordinal value is the position of an enum constant in the list, starting from 0. For example, `MONDAY.ordinal()` will
return `0`. Ordinals are rarely used in modern code since they can lead to maintenance issues if the order of enum
constants changes.

### 3.5. Iterating Over Enum Values

#### 3.5.1. How can you iterate over the values of an enum in Java?

You can use the `values()` method, which returns an array of the enum constants, to iterate over them.

#### 3.5.2. Provide an example of iterating through an enum using the `values()` method.

```java
for(Day day :Day.

values()){
        System.out.

println(day);
}
```

#### 3.5.3. What is the difference between `name()` and `toString()` methods when iterating over enums?

The `name()` method returns the exact name of the enum constant as it was declared. The `toString()` method can be
overridden to provide a custom string representation of the enum constant.

### 3.6. Enum with Overridden Methods

#### 3.6.1. Can you override methods in an enum?

Yes, you can override methods in an enum for individual constants by defining methods within the enum constant body.

#### 3.6.2. How do you define an enum with overridden methods for specific constants?

You can override methods by providing a method implementation within an enum constant.

#### 3.6.3. Provide an example where you override methods for specific enum constants.

```java
public enum Operation {
  ADD {
    public int apply(int x, int y) {
      return x + y;
    }
  },
  SUBTRACT {
    public int apply(int x, int y) {
      return x - y;
    }
  };

  public abstract int apply(int x, int y);
}
```

#### 3.6.4. What are some practical use cases for enums with overridden methods?

Enums with overridden methods are useful when the behavior of constants varies. For example, an enum for mathematical
operations like `ADD`, `SUBTRACT`, etc., can have different implementations for each operation.

## 4. Inheritance

### 4.1 Single Inheritance

#### 4.1.1. What is single inheritance in Java, and how does it work?

Single inheritance in Java is when a class inherits from one parent class. This allows the child class to reuse methods
and fields of the parent class. It works by using the `extends` keyword, creating an "IS-A" relationship between the
parent and child classes.

#### 4.1.2. How do you use the `extends` keyword to implement single inheritance?

The `extends` keyword is used to indicate that a class is inheriting from a superclass. For example:

```java
class Parent {
  void display() {
    System.out.println("This is the parent class.");
  }
}

class Child extends Parent {
  // Child class inherits methods and fields from Parent class
}
 ```

#### 4.1.3. Can you explain the benefits and drawbacks of single inheritance?

**Benefits**:

- Reusability: Code written in the parent class can be reused by the child class.
- Extensibility: Child classes can add new features on top of existing ones.

**Drawbacks**:

- Limited reuse: A class can only inherit from one parent class in Java.
- Increased coupling: The child class is dependent on the implementation of the parent class.

#### 4.1.4. What are the implications of the "IS-A" relationship in inheritance?

The "IS-A" relationship means that the subclass can be treated as an instance of the parent class. This allows
polymorphism, where objects of the child class can be used wherever the parent class objects are expected.

### 4.2 Multilevel Inheritance

#### 4.2.1. What is multilevel inheritance, and how does it differ from single inheritance?

Multilevel inheritance refers to a chain of inheritance where a class can inherit from a child class of another class.
For example, Class C can inherit from Class B, which inherits from Class A.

#### 4.2.2. Provide an example of multilevel inheritance in Java.

```java
class A {
  void methodA() {
    System.out.println("Method of class A.");
  }
}

class B extends A {
  void methodB() {
    System.out.println("Method of class B.");
  }
}

class C extends B {
  void methodC() {
    System.out.println("Method of class C.");
  }
}
```

#### 4.2.3. How do constructors behave in multilevel inheritance scenarios?

Constructors of the parent classes are called first, in a top-down approach. The constructor of the superclass gets
executed before the subclass constructors, ensuring that the parent class's part of the object is initialized first.

#### 4.2.4. What are the challenges associated with multilevel inheritance in large applications?

Multilevel inheritance can make debugging and understanding code difficult as it increases the complexity. Changes in
the base classes may propagate unexpectedly, causing unintended side effects in derived classes.

### 4.3 Method Overriding

#### 4.3.1. What is method overriding in Java, and how does it differ from method overloading?

Method overriding occurs when a subclass provides a specific implementation for a method already defined in its parent
class. In contrast, method overloading occurs when multiple methods with the same name exist in a class but with
different parameters.

#### 4.3.2. How do you override a method in a subclass?

You override a method by redefining it in the subclass with the same signature (method name, parameters, and return
type):

```java
class Parent {
  void show() {
    System.out.println("Parent's show method.");
  }
}

class Child extends Parent {
  @Override
  void show() {
    System.out.println("Child's show method.");
  }
}
```

#### 4.3.3. Can you explain the role of the `@Override` annotation in method overriding?

The `@Override` annotation ensures that the method is correctly overriding a method from the parent class. It helps
avoid errors if the method signature does not exactly match the parent class's method.

#### 4.3.4. What are the rules for method overriding in Java?

- The method must have the same name, return type, and parameters.
- The access level cannot be more restrictive than the overridden method.
- The method cannot throw new or broader checked exceptions.

#### 4.3.5. How does method overriding relate to runtime polymorphism?

Method overriding is essential for achieving runtime polymorphism. At runtime, the JVM calls the overridden method based
on the actual object's type, not the reference's type.

### 4.4 super Keyword

#### 4.4.1. What is the `super` keyword in Java, and when would you use it?

The `super` keyword refers to the parent class's object. It is used to call the parent class's methods or constructors,
especially when the subclass overrides the methods.

#### 4.4.2. How does `super` help in accessing superclass methods and constructors?

You can use `super` to explicitly call a superclass's method or constructor. For example:

```java
  class Parent {
  Parent() {
    System.out.println("Parent constructor");
  }
}

class Child extends Parent {
  Child() {
    super(); // Calls Parent's constructor
    System.out.println("Child constructor");
  }
}
```

#### 4.4.3. Provide an example of using `super` to call a superclass constructor.

```java
class A {
  A() {
    System.out.println("Constructor of A");
  }
}

class B extends A {
  B() {
    super();
    System.out.println("Constructor of B");
  }
}
```

#### 4.4.4. What are the differences between `super` and `this` in Java?

- `this` refers to the current object's instance.
- `super` refers to the parent class's instance.
- `this` is used to access members of the current class, while `super` is used to access members of the parent class.

### 4.5 Hierarchical Inheritance

### 4.5.1 Inheritance with Multiple Subclasses

#### 4.5.1.1. What is hierarchical inheritance in Java?

Hierarchical inheritance occurs when multiple subclasses inherit from a single superclass. This allows different child
classes to reuse the methods and fields of the same parent class.

#### 4.5.1.2. How do multiple subclasses inherit from a single parent class?

Each subclass uses the `extends` keyword to inherit from the same parent class. For example:

```java
class Parent {
  void method() {
    System.out.println("Method in Parent class");
  }
}

class Child1 extends Parent {
}

class Child2 extends Parent {
}
```

#### 4.5.1.3. Can you explain the advantages and potential issues with hierarchical inheritance?

**Advantages**:

- Code reuse: Subclasses can share the common functionality from the parent class.

**Potential Issues**:

- Tight coupling between child classes and parent class may introduce rigidity.
- Changes in the parent class can impact all child classes.

#### 4.5.1.4. How does method resolution work in hierarchical inheritance?

Method resolution starts with the child class. If the method is not found, it moves up the inheritance hierarchy,
checking the parent class and so on.

### 4.6 Composition vs. Inheritance

### 4.6.1 When to Use Composition Over Inheritance

#### 4.6.1.1. What is the difference between composition and inheritance in OOP?

Inheritance creates an "IS-A" relationship between parent and child classes, while composition creates a "HAS-A"
relationship where one class contains an instance of another class.

#### 4.6.1.2. When should you prefer composition over inheritance in your design?

Composition is preferable when the relationship between classes is more flexible and represents behavior rather than
identity. For example, use composition to reuse code without the tight coupling that comes with inheritance.

#### 4.6.1.3. Provide an example of using composition to achieve code reuse.

```java
class Engine {
  void start() {
    System.out.println("Engine started.");
  }
}

class Car {
  private Engine engine = new Engine(); // Composition

  void startCar() {
    engine.start(); // Using Engine through composition
  }
}
```

#### 4.6.1.4. How does composition help in creating more flexible and maintainable code?

Composition is more flexible than inheritance because it allows changing behavior at runtime by swapping out components.
This reduces coupling and increases the modularity and maintainability of the code.

## 5. Polymorphism

### 5.1 Compile-Time Polymorphism (Method Overloading)

#### 5.1.1. What is compile-time polymorphism, and how is it achieved in Java?

Compile-time polymorphism, also known as method overloading, occurs when multiple methods in the same class have the
same name but different parameters (different type, number, or both). It is resolved during compile-time.

#### 5.1.2. How do you implement method overloading in a class?

Method overloading is implemented by defining multiple methods in a class with the same name but with different
signatures. Example:

```java
class Calculator {
  public int add(int a, int b) {
    return a + b;
  }

  public double add(double a, double b) {
    return a + b;
  }
}
```

#### 5.1.3. Can you explain the rules for method overloading in Java?

1. The method names must be the same.
2. The parameter list must differ in either type, number, or both.
3. Return type does not play a role in method overloading.

#### 5.1.4. How does method overloading improve code readability and usability?

Method overloading allows a class to have multiple methods that perform similar functions but with different input
parameters. This simplifies method names and enhances readability.

### 5.2 Runtime Polymorphism (Method Overriding)

#### 5.2.1. What is runtime polymorphism, and how does it differ from compile-time polymorphism?

Runtime polymorphism occurs when a subclass overrides a method of the superclass, and the method to be called is
determined during runtime. Unlike compile-time polymorphism, runtime polymorphism relies on inheritance and method
overriding.

#### 5.2.2. How do you achieve runtime polymorphism through method overriding?

Runtime polymorphism is achieved by overriding a method in a subclass. The method in the subclass must have the same
signature as the one in the superclass. The decision about which method to execute is made at runtime based on the
object type.

#### 5.2.3. Can you explain how polymorphism enhances flexibility and reusability in OOP?

Polymorphism allows objects to be treated as instances of their parent class. This enhances code flexibility because a
single interface can represent different object types. It also improves reusability by allowing subclasses to share
behavior.

#### 5.2.4. How does the JVM determine which method to invoke in runtime polymorphism?

The JVM uses dynamic method dispatch to determine which method to invoke based on the actual object type at runtime, not
the reference type. This allows the same method to exhibit different behavior based on the object type.

### 5.3 Covariant Return Types

### 5.3.1 Method Overriding with Covariant Return Types

#### 5.3.1.1. What are covariant return types in Java?

Covariant return types allow a subclass method to return a more specific type (subtype) than the return type declared by
the method in the superclass.

#### 5.3.1.2. How do covariant return types support method overriding?

Covariant return types allow method overriding with a return type that is a subclass of the original return type, which
can make the overridden method more specific.

#### 5.3.1.3. Can you provide an example of method overriding with covariant return types?

```java
class Animal {
  Animal getAnimal() {
    return this;
  }
}

class Dog extends Animal {
  @Override
  Dog getAnimal() {
    return this;
  }
}
```

#### 5.3.1.4. What are the benefits and limitations of using covariant return types?

Benefits:

- It provides more flexibility in overriding methods by allowing more specific return types.

Limitations:

- Care must be taken to ensure that the overridden method complies with the original method's contract.

## 6. Abstraction

### 6.1 Abstract Classes and Methods

#### 6.1.1. What is an abstract class in Java, and when would you use it?

An abstract class in Java is a class that cannot be instantiated and may contain abstract methods. It is used when you
want to define a common base class with default behavior that can be shared by multiple subclasses.

#### 6.1.2. How do you declare an abstract method in an abstract class?

An abstract method is declared using the `abstract` keyword, and it does not have a body. Example:

```java
abstract class Animal {
  abstract void sound();
}
```

#### 6.1.3. Can you explain the difference between an abstract class and an interface?

- Abstract classes can have both abstract and non-abstract methods, while interfaces can only have abstract methods (
  prior to Java 8).
- A class can extend only one abstract class but can implement multiple interfaces.

#### 6.1.4. How does abstraction contribute to the flexibility and extensibility of your code?

Abstraction allows you to define methods that must be implemented by subclasses, enforcing a contract while allowing
flexibility in how the behavior is implemented.

#### 6.1.5. What are the key design principles that guide the use of abstract classes?

- There is shared code that subclasses should inherit.
- You want to define methods that all subclasses must implement.

### 6.2 Interfaces and Multiple Inheritance

#### 6.2.1. What is an interface in Java, and how does it differ from an abstract class?

An interface is a contract that classes can implement. Unlike abstract classes, interfaces do not have fields and can be
implemented by any class. In Java 8+, interfaces can also have default and static methods.

#### 6.2.2. How do interfaces support multiple inheritance in Java?

Java allows a class to implement multiple interfaces, which means that a class can inherit behavior from multiple
sources, avoiding the diamond problem.

#### 6.2.3. Can you provide an example of a class implementing multiple interfaces?

```java
interface A {
  void methodA();
}

interface B {
  void methodB();
}

class C implements A, B {
  public void methodA() {
    System.out.println("Method A");
  }

  public void methodB() {
    System.out.println("Method B");
  }
}
```

#### 6.2.4. How does the diamond problem arise in multiple inheritance, and how does Java resolve it?

The diamond problem occurs when a class inherits from multiple classes that have a common ancestor, causing ambiguity.
Java resolves this by allowing multiple interfaces, not classes, to be implemented.

#### 6.2.5. How do interfaces enhance modularity and testability in your code?

Interfaces provide a layer of abstraction that decouples implementation from behavior, making it easier to write modular
code and mock interfaces for testing purposes.

### 6.3 Default and Static Methods in Interfaces (Java 8+)

#### 6.3.1. What are default methods in Java interfaces, and why were they introduced?

Default methods are methods in interfaces with a default implementation. They were introduced in Java 8 to allow
interface evolution without breaking existing implementations.

#### 6.3.2. How do static methods in interfaces differ from default methods?

Static methods in interfaces are not tied to instance objects. They belong to the interface itself and can be invoked
directly using the interface name.

#### 6.3.3. Can you explain how default and static methods in interfaces provide backward compatibility?

Default methods allow developers to add new functionality to interfaces without forcing all implementing classes to
provide an implementation.

#### 6.3.4. How do default methods in interfaces help in evolving APIs without breaking existing implementations?

By providing default methods, you can introduce new methods to an interface without requiring all existing implementers
to modify their code.

#### 6.3.5. What are the potential pitfalls of using default and static methods in interfaces?

- Default methods may introduce ambiguity in cases where multiple interfaces define methods with the same signature.
- Overuse of default methods can lead to poorly designed interfaces.

## Summary

This document provides a comprehensive set of interview questions on key Object-Oriented Programming (OOP) concepts in
Java, covering everything from basic principles like class and object creation to more advanced topics such as
polymorphism, abstraction, and inheritance. The questions are designed to help you understand the fundamental aspects of
OOP, test your knowledge of Java-specific implementations, and prepare you for a variety of scenarios that may arise in
technical interviews. By mastering these topics, you can demonstrate a strong grasp of OOP principles, which are
essential for designing robust and maintainable software systems in Java.
