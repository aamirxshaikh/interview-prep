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
number =10; // Initialization
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

## 5. Wrapper Classes

Wrapper classes provide a way to use primitive data types as objects. They are used when an object is required, such as
in collections or generics.

### 5.1 List of Wrapper Classes

In Java, the primitive data types (such as `int`, `char`, `float`, etc.) do not behave like objects. Wrapper classes are
provided to represent these primitive types as objects.

Below is a list of Java's wrapper classes for each primitive type:

- `byte` -> `Byte`
- `short` -> `Short`
- `int` -> `Integer`
- `long` -> `Long`
- `float` -> `Float`
- `double` -> `Double`
- `char` -> `Character`
- `boolean` -> `Boolean`

These wrapper classes are part of the `java.lang` package and provide useful methods to work with primitive types as
objects.

### 5.2. Autoboxing and Unboxing

**Autoboxing** is the automatic conversion of a primitive type into its corresponding wrapper class object. Java
automatically wraps a primitive value into an object when needed, such as when adding it to a collection that requires
objects.

**Unboxing** is the reverse process, where the wrapper class object is automatically converted back into a primitive
type.

### Example of Autoboxing:

```java
int num = 5;
Integer wrappedNum = num;  // Autoboxing: primitive int to Integer object
```

### Example of Unboxing:

```java
Integer wrappedNum = 10;
int num = wrappedNum;  // Unboxing: Integer object to primitive int
```

Java's autoboxing and unboxing make working with primitive types in collections and other contexts where objects are
needed easier.

### 5.3. Usage in Collections

Since collections like `List`, `Set`, and `Map` can only store objects (not primitive types), Java's wrapper classes are
used to store primitive data in collections. Autoboxing allows primitives to be automatically converted to their wrapper
types when stored in collections.

# 5.3. Difference between Primitive Types and Wrapper Classes

In Java, each primitive type has a corresponding wrapper class. The differences between primitive types and their
wrapper classes are significant in terms of usage, memory management, and behavior.

## Primitive Types vs. Wrapper Classes

### Primitive Types:

- **Stored in stack memory**: Primitive types directly hold the value in memory.
- **Non-nullable**: A primitive type cannot be `null`.
- **No object methods**: Primitive types do not have methods (e.g., `.toString()`, `.equals()`, etc.).
- **Performance**: Primitive types are more memory and performance-efficient.
- **Default values**: Primitive types have default values (e.g., `0` for `int`, `false` for `boolean`).

### Wrapper Classes:

- **Stored in heap memory**: Wrapper classes are objects that wrap around primitive values and are stored in heap
  memory.
- **Nullable**: Wrapper classes can be `null`, which is useful for certain operations (e.g., collections, databases).
- **Object-oriented**: Wrapper classes have methods (e.g., `.toString()`, `.equals()`, `.compareTo()`).
- **Autoboxing/Unboxing**: Automatic conversion between primitives and wrapper objects.
- **Collections support**: Wrapper classes are used when storing values in data structures that only accept objects.

### Key Points:

- **Use primitive types** for better performance and memory efficiency.
- **Use wrapper classes** when you need object methods, null values, or need to store the values in a collection that
  only accepts objects.

# Interview Questions

## Primitive Data Types

### 1. What are primitive data types in Java? Name all the primitive data types and their corresponding sizes in memory.

Primitive data types in Java are the most basic data types that are predefined by the language. There are 8 primitive
data types:

- `byte`: 8-bit
- `short`: 16-bit
- `int`: 32-bit
- `long`: 64-bit
- `float`: 32-bit
- `double`: 64-bit
- `char`: 16-bit (Unicode character)
- `boolean`: 1-bit (true/false)

### 2. Explain the difference between `float` and `double`. When would you use one over the other?

`float` is a 32-bit floating-point number, while `double` is a 64-bit floating-point number. `double` provides more
precision and is typically used when more accurate decimal calculations are needed.

### 3. What is the range of a `char` data type in Java, and why is it 16-bit?

