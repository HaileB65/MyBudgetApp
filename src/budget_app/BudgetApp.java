package budget_app;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BudgetApp {

    public static void main(String[] args) {
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
                System.out.println("head to account balances menu");
//                return 1;
            }
            if (menuSelection == 2) {
                System.out.println("head to View Overview stats menu");
//                return 2;
            }
            if (menuSelection == 3) {
                System.out.println("head to Customize Budget menu");
//                return 3;
            }
            if (menuSelection == 4) {
                System.out.println("head to Run Custom Reports menu");
//                return 4;
            }
            if (menuSelection == 5) {
                System.out.println("exit code");
//                return 5;
            }

        }



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


    public Integer accountBalancesMenu(){
        Integer menuSelection = 0;
        boolean wasAMenuNumberEntered = false;

        Integer[] numbers = {1,2,3,4,5};
        List<Integer> list = Arrays.asList(numbers);

        while(!list.contains(menuSelection)) {
            Scanner userinput = new Scanner(System.in);
            System.out.println("Welcome the Budgeting App");
            System.out.println("Please select your menu number below to proceed:");
            System.out.println("1) Savings");
            System.out.println("2) Goals");
//            System.out.println("3) Customize Budget (add/update/delete income & expenses)");
//            System.out.println("4) Run Custom Reports");
//            System.out.println("5) Exit");
            menuSelection = userinput.nextInt();

            if (menuSelection == 1) {
                System.out.println("print out savings account info");
                return 1;
            }
            if (menuSelection == 2) {
                System.out.println("print out goals account info");
                return 2;
            }
//            if (menuSelection == 3) {
//                System.out.println("head to Customize Budget menu");
//                return 3;
//            }
//            if (menuSelection == 4) {
//                System.out.println("head to Run Custom Reports menu");
//                return 4;
//            }
//            if (menuSelection == 5) {
//                System.out.println("exit code");
//                return 5;
//            }

        }
        return 0;

    }
}
