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
        createBudget();
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

        printOutDataBaseTables();  // print out available tables in db

        Scanner scanner = new Scanner(System.in); // starts scanner
        System.out.print("Enter table to retrieve values: ");  // gives user a prompt
        tableName = scanner.nextLine(); // user input is set to equal sqlstatement

        return tableName;

    }

    public static void printOutDataBaseTables() {
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

    public static void printOutUsersTable() {
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

    public static void printOutSavingsTable(){
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

    public static void printOutBudget(){
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
            resultSet = statement.executeQuery("select * from mybudgetdb.budget"); //"select * from mybudgetdb.users"


            // loop through the result set while there are more records
            while (resultSet.next()) {

                // get the id, name and units fields from the result set and assign them to local variables
                int id = resultSet.getInt("budget_id");
                int monthlyBudget = resultSet.getInt("monthly_budget");
                int currentAmount = resultSet.getInt("current_amount");
                int expenses = resultSet.getInt("expenses");
                int monthlyIncome = resultSet.getInt("monthly_income");
                int oneTimePayment = resultSet.getInt("one_time_payment");
                int costOfRent = resultSet.getInt("cost_of_rent");
                int fixedDebtPayments = resultSet.getInt("fixed_debt_payments");
                int weeklyCostOfGroceries = resultSet.getInt("weekly_cost_of_groceries");
                int weeklyCostOfEatingOut = resultSet.getInt("weekly_cost_of_eating_out");
                int weeklyCostOfBeerWine = resultSet.getInt("weekly_cost_of_beer_wine");
                int healthcare = resultSet.getInt("healthcare");
                int childcare = resultSet.getInt("childcare");
                int carInsurance = resultSet.getInt("car_insurance");
                int vehicle = resultSet.getInt("vehicle");
                int gas = resultSet.getInt("gas");
                int HVAC = resultSet.getInt("HVAC");
                int phone = resultSet.getInt("phone");
                int tv = resultSet.getInt("tv");
                int travel = resultSet.getInt("travel");
                int otherUtilities = resultSet.getInt("other_utilities");


                // print out the result
                System.out.println("Budget critical info" + monthlyBudget +currentAmount + expenses + monthlyIncome + oneTimePayment
                + costOfRent + fixedDebtPayments + weeklyCostOfGroceries + weeklyCostOfEatingOut + weeklyCostOfBeerWine
                        + healthcare + childcare + carInsurance + vehicle + gas + HVAC + phone + tv + travel + otherUtilities);
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

    public static void createBudget(){
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
            int updateCount = statement.executeUpdate(
                    "insert into budget (monthly_budget, current_amount, expenses, monthly_income, one_time_payment, cost_of_rent, fixed_debt_payments, weekly_cost_of_groceries, weekly_cost_of_eating_out ,weekly_cost_of_beer_wine, healthcare, childcare, car_insurance, vehicle, gas, HVAC, phone, tv, travel, other_utilities) values (0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0);");

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
