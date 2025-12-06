<div align="center">

# ⚕️ Medical Reminder System

### A Comprehensive Java Application for Medication Management

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com)
[![Console](https://img.shields.io/badge/Console-Terminal-green.svg?style=for-the-badge)](https://github.com/2408189Kyle/java-medical-reminder-system/tree/main/src/console-based)
[![GUI](https://img.shields.io/badge/GUI-Swing-blue.svg?style=for-the-badge)](https://github.com/2408189Kyle/java-medical-reminder-system/tree/main/src/gui)

*Ensuring timely medication intake through organized record-keeping*

</div>

---

## 📋 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [System Requirements](#-system-requirements)
- [Installation & Setup](#-installation--setup)
- [Menu Functions](#-menu-functions)
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

<div align="center">

| Feature | Description |
|---------|-------------|
| 👤 **Patient Profile** | Register and view patient's age and gender |
| 💊 **Prescription Management** | Define medication, dosage, treatment frequency (e.g., "8 hours"), start time, and duration |
| ✅ **Tracking & Status** | Mark doses taken and manage prescription status (Active, Inactive, Completed) |
| 📊 **Usage Calculation** | Project the total number of doses required for a specified period |
| 📅 **Dashboard & Schedule** | View health overview and detailed schedule of upcoming doses |
| 🔍 **Search Functionality** | Quick medicine search by name |
| ⚠️ **Dosage Guidance** | Age-appropriate medication recommendations |
| 🎯 **Smart Sorting** | Automatic prioritization of active and overdue medications |

</div>

---

## 🖥️ System Requirements

```
☕ Java Development Kit (JDK) 8 or higher
💻 Any operating system (Windows, macOS, Linux)
📦 Java Swing library (included in JDK)
```

---

## 📁 Project Structure

<div align="center">

### Repository Organization

</div>

```
📦 java-medical-reminder-system
├── 📂 src/
│   ├── 📂 console-based/
│   │   └── ☕ Medical.java
│   └── 📂 gui/
│       ├── 📂 bin/
│       ├── ☕ App.java
│       └── ☕ MedicalGUI.java
├── 📄 .gitignore
└── 📄 README.md
```

<table>
<tr>
<td width="30%"><b>📂 src/console-based/</b></td>
<td>
Contains the <b>command-line version</b> of the application<br>
• <code>Medical.java</code> - Complete console-based implementation
</td>
</tr>
<tr>
<td><b>📂 src/gui/</b></td>
<td>
Contains the <b>graphical user interface version</b><br>
• <code>App.java</code> - GUI application entry point<br>
• <code>MedicalGUI.java</code> - Swing-based graphical interface<br>
• <code>bin/</code> - Compiled class files
</td>
</tr>
<tr>
<td><b>📄 README.md</b></td>
<td>
Complete documentation and user guide
</td>
</tr>
<tr>
<td><b>📄 .gitignore</b></td>
<td>
Git configuration for excluding unnecessary files
</td>
</tr>
</table>

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

## 🎯 Menu Functions

<div align="center">

### Main Menu Options

| Option | Function | Purpose |
|--------|----------|---------|
| **1** | 🆕 Add New Prescription | Creates a new medicine entry with dosage, frequency, start time, duration, and type (Oral/Tablet/Capsule). Validates input and schedules the first dose automatically. |
| **2** | 📅 View Dose Schedule | Displays all medications sorted by status and next dose time. Shows active, inactive, completed, and overdue medications with visual indicators (*DUE*) for urgent doses. |
| **3** | ✅ Mark Dose Taken | Records medication intake and automatically calculates the next dose time based on frequency. Updates the medication schedule in real-time. |
| **4** | 🔄 Update Status | Allows users to change prescription status (Active/Inactive/Completed), view details, or delete medications. Includes confirmation prompts for critical actions. |
| **5** | 📊 Calculate Medicine Usage | Computes total doses needed based on frequency and duration. Helps patients plan medication purchases and track consumption patterns. |
| **6** | ⚕️ Dosage Guidance | Provides age-appropriate dosing recommendations: Pediatric (0-12), Standard Adult (13-64), or Senior (65+) with reduced dose warnings. |
| **7** | 📄 View Prescription Details | Shows comprehensive information including dosage, frequency, status, notes, start date, duration, and remaining days of treatment. |
| **8** | 🔍 Search Medicine | Enables quick lookup of medications by name using case-insensitive search. Returns all matching prescriptions with their current status. |
| **9** | 🚪 Exit | Safely closes the application and displays a goodbye message. |

</div>

---

## 💊 Add New Prescription - Detailed Explanation

<div align="center">

### Understanding the Prescription Creation Process

</div>

The **Add New Prescription** feature is the cornerstone of the Medical Reminder System. It guides users through a comprehensive process to create a complete medication schedule with all necessary details.

---

### 📝 Prescription Components Explained

<table>
<tr>
<td width="25%"><b>🏷️ Medicine Name</b></td>
<td>
<b>Purpose:</b> Identifies the specific medication being taken<br>
<b>Example:</b> "Biogesic", "Paracetamol", "Amoxicillin"<br>
<b>Validation:</b> Cannot be empty; system prompts until valid name is entered<br>
<b>Usage:</b> Used for searching, displaying schedules, and identifying prescriptions
</td>
</tr>
<tr>
<td><b>💉 Dosage</b></td>
<td>
<b>Purpose:</b> Specifies the <b>amount of medication</b> to take per dose<br>
<b>Format:</b> Number + Unit (e.g., "300mg", "500mg", "10ml", "2 tablets")<br>
<b>Example:</b> "300mg" means 300 milligrams per dose<br>
<b>Important:</b> Must match doctor's prescription exactly for safety<br>
<b>Display:</b> Shown in schedule views and dose confirmations
</td>
</tr>
<tr>
<td><b>⏱️ Frequency</b></td>
<td>
<b>Purpose:</b> Determines <b>how often</b> medication should be taken<br>
<b>Format:</b> "[Number] [Unit]" where Unit = hours, days, or minutes<br>
<b>Examples:</b>
<ul>
<li>"8 hours" → Take every 8 hours (3 times daily)</li>
<li>"1 day" → Take once daily</li>
<li>"12 hours" → Take twice daily</li>
<li>"6 hours" → Take every 6 hours (4 times daily)</li>
</ul>
<b>System Behavior:</b> Automatically calculates next dose time based on frequency<br>
<b>Smart Calculation:</b> If you take medicine at 12:00 with "8 hours" frequency, next dose = 20:00
</td>
</tr>
<tr>
<td><b>📝 Notes</b></td>
<td>
<b>Purpose:</b> Special instructions for taking the medication<br>
<b>Examples:</b>
<ul>
<li>"Take with food" - Prevents stomach upset</li>
<li>"Before meals" - For better absorption</li>
<li>"Before sleeping" - For nighttime medications</li>
<li>"After eating" - To avoid nausea</li>
</ul>
<b>Optional:</b> Can be left blank if no special instructions<br>
<b>Display:</b> Shown in prescription details for quick reference
</td>
</tr>
</table>

---

### 🕐 Date and Time System - Understanding the Schedule

<div align="center">

#### **Initial Dose Time** - When Your Treatment Begins

</div>

The system uses a **precise date and time format** to ensure accurate medication scheduling:

<table>
<tr>
<td width="30%"><b>📅 Date Format</b></td>
<td>
<b>Format:</b> DD/MM/YYYY (Day/Month/Year)<br>
<b>Example:</b> 06/12/2025 means December 6, 2025<br>
<b>Purpose:</b> Sets the <b>starting date</b> of your medication schedule<br>
<b>Validation:</b> System checks for valid date format
</td>
</tr>
<tr>
<td><b>🕒 Time Format</b></td>
<td>
<b>Format:</b> HH:MM (24-hour format)<br>
<b>Examples:</b>
<ul>
<li>12:11 = 12:11 PM (noon)</li>
<li>08:00 = 8:00 AM</li>
<li>20:30 = 8:30 PM</li>
<li>00:00 = Midnight</li>
</ul>
<b>Purpose:</b> Sets the <b>exact time</b> for first dose<br>
<b>Important:</b> All subsequent doses calculated from this time
</td>
</tr>
<tr>
<td><b>⚡ How It Works</b></td>
<td>
<b>Example Calculation:</b><br>
✓ First dose: 06/12/2025 12:11<br>
✓ Frequency: "5 hours"<br>
✓ Second dose: 06/12/2025 17:11 (12:11 + 5 hours)<br>
✓ Third dose: 06/12/2025 22:11 (17:11 + 5 hours)<br>
✓ Fourth dose: 07/12/2025 03:11 (22:11 + 5 hours)<br>
<br>
<b>Smart Features:</b><br>
🔸 Automatic calculation - No manual math needed<br>
🔸 Crosses midnight automatically - Handles date changes<br>
🔸 Tracks all doses - Complete history maintained
</td>
</tr>
</table>

---

### ⏳ Treatment Duration - How Long to Take Medicine

<table>
<tr>
<td width="30%"><b>Purpose</b></td>
<td>Specifies the <b>total number of days</b> for the treatment course</td>
</tr>
<tr>
<td><b>Format</b></td>
<td>
<b>Whole number (0 or positive)</b><br>
• Enter specific days: "5", "7", "14", "30"<br>
• Enter 0: For continuous/ongoing medication
</td>
</tr>
<tr>
<td><b>Examples</b></td>
<td>
<b>Duration: 5 days</b><br>
→ Treatment runs from start date to 5 days later<br>
→ Example: Dec 6 to Dec 10<br>
→ System warns when duration ends<br>
<br>
<b>Duration: 0 days (Continuous)</b><br>
→ No end date - ongoing treatment<br>
→ Example: Daily vitamins, chronic condition meds<br>
→ Take until doctor advises to stop
</td>
</tr>
<tr>
<td><b>System Behavior</b></td>
<td>
✅ Tracks remaining days automatically<br>
✅ Shows "Days Left" in prescription details<br>
✅ Marks as "OVERDUE" if doses continue past duration<br>
✅ Helps plan when to refill prescriptions
</td>
</tr>
</table>

---

### 💊 Medicine Types - Understanding the Difference

<div align="center">

#### **Why Medicine Type Matters**

The system categorizes medications into three types, each with **specific intake methods** and **handling instructions**.

</div>

---

#### **1️⃣ Oral Medicine (Liquid Medications)**

<table>
<tr>
<td width="25%"><b>🔷 What Is It?</b></td>
<td>
Liquid medications that come in <b>syrup, suspension, or solution form</b>
</td>
</tr>
<tr>
<td><b>📋 Examples</b></td>
<td>
• <b>Cough syrup</b> - For colds and flu<br>
• <b>Antibiotic suspensions</b> - Amoxicillin syrup for children<br>
• <b>Pain relievers</b> - Liquid ibuprofen or paracetamol<br>
• <b>Vitamin supplements</b> - Multivitamin syrups<br>
• <b>Antacids</b> - Liquid stomach relief medications
</td>
</tr>
<tr>
<td><b>💉 Dosage Format</b></td>
<td>
Usually measured in <b>milliliters (ml)</b> or <b>teaspoons (tsp)</b><br>
Examples: "10ml", "5ml", "1 tsp", "15ml"
</td>
</tr>
<tr>
<td><b>✅ How to Take</b></td>
<td>
<b>System Instruction:</b> "Swallow the Oral Medicine: [name]"<br>
<br>
<b>Proper Method:</b><br>
1️⃣ Shake bottle if instructed (suspensions settle)<br>
2️⃣ Measure exact amount using medicine cup/syringe<br>
3️⃣ Swallow directly - don't mix with other liquids unless told<br>
4️⃣ Can follow with water if needed
</td>
</tr>
<tr>
<td><b>🎯 Special Considerations</b></td>
<td>
⚠️ <b>Must measure accurately</b> - Use proper measuring tools<br>
⚠️ <b>Check expiration</b> - Liquids expire faster once opened<br>
⚠️ <b>Storage</b> - Some need refrigeration (check label)<br>
✅ <b>Best for:</b> Children, people who can't swallow pills, faster absorption
</td>
</tr>
</table>

---

#### **2️⃣ Tablet (Compressed Solid Medications)**

<table>
<tr>
<td width="25%"><b>🔷 What Is It?</b></td>
<td>
<b>Solid, flat, or round medications</b> compressed into a hard form
</td>
</tr>
<tr>
<td><b>📋 Examples</b></td>
<td>
• <b>Biogesic (Paracetamol)</b> - Pain and fever relief<br>
• <b>Aspirin</b> - Blood thinner, pain relief<br>
• <b>Vitamins</b> - Vitamin C, multivitamins<br>
• <b>Antibiotics</b> - Amoxicillin tablets<br>
• <b>Allergy medications</b> - Antihistamine tablets
</td>
</tr>
<tr>
<td><b>💉 Dosage Format</b></td>
<td>
Usually measured in <b>milligrams (mg)</b> or number of tablets<br>
Examples: "500mg", "300mg", "1 tablet", "2 tablets"
</td>
</tr>
<tr>
<td><b>✅ How to Take</b></td>
<td>
<b>System Instruction:</b> "Take Tablet with water: [name]"<br>
<br>
<b>Proper Method:</b><br>
1️⃣ Place tablet on tongue<br>
2️⃣ <b>Drink full glass of water</b> (very important!)<br>
3️⃣ Swallow tablet whole - <b>don't crush unless directed</b><br>
4️⃣ Remain upright for a few minutes
</td>
</tr>
<tr>
<td><b>🎯 Special Considerations</b></td>
<td>
⚠️ <b>Always take with water</b> - Prevents throat irritation<br>
⚠️ <b>Don't crush/break</b> - Unless tablet has score line or doctor says okay<br>
⚠️ <b>Can be split</b> - If it has a line down the middle (scored)<br>
✅ <b>Advantages:</b> Long shelf life, easy to store, precise dosing<br>
✅ <b>Best for:</b> Adults, controlled-release medications
</td>
</tr>
</table>

---

#### **3️⃣ Capsule (Two-Piece Gelatin Shell)**

<table>
<tr>
<td width="25%"><b>🔷 What Is It?</b></td>
<td>
Medication enclosed in a <b>two-piece gelatin or vegetarian shell</b> (usually oblong shape)
</td>
</tr>
<tr>
<td><b>📋 Examples</b></td>
<td>
• <b>Paracetamol capsules</b> - Pain and fever relief<br>
• <b>Antibiotics</b> - Amoxicillin capsules<br>
• <b>Omega-3 supplements</b> - Fish oil capsules<br>
• <b>Probiotics</b> - Digestive health supplements<br>
• <b>Vitamin E</b> - Oil-based vitamin supplements
</td>
</tr>
<tr>
<td><b>💉 Dosage Format</b></td>
<td>
Usually measured in <b>milligrams (mg)</b> or <b>international units (IU)</b><br>
Examples: "400mg", "500mg", "1000 IU", "1 capsule"
</td>
</tr>
<tr>
<td><b>✅ How to Take</b></td>
<td>
<b>System Instruction:</b> "Swallow Capsule whole: [name]"<br>
<br>
<b>Proper Method:</b><br>
1️⃣ Place capsule on tongue<br>
2️⃣ <b>Swallow WHOLE with water</b> - Very important!<br>
3️⃣ <b>NEVER open, crush, or chew capsules</b><br>
4️⃣ Take with full glass of water<br>
5️⃣ Can tilt head forward slightly (helps swallowing)
</td>
</tr>
<tr>
<td><b>🎯 Special Considerations</b></td>
<td>
❌ <b>NEVER open capsules</b> - Contents may be:<br>
  • Bitter tasting and cause nausea<br>
  • Time-released (opening breaks the mechanism)<br>
  • Irritating to mouth/throat<br>
  • Damaged by stomach acid if not protected<br>
<br>
⚠️ <b>Shell dissolves in stomach</b> - Releases medication at right time<br>
⚠️ <b>May float</b> - Easier to swallow than tablets for some people<br>
✅ <b>Advantages:</b> Masks bad taste, protects sensitive ingredients, easier to swallow<br>
✅ <b>Best for:</b> Extended-release meds, oil-based vitamins, stomach-sensitive drugs
</td>
</tr>
</table>

---

### 🔄 Polymorphism in Action - Medicine Types

<div align="center">

#### **Why Three Different Types?**

</div>

The system uses **Object-Oriented Programming (Polymorphism)** to handle different medicine types intelligently:

```java
// Same method call, different behaviors
tablet.take()    → "Take Tablet with water: Biogesic"
capsule.take()   → "Swallow Capsule whole: Paracetamol"
oral.take()      → "Swallow the Oral Medicine: Syrup"
```

**Benefits:**
- ✅ **Type-Specific Instructions** - Correct guidance for each medication form
- ✅ **Safety** - Prevents mistakes (e.g., crushing capsules that shouldn't be crushed)
- ✅ **User-Friendly** - Clear, actionable directions every time
- ✅ **Extensible** - Easy to add new medicine types in the future

---

### 📊 Complete Prescription Example

<div align="center">

**Real-World Example: Creating a Biogesic Prescription**

</div>

```
Medicine Name: Biogesic
Dosage: 300mg
Frequency: 5 hours
Notes: Before Sleeping

Date: 06/12/2025
Time: 12:11
Duration: 5 days
Type: Tablet (Option 2)

✓ Result:
  → First dose: Dec 6, 2025 at 12:11 PM
  → Takes 300mg every 5 hours
  → Total duration: 5 days (Dec 6 - Dec 10)
  → Type: Tablet (must take with water)
  → Special note: Take before sleeping
  → Total doses needed: 20 doses (4 per day × 5 days)
```

---

### ⚠️ Important Validation & Safety Features

<table>
<tr>
<td width="30%"><b>✅ Input Validation</b></td>
<td>
• <b>Medicine name</b> - Cannot be empty<br>
• <b>Dosage</b> - Cannot be empty<br>
• <b>Frequency</b> - Must follow "Number Unit" format<br>
• <b>Date/Time</b> - Must be valid DD/MM/YYYY HH:MM format<br>
• <b>Duration</b> - Must be 0 or positive number<br>
• <b>Medicine type</b> - Must select 1, 2, or 3
</td>
</tr>
<tr>
<td><b>🔔 Automatic Features</b></td>
<td>
• <b>Next dose calculation</b> - Automatic based on frequency<br>
• <b>Age-appropriate guidance</b> - Checks patient age (23 = Adult)<br>
• <b>Status tracking</b> - Sets as "ACTIVE" immediately<br>
• <b>Schedule integration</b> - Adds to dose schedule automatically<br>
• <b>Days remaining counter</b> - Tracks treatment progress
</td>
</tr>
<tr>
<td><b>🛡️ Safety Checks</b></td>
<td>
• <b>Dosage guidance</b> - Shows age-appropriate recommendations<br>
• <b>Past time warning</b> - Notes if start time is in the past<br>
• <b>Duration exceeded alert</b> - Warns when treatment period ends<br>
• <b>Type-specific instructions</b> - Prevents improper intake methods
</td>
</tr>
</table>

---

## 📺 Complete Program Output

<div align="center">

### Full System Demonstration - Step by Step

*This section shows the complete program flow from start to finish*

</div>

---

### 🏁 System Initialization

```
+________________________________________+
|    MEDICAL REMINDER SYSTEM             |
+________________________________________+

  Full Name: Red Baron Barba
  Age: 23
  Gender (M/F): M

+________________________________________+
|          PATIENT RECORD                |
+________________________________________+
| ID: PAT61248                       |
| Name: Red Baron Barba              |
| Age: 23                            |
| Gender: Male                       |
| Recorded: 2025-12-06                |
+________________________________________+
```

**What Happened:** Patient successfully registered with unique ID PAT61248. Age verification (23) categorized as Adult for standard dosage recommendations.

---

### 📝 Step 1: Adding First Prescription - Biogesic

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
  Choose option: 1

  +___ NEW PRESCRIPTION ___+
  Medicine Name: Biogesic
  Dosage (e.g., 500mg): 300mg
  Frequency (e.g., '8 hours' or '1 day'): 5 hours
  Notes (e.g., 'Take with food' or 'Before meals'): Before Sleeping 

  +-- Initial Dose Time
  | Date (DD/MM/YYYY): 06/12/2025
  | Time (HH:MM): 12:11

  Duration in days (0 for continuous): 5

  +-- Medicine Type
  | 1) Oral Medicine
  | 2) Tablet
  | 3) Capsule
  +-- Choose (1-3): 2

  V Prescription added and scheduled!
  The first dose is set for: 06/12/2025 12:11

  +____ DOSAGE GUIDANCE ____+
  | AGE: Adult (13-64)     |
  | Standard dosage OK     |
  +_________________________+
```

**What Happened:** Biogesic tablet (300mg) scheduled every 5 hours for 5 days starting December 6, 2025 at 12:11. System validates age and confirms standard adult dosage is appropriate.

---

### 📅 Step 2: Viewing Initial Schedule

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
  Choose option: 2

  +____ UPCOMING DOSE SCHEDULE ____+
  +___________________________________________+
  | No | Name         | Next Dose Time     | Status  |
  +___________________________________________+
  |  1 | Biogesic     | 06/12/2025 12:11   | ACTIVE      |
  +___________________________________________+
```

**What Happened:** Schedule displays one active prescription with next dose time clearly shown.

---

### 📝 Step 3: Adding Second Prescription - Paracetamol

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
  Choose option: 1

  +___ NEW PRESCRIPTION ___+
  Medicine Name: Paracetamol
  Dosage (e.g., 500mg): 400mg
  Frequency (e.g., '8 hours' or '1 day'): 1 day
  Notes (e.g., 'Take with food' or 'Before meals'): Before meals

  +-- Initial Dose Time
  | Date (DD/MM/YYYY): 07/12/2025
  | Time (HH:MM): 12:21

  Duration in days (0 for continuous): 2

  +-- Medicine Type
  | 1) Oral Medicine
  | 2) Tablet
  | 3) Capsule
  +-- Choose (1-3): 3

  V Prescription added and scheduled!
  The first dose is set for: 07/12/2025 12:21

  +____ DOSAGE GUIDANCE ____+
  | AGE: Adult (13-64)     |
  | Standard dosage OK     |
  +_________________________+
```

**What Happened:** Paracetamol capsule (400mg) added with once-daily dosing for 2 days starting December 7, 2025. Note added to take before meals.

---

### 📅 Step 4: Updated Schedule with Multiple Prescriptions

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
  Choose option: 2

  +____ UPCOMING DOSE SCHEDULE ____+
  +___________________________________________+
  | No | Name         | Next Dose Time     | Status  |
  +___________________________________________+
  |  1 | Biogesic     | 06/12/2025 12:11   | ACTIVE      |
  |  2 | Paracetamol  | 07/12/2025 12:21   | ACTIVE      |
  +___________________________________________+
```

**What Happened:** Both medications now visible in schedule, sorted by next dose time for easy tracking.

---

### ✅ Step 5: Marking First Dose - Biogesic

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
  Choose option: 3

  +____ ACTIVE PRESCRIPTIONS ____+
  | No | Name         | Dosage  | Status  |
  +______________________________________+
  |  1 | Biogesic     | 300mg   | ACTIVE  |
  |  2 | Paracetamol  | 400mg   | ACTIVE  |
  +______________________________________+
  Select (0 to cancel): 1

  +____ DOSE CONFIRMATION ____+
  | Biogesic (300mg)
  -> Take Tablet with water: Biogesic
  Calculate next dose? (y/n): y
  V Next dose: 06/12/2025 17:11
```

**What Happened:** First Biogesic dose recorded. System automatically calculates next dose 5 hours later (17:11). Polymorphism in action - displays "Take Tablet with water" specific to Tablet class.

---

### ✅ Step 6: Marking Second Dose - Biogesic

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
  Choose option: 3

  +____ ACTIVE PRESCRIPTIONS ____+
  | No | Name         | Dosage  | Status  |
  +______________________________________+
  |  1 | Biogesic     | 300mg   | ACTIVE  |
  |  2 | Paracetamol  | 400mg   | ACTIVE  |
  +______________________________________+
  Select (0 to cancel): 1

  +____ DOSE CONFIRMATION ____+
  | Biogesic (300mg)
  -> Take Tablet with water: Biogesic
  Calculate next dose? (y/n): y
  V Next dose: 06/12/2025 22:11
```

**What Happened:** Second Biogesic dose marked. Next dose automatically scheduled for 22:11 (another 5 hours). System maintains consistent 5-hour intervals.

---

### 🔄 Step 7: Changing Paracetamol Status to INACTIVE

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
  Choose option: 4

  +____ STATUS UPDATE ____+
  1) Biogesic             [ACTIVE]
  2) Paracetamol          [ACTIVE]
  Select (0 to cancel): 2

  +____ PARACETAMOL ____+
  | Current Status: ACTIVE                 |
  |________________________|
  | 1) Set to ACTIVE       |
  | 2) Set to INACTIVE     |
  | 3) Set to COMPLETED    |
  | 4) View Full Details   |
  | 5) Delete Medicine     |
  | 6) Cancel              |
  +________________________+
  Choose (1-6): 2
  V Status: INACTIVE
