package budget_app.services;

import budget_app.models.Transaction;
import budget_app.models.Savings;
import budget_app.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    SavingsService savingsService;

    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }

    public void addTransaction(Transaction transaction){
        transactionRepository.save(transaction);
        subtractNewTransactionFromSavings(transaction);
    }

    public void subtractNewTransactionFromSavings(Transaction transaction) {
        Savings saving = savingsService.getSavingAccountOne();
        int currentBalance = saving.getCurrentAmount();
        saving.setCurrentAmount(currentBalance-transaction.getAmount());
        savingsService.updateSavingAccountOne(saving);
    }

    public void deleteTransaction(Long id){
        transactionRepository.deleteById(id);
    }

    public Float getTransactionBalance() {
        return transactionRepository.getBalance();
    }
}
