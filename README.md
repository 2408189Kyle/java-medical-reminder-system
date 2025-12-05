Medical Reminder System
Description / Overview
The Medical Reminder System is a Java console-based application designed to help users manage their medicines and ensure they take them on time. It allows users to add, view, update, and delete medicine records, including scheduled reminder times. The system uses Object-Oriented Programming (OOP) principles and a scheduling mechanism to trigger console notifications at specified times. It solves the problem of forgetting medication by providing daily reminders and organized record-keeping in a simple and efficient way.

Functionality
Users can:

Register as a patient.

View Health Overview.

Add Prescription.

Mark Dose Taken.

Manage Status (Active, Inactive, Completed).

Delete Prescription.

Calculate Usage (The total number of doses needed for a period).

Project Structure and Files
Entry Storage
📂 src/
└── 📂 console-based/
    ├── ☕ Medical.java
    └── 📂 gui/
        ├── 📂 bin/
        │   ├── app.class
        │   ├── capsule.class
        │   ├── medicine.class
        │   ├── OralMedicine.class
        │   ├── Patient.class
        │   ├── Tablet.class
        │   └── class
        ├── App.java
        └── MedicalGUI.java

Medical Reminder System
Description / Overview
The Medical Reminder System is a Java console-based application designed to help users manage their medicines and ensure they take them on time. It allows users to add, view, update, and delete medicine records, including scheduled reminder times. The system uses Object-Oriented Programming (OOP) principles and a scheduling mechanism to trigger console notifications at specified times. It solves the problem of forgetting medication by providing daily reminders and organized record-keeping in a simple and efficient way.

Functionality
Users can:

Register as a patient.

View Health Overview.

Add Prescription.

Mark Dose Taken.

Manage Status (Active, Inactive, Completed).

Delete Prescription.

Calculate Usage (The total number of doses needed for a period).

Project Structure and Files
Entry Storage
📂 src/
└── 📂 console-based/
    ├── ☕ Medical.java
    └── 📂 gui/
        ├── 📂 bin/
        │   ├── app.class
        │   ├── capsule.class
        │   ├── medicine.class
        │   ├── OralMedicine.class
        │   ├── Patient.class
        │   ├── Tablet.class
        │   └── class
        ├── App.java
        └── MedicalGUI.java
        
How to Run the Program
GUI Version: (Using MedicalGUI.java)


📂 gui
$ javac MedicalGUI.java
$ java MedicalGUI
Console-Based Version: (Using Medical.java)


📂 console-based
$ javac Medical.java
$ java Medical

Medical Reminder System
Description / Overview
The Medical Reminder System is a Java console-based application designed to help users manage their medicines and ensure they take them on time. It allows users to add, view, update, and delete medicine records, including scheduled reminder times. The system uses Object-Oriented Programming (OOP) principles and a scheduling mechanism to trigger console notifications at specified times. It solves the problem of forgetting medication by providing daily reminders and organized record-keeping in a simple and efficient way.

Functionality
Users can:

Register as a patient.

View Health Overview.

Add Prescription.

Mark Dose Taken.

Manage Status (Active, Inactive, Completed).

Delete Prescription.

Calculate Usage (The total number of doses needed for a period).

Project Structure and Files
Entry Storage
📂 src/
└── 📂 console-based/
    ├── ☕ Medical.java
    └── 📂 gui/
        ├── 📂 bin/
        │   ├── app.class
        │   ├── capsule.class
        │   ├── medicine.class
        │   ├── OralMedicine.class
        │   ├── Patient.class
        │   ├── Tablet.class
        │   └── class
        ├── App.java
        └── MedicalGUI.java
How to Run the Program
GUI Version: (Using MedicalGUI.java)

Bash

📂 gui
$ javac MedicalGUI.java
$ java MedicalGUI
Console-Based Version: (Using Medical.java)

Bash

📂 console-based
$ javac Medical.java
$ java Medical

Core Features
The system provides the following core functions:

Add Prescription: Input medicine name, dosage, frequency, and duration.

View Dose: Check the next scheduled dose time.

Mark Dose Taken: Record a dose as taken and calculate the next time slot.

Update Prescription/Medical Status: Change the status to active, inactive, or completed.

View Details: See a comprehensive summary of a specific medicine.

Calculate Medicine Usage: Determine the total quantity of medicine required for the treatment period.
  
#OOP Concepts Applie

Encapsulation - The Medicine class uses private fields (`name`, `dose`, `notes`, and `reminderTimes`) with public
getters and setters. This protects data and ensures values are accessed and modified through controlled methods.

Inheritance - The class ConsoleReminder inherits from the abstract class `Reminder`. It reuses and extends the reminder framework provided by the parent class.

Polymorphism - The `ReminderScheduler` schedules reminders using the superclass `Reminder`, but the actual object is a `ConsoleReminder`. Overridden `notifyUser()` defines how the reminder appears on the console.

Abstraction - The `Reminder` abstract class hides implementation details by requiring subclasses to implement
`notifyUser()`. Only essential behavior (scheduling reminders) is exposed.

#Example Output

Main menu
<img width="272" height="226" alt="image" src="https://github.com/user-attachments/assets/433f7c54-951a-4caf-86c7-c61cf93c3ceb" />

Add Prescription
<img width="491" height="402" alt="image" src="https://github.com/user-attachments/assets/e95c09cd-96c4-4204-a8e9-b12e226420ce" />

#GUI Output
<img width="1369" height="719" alt="image" src="https://github.com/user-attachments/assets/53090a33-2a91-4d88-9851-e655a82637d2" />

<img width="1366" height="728" alt="image" src="https://github.com/user-attachments/assets/ec582ffc-b66a-4b21-ad76-312f99d3e5b7" />

<img width="1366" height="728" alt="image" src="https://github.com/user-attachments/assets/52cefac9-df5a-4060-95e5-0b83527e2f47" />

<img width="1366" height="722" alt="image" src="https://github.com/user-attachments/assets/0661a9f5-7ae4-469e-9953-a090e07a885c" />

<img width="1366" height="712" alt="image" src="https://github.com/user-attachments/assets/280a5e18-0dad-4837-a12e-b39b00e24a03" />

<img width="1177" height="723" alt="image" src="https://github.com/user-attachments/assets/dec3733e-03c6-4fbc-a8ef-65068452c609" />

#Author and Acknowledgement
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

Future Enhancements
The current version works well, but several improvements can make the system more powerful:
1. Save Data to File- Allow storing medicines and reminders permanently.
2. Load Data on Startup- Automatically load previously saved medicines.
3. Different Notification Types- Add SMS, email, or pop-up notifications through more
Reminder subclasses.
4. Medicine History Tracking- Log when reminders are triggered and whether the user took the
medicine.
5. Graphical User Interface (GUI) - Replace the console with a simple window-based interface.
6. User Login System-Protect sensitive medical information
