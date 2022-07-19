package budget_app.services;

import budget_app.repository.Repository;

public class CheckingService {
    public void checkingAccountBalance(){
        Repository.printOutCheckingTable();


    }
}
