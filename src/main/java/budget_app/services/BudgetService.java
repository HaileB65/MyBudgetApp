package budget_app.services;

import budget_app.models.Budget;
import budget_app.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Scanner;

@Service
public class BudgetService {

    public ArrayList<Budget> getAllBudgets(){
        return Repository.returnAllBudgets();
    }

//    public Long getBudget(Long id){ return Repository.getBudget();}

    public void enterBudgetInfo(){
        Scanner userInput1 = new Scanner(System.in);
        System.out.println("Enter monthly budget: ");
        Budget.monthlyBudget = userInput1.nextInt();


        Scanner userInput2 = new Scanner(System.in);
        System.out.println("Enter monthly income: ");
        Budget.monthlyIncome = userInput2.nextInt();

        for (int element : Budget.expensesList) {

//            Scanner userInput3 = new Scanner(System.in);
//            System.out.println("Enter expense for " + cycleThroughBudgetInfoNames()
//                    + ": "); // user enters monthly income
//            element = userInput3.nextInt();

//            Budget.expenses += element;
            Budget.expenses += 12;

            Budget.count++;
        }
        Budget.count = 0;
        Budget.expenses = (Budget.expenses * -1);

        System.out.println("All monthly budget information entered.");

        runMonthlyBudgetReport();

    }

    public void addExpenseNameToBudgetList(){
        Scanner userInput1 = new Scanner(System.in);
        System.out.println("Enter new expense name:");
        String newExpense = userInput1.nextLine();

        Integer newExpenseValue = 0;

        Budget.budgetCriticalInformationNameList.add(newExpense);
        Budget.expensesList.add(newExpenseValue);

        System.out.println("New expense " + newExpense +  " added to budget list.");
        System.out.println();
    }

    public void removeExpenseFromBudgetList(){
        Scanner userInput1 = new Scanner(System.in);
        System.out.println("Enter expense name to delete it from the budget list:");
        String newExpense = userInput1.nextLine();
        Budget.budgetCriticalInformationNameList.remove(newExpense);
    }

    public void runMonthlyBudgetReport(){
        System.out.println("Monthly Budget = " + Budget.monthlyBudget);
        System.out.println("Monthly Income = " + Budget.monthlyIncome);
        System.out.println("Monthly expenses = " + (Budget.expenses));
        Budget.currentAmount = Budget.monthlyIncome + Budget.expenses;
        System.out.println("Current amount in account = " + Budget.currentAmount);

        int overUnderBudget = Budget.monthlyBudget + Budget.expenses;

        if(overUnderBudget > 0) {
            System.out.println("Amount left in budget = " + overUnderBudget);
        } else {
            System.out.println("Spent over budget = " + overUnderBudget);
        }

        System.out.println();
    }

    public String cycleThroughBudgetInfoNames(){
        Budget.itemName = Budget.budgetCriticalInformationNameList.get(Budget.count);
        return Budget.itemName;
    }

    public void updateBudgetInfo(){
        enterBudgetInfo();
    }

    public void printOutBudgetAndExpenseList(){
        System.out.println("printing out budgetCriticalInfo list");
        System.out.println(Budget.budgetCriticalInformationNameList);

        System.out.println("printing out expense list");
        System.out.println(Budget.expensesList);
    }


}

