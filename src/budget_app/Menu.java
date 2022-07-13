package budget_app;

// controller package
// inside the controllers package will be all classes that interface with the user and that print out menus etc.

import budget_app.models.MonthlyBudget;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
        mainMenu();
//        MonthlyBudget budget = new MonthlyBudget();
//        budget.enterBudgetInfo();

//        //account balances menu
//        System.out.println("1) Select account");
//        System.out.println("2) return to main menu");
//
//        //Overview stats menu
//        System.out.println("1) Select a specific stat");
//        System.out.println("2) return to main menu");
//
//        //customize budget menu
//        System.out.println("1) add/update/delete income?");
//        System.out.println("2) add/update/delete expense?");
//        System.out.println("2) return to main menu");
//
//        //run custom report menu
//        System.out.println("1) Select a custom report");
//        System.out.println("2) return to main menu");

    }

    public static void mainMenu(){
        Integer menuSelection = 0;
        boolean wasAMenuNumberEntered = false;
        Integer[] numbers = {1,2,3,4,5};
        List<Integer> list = Arrays.asList(numbers);

        while(!list.contains(menuSelection)) {
            Scanner userinput = new Scanner(System.in);
            System.out.println("Welcome the Budgeting App");
            System.out.println("Please select your menu number below to proceed:");
            System.out.println("1) View account balances");
            System.out.println("2) View Overview stats");
            System.out.println("3) Customize Budget (add/update/delete income & expenses)");
            System.out.println("4) Run Custom Reports");
            System.out.println("5) Exit");
            menuSelection = userinput.nextInt();


            if (menuSelection == 1) {
                userAccountMenu();
            }
            if (menuSelection == 2) {
                overviewStatsMenu();
            }
            if (menuSelection == 3) {
                customizeBudgetMenu();
            }
            if (menuSelection == 4) {
                customReportsMenu();
            }
            if (menuSelection == 5) {
                exit();
            }

        }
    }

    public static Integer userAccountMenu(){
        System.out.println("show user accounts table");
        System.out.println("user , checking total , savings total, goal total");
        System.out.println("Henry , 2300 , 10000, 1500");
        System.out.println("Sam , 200 , 15000, 100");
        return 1;
    }

    public static void overviewStatsMenu(){
        System.out.println("head to View Overview stats menu");
    }

    public static void customizeBudgetMenu(){
        Integer menuSelection = 0;
        boolean wasAMenuNumberEntered = false;
        Integer[] numbers = {1,2,3,4,5};
        List<Integer> list = Arrays.asList(numbers);

        System.out.println("head to Customize Budget menu");
        Scanner userinput1 = new Scanner(System.in);
        System.out.println("Customize Budget menu");
        System.out.println("1) update budget");
        System.out.println("2) View Overview stats");
        System.out.println("3) Customize Budget (add/update/delete income & expenses)");
        System.out.println("4) Run Custom Reports");
        System.out.println("5) Exit");
        menuSelection = userinput1.nextInt();

        if (menuSelection == 1) {
            MonthlyBudget budget = new MonthlyBudget();
            budget.enterBudgetInfo();
        }
    }

    public static void customReportsMenu(){
        System.out.println("head to Run Custom Reports menu");
    }

    public static void exit(){
        System.out.println("exit code");
    }


}
