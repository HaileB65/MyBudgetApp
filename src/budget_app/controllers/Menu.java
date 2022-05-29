package budget_app.controllers;

// controller package
// inside the controllers package will be all classes that interface with the user and that print out menus etc.

public class Menu {

    // menu
    // give user list of available accounts
    // ask user which account they want to enter or if they want to create a new account or
    // get a report
    // enter account
    // add/remove transaction from account
    // ask for name of new account and create new account for user
    // ask user which report they want
    // print out report

    public static void main(String[] args) {
        System.out.println("Welcome to Your Budgeting App");
        System.out.println("Please select your menu options below to proceed:");
        System.out.println("1) View account balances");
        System.out.println("2) View Overview stats");
        System.out.println("3) Customize Budget (add/update/delete income & expenses)");
        System.out.println("4) Run custom Reports");
        System.out.println("5) Exit");


        //account balances menu
        System.out.println("1) Select account");
        System.out.println("2) return to main menu");

        //Overview stats menu
        System.out.println("1) Select a specific stat");
        System.out.println("2) return to main menu");

        //customize budget menu
        System.out.println("1) add/update/delete income?");
        System.out.println("2) add/update/delete expense?");
        System.out.println("2) return to main menu");

        //run custom report menu
        System.out.println("1) Select a custom report");
        System.out.println("2) return to main menu");

    }
}
