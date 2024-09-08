# [Java Basics](https://github.com/aamirxshaikh/interview-prep/tree/main/core-java/src/main/java/com/interviewprep/java_basics)

## 1. Introduction to Java

Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation
dependencies as possible. It is a general-purpose programming language intended to let application developers write
once, run anywhere (WORA), meaning that compiled Java code can run on all platforms that support Java without the need
for recompilation. Java applications are typically compiled to bytecode that can run on any Java virtual machine (JVM)
regardless of the underlying computer architecture.

## 2. Java Development Kit (JDK) and Java Runtime Environment (JRE)

- **Java Development Kit (JDK)**: The JDK is a software development environment used for developing Java applications
  and applets. It includes the Java Runtime Environment (JRE), an interpreter/loader (Java), a compiler (javac), an
  archiver (jar), a documentation generator (Javadoc), and other tools needed for Java development.
- **Java Runtime Environment (JRE)**: The JRE is a part of the JDK that provides the libraries, Java Virtual Machine (
  JVM), and other components to run applications written in Java. The JRE does not contain tools for Java development
  like compilers or debuggers.

## 3. The Java Virtual Machine (JVM)

The JVM is an abstract computing machine that enables a computer to run a Java program. There are three notions of the
JVM: specification, implementation, and instance. The specification is a document that formally describes what is
required of a JVM implementation. Implementations of the JVM are available for many hardware and software platforms. An
instance of the JVM is created whenever you run a Java application.

## 4. The `static` Keyword

### 4.1. Static Variables (Class Variables)

Static variables are also known as class variables. They are declared with the `static` keyword in a class but outside a
method, constructor, or block. There would only be one copy of each class variable per class, regardless of how many
objects are created from it. Static variables are shared among all instances of a class.

### 4.2. Static Methods

Static methods are methods that belong to the class rather than any object of the class. They can be called without
creating an instance of the class. Static methods can access static variables and other static methods directly. They
cannot access instance variables or instance methods.

### 4.3. Static Blocks

Static blocks are used for static initializations of a class. This code inside the static block is executed only once
when the class is first loaded into memory. Static blocks are useful for initializing static variables.

### 4.4. Static Class (Nested Static Classes)

A static class is a nested class that is declared static. It can be instantiated without an instance of the enclosing
class. Static nested classes can access all static data members of the enclosing class, including private ones.

### 4.5. Static Import

Static import allows the static members (fields and methods) of a class to be used in Java code without specifying the
class in which the field is defined. This feature was introduced in Java 5.0. It can make the code more readable by
removing the class name from the static member access.

# Interview Questions

## Introduction to Java

### 1. What is Java and what are its key features?
Java is a high-level, object-oriented programming language developed by Sun Microsystems (now owned by Oracle). It is designed to be platform-independent, secure, and robust. Key features include:
- **Object-Oriented**: Everything in Java is an object.
- **Platform-Independent**: Java bytecode can run on any platform with a JVM.
- **Multithreaded**: Java supports multithreading at the language level.
- **Garbage Collection**: Java handles memory management automatically.
- **Rich API**: Java provides a vast standard library (Java API).

### 2. Explain the concept of "Write Once, Run Anywhere" in Java.
"Write Once, Run Anywhere" (WORA) refers to Java's ability to run the same code on any device that has a Java Virtual Machine (JVM). The source code is compiled into platform-independent bytecode, which the JVM interprets or compiles into native machine code on the host system.

### 3. What are the main differences between Java and other programming languages like C++?
- **Memory Management**: Java has automatic garbage collection, while C++ requires manual memory management.
- **Platform Independence**: Java is platform-independent through the JVM, whereas C++ is compiled to platform-specific machine code.
- **Syntax**: Java does not support pointers, operator overloading, or multiple inheritance (though it supports interfaces), which are present in C++.
- **Security**: Java provides built-in security features, such as the Java sandbox model, making it more secure than C++.

## Java Development Kit (JDK) and Java Runtime Environment (JRE)

### 1. What is the Java Development Kit (JDK) and what are its components?
The JDK is a software development environment used to develop Java applications. It includes:
- **Java Compiler (`javac`)**: Converts Java source code into bytecode.
- **Java Runtime Environment (JRE)**: Provides the libraries and JVM needed to run Java applications.
- **Java Debugger (`jdb`)**: Assists in debugging Java programs.
- **JavaDoc**: Generates API documentation from Java source code comments.
- **Java Libraries**: Standard libraries that provide a wide range of functionalities.

