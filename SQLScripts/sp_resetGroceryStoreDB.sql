CREATE DEFINER=`group10`@`%` PROCEDURE `resetGroceryStoreDB`()
BEGIN

SET FOREIGN_KEY_CHECKS = 0;

-- Customer(CustomerId, Name, Phone, Address, DoB, CustomerSince, RewardPoints)
DROP TABLE IF EXISTS Customer;
CREATE TABLE Customer(
  CustomerId    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Name          VARCHAR(60) NOT NULL,
  Phone         CHAR(10) NOT NULL,
  Address       VARCHAR(120) NOT NULL ,
  DoB           Date NOT NULL,
  CustomerSince Date NOT NULL,
  RewardPoints  INT DEFAULT 0 CHECK(RewardPoints >= 0)
);


-- Department(DepartmentId, Name)
DROP TABLE IF EXISTS Department;
CREATE TABLE Department (
  DepartmentId  INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Name          VARCHAR(60) NOT NULL
);


-- Distributor(DistributorId, Name, Phone, Address, PrimaryContactName)
DROP TABLE IF EXISTS Distributor;
CREATE TABLE Distributor(
  DistributorId       INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Name                VARCHAR (60) NOT NULL,
  Phone               CHAR(10) NOT NULL,
  Address             VARCHAR(120) NOT NULL,
  PrimaryContactName  VARCHAR(60) NOT NULL
);


-- Inventory(ItemId, Name, Description, DepartmentId, DistributorId, CurrentPrice, InventoryCount)
DROP TABLE IF EXISTS Inventory;
CREATE TABLE Inventory(
  ItemId           INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Name             VARCHAR(60) NOT NULL,
  Description      VARCHAR(255) NOT NULL,
  DepartmentId     INT NOT NULL,
  DistributorId    INT NOT NULL,
  CurrentPrice     DECIMAL(7,2) DEFAULT 0 CHECK(CurrentPrice > 0),
  InventoryCount   INT UNSIGNED DEFAULT 0 CHECK(InventoryCount >= 0),
  FOREIGN KEY (DepartmentId) REFERENCES Department(DepartmentId)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
  FOREIGN KEY (DistributorId) REFERENCES Distributor(DistributorId)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
);


-- Employee(EmployeeId, Name, Phone, Address, DoB, HireDate, Position, DepartmentId, Salary)
DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee(
  EmployeeId    	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  Name          	VARCHAR(60) NOT NULL,
  Phone         	CHAR(10) NOT NULL,
  Address       	VARCHAR(120)	NOT NULL ,
  DoB           	Date NOT NULL,
  HireDate      	Date NOT NULL,
  Position      	VARCHAR(60) NOT NULL,
  DepartmentId  	INT NOT NULL,
  Salary        	DECIMAL(8,2) CHECK(Salary > 0),
  IsActiveEmployee  BOOLEAN NOT NULL DEFAULT FALSE,
  FOREIGN KEY (DepartmentId) REFERENCES Department(DepartmentId)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
);


-- Purchase(PurchaseId, EmployeeId, CustomerId, ItemId, CostPerUnit, Quantity, TotalCost)
DROP TABLE IF EXISTS Purchase;
CREATE TABLE Purchase(
  PurchaseId    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  EmployeeId    INT NOT NULL,
  CustomerId    INT NOT NULL,
  ItemId        INT NOT NULL,
  CostPerUnit   DECIMAL(7,2) NOT NULL CHECK(CostPerUnit > 0),
  Quantity      INT NOT NULL CHECK(Quantity > 0),
  TotalCost     DECIMAL(8,2) NOT NULL CHECK(TotalCost > 0),
  FOREIGN KEY (EmployeeId) REFERENCES Employee(EmployeeId)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
  FOREIGN KEY (CustomerId) REFERENCES Customer(CustomerId)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
  FOREIGN KEY (ItemId) REFERENCES Inventory(ItemId)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
);


