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

📂 src/
├── 📂 console-based/
│   └── ☕ Medical.java         
└── 📂 gui/
    └── ☕ MedicalGUI.java  
    
Run Instructions (GUI Version)The GUI provides a more interactive experience using Java Swing.Bash# 1. Navigate to the GUI source directory
$ cd src/gui

# 2. Compile the source file
$ javac MedicalGUI.java

# 3. Run the program
$ java MedicalGUI