### 2. What is the Java Runtime Environment (JRE) and how does it differ from the JDK?
The JRE is a subset of the JDK that provides the libraries, JVM, and other components necessary to run Java applications, but it does not include development tools like the Java compiler. The JDK includes everything in the JRE plus the development tools.

### 3. Explain the role of the `javac` compiler in the JDK.
The `javac` compiler is responsible for converting Java source code (`.java` files) into bytecode (`.class` files). This bytecode is platform-independent and can be executed by the JVM on any platform.

## The Java Virtual Machine (JVM)

### 1. What is the Java Virtual Machine (JVM) and what is its purpose?
The JVM is an abstract computing machine that enables a computer to run Java programs. It converts Java bytecode into machine code and executes it, providing a platform-independent execution environment.

### 2. Describe the three notions of the JVM: specification, implementation, and instance.
- **Specification**: A document that describes the requirements for JVM implementations.
- **Implementation**: A concrete implementation of the JVM specification, such as HotSpot.
- **Instance**: A running instance of a JVM implementation, created when a Java program is executed.

### 3. How does the JVM handle memory management and garbage collection?
The JVM automatically manages memory through a process called garbage collection, which reclaims memory by removing objects that are no longer referenced by the program. This helps prevent memory leaks and optimizes memory usage.

## The `static` Keyword

### Static Variables (Class Variables)

### 1. What are static variables in Java and how are they different from instance variables?
Static variables are shared across all instances of a class, meaning they have a single value per class, whereas instance variables have a separate value for each instance of the class.

### 2. How do you declare a static variable in Java?
Static variables are declared using the `static` keyword, e.g., `static int count;`.

### 3. Can static variables be accessed by instance methods? Explain.
Yes, static variables can be accessed by instance methods because they belong to the class rather than any specific instance.

### Static Methods

### 1. What are static methods and how do they differ from instance methods?
Static methods belong to the class rather than any instance of the class. They can be called without creating an instance of the class, while instance methods require an object of the class to be invoked.

### 2. How do you call a static method in Java?
Static methods are called using the class name, e.g., `ClassName.methodName();`.

### 3. Can static methods access instance variables? Why or why not?
No, static methods cannot access instance variables directly because they do not belong to any specific instance of the class. They can only access static variables and other static methods.

### Static Blocks

### 1. What is a static block in Java and when is it executed?
A static block is a block of code inside a class that is executed when the class is loaded into memory, before any objects are created or any static methods are called.

### 2. How can static blocks be used for initializing static variables?
Static blocks can be used to initialize static variables when the value of the variable requires complex logic that cannot be handled in a simple assignment statement.

### 3. Can a class have multiple static blocks? If so, how are they executed?
Yes, a class can have multiple static blocks. They are executed in the order in which they appear in the class, from top to bottom.

### Static Class (Nested Static Classes)

### 1. What is a static nested class in Java and how is it different from an inner class?
A static nested class is a class defined within another class with the `static` keyword. Unlike inner classes, static nested classes do not have access to the instance variables or methods of the outer class.

### 2. How do you instantiate a static nested class?
A static nested class is instantiated using the outer class name, e.g., `OuterClass.NestedClass nestedObject = new OuterClass.NestedClass();`.

### 3. Can a static nested class access the non-static members of its enclosing class?
No, a static nested class cannot access non-static members (instance variables and methods) of its enclosing class because it does not have a reference to an instance of the outer class.

### Static Import

### 1. What is static import in Java and how is it used?
Static import allows you to access static members of a class directly without specifying the class name. For example, `import static java.lang.Math.*;` allows you to use `Math.PI` simply as `PI`.

### 2. What are the advantages and disadvantages of using static import?
**Advantages**:
- It reduces code verbosity by eliminating the need to specify the class name for static members.
  **Disadvantages**:
- It can lead to ambiguity if multiple static members with the same name are imported.
- It can reduce code readability, as it may be unclear where a static member is coming from.

### 3. Provide an example of how to use static import in a Java program.
```java
import static java.lang.Math.*;

public class StaticImportExample {
    public static void main(String[] args) {
        double result = sqrt(25) + pow(2, 3) + PI;
        System.out.println("Result: " + result);
    }
}
```

## Summary

This document provides a comprehensive overview of fundamental Java concepts, including the key features of Java, the components of the Java Development Kit (JDK), the role of the Java Runtime Environment (JRE), and the functionality of the Java Virtual Machine (JVM). It also delves into the use of the `static` keyword, covering static variables, methods, blocks, nested classes, and static imports. Through clear explanations and examples, the document highlights the differences between Java and other programming languages, the importance of platform independence, and best practices for resource management and memory handling in Java.
