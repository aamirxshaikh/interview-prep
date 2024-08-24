### [Java Basics](https://github.com/aamirxshaikh/interview-prep/tree/main/core-java/src/main/java/com/interviewprep/java_basics)

#### Introduction to Java
Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible. It is a general-purpose programming language intended to let application developers write once, run anywhere (WORA), meaning that compiled Java code can run on all platforms that support Java without the need for recompilation. Java applications are typically compiled to bytecode that can run on any Java virtual machine (JVM) regardless of the underlying computer architecture.

#### Java Development Kit (JDK) and Java Runtime Environment (JRE)
- **Java Development Kit (JDK)**: The JDK is a software development environment used for developing Java applications and applets. It includes the Java Runtime Environment (JRE), an interpreter/loader (Java), a compiler (javac), an archiver (jar), a documentation generator (Javadoc), and other tools needed for Java development.
- **Java Runtime Environment (JRE)**: The JRE is a part of the JDK that provides the libraries, Java Virtual Machine (JVM), and other components to run applications written in Java. The JRE does not contain tools for Java development like compilers or debuggers.

#### The Java Virtual Machine (JVM)
The JVM is an abstract computing machine that enables a computer to run a Java program. There are three notions of the JVM: specification, implementation, and instance. The specification is a document that formally describes what is required of a JVM implementation. Implementations of the JVM are available for many hardware and software platforms. An instance of the JVM is created whenever you run a Java application.

### The `static` Keyword

#### Static Variables (Class Variables)
Static variables are also known as class variables. They are declared with the `static` keyword in a class but outside a method, constructor, or block. There would only be one copy of each class variable per class, regardless of how many objects are created from it. Static variables are shared among all instances of a class.

#### Static Methods
Static methods are methods that belong to the class rather than any object of the class. They can be called without creating an instance of the class. Static methods can access static variables and other static methods directly. They cannot access instance variables or instance methods.

#### Static Blocks
Static blocks are used for static initializations of a class. This code inside the static block is executed only once when the class is first loaded into memory. Static blocks are useful for initializing static variables.

#### Static Class (Nested Static Classes)
A static class is a nested class that is declared static. It can be instantiated without an instance of the enclosing class. Static nested classes can access all static data members of the enclosing class, including private ones.

#### Static Import
Static import allows the static members (fields and methods) of a class to be used in Java code without specifying the class in which the field is defined. This feature was introduced in Java 5.0. It can make the code more readable by removing the class name from the static member access.

### Interview Questions

#### Introduction to Java
1. What is Java and what are its key features?
2. Explain the concept of "Write Once, Run Anywhere" in Java.
3. What are the main differences between Java and other programming languages like C++?

#### Java Development Kit (JDK) and Java Runtime Environment (JRE)
1. What is the Java Development Kit (JDK) and what are its components?
2. What is the Java Runtime Environment (JRE) and how does it differ from the JDK?
3. Explain the role of the `javac` compiler in the JDK.

#### The Java Virtual Machine (JVM)
1. What is the Java Virtual Machine (JVM) and what is its purpose?
2. Describe the three notions of the JVM: specification, implementation, and instance.
3. How does the JVM handle memory management and garbage collection?

### The `static` Keyword

#### Static Variables (Class Variables)
1. What are static variables in Java and how are they different from instance variables?
2. How do you declare a static variable in Java?
3. Can static variables be accessed by instance methods? Explain.

#### Static Methods
1. What are static methods and how do they differ from instance methods?
2. How do you call a static method in Java?
3. Can static methods access instance variables? Why or why not?

#### Static Blocks
1. What is a static block in Java and when is it executed?
2. How can static blocks be used for initializing static variables?
3. Can a class have multiple static blocks? If so, how are they executed?

#### Static Class (Nested Static Classes)
1. What is a static nested class in Java and how is it different from an inner class?
2. How do you instantiate a static nested class?
3. Can a static nested class access the non-static members of its enclosing class?

#### Static Import
1. What is static import in Java and how is it used?
2. What are the advantages and disadvantages of using static import?
3. Provide an example of how to use static import in a Java program.
