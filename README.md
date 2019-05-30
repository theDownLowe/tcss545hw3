# Grocery Store Project for the Database and Design Course TCSS 545

TO DO:
- [ ] A .pdf file with the following
    - [ ] Application Proposal containing the following
        - [ ] Description of the db application
        - [ ] Functionalities being implemented (At least 3 different)
        - [ ] Any Extra functionalities/artifacts
        - [ ] A note about implementing using AWS cloud
    - [ ] ER Model of the Application
    - [ ] Schema of the database normalized to 4NF. Detailed steps of the normalization
- [ ] A .sql file with the following
    - [ ] The script that implements the normalized DB schema (declares tables, establishes keys, RI/other constraints)
        - [ ] Add stored procedures and functions
            - [ ] Function to count # of employees
            - [ ] Function to count # of customers
            - [ ] Funciton to count # of distributors
            - [ ] Function to count # of distinct inventory items
            - [ ] Function to count # of total inventory items
            - [ ] Function to count # of goods sold
            - [ ] Function to count sum of cost of goods bought
        - [ ] Add necessary CHECKS
            - [ ] Check Inventory.InventoryCount >= 0
            - [ ] Check Inventory.CurrentPrice > 0
        - [ ] Add FK On Update/Delete
            - [ ] No Action for both update and delete on all tables
    - [X] A script entering 10 records into each table (initial data set)
- [ ] Well documented source code
- [ ] Well written readme on how to run/install the application (this file)
- [ ] Test Cases (A file explaining?)
- [ ] A powerpoint with the following:
    - [ ] Application Description (1-2 slides)
    - [ ] Raw Data and back end design (2-3 slides)
    - [ ] Implemented Functionalities (1-2 slides)
    - [ ] Demonstration of at least 3 functionalities during demo
    - [ ] Conclusion (1 slide)
    - [ ] References (1 slide)
    
# Capabilities
* Ability to Add new Customers into the database
* Ability to Update the phone number or address of customers
* Ability to Add rewards points for a particular customer after each purchase (1 point per cent spent)
* Ability to Subtract rewards points from a customer (representing points being used)
* Ability to Add a Distributor
* Ability to Update a Distributors Phone/Address/Primary Contact Name
* Ability to Add new Inventory items to the store, either by increasing the count of pre-existing items or by creating new items in the database
* Ability to Subtract Inventory Count of an Item, representing the item was sold/damaged
* Ability to Update the cost of pre-existing items in the database
* Ability to Update an Employee's Phone/Address/Position/Department/Salary/ActiveStatus
* Ability to Add a new Employee into the database
* Ability to Add a new Purchase record into the database 
    
# How to Install and Run
## Installation

## Running
