create database [Personal Budgeting];

-- DDL Queries to create database 
CREATE TABLE Users (
    userId INT PRIMARY KEY identity(0,1),
    username VARCHAR(50) not null,
    email VARCHAR(100) UNIQUE not null,
    password VARCHAR(255) not null,
    phone_number VARCHAR(15),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Income (
    income_id INT PRIMARY KEY,
    user_id INT,	
    source VARCHAR(100),
    amount DECIMAL(10,2),
    date DATE,
    FOREIGN KEY (user_id) REFERENCES Users(userId)
);

CREATE TABLE Expenses (
    expense_id INT PRIMARY KEY IDENTITY(1,1),
    user_id INT NOT NULL,
    category VARCHAR(255) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(userId) -- Adjust table/column if needed
);


drop table Expenses


CREATE TABLE Budgets (
    budget_id INT PRIMARY KEY,
    user_id INT,
    category VARCHAR(100),
    amount DECIMAL(10,2),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(userId)
);

CREATE TABLE Reminders (
    reminder_id INT PRIMARY KEY,
    user_id INT,
    title VARCHAR(255),
    reminder_date DATETIME,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    notified bit DEFAULT 0,
    FOREIGN KEY (user_id) REFERENCES Users(userId)
);



select * from Users
