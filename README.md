# Java and MySQL manipulation with a GUI

This project focuses on manipulating a SQL database to complete the "final project" for the Programming III course at ECCI University.

## Prerequisites

    1. Java SDK 17 (recommended) [Adoptium OpenJDK](https://adoptium.net/).
    2. [MySQL Community Server](https://dev.mysql.com/downloads/mysql/).
    3. (Optional) [MySQL Workbench](https://dev.mysql.com/downloads/workbench/).
    4. (Optional) Use VS code Java's Pack

## Downloading

- clone the repository on your computer.

``` bash
git clone https://github.com/Khallavan/proyecto_CRUD_Java_GUI.git
```

- changes in the src/connection/DBConnect.java the password and user for your MySQL data base

```java
protected void connect() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/application?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8",
                "user_db", "password_sql_data_base");
    } catch (Exception e) {
        System.err.println("Error: " + e);
    }
}
```

- saves changes.
- execute the DB script file in MySQL.
- build the jar file with the extension.
- execute jar file inside the folder.