```

**What Happened:** Paracetamol temporarily deactivated. Remains in system but won't appear in active prescriptions list. Encapsulation ensures status change is properly managed.

---

### 📅 Step 8: Viewing Updated Schedule (After Status Change)

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
  Choose option: 2

  +____ UPCOMING DOSE SCHEDULE ____+
  +___________________________________________+
  | No | Name         | Next Dose Time     | Status  |
  +___________________________________________+
  |  1 | Biogesic     | 06/12/2025 22:11   | ACTIVE      |
  |  2 | Paracetamol  | 07/12/2025 12:21   | INACTIVE     |
  +___________________________________________+
```

**What Happened:** Schedule now shows Biogesic's updated next dose time (22:11) and Paracetamol's inactive status. Both medications still tracked but status clearly differentiated.

---

### 🔄 Step 9: Marking Paracetamol as COMPLETED

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
  Choose option: 4

  +____ STATUS UPDATE ____+
  1) Biogesic             [ACTIVE]
  2) Paracetamol          [INACTIVE]
  Select (0 to cancel): 2

  +____ PARACETAMOL ____+
  | Current Status: INACTIVE               |
  |________________________|
  | 1) Set to ACTIVE       |
  | 2) Set to INACTIVE     |
  | 3) Set to COMPLETED    |
  | 4) View Full Details   |
  | 5) Delete Medicine     |
  | 6) Cancel              |
  +________________________+
  Choose (1-6): 3
  Confirm mark as COMPLETED? (y/n): y
  V Status: COMPLETED
