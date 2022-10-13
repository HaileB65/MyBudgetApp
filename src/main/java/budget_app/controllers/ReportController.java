package budget_app.controllers;

import budget_app.models.Goal;
import budget_app.models.Transaction;
import budget_app.repository.GoalRepository;
import budget_app.services.GoalService;
import budget_app.services.ReportService;
import budget_app.services.SavingService;
import budget_app.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Controller
public class ReportController {
    @Autowired
    TransactionService transactionService;

    @Autowired
    ReportService reportService;

    @Autowired
    SavingService savingService;

    @Autowired
    GoalService goalService;

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

        final List<Transaction> transactionsBetweenList = transactionService.getTransactionsWhereTimestampGreaterThan(ts);
        model.addAttribute("transactionsBetweenList", transactionsBetweenList); // display table of last month's transactions

        final Float futureBalanceSum  = reportService.getFutureBalanceSum();
        model.addAttribute("futureBalanceSum", futureBalanceSum);
        return "future-balance-report";
    }

    @GetMapping("/debtPaymentReport")
    public String viewDebtPaymentReportPage(Model model) {
        final Float savingBalance  = savingService.getSavingBalance();
        model.addAttribute("savingBalance", savingBalance);
        return "debt-payment-report";
    }

    @GetMapping("/spendingVsSavingReport")
    public String viewSpendingVsSavingReportPage(Model model) {
        final Float savingsTotalFromLastMonth  = reportService.getSavingsTotalFromLastMonth();
        model.addAttribute("savingsTotalFromLastMonth", savingsTotalFromLastMonth);

        final Float transactionTotalFromLastMonth  = reportService.getTransactionTotalFromLastMonth();
        model.addAttribute("transactionTotalFromLastMonth", transactionTotalFromLastMonth);

        return "spending-vs-saving-report";
    }

    @GetMapping("/spendingBreakdown")
    public String viewSpendingBreakdownPage(Model model) {
        // Map of transactions from last month
        final Map<String, List<Transaction>> transactionsFromLastMonth = reportService.getTransactionsFromLastMonth();
        model.addAttribute("transactionsFromLastMonth", transactionsFromLastMonth);

        return "spending-Breakdown";
    }

    @GetMapping("/goalsReport")
    public String viewGoalsReportPage(Model model) {
        final List<Goal> goalsList = goalService.getAllGoals();
        model.addAttribute("goalsList", goalsList);
        return "goal-report";
    }
}