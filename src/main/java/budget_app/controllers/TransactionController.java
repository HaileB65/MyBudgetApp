package budget_app.controllers;

import budget_app.models.Transaction;
import budget_app.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Stream;

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
        transactionService.saveTransaction(transaction);
        return "redirect:/transaction";
    }

    @RequestMapping("/deleteTransaction/{id}")
    public String deleteTransaction(@PathVariable(name = "id") Long id) {
        transactionService.deleteTransaction(id);
        return "redirect:/transaction";
    }

    @GetMapping("/editTransaction/{id}")
    public ModelAndView showEditTransactionPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit-transaction");
        Transaction transaction = transactionService.getTransactionById(id);
        mav.addObject("transaction", transaction);
        return mav;
    }

    @RequestMapping("/updateTransaction/{id}")
    public String updateTransaction(@ModelAttribute("transaction") Transaction transaction) {
        transactionService.saveTransaction(transaction);
        return "redirect:/transaction";
    }

    @GetMapping("/rolloverTransactions")
    public String rolloverTransactionsToSavings(Model model) {
        final List<Transaction> transactionsNotSavedToSavings = transactionService.getTransactionsNotAddedToSavingsFromLastMonth();
        model.addAttribute("transactionsNotSavedToSavings", transactionsNotSavedToSavings);

        return "rollover-transactions";
    }

    @GetMapping(value = "/completeRollover")
    public String completeRollover(Model model) {
        transactionService.moveTransactionsToSavings();

        final List<Transaction> transactionList = transactionService.getAllTransactions();
        model.addAttribute("transactionList", transactionList);

        return "rollover-complete";
    }
}