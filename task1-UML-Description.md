# Task 1 — UML Class Diagram: MyFitness Gym Management System

## Introduction

This section presents and describes the UML class diagram designed to represent the MyFitness gym management system. The diagram models the real-world entities, their attributes, operations, and the relationships between them as described in the case study. The design follows object-oriented principles, ensuring the system is modular, extensible, and reflective of the gym's operational requirements.

---

## UML Class Diagram

```
                          ┌──────────────────────────────┐
                          │         <<abstract>>         │
                          │            Person            │
                          ├──────────────────────────────┤
                          │ - id: int                    │
                          │ - name: String               │
                          │ - email: String              │
                          │ - password: String           │
                          ├──────────────────────────────┤
                          │ + login(): boolean           │
                          │ + logout(): void             │
                          │ + updateProfile(): void      │
                          └──────────────────────────────┘
                                        △
                                        │  inheritance
                   ┌────────────────────┴────────────────────┐
                   │                                         │
     ┌─────────────────────────────┐         ┌──────────────────────────────┐
     │        <<abstract>>         │         │             Staff            │
     │           Member            │         ├──────────────────────────────┤
     ├─────────────────────────────┤         │ - staffId: int               │
     │ - membershipId: int         │         │ - role: String               │
     │ - dateJoined: LocalDate     │         │ - schedule: List<String>     │
     │ - status: String            │         ├──────────────────────────────┤
     │ - balance: double           │         │ + addShift(): void           │
     ├─────────────────────────────┤         │ + viewSchedule(): void       │
     │ + getMonthlyFee(): double   │         └──────────────────────────────┘
     │ + getMonthsRemaining(): int │                       △
     │ + getMembershipType(): String│                      │  inheritance
     │ + makePayment(): void       │         ┌─────────────┼─────────────┐
     │ + viewMembershipDetails()   │         │             │             │
     └─────────────────────────────┘         │             │             │
                   △                         │             │             │
                   │  inheritance            │             │             │
      ┌────────────┼────────────┐            │             │             │
      │            │            │            │             │             │
┌──────────┐ ┌──────────┐ ┌──────────┐      │             │             │
│ Student  │ │ Standard │ │PayAsYouGo│  ┌───────────┐ ┌────────────┐ ┌────────────┐
│  Member  │ │  Member  │ │  Member  │  │FullTime   │ │PartTime    │ │ Instructor │
├──────────┤ ├──────────┤ ├──────────┤  │  Staff    │ │  Staff     │ ├────────────┤
│-studentId│ │-loyalty  │ │-credits  │  ├───────────┤ ├────────────┤ │-specializ- │
│-institut.│ │ Points   │ │          │  │-monthly   │ │-hourlyRate │ │ ation      │
│-discount │ │-frozen   │ │          │  │ Salary    │ │-hoursWorked│ │-assigned   │
│ Rate     │ │-freeze   │ │          │  │-benefits  │ │            │ │ Classes    │
├──────────┤ │ Used     │ ├──────────┤  ├───────────┤ ├────────────┤ ├────────────┤
│+verify   │ ├──────────┤ │+topUp()  │  │+calculate │ │+calculate  │ │+assignClass│
│ Student()│ │+earnPts()│ │+useCredit│  │ Salary()  │ │  Pay()     │ │+conduct    │
│+apply    │ │+redeem   │ │          │  │           │ │+logHours() │ │  Class()   │
│ Discount │ │+freeze   │ │          │  │           │ │            │ │+markAtten- │
│          │ │+guest    │ │          │  │           │ │            │ │ dance()    │
└──────────┘ │  Pass()  │ └──────────┘  └───────────┘ └────────────┘ └────────────┘
             └──────────┘                                                    │
                                                                             │ 1
                                                                             │ assigns
                                                                             │ 1..*
                                                              ┌──────────────────────────┐
                                                              │       BootCampClass      │
                                                              ├──────────────────────────┤
                                                              │ - classId: int           │
                                                              │ - className: String      │
                                                              │ - instructor: Instructor │
                                                              │ - capacity: int          │
                                                              │ - enrolledMembers: List  │
                                                              ├──────────────────────────┤
                                                              │ + enrolMember(): boolean │
                                                              │ + removeMember(): boolean│
                                                              │ + isAvailable(): boolean │
                                                              │ + printRoster(): void    │
                                                              └──────────────────────────┘
                                                                        │ 1
                                                                        │
                                                                        │ 0..*
                                                              ┌─────────┴────────────────┐
                                                              │         Booking          │
                                                              ├──────────────────────────┤
                                                              │ - bookingId: int         │
                                                              │ - member: Member         │◄────── 1 Member
                                                              │ - bootcampClass          │
                                                              │ - bookingDate: LocalDate │
                                                              │ - status: Status         │
                                                              ├──────────────────────────┤
                                                              │ + confirm(): void        │
                                                              │ + cancel(): void         │
                                                              └──────────────────────────┘

                                                              ┌──────────────────────────┐
                                                              │         Payment          │
                                                              ├──────────────────────────┤
                                                              │ - paymentId: int         │
                                                              │ - member: Member         │◄────── 1 Member
                                                              │ - amount: double         │
                                                              │ - method: Method         │
                                                              │ - date: LocalDate        │
                                                              │ - status: Status         │
                                                              │ - description: String    │
                                                              ├──────────────────────────┤
                                                              │ + process(): boolean     │
                                                              │ + refund(): boolean      │
                                                              └──────────────────────────┘


  ─────────────────────────────────────────────────────────────────────
  KEY
  ─────────────────────────────────────────────────────────────────────
  △  = Inheritance (extends / is-a)
  ──►= Association (has-a / uses)
  1, 0..*, 1..* = Cardinality
  <<abstract>> = Cannot be instantiated directly
  ─────────────────────────────────────────────────────────────────────
```