```

**What Happened:** Paracetamol treatment finished. System requires confirmation before completing to prevent accidental changes. Status permanently set to COMPLETED.

---

### 📊 Step 10: Calculate Medicine Usage - Biogesic

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
  Choose option: 5

  +____ MEDICINE USAGE CALCULATOR ____+
  | Calculates total dosage needed      |
  +___________________________________+

  +-- SELECT PRESCRIPTION
  | 1) Biogesic (300mg)
  | 2) Paracetamol (400mg)
  +-- Choose (1-2): 1

  +____ USAGE ANALYSIS ____+
  | Medicine: Biogesic                |
  | Dosage: 300mg                     |
  | Frequency: 5 hours                |
  |________________________|
  | Duration: 5                       |
  | Doses/Day: 4                      |
  | TOTAL DOSES: 20                   |
  +________________________+
```

**What Happened:** Calculator determines patient needs 20 doses total (4 doses per day × 5 days). Helps plan medication purchases: need to buy at least 20 tablets of Biogesic.

---

### ⚕️ Step 11: Checking Dosage Guidance

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
  Choose option: 6

  +____ DOSAGE GUIDANCE ____+
  | AGE: Adult (13-64)     |
  | Standard dosage OK     |
  +_________________________+
```

**What Happened:** System confirms standard adult dosing is appropriate for 23-year-old patient. Would show different guidance for children (0-12) or seniors (65+).

---

### 📄 Step 12: Viewing Detailed Prescription Information

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
  Choose option: 7

  +____ VIEW PRESCRIPTION DETAILS ____+
  1) Biogesic (ACTIVE)
  2) Paracetamol (COMPLETED)
  Select (0 to cancel): 2
  +-------------------------------------+
  | Paracetamol (Capsule)
  +-------------------------------------+
  | Dosage: 400mg
  | Frequency: 1 day
  | Next Dose: 07/12/2025 12:21
  | Status: COMPLETED
  | Notes: Before meals
  | Start: 07/12/2025
  | Duration: 2 days
  | Days Left: 3
  +-------------------------------------+
```

