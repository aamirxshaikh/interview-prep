# [Exception Handling in Java](https://github.com/aamirxshaikh/interview-prep/tree/main/core-java/src/main/java/com/interviewprep/exception_handling)

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

### 1. What is an exception in Java, and why is exception handling important?
An exception in Java is an event that disrupts the normal flow of the program. Exception handling is important because it allows a program to catch and manage errors, ensuring the program doesn't crash and providing a way to respond to different error scenarios gracefully.

### 2. Explain the difference between errors and exceptions in Java.
Errors are serious issues that a reasonable application should not try to catch, such as `OutOfMemoryError`. Exceptions, on the other hand, are conditions that a program might want to catch and handle, such as `NullPointerException` or `IOException`.

### 3. What is the base class for all exceptions in Java?
The base class for all exceptions in Java is `java.lang.Throwable`. It has two main subclasses: `Error` and `Exception`.

### 4. How does the Java runtime system handle an uncaught exception?
If an exception is not caught, the Java runtime system will terminate the program, and the exception's stack trace will be printed to the console.

### 5. What is the difference between a runtime exception and a checked exception?
Runtime exceptions (unchecked exceptions) are exceptions that occur during the execution of a program and do not need to be declared or caught, such as `NullPointerException`. Checked exceptions must be declared in a method's `throws` clause or caught within the method, such as `IOException`.

## Types of Exceptions: Checked vs. Unchecked

### 1. What are checked exceptions and unchecked exceptions in Java?
Checked exceptions are exceptions that must be caught or declared in the method signature using `throws`. Unchecked exceptions are runtime exceptions that do not need to be declared or caught.

### 2. Can you give examples of checked and unchecked exceptions?
Examples of checked exceptions: `IOException`, `SQLException`. Examples of unchecked exceptions: `NullPointerException`, `ArithmeticException`.

### 3. Why does Java distinguish between checked and unchecked exceptions?
Java distinguishes between them to enforce error handling for exceptional conditions that are more likely to occur and should be caught and handled by the programmer (checked exceptions). Unchecked exceptions usually represent programming errors that might not be recoverable.

### 4. How does the compiler enforce exception handling for checked exceptions?
The compiler checks that checked exceptions are either caught in a `try-catch` block or declared in the method's `throws` clause. If this is not done, the code will not compile.

### 5. Is it possible to create a custom checked or unchecked exception? How?
Yes, you can create a custom checked exception by extending the `Exception` class, and a custom unchecked exception by extending the `RuntimeException` class.

## try-catch Block

### 1. What is the purpose of a try-catch block in Java?
The `try-catch` block is used to handle exceptions. Code that might throw an exception is placed inside the `try` block, and the code that handles the exception is placed inside one or more `catch` blocks.

### 2. Can you have multiple catch blocks for a single try block? How are they evaluated?
Yes, you can have multiple `catch` blocks for a single `try` block. They are evaluated in the order they appear, and the first `catch` block that matches the type of the thrown exception is executed.

### 3. What happens if an exception is thrown in the try block but not caught by any catch block?
If an exception is thrown in the `try` block and not caught by any `catch` block, it propagates up the call stack, potentially terminating the program if it remains unhandled.

### 4. Can you explain the concept of exception chaining within a try-catch block?
Exception chaining is when one exception is caught, and a new exception is thrown, including the original exception as its cause. This allows you to preserve the original exception information while throwing a new exception.

### 5. Is it possible to catch multiple exceptions in a single catch block? How?
Yes, starting with Java 7, you can catch multiple exceptions in a single `catch` block by separating them with a pipe (`|`) character.

### 6. What is meant by "swallowing exceptions" in Java?
Swallowing exceptions occurs when an exception is caught in a `catch` block but not handled or logged, potentially hiding problems in the code.

## finally Block

### 1. What is the purpose of the finally block in Java?
The `finally` block contains code that is always executed after the `try-catch` block, regardless of whether an exception was thrown or caught. It is often used for resource cleanup.

