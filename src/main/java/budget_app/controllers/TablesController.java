package budget_app.controllers;

import budget_app.models.Goal;
import budget_app.models.Saving;
import budget_app.models.Transaction;
import budget_app.models.User;
import budget_app.services.GoalService;
import budget_app.services.SavingService;
import budget_app.services.TransactionService;
import budget_app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class TablesController {
    @Autowired
    UserService userService;

    @Autowired
    TransactionService transactionService;

    @Autowired
    SavingService savingService;

    @Autowired
    GoalService goalService;

    @GetMapping("/tables")
    public String viewHomePage(Model model) {
        List<User> usersList = userService.getAllUsers();
        model.addAttribute("usersList", usersList);

        List<Transaction> transactionList = transactionService.getAllTransactions();
        model.addAttribute("transactionList", transactionList);

        float transactionBalance  = transactionService.getTransactionBalance();
        model.addAttribute("transactionBalance", transactionBalance);

        List<Saving> savingList = savingService.getAllSavings();
        model.addAttribute("savingList", savingList);

        float savingBalance  = savingService.getSavingBalance();
        model.addAttribute("savingBalance", savingBalance);

        List<Goal> goalsList = goalService.getAllGoals();
        model.addAttribute("goalsList", goalsList);
        return "tables";
    }

}
