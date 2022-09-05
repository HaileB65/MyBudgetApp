package budget_app.controllers;

import budget_app.models.Transaction;
import budget_app.models.Goal;
import budget_app.models.Savings;
import budget_app.models.User;
import budget_app.services.TransactionService;
import budget_app.services.GoalService;
import budget_app.services.SavingsService;
import budget_app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class HomeController {
    @Autowired
    UserService userService;

    @Autowired
    TransactionService transactionService;

    @Autowired
    SavingsService savingsService;

    @Autowired
    GoalService goalService;

    @GetMapping("/home")
    public String viewHomePage(Model model) {
        final List<User> usersList = userService.getAllUsers();
        model.addAttribute("usersList", usersList);

        final List<Transaction> transactionList = transactionService.getAllTransactions();
        model.addAttribute("transactionList", transactionList);

        final Float transactionBalance  = transactionService.getTransactionBalance();
        model.addAttribute("transactionBalance", transactionBalance);

        final List<Savings> savingsList = savingsService.getAllSavings();
        model.addAttribute("savingsList", savingsList);

        final Float savingBalance  = savingsService.getSavingBalance();
        model.addAttribute("savingBalance", savingBalance);

        final List<Goal> goalsList = goalService.getAllGoals();
        model.addAttribute("goalsList", goalsList);
        return "home";
    }

    @GetMapping("/login")
    public String viewLoginPage(Model model) {
        return "login";
    }

    @GetMapping("/welcome")
    public String viewWelcome(Model model) {
        return "welcome";
    }

    @GetMapping("/reports")
    public String viewReportPage(Model model) {
        final List<Goal> goalsList = goalService.getAllGoals();
        model.addAttribute("goalsList", goalsList);
        return "reports";
    }
}
