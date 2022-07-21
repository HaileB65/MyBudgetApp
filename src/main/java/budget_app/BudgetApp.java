package budget_app;

import budget_app.models.Goal;
import budget_app.models.User;
import budget_app.services.BudgetService;
import budget_app.services.GoalService;
import budget_app.services.MathLogic;
import budget_app.services.ReportService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class BudgetApp {

    public static void main(String[] args) {
        SpringApplication.run(BudgetApp.class);
    }
}

//public class BudgetApp {
//    public static User user = new User();
//    public static BudgetService budgetService = new BudgetService();
//    public static GoalService goalService = new GoalService();
//
//
//    public static void main(String[] args) {
//        user.checking.setAmount(2500);
//        user.savings.setCurrentAmount(1500);
//        user.goal.setCurrentAmount(1500);
//        mainMenu();
//
//    }
//
//    public static void mainMenu() {
//        Integer menuSelection = 0;
//        boolean wasAMenuNumberEntered = false;
//        Integer[] numbers = {1, 2, 3, 4, 5};
//        List<Integer> list = Arrays.asList(numbers);
//
//        while (!list.contains(menuSelection)) {
//            Scanner userInput = new Scanner(System.in);
//            System.out.println("Welcome the Budgeting App");
//            System.out.println("Please select your menu number below to proceed:");
//            System.out.println("1) View account balances");
//            System.out.println("2) View Overview stats");
//            System.out.println("3) Customize Budget (add/update/delete income & expenses)");
//            System.out.println("4) Run Custom Reports");
//            System.out.println("5) Edit Goals");
//            System.out.println("6) Exit");
//            menuSelection = userInput.nextInt();
//
//
//            if (menuSelection == 1) {
//                accountsMenu();
//            }
//            if (menuSelection == 2) {
//                overviewStatsMenu();
//            }
//            if (menuSelection == 3) {
//                customizeBudgetMenu();
//            }
//            if (menuSelection == 4) {
//                customReportsMenu();
//            }
//            if (menuSelection == 5) {
//                editGoalsMenu();
//            }
//            if (menuSelection == 6) {
//                exit();
//            }
//
//        }
//    }
//
//    public static void accountsMenu() {
//        System.out.println("show user's accounts table");
//        System.out.println("Henry");
//
//        //menu prompt select
//        Scanner userInput1 = new Scanner(System.in);
//        System.out.println("1)select checking account");
//        System.out.println("2)select savings account");
//        System.out.println("3)select goal account");
//        System.out.println("4)return to main menu");
//        Integer menuSelection = userInput1.nextInt();
//
//        if (menuSelection == 1) {
//            System.out.println("Henry checking");
//            System.out.println(user.checking.getAmount());
//
//            Scanner userInput2 = new Scanner(System.in);
//            System.out.println("1) enter '1' see amount possible to place into savings");
//            Integer menuSelection1 = userInput2.nextInt();
//
//            if (menuSelection1 == 1) {
//                System.out.println("amount able to place into savings from checking account: " + user.checking.getAmount());
//            }
//
//            System.out.println("return to accounts menu? Enter 'y' or 'n'.");
//            if (yesOrNoPrompt()) {
//                accountsMenu();
//            }
//            System.out.println("user did not want to return to accounts menu. Returning to main menu.");
//            System.out.println();
//            mainMenu();
//
//        }
//        if (menuSelection == 2) {
//            System.out.println("Henry savings");
//            System.out.println(user.savings.getCurrentAmount());
//
//            Scanner userInput2 = new Scanner(System.in);
//            System.out.println("1) enter '1' see amount possible to place into checking");
//            Integer menuSelection1 = userInput2.nextInt();
//
//            if (menuSelection1 == 1) {
//                System.out.println("amount able to place into checking from savings: " + user.savings.getCurrentAmount());
//            }
//
//            System.out.println("return to accounts menu? Enter 'y' or 'n'.");
//            if (yesOrNoPrompt()) {
//                accountsMenu();
//            }
//            System.out.println("user did not want to return to accounts menu. Returning to main menu.");
//            System.out.println();
//            mainMenu();
//
//        }
//        if (menuSelection == 3) {
//            System.out.println("Henry road trip goal");
//            System.out.println(user.goal.getCurrentAmount());
//
//            Scanner userInput2 = new Scanner(System.in);
//            System.out.println("1) enter '1' see amount possible to place into goal");
//            Integer menuSelection1 = userInput2.nextInt();
//
//            if (menuSelection1 == 1) {
//                System.out.println("amount able to place into goal from checking account: " + user.checking.getAmount());
//            }
//
//            System.out.println("return to accounts menu? Enter 'y' or 'n'.");
//            if (yesOrNoPrompt()) {
//                accountsMenu();
//            }
//            System.out.println("user did not want to return to accounts menu. Returning to main menu.");
//            System.out.println();
//            mainMenu();
//
//        }
//        if (menuSelection == 4) {
//            System.out.println();
//            mainMenu();
//        } else {
//            System.out.println("please enter a menu option between 1 and 5");
//            System.out.println();
//            accountsMenu();
//        }
//    }
//
//    public static void overviewStatsMenu() {
//        System.out.println("head to View Overview stats menu");
//
//        Scanner userInput1 = new Scanner(System.in);
//        System.out.println("1)view account balances");
//        System.out.println("2)view amount that can be put into savings now");
//        System.out.println("3)view upcoming payment dates and amounts");
//        System.out.println("4)return to main menu");
//        Integer menuSelection = userInput1.nextInt();
//
//        if (menuSelection == 1) {
//            System.out.println("Accounts totals: ");
//            System.out.println("checking: " + user.checking.getAmount() + ",savings: " + user.savings.getCurrentAmount() + ", road trip goal: "
//                    + user.goal.getCurrentAmount());
//
//            System.out.println("return to overviewStats menu? Enter 'y' or 'n'.");
//            if (yesOrNoPrompt()) {
//                overviewStatsMenu();
//            }
//            System.out.println("user did not want to return to accounts menu. Returning to main menu.");
//            System.out.println();
//            mainMenu();
//        }
//        if (menuSelection == 2) {
//            System.out.println("amount able to place into savings from checking account: " + user.checking.getAmount());
//
//            System.out.println("return to overviewStats menu? Enter 'y' or 'n'.");
//            if (yesOrNoPrompt()) {
//                overviewStatsMenu();
//            }
//            System.out.println("user did not want to return to accounts menu. Returning to main menu.");
//            System.out.println();
//            mainMenu();
//        }
//        if (menuSelection == 3) {
//            System.out.println("display upcoming payments and amounts");
//
//            System.out.println("return to overviewStats menu? Enter 'y' or 'n'.");
//            if (yesOrNoPrompt()) {
//                overviewStatsMenu();
//            }
//            System.out.println("user did not want to return to accounts menu. Returning to main menu.");
//            System.out.println();
//            mainMenu();
//        }
//        if (menuSelection == 4) {
//            mainMenu();
//        } else {
//            System.out.println("please enter a menu option between 1 and 4");
//            System.out.println();
//            overviewStatsMenu();
//        }
//
//    }
//
//    public static void customizeBudgetMenu() {
//        Integer menuSelection = 0;
//        boolean wasAMenuNumberEntered = false;
//        Integer[] numbers = {1, 2, 3, 4, 5};
//        List<Integer> list = Arrays.asList(numbers);
//
//        Scanner userInput1 = new Scanner(System.in);
//        System.out.println("Customize Budget menu");
//        System.out.println("1) update budget critical information");
//        System.out.println("2) add an expense to budget list");
//        System.out.println("3) delete expense from budget list");
//        System.out.println("4) print out budget critical information list");
//        System.out.println("5) Exit");
//        menuSelection = userInput1.nextInt();
//
//        if (menuSelection == 1) {
//            budgetService.enterBudgetInfo();
//            System.out.println();
//
//            System.out.println("return to Customize Budget menu? Enter 'y' or 'n'.");
//            if (yesOrNoPrompt()) {
//                customizeBudgetMenu();
//            }
//            System.out.println("user did not want to return to Customize Budget menu. Returning to main menu.");
//            System.out.println();
//            mainMenu();
//        }
//        if (menuSelection == 2) {
//            budgetService.addExpenseNameToBudgetList();
//            System.out.println();
//            customizeBudgetMenu();
//        }
//        if (menuSelection == 3) {
//            budgetService.removeExpenseFromBudgetList();
//            System.out.println();
//        }
//        if (menuSelection == 4) {
//            budgetService.printOutBudgetAndExpenseList();
//            System.out.println();
//            customizeBudgetMenu();
//        }
//        if (menuSelection == 5) {
//            System.out.println("returning to main menu");
//            System.out.println();
//            mainMenu();
//        } else {
//            System.out.println("please enter a menu option between 1 and 5");
//            System.out.println();
//            customizeBudgetMenu();
//        }
//
//    }
//
//    public static void customReportsMenu() {
//        System.out.println("Custom Reports menu");
//        Scanner userInput1 = new Scanner(System.in);
//        System.out.println("1)Run future estimate report");
//        System.out.println("2)Run Debt Payment Calendar report");
//        System.out.println("3)Run Spending vs Saving over time report");
//        System.out.println("4)Run Comprehensive Financial Sanity Report");
//        System.out.println("5)Run Goals report");
//        System.out.println("6)return to main menu");
//        Integer menuSelection = userInput1.nextInt();
//
//        if (menuSelection == 1) {
//            ReportService.runFutureBalanceReport();
//
//            System.out.println("return to Custom Reports menu? Enter 'y' or 'n'.");
//            if (yesOrNoPrompt()) {
//                customReportsMenu();
//            }
//            System.out.println("user did not want to return to Custom Reports menu. Returning to main menu.");
//            System.out.println();
//            mainMenu();
//
//        }
//        if (menuSelection == 2) {
//            ReportService.runDebtPaymentCalendarReport();
//
//            System.out.println("return to Custom Reports menu? Enter 'y' or 'n'.");
//            if (yesOrNoPrompt()) {
//                customReportsMenu();
//            }
//            System.out.println("user did not want to return to Custom Reports menu. Returning to main menu.");
//            System.out.println();
//            mainMenu();
//
//        }
//        if (menuSelection == 3) {
//            ReportService.RunSpendingVsSavingOverTimeReport();
//
//            System.out.println("return to Custom Reports menu? Enter 'y' or 'n'.");
//            if (yesOrNoPrompt()) {
//                customReportsMenu();
//            }
//            System.out.println("user did not want to return to Custom Reports menu. Returning to main menu.");
//            System.out.println();
//            mainMenu();
//
//        }
//        if (menuSelection == 4) {
//            ReportService.runComprehensiveFinancialSanityReport();
//
//            System.out.println("return to Custom Reports menu? Enter 'y' or 'n'.");
//            if (yesOrNoPrompt()) {
//                customReportsMenu();
//            }
//            System.out.println("user did not want to return to Custom Reports menu. Returning to main menu.");
//            System.out.println();
//            mainMenu();
//
//        }
//        if (menuSelection == 5) {
//            ReportService.runGoalsReport();
//
//            System.out.println("return to Custom Reports menu? Enter 'y' or 'n'.");
//            if (yesOrNoPrompt()) {
//                customReportsMenu();
//            }
//            System.out.println("user did not want to return to Custom Reports menu. Returning to main menu.");
//            System.out.println();
//            mainMenu();
//
//        }
//        if (menuSelection == 6) {
//            mainMenu();
//        } else {
//            System.out.println("please enter a menu option between 1 and 6");
//            System.out.println();
//            customReportsMenu();
//        }
//    }
//
//    public static void editGoalsMenu() {
//        System.out.println("Edit Goals menu");
//        Scanner userInput1 = new Scanner(System.in);
//        System.out.println("1)Edit Goal");
//        System.out.println("2)Create New goal");
//        System.out.println("3)Print out existing goals");
//        System.out.println("3)return to main menu");
//        Integer menuSelection = userInput1.nextInt();
//
//        if (menuSelection == 1) {
//            goalService.editGoal();
//
//            System.out.println("return to Edit Goal menu? Enter 'y' or 'n'.");
//            if (yesOrNoPrompt()) {
//                editGoalsMenu();
//            }
//            System.out.println("user did not want to return to Edit Goal menu. Returning to main menu.");
//            System.out.println();
//            mainMenu();
//
//        }
//        if (menuSelection == 2) {
//            goalService.createNewGoal();
//
//            System.out.println("return to Edit Goal menu? Enter 'y' or 'n'.");
//            if (yesOrNoPrompt()) {
//                editGoalsMenu();
//            }
//            System.out.println("user did not want to return to Edit Goal menu. Returning to main menu.");
//            System.out.println();
//            mainMenu();
//        }
//        if (menuSelection == 3) {
//            goalService.printGoalNamesList();
//        }
//        if (menuSelection == 4) {
//            mainMenu();
//        } else {
//            System.out.println("please enter a menu option between 1 and 3");
//            System.out.println();
//            editGoalsMenu();
//        }
//
//    }
//
//
//    public static void exit() {
//        System.out.println("Exiting budget app");
//        System.exit(0);
//    }
//
//    public static boolean yesOrNoPrompt() {
//        Scanner userInput1 = new Scanner(System.in);
//        String answer = userInput1.nextLine();
//        while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
//            System.out.println("please enter 'y' or 'n'. Try again.");
//            answer = userInput1.nextLine();
//        }
//        if (answer.equalsIgnoreCase("n")) {
//            return false;
//        } else {
//            return true;
//        }
//    }
//
//}
