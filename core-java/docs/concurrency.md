# [Concurrency](https://github.com/aamirxshaikh/interview-prep/tree/main/core-java/src/main/java/com/interviewprep/concurrency)

## 1. Introduction to Multithreading

### 1.1 What is Multithreading?

Multithreading is a technique in Java that allows multiple threads (lightweight processes) to run concurrently within a
program. It enables better CPU utilization and enhances the performance of applications.

### 1.2 Benefits of Multithreading

- **Improved Performance:** Multiple tasks can run in parallel.
- **Better CPU Utilization:** Efficient use of system resources.
- **Responsiveness:** UI applications remain responsive.
- **Asynchronous Processing:** Enables background tasks.

### 1.3 Challenges in Multithreading

- **Race Conditions:** Multiple threads accessing shared resources.
- **Deadlocks:** Two or more threads waiting indefinitely for each other.
- **Thread Interference:** Unexpected behavior due to improper synchronization.

---

## 2. Creating Threads: Thread Class vs. Runnable Interface

### 2.1 Using the Thread Class

#### Example:

```java
class MyThread extends Thread {
  public void run() {
    System.out.println("Thread is running...");
  }

  public static void main(String[] args) {
    MyThread t1 = new MyThread();
    t1.start(); // Start the thread
  }
}
```

- **Pros:** Simple to use.
- **Cons:** Cannot extend another class.

### 2.2 Using the Runnable Interface

#### Example:

```java
class MyRunnable implements Runnable {
  public void run() {
    System.out.println("Thread is running...");
  }

  public static void main(String[] args) {
    Thread t1 = new Thread(new MyRunnable());
    t1.start();
  }
}
```

- **Pros:** Allows extending another class.
- **Cons:** Requires an explicit `Thread` instance.

#### Example Using Lambda Expression

Since Java 8, we can use lambda expressions to create a `Runnable` instance in a more concise way.

```java
public class LambdaRunnable {
  public static void main(String[] args) {
    Runnable task = () -> System.out.println("Thread is running using Lambda!");

    Thread t1 = new Thread(task);
    t1.start();
  }
}
```

#### Even More Concise Version

````java
public class LambdaRunnable {
  public static void main(String[] args) {
    Thread t1 = new Thread(() -> System.out.println("Thread is running using Lambda!"));
    t1.start();
  }
}
````

#### Why Use Lambda?

- **Reduces Boilerplate Code** – No need to create a separate class or override run().
- **Improves Readability** – The logic is more concise and easier to understand.
- **Functional Programming Approach** – Encourages writing cleaner, inline code.

## 2.3 Choosing Between Thread and Runnable

| Feature                | Thread Class | Runnable Interface |
|------------------------|--------------|--------------------|
| Extends another class? | ❌ No         | ✅ Yes              |
| Reusability            | ❌ Less       | ✅ More             |
| Flexibility            | ❌ Limited    | ✅ High             |

---

## 3. Thread Lifecycle and States

## 3.1 Lifecycle of a Thread

A thread in Java has the following states:

1. **New** – Thread is created but not started.
2. **Runnable** – Ready to run but waiting for CPU.
3. **Blocked** – Waiting for a resource.
4. **Waiting** – Indefinitely waiting for another thread.
5. **Timed Waiting** – Waiting for a specified time.
6. **Terminated** – Execution is finished.

## 3.2 Example of Thread Lifecycle

### 2.1 New, Runnable, and Terminated State

This example demonstrates a thread that is created (`NEW`), started (`RUNNABLE`), and completes execution (
`TERMINATED`).

```java
public class ThreadLifecycleExample {
  public static void main(String[] args) throws InterruptedException {
// Create a thread (NEW state)
    Thread thread = new Thread(() -> System.out.println("Thread is running..."));

    // Print NEW state
    System.out.println("Thread state after creation: " + thread.getState()); // NEW

    // Start the thread (transition to RUNNABLE)
    thread.start();
    System.out.println("Thread state after start: " + thread.getState()); // RUNNABLE or TERMINATED (if very fast)

    // Wait for the thread to finish
    thread.join();
    System.out.println("Thread state after completion: " + thread.getState()); // TERMINATED
  }
}
```

### 2.2 Blocked State

This example demonstrates a thread that enters the `BLOCKED` state while waiting to acquire a synchronized lock.

```java
public class BlockedStateExample {
  public static void main(String[] args) throws InterruptedException {
    SharedResource resource = new SharedResource();

    Thread t1 = new Thread(resource::access);
    Thread t2 = new Thread(resource::access);

    t1.start();
    Thread.sleep(100); // Ensure Thread-0 gets the lock first
    t2.start();

    Thread.sleep(100); // Allow time for Thread-1 to be blocked
    System.out.println(t2.getState()); // BLOCKED if t1 is holding the lock
  }
}
```

```java
public class SharedResource {
  synchronized void access() {
    System.out.println(Thread.currentThread().getName() + " got the lock.");

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(Thread.currentThread().getName() + " is releasing the lock.");
  }
}
```

### 2.3 Waiting State