### 2. When is the finally block executed in a try-catch-finally construct?
The `finally` block is executed after the `try` and `catch` blocks have completed. It is executed whether or not an exception was thrown or caught.

### 3. Can a finally block be skipped? Under what circumstances?
The `finally` block can be skipped if the JVM terminates abruptly due to a `System.exit()` call or a fatal error such as `OutOfMemoryError`.

### 4. What happens if there is a return statement in the try or catch block? Will the finally block still execute?
Yes, the `finally` block will still execute even if there is a `return` statement in the `try` or `catch` block. The return value will only be returned after the `finally` block has executed.

### 5. Can a finally block itself throw an exception? What would happen in such a case?
Yes, a `finally` block can throw an exception. If an exception is thrown in the `finally` block, it will override any exception that was thrown in the `try` or `catch` block, potentially hiding it.

## throw and throws Keywords

### 1. What is the difference between `throw` and `throws` in Java?
The `throw` keyword is used to explicitly throw an exception from a method or block of code. The `throws` keyword is used in a method signature to declare that the method might throw one or more exceptions.

### 2. When would you use the `throw` keyword in your code?
You would use the `throw` keyword when you want to explicitly throw an exception in response to a specific condition, such as invalid input.

### 3. How do you declare that a method throws an exception using the `throws` keyword?
You declare that a method throws an exception by adding the `throws` keyword followed by the exception type(s) to the method signature. For example: `public void myMethod() throws IOException`.

### 4. Can a constructor throw an exception? How would you handle it?
Yes, a constructor can throw an exception. To handle it, the calling code must catch the exception or declare it using the `throws` clause in the calling method.

### 5. What happens if a method that declares a checked exception does not handle it and does not propagate it with `throws`?
If a method declares a checked exception but does not handle it or propagate it with `throws`, the code will not compile.

## Custom Exceptions

### 1. How do you create a custom exception in Java?
To create a custom exception, you extend either the `Exception` class (for checked exceptions) or the `RuntimeException` class (for unchecked exceptions). You can also add constructors and methods as needed.

### 2. Why would you need to create a custom exception?
Custom exceptions allow you to create meaningful exception types that can provide more specific information about errors in your application, improving the clarity and robustness of your error handling.

### 3. What are the steps to create a custom checked exception?
To create a custom checked exception:
1. Create a new class that extends `Exception`.
2. Define one or more constructors in the class, including a constructor that accepts a message and a cause.

### 4. How do you add additional fields or methods to a custom exception?
You can add fields and methods to a custom exception class like any other class. For example, you might add a field to store an error code and a method to retrieve it.

### 5. Can you provide an example of when you would use a custom runtime exception?
You might use a custom runtime exception when you want to indicate a specific programming error or business rule violation that should not be caught by most methods. For example, throwing `InvalidStateException` when an object is in an unexpected state.

## Handling Multiple Exceptions

### 1. How does Java handle multiple exceptions in a single try block?
Java allows multiple `catch` blocks to handle different exceptions thrown by the same `try` block. Each `catch` block can handle a specific type of exception.

### 2. Can you catch multiple exceptions in a single catch block? How?
Yes, starting with Java 7, you can catch multiple exceptions in a single `catch` block by separating the exception types with a pipe (`|`) character.

### 3. What are the advantages of multi-catch blocks introduced in Java 7?
Multi-catch blocks reduce code duplication by allowing you to handle different exceptions with the same code, making your code cleaner and easier to maintain.

### 4. How does exception handling work with inheritance and multiple catch blocks?
When handling exceptions with inheritance, the catch blocks should be ordered from most specific to most general. If a general exception is caught first, the more specific exceptions will be unreachable.

### 5. What happens if multiple exceptions occur in a try block, and only one catch block is defined?
If multiple exceptions occur, only the first exception that matches a `catch` block will be caught and handled.

# Exception Propagation

