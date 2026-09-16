Student Management System

A simple console-based Student management system developed in java to demonstrate the Object-oriented concepts like encapsulation, constructors etc.

Features
Add Student – Add the student to the system with id, name and marks.
View All Students – To view all the students added to the system with their marks and grade.
Search Student – To search for a student based on the id.
Update Marks – To update the marks of an existing student.
Delete Student – To delete an existing student based on the id.
Description
The grades for the marks scored by the students are calculated based on the below criteria.
Marks Range Grade
80 – 100 A
60 – 79 B
40 – 59 C
Below 40 Fail
The project is structured into two files as given below
StudentManagementSystem.java
├── class Student
│ ├── Fields – id, name, marks
│ ├── Constructor
│ ├── display()
│ └── getGrade()
│
└── class StudentManagementSystem
├── main()
├── addStudent()
├── viewStudents()
├── searchStudent()
├── updateMarks()
└── deleteStudent()
Prerequisites
Java jdk 8 or above
How to Compile and Run ?
Save the code in a file named as StudentManagementSystem.java
Open terminal and navigate to the directory where the file is saved.
Perform compilation
javac StudentManagementSystem.java
To start the application
java StudentManagementSystem
Usage
Once the application is started, you will see the below options on console.

===== STUDENT MANAGEMENT SYSTEM =====
1. Add Student
2. View All Students
3. Search Student	
4. Update Marks
5. Delete Student
6. Exit
Enter choice:
Choose the option based on what you want to do. The further instruction will be given on the console. The data entered will be stored in memory and will be available until the application is running.

Notes
The data is not stored in any file or database, hence it will be cleared once the application is closed.
There is basic validation for input values (like for integer inputs etc) but no check for duplicate id while adding a student, hence it can be possible to have two students with same id.
The project is created just for learning purpose and to demonstrate the OOPs concepts and Java Collections, hence no need to use it for any production purpose.
Possible enhancements
Make the data stored in a file or database so that it can be accessed next time when the application is started.
Check for duplicate student id while adding.
Sorting and Filtering the students based on grade or marks.
Build frontend using JavaFX/Swing or Web application for the same.
License

Free to use, modify and distribute for learning purpose.