**What Happened:** Comprehensive view shows all Paracetamol details including type (Capsule), notes, start date, and remaining days. Demonstrates `displayInfo()` method from Medicine class.

---

### 🔍 Step 13: Searching for Medicine

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
  Choose option: 8

  Search medicine name: pAraCetamol

  +____ SEARCH RESULTS ____+
  1) Paracetamol (COMPLETED)
  +________________________+
```

**What Happened:** Case-insensitive search successfully finds "Paracetamol" even though user typed "pAraCetamol". Useful for quick lookup when managing multiple prescriptions.

---

### 📅 Step 14: Final Schedule Review

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
  Choose option: 2

  +____ UPCOMING DOSE SCHEDULE ____+
  +___________________________________________+
  | No | Name         | Next Dose Time     | Status  |
  +___________________________________________+
  |  1 | Biogesic     | 06/12/2025 22:11   | ACTIVE      |
  |  2 | Paracetamol  | 07/12/2025 12:21   | COMPLETED     |
  +___________________________________________+
```

**What Happened:** Final schedule shows Biogesic still active with next dose at 22:11, and Paracetamol completed. System maintains historical record even after completion.

---

### ✅ Step 15: Marking Third Dose - Biogesic

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
  Choose option: 3

  +____ ACTIVE PRESCRIPTIONS ____+
  | No | Name         | Dosage  | Status  |
  +______________________________________+
  |  1 | Biogesic     | 300mg   | ACTIVE  |
  +______________________________________+
  Select (0 to cancel): 1

  +____ DOSE CONFIRMATION ____+
  | Biogesic (300mg)
  -> Take Tablet with water: Biogesic
  Calculate next dose? (y/n): y
  V Next dose: 07/12/2025 03:11