The `char` data type in Java is a 16-bit Unicode character. It can represent values from 0 to 65,535, covering the full
range of Unicode characters.

### 4. Can you assign an `int` value to a `byte` variable? Why or why not? How can it be done safely?

Directly assigning an `int` to a `byte` can cause a compile-time error due to possible data loss. It can be done safely
using explicit casting, e.g., `byte b = (byte) intValue;`.

### 5. How does Java handle integer overflow? Provide an example.

Java wraps around on integer overflow. For example, if you add 1 to `Integer.MAX_VALUE`, it will wrap around to
`Integer.MIN_VALUE`.

### 6. Why is String immutable in Java?

String is immutable to ensure security, performance (due to caching), and safe sharing between threads without the need
for synchronization.

### 7. What is String pooling in Java, and how does it optimize memory usage?

String pooling is a method of storing only one copy of each distinct string value, which optimizes memory usage by
avoiding the creation of multiple identical String objects.

## Reference Data Types

### 1. What are reference data types in Java? How do they differ from primitive data types?

Reference data types refer to objects and can store a reference (or address) to the actual data, unlike primitive data
types that store actual values.

### 2. Explain how arrays are stored in memory. What happens when you create an array of objects?

Arrays are stored as contiguous blocks of memory. An array of objects stores references to the objects rather than the
objects themselves.

### 3. What is the difference between a String and a char array in Java?

A `String` is an immutable sequence of characters, while a `char` array is a mutable sequence. Strings are easier to use
and have built-in methods for common operations.

### 4. How does Java handle null values with reference types? What is the impact of a `NullPointerException`?

If a reference type is null, any attempt to access a method or field through it will result in a `NullPointerException`,
which typically crashes the program unless caught.

### 5. Can you create an array of primitive types? How do you access elements in such an array?

Yes, you can create an array of primitive types. Elements can be accessed using an index, e.g., `intArray[0]`.

## Variable Declaration and Initialization

### 1. What is the difference between declaring a variable and initializing a variable? Can you provide examples?

Declaring a variable means defining its type and name (e.g., `int x;`), while initializing it means assigning it a
value (e.g., `x = 5;`).

### 2. What are the default values for instance variables of different data types in Java?

    - `int`, `short`, `byte`, `long`: 0
    - `float`, `double`: 0.0
    - `char`: '\u0000' (null character)
    - `boolean`: false
    - Reference types: null

### 3. Explain the difference between local variables and instance variables. What are their scopes and lifetimes?

Local variables are defined within a method and only accessible within that method, while instance variables are defined
within a class and accessible by all methods of the class.

### 4. Can you declare multiple variables of the same type in a single statement? Provide an example.

Yes, e.g., `int a = 1, b = 2, c = 3;`.

### 5. What is the purpose of the `this` keyword in relation to variable initialization?

The `this` keyword is used to refer to the current object's instance variable, distinguishing it from local variables.

## Type Casting

### Implicit Casting (Widening)

### 1. What is implicit casting in Java? Can you provide an example where implicit casting occurs?

Implicit casting is an automatic type conversion where a smaller type is converted to a larger type. For example,
`int i = 100; long l = i;`.

### 2. Why is implicit casting also known as widening conversion? Which data types are involved in such conversions?

It's called widening because it converts a smaller data type to a larger one, like `byte` to `int` or `int` to `long`.

### 3. Is it possible to implicitly cast a `long` to a `float`? Why or why not?

Yes, because a `float` can represent a larger range of values than a `long`, even though its precision might be lower.

### Explicit Casting (Narrowing)

### 1. What is explicit casting in Java, and why is it required? Provide a code example.

Explicit casting is needed when converting a larger data type to a smaller one, e.g., `int i = (int) longValue;`.

### 2. What is the risk of explicit casting? Can you provide an example where explicit casting leads to data loss?

Explicit casting can lead to data loss if the larger data type value exceeds the range of the smaller type, e.g.,
`(byte) 130` results in `-126`.