This example demonstrates a thread that enters the `WAITING` state by calling `wait()` and waits indefinitely until
notified.

```java
public class Main {
  public static void main(String[] args) throws InterruptedException {
    WaitingExample obj = new WaitingExample();

    Thread t1 = new Thread(obj::waitingMethod);
    t1.start();

    // Give some time for the thread to go into WAITING state
    Thread.sleep(1000);
    System.out.println("Thread state: " + t1.getState()); // WAITING

    Thread t2 = new Thread(obj::notifyingMethod);
    t2.start();

    t1.join(); // Ensure t1 completes
    System.out.println("Thread state after completion: " + t1.getState()); // TERMINATED
  }
}
```

```java
public class WaitingExample {
  synchronized void waitingMethod() {
    try {
      System.out.println(Thread.currentThread().getName() + " is waiting...");
      wait(); // Thread enters WAITING state
      System.out.println(Thread.currentThread().getName() + " resumed...");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  synchronized void notifyingMethod() {
    notify(); // Notify the waiting thread
    System.out.println("Thread notified...");
  }
}
```

### 2.4 Timed Waiting State

This example demonstrates a thread that enters the `TIMED_WAITING` state by calling `Thread.sleep()`.

```java
public class TimedWaitingStateExample {
  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(() -> {
      try {
        System.out.println("Thread is sleeping...");
        Thread.sleep(3000); // Thread enters TIMED_WAITING for 3 sec
        System.out.println("Thread woke up...");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    t1.start();

    // Give some time for the thread to go into TIMED_WAITING state
    Thread.sleep(1000);
    System.out.println("Thread state: " + t1.getState()); // TIMED_WAITING

    t1.join();
    System.out.println("Thread state after completion: " + t1.getState()); // TERMINATED
  }
}
```

---

# 4. Synchronization and Locks

## 4.1 Synchronized Methods and Blocks

### 4.1.1 Using Synchronized Methods

When multiple threads access shared data, synchronization prevents data inconsistency by ensuring only one thread can
execute a block at a time.

```java
class SharedResource {
  synchronized void printMessage(String message) {
    System.out.println("Message: " + message);
  }
}

class MyThread extends Thread {
  SharedResource resource;

  MyThread(SharedResource resource) {
    this.resource = resource;
  }

  public void run() {
    resource.printMessage("Hello from " + Thread.currentThread().getName());
  }
}

public class Main {
  public static void main(String[] args) {
    SharedResource resource = new SharedResource();
    Thread t1 = new MyThread(resource);
    Thread t2 = new MyThread(resource);

    t1.start();
    t2.start();
  }
}
```

- **Prevents multiple threads from executing a method at the same time.**

### 4.1.2 Using Synchronized Blocks

```java
class SharedResource {
  void printMessage(String message) {
    synchronized (this) {
      System.out.println("Message: " + message);
    }
  }
}
```

- **Synchronized blocks are more efficient than synchronized methods.**

## 4.2 Intrinsic Locks and Reentrant Locks

### 4.2.1 Intrinsic Locks

- Java uses **intrinsic locks** with `synchronized` methods and blocks.
- Every object in Java has an intrinsic lock (monitor lock).
- Methods declared as `synchronized` automatically acquire this lock.

### 4.2.2 Reentrant Lock (More Flexible Locking Mechanism)

```java
import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
  private final ReentrantLock lock = new ReentrantLock();

  void printMessage(String message) {
    lock.lock();
    try {
      System.out.println("Message: " + message);
    } finally {
      lock.unlock();
    }
  }
}
```

### Why Use ReentrantLock?

- More control over lock acquisition.
- Can specify **lock fairness**.
- Supports **tryLock()** to avoid blocking indefinitely.

## 4.3 Deadlock, Starvation, and Livelock

### 4.3.1 Deadlock

- Occurs when two threads wait for each other's lock indefinitely.

**Example:**

```java
class A {
  synchronized void methodA(B b) {
    System.out.println("Thread A waiting for B's lock...");
    b.methodB();
  }

  synchronized void methodB() {
  }
}

class B {
  synchronized void methodB(A a) {
    System.out.println("Thread B waiting for A's lock...");
    a.methodA(this);
  }

  synchronized void methodA() {
  }
}

public class DeadlockExample {
  public static void main(String[] args) {
    A a = new A();
    B b = new B();

    new Thread(() -> a.methodA(b)).start();
    new Thread(() -> b.methodB(a)).start();
  }
}
```

### Prevention:

- Use **lock ordering**.
- Implement **tryLock()** with timeouts.

### 4.3.2 Starvation

- A thread may never get CPU time if high-priority threads keep running.
- **Solution:** Use fair locks.

### 4.3.3 Livelock

- Threads continuously respond to each other without making progress.
- **Solution:** Introduce randomness or delays.

---

## Summary

- Multithreading improves performance and responsiveness.
- Threads can be created via `Thread` class or `Runnable` interface.
- The `synchronized` keyword prevents race conditions but may cause performance issues.
- **ReentrantLock** provides more control over thread synchronization.
- **Deadlocks, starvation, and livelocks** are common pitfalls that must be avoided.

---