-- Insert statments

-- Insert 10 rows into Customer
INSERT INTO Customer VALUES
  (NULL, "Tony Stark", "2535550001", "Stark Tower, New York, USA - APT 1", "1966-03-15", "1990-11-17", 1600000),
  (NULL, "Steve Rogers", "2535550002", "Stark Tower, New York, USA - APT 2", "1919-01-03", "1991-03-16", 500790),
  (NULL, "Thor Odinson", "2535550003", "Stark Tower, New York, USA - APT 3", "1019-10-31", "1993-10-27", 40099),
  (NULL, "Bruce Banner", "2535550004", "Stark Tower, New York, USA - APT 4", "1972-09-24", "1999-09-27", 98302),
  (NULL, "T'Challa", "2535550005", "Stark Tower, New York, USA - APT 5", "1987-05-20", "2005-01-12", 50313),
  (NULL, "Natasha Romanoff", "2535550006", "Stark Tower, New York, USA - APT 6", "1985-01-25", "2007-12-11", 1238721),
  (NULL, "Peter Parker", "2535550007", "Stark Tower, New York, USA - APT 7", "2003-11-04", "2011-01-24", 1209),
  (NULL, "Scott Lang", "2535550008", "Stark Tower, New York, USA - APT 8", "1991-06-16", "2013-11-07", 607832),
  (NULL, "Stephen Strange", "2535550009", "Stark Tower, New York, USA - APT 9", "1970-07-19", "2017-11-19", 1995),
  (NULL, "Carol Danvers", "2535550010", "Stark Tower, New York, USA - APT 10", "1989-07-01", "2018-07-30", 70508);


-- Insert 10 rows into Department
INSERT INTO Department VALUES
  (NULL, "General"),
  (NULL, "Produce"),
  (NULL, "Bakery"),
  (NULL, "Meat"),
  (NULL, "Seafood"),
  (NULL, "Frozen"),
  (NULL, "Liquor"),
  (NULL, "Pharmacy"),
  (NULL, "Floral"),
  (NULL, "Deli");


-- Insert 10 rows into Distributor
INSERT INTO Distributor VALUES
  (NULL, "General Goods Supplier", "2065550001", "1328 Market St, Tacoma, WA 98402 - APT 501", "Luke Skywalker"),
  (NULL, "Fresh Farms Produce", "2065550002", "1328 Market St, Tacoma, WA 98402 - APT 502", "Darth Vader"),
  (NULL, "Best Breads Bakery", "2065550003", "1328 Market St, Tacoma, WA 98402 - APT 503", "Obiwan Kenobi"),
  (NULL, "MeatLords Meats", "2065550004", "1328 Market St, Tacoma, WA 98402 - APT 504", "Leia Organa"),
  (NULL, "Splashin Seas Seafood", "2065550005", "1328 Market St, Tacoma, WA 98402 - APT 505", "Han Solo"),
  (NULL, "OpenSky Produce", "2065550006", "1328 Market St, Tacoma, WA 98402 - APT 506", "Darth Sideous"),
  (NULL, "PolarIce Frozen Distribution", "2065550007", "1328 Market St, Tacoma, WA 98402 - APT 507", "Chewbacca"),
  (NULL, "Meds2You Delivery", "2065550008", "1328 Market St, Tacoma, WA 98402 - APT 508", "Yoda"),
  (NULL, "Sunny Day Flowers", "2065550009", "1328 Market St, Tacoma, WA 98402 - APT 509", "R2-D2"),
  (NULL, "Good Foods Done Quick Delivery", "2065550010", "1328 Market St, Tacoma, WA 98402 - APT 510", "C3-PO");


