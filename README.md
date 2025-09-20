📌 Problem Statement

Managing student leave requests manually is inefficient and error-prone. Teachers struggle to track handwritten letters, and students lack visibility into their request status. A digital system is needed to streamline this process.

📌 Proposed Solution

A Java console-based Student Leave Management System (SLMS) with JDBC and SQL integration.



Teacher Login
- Add students to the database  
- View and manage leave requests  
- Approve/Reject requests  
- View student leave history and total leave count  


- Submit leave request (reason, start date, number of days)  
- View request status (Pending/Approved/Rejected)  
- Track total leaves taken  

📌 Workflow

1. Teacher creates student accounts  
2. Student logs in and submits leave request  
3. Teacher reviews and approves/rejects  
4. System updates leave count and notifies student  


📌 Java OOP Concepts Used

- Encapsulation: Private fields with public getters/setters  
- Inheritance: User base class → Student, Teacher subclasses  
- Polymorphism: Overridden login() method  
- Abstraction: LeaveActions interface with methods like applyLeave(), approveLeave() 
- Association/Aggregation:  
  - Teacher ↔ Students  
  - Student ↔ LeaveRequests  


🛠 Tech Stack

- Java (console app)  
- SQL (MySQL or SQLite)  
- JDBC  
- IDE: VS Code / IntelliJ / Eclipse  
- Git for version control  



👤 Author

Name: Logavarshhni S  
Email: logavarshhni.s2024@sece.ac.in  

