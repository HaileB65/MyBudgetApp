package budget_app;

import java.sql.*;

class Repository {
        public static void main(String[] args)  {
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;


            try {
                // This will load the MySQL driver, each DB has its own driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Setup the connection with the DB
                connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mybudgetdb","root","fdal87439KJIOD@#$^"); // working connection string


                // Statements allow us to issue SQL queries to the database
                statement = connection.createStatement();
                // Execute the query on the Statement, getting a ResultSet in return
                resultSet = statement.executeQuery("select * from mybudgetdb.users");


                // loop through the result set while there are more records
                while (resultSet.next()) {
                    // get the id, name and units fields from the result set and assign them to local variables
                    int id = resultSet.getInt("id");
                    String fname = resultSet.getString("first_name");
                    String lname = resultSet.getString("last_name");
                    String email = resultSet.getString("email");


                    // print out the result
                            System.out.println("User ID: " + id + " is " + fname + " " + lname + " email is: " + email);
                }
            } catch (SQLException exc) {
                System.out.println("Exception occurred");
                exc.printStackTrace();
            } catch (ClassNotFoundException e) {
                System.out.println("Exception occurred - driver not found on classpath");
                e.printStackTrace();
            } finally {
                try {
                    // close all JDBC elements
                    statement.close();
                    resultSet.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
