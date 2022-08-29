package budget_app.services;

import budget_app.models.Checking;
import budget_app.models.Savings;
import budget_app.repository.CheckingRepository;
import budget_app.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CheckingService {
    @Autowired
    CheckingRepository checkingRepository;

    @Autowired
    SavingsService savingsService;

    public ArrayList<Checking> getAllChecking(){
        return Repository.returnAllChecking();
    }

    public void addChecking(Checking checking){
        Repository.addChecking(checking);
        subtractNewTransactionFromSavings(checking);
    }

    public void subtractNewTransactionFromSavings(Checking checking) {
        Savings saving = savingsService.getSavingAccountOne();
        int currentBalance = saving.getCurrentAmount();
        saving.setCurrentAmount(currentBalance-checking.getAmount());
        savingsService.updateSavingAccountOne(saving);
    }

    public void deleteChecking(Long id){Repository.deleteChecking(id);}

    public Float getCheckingBalance() {
        return checkingRepository.getBalance();
    }
}
