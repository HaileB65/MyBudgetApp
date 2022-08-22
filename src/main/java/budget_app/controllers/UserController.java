package budget_app.controllers;

import budget_app.models.User;
import budget_app.services.GoalService;
import budget_app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users") // users page endpoint
    public String vewUserPage(Model model) {
        // Here you call the service to retrieve all the savings accounts
        final List<User> usersList = userService.getAllUsers();
        // Once the customers are retrieved, you can store them in model and return it to the view
        model.addAttribute("usersList", usersList);
        return "users";
    }

    @GetMapping("/new")
    public String showNewCustomerPage(Model model) {
        // Here a new (empty) Customer is created and then sent to the view
//        Budget customer = new Budget();
        model.addAttribute("user", new User());
        return "new-customer";

    }

    @PostMapping(value = "/save")
    // As the Model is received back from the view, @ModelAttribute
    // creates a Customer based on the object you collected from
    // the HTML page above
    public String saveCustomer(@ModelAttribute("user") User user) {
        System.out.println(user);
        userService.addUser(user);
//        springBudgetService.saveCustomer(user);
        return "redirect:/users";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id) {
        System.out.println(id);
        userService.deleteUser(id);
        return "redirect:/users";
    }
//
//    @GetMapping("/edit/{id}")
//    // The path variable "id" is used to pull a customer from the database
//    public ModelAndView showEditCustomerPage(@PathVariable(name = "id") Long id) {
//        // Since the previous methods use Model, this one uses ModelAndView
//        // to get some experience using both. Model is more common these days,
//        // but ModelAndView accomplishes the same thing and can be useful in
//        // certain circumstances. The view name is passed to the constructor.
//        ModelAndView mav = new ModelAndView("edit-customer");
//        Customer customer = springBudgetService.getCustomer(id);
//        mav.addObject("customer", customer);
//        return mav;
//    }
//
//    @PostMapping("/update/{id}")
//    public String updateCustomer(@PathVariable(name = "id") Long id, @ModelAttribute("customer") Customer customer, Model model) {
//        if (!id.equals(customer.getId())) {
//            model.addAttribute("message",
//                    "Cannot update, customer id " + customer.getId()
//                            + " doesn't match id to be updated: " + id + ".");
//            return "error-page";
//        }
//        springBudgetService.saveCustomer(customer);
//        return "redirect:/";
//    }
//


}
