

DROP DATABASE IF EXISTS `GroceryStore`;
CREATE DATABASE IF NOT EXISTS `GroceryStore`;
USE `Grocery Store`;

-- database schemas


-- Inventory(ItemId, Name, Description, DepartmentId, DistributorId, CurrentPrice, InventoryCount)
CREATE TABLE Inventory( 
  ItemId           INT  NOT NULL, 
  Name             VARCHAR(15) NOT NULL, 
  Description      VARCHAR(20)  NOT NULL, 
  DepartmentId     INT NOT NULL,
  DistributorId    INT NOT NULL,
  CurrentPrice     INT NOT NULL,
  InventoryCount   INT   );


-- Employee(EmployeeId, Name, Phone, Address, DoB, HireDate, Position, DepartmentId, Salary)
CREATE TABLE Employee( 
  EmployeeId  INT  NOT NULL, 
  Name        VARCHAR (15)  NOT NULL, 
  Phone       VARCHAR   NOT NULL, 
  Address     VARCHAR (20) 	NOT NULL ,
  DoB         Date   NOT NULL, 
  HireDate    Date NOT NULL,
  Position    VARCHAR (5) NOT NULL,
  DepartmentId INT NOT NULL ,
  Salary       INT );


  -- Customer(CustomerId, Name, Phone, Address, DoB, CustomerSince, RewardPoints)
CREATE TABLE Customer( 
  CustomerId    INT  NOT NULL, 
  Name          VARCHAR (10)    NOT NULL, 
  Phone         VARCHAR   NOT NULL, 
  Address       VARCHAR(20) 	NOT NULL ,
  DoB           Date  NOT NULL,
  CustomerSince Date   NOT NULL  
  RewardPoints INT  );


-- Department(DepartmentId, Name)
CREATE TABLE Department ( 
  DepartmentId  INT  NOT NULL, 
  Name   VARCHAR (10)  NOT NULL );


-- Distributor(DistributorId, Name, Phone, Address, PrimaryContactName)
CREATE TABLE Distributor( 
  DistributorId          INT  NOT NULL, 
  Name                     VARCHAR (10)    NOT NULL, 
  Phone                    VARCHAR   NOT NULL, 
  Address                  VARCHAR (20)   NOT NULL ,
  PrimaryContactName        VARCHAR (20) NOT NULL );

-- Purchase(PurchaseId, EmployeeId, CustomerId, ItemId, CostPerUnit, Quantity, TotalCost)
CREATE TABLE Purchase( 
  PurchaseId          INT  NOT NULL, 
  EmployeeId          INT    NOT NULL, 
  CustomerId          INT NOT NULL, 
  ItemId              INT  NOT NULL ,
  CostPerUnit        INT NOT NULL;
  Quantity           INT NOT NULL; 
  TotalCost          INT NOT NULL ) ;



-- Insert statments

-- INSERT INTO product VALUES Inventory ();



-- INSERT INTO product VALUES Employee ();



-- INSERT INTO product VALUES Customer ();



-- INSERT INTO product VALUES Department ();



-- INSERT INTO product VALUES Distributor ();



-- INSERT INTO product VALUES Purchase ();





