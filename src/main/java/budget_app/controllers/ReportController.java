package budget_app.controllers;

import budget_app.models.Transaction;
import budget_app.services.ReportService;
import budget_app.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Controller
public class ReportController {
    @Autowired
    TransactionService transactionService;

    @Autowired
    ReportService reportService;

    @GetMapping("/reports")
    public String viewGoalPage(Model model) {
        return "reports";
    }

    @GetMapping("/futureBalanceReport")
    public String viewFutureBalanceReportPage(Model model) {

        Date date = new Date();
        Timestamp ts=new Timestamp(date.getTime());
        final List<Transaction> transactionsBetweenList = transactionService.findCustomerNameWhereTimestampIsLessThan("Haile",ts);
        model.addAttribute("transactionsBetweenList", transactionsBetweenList); // display table of last months transactions

        final Float futureBalanceSum  = reportService.getFutureBalanceSum();
        model.addAttribute("futureBalanceSum", futureBalanceSum);
        return "future-balance-report";
    }

//    @GetMapping("/newTransaction")
//    public String viewNewTransactionPage(Model model) {
//        Transaction transaction = new Transaction();
//        model.addAttribute("transaction", transaction);
//        return "new-transaction";
//    }
//
//    @PostMapping(value = "/runFutureBalanceReport")
//    public String runFutureBalanceReport() {
//        runFutureBalanceReport();
//        return "redirect:/futureBalanceReport";
//    }
//
//    @RequestMapping("/deleteTransaction/{id}")
//    public String deleteTransaction(@PathVariable(name = "id") Long id) {
//        transactionService.deleteTransaction(id);
//        return "redirect:/transaction";
//    }
}