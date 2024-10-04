# How to Ace Java Developer Interviews

Welcome to the Java Developer Interview Prep repository! This resource is designed to help Java developers prepare for
technical interviews. It contains documentation, code samples, and interview questions and answers covering a wide range
of topics relevant to Java development.

To excel in Java developer interviews, you should have a strong grasp of both core and advanced Java concepts, as well
as a solid understanding of related tools and technologies. Below is a comprehensive list of topics and subtopics that
you should prepare:

## 1. **[Core Java](core-java)**

- **[Java Basics](core-java/docs/java-basics.md)**
    - Introduction to Java
    - Java Development Kit (JDK) and Java Runtime Environment (JRE)
    - The Java Virtual Machine (JVM)
    - **The `static` Keyword**
        - Static Variables (Class Variables)
        - Static Methods
        - Static Blocks
        - Static Class (Nested Static Classes)
        - Static Import

- **[Data Types and Variables](core-java/docs/data-types-and-variables.md)**
    - Primitive Data Types (int, char, float, etc.)
    - Reference Data Types (Objects and Arrays)
    - Variable Declaration and Initialization
    - Type Casting (Implicit and Explicit)
    - Constants (final keyword)
    - **Wrapper Classes**
        - List of Wrapper Classes
        - Autoboxing and Unboxing
        - Usage in Collections

- **[Exception Handling](core-java/docs/exception-handling.md)**
    - Introduction to Exceptions
    - Types of Exceptions: Checked vs. Unchecked
    - try-catch Block
    - finally Block
    - throw and throws Keywords
    - Custom Exceptions
    - Handling Multiple Exceptions
    - Exception Propagation
    - try-with-resources Statement (Automatic Resource Management)

- **[Object-Oriented Programming (OOP) Concepts](core-java/docs/oop-concepts.md)**
    - Class and Object
        - Defining a Class and Creating Objects
        - Constructors and Initialization Blocks
        - this Keyword
        - **Static Context in OOP**
            - Accessing Static Members
            - Restrictions in Static Context
            - Static vs. Instance Context
            - **Method Hiding**
                - Definition of Method Hiding
                - Characteristics of Method Hiding
                - Differences Between Method Hiding and Method Overriding
        - **Nested Classes and Static Classes**
            - Inner Classes (Non-static Nested Classes)
            - Static Nested Classes
        - **Object Class and Its Methods**
            - equals() and hashCode()
            - toString()
            - clone() and Cloning in Java
            - finalize() Method
    - Enum Types
        - Defining an Enum
        - Enum with Constructors, Fields, and Methods
        - Using Enums in Switch Statements
        - Enum Constants as Static Final Fields
        - Iterating Over Enum Values
        - Enum with Overridden Methods
    - Encapsulation
        - Access Modifiers (private, public, protected, default)
        - Getters and Setters
        - Data Hiding
        - **Immutable Classes**
            - Creating Immutable Classes
            - Benefits of Immutability
    - Inheritance
        - Single Inheritance
        - Multilevel Inheritance
        - Method Overriding
        - super Keyword
        - **Hierarchical Inheritance**
            - Inheritance with Multiple Subclasses
        - **Composition vs. Inheritance**
            - When to Use Composition Over Inheritance
    - Polymorphism
        - Compile-Time Polymorphism (Method Overloading)
        - Runtime Polymorphism (Method Overriding)
        - **Covariant Return Types**
            - Method Overriding with Covariant Return Types
    - Abstraction
        - Abstract Classes and Methods
        - Characteristics of an Abstract Class
        - What You Can and Cannot Do with Abstract Classes
        - Interfaces and Multiple Inheritance
        - Characteristics of an Interface
        - What You Can and Cannot Do with Interfaces
        - Comparison: Abstract Class vs Interface
        - When to Use Abstract Classes vs Interfaces

