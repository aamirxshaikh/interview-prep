# [Data Types and Variables](https://github.com/aamirxshaikh/interview-prep/tree/main/core-java/src/main/java/com/interviewprep/data_types_and_variables)

This section covers the fundamental concepts of data types and variables in Java, which are crucial for any Java
developer. Understanding these concepts is key to writing efficient and error-free code.

## 1. Data Types in Java

Java provides a rich set of data types that can be categorized into two main types:

### 1.1. Primitive Data Types

Primitive data types are the most basic data types available in Java. They are not objects and hold their values
directly in memory. Java has 8 primitive data types:

- **byte**: 8-bit signed integer.
- **short**: 16-bit signed integer.
- **int**: 32-bit signed integer.
- **long**: 64-bit signed integer.
- **float**: 32-bit floating-point.
- **double**: 64-bit floating-point.
- **char**: 16-bit Unicode character.
- **boolean**: Represents one bit of information. Two possible values: `true` or `false`.

#### Example:

```java
int age = 25;
float salary = 50000.5f;
char grade = 'A';
boolean isActive = true;
```

### 1.2. Reference Data Types

Reference data types refer to objects and arrays. Unlike primitive data types, reference types hold references (or
memory addresses) to the actual data. Reference types include:

- **Classes**: Created using the `class` keyword.
- **Interfaces**: Created using the `interface` keyword.
- **Arrays**: A collection of elements of the same type.

#### Example:

```java
String name = "John Doe"; // String is a class in Java
int[] numbers = {1, 2, 3, 4, 5}; // Array of integers
```

## 2. Variables in Java

A variable is a container that holds data that can be changed during the execution of a program. Variables in Java must
be declared with a data type before they can be used.

### 2.1. Variable Declaration and Initialization

- *Declaration*: Specifying the type and name of the variable.
- *Initialization*: Assigning a value to the variable at the time of declaration or later.

#### Example:

```java
int number; // Declaration
number = 10; // Initialization
int age = 25; // Declaration and Initialization
```

### 2.2. Types of Variables

- *Local Variables*: Declared within a method or a block and accessible only within that method or block.
- *Instance Variables*: Declared inside a class but outside any method. They are associated with instances of the class.
- *Static Variables*: Declared with the `static` keyword inside a class but outside any method. They are shared among
  all instances of the class.

#### Example:

```java
public class Example {
  int instanceVar; // Instance Variable
  static int staticVar; // Static Variable

  public void method() {
    int localVar = 10; // Local Variable
  }
}
```

## 3. Type Casting in Java

Type casting is the process of converting one data type to another. Java supports two types of casting:

### 3.1. Implicit Casting (Widening)

Implicit casting happens automatically when converting a smaller data type to a larger data type. No data loss occurs
during this conversion.

#### Example:

```java
int num = 100;
double doubleNum = num; // Implicit casting from int to double
```

### 3.2. Explicit Casting (Narrowing)

Explicit casting must be done manually by placing the type in parentheses. It is used when converting a larger data type
to a smaller data type, and there is a risk of data loss.

#### Example:

```java
double doubleNum = 9.78;
int num = (int) doubleNum; // Explicit casting from double to int (truncates the decimal part)
```

## 4. Constants in Java

Constants are variables whose values cannot be changed once assigned. In Java, constants are declared using the `final`
keyword.

### 4.1. Declaring Constants

A `final` variable must be initialized at the time of declaration or in the constructor. Once assigned, the value cannot
be altered.

#### Example:

```java
public class Constants {
  public static final double PI = 3.14159;

  public static void main(String[] args) {
    // PI = 3.14; // This line would cause a compilation error
    System.out.println("Value of PI: " + PI);
  }
}
```

# Interview Questions

## Primitive Data Types

1. What are primitive data types in Java? Name all the primitive data types and their corresponding sizes in memory.
2. Explain the difference between `float` and `double`. When would you use one over the other?
3. What is the range of a `char` data type in Java, and why is it 16-bit?
4. Can you assign an `int` value to a `byte` variable? Why or why not? How can it be done safely?
5. How does Java handle integer overflow? Provide an example.
6. Why is String immutable in Java?
7. What is String pooling in Java, and how does it optimize memory usage?

## Reference Data Types

1. What are reference data types in Java? How do they differ from primitive data types?
2. Explain how arrays are stored in memory. What happens when you create an array of objects?
3. What is the difference between a String and a char array in Java?
4. How does Java handle null values with reference types? What is the impact of a `NullPointerException`?
5. Can you create an array of primitive types? How do you access elements in such an array?

## Variable Declaration and Initialization

1. What is the difference between declaring a variable and initializing a variable? Can you provide examples?
2. What are the default values for instance variables of different data types in Java?
3. Explain the difference between local variables and instance variables. What are their scopes and lifetimes?
4. Can you declare multiple variables of the same type in a single statement? Provide an example.
5. What is the purpose of the `this` keyword in relation to variable initialization?

## Type Casting

### Implicit Casting (Widening)

1. What is implicit casting in Java? Can you provide an example where implicit casting occurs?
2. Why is implicit casting also known as widening conversion? Which data types are involved in such conversions?
3. Is it possible to implicitly cast a `long` to a `float`? Why or why not?

### Explicit Casting (Narrowing)

1. What is explicit casting in Java, and why is it required? Provide a code example.
2. What is the risk of explicit casting? Can you provide an example where explicit casting leads to data loss?
3. Explain the difference between casting an object to a superclass versus casting it to a subclass.
4. Can you cast a `double` to an `int` without losing information? If not, how can you ensure the correct value?

## Constants (`final` keyword)

1. What is the `final` keyword in Java, and how is it used to declare constants?
2. Can a `final` variable be modified after it has been initialized? Explain your answer.
3. What is the difference between `final` variables, `final` methods, and `final` classes in Java?
4. How can a `final` variable be initialized if it is not done at the time of declaration?
5. What are the advantages of using constants in Java, and how do they improve code maintainability?

## Tricky/Advanced Questions

1. How does Java handle the conversion between different data types during arithmetic operations? Can you provide an
   example involving mixed data types?
2. What happens when you declare a variable inside a loop versus outside? How does it affect memory and performance?
3. Explain the difference between `==` and `equals()` when comparing reference data types. Why is it important to
   understand this difference?
4. Can you explain what happens during a type conversion from `double` to `float` when the double value exceeds the
   range of a float?
5. Why is it important to use `final` for constants, especially in multi-threaded environments?

## Summary

Understanding data types and variables in Java is fundamental for writing efficient and maintainable code. Java's strong
type system ensures type safety and helps prevent errors. Proper use of type casting and constants further enhances the
robustness of the code.

Make sure to master these basics as they form the foundation for more advanced Java concepts.