package budget_app.controllers;

import budget_app.models.Goal;
import budget_app.services.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller
public class GoalController {
    @Autowired
    GoalService goalService;

    @GetMapping("/goals")
    public String vewGoalPage(Model model) {
        final List<Goal> goalsList = goalService.getAllGoals();
        model.addAttribute("goalsList", goalsList);
        return "goals";
    }

    @GetMapping("/newGoal")
    public String showNewGoalPage(Model model) {
        Goal goal = new Goal();
        model.addAttribute("goal", goal);
        return "new-goal";
    }

    @PostMapping(value = "/saveGoal")
    public String saveGoal(@ModelAttribute("goal") Goal goal) {
        System.out.println(goal);
        goalService.addGoal(goal);
        return "redirect:/goals";
    }

    @RequestMapping("/deleteGoal/{id}")
    public String deleteGoal(@PathVariable(name = "id") Long id) {
        System.out.println(id);
        goalService.deleteGoal(id);
        return "redirect:/goals";
    }
}
