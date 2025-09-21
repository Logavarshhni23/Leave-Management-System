📌 **Problem Statement**

Managing student leave requests manually is inefficient and error-prone. Teachers struggle to track handwritten letters, and students lack visibility into their request status. A digital system is needed to streamline this process and ensure transparency.


📌 **Proposed Solution**

A Java console-based Student Leave Management System (SLMS) with JDBC and SQL integration.

**Teacher Role:**
- Add students to the database  
- View and manage leave requests  
- Approve or reject requests  
- View student leave history and total leave count  

**Student Role:**
- Submit leave request (reason, start date, number of days)  
- View request status (Pending / Approved / Rejected)  
- Track total leaves taken  


📌 **Workflow**

1. Teacher creates student accounts  
2. Student logs in and submits leave request  
3. Teacher reviews and approves/rejects  
4. System updates leave count and retains request history  
5. Student can view updated status anytime  


📌 **Java OOP Concepts Used**

- **Encapsulation**: Private fields with public getters/setters  
- **Inheritance**: `User` base class extended by `Student` and `Teacher`  
- **Polymorphism**: Overridden `showMenu()` method for role-specific logic  
- **Abstraction**: Service layer (`LeaveService`) hides DB operations  
- **Association/Aggregation**:  
  - Teacher ↔ Students  
  - Student ↔ LeaveRequests  


🛠 **Tech Stack**

- Java (console-based application)  
- SQL (MySQL database)  
- JDBC for database connectivity  
- IDE: VS Code / IntelliJ / Eclipse  
- Git for version control  


👤 Author

Name: Logavarshhni S  
Email: logavarshhni.s2024@sece.ac.in  

