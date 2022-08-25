package budget_app.controllers;

import budget_app.models.Budget;
import budget_app.models.User;
import budget_app.services.BudgetService;
import budget_app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@org.springframework.stereotype.Controller
public class BudgetController {
    @Autowired
    BudgetService budgetService;

    @GetMapping("/budget") //
    public String viewBudget(Model model) {
        final List<Budget> budgetList = budgetService.getAllBudgets();
        model.addAttribute("budgetList", budgetList);
        return "budget";
    }

    @GetMapping("/edit/{id}")
    // The path variable "id" is used to pull a customer from the database
    public ModelAndView showEditCustomerPage(@PathVariable(name = "id") Long id) {
        // Since the previous methods use Model, this one uses ModelAndView
        // to get some experience using both. Model is more common these days,
        // but ModelAndView accomplishes the same thing and can be useful in
        // certain circumstances. The view name is passed to the constructor.
        ModelAndView mav = new ModelAndView("edit-budget");
//        Budget budget = budgetService.getBudget(id);
//        mav.addObject("budget", budget);
        return mav;
    }
//
//    @PostMapping(value = "/save")
//    public String saveCustomer(@ModelAttribute("user") User user) {
//        System.out.println(user);
//        userService.addUser(user);
//        return "redirect:/users";
//    }
//
//    @RequestMapping("/deleteUser/{id}")
//    public String deleteUser(@PathVariable(name = "id") Long id) {
//        System.out.println(id);
//        userService.deleteUser(id);
//        return "redirect:/users";
//    }
}