### 3. Explain the difference between casting an object to a superclass versus casting it to a subclass.

Casting to a superclass is always safe, but casting to a subclass requires a check with `instanceof` to avoid
`ClassCastException`.

### 4. Can you cast a `double` to an `int` without losing information? If not, how can you ensure the correct value?

Casting a `double` to an `int` truncates the decimal part. To round it correctly, use `Math.round()` before casting.

## Constants (`final` keyword)

### 1. What is the `final` keyword in Java, and how is it used to declare constants?

The `final` keyword ensures that a variable's value cannot be changed after initialization, effectively making it a
constant.

### 2. Can a `final` variable be modified after it has been initialized? Explain your answer.

No, once a `final` variable is initialized, it cannot be modified.

### 3. What is the difference between `final` variables, `final` methods, and `final` classes in Java?

`final` variables can't be reassigned, `final` methods can't be overridden, and `final` classes can't be subclassed.

### 4. How can a `final` variable be initialized if it is not done at the time of declaration?

It can be initialized in the constructor or in an instance initializer block.

### 5. What are the advantages of using constants in Java, and how do they improve code maintainability?

Constants make code easier to understand, prevent magic numbers, and reduce the risk of errors from accidental changes.

## Wrapper Classes

### 1. What are wrapper classes in Java?

Wrapper classes in Java are the object representations of primitive data types. Each primitive type has a corresponding
wrapper class that encapsulates its value in an object, allowing it to be treated like an object.

### 2. Why do we need wrapper classes when we have primitive data types?

Wrapper classes are necessary for several reasons: they allow primitives to be treated as objects, which is essential
for using them in collections (e.g., `ArrayList`, `HashMap`), they provide utility methods for converting between types,
and they enable null values for cases where a primitive type cannot represent the absence of a value.

### 3. Can you explain the concept of boxing and unboxing?

Boxing is the process of converting a primitive type into its corresponding wrapper class object. Unboxing is the
reverse process, where a wrapper class object is converted back into its corresponding primitive type. This allows for
seamless integration between primitive types and collections.

### 4. How do wrapper classes enhance the functionality of primitive types?

Wrapper classes enhance functionality by providing methods for conversion (e.g., `Integer.parseInt()`), allowing for
null values, enabling object-oriented behavior, and allowing primitives to be used in collections and generic types.

### 5. Are wrapper classes mutable or immutable? Explain your answer.

Wrapper classes are immutable. Once a wrapper object is created, its value cannot be changed. Any operation that seems
to modify a wrapper class actually creates a new object with the new value.

## List of Wrapper Classes

### 1. What are the different wrapper classes available in Java?

The different wrapper classes available in Java are:

- `Byte`
- `Short`
- `Integer`
- `Long`
- `Float`
- `Double`
- `Character`
- `Boolean`

### 2. Can you explain the differences between `Integer`, `Long`, and `Double` wrapper classes?

`Integer` is used to represent 32-bit signed integers. `Long` is used for 64-bit signed integers, while `Double` is used
for representing double-precision 64-bit floating point numbers. Each wrapper class provides methods for converting to
and from their respective primitive types and performing operations specific to their type.

### 3. What is the significance of the `Character` wrapper class?

The `Character` wrapper class is used to represent a single character as an object. It provides utility methods for
manipulating characters, such as checking if a character is a digit, letter, whitespace, etc. It also allows the
representation of `null` for character values.

### 4. How do the wrapper classes correlate with their corresponding primitive types?

Each wrapper class corresponds directly to a primitive type, allowing the two to be used interchangeably when needed
through autoboxing and unboxing. For instance, an `int` can be automatically converted to an `Integer` (boxing) and vice
versa (unboxing).

### 5. Are there any special features associated with each wrapper class?

Yes, each wrapper class has unique features. For example, `Integer` and `Double` provide static methods for parsing
strings into their respective types (`Integer.parseInt()`, `Double.parseDouble()`). The `Boolean` class provides a
static method `Boolean.valueOf()` to convert strings to boolean values.