---

## Class Descriptions

### 1. Person *(Abstract)*

`Person` is the abstract root class of the entire hierarchy. It captures attributes shared by every individual in the system — both members and staff. These attributes are `id`, `name`, `email`, and `password`. The class exposes operations common to all persons: `login()`, `logout()`, and `updateProfile()`. Since no object should ever be created as a generic "person" — every individual is either a member or a staff member — the class is declared abstract. This enforces correct instantiation and eliminates redundant code duplication across subclasses.

---

### 2. Member *(Abstract, extends Person)*

`Member` extends `Person` and serves as the abstract base for all gym membership types. It introduces membership-specific attributes: `membershipId`, `dateJoined`, `status`, and `balance`. It declares three abstract methods — `getMonthlyFee()`, `getMonthsRemaining()`, and `getMembershipType()` — which every concrete membership type must implement according to its own rules. Additional concrete methods such as `makePayment()` and `viewMembershipDetails()` are implemented here since they are shared across all member types.

`Member` is abstract because MyFitness does not offer a generic membership — every member must belong to a specific tier.

---

### 3. StudentMember *(extends Member)*

`StudentMember` represents members who qualify for the student saver membership. It adds `studentId` and `institution` attributes and a `discountRate` fixed at 20%. The membership runs for 9 months at £15.91 per month. Key operations include `verifyStudent()` — which validates the student ID — and `applyDiscount()`, which calculates the discounted price for any given amount.

---

### 4. StandardMember *(extends Member)*

`StandardMember` models the standard 24/7 membership at £20.99 per month with a £5.00 joining fee, valid for 12 months. It introduces `loyaltyPoints`, a `frozen` flag, `freezeUsed`, and `guestPassesThisMonth`. Operations include `earnPoints()`, `redeemPoints()`, `freezeMembership()` — which can only be used once for free — and `useGuestPass()`, capped at four guests per month.

---

### 5. PayAsYouGoMember *(extends Member)*

`PayAsYouGoMember` models the flexible pay-per-visit membership at £4.95 per visit with a 30-day validity window. It holds a `credits` attribute representing the number of pre-purchased visits. Operations include `topUp()` to add credits and `useCredit()` to consume one per gym visit.

---

### 6. Staff *(extends Person)*

`Staff` extends `Person` and represents all gym employees. It adds `staffId`, `role`, and a `schedule` list of shifts. Operations include `addShift()` and `viewSchedule()`. This class is concrete and can be instantiated directly for general staff roles such as receptionists and security.

