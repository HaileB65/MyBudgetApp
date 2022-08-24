package budget_app.services;

import budget_app.models.User;
import budget_app.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    public ArrayList<User> getAllUsers(){
        return Repository.returnAllUsers();
    }

    public void addUser(User user){
        Repository.addUser(user);
    }

    public void deleteUser(Long id){Repository.deleteUser(id);}
}
