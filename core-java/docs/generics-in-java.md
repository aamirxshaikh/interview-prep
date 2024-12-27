# [Generics in Java](https://github.com/aamirxshaikh/interview-prep/tree/main/core-java/src/main/java/com/interviewprep/generics_in_java)

## 1. Introduction to Generics

Generics were introduced in Java 5 to provide a way to create classes, interfaces, and methods with type parameters.
This allows code to be more reusable, type-safe, and less error-prone. With generics, you can create classes and methods
that operate on a variety of data types.

Example:

```java
public class Box<T> {
  private T value;

  public Box(T value) {
    this.value = value;
  }

  public T getValue() {
    return value;
  }
}
```

## 2. Type Parameters and Wildcards

Type parameters in generics are placeholders for types passed at instantiation. Common type parameters include `<T>`,
`<E>`, `<K>`, and `<V>`. Wildcards, represented by `?`, allow flexibility in specifying types without explicitly
defining them.

Example:

```java
public void printList(List<?> list) {
  for (Object item : list) {
    System.out.println(item);
  }
}
```

## 3. Generic Classes and Interfaces

A generic class allows you to define a class with type parameters, enabling it to work with any data type. Similarly,
generic interfaces work with unspecified data types, useful for building flexible APIs.

Example:

```java
public interface Container<T> {
  void add(T item);

  T get();
}
```

## 4. Generic Methods

A generic method allows you to specify type parameters for individual methods. This can be useful when the method's type
doesn't need to match the class's generic type.

Example:

```java
public <T> void display(T item) {
  System.out.println(item);
}
```

## 5. Bounded Types in Generics

Bounded types restrict the type parameters to a specified range, typically a superclass or interface, using the
`extends` keyword.

Example:

```java
public <T extends Number> void printDoubleValue(T value) {
  System.out.println(value.doubleValue());
}
```

## 6. Wildcards: `? extends` and `? super`

- `? extends T`: Accepts T or any subclass of T, known as an upper-bounded wildcard.
- `? super T`: Accepts T or any superclass of T, known as a lower-bounded wildcard.

Example:

```java
public void addNumbers(List<? super Integer> list) {
  list.add(1);
  list.add(2);
}
```

## 7. Erasure and Limitations of Generics

Type erasure removes generic type information at runtime, making generic types only available at compile time.
Limitations include the inability to create generic arrays, perform instanceof checks, and use primitives as type
parameters.

## 8. Benefits of Using Generics

Generics improve code reusability, provide compile-time type safety, and reduce the need for casting. They help create
more flexible and maintainable code.

## 9. Generics and Collections

Collections heavily use generics to allow type-safe storage and retrieval of elements, making them versatile and
reducing errors. Collections like `List<T>`, `Map<K, V>`, and `Set<E>` rely on generics for flexible data handling.

# Interview Questions

## 1 Introduction to Generics

1. What is generics in Java, and why is it used?
2. How do generics improve type safety in Java?
3. Can you explain type erasure in the context of generics?
4. What are the key advantages of using generics in Java?

## 2 Type Parameters and Wildcards

1. What are type parameters in generics?
2. What is the difference between `T`, `E`, `K`, and `V` in generic types?
3. How are wildcards (`?`) used in generics?
4. Explain the difference between `? extends` and `? super`.

## 3 Generic Classes and Interfaces

1. How do you define a generic class in Java?
2. Can an interface be generic? Provide an example.
3. Explain the significance of the diamond operator (`<>`) in generics.

## 4 Generic Methods

1. How do you define a generic method in Java?
2. Can generic methods exist in non-generic classes? Provide an example.
3. Explain how a generic method can handle multiple type parameters.

## 5 Bounded Types in Generics

1. What are bounded type parameters in Java generics?
2. How do you define an upper bound for a type parameter?
3. Explain the use of multiple bounds in generic types.

## 6 Wildcards: `? extends` and `? super`

1. What is the purpose of `? extends` in generics?
2. When should you use `? super` in generics?
3. How do wildcards contribute to generic method flexibility?

## 7 Erasure and Limitations of Generics

1. What is type erasure in Java generics, and why does it exist?
2. What are some limitations of Java generics?
3. Why can't you create an array of a generic type?

## 8 Benefits of Using Generics

1. How do generics help in reducing runtime errors?
2. Explain how generics provide stronger type checks at compile time.
3. How do generics eliminate the need for explicit type casting?

## 9 Generics and Collections

1. How are generics used in the Java Collections Framework?
2. Provide examples of generic usage in `List`, `Set`, and `Map`.
3. How do generic collections improve code readability and maintainability?

## Summary

Generics in Java provide a powerful way to create reusable, type-safe code that works with a variety of data types.
