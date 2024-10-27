# Java Collections Framework

## 1. Overview of Collections Framework

The Java Collections Framework (JCF) is a unified architecture for representing and manipulating collections, enabling
developers to work with data more efficiently and effectively. It provides a set of interfaces, implementations, and
algorithms to handle groups of objects.

![img_2.png](images/img_1.png)

## 2. Collection Interfaces: List, Set, Queue, Map

### List

The `List` interface represents an ordered collection (also known as a sequence). It allows duplicate elements and
provides methods to manipulate the size of the list. Common implementations include:

- **ArrayList**: Resizable array implementation of the `List` interface.
- **LinkedList**: Doubly-linked list implementation, allowing for faster insertion and deletion of elements.
- **Vector**: Similar to `ArrayList`, but synchronized and thus thread-safe.
- **Stack**: Represents a last-in-first-out (LIFO) stack of objects.

### Set

The `Set` interface represents a collection that cannot contain duplicate elements. Implementations include:

- **HashSet**: Hash table-based implementation; allows null elements.
- **LinkedHashSet**: Maintains a linked list of the entries to preserve the insertion order.
- **TreeSet**: Implements a navigable set using a red-black tree, ensuring elements are sorted.

### Queue

The `Queue` interface represents a collection designed for holding elements prior to processing. Common implementations
are:

- **PriorityQueue**: A queue that orders its elements based on their natural ordering or a specified comparator.
- **ArrayDeque**: Resizable-array implementation of the `Deque` interface, allowing fast insertion and removal operations.
- **LinkedList**: Also implements the `Queue` interface, providing flexibility for queue operations.

### Map

The `Map` interface represents a collection of key-value pairs, with unique keys. Implementations include:

- **HashMap**: Hash table-based implementation of the `Map` interface, allowing null values and one null key.
- **LinkedHashMap**: Maintains a linked list of entries for predictable iteration order.
- **TreeMap**: Implements a red-black tree to provide a sorted map.
- **Hashtable**: Similar to `HashMap`, but synchronized and does not allow null keys or values.

## 3. Implementations of Collection Interfaces

### List

- `List` is an interface in the Java Collections Framework.
- It represents an ordered collection (also known as a sequence).
- Lists can contain duplicate elements, and they maintain insertion order.
- Elements can be accessed by their position (index) in the list.
- It is a part of the `java.util` package.

### Commonly Used List Implementations

#### `ArrayList`

`ArrayList` is based on a dynamically resizable array. It provides random access to elements, making it very fast when
accessing elements by index. When elements are added, and the internal array is full, a new array is created with 1.5
times the current capacity, and the existing elements are copied into the new array.

- Backed by a dynamic array.
- Provides fast random access (get and set operations) with O(1) complexity.
- Adding or removing elements at the end is generally O(1).
- Adding or removing elements in the middle requires shifting, which results in O(n) complexity.
- Allows `null` values.

#### Internal Working:

- `ArrayList` uses an array internally.
- When elements are added, and the internal array is full, a new array is created with 1.5 times the current capacity,
  and existing elements are copied into the new array.
- It maintains an internal `size` variable that tracks the number of elements.

#### Example:

```java
import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
  public static void main(String[] args) {
    List<String> fruits = new ArrayList<>();
    fruits.add("Apple");
    fruits.add("Banana");
    fruits.add("Mango");
    fruits.add("Apple"); // Duplicates are allowed

    System.out.println(fruits); // Output: [Apple, Banana, Mango, Apple]
  }
}
```

- **Time Complexity**:
    - Access: O(1) (Random access is fast, like an array.)
    - Insert (at end): O(1) (Amortized). If resizing is needed (e.g., if the internal array is full), it becomes O(n)
      due to the cost of copying elements.
    - Insert (at index): O(n) (Elements need to be shifted to the right.)
    - Remove: O(n) (Elements need to be shifted to the left after removal.)

#### `LinkedList`

`LinkedList` is a doubly-linked list. Each element (node) contains a data part and two pointers to the next and previous
elements. This makes it efficient for inserting or deleting elements at the beginning or middle but slower for accessing
elements by index.

- Implements a doubly-linked list.
- Allows `null` values.
- Good for scenarios where frequent addition or removal of elements occurs at the beginning or middle.
- Accessing elements is slower than `ArrayList` because it needs to traverse the list.
- Suitable for implementing queues and deques.

#### Internal Working:

- `LinkedList` consists of nodes, where each node contains data, a reference to the next node, and a reference to the
  previous node.
