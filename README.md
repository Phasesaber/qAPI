# qAPI
Using qAPI, you can query any SQL server you want! 

##Initializing
This is how you set up (*get the *`Connection`* for*) each SQL databse using the API.

###MySQL
To use MySQL, you need to create an instance of the MySQL class.
```java
MySQL sql = new MySQL("host.name", "port", "database", "user", "pass");
Connection c = sql.openConnection();
```

##Using the SQL Databases
The first thing you want to do is get a `Statement` object from the `Connection`.
```java
Statement statement = c.createStatement();
```
To query, simply execute query and go through the results.
```java
ResultSet r = statement.executeQuery"SQL code here");
r.next(); //Iterate through results
```
To upload information, execute an update with what you want to upload.
```java
statement.executeUpdate("SQL code here");
```
