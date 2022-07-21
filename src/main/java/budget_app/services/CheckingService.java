package budget_app.services;

import budget_app.models.Checking;
import budget_app.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CheckingService {
    public ArrayList<Checking> getAllChecking(){
        return Repository.returnAllChecking();
    }
}
