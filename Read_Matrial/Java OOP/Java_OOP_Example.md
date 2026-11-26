# Java OOP — Complete Concept Guide (Exam + Interview Ready)

Covers: **Class & Object, Polymorphism (Overloading + Overriding), Interface, Abstract Class, Encapsulation, Inheritance**
Every section has: Real-world use case → UML-style structure → Full runnable code → Output → Interview one-liners.

---

## 1. CLASS AND OBJECT

**Real World Use Case:** Student Management

**Concept:** A **Class** is a blueprint (template). An **Object** is a real-world entity created from that blueprint, occupying actual memory.

```java
class Student {
    // Fields (State)
    String name;
    int rollNo;
    int marks;

    // Constructor
    Student(String name, int rollNo, int marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    // Methods (Behavior)
    void study() {
        System.out.println(name + " is Studying");
    }

    void display() {
        System.out.println("Name  : " + name);
        System.out.println("Roll  : " + rollNo);
        System.out.println("Marks : " + marks);
    }
}

public class Main {
    public static void main(String[] args) {
        // Object creation
        Student s1 = new Student("Mohit", 101, 90);
        s1.display();
        s1.study();
    }
}
```

**Output:**
```
Name  : Mohit
Roll  : 101
Marks : 90
Mohit is Studying
```

**Interview Points:**
- Class = logical entity (no memory until instantiated); Object = physical entity (memory allocated on heap).
- Multiple objects of the same class have independent copies of instance variables but share the same method code.
- Object creation steps: `new` allocates memory → constructor initializes fields → reference returned.

---

## 2. POLYMORPHISM — METHOD OVERLOADING (Compile-Time Polymorphism)

**Real World Use Case:** Student Admission System (same action "admission", different data)

**Concept:** Same method name, **different parameter list** (number/type/order). Resolved at **compile time** (also called static binding / early binding).

```java
class StudentAdmission {

    // 1. Management Quota
    void admission(String name, int marks, double managementFee) {
        System.out.println("Management Quota Admission");
        System.out.println("Student: " + name + " | Marks: " + marks + " | Fee: " + managementFee);
    }

    // 2. Government Quota
    void admission(String name, int marks, String category) {
        System.out.println("Government Quota Admission");
        System.out.println("Student: " + name + " | Category: " + category);
    }

    // 3. Merit List
    void admission(String name, int marks, int rank) {
        System.out.println("Merit List Admission");
        System.out.println("Student: " + name + " | Rank: " + rank);
    }
}

public class Main {
    public static void main(String[] args) {
        StudentAdmission s = new StudentAdmission();
        s.admission("Rahul", 88, 50000.0);   // calls management quota version
        s.admission("Aman", 82, "OBC");      // calls government quota version
        s.admission("Neha", 95, 1);          // calls merit list version
    }
}
```

**Output:**
```
Management Quota Admission
Student: Rahul | Marks: 88 | Fee: 50000.0
Government Quota Admission
Student: Aman | Category: OBC
Merit List Admission
Student: Neha | Rank: 1
```

**Interview Points:**
- Overloading can differ in: number of params, type of params, or order of params — **NOT** just return type.
- Happens within the **same class** (or via inheritance).
- Compiler decides which method to call based on the arguments passed — hence "compile-time polymorphism."
- `admission(String,int,int)` vs `admission(String,int,double)` — Java resolves via widening/autoboxing rules if exact match not found.

---

## 3. POLYMORPHISM — METHOD OVERRIDING (Run-Time Polymorphism)

**Real World Use Case:** Bank Account Management (Saving vs Current Account rules)

**Concept:** Child class provides a **specific implementation** of a method already defined in its parent class. Same method **signature**, resolved at **runtime** (dynamic/late binding) via the actual object type.

