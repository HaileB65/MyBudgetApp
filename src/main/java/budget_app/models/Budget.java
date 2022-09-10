package budget_app.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;

@Entity
@Table(name="budget")
@Data
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    int monthlyBudget = 0;
    int currentAmount = 0;
    int expenses = 0;
    int monthlyIncome = 0;

    int oneTimePayment = 0;
    int costOfRent = 0;
    int fixedDebtPayments = 0;
    int weeklyCostOfGroceries = 0;
    int weeklyCostOfEatingOut = 0;
    int weeklyCostOfBeerWine = 0;

    //monthly cost of
    int healthcare = 0;
    int childcare = 0;
    int carInsurance = 0;
    int vehicle = 0;
    int gas = 0;
    int HVAC = 0;
    int phone = 0;
    int tv = 0;
    int travel = 0;
    int otherUtilities = 0;
    int numberOfTimesYouEatOut = 0;

    public static String itemName = null;
    public static int count = 0;


    public ArrayList<Integer> expensesList = new ArrayList<>(Arrays. asList(oneTimePayment, costOfRent,
            fixedDebtPayments, weeklyCostOfGroceries, weeklyCostOfEatingOut, weeklyCostOfBeerWine,
            healthcare, childcare, carInsurance, vehicle, gas, HVAC, phone, tv, travel, otherUtilities));

    public static ArrayList<String> budgetCriticalInformationNameList =  new ArrayList<>(Arrays. asList("oneTimePayment", "costOfRent",
            "fixedDebtPayments", "weeklyCostOfGroceries", "weeklyCostOfEatingOut",
            "weeklyCostOfBeerWine", "healthcare", "childcare", "carInsurance", "vehicle", "gas", "HVAC", "phone",
            "tv", "travel", "otherUtilities"));


    public static ArrayList<String> getBudgetCriticalInformationNameList() {
        return budgetCriticalInformationNameList;
    }

    public static void setBudgetCriticalInformationNameList(ArrayList<String> budgetCriticalInformationNameList) {
        Budget.budgetCriticalInformationNameList = budgetCriticalInformationNameList;
    }


}
