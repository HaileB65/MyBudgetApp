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
    public static Integer monthlyBudget = 0;
    public static Integer currentAmount = 0;
    public static Integer expenses = 0;
    public static Integer monthlyIncome = 0;
    public static Integer oneTimePayment = 0;
    public static Integer costOfRent = 0;
    public static Integer fixedDebtPayments = 0;
    public static Integer weeklyCostOfGroceries = 0;
    public static Integer weeklyCostOfEatingOut = 0;
    public static Integer weeklyCostOfBeerWine = 0;
    //monthly cost of
    public static Integer healthcare = 0;
    public static Integer childcare = 0;
    public static Integer carInsurance = 0;
    public static Integer vehicle = 0;
    public static Integer gas = 0;
    public static Integer HVAC = 0;
    public static Integer phone = 0;
    public static Integer tv = 0;
    public static Integer travel = 0;
    public static Integer otherUtilities = 0;
    public static Integer numberOfTimesYouEatOut = 0;

    public static String itemName = null;
    public static Integer count = 0;


    public static ArrayList<Integer> expensesList = new ArrayList<>(Arrays. asList(oneTimePayment, costOfRent,
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
