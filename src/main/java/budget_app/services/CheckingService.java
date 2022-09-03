package budget_app.services;

import budget_app.models.Checking;
import budget_app.models.Savings;
import budget_app.repository.CheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CheckingService {
    @Autowired
    CheckingRepository checkingRepository;

    @Autowired
    SavingsService savingsService;

    public List<Checking> getAllChecking(){
        return checkingRepository.findAll();
    }

    public void addChecking(Checking checking){
        checkingRepository.save(checking);
        subtractNewTransactionFromSavings(checking);
    }

    public void subtractNewTransactionFromSavings(Checking checking) {
        Savings saving = savingsService.getSavingAccountOne();
        int currentBalance = saving.getCurrentAmount();
        saving.setCurrentAmount(currentBalance-checking.getAmount());
        savingsService.updateSavingAccountOne(saving);
    }

    public void deleteChecking(Long id){
        checkingRepository.deleteById(id);
    }

    public Float getCheckingBalance() {
        return checkingRepository.getBalance();
    }
}
