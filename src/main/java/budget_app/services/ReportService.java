package budget_app.services;

import budget_app.models.Saving;
import budget_app.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportService {
    @Autowired
    TransactionService transactionService;

    @Autowired
    SavingService savingService;

    public float getTransactionTotalFromLastMonth(){
        Timestamp OneMonthFromToday = getTimestamp();

        final List<Transaction> transactionsFromLastMonth = transactionService.getTransactionsWhereTimestampGreaterThan(OneMonthFromToday); // get transactions from last month

        return transactionsFromLastMonth.stream() // get sum of transactions from last month
                .map(Transaction::getAmount)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public float getSavingsTotalFromLastMonth(){
        Timestamp OneMonthFromToday = getTimestamp();

        final List<Saving> savingsBetweenList = savingService.getSavingTransactions(OneMonthFromToday); // get savings from last month

        return savingsBetweenList.stream() // get sum of savings from last month
                .map(Saving::getCurrentAmount)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public float getFutureBalanceSum(){
        Timestamp OneMonthFromToday = getTimestamp();

        final List<Transaction> transactionsFromLastMonth = transactionService.getTransactionsWhereTimestampGreaterThan(OneMonthFromToday); // get transactions from last month

        Integer sumOfLastMonthsTransactions = transactionsFromLastMonth.stream() // get sum of transactions from last month
                .map(Transaction::getAmount)
                .mapToInt(Integer::intValue)
                .sum();

        float futureBalance = savingService.getSavingBalance() - sumOfLastMonthsTransactions; // current savings minus sum of transactions from last month

        return futureBalance;
    }

    public Map<String, List<Transaction>> getTransactionsFromLastMonth(){
        Timestamp OneMonthFromToday = getTimestamp();

        final List<Transaction> transactionsFromLastMonth = transactionService.getTransactionsWhereTimestampGreaterThan(OneMonthFromToday);

        return transactionsFromLastMonth.stream()
                .collect(Collectors.groupingBy(Transaction::getCategory));

    }

    public void runGoalsReport(){
        System.out.println("GoalsReport");
        //display current goals and how far they are from their total
    }

    private Timestamp getTimestamp() {
        Calendar cal = Calendar.getInstance(); // get date from one month ago
        cal.add(Calendar.MONTH, -1);
        Date result = cal.getTime();
        return new Timestamp(result.getTime());
    }

}
