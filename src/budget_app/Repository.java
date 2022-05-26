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

             /* Other examples include:
                 Class.forname("oracle.jdbc.driver.oracledriver");
                 Class.forName("org.postgresql.Driver");
                 Class.forName("mongodb.jdbc.mongodriver"); */


                // configure the "connection string" (below) with the following format
                // -------------------------------------
                // jdbc:/mysql://H.O.S.T:<PORT>/DATABASE
                // -------------------------------------
                // on our localhost we don't need the port ":3306", we will also
                // add the login credentials and one or more other arguments
                // within the connection String. Your username here is most
                // likely "root", unless you have already created
                // new database users. The default MySQL username is "root".


                // NOTE: depending on your version of MySQL, you may need to delete "&useSSL=false"
                // from the connection String below in order to connect to the database


//                String connectionString = "jdbc:mysql://localhost:3306/mybudgetdb?"  connection string
//                        + "user=root&password=fdal87439KJIOD@#$^";
//                String connectionString = "jdbc:mysql://root:fdal87439KJIOD@#$^@localhost:3306/mybudgetdb";
//                        + "user=root&password=fdal87439KJIOD@#$^";
//                        + "&useSSL=false&allowPublicKeyRetrieval=true";


                // Example connection String to remote MySQL instance:
                // "jdbc:mysql://178.34.21.99:3306/codingnomads?user=root&password=3tr0ngP@33W0rd"


                // Setup the connection with the DB
//                connection = DriverManager.getConnection(connectionString);
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
