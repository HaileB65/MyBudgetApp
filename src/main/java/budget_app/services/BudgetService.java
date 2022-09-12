package budget_app.services;

import budget_app.models.Budget;
import budget_app.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BudgetService {
    @Autowired
    BudgetRepository budgetRepository;

    public List<Budget> getAllBudgets(){
        return budgetRepository.findAll();
    }

    public Budget getBudgetById(Long id){return budgetRepository.findBudgetById(id);}

    public void saveBudget(Budget budget) {
        budgetRepository.save(budget);
    }

    public int returnExpensesCalculation(){
        Budget budget = budgetRepository.findBudgetById(1L);
        int expenses = budget.getOneTimePayment() + budget.getCostOfRent() + budget.getFixedDebtPayments()
                + budget.getWeeklyCostOfGroceries() + (budget.getWeeklyCostOfEatingOut() * budget.getNumberOfTimesYouEatOut()) + budget.getWeeklyCostOfEatingOut()
                + budget.getHealthcare() + budget.getChildcare() + budget.getCarInsurance() + budget.getVehicle()
                + budget.getGas() + budget.getHVAC() + budget.getPhone() + budget.getTv() + budget.getTravel()
                + budget.getOtherUtilities() + budget.getNumberOfTimesYouEatOut();

        return expenses;
    }

    public int returnCurrentBalance(){
        Budget budget = budgetRepository.findBudgetById(1L);
        int  monthlyBudget= budget.getMonthlyBudget();
        int currentBalance = monthlyBudget - returnExpensesCalculation();

        return currentBalance;
    }

//    public void addExpenseNameToBudgetList(){
//        Scanner userInput1 = new Scanner(System.in);
//        System.out.println("Enter new expense name:");
//        String newExpense = userInput1.nextLine();
//
//        Integer newExpenseValue = 0;
//
//        Budget.budgetCriticalInformationNameList.add(newExpense);
//        Budget.expensesList.add(newExpenseValue);
//
//        System.out.println("New expense " + newExpense +  " added to budget list.");
//        System.out.println();
//    }
//
//    public void removeExpenseFromBudgetList(){
//        Scanner userInput1 = new Scanner(System.in);
//        System.out.println("Enter expense name to delete it from the budget list:");
//        String newExpense = userInput1.nextLine();
//        Budget.budgetCriticalInformationNameList.remove(newExpense);
//    }

//    public void runMonthlyBudgetReport(){
//        System.out.println("Monthly Budget = " + Budget.monthlyBudget);
//        System.out.println("Monthly Income = " + Budget.monthlyIncome);
//        System.out.println("Monthly expenses = " + (Budget.expenses));
//        Budget.currentAmount = Budget.monthlyIncome + Budget.expenses;
//        System.out.println("Current amount in account = " + Budget.currentAmount);
//
//        int overUnderBudget = Budget.monthlyBudget + Budget.expenses;
//
//        if(overUnderBudget > 0) {
//            System.out.println("Amount left in budget = " + overUnderBudget);
//        } else {
//            System.out.println("Spent over budget = " + overUnderBudget);
//        }
//
//        System.out.println();
//    }

    public String cycleThroughBudgetInfoNames(){
        Budget.itemName = Budget.budgetCriticalInformationNameList.get(Budget.count);
        return Budget.itemName;
    }

//    public void updateBudgetInfo(){
//        enterBudgetInfo();
//    }
//
//    public void printOutBudgetAndExpenseList(){
//        System.out.println("printing out budgetCriticalInfo list");
//        System.out.println(Budget.budgetCriticalInformationNameList);
//
//        System.out.println("printing out expense list");
//        System.out.println(Budget.expensesList);
//    }


}

