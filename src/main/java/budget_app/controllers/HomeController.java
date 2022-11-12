package budget_app.controllers;

import budget_app.models.Budget;
import budget_app.services.BudgetService;
import budget_app.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class HomeController {
    @Autowired
    BudgetService budgetService;

    @Autowired
    ReportService reportService;

    @GetMapping("/home")
    public String viewBudget(Model model) {
        Budget budget = budgetService.getBudgetById(1L);
        model.addAttribute("budget", budget);


        int oneTimePaymentCategoryTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("One Time Payment");
        model.addAttribute("oneTimePaymentCategoryActualValue", oneTimePaymentCategoryTotalFromLastMonth);

        int costOfRentTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Cost Of Rent");
        model.addAttribute("costOfRentActualValue", costOfRentTotalFromLastMonth);

        int fixedDebtPaymentTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Fixed Debt Payment");
        model.addAttribute("fixedDebtPaymentActualValue", fixedDebtPaymentTotalFromLastMonth);

        int weeklyCostOfGroceriesTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Weekly Cost Of Groceries");
        model.addAttribute("weeklyCostOfGroceriesActualValue", weeklyCostOfGroceriesTotalFromLastMonth);

        int weeklyCostOfEatingOutTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Weekly Cost Of Eating Out");
        model.addAttribute("weeklyCostOfEatingOutActualValue", weeklyCostOfEatingOutTotalFromLastMonth);

        int weeklyCostOfBeerWineTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Weekly Cost Of Beer Wine");
        model.addAttribute("weeklyCostOfBeerWineActualValue", weeklyCostOfBeerWineTotalFromLastMonth);

        int healthcareTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Healthcare");
        model.addAttribute("healthcareActualValue", healthcareTotalFromLastMonth);

        int childcareTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Childcare");
        model.addAttribute("childcareActualValue", childcareTotalFromLastMonth);

        int carInsuranceTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Car Insurance");
        model.addAttribute("carInsuranceActualValue", carInsuranceTotalFromLastMonth);

        int vehicleTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Vehicle");
        model.addAttribute("vehicleActualValue", vehicleTotalFromLastMonth);

        int gasTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Gas");
        model.addAttribute("gasActualValue", gasTotalFromLastMonth);

        int HVACTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("HVAC");
        model.addAttribute("HVACActualValue", HVACTotalFromLastMonth);

        int phoneTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Phone");
        model.addAttribute("phoneActualValue", phoneTotalFromLastMonth);

        int tvTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Tv");
        model.addAttribute("tvActualValue", tvTotalFromLastMonth);

        int travelCategoryTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Travel");
        model.addAttribute("travelActualValue", travelCategoryTotalFromLastMonth);

        int otherUtilitiesTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Other Utilities");
        model.addAttribute("otherUtilitiesActualValue", otherUtilitiesTotalFromLastMonth);

        int numberOfTimesYouEatOutTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Number Of Times You Eat Out");
        model.addAttribute("numberOfTimesYouEatOutActualValue", numberOfTimesYouEatOutTotalFromLastMonth);


        int expenseCalculation = budgetService.returnExpensesCalculation();
        model.addAttribute("expenseCalculation",expenseCalculation);

        int currentBalance = budgetService.returnCurrentBalance();
        model.addAttribute("currentBalance",currentBalance);

        return "home";
    }

    @GetMapping("/editBudget")
    public ModelAndView showEditBudgetPage() {
        ModelAndView mav = new ModelAndView("edit-budget");
        Budget budget = budgetService.getBudgetById(1L);
        mav.addObject("budget", budget);
        return mav;
    }

    @GetMapping("/editBudget/{id}")
    public ModelAndView showEditBudgetPage(@PathVariable(name = "id", value = "1") Long id) {
        ModelAndView mav = new ModelAndView("edit-budget");
        Budget budget = budgetService.getBudgetById(id);
        mav.addObject("budget", budget);
        return mav;
    }

    @PostMapping(value = "/saveBudget")
    public String saveBudget(@ModelAttribute("budget") Budget budget) {
        budgetService.saveBudget(budget);
        return "redirect:/home";
    }

    @RequestMapping("/updateBudget/{id}")
    public String updateBudget(@ModelAttribute("budget") Budget budget) {
        budgetService.saveBudget(budget);
        return "redirect:/home";
    }

    @GetMapping("/login")
    public String viewLoginPage(Model model) {
        return "login";
    }

    @GetMapping("/welcome")
    public String viewWelcome(Model model) {
        return "welcome";
    }

}