- It uses a `head` and `tail` pointer to track the first and last nodes.
- It is efficient for insertions or deletions at the beginning or end due to the doubly-linked structure.

#### Example:

```java
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
  public static void main(String[] args) {
    List<String> cities = new LinkedList<>();
    cities.add("New York");
    cities.add("Los Angeles");
    cities.add("Chicago");

    System.out.println(cities); // Output: [New York, Los Angeles, Chicago]
  }
}
```

- **Time Complexity**:
    - Access: O(n) (Needs to traverse from the head or tail to the desired index.)
    - Insert (at start or end): O(1) (Inserting at the beginning or end is quick as there's a reference to the first and
      last node.)
    - Insert (at index): O(n) (Needs traversal to reach the desired index.)
    - Remove (at start or end): O(1) (Removing the first or last node is quick as there's a reference to the first and
      last node.)
    - Remove (at index): O(n) (Needs traversal to reach the desired index.)

#### `Vector`

`Vector` is similar to `ArrayList`, but it is synchronized, making it thread-safe. However, this synchronization results
in a performance overhead when used in a single-threaded environment.

- Synchronized version of `ArrayList`.
- Thread-safe but slower due to synchronization overhead.
- Provides methods like `addElement()` which is not part of the `List` interface.
- Allows `null` values.
- Rarely used in modern applications where `ArrayList` is preferred with external synchronization if needed.
- Vectors grow by doubling their size when they reach capacity.

### Internal Working:

- `Vector` internally uses a dynamic array like `ArrayList`.
- It is synchronized, making it thread-safe for multi-threaded environments.
- The size increases by doubling when the internal array reaches its capacity.

#### Example:

```java
import java.util.Vector;
import java.util.List;

public class VectorExample {
  public static void main(String[] args) {
    List<Integer> numbers = new Vector<>();
    numbers.add(10);
    numbers.add(20);
    numbers.add(30);

    System.out.println(numbers); // Output: [10, 20, 30]
  }
}
```

- **Time Complexity**:
    - Access: O(1) (Random access is fast, like an array.)
    - Insert (at end): O(1) (Amortized). If resizing is needed (e.g., if the internal array is full), it becomes O(n)
      due to the cost of copying elements.
    - Insert (at index): O(n) (Elements need to be shifted to the right.)
    - Remove: O(n) (Elements need to be shifted to the left after removal.)

#### `Stack`

The `Stack` class is based on the `Vector` class, meaning it inherits all the properties and methods of `Vector`. This
includes dynamic array behavior, where elements are stored in an array that can resize itself when needed.

- A subclass of `Vector` that represents a last-in, first-out (LIFO) stack of objects.
- Provides methods like `push()`, `pop()`, `peek()`, and `empty()`.
- Thread-safe but rarely used in modern applications where `Deque` is preferred.
- When you push an element, it adds to the end of the array.
- When you pop or peek, it accesses or removes the element at the last index of the array.

### Internal Working:

- `Stack` uses the same dynamic array mechanism as `Vector`.
- When you push an element, it adds to the end of the array.
- When you pop or peek, it accesses or removes the element at the last index of the array.
- The LIFO behavior is achieved by adding/removing elements from the end.

#### Example:

```java
import java.util.Stack;

public class StackExample {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();
    stack.push("First");
    stack.push("Second");
    stack.push("Third");

    System.out.println(stack.pop()); // Output: Third (LIFO)
    System.out.println(stack.peek()); // Output: Second (next element to be popped)
  }
}
```

- **Time Complexity**:
    - Access: O(n) (Since direct access is not typically used, stack operations like peek() and search() are more
      common.)
    - Push (Insert at end): O(1) (Amortized). Resizing can make it O(n).
    - Pop (Remove at end): O(1)
    - Peek: O(1)
    - Search: O(n) (Because it may need to iterate through the stack.)

### When to Use Which `List` Implementation?

- Use `ArrayList` if:
    - You need fast random access to elements.
    - Insertion and deletion operations are mostly at the end.
- Use `LinkedList` if:
    - You have frequent insertions and deletions in the middle or beginning.
    - Memory consumption is not a major concern.
- Use `Vector` or `Stack` if:
    - You need a thread-safe version of `ArrayList` or a stack behavior with synchronization.

### Important Methods in `List` Interface

- `add(E e)`: Adds an element to the list.
- `get(int index)`: Returns the element at the specified position.
- `remove(int index)`: Removes the element at the specified position.
- `size()`: Returns the number of elements in the list.
- `isEmpty()`: Checks if the list is empty.
- `contains(Object o)`: Checks if the list contains the specified element.
- `clear()`: Removes all elements from the list.

