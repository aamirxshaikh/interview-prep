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

### 1. What are primitive data types in Java? Name all the primitive data types and their corresponding sizes in memory.
Primitive data types in Java are the most basic data types that are predefined by the language. There are 8 primitive data types:
    - `byte`: 8-bit
    - `short`: 16-bit
    - `int`: 32-bit
    - `long`: 64-bit
    - `float`: 32-bit
    - `double`: 64-bit
    - `char`: 16-bit (Unicode character)
    - `boolean`: 1-bit (true/false)

### 2. Explain the difference between `float` and `double`. When would you use one over the other?
`float` is a 32-bit floating-point number, while `double` is a 64-bit floating-point number. `double` provides more precision and is typically used when more accurate decimal calculations are needed.

### 3. What is the range of a `char` data type in Java, and why is it 16-bit?
The `char` data type in Java is a 16-bit Unicode character. It can represent values from 0 to 65,535, covering the full range of Unicode characters.

### 4. Can you assign an `int` value to a `byte` variable? Why or why not? How can it be done safely?
Directly assigning an `int` to a `byte` can cause a compile-time error due to possible data loss. It can be done safely using explicit casting, e.g., `byte b = (byte) intValue;`.

### 5. How does Java handle integer overflow? Provide an example.
Java wraps around on integer overflow. For example, if you add 1 to `Integer.MAX_VALUE`, it will wrap around to `Integer.MIN_VALUE`.

### 6. Why is String immutable in Java?
String is immutable to ensure security, performance (due to caching), and safe sharing between threads without the need for synchronization.

### 7. What is String pooling in Java, and how does it optimize memory usage?
String pooling is a method of storing only one copy of each distinct string value, which optimizes memory usage by avoiding the creation of multiple identical String objects.

## Reference Data Types

### 1. What are reference data types in Java? How do they differ from primitive data types?
Reference data types refer to objects and can store a reference (or address) to the actual data, unlike primitive data types that store actual values.

### 2. Explain how arrays are stored in memory. What happens when you create an array of objects?
Arrays are stored as contiguous blocks of memory. An array of objects stores references to the objects rather than the objects themselves.

### 3. What is the difference between a String and a char array in Java?
A `String` is an immutable sequence of characters, while a `char` array is a mutable sequence. Strings are easier to use and have built-in methods for common operations.

### 4. How does Java handle null values with reference types? What is the impact of a `NullPointerException`?
If a reference type is null, any attempt to access a method or field through it will result in a `NullPointerException`, which typically crashes the program unless caught.

### 5. Can you create an array of primitive types? How do you access elements in such an array?
Yes, you can create an array of primitive types. Elements can be accessed using an index, e.g., `intArray[0]`.

## Variable Declaration and Initialization

### 1. What is the difference between declaring a variable and initializing a variable? Can you provide examples?
Declaring a variable means defining its type and name (e.g., `int x;`), while initializing it means assigning it a value (e.g., `x = 5;`).

### 2. What are the default values for instance variables of different data types in Java?
    - `int`, `short`, `byte`, `long`: 0
    - `float`, `double`: 0.0
    - `char`: '\u0000' (null character)
    - `boolean`: false
    - Reference types: null

### 3. Explain the difference between local variables and instance variables. What are their scopes and lifetimes?
Local variables are defined within a method and only accessible within that method, while instance variables are defined within a class and accessible by all methods of the class.

### 4. Can you declare multiple variables of the same type in a single statement? Provide an example.
Yes, e.g., `int a = 1, b = 2, c = 3;`.

### 5. What is the purpose of the `this` keyword in relation to variable initialization?
The `this` keyword is used to refer to the current object's instance variable, distinguishing it from local variables.

## Type Casting

### Implicit Casting (Widening)

### 1. What is implicit casting in Java? Can you provide an example where implicit casting occurs?
Implicit casting is an automatic type conversion where a smaller type is converted to a larger type. For example, `int i = 100; long l = i;`.

### 2. Why is implicit casting also known as widening conversion? Which data types are involved in such conversions?
It's called widening because it converts a smaller data type to a larger one, like `byte` to `int` or `int` to `long`.

### 3. Is it possible to implicitly cast a `long` to a `float`? Why or why not?
Yes, because a `float` can represent a larger range of values than a `long`, even though its precision might be lower.

### Explicit Casting (Narrowing)

### 1. What is explicit casting in Java, and why is it required? Provide a code example.
Explicit casting is needed when converting a larger data type to a smaller one, e.g., `int i = (int) longValue;`.

### 2. What is the risk of explicit casting? Can you provide an example where explicit casting leads to data loss?
Explicit casting can lead to data loss if the larger data type value exceeds the range of the smaller type, e.g., `(byte) 130` results in `-126`.

### 3. Explain the difference between casting an object to a superclass versus casting it to a subclass.
Casting to a superclass is always safe, but casting to a subclass requires a check with `instanceof` to avoid `ClassCastException`.

### 4. Can you cast a `double` to an `int` without losing information? If not, how can you ensure the correct value?
Casting a `double` to an `int` truncates the decimal part. To round it correctly, use `Math.round()` before casting.

## Constants (`final` keyword)

### 1. What is the `final` keyword in Java, and how is it used to declare constants?
The `final` keyword ensures that a variable's value cannot be changed after initialization, effectively making it a constant.

### 2. Can a `final` variable be modified after it has been initialized? Explain your answer.
No, once a `final` variable is initialized, it cannot be modified.

### 3. What is the difference between `final` variables, `final` methods, and `final` classes in Java?
`final` variables can't be reassigned, `final` methods can't be overridden, and `final` classes can't be subclassed.

### 4. How can a `final` variable be initialized if it is not done at the time of declaration?
It can be initialized in the constructor or in an instance initializer block.

### 5. What are the advantages of using constants in Java, and how do they improve code maintainability?
Constants make code easier to understand, prevent magic numbers, and reduce the risk of errors from accidental changes.

## Tricky/Advanced Questions

### 1. How does Java handle the conversion between different data types during arithmetic operations? Can you provide an example involving mixed data types?
Java automatically promotes smaller types to larger types when performing arithmetic. For example, in `int result = 5 + 3.0;`, the `int` is promoted to `double`.

### 2. What happens when you declare a variable inside a loop versus outside? How does it affect memory and performance?
Declaring inside a loop creates a new variable each iteration, potentially increasing memory usage, while declaring outside reuses the same variable.

### 3. Explain the difference between `==` and `equals()` when comparing reference data types. Why is it important to understand this difference?
`==` checks for reference equality, while `equals()` checks for value equality. Understanding this prevents logical errors.

### 4. Can you explain what happens during a type conversion from `double` to `float` when the double value exceeds the range of a float?
The `double` value is rounded and may lose precision or result in `Infinity` if it exceeds the `float` range.

### 5. Why is it important to use `final` for constants, especially in multi-threaded environments?
`final` ensures that the constant is immutable and safely published, preventing inconsistencies in multi-threaded applications.

## Summary

Understanding data types and variables in Java is fundamental for writing efficient and maintainable code. Java's strong
type system ensures type safety and helps prevent errors. Proper use of type casting and constants further enhances the
robustness of the code.

Make sure to master these basics as they form the foundation for more advanced Java concepts.