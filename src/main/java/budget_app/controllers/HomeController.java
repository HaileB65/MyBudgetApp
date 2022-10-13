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
        final Budget budget = budgetService.getBudgetById(1L);
        model.addAttribute("budget", budget);


        final int oneTimePaymentCategoryTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("One Time Payment");
        model.addAttribute("oneTimePaymentCategoryActualValue", oneTimePaymentCategoryTotalFromLastMonth);

        final int costOfRentTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Cost Of Rent");
        model.addAttribute("costOfRentActualValue", costOfRentTotalFromLastMonth);

        final int fixedDebtPaymentTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Fixed Debt Payment");
        model.addAttribute("fixedDebtPaymentActualValue", fixedDebtPaymentTotalFromLastMonth);

        final int weeklyCostOfGroceriesTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Weekly Cost Of Groceries");
        model.addAttribute("weeklyCostOfGroceriesActualValue", weeklyCostOfGroceriesTotalFromLastMonth);

        final int weeklyCostOfEatingOutTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Weekly Cost Of Eating Out");
        model.addAttribute("weeklyCostOfEatingOutActualValue", weeklyCostOfEatingOutTotalFromLastMonth);

        final int weeklyCostOfBeerWineTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Weekly Cost Of Beer Wine");
        model.addAttribute("weeklyCostOfBeerWineActualValue", weeklyCostOfBeerWineTotalFromLastMonth);

        final int healthcareTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Healthcare");
        model.addAttribute("healthcareActualValue", healthcareTotalFromLastMonth);

        final int childcareTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Childcare");
        model.addAttribute("childcareActualValue", childcareTotalFromLastMonth);

        final int carInsuranceTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Car Insurance");
        model.addAttribute("carInsuranceActualValue", carInsuranceTotalFromLastMonth);

        final int vehicleTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Vehicle");
        model.addAttribute("vehicleActualValue", vehicleTotalFromLastMonth);

        final int gasTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Gas");
        model.addAttribute("gasActualValue", gasTotalFromLastMonth);

        final int HVACTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("HVAC");
        model.addAttribute("HVACActualValue", HVACTotalFromLastMonth);

        final int phoneTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Phone");
        model.addAttribute("phoneActualValue", phoneTotalFromLastMonth);

        final int tvTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Tv");
        model.addAttribute("tvActualValue", tvTotalFromLastMonth);

        final int travelCategoryTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Travel");
        model.addAttribute("travelActualValue", travelCategoryTotalFromLastMonth);

        final int otherUtilitiesTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Other Utilities");
        model.addAttribute("otherUtilitiesActualValue", otherUtilitiesTotalFromLastMonth);

        final int numberOfTimesYouEatOutTotalFromLastMonth = reportService.getCategoryTotalFromLastMonth("Number Of Times You Eat Out");
        model.addAttribute("numberOfTimesYouEatOutActualValue", numberOfTimesYouEatOutTotalFromLastMonth);


        final int expenseCalculation = budgetService.returnExpensesCalculation();
        model.addAttribute("expenseCalculation",expenseCalculation);

        final int currentBalance = budgetService.returnCurrentBalance();
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
