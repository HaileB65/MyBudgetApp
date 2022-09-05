package budget_app.controllers;

import budget_app.models.Goal;
import budget_app.models.Transaction;
import budget_app.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller
public class ReportController {
    @Autowired
    TransactionService transactionService;

    @GetMapping("/reports")
    public String viewGoalPage(Model model) {
        return "reports";
    }

    @GetMapping("/futureBalanceReport")
    public String viewFutureBalancePage(Model model) {
//        Goal goal = new Goal();
//        model.addAttribute("goal", goal);
        return "future-balance-report";
    }

//    @GetMapping("/newTransaction")
//    public String viewNewTransactionPage(Model model) {
//        Transaction transaction = new Transaction();
//        model.addAttribute("transaction", transaction);
//        return "new-transaction";
//    }
//
    @PostMapping(value = "/runFutureBalanceReport")
    public String runFutureBalanceReport() {
//        transactionService.
        return "redirect:/futureBalanceReport";
    }
//
//    @RequestMapping("/deleteTransaction/{id}")
//    public String deleteTransaction(@PathVariable(name = "id") Long id) {
//        transactionService.deleteTransaction(id);
//        return "redirect:/transaction";
//    }
}