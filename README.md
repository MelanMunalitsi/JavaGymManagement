# MyFitness Gym Management System

A fully object-oriented Java application that models the core operations of the **MyFitness** gym — including member registration, staff management, bootcamp class scheduling, bookings, and payment processing.

Built as a clean Gradle project using proper OOP principles: abstract classes, inheritance hierarchies, interfaces, encapsulation, and polymorphism.

---

## Table of Contents

- [Overview](#overview)
- [Requirements](#requirements)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [Architecture & Design](#architecture--design)
- [What the Demo Covers](#what-the-demo-covers)
- [Key Design Decisions](#key-design-decisions)
- [Sample Output](#sample-output)

---

## Overview

MyFitness is a local gym catering to members aged 18 and above. This system manages:

- **Members** — three membership types: Student, Standard, and Pay-As-You-Go
- **Staff** — full-time, part-time, and fitness instructors
- **Bootcamp Classes** — Fat Burn, Fitness & Endurance, Full Body (30 days each)
- **Bookings** — members can enrol in and cancel bootcamp classes
- **Payments** — automated fee calculation with a 7% multi-class discount

---

## Requirements

- Java 17 or higher
- Gradle 7+ (or use the included wrapper — no installation needed)

---

## Getting Started

```bash
# 1. Clone the repository
git clone https://github.com/MelanMunalitsi/JavaGymManagement.git
cd JavaGymManagement

# 2. Run the application (Gradle compiles automatically)
./gradlew run

# On Windows
gradlew.bat run

# Optional: build a standalone JAR
./gradlew jar
java -jar build/libs/JavaGymManagement-1.0.0.jar
```

That's it. No dependencies to install, no configuration needed.

---

## Project Structure

```
JavaGymManagement/
│
├── build.gradle                        ← Gradle build config
├── settings.gradle                     ← Project name
├── README.md
│
└── src/
    └── main/
        └── java/
            └── com/
                └── myfitness/
                    │
                    ├── Main.java                   ← Entry point, runs all task demos
                    │
                    ├── model/                      ← Domain classes (what things ARE)
                    │   ├── Person.java             ← Abstract root of all people
                    │   ├── Member.java             ← Abstract base for all members
                    │   ├── Staff.java              ← Base class for all staff
                    │   ├── StudentMember.java      ← 9-month discounted membership
                    │   ├── StandardMember.java     ← 12-month full membership
                    │   ├── PayAsYouGoMember.java   ← Credit-based pay-per-visit
                    │   ├── FullTimeStaff.java      ← Salaried staff with benefits
                    │   ├── PartTimeStaff.java      ← Hourly-rate staff
                    │   ├── Instructor.java         ← Fitness instructor, runs classes
                    │   ├── BootCampClass.java      ← A bootcamp class with roster
                    │   ├── Booking.java            ← A member's class reservation
                    │   └── Payment.java            ← A financial transaction
                    │
                    └── service/                    ← Business logic (what things DO)
                        ├── Payable.java            ← Interface: payment contract
                        ├── BootcampFee.java        ← Abstract class: fee rules
                        └── GymManager.java         ← Core service, in-memory database
```

---

## Architecture & Design

### Inheritance Hierarchy

```
Person  (abstract)
├── Member  (abstract)
│   ├── StudentMember       £15.91/mo | 9 months  | 20% student discount
│   ├── StandardMember      £20.99/mo | 12 months | loyalty points, freeze, guest passes
│   └── PayAsYouGoMember    £4.95/visit | 30 days | credit top-up system
│
└── Staff
    ├── FullTimeStaff       fixed monthly salary + benefits package
    ├── PartTimeStaff       hourly rate × hours worked
    └── Instructor          extends Staff, assigned to bootcamp classes
```

### Service Layer

```
BootcampFee  (abstract class)
└── GymManager  implements BootcampFee + Payable
```

- **`BootcampFee`** defines the abstract rule: £35.50/class, 7% off for 2+ classes. `GymManager` provides the concrete implementation.
- **`Payable`** is an interface that contracts `processPayment()`, `issueRefund()`, and `getTotalPaid()`. `GymManager` fulfils this contract.
- **`GymManager`** is the single source of truth — it holds all ArrayLists (members, staff, classes, bookings, payments) and orchestrates every operation.

### Supporting Classes

| Class | Role |
|---|---|
| `BootCampClass` | Holds a class roster, tracks capacity, manages enrolment |
| `Booking` | Links a member to a class, tracks status (PENDING / CONFIRMED / CANCELLED) |
| `Payment` | Records a transaction, supports processing and refunds |

---

## What the Demo Covers

`Main.java` runs four sections in sequence, each mapped to an assignment task:

### Task 2 — Base Classes
Instantiates the core classes and tests their fundamental behaviour:
- `Person` — login with correct and incorrect credentials, profile update
- `Member` — membership details display with fee, duration, and status
- `Staff` — shift scheduling and schedule display
- `Payment` — full lifecycle: PENDING → COMPLETED → REFUNDED

### Task 3a — Inheritance Hierarchy
Demonstrates every concrete subclass:
- `StudentMember` — student ID verification, 20% discount application
- `StandardMember` — loyalty points, redemption, membership freeze (one-time), guest passes
- `PayAsYouGoMember` — credit top-up and usage
- `FullTimeStaff` — salary calculation
- `PartTimeStaff` — hour logging and pay calculation
- `Instructor` — class assignment and conducting

### Task 3b — Gym Operations (ArrayLists)
Seeds the system with realistic dummy data and runs a full operational demo:
- 3 instructors, 5 full-time staff, 4 part-time staff added
- 3 bootcamp classes created and assigned to instructors
- 6 members registered across all membership types
- Members enrolled in classes, rosters printed, a member removed
- All bookings and payments listed with a revenue total

### Task 3c — Bootcamp Fee Calculation (Abstract Class)
Demonstrates the abstract `BootcampFee` class in action:
- 1 class → £35.50 (no discount)
- 2 classes → £66.03 (7% off £71.00, saving £4.97)
- 3 classes → £99.04 (7% off £106.50, saving £7.46)

---

## Key Design Decisions

**Why is `Member` abstract?**
Every member must belong to a concrete type. There is no such thing as a generic "member" at MyFitness — you are either a Student, Standard, or Pay-As-You-Go member. Making `Member` abstract enforces this and requires each subclass to define its own `getMonthlyFee()`, `getMonthsRemaining()`, and `getMembershipType()`.

**Why is `BootcampFee` an abstract class and not an interface?**
It needs to carry shared state (`BASE_FEE_PER_CLASS`, `MULTI_CLASS_DISCOUNT`) and a concrete method (`printFeeBreakdown()`). An interface cannot hold non-constant fields or provide default implementations that reference those fields cleanly. An abstract class is the right tool here.

**Why does `GymManager` extend `BootcampFee` and implement `Payable`?**
`GymManager` is the single orchestrator of the system. It needs to both calculate fees (provided by `BootcampFee`) and process payments (contracted by `Payable`). This demonstrates the combination of abstract class inheritance and interface implementation in one class.

**Why ArrayLists?**
The assignment specifies ArrayList as the in-memory database. Each entity type has its own list inside `GymManager`, making it easy to add, remove, search, and iterate over records without external dependencies.

---

## Sample Output

```
════════════════════════════════════════════════════════════
  MyFitness Gym Management System
════════════════════════════════════════════════════════════

┌─ TASK 3b — Gym Operations (ArrayLists) ─────────────────

▶ Enrolling Members in Bootcamp Classes
  ✓ Zara Ahmed enrolled in Fat Burn.
  ✓ Booking #1001 confirmed: Zara Ahmed → Fat Burn
  ✓ Payment #5001 processed: £35.50 via CREDIT_CARD
  ✓ Zara Ahmed enrolled in Fitness & Endurance.
  ✓ Booking #1002 confirmed: Zara Ahmed → Fitness & Endurance
  ✓ Payment #5002 processed: £66.03 via CREDIT_CARD  ← 7% discount applied

┌─ TASK 3c — Bootcamp Fee Calculation ────────────────────

  ┌─── Bootcamp Fee Breakdown ───────────────
  │ Classes enrolled  : 2
  │ Base fee/class    : £35.50
  │ Subtotal          : £71.00
  │ Discount (7%)     : -£4.97
  │ TOTAL DUE         : £66.03
  └──────────────────────────────────────────

┌─ SYSTEM SUMMARY ────────────────────────────────────────

  │ Members     : 6
  │ Staff       : 12 (incl. 3 instructors)
  │ Classes     : 3
  │ Bookings    : 7
  │ Payments    : 7 | Revenue: £309.56
```
