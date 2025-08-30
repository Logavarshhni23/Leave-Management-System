📌 Problem Statement

In a college class, managing student leave requests is a challenge. Currently, students have to submit handwritten leave letters to their class teacher, which are hard to track, easy to lose, and difficult to maintain for future reference. Teachers also find it time-consuming to review leave requests, approve/reject them, and calculate the number of leave days taken by each student.

There is a need for a console-based Student Leave Management System (SLMS) where:

1. The class teacher maintains a database of students.

2. Students can log in and submit leave requests with reason, start date, and number of days.

3. Teacher can view all pending leave requests in one place, approve/reject them, and the decision is updated in the database.

4. The system automatically tracks how many leave days each student has taken.

5. Students can view the status of their requests (Approved/Rejected/Pending).

This reduces paperwork, improves transparency, and saves time.

📌 Proposed Solution

The system will be a Java console application with JDBC + SQL database integration.

Features:

* Teacher Login

    *Add students to the class database.

    *View all pending leave requests.

    *Approve/Reject requests.

    *View student leave history and total leave count.

* Student Login

    *Submit new leave request (reason + date + number of days).

    *View leave request status (pending, approved, rejected).

    *View total leaves taken.

Database Tables (simplified)

 *Students

    StudentID, Name, Password, TotalLeaves

 *LeaveRequests

    RequestID, StudentID, Reason, Days, Status (Pending/Approved/Rejected)

Workflow:

*Teacher creates student accounts.

*Student logs in and submits leave request.

*Teacher logs in → sees pending requests → approves/rejects.

*System updates leave counts and notifies student.

📌 Java OOP Concepts Used

✅ Encapsulation

Student, Teacher, and LeaveRequest will be separate classes with private fields and public getter/setter methods.

Example: LeaveRequest has private fields reason, days, status, and can be accessed only through methods.

✅ Inheritance

Base class: User (common attributes: username, password, role).

Subclasses: Student and Teacher.

This avoids duplication and improves code reusability.

✅ Polymorphism

Overriding: login() method works differently for Student and Teacher.

Example: When a teacher logs in, they see pending requests; when a student logs in, they see their own requests.

✅ Abstraction

Interfaces like LeaveActions for methods: applyLeave(), approveLeave(), rejectLeave().

Hides implementation details, shows only necessary operations.

✅ Association / Aggregation

A Teacher is associated with many Students.

A Student can have many LeaveRequests.


AUTHOR
Name:Logavarshhni S
gmail:logavarshhnis2007@gmail.com
