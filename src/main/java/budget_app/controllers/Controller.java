package budget_app.controllers;

import budget_app.models.Budget;
import budget_app.models.Checking;
import budget_app.services.CheckingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
//    @Autowired
//    SpringBudgetService springBudgetService;

    @Autowired
    CheckingService checkingService;

//    @Autowired
//    RentalCarService rentalCarService;

//    public Controller(CustomerService customerService, RentalCarService rentalCarService) {
//        this.customerService = customerService;
//        this.rentalCarService = rentalCarService;
//    }

    @GetMapping("/checking") // checking home endpoint
    public String vewCheckingHomePage(Model model) {
        // Here you call the service to retrieve all the customers
        final List<Checking> checkingList = checkingService.getAllChecking();
        // Once the customers are retrieved, you can store them in model and return it to the view
        model.addAttribute("checkingList", checkingList);
        return "checking";
    }
//
//    @GetMapping("/new")
//    public String showNewCustomerPage(Model model) {
//        // Here a new (empty) Customer is created and then sent to the view
//        Budget customer = new Budget();
//        model.addAttribute("budget", customer);
//        return "new-customer";
//
//    }
//
//    @PostMapping(value = "/save")
//    // As the Model is received back from the view, @ModelAttribute
//    // creates a Customer based on the object you collected from
//    // the HTML page above
//    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
//        springBudgetService.saveCustomer(customer);
//        return "redirect:/";
//    }
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
//    @RequestMapping("/delete/{id}")
//    public String deleteCustomer(@PathVariable(name = "id") Long id) {
//        springBudgetService.deleteCustomer(id);
//        return "redirect:/";
//    }

}