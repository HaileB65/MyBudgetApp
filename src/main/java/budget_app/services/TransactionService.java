package budget_app.services;

import budget_app.models.Saving;
import budget_app.models.Transaction;
import budget_app.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    SavingService savingService;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.getById(id);
    }

    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    public Float getTransactionBalance() {
        return transactionRepository.getBalance();
    }

    public List<Transaction> getTransactionsWhereTimestampGreaterThan(Timestamp timestamp1) {
        return transactionRepository.findByTimestampGreaterThan(timestamp1);
    }

    public void moveTransactionsToSavings() {
        Timestamp OneMonthFromToday = getTimestamp();

        int sum = transactionRepository.findByTimestampGreaterThan(OneMonthFromToday).stream() // get sum of transactions from last month
                .filter(transaction -> !transaction.isAddedToSavings())
                .map(Transaction::getAmount)
                .mapToInt(Integer::intValue)
                .sum();

        savingService.addSaving(Saving.builder() // deposit sum of transactions to savings account
                .currentAmount(sum)
                .build());

        transactionRepository.findByTimestampGreaterThan(OneMonthFromToday).stream() // change "added to savings"
                .filter(transaction -> !transaction.isAddedToSavings())              // column to "true" for each transaction
                .map(transaction -> transaction.isAddedToSavings());                 // added to savings account
    }

    public List<Transaction> getTransactionsNotAddedToSavingsFromLastMonth() {
        Timestamp OneMonthFromToday = getTimestamp();

        final List<Transaction> transactionsFromLastMonth = transactionRepository.findByTimestampGreaterThan(OneMonthFromToday);

        return transactionsFromLastMonth.stream()
                .filter(transaction -> !transaction.isAddedToSavings()) // filter to get transactions not added to savings account
                .collect(Collectors.toList()); // form into a list
    }

    private Timestamp getTimestamp() {
        Calendar cal = Calendar.getInstance(); // get date from one month ago
        cal.add(Calendar.MONTH, -1);
        Date result = cal.getTime();
        return new Timestamp(result.getTime());
    }

}
