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

    public ArrayList<Checking> getAllChecking(){
        return Repository.returnAllChecking();
    }

    public void addChecking(Checking checking){
        Repository.addChecking(checking);
        subtractNewTransactionFromSavings(checking);
    }

    public void subtractNewTransactionFromSavings(Checking checking) {
//        int subtractingNewTransactionFromSavings = savings.currentAmount - checking.getAmount();
//        update savings.currentAmount;
    }


    public void deleteChecking(Long id){Repository.deleteChecking(id);}

    public Float getCheckingBalance() {
        return checkingRepository.getBalance();
    }
}