```

**What Happened:** Third Biogesic dose recorded. Next dose calculated for early next morning (03:11). Only Biogesic appears in active list since Paracetamol is completed.

---

### 👋 Step 16: Exiting the System

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
  Choose option: 9

  Thank you for using Medical Reminder System!
  Goodbye!
```

**What Happened:** Clean program exit with friendly goodbye message. All data properly managed throughout session.

---

<div align="center">

### 📊 Summary of Demonstration

| Metric | Value | Details |
|--------|-------|---------|
| **Total Prescriptions Created** | 2 | Biogesic (Tablet), Paracetamol (Capsule) |
| **Doses Recorded** | 3 | All for Biogesic at 5-hour intervals |
| **Status Changes** | 2 | Paracetamol: ACTIVE → INACTIVE → COMPLETED |
| **Features Demonstrated** | 9/9 | All menu functions successfully tested |
| **OOP Concepts Shown** | 4/4 | Encapsulation, Inheritance, Abstraction, Polymorphism |

</div>

---

## 📖 Individual Feature Examples

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

<div align="center">

### Object-Oriented Programming Implementation

</div>

### 🔒 1. Encapsulation

**Definition:** Bundling data (fields) and methods that operate on that data within a single unit (class), while restricting direct access to some components.

**Implementation in Code:**

