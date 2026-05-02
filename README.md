# MyFitness Gym Management System

A Java application modelling the core operations of the MyFitness gym — built with clean OOP principles, a proper Gradle project structure, and full coverage of all assignment tasks.

---

## Project Structure

```
JavaGymManagement/
├── build.gradle
├── settings.gradle
└── src/main/java/com/myfitness/
    ├── Main.java                  ← Entry point
    ├── model/
    │   ├── Person.java            ← Abstract root
    │   ├── Member.java            ← Abstract member base
    │   ├── Staff.java             ← Staff base
    │   ├── StudentMember.java
    │   ├── StandardMember.java
    │   ├── PayAsYouGoMember.java
    │   ├── FullTimeStaff.java
    │   ├── PartTimeStaff.java
    │   ├── Instructor.java
    │   ├── BootCampClass.java
    │   ├── Booking.java
    │   └── Payment.java
    └── service/
        ├── Payable.java           ← Interface
        ├── BootcampFee.java       ← Abstract class (Task 3c)
        └── GymManager.java        ← Core service / in-memory DB
```

---

## Requirements

- Java 17+
- Gradle (wrapper included — no install needed)

---

## Build & Run

```bash
# Clone
git clone https://github.com/MelanMunalitsi/JavaGymManagement.git
cd JavaGymManagement

# Run (Gradle will compile automatically)
./gradlew run

# Or build a JAR and run it
./gradlew jar
java -jar build/libs/JavaGymManagement-1.0.0.jar
```

> On Windows use `gradlew.bat run` instead of `./gradlew run`

---

## What the Demo Covers

| Task   | What it demonstrates |
|--------|----------------------|
| Task 2 | Base class instantiation — `Person`, `Member`, `Staff`, `Payment` with getters/setters |
| Task 3a | Full inheritance hierarchy — all member & staff subtypes in action |
| Task 3b | ArrayList-based gym operations — 6 members, 9 staff, 3 bootcamp classes, bookings, payments |
| Task 3c | Abstract `BootcampFee` class — £35.50/class, 7% discount for 2+ classes |

---

## Inheritance Hierarchy

```
Person (abstract)
├── Member (abstract)
│   ├── StudentMember      — 9 months, 20% discount, student ID verification
│   ├── StandardMember     — 12 months, loyalty points, freeze, guest passes
│   └── PayAsYouGoMember   — £4.95/visit, credit-based
└── Staff
    ├── FullTimeStaff      — monthly salary + benefits
    ├── PartTimeStaff      — hourly rate, hours tracking
    └── Instructor         — assigned bootcamp classes

BootcampFee (abstract) ← implemented by GymManager
Payable (interface)    ← implemented by GymManager
```
