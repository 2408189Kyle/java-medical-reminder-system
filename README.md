<div align="center">

# ⚕️ Medical Reminder System

### A Comprehensive Java Application for Medication Management

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com)
[![License](https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge)](LICENSE)

*Ensuring timely medication intake through organized record-keeping*

</div>

---

## 📋 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [System Requirements](#-system-requirements)
- [Installation & Setup](#-installation--setup)
- [Program Output](#-program-output)
- [OOP Concepts Applied](#-oop-concepts-applied)
- [Class Architecture](#-class-architecture)
- [Screenshots](#-screenshots)
- [Authors](#-authors)

---

## 💡 Overview

The **Medical Reminder System** is built using Java to track medication schedules, providing daily reminders and organized record-keeping. It allows users to register as a patient, add new prescriptions, track dosages, and monitor treatment duration. 

The application is available in two versions:
- **Console-Based Interface** (`Medical.java`) - Simple text-based interaction
- **Graphical User Interface** (`MedicalGUI.java`) - Modern Swing GUI

---

## ✨ Features

| Feature | Description |
|---------|-------------|
| 👤 **Patient Profile** | Register and view patient's age and gender |
| 💊 **Prescription Management** | Define medication, dosage, treatment frequency (e.g., "8 hours"), start time, and duration |
| ✅ **Tracking & Status** | Mark doses taken and manage prescription status (Active, Inactive, Completed) |
| 📊 **Usage Calculation** | Project the total number of doses required for a specified period |
| 📅 **Dashboard & Schedule** | View health overview and detailed schedule of upcoming doses |
| 🔍 **Search Functionality** | Quick medicine search by name |
| ⚠️ **Dosage Guidance** | Age-appropriate medication recommendations |

---

## 🖥️ System Requirements

```
☕ Java Development Kit (JDK) 8 or higher
💻 Any operating system (Windows, macOS, Linux)
📦 Java Swing library (included in JDK)
```

---

## 🚀 Installation & Setup

### Step 1: Clone the Repository
```bash
git clone https://github.com/yourusername/medical-reminder-system.git
cd medical-reminder-system
```

### Step 2: Compile the Program
```bash
javac Medical.java
```

### Step 3: Run the Application
```bash
java Medical
```

<div align="center">

![Run Program](https://github.com/user-attachments/assets/208c3e1a-5628-4c43-8018-57c4d9c478f0)

</div>

---

## 📺 Program Output

### 📋 Patient Information

```
Full Name: Red Baron Barba
Age: 23
Gender: M
Patient ID: PAT61248
Recorded: 2025-12-06
```

### 🎯 Main Menu

```
Menu:
1. Add new prescription
2. View dose schedule
3. Mark dose taken
4. Update status
5. Calculate medicine usage
6. Dosage guidance
7. View prescription details
8. Search medicine
9. Exit
```

---

## 📖 Usage Examples

<details>
<summary><b>1️⃣ Adding New Prescription - Biogesic</b></summary>

```
Choose option: 1

NEW PRESCRIPTION
Medicine Name: Biogesic
Dosage: 300mg
Frequency: 5 hours
Notes: Before Sleeping

Initial Dose Time
Date: 06/12/2025
Time: 12:11

Duration in days: 5

Medicine Type
1) Oral Medicine
2) Tablet
3) Capsule
Choose: 2

✓ Prescription added and scheduled!
  The first dose is set for: 06/12/2025 12:11

DOSAGE GUIDANCE
AGE: Adult (13-64)
Standard dosage OK
```

</details>

<details>
<summary><b>2️⃣ Viewing Dose Schedule</b></summary>

```
Choose option: 2

UPCOMING DOSE SCHEDULE
+---------------------------------------------------+
| No | Name        | Next Dose Time   | Status     |
+---------------------------------------------------+
|  1 | Biogesic    | 06/12/2025 12:11 | ACTIVE     |
+---------------------------------------------------+
```

</details>

<details>
<summary><b>3️⃣ Adding Second Prescription - Paracetamol</b></summary>

```
Choose option: 1

NEW PRESCRIPTION
Medicine Name: Paracetamol
Dosage: 400mg
Frequency: 1 day
Notes: Before meals

Initial Dose Time
Date: 07/12/2025
Time: 12:21

Duration in days: 2

Medicine Type
1) Oral Medicine
2) Tablet
3) Capsule
Choose: 3

✓ Prescription added and scheduled!
  The first dose is set for: 07/12/2025 12:21
```

</details>

<details>
<summary><b>4️⃣ Updated Schedule with Multiple Prescriptions</b></summary>

```
Choose option: 2

UPCOMING DOSE SCHEDULE
+---------------------------------------------------+
| No | Name        | Next Dose Time   | Status     |
+---------------------------------------------------+
|  1 | Biogesic    | 06/12/2025 12:11 | ACTIVE     |
|  2 | Paracetamol | 07/12/2025 12:21 | ACTIVE     |
+---------------------------------------------------+
```

</details>

<details>
<summary><b>5️⃣ Marking Dose as Taken</b></summary>

```
Choose option: 3

ACTIVE PRESCRIPTIONS
+------------------------------------------+
| No | Name        | Dosage | Status      |
+------------------------------------------+
|  1 | Biogesic    | 300mg  | ACTIVE      |
|  2 | Paracetamol | 400mg  | ACTIVE      |
+------------------------------------------+
Select: 1

DOSE CONFIRMATION
Biogesic (300mg)
-> Take Tablet with water: Biogesic
Calculate next dose? (y/n): y
✓ Next dose: 06/12/2025 17:11
```

**Second Dose:**

```
Choose option: 3
Select: 1

✓ Next dose: 06/12/2025 22:11
```

</details>

<details>
<summary><b>6️⃣ Updating Prescription Status</b></summary>

```
Choose option: 4

STATUS UPDATE
1) Biogesic    [ACTIVE]
2) Paracetamol [ACTIVE]
Select: 2

PARACETAMOL
Current Status: ACTIVE

1) Set to ACTIVE
2) Set to INACTIVE
3) Set to COMPLETED
4) View Full Details
5) Delete Medicine
6) Cancel

Choose: 2
✓ Status: INACTIVE
```

**Updated Schedule:**

```
UPCOMING DOSE SCHEDULE
+---------------------------------------------------+
| No | Name        | Next Dose Time   | Status     |
+---------------------------------------------------+
|  1 | Biogesic    | 06/12/2025 22:11 | ACTIVE     |
|  2 | Paracetamol | 07/12/2025 12:21 | INACTIVE   |
+---------------------------------------------------+
```

**Marking as Completed:**

```
Choose option: 4
Select: 2
Choose: 3

Confirm mark as COMPLETED? (y/n): y
✓ Status: COMPLETED
```

</details>

<details>
<summary><b>7️⃣ Calculate Medicine Usage</b></summary>

```
Choose option: 5

MEDICINE USAGE CALCULATOR
Calculates total dosage needed

SELECT PRESCRIPTION
1) Biogesic (300mg)
2) Paracetamol (400mg)
Choose: 1

USAGE ANALYSIS
Medicine: Biogesic
Dosage: 300mg
Frequency: 5 hours
Duration: 5 days
Doses/Day: 4
TOTAL DOSES: 20
```

</details>

<details>
<summary><b>8️⃣ Dosage Guidance</b></summary>

```
Choose option: 6

DOSAGE GUIDANCE
AGE: Adult (13-64)
Standard dosage OK
```

</details>

<details>
<summary><b>9️⃣ View Prescription Details</b></summary>

```
Choose option: 7

VIEW PRESCRIPTION DETAILS
1) Biogesic (ACTIVE)
2) Paracetamol (COMPLETED)
Select: 2

+---------------------------------------+
| Paracetamol (Capsule)                |
+---------------------------------------+
| Dosage: 400mg                        |
| Frequency: 1 day                     |
| Next Dose: 07/12/2025 12:21          |
| Status: COMPLETED                    |
| Notes: Before meals                  |
| Start: 07/12/2025                    |
| Duration: 2 days                     |
| Days Left: 3                         |
+---------------------------------------+
```

</details>

<details>
<summary><b>🔟 Search Medicine</b></summary>

```
Choose option: 8

Search medicine name: pAraCetamol

SEARCH RESULTS
1) Paracetamol (COMPLETED)
```

</details>

<details>
<summary><b>1️⃣1️⃣ Final Schedule</b></summary>

```
Choose option: 2

UPCOMING DOSE SCHEDULE
+---------------------------------------------------+
| No | Name        | Next Dose Time   | Status     |
+---------------------------------------------------+
|  1 | Biogesic    | 06/12/2025 22:11 | ACTIVE     |
|  2 | Paracetamol | 07/12/2025 12:21 | COMPLETED  |
+---------------------------------------------------+
```

</details>

<details>
<summary><b>1️⃣2️⃣ Mark Final Dose</b></summary>

```
Choose option: 3

ACTIVE PRESCRIPTIONS
+------------------------------------------+
| No | Name     | Dosage | Status         |
+------------------------------------------+
|  1 | Biogesic | 300mg  | ACTIVE         |
+------------------------------------------+
Select: 1

DOSE CONFIRMATION
Biogesic (300mg)
-> Take Tablet with water: Biogesic
Calculate next dose? (y/n): y
✓ Next dose: 07/12/2025 03:11
```

</details>

---

## 🎓 OOP Concepts Applied

### 🔒 Encapsulation

The `Medicine` class uses private fields (`name`, `dose`, `notes`, and `reminderTimes`) with public getters and setters. This protects data and ensures values are accessed and modified through controlled methods.

```java
private String name;
private String dose;
// Getters and setters provide controlled access
```

### 🧬 Inheritance

The `ConsoleReminder` class inherits from the abstract class `Reminder`. It reuses and extends the reminder framework provided by the parent class.

```java
public class ConsoleReminder extends Reminder {
    // Inherits properties and methods from Reminder
}
```

### 🎭 Abstraction

The `Reminder` abstract class hides implementation details by requiring subclasses to implement `notifyUser()`. Only essential behavior (scheduling reminders) is exposed.

```java
public abstract class Reminder {
    public abstract void notifyUser();
}
```

---

## 🏗️ Class Architecture

<div align="center">

| Class | Purpose | Key Methods |
|-------|---------|-------------|
| **Medicine** | Represents a single medicine entry | `addReminderTime()`, `removeReminderTime()` |
| **MedicineManager** | Manages the list of medicines | `addMedicine()`, `getMedicine()`, `updateMedicine()`, `deleteMedicine()` |
| **Reminder** *(Abstract)* | General blueprint for any reminder type | `run()`, `notifyUser()` |
| **ConsoleReminder** | Extends Reminder for console-based notifications | `notifyUser()` |

</div>

### 📦 Medicine Class
- **Represents**: A single medicine entry
- **Fields**: `name`, `dose`, `notes`, list of reminder times
- **Methods**: Getters, setters, `addReminderTime()`, `removeReminderTime()`
- **Purpose**: Stores all user-defined data for a specific medicine

### 🗂️ MedicineManager Class
- **Manages**: The list of medicines
- **Fields**: `ArrayList` of Medicine objects
- **Methods**: CRUD operations (Create, Read, Update, Delete)
- **Purpose**: Handles all medicine data operations

### 🔔 Reminder Class (Abstract)
- **General**: Blueprint for any reminder type
- **Fields**: `Medicine medicine`, `String timeStr`
- **Methods**: `run()` and abstract `notifyUser()`
- **Purpose**: Defines shared structure for reminder behavior

### 📢 ConsoleReminder Class (Subclass)
- **Extends**: Reminder to provide console-based notifications
- **Overrides**: `notifyUser()` — prints reminder details in console
- **Purpose**: Delivers actual reminder output to the user

---

## 📸 Screenshots

<div align="center">

### Console Interface

![Console View 1](https://github.com/user-attachments/assets/35b3f5ee-7477-4995-a5af-7e184661ee47)

### GUI Interface

![GUI View 1](https://github.com/user-attachments/assets/8bbd27aa-abd9-4144-89a7-c86b2b17cc45)

</div>

---

## 👥 Authors

<div align="center">

| Name | Role |
|------|------|
| **Arellano, Jaybert Ivan P.** | Developer |
| **Encarnacion, Kyle Raphael R.** | Developer |
| **Sua-an, Pauline Bernadeth G.** | Developer |

</div>

---

## 🙏 Acknowledgements

We would like to express our gratitude to:

- **Our Instructor** - For the guidance provided throughout the development of this project. Their feedback helped us better understand Java and apply OOP principles effectively.

- **Our Groupmates** - For the teamwork and cooperation that made this project successful.

- **Online Resources** - Especially [Programiz](https://www.programiz.com/java-programming) for helping us test and run our Java program smoothly.

This project would not be as polished without everyone's support.

---

<div align="center">

### ⭐ If you find this project useful, please consider giving it a star!

**Made with ❤️ and ☕ by the Medical Reminder Team**

</div>