```java
class BankAccount {
    double balance;

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit: " + amount);
    }

    void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdraw: " + amount);
    }

    void calculateInterest() {
        System.out.println("Normal Interest");
    }
}

class SavingAccount extends BankAccount {
    @Override
    void withdraw(double amount) {
        if (amount <= 50000) {
            balance -= amount;
            System.out.println("Saving Account Withdraw Allowed");
        } else {
            System.out.println("Limit Exceeded");
        }
    }

    @Override
    void calculateInterest() {
        System.out.println("Saving Interest: 8%");
    }
}

class CurrentAccount extends BankAccount {
    @Override
    void withdraw(double amount) {
        balance -= amount;
        System.out.println("Current Account Unlimited Withdraw");
    }

    @Override
    void calculateInterest() {
        System.out.println("Current Interest: 3%");
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount b;                       // Parent reference

        b = new SavingAccount();             // Child object (Runtime Polymorphism)
        b.deposit(100000);
        b.withdraw(40000);
        b.calculateInterest();

        System.out.println();

        b = new CurrentAccount();
        b.deposit(200000);
        b.withdraw(150000);
        b.calculateInterest();
    }
}
```

**Output:**
```
Deposit: 100000.0
Saving Account Withdraw Allowed
Saving Interest: 8%

Deposit: 200000.0
Current Account Unlimited Withdraw
Current Interest: 3%
```

**Interview Points:**
- Overriding requires: same method name, same parameters, same (or covariant) return type, and IS-A relationship (inheritance).
- Rules: access modifier can't be more restrictive in child; can't override `static`, `final`, or `private` methods.
- JVM decides which overridden method to call at **runtime** based on the actual object (dynamic method dispatch) — that's why `BankAccount b = new SavingAccount()` calls the child's version.
- `@Override` is optional but strongly recommended — compiler catches signature mismatches.
- **Overloading vs Overriding** is the #1 asked interview question — know both tables cold.

| | Overloading | Overriding |
|---|---|---|
| Binding | Compile-time | Runtime |
| Class | Same class | Parent-child (inheritance) |
| Signature | Must differ | Must be same |
| Return type | Can differ | Same/covariant |
| Also called | Static/Early binding | Dynamic/Late binding |

---

## 4. INTERFACE

**Real World Use Case:** Online Payment Platform (UPI, NetBanking, GooglePay, PhonePay)

**Concept:** An interface defines a **contract** (pure abstraction, prior to Java 8 — 100% abstract). Any class implementing it **must** provide implementations for all its methods. Enables multiple inheritance of type.

```java
interface Payment {
    void paymentProcess();   // implicitly public abstract
}

class UPI implements Payment {
    public void paymentProcess() {
        System.out.println("Payment using UPI");
    }
}

class NetBanking implements Payment {
    public void paymentProcess() {
        System.out.println("Payment using Net Banking");
    }
}

class GooglePay implements Payment {
    public void paymentProcess() {
        System.out.println("Payment using Google Pay");
    }
}

class PhonePay implements Payment {
    public void paymentProcess() {
        System.out.println("Payment using PhonePe");
    }
}

public class Main {
    public static void main(String[] args) {
        Payment p;

        p = new UPI();          p.paymentProcess();
        p = new NetBanking();   p.paymentProcess();
        p = new GooglePay();    p.paymentProcess();
        p = new PhonePay();     p.paymentProcess();
    }
}
```

**Output:**
```
Payment using UPI
Payment using Net Banking
Payment using Google Pay
Payment using PhonePe
```

**Interview Points:**
- All fields in an interface are implicitly `public static final` (constants).
- All methods are implicitly `public abstract` (unless `default`, `static`, or `private` — Java 8+ features).
- A class can implement **multiple interfaces** → solves Java's lack of multiple class inheritance.
- Since Java 8: interfaces can have `default` and `static` methods with body. Since Java 9: `private` methods too.
- Interface vs Abstract Class is another very common question (see comparison table in section 5).

---

## 5. ABSTRACT CLASS

**Real World Use Case:** Employee Salary Management System

**Concept:** A class declared `abstract` can have both abstract (no body) and concrete (with body) methods. Cannot be instantiated directly; child classes **must** implement all abstract methods (unless the child is also abstract).

