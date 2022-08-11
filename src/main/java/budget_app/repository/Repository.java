package budget_app.repository;

// services package
// inside the services package will be the core logic of the application.
// In here you'll find all the methods that calculate all the budgets/savings/goals etc.
// These methods will be called by methods from within the controllers package, as well as
// other method from within the services package.

import budget_app.models.Checking;
import budget_app.models.Goal;
import budget_app.models.Savings;
import budget_app.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Repository {
    static String sqlStatement; // example sql statement:  "select * from mybudgetdb.users";
    static String tableName;
    static Statement statement;
    static ResultSet resultSet;

//    public static void runAnySQLStatement(){
//        Connection connection = null;
//        statement = null;
//        resultSet = null;
//
//
//        try {
//            // This will load the MySQL driver, each DB has its own driver
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            // Setup the connection with the DB
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybudgetdb", "root", "fdal87439KJIOD@#$^"); // working connection string
//
//
//            // Statements allow us to issue SQL queries to the database
//            statement = connection.createStatement();
//            // Execute the query on the Statement, getting a ResultSet in return
//            resultSet = statement.executeQuery("" ); //"select * from mybudgetdb.users"
//
//
//            // loop through the result set while there are more records
//            while (resultSet.next()) {
//
//                while(resultSet.next()) {
//                    System.out.print(resultSet.getString(1));
//                    System.out.println();
//                }
//
//            }
//        } catch (SQLException exc) {
//            System.out.println("Exception occurred");
//            exc.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            System.out.println("Exception occurred - driver not found on classpath");
//            e.printStackTrace();
//        } finally {
//            try {
//                // close all JDBC elements
//                statement.close();
//                resultSet.close();
//                connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }


    public void createNewGoal(){
        Goal newGoal = new Goal();

        Scanner userInput1 = new Scanner(System.in);
        System.out.println("Enter new goal name:");
        String newGoalName = userInput1.nextLine();

        System.out.println("Enter goal current amount:");
        Integer goalCurrentAmount = userInput1.nextInt();

        System.out.println("Enter goal target amount:");
        Integer goalTargetAmount = userInput1.nextInt();

        System.out.println("Monthly contribution towards goal:");
        Integer goalMonthlyContribution = userInput1.nextInt();

        newGoal.setName(newGoalName);
        newGoal.setCurrentAmount(goalCurrentAmount);
        newGoal.setTargetAmount(goalTargetAmount);
        newGoal.setMonthlyContribution(goalMonthlyContribution);
        User.goalList.add(newGoal);
        User.goalNamesList.add(newGoalName);

        System.out.println(newGoalName + " goal created");
    }

    public void editGoal(){
        System.out.println("Available goals to edit");
        for (Goal goal : User.goalList) {
            System.out.println(goal.getName());
        }
        System.out.println();

        Scanner userInput2 = new Scanner(System.in);
        System.out.println("Enter Goal name to edit");
        String goalToEdit = userInput2.nextLine();
        while(!User.goalNamesList.contains(goalToEdit)){
            System.out.println("please enter a goal name that already exists");
            System.out.println("List of existing goals:");
            for (Goal goal : User.goalList) {
                System.out.println(goal.getName());
            }
            goalToEdit = userInput2.nextLine();
            if(User.goalNamesList.contains(goalToEdit)){
                break;
            }

//            System.out.println("return to Edit Goal menu? Enter 'y' or 'n'.");
//            if(BudgetApp.yesOrNoPrompt()) {
//                BudgetApp.editGoalsMenu();
//            }
        }

        Scanner userInput1 = new Scanner(System.in);
        System.out.println("Enter updated goal name:");
        String updatedGoalName = userInput1.nextLine();
        System.out.println("Enter goal current amount:");
        Integer updatedGoalCurrentAmount = userInput1.nextInt();
        System.out.println("Enter goal target amount:");
        Integer updatedGoalTargetAmount = userInput1.nextInt();
        System.out.println("Monthly contribution towards goal:");
        Integer updatedGoalMonthlyContribution = userInput1.nextInt();

//        if(goalToEdit == BudgetApp.user.goal.getName()) {
//            BudgetApp.user.goal.setName(updatedGoalName);
//            BudgetApp.user.goal.setCurrentAmount(updatedGoalCurrentAmount);
//            BudgetApp.user.goal.setTargetAmount(updatedGoalTargetAmount);
//            BudgetApp.user.goal.setMonthlyContribution(updatedGoalMonthlyContribution);
//        }
//        if(goalToEdit == BudgetApp.user.goal2.getName()) {
//            BudgetApp.user.goal2.setName(updatedGoalName);
//            BudgetApp.user.goal2.setCurrentAmount(updatedGoalCurrentAmount);
//            BudgetApp.user.goal2.setTargetAmount(updatedGoalTargetAmount);
//            BudgetApp.user.goal2.setMonthlyContribution(updatedGoalMonthlyContribution);
//        }
//        if(goalToEdit == BudgetApp.user.goal2.getName()) {
//            // how to set values to a goal that a user created?
//        }

        System.out.println("goal edit complete");
    }

    public void printGoalNamesList(){
        System.out.println("printing out goal list");
//        System.out.println(BudgetApp.user.goalNamesList);

    }

    public static String askUserToEnterSQLStatement() {
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

// print out db tables
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

    public static void printOutGoalsTable(){
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

    public static ArrayList<Checking> returnAllChecking(){
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
            resultSet = statement.executeQuery("select * from mybudgetdb.checking"); //"select * from mybudgetdb.users"

            ArrayList<Checking> checkingList = new ArrayList<>(); // created list of checking objects

            // loop through the result set while there are more records
            while (resultSet.next()) {
                Checking checking1 = new Checking();

                checking1.setId(resultSet.getInt("checking_id")); // set id from db to checking1 instance
                checking1.setCustomerName(resultSet.getString("customer_name"));
                checking1.setVenderName(resultSet.getString("vender_name"));
                checking1.setAmount(resultSet.getInt("amount"));

                checkingList.add(checking1); // add checking1 to array list
            }

            return checkingList; // return checkingList


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

        return null;
    }

    public static ArrayList<Savings> returnAllSavings(){
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

            ArrayList<Savings> savingsList = new ArrayList<>(); // created list of checking objects

            // loop through the result set while there are more records
            while (resultSet.next()) {
                Savings savings1 = new Savings();

                savings1.setId(resultSet.getInt("savings_id")); // set id from db to checking1 instance
                savings1.setName(resultSet.getString("savings_name"));
                savings1.setTargetAmount(resultSet.getInt("target_amount"));
                savings1.setCurrentAmount(resultSet.getInt("current_amount"));

                savingsList.add(savings1); // add checking1 to array list
            }

            return savingsList; // return checkingList


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

        return null;
    }

    public static ArrayList<Goal> returnAllGoals(){
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

            ArrayList<Goal> goalsList = new ArrayList<>(); // created list of goal objects

            // loop through the result set while there are more records
            while (resultSet.next()) {
                Goal goal1 = new Goal();

                goal1.setId(resultSet.getInt("goal_id")); // set id from db to checking1 instance
                goal1.setName(resultSet.getString("goal_name"));
                goal1.setTargetAmount(resultSet.getInt("target_amount"));
                goal1.setCurrentAmount(resultSet.getInt("current_amount"));
                goal1.setMonthlyContribution(resultSet.getInt("monthly_contribution"));

                goalsList.add(goal1); // add goal1 to array list
            }

            return goalsList; // return goalList


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

        return null;
    }

    public static ArrayList<User> returnAllUsers(){
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

            ArrayList<User> usersList = new ArrayList<>(); // created list of user objects

            // loop through the result set while there are more records
            while (resultSet.next()) {
                User user1 = new User();

                user1.setId(resultSet.getInt("user_id")); // set id from db to checking1 instance
                user1.setFirstName(resultSet.getString("first_name"));
                user1.setLastName(resultSet.getString("last_name"));
                user1.setEmail(resultSet.getString("email"));

                usersList.add(user1); // add user1 to array list
            }

            return usersList; // return userList


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

        return null;
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

    public static void returnCheckingAccountSum(){
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
            resultSet = statement.executeQuery("SELECT SUM(amount) FROM checking;"); //"select * from mybudgetdb.users"


            // loop through the result set while there are more records
            while (resultSet.next()) {

                // get the id, name and units fields from the result set and assign them to local variables
                int amount = resultSet.getInt("amount");



                // print out the result
                System.out.println("Checking account balance = " + amount);
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
    } // having trouble returning the sum of checking account

// update db tables
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


// create row in table
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

    public static void createChecking(){
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
            int updateCount = statement.executeUpdate("insert into checking (customer_name, vender_name, amount) values ('Miguel', 'AutoZone', 50);");
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

    public static void addUser(User user){
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
            int updateCount = statement.executeUpdate("insert into users (first_name, last_name, email) values ('"+user.getFirstName()+"', '"+user.getLastName()+"', '"+user.getEmail()+"');");
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