### Differences between `List` Implementations

| Feature                       | `ArrayList`                                      | `LinkedList`                                          | `Vector`                                  | `Stack`                                                 |
|-------------------------------|--------------------------------------------------|-------------------------------------------------------|-------------------------------------------|---------------------------------------------------------|
| **Underlying Data Structure** | Resizable array                                  | Doubly linked list                                    | Resizable array                           | Inherits from `Vector`                                  |
| **Performance**               | Fast random access (O(1) for `get`)              | Slow random access (O(n) for `get`)                   | Similar to `ArrayList` but synchronized   | Similar to `Vector` but LIFO behavior                   |
| **Insertion Performance**     | Adding at the end is O(1) (amortized)            | Adding at the end is O(1)                             | Adding at the end is O(1) (amortized)     | Push is O(1)                                            |
| **Removal Performance**       | Removing by index is O(n)                        | Removing from the beginning is O(1)                   | Removing by index is O(n)                 | Pop is O(1)                                             |
| **Synchronization**           | Not synchronized                                 | Not synchronized                                      | Synchronized                              | Synchronized                                            |
| **Memory Efficiency**         | Less memory overhead due to array storage        | More memory overhead due to node storage              | Less memory overhead due to array storage | Similar to `Vector`                                     |
| **Use Cases**                 | Best for read-heavy operations and random access | Best for insertions/deletions at the beginning/middle | Use when synchronization is needed        | Use for LIFO data structures (e.g., undo functionality) |

### Set

A `Set` is a part of the Java Collections Framework. It is an interface that extends the `Collection` interface and
represents a collection of unique elements. Sets do not allow duplicate values, which means each element in a set must
be unique. `Set` is implemented by various classes in the Java Collections Framework.

- **No Duplicates**: A `Set` cannot contain duplicate elements.
- **Unordered**: The elements in a `Set` are not stored in any particular order.
- **Null Elements**: Some implementations of `Set` allow null elements (e.g., `HashSet`), while others may not (e.g.,
  `TreeSet`).

### Commonly Used Set Implementations

#### `HashSet`

- `HashSet` is the most commonly used implementation of the `Set` interface.
- It **does not maintain any order** of the elements.
- It allows **one null element**.
- **Internally** uses a **hash table** for storing elements.
- It provides **constant-time performance (O(1))** for basic operations like add, remove, and contains (under ideal
  conditions).

#### Internal Working:

#### Underlying Data Structure

Internally, `HashSet` uses a `HashMap` instance to store elements. The `HashSet` class is essentially a wrapper around
`HashMap` with only keys being stored (in a conceptual sense). The values are all identical and use a constant object.

```java
private transient HashMap<E, Object> map;

// A dummy value to associate with an Object in the backing Map
private static final Object PRESENT = new Object();
```

- **Keys in HashMap**: Every element in the HashSet is stored as a key in the HashMap.
- **Values in HashMap**: The value for all keys in the HashMap is the same constant placeholder object, typically named
  PRESENT.

#### Adding an Element

When an element is added to a `HashSet`, the following steps are performed:

1. **Hashing**: The hash code of the element is calculated using its `hashCode()` method.
2. **Index Calculation**: The hash code is used to find an appropriate bucket (index) in the underlying `HashMap` array.
3. **Checking for Duplicates**: The `equals()` method is used to check if the element already exists in the bucket. If
   an equal element is found, the new element is not added (since duplicates are not allowed).
4. **Storing**: If no duplicate is found, the element is added to the bucket at the calculated index in the `HashMap`.

**Example:**

```java
HashSet<String> set = new HashSet<>();
set.add("apple"); // "apple" is hashed, and if not present, it's stored in HashMap
```

**Behind the scenes:**

```java
private transient HashMap<E, Object> map; // internal HashMap instance
private static final Object PRESENT = new Object();

public boolean add(E e) {
  return map.put(e, PRESENT) == null;
}
```

#### Retrieving an Element

Since a `HashSet` does not allow direct access to elements (as it does not maintain ordering), elements can only be
accessed using iteration, not by index.

#### Removing an Element

When an element is removed:

1. **Hashing**: The hash code of the element is calculated to find the corresponding bucket.
2. **Equality Check**: The bucket is traversed using the `equals()` method to find the element.
3. **Deletion**: If the element is found, it is removed from the underlying `HashMap`.

#### Handling Collisions

