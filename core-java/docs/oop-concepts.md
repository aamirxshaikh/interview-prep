# Object-Oriented Programming (OOP) Concepts

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

- **Abstract Class**: Cannot be instantiated and may contain abstract methods.
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

### Interfaces and Multiple Inheritance

- **Interface**: A reference type that can contain abstract methods and constants.
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

### Default and Static Methods in Interfaces (Java 8+)

- Default methods provide concrete implementations in interfaces.
- Static methods can be called on the interface itself.

**Example:**

```java
interface Vehicle {
  void start();

  default void honk() {
    System.out.println("Honk honk!");
  }

  static int getWheelCount() {
    return 4;
  }
}

class Car implements Vehicle {
  @Override
  public void start() {
    System.out.println("Car starting");
  }
}

public class Main {
  public static void main(String[] args) {
    Car car = new Car();
    car.start();
    car.honk();  // Using default method
    System.out.println("Wheel count: " + Vehicle.getWheelCount());  // Using static method
  }
}
```

In this example, `honk()` is a default method that provides a default implementation, while `getWheelCount()` is a
static method that can be called on the `Vehicle` interface itself.

# Interview Questions

## 1. Class and Object

### 1.1 Defining a Class and Creating Objects

#### 1.1.1. What is a class in Java, and how is it different from an object?**

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

- What is a constructor in Java, and how is it different from a method?
- How do you define a constructor in a class?
- What is a default constructor, and when is it provided by the compiler?
- Can you explain the use of initialization blocks in Java?
- How do initialization blocks differ from constructors?
- What is a copy constructor, and how do you implement it in Java?
- Can constructors be overloaded? Provide examples.
- How does constructor chaining work in Java?

### 1.3 this Keyword

- What is the `this` keyword in Java, and when would you use it?
- How does `this` help in resolving naming conflicts within a class?
- Can you explain how `this` can be used to call another constructor within the same class?
- How would you pass the current object as an argument to a method using `this`?
- Can `this` be used in a static method? Why or why not?

### 1.4 Static Context in OOP

#### 1.4.1 Accessing Static Members

- What are static members in Java, and how do they differ from instance members?
- How do you access static variables and methods within a class?
- Can static methods be overridden in Java? Why or why not?
- How are static blocks different from static methods?

#### 1.4.2 Restrictions in Static Context

- What are the restrictions of using static methods in Java?
- Why can't you use `this` or `super` in a static context?
- Can a static method access instance variables? Explain your answer.
- Why can't you declare abstract static methods in Java?

#### 1.4.3 Static vs. Instance Context

- What is the difference between a static context and an instance context in Java?
- How does memory allocation differ for static and instance members?
- When would you prefer to use static methods over instance methods?
- What are some common use cases for static methods in utility classes?

#### 1.4.4 Method Hiding

- Explain the concept of method hiding and how it differs from method overriding.
- Explain how Java resolves method calls when both superclass and subclass have static methods with the same name.
- Discuss whether polymorphism applies to method hiding and why.
- Suggest best practices to differentiate between when to use overriding versus hiding, particularly for developers new
  to Java.

### 1.5 Nested Classes and Static Classes

#### 1.5.1 Inner Classes (Non-static Nested Classes)

- What is an inner class in Java, and how does it differ from a static nested class?
- How do you define an inner class in Java?
- What are the different types of inner classes in Java?
- Can you explain the difference between member inner classes, local inner classes, and anonymous inner classes?
- How does an inner class access the members of its outer class?
- Provide an example of when to use an inner class.
- What are the limitations or challenges of using inner classes?

#### 1.5.2 Static Nested Classes

- What is a static nested class in Java?
- How does a static nested class differ from an inner class?
- Can you provide an example of a static nested class?
- How do static nested classes interact with the outer class's static members?
- What are the benefits of using a static nested class?
- When would you choose a static nested class over an inner class?

### 1.6 Object Class and Its Methods

#### 1.6.1 equals() and hashCode()

- What is the purpose of the `equals()` method in Java?
- How does the `equals()` method differ from the `==` operator?
- Why is it important to override `hashCode()` when overriding `equals()`?
- Can you explain the contract between `equals()` and `hashCode()`?
- What are the potential issues if `equals()` and `hashCode()` are not overridden properly?
- How would you implement a custom `equals()` and `hashCode()` method for a complex object?

#### 1.6.2 toString()

- What is the purpose of the `toString()` method in Java?
- How does overriding `toString()` benefit your code?
- Provide an example of how `toString()` is used in logging and debugging.
- How does the default `toString()` implementation work for an object?
- How would you design a `toString()` method to avoid exposing sensitive information?

#### 1.6.3 clone() and Cloning in Java

- What is cloning in Java, and how do you achieve it?
- What is the difference between a shallow copy and a deep copy?
- What is the purpose of the `Cloneable` interface?
- Can you explain the `clone()` method and when to override it?
- What are the challenges and pitfalls of implementing the `clone()` method?
- How would you implement deep cloning in Java without using the `Cloneable` interface?

#### 1.6.4 finalize() Method

- What is the `finalize()` method in Java?
- Why is the `finalize()` method considered deprecated or unreliable in modern Java?
- How does garbage collection work in relation to `finalize()`?
- Can you manually call the `finalize()` method? What are the implications?
- What are alternatives to using the `finalize()` method for resource cleanup?

## 2. Encapsulation

### 2.1 Access Modifiers (private, public, protected, default)