```java
abstract class Salary {
    // Concrete field & method (extra: added for real-world completeness)
    String company = "TechCorp Pvt Ltd";

    void companyInfo() {
        System.out.println("Company: " + company);
    }

    // Abstract method — must be implemented by subclasses
    abstract void calculateSalary(double basic, int experience);
}

class Employee extends Salary {
    @Override
    void calculateSalary(double basic, int experience) {
        double pf = basic * 0.12;
        double salary = basic - pf - (experience * 1200);
        System.out.println("Employee Salary (No PF Cut): " + salary);
    }
}

class HR extends Salary {
    @Override
    void calculateSalary(double basic, int experience) {
        double pf = basic * 0.10;
        double salary = basic - pf - (experience * 1200);
        System.out.println("HR Salary (PF 10% Cut): " + salary);
    }
}

class Manager extends Salary {
    @Override
    void calculateSalary(double basic, int experience) {
        double pf = basic * 0.20;
        double salary = basic - pf - (experience * 1500);
        System.out.println("Manager Salary (PF 20% Cut): " + salary);
    }
}

public class Main {
    public static void main(String[] args) {
        Salary s;

        s = new Employee();  s.calculateSalary(30000, 5);
        s = new HR();        s.calculateSalary(35000, 5);
        s = new Manager();   s.calculateSalary(50000, 5);
    }
}
```

**Output:**
```
Employee Salary (No PF Cut): 20400.0
HR Salary (PF 10% Cut): 25500.0
Manager Salary (PF 20% Cut): 25500.0
```

**Interview Points:**
- Abstract class **can** have constructors, instance variables, concrete methods, and static methods — interfaces (pre-Java 8) cannot.
- A class with even **one** abstract method must itself be declared `abstract`.
- Cannot create object of an abstract class: `new Salary()` → compile error.
- Used when classes share **common code + a common contract**; interface used when only a **contract** is needed across unrelated classes.

| | Interface | Abstract Class |
|---|---|---|
| Methods | Abstract by default (+ default/static in Java 8+) | Abstract + concrete both |
| Fields | `public static final` only | Any type of variable |
| Constructor | No | Yes |
| Inheritance | `implements`, multiple allowed | `extends`, single only |
| Use case | Unrelated classes, pure contract | Related classes, shared code |

---

## 6. ENCAPSULATION *(Added — essential for interviews)*

**Real World Use Case:** ATM / Bank Account — protecting balance from direct/illegal modification

**Concept:** Wrapping data (fields) and code (methods) together, and **restricting direct access** to fields using `private` + exposing controlled access via public getters/setters. "Data Hiding."

```java
class ATMAccount {
    // private fields — cannot be accessed directly from outside the class
    private String accountHolder;
    private double balance;
    private String pin;

    ATMAccount(String accountHolder, double balance, String pin) {
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.pin = pin;
    }

    // Controlled READ access
    public double getBalance() {
        return balance;
    }

    // Controlled WRITE access — with validation logic
    public void withdraw(double amount, String enteredPin) {
        if (!pin.equals(enteredPin)) {
            System.out.println("Invalid PIN!");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient Balance!");
            return;
        }
        balance -= amount;
        System.out.println("Withdraw Successful. Remaining Balance: " + balance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid Deposit Amount!");
            return;
        }
        balance += amount;
        System.out.println("Deposit Successful. Balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        ATMAccount acc = new ATMAccount("Mohit", 10000, "1234");

        // acc.balance = 999999;   // ❌ Compile Error — private field, not accessible directly

        acc.deposit(5000);
        acc.withdraw(3000, "1234");
        acc.withdraw(2000, "0000");   // wrong PIN
        System.out.println("Final Balance: " + acc.getBalance());
    }
}
```

**Output:**
```
Deposit Successful. Balance: 15000.0
Withdraw Successful. Remaining Balance: 12000.0
Invalid PIN!
Final Balance: 12000.0
```