## Autoboxing and Unboxing

### 1. What is autoboxing in Java, and how does it work?

Autoboxing is the automatic conversion that the Java compiler makes between a primitive type and its corresponding
wrapper class. For example, when you assign an `int` value to an `Integer` object, the compiler automatically converts
it.

### 2. What is unboxing, and how does it differ from autoboxing?

Unboxing is the reverse of autoboxing. It refers to the automatic conversion of a wrapper class object back to its
corresponding primitive type. For example, when an `Integer` object is assigned to an `int` variable, it is
automatically converted.

### 3. Can you provide an example of autoboxing and unboxing in action?

```java
Integer intValue = 5; // Autoboxing
int primitiveValue = intValue; // Unboxing
```

### 4. What are the performance implications of using autoboxing and unboxing?

Autoboxing and unboxing can introduce overhead due to the creation of wrapper objects, which can impact performance,
especially in tight loops or performance-sensitive applications. It may lead to unnecessary object creation and garbage
collection.

### 5. Are there any potential pitfalls or issues to be aware of when using autoboxing and unboxing?

- Yes, potential pitfalls include:
- NullPointerExceptions when unboxing null values.
- Performance degradation due to unnecessary object creation.
- Unexpected behavior when comparing wrapper objects using `==` (as it compares object references, not values).

## Usage in Collections

### 1. How do wrapper classes facilitate the use of primitive types in Java Collections?

Wrapper classes allow primitive types to be used in collections, which can only hold objects. By converting primitives
into their corresponding wrapper classes, we can store and manipulate them in collections like `ArrayList`, `HashMap`,
etc.

### 2. Why can't you use primitive types directly in collections like `ArrayList` or `HashMap`?

Collections in Java are designed to hold objects, not primitive types. Since primitive types are not objects, they
cannot be directly added to collections, which require reference types.

### 3. Can you provide examples of using wrapper classes in a collection?

```java
List<Integer> numbers = new ArrayList<>();
numbers.

add(10); // Autoboxing occurs
numbers.

add(20);
```

### 4. What happens if you try to add a primitive type directly to a collection?

If you try to add a primitive type directly to a collection, you will get a compilation error, as collections can only
accept objects. For example:

```java
List<int> numbers = new ArrayList<>(); // Compilation error
```

### 5. How does autoboxing simplify the manipulation of collections containing primitive types?

Autoboxing simplifies collection manipulation by allowing developers to work with primitive types seamlessly. They can
directly add primitive values to collections without needing explicit conversion to their wrapper class.

## Tricky/Advanced Questions

### 1. How does Java handle the conversion between different data types during arithmetic operations? Can you provide an example involving mixed data types?

Java automatically promotes smaller types to larger types when performing arithmetic. For example, in
`int result = 5 + 3.0;`, the `int` is promoted to `double`.

### 2. What happens when you declare a variable inside a loop versus outside? How does it affect memory and performance?

Declaring inside a loop creates a new variable each iteration, potentially increasing memory usage, while declaring
outside reuses the same variable.

### 3. Explain the difference between `==` and

`equals()` when comparing reference data types. Why is it important to understand this difference?

`==` checks for reference equality, while `equals()` checks for value equality. Understanding this prevents logical
errors.

### 4. Can you explain what happens during a type conversion from `double` to

`float` when the double value exceeds the range of a float?

The `double` value is rounded and may lose precision or result in `Infinity` if it exceeds the `float` range.

### 5. Why is it important to use `final` for constants, especially in multi-threaded environments?

`final` ensures that the constant is immutable and safely published, preventing inconsistencies in multi-threaded
applications.

## Summary

Understanding data types and variables in Java is fundamental for writing efficient and maintainable code. Java's strong
type system ensures type safety and helps prevent errors. Proper use of type casting and constants further enhances the
robustness of the code.

Make sure to master these basics as they form the foundation for more advanced Java concepts.