# Inventory
This is an inventory tracking web system.

OS: MacOS

Software:
1. DBeaver
2. IntelliJ IDEA 2021.2
3. MySQL 5.7.20
4. Java 1.8
5. apache-tomcat-9.0-1.56.tar.gz

Library:
All showed in inventory_tracking/web/WEB-INF/lib

Step:
1. Download the MySQL in computer and run the server. Download the apache-tomcat-9.0-1.56.tar.gz
2. Download the DBeaver to manage the MySQL. Create new connection and select MySQL. As for the Database Native in the 
configuration, enter your own MySQL's username and password(my username is 'root' and pw is '980416'). Besides, you 
also need to change the username and password to your own in inventory_tracking/src/bean/DBcon.java (which is 
used to connect to your database.)
3. After connecting to MySQL, use the SQL editor to execute the code in createtable.sql. It will create database named 
'inventory' and the table named 'inventory_info' and insert some data.
4. Open IDEA, click File/Project Structure --> set the SDK as Java 1.8 and add the library in 
inventory_tracking/web/WEB-INF/lib. 
5. Click Run/Edit Configurations --> add new configuration --> Tomcat server/local 
--> Set the server: Configure the Application server as apache-tomcat-9.0-1.56 --> Set the Deployment: Add an artifacts
6. Run the program and the website with the goods list of inventory will show up in the browser.
7. Click on the delete, the item in corresponding row will be deleted. 
8. Click on the Add Good can add a new goods information, including its name, type, supplier, count and price. When 
click the submit, it will check the validness of every input. Good Id cannot be modified. All the other input cannot be
null. Name, type and supplier cannot be all numbers. Count and price cannot be a string or a negative value. When the 
conditions are met, you can successfully add the product information.
9. Click on the goodId can edit the goods' info, including its name, type, supplier, count and price. When click the
submit, it will check the validness of every input (same as 8). When the conditions are met, you can successfully 
modify the product information.
10. Click on the Export Good to export csv file. You can change the file output path for your own need in 
inventory_tracking/src/bean/GoodDaoImp.java
