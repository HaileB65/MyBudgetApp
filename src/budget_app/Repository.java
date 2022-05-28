package budget_app;

import java.sql.*;
import java.util.Scanner;

class Repository {
    static String sqlStatement; // example sql statement:  "select * from mybudgetdb.users";
    static String tableName;
    static Statement statement;
    static ResultSet resultSet;

    public static void main(String[] args) {

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


    public static String executeSQLStatement() {
        Scanner scanner = new Scanner(System.in); // starts scanner
        System.out.print("Enter sql statement: ");  // gives user a prompt
        sqlStatement = scanner.nextLine(); // user input is set to equal sqlstatement
        return sqlStatement;
    }

    public static String askUserWhichTableToRetrieve() {

        printOutDatabaseTables();  // print out available tables in db

        // code to return full table values.
        Scanner scanner = new Scanner(System.in); // starts scanner
        System.out.print("Enter table to retrieve values: ");  // gives user a prompt
        tableName = scanner.nextLine(); // user input is set to equal sqlstatement

        sqlStatement = "select * from mybudgetdb." + tableName;  // "select * from mybudgetdb.users"

        return sqlStatement;

    }

    private static void printOutDatabaseTables() {
        //        resultSet = statement.executeQuery("show tables");
//
//        System.out.println("Tables in the current database: ");
//        while(resultSet.next()) {
//            System.out.print(resultSet.getString(1));
//            System.out.println();
//        }
    }

    public static void returnUsersTable() {

//        resultSet = statement.executeQuery("select * from mybudgetdb.users");
//
//
//        // loop through the result set while there are more records
//        while (resultSet.next()) {
//
//            // get the id, name and units fields from the result set and assign them to local variables
//            int id = resultSet.getInt("id");
//            String fname = resultSet.getString("first_name");
//            String lname = resultSet.getString("last_name");
//            String email = resultSet.getString("email");
//
//
//            // print out the result
//            System.out.println("User ID: " + id + " is " + fname + " " + lname + " email is: " + email);
//        }
    }

    public static void returnTransactionTable() throws SQLException {

        resultSet = statement.executeQuery("select * from mybudgetdb.transactions");


        // loop through the result set while there are more records
        while (resultSet.next()) {

            // get the id, name and units fields from the result set and assign them to local variables
            int date = resultSet.getInt("created_at");
            int amount = resultSet.getInt("amount");
            String userName = resultSet.getString("user_name");
            String venderName = resultSet.getString("vender_name");


            // print out the result
            System.out.println("On" + date + "user " + userName + " payed " + amount + " at " + venderName);
//        }
        }
    }


        public static void insertTableValue(){
            // code to insert into values into users table. ask user which table they want to insert into and what columns are available
            // columns first_name, last_name, email
            // columns amount, source, weekly interval
        }


    }
