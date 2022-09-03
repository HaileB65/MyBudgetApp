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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static Integer getMonthlyBudget() {
        return monthlyBudget;
    }

    public static void setMonthlyBudget(Integer monthlyBudget) {
        Budget.monthlyBudget = monthlyBudget;
    }

    public static Integer getCurrentAmount() {
        return currentAmount;
    }

    public static void setCurrentAmount(Integer currentAmount) {
        Budget.currentAmount = currentAmount;
    }

    public static Integer getExpenses() {
        return expenses;
    }

    public static void setExpenses(Integer expenses) {
        Budget.expenses = expenses;
    }

    public static Integer getCount() {
        return count;
    }

    public static void setCount(Integer count) {
        Budget.count = count;
    }

    public static String getItemName() {
        return itemName;
    }

    public static void setItemName(String itemName) {
        Budget.itemName = itemName;
    }

    public static Integer getMonthlyIncome() {
        return monthlyIncome;
    }

    public static void setMonthlyIncome(Integer monthlyIncome) {
        Budget.monthlyIncome = monthlyIncome;
    }

    public static Integer getOneTimePayment() {
        return oneTimePayment;
    }

    public static void setOneTimePayment(Integer oneTimePayment) {
        Budget.oneTimePayment = oneTimePayment;
    }

    public static Integer getCostOfRent() {
        return costOfRent;
    }

    public static void setCostOfRent(Integer costOfRent) {
        Budget.costOfRent = costOfRent;
    }

    public static Integer getFixedDebtPayments() {
        return fixedDebtPayments;
    }

    public static void setFixedDebtPayments(Integer fixedDebtPayments) {
        Budget.fixedDebtPayments = fixedDebtPayments;
    }

    public static Integer getWeeklyCostOfGroceries() {
        return weeklyCostOfGroceries;
    }

    public static void setWeeklyCostOfGroceries(Integer weeklyCostOfGroceries) {
        Budget.weeklyCostOfGroceries = weeklyCostOfGroceries;
    }

    public static Integer getWeeklyCostOfEatingOut() {
        return weeklyCostOfEatingOut;
    }

    public static void setWeeklyCostOfEatingOut(Integer weeklyCostOfEatingOut) {
        Budget.weeklyCostOfEatingOut = weeklyCostOfEatingOut;
    }

    public static Integer getNumberOfTimesYouEatOut() {
        return numberOfTimesYouEatOut;
    }

    public static void setNumberOfTimesYouEatOut(Integer numberOfTimesYouEatOut) {
        Budget.numberOfTimesYouEatOut = numberOfTimesYouEatOut;
    }

    public static Integer getWeeklyCostOfBeerWine() {
        return weeklyCostOfBeerWine;
    }

    public static void setWeeklyCostOfBeerWine(Integer weeklyCostOfBeerWine) {
        Budget.weeklyCostOfBeerWine = weeklyCostOfBeerWine;
    }

    public static Integer getHealthcare() {
        return healthcare;
    }

    public static void setHealthcare(Integer healthcare) {
        Budget.healthcare = healthcare;
    }

    public static Integer getChildcare() {
        return childcare;
    }

    public static void setChildcare(Integer childcare) {
        Budget.childcare = childcare;
    }

    public static Integer getCarInsurance() {
        return carInsurance;
    }

    public static void setCarInsurance(Integer carInsurance) {
        Budget.carInsurance = carInsurance;
    }

    public static Integer getVehicle() {
        return vehicle;
    }

    public static void setVehicle(Integer vehicle) {
        Budget.vehicle = vehicle;
    }

    public static Integer getGas() {
        return gas;
    }

    public static void setGas(Integer gas) {
        Budget.gas = gas;
    }

    public static Integer getHVAC() {
        return HVAC;
    }

    public static void setHVAC(Integer HVAC) {
        Budget.HVAC = HVAC;
    }

    public static Integer getPhone() {
        return phone;
    }

    public static void setPhone(Integer phone) {
        Budget.phone = phone;
    }

    public static Integer getTv() {
        return tv;
    }

    public static void setTv(Integer tv) {
        Budget.tv = tv;
    }

    public static Integer getTravel() {
        return travel;
    }

    public static void setTravel(Integer travel) {
        Budget.travel = travel;
    }

    public static Integer getOtherUtilities() {
        return otherUtilities;
    }

    public static void setOtherUtilities(Integer otherUtilities) {
        Budget.otherUtilities = otherUtilities;
    }

    public static ArrayList<Integer> getExpensesList() {
        return expensesList;
    }

    public static void setExpensesList(ArrayList<Integer> expensesList) {
        Budget.expensesList = expensesList;
    }

    public static ArrayList<String> getBudgetCriticalInformationNameList() {
        return budgetCriticalInformationNameList;
    }

    public static void setBudgetCriticalInformationNameList(ArrayList<String> budgetCriticalInformationNameList) {
        Budget.budgetCriticalInformationNameList = budgetCriticalInformationNameList;
    }


}