---

### 7. FullTimeStaff *(extends Staff)*

`FullTimeStaff` represents the five full-time employees. It adds `monthlySalary` and `benefits`. The `calculateSalary()` method returns the fixed monthly pay. This class reflects the real-world distinction between salaried and hourly workers.

---

### 8. PartTimeStaff *(extends Staff)*

`PartTimeStaff` models the four part-time employees. It holds `hourlyRate` and `hoursWorked`. The `calculatePay()` method computes total earnings as `hourlyRate × hoursWorked`, and `logHours()` updates the hours worked over time.

---

### 9. Instructor *(extends Staff)*

`Instructor` is a specialised staff member responsible for organising and conducting bootcamp exercise programmes. It adds a `specialization` attribute and an `assignedClasses` list. Operations include `assignClass()`, `conductClass()`, and `markAttendance()`. The case study specifies three fitness expert instructors, each leading one of the three bootcamp classes.

---

### 10. BootCampClass

`BootCampClass` is an independent entity representing one of the three bootcamp programmes: Fat Burn, Fitness & Endurance, and Full Body. Each class has a `classId`, `className`, an assigned `Instructor`, a `capacity`, and a list of enrolled `Member` objects. It runs for a fixed 30 days. Operations include `enrolMember()`, `removeMember()`, `isAvailable()`, and `printRoster()`.

---

### 11. Booking

`Booking` represents the reservation made when a member signs up for a bootcamp class. It links a `Member` to a `BootCampClass` and records the `bookingDate` and `status` (PENDING, CONFIRMED, or CANCELLED). Operations are `confirm()` and `cancel()`.

---

### 12. Payment

`Payment` records a financial transaction in the system. It holds `paymentId`, `amount`, `method` (credit card, debit card, etc.), `date`, `status`, and a `description`. Operations are `process()` and `refund()`.

---

## Relationships and Cardinality

| Relationship | Type | Cardinality | Justification |
|---|---|---|---|
| `Person` → `Member` | Inheritance | — | A member is a person. Member inherits all personal attributes and login behaviour. |
| `Person` → `Staff` | Inheritance | — | A staff member is a person. Staff inherits the same root attributes. |
| `Member` → `StudentMember` | Inheritance | — | A student member is a specific type of member with a discounted rate. |
| `Member` → `StandardMember` | Inheritance | — | A standard member is a specific type of member with full 24/7 access. |
| `Member` → `PayAsYouGoMember` | Inheritance | — | A pay-as-you-go member is a credit-based member type. |
| `Staff` → `FullTimeStaff` | Inheritance | — | A full-time staff member is a specific type of staff with a salary. |
| `Staff` → `PartTimeStaff` | Inheritance | — | A part-time staff member is a specific type of staff paid by the hour. |
| `Staff` → `Instructor` | Inheritance | — | An instructor is a specialised staff member who runs bootcamp classes. |
| `Instructor` → `BootCampClass` | Association | 1 instructor : 1..* classes | Each instructor is assigned to one or more bootcamp classes. The case study specifies three instructors each leading one class. |
| `BootCampClass` → `Member` | Association | 1 class : 0..* members | A bootcamp class can have zero or many enrolled members up to its capacity. |
| `Booking` → `Member` | Association | 1 booking : 1 member | Each booking belongs to exactly one member. |
| `Booking` → `BootCampClass` | Association | 1 booking : 1 class | Each booking is for exactly one bootcamp class. |
| `Payment` → `Member` | Association | 1 payment : 1 member | Each payment is made by exactly one member. |

---

## Summary

The class diagram reflects a clean and well-structured object-oriented design. Abstraction is applied at the `Person` and `Member` levels to prevent direct instantiation where it would be conceptually incorrect. Inheritance is used to share common behaviour while allowing each subclass to specialise. Associations between `BootCampClass`, `Booking`, and `Payment` model the real-world interactions between gym entities — a member books a class, and that booking triggers a payment. The cardinality defined across all relationships accurately represents the operational rules of MyFitness as described in the case study.
