package budget_app.services;

import budget_app.models.Saving;
import budget_app.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ReportService {
    @Autowired
    TransactionService transactionService;

    @Autowired
    SavingService savingService;

    public float getTransactionTotalFromLastMonth(){
        Calendar cal = Calendar.getInstance(); // get date from one month ago
        cal.add(Calendar.MONTH, -1);
        Date result = cal.getTime();

        Timestamp OneMonthFromToday= new Timestamp(result.getTime());
        final List<Transaction> transactionsBetweenList = transactionService.getCustomerNameWhereTimestampIsGreaterThan("Haile",OneMonthFromToday); // get transactions from last month

        Integer sumOfLastMonthsTransactions = transactionsBetweenList.stream() // get sum of transactions from last month
                .map(Transaction::getAmount)
                .mapToInt(Integer::intValue)
                .sum();

        return sumOfLastMonthsTransactions;
    }

    public float getSavingsTotalFromLastMonth(){
        Calendar cal = Calendar.getInstance(); // get date from one month ago
        cal.add(Calendar.MONTH, -1);
        Date result = cal.getTime();

        Timestamp OneMonthFromToday= new Timestamp(result.getTime());
        final List<Saving> savingsBetweenList = savingService.findNameWhereTimestampIsGreaterThan("saving",OneMonthFromToday); // get savings from last month

        Integer sumOfLastMonthsSavings = savingsBetweenList.stream() // get sum of savings from last month
                .map(Saving::getCurrentAmount)
                .mapToInt(Integer::intValue)
                .sum();

        return sumOfLastMonthsSavings;
    }

    public float getFutureBalanceSum(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date result = cal.getTime();

        Timestamp OneMonthFromToday= new Timestamp(result.getTime());
        final List<Transaction> transactionsBetweenList = transactionService.getCustomerNameWhereTimestampIsGreaterThan("Haile",OneMonthFromToday); // get transactions from last month

        Integer sumOfLastMonthsTransactions = transactionsBetweenList.stream() // get sum of transactions from last month
                .map(Transaction::getAmount)
                .mapToInt(Integer::intValue)
                .sum();

        float futureBalance = savingService.getSavingBalance() - sumOfLastMonthsTransactions; // current savings minus sum of transactions from last month

        return futureBalance;
    }

    public void runSpendingBreakdown(){
        //show different tables of transactions from each category

        //table 2: transactions from last month for car Insurance
    }

    public List<Transaction> getTravelTransactionsFromLastMonth(){
        //table 1: transactions from last month for travel
        Calendar cal = Calendar.getInstance(); // get date from one month ago
        cal.add(Calendar.MONTH, -1);
        Date result = cal.getTime();
        Timestamp OneMonthFromToday= new Timestamp(result.getTime());
        final List<Transaction> transactionsFromLastMonth = transactionService.getCustomerNameWhereTimestampIsGreaterThan("Haile",OneMonthFromToday); // get transactions from last month

        List<Transaction> travelTransactions = new ArrayList<>(); // new filtered list
        for (Transaction transaction : transactionsFromLastMonth) {
            if (transaction.getCategory().equalsIgnoreCase("Travel")) {
                travelTransactions.add(transaction);
            }
        }

        return travelTransactions;
    }

    public List<Transaction> getOneTimePaymentTransactionsFromLastMonth(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date result = cal.getTime();
        Timestamp OneMonthFromToday= new Timestamp(result.getTime());
        final List<Transaction> transactionsFromLastMonth = transactionService.getCustomerNameWhereTimestampIsGreaterThan("Haile",OneMonthFromToday); // get transactions from last month

        List<Transaction> oneTimePaymentTransactions = new ArrayList<>();
        for (Transaction transaction : transactionsFromLastMonth) {
            if (transaction.getCategory().equalsIgnoreCase("One Time Payment")) {
                oneTimePaymentTransactions.add(transaction);
            }
        }
        return oneTimePaymentTransactions;
    }

    public void runGoalsReport(){
        System.out.println("GoalsReport");
        //display current goals and how far they are from their total
    }

}
