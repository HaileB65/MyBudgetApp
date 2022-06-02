package budget_app.services;

import java.util.Scanner;

// model package
// the model package will contain all the POJOs required for your application.
public class budgetCriticalInformation {
    String name;
    int targetAmount;

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

    public void enterbudgetCritialInformation(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter Monthly income"); // user enters monthly income
        monthlyIncome = userInput.nextInt();

        Scanner userInput2 = new Scanner(System.in);
        System.out.println("Enter oneTimePayment"); // user enters monthly income
        oneTimePayment = userInput.nextInt();

        //automate asking user to enter budget critical information
//    public void askUser(){
//        Scanner userInput = new Scanner(System.in);
//        System.out.println("Enter " + Monthly +"income"); // user enters monthly income
//        monthlyIncome = userInput.nextInt();
//    }

    }



    public void updateBudgetCritialInformation(String itemName, Integer value){
        // find itemName in budgetCritialInformation class
        // set item to new value entered by user

        Scanner updateItem = new Scanner(System.in);
        monthlyIncome = updateItem.nextInt();


    }


}
