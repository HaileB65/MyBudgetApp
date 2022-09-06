package budget_app.services;

import budget_app.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ReportService {
    @Autowired
    TransactionService transactionService;

    @Autowired
    SavingsService savingsService;

    public float getFutureBalanceSum(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date result = cal.getTime();

        Timestamp OneMonthFromToday= new Timestamp(result.getTime());
        final List<Transaction> transactionsBetweenList = transactionService.findCustomerNameWhereTimestampIsGreaterThan("Haile",OneMonthFromToday); // get transactions from last month

        Integer sumOfLastMonthsTransactions = transactionsBetweenList.stream() // get sum of transactions from last month
                .map(Transaction::getAmount)
                .mapToInt(Integer::intValue).sum();

        float futureBalance = savingsService.getSavingBalance() - sumOfLastMonthsTransactions; // current savings minus sum of transactions from last month

        return futureBalance;
    }

    public void runDebtPaymentCalendarReport(){
        System.out.println("DebtPaymentCalendarReport");
        //print out a $100 charge the 10th and 25th of each month for credit card bill

    }

    public void RunSpendingVsSavingOverTimeReport(){
        System.out.println("SpendingVsSavingOverTimeReport");
        //get savings and spending from last month
        //print out both
        //subtract spending from savings and display

    }

    public void runComprehensiveFinancialSanityReport(){
        System.out.println("ComprehensiveFinancialSanityReport");
        //

    }

    public void runGoalsReport(){
        System.out.println("GoalsReport");
        //display current goals and how far they are from their total

    }

}
