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

-Main Menu


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



