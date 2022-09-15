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

//    public Float subtractNewTransactionFromSavings(Transaction transaction) {
//        Float savingBalance = savingService.getSavingBalance();
//        savingBalance = savingBalance - transaction.getAmount();
//        return savingBalance; // where do I store saving balance between each app session?
//    }

    public void subtractNewTransactionFromSavings(Transaction transaction) {
        Saving saving = savingService.getSavingAccountNine();
        int currentBalance = saving.getCurrentAmount() - transaction.getAmount();
        saving.setCurrentAmount(currentBalance);
        savingService.addSaving(saving);
    }




    public void deleteTransaction(Long id){
        transactionRepository.deleteById(id);
    }

    public Float getTransactionBalance() {
        return transactionRepository.getBalance();
    }

    public List<Transaction> getCustomerNameWhereTimestampIsGreaterThan(String customerName, Timestamp timestamp1){
        return transactionRepository.findByCustomerNameIsAndTimestampGreaterThan(customerName,timestamp1);
    }

    public List<Transaction> getTransactionByCustomerNameAndCategory(String customerName, Timestamp timestamp1, String category){
        return transactionRepository.findCustomerNameWhereTimestampIsGreaterThanAndCategoryIs(customerName,timestamp1, category);
    }
}
