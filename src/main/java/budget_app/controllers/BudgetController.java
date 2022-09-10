package budget_app.controllers;

import budget_app.models.Budget;
import budget_app.models.User;
import budget_app.services.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class BudgetController {
    @Autowired
    BudgetService budgetService;

    @GetMapping("/budget")
    public String viewBudget(Model model) {
        final Budget budget = budgetService.getBudgetById(1L);
        model.addAttribute("budget", budget);
        return "budget";
    }

    @GetMapping("/editBudget/{id}")
    public ModelAndView showEditBudgetPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit-budget");
        Budget budget = budgetService.getBudgetById(id);
        mav.addObject("budget", budget);
        return mav;
    }

    @PostMapping(value = "/saveBudget")
    public String saveBudget(@ModelAttribute("budget") Budget budget) {
        budgetService.saveBudget(budget);
        return "redirect:/budget";
    }
//
//    @RequestMapping("/deleteUser/{id}")
//    public String deleteUser(@PathVariable(name = "id") Long id) {
//        System.out.println(id);
//        userService.deleteUser(id);
//        return "redirect:/users";
//    }
}