**Interview Points:**
- Achieved via: `private` fields + `public` getters/setters.
- Benefits: data hiding, validation control, increased security, loose coupling, easier maintenance.
- Java Beans convention: `getXxx()` / `setXxx()` naming.
- Encapsulation ≠ Abstraction: Encapsulation hides **data** (how it's stored/protected); Abstraction hides **implementation details** (what vs how). Very commonly confused in interviews — be ready to explain the difference with an example.

---

## 7. INHERITANCE *(Added — essential for interviews)*

**Real World Use Case:** Vehicle Showroom — Car and Bike share common Vehicle features

**Concept:** A mechanism where one class (child/subclass) acquires the fields and methods of another class (parent/superclass) using `extends` — promotes **code reusability** and models an **IS-A** relationship.

```java
class Vehicle {
    String brand;
    int wheels;

    Vehicle(String brand, int wheels) {
        this.brand = brand;
        this.wheels = wheels;
    }

    void start() {
        System.out.println(brand + " is starting...");
    }

    void fuelInfo() {
        System.out.println("Runs on fuel/electricity");
    }
}

// Single Inheritance
class Car extends Vehicle {
    int seatingCapacity;

    Car(String brand, int seatingCapacity) {
        super(brand, 4);                 // calling parent constructor
        this.seatingCapacity = seatingCapacity;
    }

    void airConditioner() {
        System.out.println(brand + " AC turned ON");
    }
}

// Single Inheritance
class Bike extends Vehicle {
    boolean hasGear;

    Bike(String brand, boolean hasGear) {
        super(brand, 2);
        this.hasGear = hasGear;
    }

    void kickStart() {
        System.out.println(brand + " kick-started");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Hyundai Creta", 5);
        car.start();          // inherited from Vehicle
        car.fuelInfo();       // inherited from Vehicle
        car.airConditioner(); // Car's own method
        System.out.println("Wheels: " + car.wheels + " | Seats: " + car.seatingCapacity);

        System.out.println();

        Bike bike = new Bike("Royal Enfield", true);
        bike.start();
        bike.kickStart();
        System.out.println("Wheels: " + bike.wheels + " | Has Gear: " + bike.hasGear);
    }
}
```

**Output:**
```
Hyundai Creta is starting...
Runs on fuel/electricity
Hyundai Creta AC turned ON
Wheels: 4 | Seats: 5

Royal Enfield is starting...
Royal Enfield kick-started
Wheels: 2 | Has Gear: true
```

**Interview Points:**
- Types of inheritance in Java: **Single, Multilevel, Hierarchical**. **Multiple inheritance with classes is NOT supported** (diamond problem) — achieved instead via **interfaces**.
- `super` keyword: calls parent constructor (`super(...)`) or parent method (`super.method()`).
- Constructors are **not inherited**, but the parent constructor is always called first (implicitly `super()` if not written).
- `private` members of parent are not directly inherited/accessible in child (encapsulation still applies).

---

## Quick Revision Table — All 6 Concepts

| Concept | Keyword(s) | Real World Analogy | Binding Time |
|---|---|---|---|
| Class & Object | `class`, `new` | Blueprint vs Real Building | — |
| Overloading | Same class, diff params | Same tap, different water pressure settings | Compile-time |
| Overriding | `extends`, `@Override` | Same job, different employee style | Runtime |
| Interface | `interface`, `implements` | Rulebook everyone must follow | Runtime (via dispatch) |
| Abstract Class | `abstract` | Half-built blueprint | Runtime (for abstract methods) |
| Encapsulation | `private` + getters/setters | ATM machine — you can't touch the cash directly | — |
| Inheritance | `extends`, `super` | Child inherits family business/traits | — |

## Why OOP? (Exam One-Liners)
- **Code Reusability** — via Inheritance
- **Easy Maintenance** — changes isolated to specific classes
- **Real World Modeling** — objects mirror real entities
- **Security** — via Encapsulation
- **Flexibility** — via Polymorphism
- **Scalability** — via Abstraction & Interfaces

## Most-Asked Interview Questions From This Sheet
1. Difference between Method Overloading and Overriding.
2. Difference between Abstract Class and Interface.
3. Difference between Encapsulation and Abstraction.
4. Why doesn't Java support multiple inheritance with classes?
5. Can we instantiate an abstract class or interface? Why not?
6. What is dynamic method dispatch? Give an example.
7. Can a `static` or `private` or `final` method be overridden? Why not?
8. What happens if a subclass doesn't implement all abstract methods?
9. Real-life example each of the 4 pillars: Encapsulation, Abstraction, Inheritance, Polymorphism.
10. Constructor chaining using `super()` — how does it work internally?