### 1. What is exception propagation in Java?
Exception propagation in Java refers to the process by which an exception is passed (or propagated) from one method to another along the call stack. When an exception occurs in a method, it can either be handled within that method or be thrown to the calling method. This continues until the exception is caught and handled, or it reaches the top of the call stack and causes the program to terminate.

### 2. How does exception propagation work in a method call stack?
When an exception is thrown in a method, the Java runtime checks if there is a corresponding `catch` block within the method. If not, the exception is propagated to the method that called the current method. This continues up the call stack until the exception is either caught by a method higher up or reaches the `main()` method. If the exception is not caught by any method, the program will terminate, and the exception's stack trace will be printed.

### 3. Can you explain the concept of rethrowing an exception?
Rethrowing an exception occurs when an exception is caught in a `catch` block and then thrown again to be handled by another `catch` block higher up in the call stack. This allows for a specific method to log or modify the exception before passing it on to another method for further handling. This can be done using the `throw` keyword.

### 4. How do checked and unchecked exceptions behave differently during propagation?
- **Checked exceptions** must be either caught or declared in the `throws` clause of a method. If a method does not handle a checked exception, it must declare it in its `throws` clause, allowing the exception to propagate up the call stack.
- **Unchecked exceptions** (runtime exceptions) do not need to be declared or caught. They automatically propagate up the call stack without requiring any specific handling.

### 5. What are the best practices for handling exceptions that propagate through multiple methods?
- **Handle exceptions at the appropriate level**: Only catch exceptions where you can actually handle them meaningfully. Otherwise, let them propagate.
- **Use custom exceptions**: Define custom exceptions to provide more context about the error.
- **Log exceptions**: Log exceptions at the point where they are caught to preserve the stack trace and understand the cause.
- **Avoid catching generic exceptions**: Catch specific exceptions to avoid masking issues.
- **Clean up resources**: Ensure that resources are properly closed using try-with-resources or `finally` blocks, especially if the exception is propagated.

# try-with-resources Statement (Automatic Resource Management)

### 1. What is the try-with-resources statement in Java?
The try-with-resources statement in Java is a special form of the `try` statement that automatically closes resources (like files, database connections, etc.) after they are used. It ensures that resources are properly closed regardless of whether an exception occurs or not, reducing the likelihood of resource leaks.

### 2. How does try-with-resources improve resource management in Java?
Try-with-resources simplifies resource management by automatically closing resources at the end of the `try` block, eliminating the need for a `finally` block to manually close resources. This ensures that resources are always released, reducing the risk of memory leaks and other resource-related issues.

### 3. What are the requirements for a resource to be used with try-with-resources?
For a resource to be used with try-with-resources, it must implement the `AutoCloseable` interface. This interface has a single method, `close()`, which is automatically called when the `try` block is exited.

### 4. Can you nest try-with-resources statements? How does it affect resource management?
Yes, you can nest try-with-resources statements. Nested try-with-resources statements allow you to manage multiple resources that depend on each other. Each resource in the nested try blocks will be closed in reverse order of their creation, ensuring proper release of resources.

### 5. How does the try-with-resources statement differ from a traditional try-catch-finally block?
- **Automatic resource management**: Try-with-resources automatically closes resources, while in a traditional try-catch-finally block, resources must be manually closed in the `finally` block.
- **Less boilerplate code**: Try-with-resources reduces the amount of code needed to manage resources compared to a traditional try-catch-finally block.
- **Guaranteed resource closure**: With try-with-resources, resources are always closed, even if an exception occurs. In a traditional block, resources may not be closed if an exception occurs before the `finally` block is reached.

## Summary

- Exception handling ensures that runtime errors are caught and handled without crashing the program.
- Use `try-catch` blocks to handle exceptions.
- `finally` is used for cleanup tasks and always executes.
- `throw` and `throws` help manage custom and expected exceptions.
- Handling multiple exceptions, creating custom exceptions, and understanding propagation are key to robust error management.
- The `try-with-resources` statement simplifies resource management by automatically closing resources.
