package budget_app.controllers;

import budget_app.models.Transaction;
import budget_app.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @GetMapping("/transaction")
    public String viewTransactionAccountPage(Model model) {
        final List<Transaction> transactionList = transactionService.getAllTransactions();
        model.addAttribute("transactionList", transactionList);
        return "transaction";
    }

    @GetMapping("/newTransaction")
    public String viewNewTransactionPage(Model model) {
        Transaction transaction = new Transaction();
        model.addAttribute("transaction", transaction);
        return "new-transaction";
    }

    @PostMapping(value = "/saveTransaction")
    public String saveTransaction(@ModelAttribute("transaction") Transaction transaction) {
        transactionService.addTransaction(transaction);
        return "redirect:/transaction";
    }

    @RequestMapping("/deleteTransaction/{id}")
    public String deleteTransaction(@PathVariable(name = "id") Long id) {
        transactionService.deleteTransaction(id);
        return "redirect:/transaction";
    }
}