- **Java Collections Framework**
    - Generics in Java
        - Introduction to Generics
        - Type Parameters and Wildcards
        - Generic Classes and Interfaces
        - Generic Methods
        - Bounded Types in Generics
        - Wildcards: `? extends` and `? super`
        - Erasure and Limitations of Generics
        - Benefits of Using Generics
        - Generics and Collections
    - Overview of Collections Framework
    - Collection Interfaces: List, Set, Queue, Map
    - Implementations of Collection Interfaces
        - List: ArrayList, LinkedList, Vector, Stack
        - Set: HashSet, LinkedHashSet, TreeSet
        - Map: HashMap, LinkedHashMap, TreeMap, Hashtable
        - Queue: PriorityQueue, LinkedList
    - ArrayList vs. LinkedList
    - HashMap vs. TreeMap
    - HashSet vs. TreeSet
    - Collections Utility Class
        - Sorting, Searching, and Shuffling Collections
        - Synchronized Collections
        - Unmodifiable Collections

- **Concurrency**
    - Introduction to Multithreading
    - Creating Threads: Thread Class vs. Runnable Interface
    - Thread Lifecycle and States
    - Synchronization and Locks
        - Synchronized Methods and Blocks
        - Intrinsic Locks and Reentrant Locks
        - Deadlock, Starvation, and Livelock
    - Inter-Thread Communication (wait, notify, notifyAll)
    - Executor Framework
        - ExecutorService and ThreadPoolExecutor
        - ScheduledExecutorService
    - Callable and Future
        - Creating Asynchronous Tasks with Callable
        - Retrieving Results with Future
    - Concurrent Collections
        - BlockingQueue, ConcurrentHashMap, CopyOnWriteArrayList
        - ConcurrentLinkedQueue, ConcurrentSkipListMap

- **Java 8+ Features**
    - Lambda Expressions
        - Syntax and Usage
        - Functional Programming with Lambdas
    - Streams API
        - Creating and Using Streams
        - Stream Operations: filter, map, reduce, collect
        - Parallel Streams
    - Optional Class
        - Avoiding NullPointerExceptions with Optional
        - Working with Optional Methods
    - Functional Interfaces
        - Predefined Functional Interfaces: Predicate, Function, Consumer, Supplier
        - Creating Custom Functional Interfaces
    - Method References
        - Static Method References
        - Instance Method References
        - Constructor References
    - Default and Static Methods in Interfaces
        - Extending Interfaces with Default Methods
        - Defining Static Methods in Interfaces
    - Type Inference with `var`

- **Memory Management**
    - Understanding Heap and Stack Memory
    - Object Creation and Memory Allocation
    - Garbage Collection
        - How Garbage Collection Works
        - Types of Garbage Collectors
        - Manual vs. Automatic Garbage Collection
        - finalize() Method and Its Uses
    - Java Memory Model
        - Memory Visibility and Ordering
        - Happens-Before Relationship
        - Volatile Variables and Atomic Variables

## 2. **Advanced Java**

- **JDBC (Java Database Connectivity)**
    - Connecting to Databases
    - Executing Queries
    - ResultSet and PreparedStatement
    - Transaction Management
- **Java Servlets and JSP**
    - Servlet Lifecycle
    - Session Management
    - JSP Scripting Elements
    - MVC Architecture
- **Java Annotations**
    - Built-in Annotations (e.g., @Override, @Deprecated)
    - Custom Annotations
- **Java Reflection**
    - Inspecting Classes, Methods, and Fields
    - Dynamic Method Invocation
    - Proxy Classes
- **Design Patterns**
    - Singleton
    - Factory
    - Builder
    - Observer
    - Dependency Injection

## 3. **Spring Framework**

- **Spring Core**
    - Inversion of Control (IoC)
    - Dependency Injection (DI)
    - Bean Lifecycle
    - ApplicationContext vs. BeanFactory
