

DROP DATABASE IF EXISTS `GroceryStore`;
CREATE DATABASE IF NOT EXISTS `GroceryStore`;
USE `Grocery Store`;

-- database schemas


-- Customer(CustomerId, Name, Phone, Address, DoB, CustomerSince, RewardPoints)
CREATE TABLE Customer( 
  CustomerId    INT NOT NULL PRIMARY KEY, 
  Name          VARCHAR(60) NOT NULL, 
  Phone         CHAR(10) NOT NULL, 
  Address       VARCHAR(120) NOT NULL ,
  DoB           Date NOT NULL,
  CustomerSince Date NOT NULL,  
  RewardPoints  INT DEFAULT 0,
);


-- Department(DepartmentId, Name)
CREATE TABLE Department ( 
  DepartmentId  INT NOT NULL PRIMARY KEY, 
  Name          VARCHAR(60) NOT NULL 
);


-- Distributor(DistributorId, Name, Phone, Address, PrimaryContactName)
CREATE TABLE Distributor( 
  DistributorId       INT NOT NULL PRIMARY KEY, 
  Name                VARCHAR (60) NOT NULL, 
  Phone               CHAR(10) NOT NULL, 
  Address             VARCHAR(120) NOT NULL,
  PrimaryContactName  VARCHAR(60) NOT NULL
);


-- Inventory(ItemId, Name, Description, DepartmentId, DistributorId, CurrentPrice, InventoryCount)
CREATE TABLE Inventory( 
  ItemId           INT  NOT NULL PRIMARY KEY, 
  Name             VARCHAR(60) NOT NULL, 
  Description      VARCHAR(255) NOT NULL, 
  DepartmentId     INT NOT NULL,
  DistributorId    INT NOT NULL,
  CurrentPrice     DECIMAL(7,2) DEFAULT 0,
  InventoryCount   INT DEFAULT 0,
  FOREIGN KEY (DepartmentId) REFERENCES Department(DepartmentId),
  FOREIGN KEY (DistributorId) REFERENCES Distributor(DistributorId)
);


-- Employee(EmployeeId, Name, Phone, Address, DoB, HireDate, Position, DepartmentId, Salary)
CREATE TABLE Employee( 
  EmployeeId    INT  NOT NULL PRIMARY KEY, 
  Name          VARCHAR(60) NOT NULL, 
  Phone         CHAR(10) NOT NULL, 
  Address       VARCHAR(120)	NOT NULL ,
  DoB           Date NOT NULL, 
  HireDate      Date NOT NULL,
  Position      VARCHAR(60) NOT NULL,
  DepartmentId  INT NOT NULL,
  Salary        DECIMAL(8,2),
  FOREIGN KEY (DepartmentId) REFERENCES Department(DepartmentId)
);


-- Purchase(PurchaseId, EmployeeId, CustomerId, ItemId, CostPerUnit, Quantity, TotalCost)
CREATE TABLE Purchase( 
  PurchaseId    INT NOT NULL PRIMARY KEY, 
  EmployeeId    INT NOT NULL, 
  CustomerId    INT NOT NULL, 
  ItemId        INT NOT NULL,
  CostPerUnit   DECIMAL(7,2) NOT NULL,
  Quantity      INT NOT NULL, 
  TotalCost     DECIMAL(8,2) NOT NULL,
  FOREIGN KEY (EmployeeId) REFERENCES Employee(EmployeeId),
  FOREIGN KEY (CustomerId) REFERENCES Customer(CustomerId),
  FOREIGN KEY (ItemId) REFERENCES Inventory(InventoryId)
);



-- Insert statments

-- INSERT INTO product VALUES Inventory ();



-- INSERT INTO product VALUES Employee ();



-- INSERT INTO product VALUES Customer ();



-- INSERT INTO product VALUES Department ();



-- INSERT INTO product VALUES Distributor ();



-- INSERT INTO product VALUES Purchase ();





