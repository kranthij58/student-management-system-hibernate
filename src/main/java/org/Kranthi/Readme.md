# Student–Course Management System (Java + Hibernate)

A console-based Java application that demonstrates a **correct Many-to-Many relationship** between **Students** and **Courses** using **Hibernate ORM**.

This project focuses on **clean architecture**, **proper ORM design**, and **real Hibernate best practices**, not shortcuts.

---

## ✨ Features

* Add and manage **Courses** (one-time setup)
* Register **Students**
* Assign **multiple courses to a student** (Many-to-Many)
* Update student details
* Fetch students and courses
* Hibernate-managed **join table**
* Clean separation of responsibilities (Input / Manager / Data / Entity)

---

## 🧰 Tech Stack

* Java
* Hibernate (ORM)
* JPA Annotations
* MySQL / H2 (any relational database)

---

## 📂 Project Structure

```
org.Kranthi
│
├── Main.java
│

│── StudentManager.java
│── CourseManager.java

├── StudentDataManagement.java
│── CoursesDataManagement.java
│

│── Student.java
│── Course.java

│── StudentsDetailsCollection.java
│── CourseDetailsCollection.java

│── HibernateUtil.java

```

---

## 🗄️ Database Design

### Tables

* `students`
* `courses`
* `student_course` (join table)

### Relationship

```
Student  <---->  Course
      Many-to-Many
```

* **Student** is the **owning side**
* **Course** is the **inverse side**
* Join table is fully managed by Hibernate

---

## 🧠 Important Design Decisions

### ✔ Owning Side Controls the Relationship

* Only `Student.courses` updates the join table
* No manual updates required on `Course`

### ✔ Courses Must Exist First

* Courses are added once
* Students only reference existing courses

### ✔ No Primitive Foreign Keys

* Courses are entities, not `String` fields

### ✔ Single Shared Scanner

* Prevents multiple-input and buffer issues
* Avoids `System.in` conflicts

---

## ▶️ Execution Flow

1. Add courses (initial setup)
2. Add students
3. Assign courses to students
4. Fetch or update data

---

## ⚠️ Common Issues Solved

* `LazyInitializationException`
* Scanner double-input problem
* Incorrect Many-to-Many ownership
* Unnecessary merges on inverse side

---

## 🎯 Learning Outcomes

* Proper Many-to-Many mapping in Hibernate
* Understanding owning vs inverse side
* Handling lazy loading correctly
* Writing clean, layered Java code

---

## 🚧 Future Enhancements

* Menu-driven CLI
* Spring Boot conversion
* REST APIs
* DTO and validation layers

---

## 👨‍💻 Author

**Kranthi**
Learning Java backend and Hibernate through hands-on projects.