- What are access modifiers in Java, and why are they important?
- Can you explain the difference between `private`, `public`, `protected`, and default access?
- How do access modifiers contribute to encapsulation in OOP?
- What are the limitations of using access modifiers in inheritance?
- How does Java handle access control for classes in different packages?

### 2.2 Getters and Setters

- What are getters and setters in Java, and why are they used?
- How do getters and setters help in encapsulating data?
- Can you explain how to implement a getter and setter for a private variable?
- How can you enforce validation in setters to ensure data integrity?
- What is the use of read-only and write-only properties in a class?

### 2.3 Data Hiding

- What is data hiding in Java, and how does it relate to encapsulation?
- How do private fields contribute to data hiding?
- Can you provide an example of how data hiding improves security in your code?
- How does data hiding differ from data abstraction?

### 2.4 Immutable Classes

#### 2.4.1 Creating Immutable Classes

- What is an immutable class in Java?
- How do you create an immutable class, and what are the necessary conditions?
- Why are immutable objects considered thread-safe?
- What are the common practices to ensure immutability in a class?
- Can you explain the advantages and disadvantages of immutability?

#### 2.4.2 Benefits of Immutability

- What are the advantages of using immutable classes in Java?
- How does immutability help in creating a simpler and more robust codebase?
- Can you explain how immutability can prevent common bugs related to shared mutable state?
- How does immutability relate to functional programming principles?

## 3. Inheritance

### 3.1 Single Inheritance

- What is single inheritance in Java, and how does it work?
- How do you use the `extends` keyword to implement single inheritance?
- Can you explain the benefits and drawbacks of single inheritance?
- What are the implications of the "IS-A" relationship in inheritance?

### 3.2 Multilevel Inheritance

- What is multilevel inheritance, and how does it differ from single inheritance?
- Provide an example of multilevel inheritance in Java.
- How do constructors behave in multilevel inheritance scenarios?
- What are the challenges associated with multilevel inheritance in large applications?

### 3.3 Method Overriding

- What is method overriding in Java, and how does it differ from method overloading?
- How do you override a method in a subclass?
- Can you explain the role of the `@Override` annotation in method overriding?
- What are the rules for method overriding in Java?
- How does method overriding relate to runtime polymorphism?

### 3.4 super Keyword

- What is the `super` keyword in Java, and when would you use it?
- How does `super` help in accessing superclass methods and constructors?
- Provide an example of using `super` to call a superclass constructor.
- What are the differences between `super` and `this` in Java?

### 3.5 Hierarchical Inheritance

#### 3.5.1 Inheritance with Multiple Subclasses

- What is hierarchical inheritance in Java?
- How do multiple subclasses inherit from a single parent class?
- Can you explain the advantages and potential issues with hierarchical inheritance?
- How does method resolution work in hierarchical inheritance?

### 3.6 Composition vs. Inheritance

#### 3.6.1 When to Use Composition Over Inheritance

- What is the difference between composition and inheritance in OOP?
- When should you prefer composition over inheritance in your design?
- Provide an example of using composition to achieve code reuse.
- How does composition help in creating more flexible and maintainable code?

## 4. Polymorphism

### 4.1 Compile-Time Polymorphism (Method Overloading)

- What is compile-time polymorphism, and how is it achieved in Java?
- How do you implement method overloading in a class?
- Can you explain the rules for method overloading in Java?
- How does method overloading improve code readability and usability?

### 4.2 Runtime Polymorphism (Method Overriding)

- What is runtime polymorphism, and how does it differ from compile-time polymorphism?
- How do you achieve runtime polymorphism through method overriding?
- Can you explain how polymorphism enhances flexibility and reusability in OOP?
- How does the JVM determine which method to invoke in runtime polymorphism?

### 4.3 Covariant Return Types

#### 4.3.1 Method Overriding with Covariant Return Types

- What are covariant return types in Java?
- How do covariant return types support method overriding?
- Can you provide an example of method overriding with covariant return types?
- What are the benefits and limitations of using covariant return types?

## 5. Abstraction

### 5.1 Abstract Classes and Methods

- What is an abstract class in Java, and when would you use it?
- How do you declare an abstract method in an abstract class?
- Can you explain the difference between an abstract class and an interface?
- How does abstraction contribute to the flexibility and extensibility of your code?
- What are the key design principles that guide the use of abstract classes?

### 5.2 Interfaces and Multiple Inheritance

- What is an interface in Java, and how does it differ from an abstract class?
- How do interfaces support multiple inheritance in Java?
- Can you provide an example of a class implementing multiple interfaces?
- How does the diamond problem arise in multiple inheritance, and how does Java resolve it?
- How do interfaces enhance modularity and testability in your code?

### 5.3 Default and Static Methods in Interfaces (Java 8+)

- What are default methods in Java interfaces, and why were they introduced?
- How do static methods in interfaces differ from default methods?
- Can you explain how default and static methods in interfaces provide backward compatibility?
- How do default methods in interfaces help in evolving APIs without breaking existing implementations?
- What are the potential pitfalls of using default and static methods in interfaces?

## Summary

This document provides a comprehensive set of interview questions on key Object-Oriented Programming (OOP) concepts in
Java, covering everything from basic principles like class and object creation to more advanced topics such as
polymorphism, abstraction, and inheritance. The questions are designed to help you understand the fundamental aspects of
OOP, test your knowledge of Java-specific implementations, and prepare you for a variety of scenarios that may arise in
technical interviews. By mastering these topics, you can demonstrate a strong grasp of OOP principles, which are
essential for designing robust and maintainable software systems in Java.