-- Insert 10 rows into Inventory
INSERT INTO Inventory VALUES
  (NULL, "Banana", "Banana on the bunch ripe from Columbia", 2, 6, 0.69, 320),
  (NULL, "Apple", "Granny Smith from Washington", 2, 2, 0.30, 1200),
  (NULL, "Oat Bread", "Bread made with over 5 different oats", 3, 3, 1.20, 60),
  (NULL, "Salmon", "Pink Chinook Salmon from Washington", 5, 5, 7.89, 15),
  (NULL, "Ibuprophen", "100 count 50mg", 8, 8, 4.89, 20),
  (NULL, "Frozen Mac and Cheese Meal", "Family Size", 6, 7, 9.56, 9),
  (NULL, "Ice Cream", "Chocolate Vanilla Swirl", 6, 7, 10.07, 17),
  (NULL, "Grilled Cheese Sandwich", "Deli fresh sandwich", 10, 10, 5.59, 10),
  (NULL, "Rose", "Red", 9, 9, 1.22, 30),
  (NULL, "Magnet", "Seattle Fridge Magnet", 1, 1, 0.99, 5);


-- Insert 10 rows into Employee
INSERT INTO Employee VALUES
  (NULL, "Bilbo Baggins", "4255550001", "1301 1st Ave, Seattle, WA 98101 - APT 101", "1969-05-28", "2008-07-23", "Cashier", 1, 49820, TRUE),
  (NULL, "Frodo Baggins", "4255550002", "1301 1st Ave, Seattle, WA 98101 - APT 102", "1970-02-19", "2009-07-28", "Cashier", 1, 49820, TRUE),
  (NULL, "Gandalf", "4255550003", "1301 1st Ave, Seattle, WA 98101 - APT 103", "1973-02-08", "2009-08-20", "Courtesy Clerk", 1, 31720, FALSE), 
  (NULL, "Samwise Gamgee", "4255550004", "1301 1st Ave, Seattle, WA 98101 - APT 104", "1983-05-10", "2011-01-06", "Manager", 1, 99000, TRUE),
  (NULL, "Gollum", "4255550005", "1301 1st Ave, Seattle, WA 98101 - APT 105", "1986-03-25", "2011-01-10", "Produce Clerk", 2, 31720, TRUE),
  (NULL, "Aragorn", "4255550006", "1301 1st Ave, Seattle, WA 98101 - APT 106", "1987-12-12", "2012-03-29", "Pharmacist", 8, 120000, TRUE),
  (NULL, "Legolas", "4255550007", "1301 1st Ave, Seattle, WA 98101 - APT 107", "1988-08-08", "2012-10-31", "Deli Clerk", 10, 31720, TRUE),
  (NULL, "Saruman", "4255550008", "1301 1st Ave, Seattle, WA 98101 - APT 108", "1991-07-12", "2014-02-07", "Floral Clerk", 9, 31720, TRUE),
  (NULL, "Sauron", "4255550009", "1301 1st Ave, Seattle, WA 98101 - APT 109", "1994-02-09", "2017-05-23", "Bakery Clerk", 3, 31720, FALSE),
  (NULL, "Gimli", "4255550010", "1301 1st Ave, Seattle, WA 98101 - APT 110", "1995-06-02", "2018-10-01", "Frozen Clerk", 6, 31720, TRUE);


-- Insert 10 rows into Purchase
INSERT INTO Purchase VALUES
  (NULL, 1, 1, 1, 0.69, 5, 3.45),
  (NULL, 1, 1, 2, 0.30, 3, 0.90),
  (NULL, 1, 1, 8, 5.59, 1, 5.59),
  (NULL, 1, 2, 3, 1.20, 3, 3.60),
  (NULL, 1, 2, 6, 9.56, 1, 9.56),
  (NULL, 1, 3, 6, 9.56, 1, 9.56),
  (NULL, 2, 6, 10, 0.99, 1, 0.99),
  (NULL, 2, 7, 9, 1.22, 10, 12.20),
  (NULL, 2, 8, 5, 4.89, 1, 4.89),
  (NULL, 2, 9, 8, 5.59, 1, 5.59);
  
  SET FOREIGN_KEY_CHECKS = 1;
  
END