package budget_app.services;

import budget_app.models.Saving;
import budget_app.models.Transaction;
import budget_app.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    SavingService savingService;

    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id){return transactionRepository.getById(id);}

    public void saveTransaction(Transaction transaction){
        transactionRepository.save(transaction);
        subtractNewTransactionFromSavings(transaction);
    }

    public void subtractNewTransactionFromSavings(Transaction transaction) {
        Saving saving = savingService.getSavingAccountThree();
        int savingBalance = saving.getCurrentAmount();
        savingBalance = savingBalance - transaction.getAmount();
        savingService.addSaving(saving);
    }

//    public void subtractNewTransactionFromSavings(Transaction transaction) {
//        Float currentBalance = savingService.getSavingBalance();
//        currentBalance = currentBalance - transaction.getAmount();
//    }

    public void deleteTransaction(Long id){
        transactionRepository.deleteById(id);
    }

    public Float getTransactionBalance() {
        return transactionRepository.getBalance();
    }

    public List<Transaction> findCustomerNameWhereTimestampIsGreaterThan(String customerName, Timestamp timestamp1){
        return transactionRepository.findByCustomerNameIsAndTimestampGreaterThan(customerName,timestamp1);
    }
}
