package budget_app.services;

import budget_app.models.Goal;
import budget_app.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GoalService {
    public ArrayList<Goal> getAllGoals(){
        return Repository.returnAllGoals();
    }

    public void addGoal(Goal goal){
        Repository.addGoal(goal);
    }

    public void deleteGoal(Long id){Repository.deleteGoal(id);}
}
