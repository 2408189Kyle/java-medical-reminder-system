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

# Author and Acknowledgement
Author:
 Arellano, Jaybert Ivan P.
 Encarnacion , Kyle
 Sua-an, Pauline Bernadeth G.
We would like to express our gratitude to our instructor for the guidance provided throughout the
development of this project. Their feedback helped us better understand Java and apply OOP
principles effectively. We also thank our groupmates for the teamwork and cooperation that made
this project successful. Finally, online resources—especially Programiz—were helpful in testing
and running our Java program smoothly. This project would not be as polished without
everyone’s support.



