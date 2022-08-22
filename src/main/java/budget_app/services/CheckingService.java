package budget_app.services;

import budget_app.models.Checking;
import budget_app.models.Savings;
import budget_app.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CheckingService {
    public ArrayList<Checking> getAllChecking(){
        return Repository.returnAllChecking();
    }

    public void addChecking(Checking checking){
        Repository.addChecking(checking);
    }

    public void deleteChecking(Long id){Repository.deleteChecking(id);}
}
