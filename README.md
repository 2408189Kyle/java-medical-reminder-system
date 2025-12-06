# ⚕️ Medical Reminder System
A comprehensive Java application designed to help users manage their medication schedule, ensuring timely intake and organized record-keeping through both Console-Based and Graphical User Interface (GUI) versions.
    
# 💡 Project Overview
The Medical Reminder System is built using Java to track medication schedules, providing daily reminders and organized record-keeping. It allows users to register as a patient, add new prescriptions, track dosages, and monitor treatment duration. The application is available in both a simple console interface (Medical.java) and a modern Swing GUI (MedicalGUI.java).
# ✨ Key Features
Patient Profile: Register and view the patient's age and gender.

Prescription Management: Define medication, dosage, treatment frequency (e.g., "8 hours"), start time, and treatment duration.

Tracking & Status: Easily Mark Doses Taken and manage prescription status (Active, Inactive, Completed).

Usage Calculation: Project the total number of doses required for a specified period (or the entire treatment duration).

Dashboard & Schedule: View a health overview and a detailed schedule of upcoming doses.

# 3. Run the program

<img width="607" height="117" alt="image" src="https://github.com/user-attachments/assets/208c3e1a-5628-4c43-8018-57c4d9c478f0" />


# OOP Concepts Applied


# Encapsulation
The Medicine class uses private fields (`name`, `dose`, `notes`, and `reminderTimes`) with public
getters and setters. This protects data and ensures values are accessed and modified through controlled methods.

# Inheritance
The class ConsoleReminder inherits from the abstract class `Reminder`.
It reuses and extends the reminder framework provided by the parent class.

# Abstraction
The `Reminder` abstract class hides implementation details by requiring subclasses to implement
`notifyUser()`.
Only essential behavior (scheduling reminders) is exposed.

# Class Descriptions

Medicine
Represents a single medicine entry.
Fields: name, dose, notes, and a list of reminder times.
Methods: getters, setters, addReminderTime(), removeReminderTime().
Purpose: Stores all user-defined data for a specific medicine.
MedicineManager
Manages the list of medicines.
Fields: ArrayList of Medicine objects.
Methods: addMedicine(), getMedicine(), updateMedicine(), deleteMedicine(), listAll().
Purpose: Handles CRUD operations (Create, Read, Update, Delete).
Reminder (Abstract Class)
General blueprint for any reminder type.
Fields: Medicine medicine, String timeStr.
Methods:run() and abstract notifyUser().
Purpose:Defines shared structure for reminder behavior.
ConsoleReminder (Subclass)
Extends Reminder to provide console-based notifications.
Overrides: notifyUser() — prints reminder details in the console.
Purpose: Delivers actual reminder output to the user.

# Program Output

Full Name: Red Baron Barba
Age: 23
Gender: M
Patient ID: PAT61248
Recorded: 2025-12-06
System Demo
Main Menu
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

Example Usage
1. Adding New Prescription - Biogesic
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

2. Viewing Dose Schedule
Choose option: 2

UPCOMING DOSE SCHEDULE
+---------------------------------------------------+
| No | Name        | Next Dose Time   | Status     |
+---------------------------------------------------+
|  1 | Biogesic    | 06/12/2025 12:11 | ACTIVE     |
+---------------------------------------------------+

3. Adding Second Prescription - Paracetamol
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

4. Updated Schedule with Multiple Prescriptions
Choose option: 2

UPCOMING DOSE SCHEDULE
+---------------------------------------------------+
| No | Name        | Next Dose Time   | Status     |
+---------------------------------------------------+
|  1 | Biogesic    | 06/12/2025 12:11 | ACTIVE     |
|  2 | Paracetamol | 07/12/2025 12:21 | ACTIVE     |
+---------------------------------------------------+

5. Marking Dose as Taken
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
Second Dose:
Choose option: 3
Select: 1

✓ Next dose: 06/12/2025 22:11

6. Updating Prescription Status
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
Updated Schedule:
UPCOMING DOSE SCHEDULE
+---------------------------------------------------+
| No | Name        | Next Dose Time   | Status     |
+---------------------------------------------------+
|  1 | Biogesic    | 06/12/2025 22:11 | ACTIVE     |
|  2 | Paracetamol | 07/12/2025 12:21 | INACTIVE   |
+---------------------------------------------------+
Marking as Completed:
Choose option: 4
Select: 2
Choose: 3

Confirm mark as COMPLETED? (y/n): y
✓ Status: COMPLETED

7. Calculate Medicine Usage
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

8. Dosage Guidance
Choose option: 6

DOSAGE GUIDANCE
AGE: Adult (13-64)
Standard dosage OK

9. View Prescription Details
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

10. Search Medicine
Choose option: 8

Search medicine name: pAraCetamol

SEARCH RESULTS
1) Paracetamol (COMPLETED)

11. Final Schedule
Choose option: 2

UPCOMING DOSE SCHEDULE
+---------------------------------------------------+
| No | Name        | Next Dose Time   | Status     |
+---------------------------------------------------+
|  1 | Biogesic    | 06/12/2025 22:11 | ACTIVE     |
|  2 | Paracetamol | 07/12/2025 12:21 | COMPLETED  |
+---------------------------------------------------+

12. Mark Final Dose
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

Features

✅ Add multiple prescriptions with custom schedules
✅ Track medication dosage and frequency
✅ Set medication reminders
✅ Mark doses as taken
✅ Update prescription status (Active/Inactive/Completed)
✅ Calculate total medicine usage
✅ Age-appropriate dosage guidance
✅ View detailed prescription information
✅ Search medications by name
✅ Support for different medicine types (Oral, Tablet, Capsule)


System Exit
Choose option: 9

Thank you for using Medical Reminder System!
Goodbye!


- with GUI

  <img width="1186" height="728" alt="image" src="https://github.com/user-attachments/assets/35b3f5ee-7477-4995-a5af-7e184661ee47" />


  <img width="1181" height="727" alt="image" src="https://github.com/user-attachments/assets/8bbd27aa-abd9-4144-89a7-c86b2b17cc45" />

# Author and Acknowledgement

Author:
 Arellano, Jaybert Ivan P.
 
 Encarnacion , Kyle Raphael R.
 
 Sua-an, Pauline Bernadeth G.
 
We would like to express our gratitude to our instructor for the guidance provided throughout the
development of this project. Their feedback helped us better understand Java and apply OOP
principles effectively. We also thank our groupmates for the teamwork and cooperation that made
this project successful. Finally, online resources—especially Programiz—were helpful in testing
and running our Java program smoothly. This project would not be as polished without
everyone’s support.



