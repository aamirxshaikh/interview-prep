
# Exception Handling in Java

Exception handling in Java is a mechanism that handles runtime errors to maintain normal application flow. It allows a program to catch and handle errors gracefully rather than abruptly terminating the program.

## 1. Introduction to Exceptions

- **Exception**: An exception is an event that disrupts the normal flow of the program. It is an object that is thrown at runtime.
- **Error vs. Exception**:
    - **Error**: Serious problems that applications should not try to handle (e.g., OutOfMemoryError).
    - **Exception**: Problems that can be caught and handled (e.g., NullPointerException).

![](https://cdn.rollbar.com/wp-content/uploads/2021/07/java-exceptions-hierarchy-example.png.webp)

## 2. Types of Exceptions: Checked vs. Unchecked

- **Checked Exceptions**:
    - Checked at compile-time.
    - Must be either caught or declared to be thrown using `throws`.
    - Examples: `IOException`, `SQLException`.

- **Unchecked Exceptions**:
    - Checked at runtime (RuntimeExceptions).
    - Do not need to be declared or caught.
    - Examples: `NullPointerException`, `ArithmeticException`.

## 3. `try-catch` Block

- **Purpose**: Used to handle exceptions where the code that might throw an exception is placed inside the `try` block, and exception handling code is placed in the `catch` block.

### Example:

```java
try {
    int result = 10 / 0; // This will cause ArithmeticException
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero: " + e.getMessage());
}
```

## 4. `finally` Block

- **Purpose**: A block that always executes, regardless of whether an exception was thrown or caught. It is commonly used for cleanup code, such as closing files or releasing resources.

### Example:

```java
try {
    int[] numbers = {1, 2, 3};
    System.out.println(numbers[5]);
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Array index is out of bounds.");
} finally {
    System.out.println("This block always executes.");
}
```

## 5. `throw` and `throws` Keywords

- **`throw`**: Used to explicitly throw an exception.
- **`throws`**: Declares that a method may throw exceptions; used in method signatures.

### Example:

```java
// Using throw
public void validateAge(int age) {
    if (age < 18) {
        throw new IllegalArgumentException("Age must be 18 or older.");
    }
}

// Using throws
public void readFile(String filePath) throws IOException {
    FileReader file = new FileReader(filePath);
}
```

## 6. Custom Exceptions

- **Purpose**: Creating your own exception classes to handle specific scenarios in your application.

### Example:

```java
// Custom Exception Class
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

// Using Custom Exception
public void checkAge(int age) throws InvalidAgeException {
    if (age < 18) {
        throw new InvalidAgeException("Age is not valid for this operation.");
    }
}
```

## 7. Handling Multiple Exceptions

- **Purpose**: Multiple `catch` blocks can handle different exceptions thrown by a single `try` block.

### Example:

```java
try {
    int num = Integer.parseInt("XYZ");
    int result = 10 / 0;
} catch (NumberFormatException e) {
    System.out.println("Invalid number format.");
} catch (ArithmeticException e) {
    System.out.println("Arithmetic error occurred.");
}
```

## 8. Exception Propagation

- **Concept**: If an exception is not handled in the current method, it is propagated to the caller method. Propagation occurs until the exception is handled or reaches the JVM, which terminates the program.

### Example:

```java
public void method1() {
    method2();
}

public void method2() {
    int result = 10 / 0; // Throws ArithmeticException
}

// If method1 is called, the exception will propagate to it.
```

## 9. `try-with-resources` Statement (Automatic Resource Management)

- **Purpose**: Manages resources automatically, ensuring they are closed properly. It is used with resources like files, databases, or sockets.

### Example:

```java
// try-with-resources automatically closes FileReader
try (FileReader reader = new FileReader("file.txt")) {
    int data = reader.read();
    while (data != -1) {
        System.out.print((char) data);
        data = reader.read();
    }
} catch (IOException e) {
    System.out.println("An error occurred: " + e.getMessage());
}
```

# Interview Questions

## Introduction to Exceptions

1. What is an exception in Java, and why is exception handling important?
2. Explain the difference between errors and exceptions in Java.
3. What is the base class for all exceptions in Java?
4. How does the Java runtime system handle an uncaught exception?
5. What is the difference between a runtime exception and a checked exception?

## Types of Exceptions: Checked vs. Unchecked

1. What are checked exceptions and unchecked exceptions in Java?
2. Can you give examples of checked and unchecked exceptions?
3. Why does Java distinguish between checked and unchecked exceptions?
4. How does the compiler enforce exception handling for checked exceptions?
5. Is it possible to create a custom checked or unchecked exception? How?

## try-catch Block

1. What is the purpose of a try-catch block in Java?
2. Can you have multiple catch blocks for a single try block? How are they evaluated?
3. What happens if an exception is thrown in the try block but not caught by any catch block?
4. Can you explain the concept of exception chaining within a try-catch block?
5. Is it possible to catch multiple exceptions in a single catch block? How?
6. What is meant by "swallowing exceptions" in Java?

## finally Block

1. What is the purpose of the finally block in Java?
2. When is the finally block executed in a try-catch-finally construct?
3. Can a finally block be skipped? Under what circumstances?
4. What happens if there is a return statement in the try or catch block? Will the finally block still execute?
5. Can a finally block itself throw an exception? What would happen in such a case?

## throw and throws Keywords

1. What is the difference between `throw` and `throws` in Java?
2. When would you use the `throw` keyword in your code?
3. How do you declare that a method throws an exception using the `throws` keyword?
4. Can a constructor throw an exception? How would you handle it?
5. What happens if a method that declares a checked exception does not handle it and does not propagate it with
   `throws`?

## Custom Exceptions

1. How do you create a custom exception in Java?
2. Why would you need to create a custom exception?
3. What are the steps to create a custom checked exception?
4. How do you add additional fields or methods to a custom exception?
5. Can you provide an example of when you would use a custom runtime exception?

## Handling Multiple Exceptions

1. How does Java handle multiple exceptions in a single try block?
2. Can you catch multiple exceptions in a single catch block? How?
3. What are the advantages of multi-catch blocks introduced in Java 7?
4. How does exception handling work with inheritance and multiple catch blocks?
5. What happens if multiple exceptions occur in a try block, and only one catch block is defined?

## Exception Propagation

1. What is exception propagation in Java?
2. How does exception propagation work in a method call stack?
3. Can you explain the concept of rethrowing an exception?
4. How do checked and unchecked exceptions behave differently during propagation?
5. What are the best practices for handling exceptions that propagate through multiple methods?

## try-with-resources Statement (Automatic Resource Management)

1. What is the try-with-resources statement in Java?
2. How does try-with-resources improve resource management in Java?
3. What are the requirements for a resource to be used with try-with-resources?
4. Can you nest try-with-resources statements? How does it affect resource management?
5. How does the try-with-resources statement differ from a traditional try-catch-finally block?

## Summary

- Exception handling ensures that runtime errors are caught and handled without crashing the program.
- Use `try-catch` blocks to handle exceptions.
- `finally` is used for cleanup tasks and always executes.
- `throw` and `throws` help manage custom and expected exceptions.
- Handling multiple exceptions, creating custom exceptions, and understanding propagation are key to robust error management.
- The `try-with-resources` statement simplifies resource management by automatically closing resources.