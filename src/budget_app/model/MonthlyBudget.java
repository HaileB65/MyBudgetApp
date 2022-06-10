package budget_app.model;

import java.util.Scanner;

public class MonthlyBudget {
    int monthlyBudget;
    int currentAmount;
    int expenses;
    int count = 0;
    String itemName = null;

    int monthlyIncome;
    int oneTimePayment;
    int costOfRent;
    int fixedDebtPayments;
    int weeklyCostOfGroceries;
    int weeklyCostOfEatingOut;
    int numberOfTimesYouEatOut;
    int weeklyCostOfBeerWine;

    //monthly cost of
    int healthcare;
    int childcare;
    int carInsurance;
    int vehicle;
    int gas;
    int HVAC;
    int phone;
    int tv;
    int travel;
    int otherUtilities;


    int[] expensesList = {oneTimePayment, costOfRent,
    fixedDebtPayments, weeklyCostOfGroceries, weeklyCostOfEatingOut, weeklyCostOfBeerWine,
    healthcare, childcare, carInsurance, vehicle, gas, HVAC, phone, tv, travel, otherUtilities};

    String[] budgetCriticalInformationNameList = {"oneTimePayment", "costOfRent",
            "fixedDebtPayments", "weeklyCostOfGroceries", "weeklyCostOfEatingOut",
            "weeklyCostOfBeerWine", "healthcare", "childcare", "carInsurance", "vehicle", "gas", "HVAC", "phone",
            "tv", "travel", "otherUtilities"};

    public void enterBudgetInfo(){
        Scanner userInput1 = new Scanner(System.in);
        System.out.println("Enter monthly budget: ");
        monthlyBudget = userInput1.nextInt();

        Scanner userInput2 = new Scanner(System.in);
        System.out.println("Enter monthly income: ");
        monthlyIncome = userInput2.nextInt();

        for (int element : expensesList) {

            Scanner userInput3 = new Scanner(System.in);
            System.out.println("Enter expense for " + cycleThroughBudgetInfoNames()
                    + ": "); // user enters monthly income
            element = userInput3.nextInt();

            expenses += element;

            count++;
        }
        count = 0;
        expenses = (expenses * -1);

        System.out.println("All monthly budget information entered.");

        runMonthlyBudgetReport();

    }

    public void runMonthlyBudgetReport(){
        System.out.println("Monthly Budget = " + monthlyBudget);
        System.out.println("Monthly Income = " + monthlyIncome);
        System.out.println("Monthly expenses = " + (expenses));
        currentAmount = monthlyIncome + expenses;
        System.out.println("Current amount in account = " + currentAmount);

        int overUnderBudget = monthlyBudget + expenses;

        if(overUnderBudget > 0) {
            System.out.println("Amount left in budget = " + overUnderBudget);
        } else {
            System.out.println("Spent over budget = " + overUnderBudget);
        }
    }


    public String cycleThroughBudgetInfoNames(){
        itemName = budgetCriticalInformationNameList[count];
        return itemName;
    }


    public void askUserToUpdateBudgetInfo(){
        Scanner userInput1 = new Scanner(System.in);
        System.out.println("Would you like to update budget info? Enter 'Y' or 'N'. ");
        String answer = userInput1.next();

        while( !(answer).equalsIgnoreCase("N") ) {
            if(answer.equalsIgnoreCase("Y")) {
                updateBudgetInfo();
            } else {
                System.out.println("Please enter 'Y' or 'N' for an answer");
            }
        }
        System.out.println("User did not want to update budget information");
    }

    public void updateBudgetInfo(){
        enterBudgetInfo();
    }


}