```java
abstract class Medicine {
    // PRIVATE fields - data is hidden from outside access
    private String name;
    private String dosage;
    private String frequency;
    private LocalDateTime nextTakeTime;
    private boolean isCompleted = false;
    private boolean isActive = true;
    
    // PUBLIC methods - controlled access to data
    public String getName() { return name; }
    public String getDosage() { return dosage; }
    public void setIsCompleted(boolean completed) { 
        this.isCompleted = completed; 
        if (completed) {
            this.isActive = false; // Business logic protection
        }
    }
}
```

**Purpose:**
- ✅ **Data Protection:** Prevents direct modification of critical fields like `nextTakeTime` and `isActive`
- ✅ **Controlled Access:** Getters and setters ensure data validation and business rules are enforced
- ✅ **Maintainability:** Internal implementation can change without affecting external code
- ✅ **Security:** Sensitive patient data in `Patient` class is protected from unauthorized access

**Real Example:** When marking a prescription as completed, the setter automatically sets `isActive` to false, preventing inconsistent states.

---

### 🧬 2. Inheritance

**Definition:** A mechanism where a new class (child/subclass) derives properties and behaviors from an existing class (parent/superclass).

**Implementation in Code:**

```java
// PARENT CLASS - Base blueprint for all medicines
abstract class Medicine {
    private String name;
    private String dosage;
    private String frequency;
    
    public abstract void take(); // Must be implemented by children
    
    public void calculateNextTime() { /* Common logic */ }
    public void displayInfo() { /* Common logic */ }
}

// CHILD CLASSES - Inherit from Medicine
class OralMedicine extends Medicine {
    @Override
    public void take() {
        System.out.println("-> Swallow the Oral Medicine: " + getName());
    }
}

class Tablet extends Medicine {
    @Override
    public void take() {
        System.out.println("-> Take Tablet with water: " + getName());
    }
}

class Capsule extends Medicine {
    @Override
    public void take() {
        System.out.println("-> Swallow Capsule whole: " + getName());
    }
}
```

**Purpose:**
- ✅ **Code Reusability:** All medicine types share common functionality (`calculateNextTime()`, `displayInfo()`)
- ✅ **Hierarchy:** Creates a clear "IS-A" relationship (Tablet IS-A Medicine, Capsule IS-A Medicine)
- ✅ **Extensibility:** New medicine types can be added easily without modifying existing code
- ✅ **Reduced Redundancy:** Common fields and methods are defined once in the parent class

**Real Example:** `Tablet`, `Capsule`, and `OralMedicine` all inherit scheduling logic but provide specific intake instructions.

---

### 🎭 3. Abstraction

**Definition:** Hiding complex implementation details and showing only essential features. Abstract classes cannot be instantiated directly.

**Implementation in Code:**

```java
// ABSTRACT CLASS - Cannot be instantiated directly
abstract class Medicine {
    // Concrete methods - implementation provided
    public void calculateNextTime() {
        // Complex calculation logic hidden from user
        String[] parts = frequency.split(" ");
        long value = Long.parseLong(parts[0]);
        String unit = parts[1].toLowerCase().trim();
        
        Duration duration = switch (unit) {
            case "hours" -> Duration.ofHours(value);
            case "days" -> Duration.ofDays(value);
            default -> null;
        };
        this.nextTakeTime = this.nextTakeTime.plus(duration);
    }
    
    // Abstract method - subclasses MUST implement
    public abstract void take();
}

// User creates specific medicine types, not abstract Medicine
Medicine med = new Tablet("Aspirin", "500mg", "8 hours", time, 5);
```

**Purpose:**
- ✅ **Simplified Interface:** Users interact with simple methods like `take()` without knowing complex calculations
- ✅ **Enforced Structure:** Subclasses must implement `take()`, ensuring consistent behavior
- ✅ **Flexibility:** Implementation details can change without affecting how users interact with Medicine
- ✅ **Focus on "What" not "How":** Users know they can call `calculateNextTime()` without understanding date/time math