- **Collisions** occur when multiple elements hash to the same index. In such cases, `HashSet` uses a linked list or a
  balanced tree structure (in case of many collisions) within the bucket to store multiple entries.
- If the number of elements in a single bucket grows beyond a certain threshold, the bucket is transformed into a
  balanced binary tree (red-black tree) to improve lookup performance.

#### Resizing

If the number of elements exceeds the product of the load factor (default 0.75) and the current capacity, the underlying
`HashMap` automatically resizes, which involves:

1. **Doubling** the size of the internal array.
2. **Rehashing** all existing elements into the new array.

#### Example

```java
import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
  public static void main(String[] args) {
    Set<String> fruits = new HashSet<>();
    fruits.add("Apple");
    fruits.add("Banana");
    fruits.add("Orange");
    fruits.add("Apple"); // Duplicate, will be ignored

    System.out.println(fruits); // Output: [Banana, Orange, Apple] (Order may vary)
  }
}
```

- **Time Complexity**:
    - Access: O(1) (not applicable for sets, as they don't allow accessing elements by index)
    - Insert: O(1) (amortized, but can degrade to O(n) if many elements hash to the same bucket)
    - Remove: O(1) (amortized, similar conditions as insert)

#### `LinkedHashSet`

- `LinkedHashSet` extends `HashSet` and **maintains insertion order**.
- It uses a **doubly-linked list** along with the hash table.
- Allows **one null element**.
- Performance is slightly lower than `HashSet` due to the extra overhead of maintaining the **linked list**.

#### Internal Working:

#### Underlying Data Structure

Internally, `LinkedHashSet` uses a combination of `HashMap` and a doubly-linked list. This allows it to maintain the
insertion order of elements while providing the set functionalities.

`LinkedHashSet` extends `HashSet` and relies on a `LinkedHashMap` to store elements. This combination provides both the
benefits of fast lookup times due to hashing and the ability to iterate in insertion order.

```java
public class LinkedHashSet<E> extends HashSet<E> implements Set<E>, Cloneable, java.io.Serializable {
  private transient LinkedHashMap<E, Object> map;
  // Other methods and constructor implementations
}
```

- **Keys in LinkedHashMap**: Every element in the `LinkedHashSet` is stored as a key in a `LinkedHashMap`.
- **Values in LinkedHashMap**: The value for all keys in `LinkedHashMap` is a constant placeholder object named
  `PRESENT` (similar to `HashSet`).

#### Adding an Element

When an element is added to a `LinkedHashSet`, the following steps are performed:

1. **Hashing**: The hash code of the element is calculated using its `hashCode()` method.
2. **Index Calculation**: The hash code is used to find an appropriate bucket (index) in the underlying `LinkedHashMap`
   array.
3. **Checking for Duplicates**: The `equals()` method is used to check if the element already exists in the bucket. If
   an equal element is found, the new element is not added (since duplicates are not allowed).
4. **Storing and Maintaining Order**: If no duplicate is found, the element is added to the bucket at the calculated
   index in the `LinkedHashMap`, and its position in the linked list is recorded to maintain insertion order.

#### Example:

```java
LinkedHashSet<String> linkedSet = new LinkedHashSet<>();
linkedSet.add("apple"); // "apple" is hashed, checked for uniqueness, and stored in LinkedHashMap.
```

#### Behind the Scenes:

```java
private transient LinkedHashMap<E, Object> map; // internal LinkedHashMap instance
private static final Object PRESENT = new Object();

public boolean add(E e) {
  return map.put(e, PRESENT) == null;
}
```

#### Maintaining Insertion Order

`LinkedHashMap`, which `LinkedHashSet` uses internally, maintains a doubly-linked list to keep track of the order of
insertion. This ensures that the iteration order of `LinkedHashSet` is the same as the order in which elements were
inserted.

#### Retrieving an Element

Elements in a `LinkedHashSet` can be accessed by iterating through the set. Unlike a `HashSet`, a
`LinkedHashSet` guarantees that elements are iterated in their insertion order.

#### Removing an Element

When an element is removed:

1. **Hashing**: The hash code of the element is calculated to find the corresponding bucket.
2. **Equality Check**: The bucket is traversed using the `equals()` method to find the element.
3. **Deletion**: If the element is found, it is removed from the underlying `LinkedHashMap`, and its links in the
   doubly-linked list are updated to maintain order.

#### Handling Collisions

- **Collisions** occur when multiple elements hash to the same index. In such cases, `LinkedHashMap` (and consequently
  `LinkedHashSet`) uses a linked list or a balanced tree structure within the bucket to store multiple entries.
- If the number of elements in a single bucket grows beyond a certain threshold, the bucket is transformed into a
  balanced binary tree (red-black tree) to improve lookup performance.

#### Resizing

If the number of elements exceeds the product of the load factor (default 0.75) and the current capacity, the underlying
`LinkedHashMap` automatically resizes, which involves:

1. **Doubling** the size of the internal array.
2. **Rehashing** all existing elements into the new array.

#### Example

```java
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExample {
  public static void main(String[] args) {
    Set<String> cities = new LinkedHashSet<>();
    cities.add("New York");
    cities.add("London");
    cities.add("Tokyo");
    cities.add("New York"); // Duplicate, will be ignored

    System.out.println(cities); // Output: [New York, London, Tokyo]
  }
}
```

- **Time Complexity**:
    - Access: O(1) (not applicable for sets, as they don't allow accessing elements by index)
    - Insert: O(1) (amortized, maintains insertion order)
    - Remove: O(1) (amortized, similar conditions as insert)
    - Iteration: O(n) (preserves insertion order)

#### `TreeSet`

- `TreeSet` is an implementation of the `SortedSet` interface and stores elements in **sorted order**.
- It uses a **Red-Black tree** internally.
- Does not allow **null elements**.
- Provides **logarithmic time performance (O(log n))** for add, remove, and contains operations.

#### Internal Working:

#### Underlying Data Structure

Internally, `TreeSet` uses a `TreeMap` instance to store elements. The `TreeSet` class is essentially a wrapper around
`TreeMap` with only keys being stored (in a conceptual sense). `TreeSet` maintains a sorted order of elements using the
natural ordering of elements or a provided comparator.

```java
private transient NavigableMap<E, Object> m;
private static final Object PRESENT = new Object();
```

- **Keys in TreeMap**: Every element in the `TreeSet` is stored as a key in the underlying `TreeMap`.
- **Values in TreeMap**: The value for all keys in the `TreeMap` is the same constant placeholder object, typically
  named `PRESENT`.

#### Adding an Element

When an element is added to a `TreeSet`, the following steps are performed:

1. **Comparison**: The element to be added is compared with existing elements using either its `compareTo()` method or a
   provided `Comparator`.
2. **Checking for Duplicates**: If an equal element is found using the comparison, the new element is not added (since
   duplicates are not allowed).
3. **Inserting**: If no duplicate is found, the element is inserted into the underlying `TreeMap` as a key, maintaining
   the sorted order.

**Example:**

```java
TreeSet<String> set = new TreeSet<>();
set.add("banana");
set.add("apple");
set.add("cherry");
```

**Behind the scenes:**

```java
private transient NavigableMap<E, Object> m;
private static final Object PRESENT = new Object();

public boolean add(E e) {
  return m.put(e, PRESENT) == null;
}
```

#### Retrieving an Element

Since a `TreeSet` maintains a sorted order of elements, it provides methods to retrieve elements like `first()`,
`last()`, `ceiling()`, `floor()`, `higher()`, and `lower()`, based on specific criteria. Direct access to elements by
index is not allowed.

#### Removing an Element

When an element is removed:

1. **Comparison**: The element to be removed is compared with existing elements using either the natural order or a
   provided `Comparator`.
2. **Equality Check**: If an equal element is found in the underlying `TreeMap`, it is removed.
3. **Deletion**: If the element is found, it is removed from the underlying `TreeMap`.

#### Sorting Mechanism

- `TreeSet` uses a red-black tree internally, which is a self-balancing binary search tree. This ensures that all
  operations such as insertion, deletion, and lookup are performed in `O(log n)` time.

#### Handling Duplicates

- Duplicates are not allowed in a `TreeSet`. If an attempt is made to add an element that is already present (based on
  comparison), the new element is not added, and the set remains unchanged.

#### Resizing

- Unlike a `HashSet`, there is no concept of resizing in a `TreeSet` since the underlying `TreeMap` does not rely on an
  array but rather on a balanced binary tree.

#### Example

```java
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
  public static void main(String[] args) {
    Set<Integer> numbers = new TreeSet<>();
    numbers.add(5);
    numbers.add(1);
    numbers.add(10);
    numbers.add(2);

    System.out.println(numbers); // Output: [1, 2, 5, 10] (Sorted order)
  }
}
```

- **Time Complexity**:
    - Access: O(log n) (for operations like first(), last(), etc.)
    - Insert: O(log n) (for maintaining sorted order)
    - Remove: O(log n)
    - Iteration: O(n) (in sorted order)

### When to Use Which Set Implementation?

- **Use `HashSet`** if you do not need to maintain the order of elements and want fast insertion, deletion, and lookup.
- **Use `LinkedHashSet`** if you want to maintain the insertion order of elements.
- **Use `TreeSet`** if you need a sorted set of elements.

### Important Methods of Set

- `add(E e)`: Adds the specified element to the set if it is not already present.
- `remove(Object o)`: Removes the specified element from the set if it is present.
- `contains(Object o)`: Returns `true` if the set contains the specified element.
- `size()`: Returns the number of elements in the set.
- `isEmpty()`: Returns `true` if the set contains no elements.
- `clear()`: Removes all elements from the set.

### Differences between `Set` Implementations

| Feature              | `HashSet`                                                     | `LinkedHashSet`                                         | `TreeSet`                                                  |
|----------------------|---------------------------------------------------------------|---------------------------------------------------------|------------------------------------------------------------|
| Order                | No specific order                                             | Maintains insertion order                               | Sorted (Natural or Custom Comparator)                      |
| Underlying Structure | Hash table                                                    | Hash table + Linked list                                | Red-Black tree                                             |
| Null Values          | Allows one null                                               | Allows one null                                         | Does not allow null                                        |
| Performance          | Fastest for basic operations (O(1) for add, remove, contains) | Slightly slower than `HashSet` due to maintaining order | Slower (O(log n) for add, remove, contains) due to sorting |

### 3. Queue

The **`Queue` interface** in Java is a part of the Java Collections Framework. It represents a collection designed for
holding elements before processing, following the First-In-First-Out (FIFO) principle. Queues are typically used to
order elements for processing in the same order they were added.

- **FIFO (First-In-First-Out) Order**: Elements in a `Queue` are processed in the order they are added. The element
  inserted first is the one removed first. Some implementations might not strictly adhere to this, such as priority
  queues.
- **Insertion at the Tail, Removal from the Head**: By default, elements are added at the end (tail) and removed from
  the start (head) of the queue.
- **Extends Collection Interface**: `Queue` extends the `Collection` interface, meaning it inherits its basic collection
  methods like `add`, `remove`, `size`, and more.
- **Two Types of Queue Operations**: There are two sets of methods in the `Queue` interface:
    - **Throws Exception**: `add()` (for adding) and `remove()` (for removing) throw exceptions on failure.
    - **Returns Special Value**: `offer()` (for adding) and `poll()` (for removing) return special values (`false` or
      `null`) on failure.
- **Various Implementations**: `Queue` has various implementations like `PriorityQueue`, `ArrayDeque`, `LinkedList`,
  each with specific characteristics and uses.
- **Does Not Allow `null`**: In most implementations, inserting `null` elements is not allowed and can throw exceptions.

### Commonly Used Queue Implementations

#### `PriorityQueue`

- `PriorityQueue` is an implementation of the `Queue` interface that orders its elements based on their natural ordering
  or using a specified comparator.
- **Maintains elements in a priority order**, where the element with the highest priority is at the head of the queue.
- **Does not permit `null` elements**.
- **Not thread-safe**; requires external synchronization if accessed by multiple threads.
- **Does not guarantee ordering** of elements with equal priority.

#### Internal Working:

#### Underlying Data Structure

Internally, `PriorityQueue` uses a **resizable array** (similar to a heap) to store elements. The internal array grows
as needed.

```java
private transient Object[] queue; // Array to store elements
```

- **Binary Heap**: The elements are organized using a binary heap structure. In a binary heap:
    - The **root node** represents the element with the highest priority (or smallest/largest based on the comparator).
    - New elements are added at the end of the array and then sifted up to maintain the heap order.

#### Adding an Element

1. **Adding to the end**: A new element is added at the end of the internal array.
2. **Sifting Up**: The element is then sifted up to restore the heap order, ensuring that the highest priority element
   is at the head.

#### Example:

```java
PriorityQueue<Integer> queue = new PriorityQueue<>();
queue.add(10);
queue.add(5);
queue.add(20);
System.out.println(queue); // Output: [5, 10, 20] (order may vary based on natural ordering)
```

#### Removing an Element

When an element is removed, the following steps are performed:

1. **Replacing with the last element**: The element at the head is replaced with the last element in the array.
2. **Sifting Down**: The new head is sifted down to maintain the heap order.

- **Time Complexity**:
    - Insertion: O(log n) *(Uses a binary heap to maintain order while adding elements)*
    - Deletion (removal of the head): O(log n) *(Reorders the heap structure when removing elements)*
    - Access (peek/element): O(1) *(Directly accesses the head element)*
    - Search: O(n) *(Sequentially searches through unsorted heap elements)*

#### `ArrayDeque`

- `ArrayDeque` is a **resizable array implementation** of the `Deque` interface.
- It allows **fast insertion and removal operations** from both ends (head and tail).
- **No capacity restrictions** by default, and **null elements are not permitted**.

#### Internal Working:

#### Underlying Data Structure

Internally, `ArrayDeque` uses a **circular array** to store elements. The circular array allows wrapping around the ends
for efficient space utilization.

```java
transient Object[] elements; // Circular array to store elements
```

#### Adding an Element

1. **Adding at head**: Elements can be added at the beginning of the deque.
2. **Adding at tail**: Elements can also be added at the end.

#### Example:

```java
ArrayDeque<String> deque = new ArrayDeque<>();
deque.addFirst("First");
deque.addLast("Last");
System.out.println(deque); // Output: [First, Last]
```

#### Removing an Element

1. **Removing from head**: Elements can be removed from the beginning.
2. **Removing from tail**: Elements can be removed from the end.

- **Time Complexity**:
    - Insertion (enqueue) and Deletion (dequeue): O(1) (amortized) *(Efficiently resizes and maintains a circular
      buffer, reducing the need for element shifting)*
    - Access (peek/element): O(1) *(Accesses elements from the front or end without any traversal)*
    - Search: O(n) *(Sequential search through an array)*

#### `LinkedList`

LinkedList was already covered in the `List` section.

- **Flexibility**: LinkedList can also be used as a `Queue` due to its implementation of the `Deque` interface.
- Provides **efficient insertion and removal operations** at both ends (head and tail).
- As a queue, it can serve as a **FIFO (First-In-First-Out)** structure.

**Additional Information for Queue Perspective**:

1. **Adding Elements**: Elements can be added using methods like `add()`, `offer()`, `addLast()`.
2. **Retrieving Elements**: Use methods like `poll()`, `peek()`, or `removeFirst()` to retrieve or remove elements from
   the head.

### When to Use Which Queue Implementation

- **Use `PriorityQueue`**: When you need to prioritize elements in a natural or custom order. Priority queues are
  suitable when elements need to be processed based on their priority.
- **Use `ArrayDeque`**: When you need a resizable, circular buffer with efficient additions and removals from both ends.
  It is ideal for implementing stacks and queues.
- **Use `LinkedList`**: When you need a queue with efficient insertions and deletions, and ordering is not a primary
  concern. Additionally, if you require both `List` and `Deque` features, LinkedList is versatile enough to serve both
  purposes.

### Important Methods of the Queue Interface

- **add(E e)**: Inserts the specified element into the queue if possible. Throws an exception if the operation fails.
- **offer(E e)**: Inserts the specified element into the queue if possible. Returns `false` if the operation fails.
- **remove()**: Retrieves and removes the head of the queue. Throws an exception if the queue is empty.
- **poll()**: Retrieves and removes the head of the queue, or returns `null` if the queue is empty.
- **element()**: Retrieves, but does not remove, the head of the queue. Throws an exception if the queue is empty.
- **peek()**: Retrieves, but does not remove, the head of the queue, or returns `null` if the queue is empty.

### Differences Between `Queue` Implementations

| **Feature**              | **PriorityQueue**                    | **ArrayDeque**                   | **LinkedList**                  |
|--------------------------|--------------------------------------|----------------------------------|---------------------------------|
| **Ordering**             | Based on natural order or comparator | Insertion order                  | Insertion order                 |
| **Thread-Safe**          | No (use `PriorityBlockingQueue`)     | No                               | No                              |
| **Null Elements**        | Not Allowed                          | Not Allowed                      | Allowed                         |
| **Underlying Structure** | Binary Heap                          | Resizable Circular Array         | Doubly Linked List              |
| **Use Case**             | Priority-based processing            | Efficient Stack/Queue operations | General-purpose, flexible queue |

### 4. Map

The `Map` interface represents a collection of key-value pairs, with unique keys. Implementations include:

- **HashMap**: Hash table-based implementation of the `Map` interface, allowing null values and one null key.
- **LinkedHashMap**: Maintains a linked list of entries for predictable iteration order.
- **TreeMap**: Implements a red-black tree to provide a sorted map.
- **Hashtable**: Similar to `HashMap`, but synchronized and does not allow null keys or values.

## Comparisons

### ArrayList vs. LinkedList

### Overview

| Feature              | `ArrayList`                                   | `LinkedList`                                                                            |
|----------------------|-----------------------------------------------|-----------------------------------------------------------------------------------------|
| **Implementation**   | Uses a dynamic array internally.              | Uses a doubly linked list internally.                                                   |
| **Memory Structure** | Stores elements in a contiguous memory block. | Stores elements as nodes, each containing data and pointers to previous and next nodes. |

### Performance Comparison

#### 1. Access Time

- **ArrayList**: `O(1)`
    - Explanation: Direct access is possible using the index since elements are stored in a contiguous memory block.
- **LinkedList**: `O(n)`
    - Explanation: To access an element, it needs to traverse from the head or tail to the specified index.

#### 2. Insertion

- **At End**:
    - **ArrayList**: `O(1)` (amortized)
        - Explanation: Adding an element at the end is usually quick unless resizing is needed. When the array is full,
          it resizes (typically 1.5 times its size), which takes `O(n)`.
    - **LinkedList**: `O(1)`
        - Explanation: Since there's a reference to the tail, adding an element at the end is straightforward.
- **At Start**:
    - **ArrayList**: `O(n)`
        - Explanation: Insertion at the start requires shifting all elements to the right.
    - **LinkedList**: `O(1)`
        - Explanation: Inserting at the start is quick as it updates the head reference.
- **At Index**:
    - **ArrayList**: `O(n)`
        - Explanation: Requires shifting elements to make space for the new element.
    - **LinkedList**: `O(n)`
        - Explanation: Needs to traverse to the specified index and then update pointers.

#### 3. Deletion

- **At End**:
    - **ArrayList**: `O(1)`
        - Explanation: Removing the last element is quick as no shifting is required.
    - **LinkedList**: `O(1)`
        - Explanation: Deleting the last element is fast due to the tail reference.
- **At Start**:
    - **ArrayList**: `O(n)`
        - Explanation: Removing the first element requires shifting all elements to the left.
    - **LinkedList**: `O(1)`
        - Explanation: Removing the first element is quick as it updates the head reference.
- **At Index**:
    - **ArrayList**: `O(n)`
        - Explanation: Requires shifting elements to fill the gap left by the removed element.
    - **LinkedList**: `O(n)`
        - Explanation: Needs to traverse to the specified index before removing and updating pointers.

#### 4. Memory Usage

- **ArrayList**:
    - More memory-efficient when storing simple data types as it doesn't require extra memory for pointers.
- **LinkedList**:
    - Uses more memory as each node stores additional pointers (references to the previous and next nodes).

### Use Cases

| **Scenario**                                | **Better Option**            | **Reason**                                                                    |
|---------------------------------------------|------------------------------|-------------------------------------------------------------------------------|
| **Frequent read operations**                | `ArrayList`                  | Provides faster random access (`O(1)` for accessing elements).                |
| **Frequent insertions/deletions at ends**   | `LinkedList`                 | No shifting of elements required, making operations `O(1)`.                   |
| **Memory-sensitive application**            | `ArrayList`                  | More space-efficient due to lack of additional pointers.                      |
| **Frequent insertions/deletions at middle** | `LinkedList` (if traversing) | Better if you need to avoid shifting elements, though traversal cost applies. |

### HashMap vs. TreeMap

- **HashMap**: Provides constant time complexity for basic operations but does not maintain order.
- **TreeMap**: Provides log(n) time complexity for basic operations while maintaining sorted order.

### HashSet vs. TreeSet

- **HashSet**: Fast operations with no order.
- **TreeSet**: Slower but maintains a sorted order of elements.

## Collections Utility Class

The `Collections` utility class provides static methods for various operations on collections, such as:

- Sorting (`Collections.sort()`)
- Shuffling (`Collections.shuffle()`)
- Searching (`Collections.binarySearch()`)
- Synchronized wrappers for thread-safe collections (`Collections.synchronizedList()`)

## Sorting, Searching, and Shuffling Collections

- Sorting: Rearranges the elements based on natural ordering or a custom comparator.
- Searching: Locates an element using algorithms like binary search.
- Shuffling: Randomly permutes the elements in a collection.

## Synchronized Collections

Synchronized collections are thread-safe implementations that prevent concurrent modification, ensuring safe access in
multithreaded environments.

## Unmodifiable Collections

Unmodifiable collections prevent modifications after their creation. They are useful for protecting data from changes
and can be created using methods like `Collections.unmodifiableList()`.
