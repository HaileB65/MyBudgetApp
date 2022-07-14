package budget_app.services;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BudgetCriticalInformationService {
    Integer monthlyBudget;
    Integer currentAmount;
    Integer expenses;
    Integer count = 0;
    String itemName = null;

    Integer monthlyIncome;
    Integer oneTimePayment;
    Integer costOfRent;
    Integer fixedDebtPayments;
    Integer weeklyCostOfGroceries;
    Integer weeklyCostOfEatingOut;
    Integer numberOfTimesYouEatOut;
    Integer weeklyCostOfBeerWine;

    //monthly cost of
    Integer healthcare;
    Integer childcare;
    Integer carInsurance;
    Integer vehicle;
    Integer gas;
    Integer HVAC;
    Integer phone;
    Integer tv;
    Integer travel;
    Integer otherUtilities;


    ArrayList<Integer> expensesList = new ArrayList<>(Arrays. asList(oneTimePayment, costOfRent,
    fixedDebtPayments, weeklyCostOfGroceries, weeklyCostOfEatingOut, weeklyCostOfBeerWine,
    healthcare, childcare, carInsurance, vehicle, gas, HVAC, phone, tv, travel, otherUtilities));

    ArrayList<String> budgetCriticalInformationNameList =  new ArrayList<>(Arrays. asList("oneTimePayment", "costOfRent",
            "fixedDebtPayments", "weeklyCostOfGroceries", "weeklyCostOfEatingOut",
            "weeklyCostOfBeerWine", "healthcare", "childcare", "carInsurance", "vehicle", "gas", "HVAC", "phone",
            "tv", "travel", "otherUtilities"));

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

    public void addExpenseNameToBudgetList(){
        Scanner userInput1 = new Scanner(System.in);
        System.out.println("Enter new expense name:");
        String newExpense = userInput1.nextLine();

        Integer newExpenseValue = 0;

        int homeInsurance = 250;
        budgetCriticalInformationNameList.add(newExpense);
        expensesList.add(newExpenseValue);

        System.out.println("New expense " + newExpense +  " added to budget list.");
        System.out.println();
    }

    public void removeExpenseFromBudgetList(){
        Scanner userInput1 = new Scanner(System.in);
        System.out.println("Enter expense name to delete it from the budget list:");
        String newExpense = userInput1.nextLine();
        budgetCriticalInformationNameList.remove(newExpense);
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
        itemName = budgetCriticalInformationNameList.get(count);
        return itemName;
    }


    public void updateBudgetInfo(){
        enterBudgetInfo();
    }

    public void budgetAndExpenseListCheck(){
        System.out.println("printing out budgetCriticalInfo list");
        System.out.println(budgetCriticalInformationNameList);

        System.out.println("printing out expense list");
        System.out.println(expensesList);
    }


}

