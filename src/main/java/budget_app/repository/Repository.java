package budget_app.repository;

// services package
// inside the services package will be the core logic of the application.
// In here you'll find all the methods that calculate all the budgets/savings/goals etc.
// These methods will be called by methods from within the controllers package, as well as
// other method from within the services package.

import java.sql.*;
import java.util.Scanner;

public class Repository {
    static String sqlStatement; // example sql statement:  "select * from mybudgetdb.users";
    static String tableName;
    static Statement statement;
    static ResultSet resultSet;

    public static void main(String[] args) {
        returnUsersTable();
//        createGoal();
//        returnGoalsTable();

    }


    public static String executeSQLStatement() {
        Scanner scanner = new Scanner(System.in); // starts scanner
        System.out.print("Enter sql statement: ");  // gives user a prompt
        sqlStatement = scanner.nextLine(); // user input is set to equal sqlstatement
        return sqlStatement;
    }

    public static String askUserWhichTableToRetrieve() {

        printOutDatabaseTables();  // print out available tables in db

        Scanner scanner = new Scanner(System.in); // starts scanner
        System.out.print("Enter table to retrieve values: ");  // gives user a prompt
        tableName = scanner.nextLine(); // user input is set to equal sqlstatement

        return tableName;

    }

    public static void printOutDatabaseTables() {
        Connection connection = null;
        statement = null;
        resultSet = null;


        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Setup the connection with the DB
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybudgetdb", "root", "fdal87439KJIOD@#$^"); // working connection string


            // Statements allow us to issue SQL queries to the database
            statement = connection.createStatement();
            // Execute the query on the Statement, getting a ResultSet in return
            resultSet = statement.executeQuery("show tables;" ); //"select * from mybudgetdb.users"


            // loop through the result set while there are more records
            while (resultSet.next()) {

                while(resultSet.next()) {
                    System.out.print(resultSet.getString(1));
                    System.out.println();
                }

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

    public static void returnUsersTable() {
        Connection connection = null;
        statement = null;
        resultSet = null;


        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Setup the connection with the DB
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybudgetdb", "root", "fdal87439KJIOD@#$^"); // working connection string


            // Statements allow us to issue SQL queries to the database
            statement = connection.createStatement();
            // Execute the query on the Statement, getting a ResultSet in return
            resultSet = statement.executeQuery("select * from mybudgetdb.users"); //"select * from mybudgetdb.users"


            // loop through the result set while there are more records
            while (resultSet.next()) {

                // get the id, name and units fields from the result set and assign them to local variables
                int id = resultSet.getInt("user_id");
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

    public static void returnGoalsTable(){
        Connection connection = null;
        statement = null;
        resultSet = null;


        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Setup the connection with the DB
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybudgetdb", "root", "fdal87439KJIOD@#$^"); // working connection string


            // Statements allow us to issue SQL queries to the database
            statement = connection.createStatement();
            // Execute the query on the Statement, getting a ResultSet in return
            resultSet = statement.executeQuery("select * from mybudgetdb.goals"); //"select * from mybudgetdb.users"


            // loop through the result set while there are more records
            while (resultSet.next()) {

                // get the id, name and units fields from the result set and assign them to local variables
                int id = resultSet.getInt("goal_id");
                String name = resultSet.getString("goal_name");
                int targetAmount = resultSet.getInt("target_amount");
                int currentAmount = resultSet.getInt("current_amount");
                int monthlyContribution = resultSet.getInt("monthly_contribution");



                // print out the result
                System.out.println( name + " target amount is " + targetAmount
                        + ", current amount is  " + currentAmount + ", monthly contribution is " + monthlyContribution );
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

    public static void returnSavingsTable(){
        Connection connection = null;
        statement = null;
        resultSet = null;


        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Setup the connection with the DB
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybudgetdb", "root", "fdal87439KJIOD@#$^"); // working connection string


            // Statements allow us to issue SQL queries to the database
            statement = connection.createStatement();
            // Execute the query on the Statement, getting a ResultSet in return
            resultSet = statement.executeQuery("select * from mybudgetdb.savings"); //"select * from mybudgetdb.users"


            // loop through the result set while there are more records
            while (resultSet.next()) {

                // get the id, name and units fields from the result set and assign them to local variables
                int id = resultSet.getInt("savings_id");
                String name = resultSet.getString("savings_name");
                int targetAmount = resultSet.getInt("target_amount");
                int currentAmount = resultSet.getInt("current_amount");



                // print out the result
                System.out.println( name + " target amount is " + targetAmount
                        + ", current amount is  " + currentAmount);
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

    public static void returnBudgetTable(){
        Connection connection = null;
        statement = null;
        resultSet = null;


        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Setup the connection with the DB
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybudgetdb", "root", "fdal87439KJIOD@#$^"); // working connection string


            // Statements allow us to issue SQL queries to the database
            statement = connection.createStatement();
            // Execute the query on the Statement, getting a ResultSet in return
            resultSet = statement.executeQuery("select * from mybudgetdb.savings"); //"select * from mybudgetdb.users"


            // loop through the result set while there are more records
            while (resultSet.next()) {

                // get the id, name and units fields from the result set and assign them to local variables
                int id = resultSet.getInt("savings_id");
                String name = resultSet.getString("savings_name");
                int targetAmount = resultSet.getInt("target_amount");
                int currentAmount = resultSet.getInt("current_amount");



                // print out the result
                System.out.println( name + " target amount is " + targetAmount
                        + ", current amount is  " + currentAmount);
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

    public static void updateGoalsTable(){
        Connection connection = null;
        statement = null;
        resultSet = null;


        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Setup the connection with the DB
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybudgetdb", "root", "fdal87439KJIOD@#$^"); // working connection string


            // Statements allow us to issue SQL queries to the database
            statement = connection.createStatement();
            // Execute the query on the Statement, getting a ResultSet in return
            int updateCount = statement.executeUpdate("UPDATE goals SET target_amount = 2600 WHERE account_type = 'Road Trip'");

            System.out.println("Updated test_value successfully : " + updateCount );

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
//                resultSet.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createGoal(){
        Connection connection = null;
        statement = null;
        resultSet = null;


        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Setup the connection with the DB
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybudgetdb", "root", "fdal87439KJIOD@#$^"); // working connection string


            // Statements allow us to issue SQL queries to the database
            statement = connection.createStatement();
            // Execute the query on the Statement, getting a ResultSet in return
            int updateCount = statement.executeUpdate("insert into goals (goal_name, target_amount, current_amount, monthly_contribution) values ('Road Trip', 500, 250, 50);");

            System.out.println("Updated test_value successfully : " + updateCount );

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
//                resultSet.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