**Real Example:** The `calculateNextTime()` method hides complex duration parsing and time calculations. Users just call it, and the next dose is computed automatically.

---

### 🔄 4. Polymorphism

**Definition:** The ability of different classes to be treated as instances of the same parent class, with each providing its own implementation of methods.

**Implementation in Code:**

```java
// Polymorphism in action - same method, different behaviors
List<Medicine> meds = new ArrayList<>();

// All are stored as Medicine type, but are actually different types
meds.add(new Tablet("Biogesic", "300mg", "5 hours", time, 5));
meds.add(new Capsule("Paracetamol", "400mg", "1 day", time, 2));
meds.add(new OralMedicine("Syrup", "10ml", "8 hours", time, 7));

// POLYMORPHIC BEHAVIOR - same method call, different output
for (Medicine m : meds) {
    m.take(); // Calls the appropriate version based on actual type
}

// Output:
// -> Take Tablet with water: Biogesic
// -> Swallow Capsule whole: Paracetamol
// -> Swallow the Oral Medicine: Syrup
```

**Purpose:**
- ✅ **Unified Interface:** All medicines can be stored in one list and processed uniformly
- ✅ **Runtime Behavior:** Correct `take()` method is called based on actual object type at runtime
- ✅ **Extensibility:** New medicine types work with existing code without modifications
- ✅ **Simplified Code:** Single loop handles all medicine types, reducing complexity

**Real Example in Menu Option 3:**
```java
private static void takeAndRecalculate(Scanner sc, List<Medicine> meds) {
    Medicine m = meds.get(index);
    m.take(); // Polymorphic call - displays correct instruction for each type
    m.calculateNextTime(); // Works for all medicine types
}
```

**Runtime Polymorphism:** When marking a dose as taken, the system automatically displays "Take Tablet with water" for tablets, "Swallow Capsule whole" for capsules, and "Swallow the Oral Medicine" for oral medicines—all from the same method call!

---

## 🏗️ Class Architecture

<div align="center">

### System Design Overview

```
┌─────────────────────────────────────────────────────────┐
│                      Medical.java                       │
│                   (Main Application)                     │
└───────────────────┬─────────────────────────────────────┘
                    │
        ┌───────────┴───────────┐
        │                       │
        ▼                       ▼
┌───────────────┐      ┌──────────────┐
│    Patient    │      │   Medicine   │
│     Class     │      │   (Abstract) │
└───────────────┘      └──────┬───────┘
                              │
                 ┌────────────┼────────────┐
                 │            │            │
                 ▼            ▼            ▼
         ┌─────────────┐ ┌─────────┐ ┌─────────┐
         │OralMedicine │ │ Tablet  │ │ Capsule │
         └─────────────┘ └─────────┘ └─────────┘
```

</div>

### 📊 Class Responsibilities Table

<div align="center">

| Class | Type | Responsibility | Key Fields | Key Methods |
|-------|------|---------------|------------|-------------|
| **Medical** | Main | Application entry point and user interface | `meds: List<Medicine>`, `currentPatient: Patient` | `main()`, `createMedicine()`, `takeAndRecalculate()`, `printMenu()` |
| **Patient** | Concrete | Store patient information | `patientID`, `fullName`, `age`, `gender`, `recordedDate` | `displayInfo()`, getters for all fields |
| **Medicine** | Abstract | Base class for all medications | `name`, `dosage`, `frequency`, `nextTakeTime`, `isActive`, `isCompleted` | `take()` (abstract), `calculateNextTime()`, `displayInfo()` |
| **OralMedicine** | Concrete | Represents liquid medications | *(inherits from Medicine)* | `take()` - "Swallow the Oral Medicine" |
| **Tablet** | Concrete | Represents tablet medications | *(inherits from Medicine)* | `take()` - "Take Tablet with water" |
| **Capsule** | Concrete | Represents capsule medications | *(inherits from Medicine)* | `take()` - "Swallow Capsule whole" |

</div>

---

### 📦 Detailed Class Descriptions

#### 1. **Medical Class** (Main Application)

<table>
<tr>
<td width="30%"><b>Purpose</b></td>
<td>Entry point of the application. Manages user interaction, menu display, and coordinates all operations.</td>
</tr>
<tr>
<td><b>Key Responsibilities</b></td>
<td>
• User interface management<br>
• Menu navigation<br>
• Input validation<br>
• Medicine creation and management<br>
• Patient registration<br>
• Coordination between Patient and Medicine objects
</td>
</tr>
<tr>
<td><b>Important Methods</b></td>
<td>
<code>main()</code> - Application entry point<br>
<code>createMedicine()</code> - Creates new Medicine objects<br>
<code>takeAndRecalculate()</code> - Records dose and calculates next time<br>
<code>calculateMedicineUsage()</code> - Computes total doses needed<br>
<code>updateMedicineStatus()</code> - Manages medicine lifecycle<br>
<code>displayAgeRecommendation()</code> - Provides dosage guidance
</td>
</tr>
</table>

---

#### 2. **Patient Class**

<table>
<tr>
<td width="30%"><b>Purpose</b></td>
<td>Represents a patient with personal health information. Encapsulates patient data and provides formatted display.</td>
</tr>
<tr>
<td><b>Fields</b></td>
<td>
<code>patientID: String</code> - Unique identifier<br>
<code>fullName: String</code> - Patient's full name<br>
<code>age: int</code> - Patient's age<br>
<code>gender: String</code> - Patient's gender (Male/Female)<br>
<code>recordedDate: LocalDate</code> - Registration date
</td>
</tr>
<tr>
<td><b>Methods</b></td>
<td>
<code>displayInfo()</code> - Shows formatted patient record<br>
<code>getFullName()</code>, <code>getAge()</code>, <code>getGender()</code> - Data accessors<br>
<code>getPatientID()</code> - Returns unique patient identifier
</td>
</tr>
<tr>
<td><b>OOP Principles</b></td>
<td>
<b>Encapsulation:</b> Private fields with public getters<br>
<b>Single Responsibility:</b> Only manages patient data
</td>
</tr>
</table>

