### Java SQLite CRUD System

This project is a lightweight database management tool built with Java and SQLite. It focuses on implementing complete CRUD functionality for a small college-style database, including operations for adding, viewing, updating, and deleting records. The program connects directly to a local SQLite database file and uses prepared statements to handle all SQL interactions in a structured and reliable way.

The code is organized into separate classes for each data type to keep the structure clear as the program grows. I used DB Browser alongside the Java console output to verify that every operation worked correctly. Seeing the database update in real time helped me understand how each method interacted with the underlying college.db file.

--- 

### How the Program Works:

The project includes classes that represent the different entities stored in the database, such as faculty members, courses, and students. The CollegeDB class manages the connection to the SQLite file and contains all the SQL statements for inserting new data, reading existing records, updating information, and removing entries. The Main class runs these operations and displays the results in the console.

The database itself is stored in the included college.db file. As the program runs, this file updates based on the CRUD operations performed, and any changes made manually through DB Browser will also appear the next time the program is executed.

### How to Run:

I developed and ran this project in VS Code using the Java Extension Pack, which provides all the tools needed for Java development. After opening the project folder, VS Code automatically detected the pom.xml file and loaded the Maven dependencies. To run the application, I opened the Main.java file inside the org.example package and used the Run button in VS Code. The program connects to the college.db file automatically and prints the results of each operation in the console. Any updates made directly in DB Browser also appear when the program runs again, as long as the database file stays inside the project folder.

---

### Notes:

This project gave me practical experience working with Java and SQL together in a small backend system. I learned how to structure CRUD operations using prepared statements, how to manage connections to a local SQLite database, and how to trace problems by checking both the code output and the database file. Working through the logic step by step helped me better understand how data flows in a real application, and it encouraged me to write cleaner, more organized backend code.
