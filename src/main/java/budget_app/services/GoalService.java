package budget_app.services;

import budget_app.models.Goal;
import budget_app.models.User;
import budget_app.repository.GoalRepository;
import budget_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoalService {
    @Autowired
    GoalRepository goalRepository;

    public List<Goal> getAllGoals(){
        return goalRepository.findAll();
    }

    public Goal getGoalById(Long id) { return goalRepository.getById(id);}

    public void saveGoal(Goal goal){
        goalRepository.save(goal);
    }

    public void deleteGoal(Long id){
        goalRepository.deleteById(id);
    }
}
