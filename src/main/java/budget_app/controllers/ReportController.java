package budget_app.controllers;

import budget_app.models.Transaction;
import budget_app.services.ReportService;
import budget_app.services.SavingsService;
import budget_app.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Controller
public class ReportController {
    @Autowired
    TransactionService transactionService;

    @Autowired
    ReportService reportService;

    @Autowired
    SavingsService savingsService;

    @GetMapping("/reports")
    public String viewGoalPage(Model model) {
        return "reports";
    }

    @GetMapping("/futureBalanceReport")
    public String viewFutureBalanceReportPage(Model model) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date result = cal.getTime();

        Timestamp ts = new Timestamp(result.getTime());
        final List<Transaction> transactionsBetweenList = transactionService.findCustomerNameWhereTimestampIsGreaterThan("Haile",ts);
        model.addAttribute("transactionsBetweenList", transactionsBetweenList); // display table of last month's transactions

        final Float futureBalanceSum  = reportService.getFutureBalanceSum();
        model.addAttribute("futureBalanceSum", futureBalanceSum);
        return "future-balance-report";
    }

    @GetMapping("/debtPaymentReport")
    public String viewDebtPaymentReportPage(Model model) {
        final Float savingBalance  = savingsService.getSavingBalance();
        model.addAttribute("savingBalance", savingBalance);
        return "debt-payment-report";
    }

    @GetMapping("/spendingVsSavingReport")
    public String viewSpendingVsSavingReportPage(Model model) {
        final Float savingBalance  = savingsService.getSavingBalance();
        model.addAttribute("savingBalance", savingBalance);

        final Float transactionTotalFromLastMonth  = reportService.getTransactionTotalFromLastMonth();
        model.addAttribute("transactionTotalFromLastMonth", transactionTotalFromLastMonth);

        return "spending-vs-saving-report";
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