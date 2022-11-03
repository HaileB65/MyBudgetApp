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

}