- **Spring MVC**
    - DispatcherServlet
    - Controllers and Views
    - Model and ModelAndView
    - Request Mapping
    - Form Handling
- **Spring Boot**
    - Spring Boot Annotations
    - Auto-Configuration
    - Spring Boot Starter Projects
    - Application Properties and YAML
    - Embedded Servers (Tomcat, Jetty)
- **Spring Data JPA**
    - Repositories
    - Query Methods
    - JPQL and Criteria API
    - Transaction Management
- **Spring Security**
    - Authentication and Authorization
    - Security Filters
    - OAuth2 and JWT
    - Method Security

## 4. **Hibernate and JPA**

- **ORM (Object-Relational Mapping)**
    - Entity Mapping
    - Associations (One-to-One, One-to-Many, Many-to-Many)
    - Lazy vs. Eager Loading
- **Hibernate Basics**
    - SessionFactory and Session
    - HQL (Hibernate Query Language)
    - Caching (First-Level and Second-Level)
    - Transaction Management

## 5. **Microservices Architecture**

- **Basics of Microservices**
    - Monolithic vs. Microservices Architecture
    - Advantages and Challenges
- **Spring Cloud**
    - Service Discovery (Eureka)
    - API Gateway (Zuul, Spring Cloud Gateway)
    - Circuit Breaker (Hystrix)
    - Configuration Management (Spring Cloud Config)
- **RESTful Web Services**
    - REST Principles
    - HTTP Methods (GET, POST, PUT, DELETE)
    - Status Codes
    - Request and Response Handling
- **Message Queues**
    - Basics of Messaging
    - JMS (Java Message Service)
    - RabbitMQ
    - Apache Kafka

## 6. **Testing**

- **Unit Testing**
    - JUnit Framework
    - Test Cases and Test Suites
    - Mocking (Mockito)
    - Assertions
- **Integration Testing**
    - Testing with Spring Boot
    - MockMvc for testing Spring MVC Controllers
- **Performance Testing**
    - JMeter Basics
    - Profiling and Monitoring

## 7. **Version Control Systems**

- **Git**
    - Git Commands (clone, commit, push, pull, branch, merge)
    - Branching Strategies (Git Flow, GitHub Flow)
    - Handling Merge Conflicts
- **GitHub/GitLab**
    - Pull Requests and Code Reviews
    - Continuous Integration/Continuous Deployment (CI/CD)

## 8. **Build Tools**

- **Maven**
    - POM.xml Configuration
    - Maven Lifecycle
    - Dependency Management
- **Gradle**
    - Build Scripts (Groovy/Kotlin DSL)
    - Task Management
    - Multi-Module Projects

## 9. **Database Concepts**

- **SQL**
    - Basic Queries (SELECT, INSERT, UPDATE, DELETE)
    - Joins (INNER, OUTER, LEFT, RIGHT)
    - Indexing
    - Transactions and ACID Properties
- **NoSQL**
    - Basics of NoSQL Databases
    - MongoDB
    - Redis
    - Cassandra

## 10. **System Design and Architecture**

- **Design Principles**
    - SOLID Principles
    - DRY, KISS, YAGNI
- **Scalability**
    - Horizontal vs. Vertical Scaling
    - Load Balancing
    - Caching Strategies
- **Distributed Systems**
    - CAP Theorem
    - Consistency Models
    - Distributed Transactions
- **APIs and Protocols**
    - RESTful APIs
    - SOAP
    - GraphQL

## 11. **Behavioral and Soft Skills**

- **Problem Solving**
    - Approach to Problem-Solving
    - Algorithm Design and Complexity Analysis
- **Communication Skills**
    - Explaining Complex Technical Concepts
    - Handling Peer Reviews and Feedback
- **Time Management**
    - Prioritizing Tasks
    - Estimating Effort and Meeting Deadlines

---

By thoroughly preparing these topics and subtopics, you will be well-equipped to ace your Java developer interview for a
3+ years experienced role.
