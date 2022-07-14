package budget_app;

import budget_app.services.BudgetCriticalInformationService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BudgetApp {
    private static BudgetCriticalInformationService budget = new BudgetCriticalInformationService();
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
                    accountsMenu();
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
                    mainMenu();
                }

            }
        }

        public static void accountsMenu(){
            System.out.println("show user's accounts table");
            System.out.println("Henry");

            //menu prompt select
            Scanner userInput1 = new Scanner(System.in);
            System.out.println("1)select checking account");
            System.out.println("2)select savings account");
            System.out.println("2)select goal account");
            System.out.println("5)return to main menu");
            Integer menuSelection = userInput1.nextInt();

            if (menuSelection == 1) {
                System.out.println("Henry checking 2300");

                Scanner userInput2 = new Scanner(System.in);
                System.out.println("1) enter '1' see amount possible to place into savings");
                Integer menuSelection1 = userInput2.nextInt();

                if (menuSelection1 == 1) {
                    System.out.println(" display amount able to place into savings");
                }

                System.out.println("return to accounts menu? Enter 'y' or 'n'.");
                if(yesOrNoPrompt()) {
                    accountsMenu();
                }
                System.out.println("user did not want to return to accounts menu. Returning to main menu.");
                mainMenu();

            }if (menuSelection == 2) {
                System.out.println("Henry savings 15000");

                Scanner userInput2 = new Scanner(System.in);
                System.out.println("1) enter '1' see amount possible to place into checking");
                Integer menuSelection1 = userInput2.nextInt();

                if (menuSelection1 == 1) {
                    System.out.println(" display amount able to place into checking");
                }

                System.out.println("return to accounts menu? Enter 'y' or 'n'.");
                if(yesOrNoPrompt()) {
                    accountsMenu();
                }
                System.out.println("user did not want to return to accounts menu. Returning to main menu.");
                mainMenu();

            }
            if (menuSelection == 3) {
                System.out.println("Henry road trip goal 1500");

                Scanner userInput2 = new Scanner(System.in);
                System.out.println("1) enter '1' see amount possible to place into goal");
                Integer menuSelection1 = userInput2.nextInt();

                if (menuSelection1 == 1) {
                    System.out.println(" display amount able to place into goal");
                }

                System.out.println("return to accounts menu? Enter 'y' or 'n'.");
                if(yesOrNoPrompt()) {
                    accountsMenu();
                }
                System.out.println("user did not want to return to accounts menu. Returning to main menu.");
                mainMenu();

            }
            if (menuSelection == 5) {
                mainMenu();
            }
        }

        public static void overviewStatsMenu(){
            System.out.println("head to View Overview stats menu");

            Scanner userInput1 = new Scanner(System.in);
            System.out.println("1)view account balances");
            System.out.println("2)view amount that can be put into savings now");
            System.out.println("3)view upcoming payment dates and amounts");
            System.out.println("4) return to main menu");
            Integer menuSelection = userInput1.nextInt();

            if (menuSelection == 1) {
                System.out.println("Henry , checking 2300 ,savings 10000, road trip goal 1500");

                System.out.println("return to overviewStats menu? Enter 'y' or 'n'.");
                if(yesOrNoPrompt()) {
                    overviewStatsMenu();
                }
                System.out.println("user did not want to return to accounts menu. Returning to main menu.");
                mainMenu();
            }
            if (menuSelection == 2) {
                System.out.println(" display amount able to place into savings");

                System.out.println("return to overviewStats menu? Enter 'y' or 'n'.");
                if(yesOrNoPrompt()) {
                    overviewStatsMenu();
                }
                System.out.println("user did not want to return to accounts menu. Returning to main menu.");
                mainMenu();
            }
            if (menuSelection == 3) {
                System.out.println("display upcoming payments and amounts");

                System.out.println("return to overviewStats menu? Enter 'y' or 'n'.");
                if(yesOrNoPrompt()) {
                    overviewStatsMenu();
                }
                System.out.println("user did not want to return to accounts menu. Returning to main menu.");
                mainMenu();
            }
            if (menuSelection == 4) {
                mainMenu();
            }

            }


        public static void customizeBudgetMenu(){
            Integer menuSelection = 0;
            boolean wasAMenuNumberEntered = false;
            Integer[] numbers = {1,2,3,4,5};
            List<Integer> list = Arrays.asList(numbers);

            Scanner userInput1 = new Scanner(System.in);
            System.out.println("Customize Budget menu");
            System.out.println("1) update budget critical information");
            System.out.println("2) add an expense to budget list");
            System.out.println("3) delete expenses");
            System.out.println("4) print out budget critical information list");
            System.out.println("5) Exit");
            menuSelection = userInput1.nextInt();

            if (menuSelection == 1) {
                budget.enterBudgetInfo();
                System.out.println();
            }
            if (menuSelection == 2) {
                budget.addExpenseNameToBudgetList();
                System.out.println();
                customizeBudgetMenu();
            }
            if (menuSelection == 3) {
                budget.removeExpenseFromBudgetList();
                System.out.println();
            }
            if (menuSelection == 4) {
                budget.budgetAndExpenseListCheck();
                System.out.println();
                customizeBudgetMenu();
            }
            if (menuSelection == 5) {
                System.out.println("returning to main menu");
                mainMenu();
            }
            else{
                System.out.println("please enter a menu option between 1 and 5");
                customizeBudgetMenu();
            }

        }

        public static void customReportsMenu(){
            System.out.println("head to Run Custom Reports menu");
        }


        public static void exit(){
            System.out.println("exit code");
        }

    public static boolean yesOrNoPrompt(){
        Scanner userInput1 = new Scanner(System.in);
        String answer = userInput1.nextLine();
        while( !answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
            System.out.println("please enter 'y' or 'n'. Try again.");
            answer = userInput1.nextLine();
        }
        if (answer.equalsIgnoreCase("n")) {
            return false;
        } else {
            return true;
        }
    }

}