---

#### 3. **Medicine Class** (Abstract)

<table>
<tr>
<td width="30%"><b>Purpose</b></td>
<td>Abstract base class defining common structure and behavior for all medicine types. Cannot be instantiated directly.</td>
</tr>
<tr>
<td><b>Fields</b></td>
<td>
<code>name: String</code> - Medicine name<br>
<code>dosage: String</code> - Dosage amount (e.g., "500mg")<br>
<code>frequency: String</code> - How often to take (e.g., "8 hours")<br>
<code>nextTakeTime: LocalDateTime</code> - Next scheduled dose<br>
<code>startDate: LocalDate</code> - Treatment start date<br>
<code>treatmentDurationInDays: long</code> - Treatment period<br>
<code>notes: String</code> - Additional instructions<br>
<code>isCompleted: boolean</code> - Completion status<br>
<code>isActive: boolean</code> - Active/Inactive status
</td>
</tr>
<tr>
<td><b>Abstract Methods</b></td>
<td>
<code>take()</code> - Must be implemented by subclasses to define specific intake instructions
</td>
</tr>
<tr>
<td><b>Concrete Methods</b></td>
<td>
<code>calculateNextTime()</code> - Computes next dose based on frequency<br>
<code>displayInfo()</code> - Shows comprehensive medicine details<br>
<code>isDurationExceeded()</code> - Checks if treatment period has passed<br>
<code>getStatusDisplay()</code> - Returns current status (ACTIVE/INACTIVE/COMPLETED/OVERDUE)<br>
Multiple getters and setters for all fields
</td>
</tr>
<tr>
<td><b>OOP Principles</b></td>
<td>
<b>Abstraction:</b> Hides complex time calculations and status logic<br>
<b>Encapsulation:</b> All fields are private with controlled access<br>
<b>Inheritance Base:</b> Provides common functionality for subclasses
</td>
</tr>
</table>

---

#### 4. **OralMedicine, Tablet, Capsule Classes** (Concrete)

<table>
<tr>
<td width="30%"><b>Purpose</b></td>
<td>Concrete implementations of Medicine for different medication types. Each provides specific intake instructions.</td>
</tr>
<tr>
<td><b>Inheritance</b></td>
<td>
All three classes extend <code>Medicine</code> abstract class
</td>
</tr>
<tr>
<td><b>Implemented Methods</b></td>
<td>
<b>OralMedicine:</b> <code>take()</code> - "Swallow the Oral Medicine: [name]"<br>
<b>Tablet:</b> <code>take()</code> - "Take Tablet with water: [name]"<br>
<b>Capsule:</b> <code>take()</code> - "Swallow Capsule whole: [name]"<br>
<code>toString()</code> - Returns type name for display
</td>
</tr>
<tr>
<td><b>Constructor</b></td>
<td>
Each constructor accepts: <code>name</code>, <code>dosage</code>, <code>frequency</code>, <code>nextTakeTime</code>, <code>durationDays</code><br>
Calls parent constructor: <code>super(name, dosage, frequency, nextTakeTime, durationDays)</code>
</td>
</tr>
<tr>
<td><b>OOP Principles</b></td>
<td>
<b>Inheritance:</b> Inherits all fields and methods from Medicine<br>
<b>Polymorphism:</b> Each provides unique implementation of <code>take()</code><br>
<b>Liskov Substitution:</b> Can be used anywhere Medicine is expected
</td>
</tr>
</table>

---

### 🔄 How Classes Work Together

```
1. User starts application → Medical.main() executes
2. Patient object created → stores user information
3. User adds prescription → createMedicine() called
4. Medicine subclass instantiated → OralMedicine, Tablet, or Capsule
5. Medicine stored in List<Medicine> → polymorphic collection
6. User marks dose taken → take() method called (polymorphic)
7. Next dose calculated → calculateNextTime() updates schedule
8. Status updates propagate → encapsulated state management
```

---

## 📸 Screenshots

<div align="center">

### Console Interface

![Console View 1](https://github.com/user-attachments/assets/35b3f5ee-7477-4995-a5af-7e184661ee47)

*Figure 1: Console-based interface showing medication tracking and schedule management*

---

### GUI Interface

![GUI View 1](https://github.com/user-attachments/assets/8bbd27aa-abd9-4144-89a7-c86b2b17cc45)

*Figure 2: Graphical user interface with modern Swing components*

</div>

---

## 👥 Authors

<div align="center">

### Development Team

| Name | Role | Contribution |
|------|------|-------------|
| **Encarnacion, Kyle Raphael R.** | Lead Developer | Core system development, complete coding implementation (console & GUI), application architecture, OOP design, README documentation and editing |
| **Arellano, Jaybert Ivan P.** | Developer | System testing, code review, feature validation |
| **Sua-an, Pauline Bernadeth G.** | Developer | User interface design consultation, documentation support |

</div>

---

## 🙏 Acknowledgements

We would like to express our gratitude to:

**Our Instructor**  
For the guidance provided throughout the development of this project. Their feedback helped us better understand Java and apply OOP principles effectively, particularly in implementing encapsulation, inheritance, abstraction, and polymorphism in real-world scenarios.

**Our Groupmates**  
For the teamwork and cooperation that made this project successful. The collaborative debugging sessions and code reviews significantly improved the quality of our implementation.

**Online Resources**  
Especially [Programiz](https://www.programiz.com/java-programming) for helping us test and run our Java program smoothly. The tutorials on abstract classes and inheritance were particularly helpful.

**Open Source Community**  
For the countless examples and best practices that guided our OOP design decisions.

This project would not be as polished without everyone's support and contributions.

---

<div align="center">

### ⭐ If you find this project useful, please consider giving it a star!

**Made with ❤️ and ☕ by the Medical Reminder Team**

---

**© 2025 Medical Reminder System. All Rights Reserved.**

</div>
