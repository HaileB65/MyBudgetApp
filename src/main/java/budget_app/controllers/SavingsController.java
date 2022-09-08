package budget_app.controllers;

import budget_app.models.Savings;
import budget_app.services.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller
public class SavingsController {
    @Autowired
    SavingsService savingsService;

    @GetMapping("/savings")
    public String viewSavingsPage(Model model) {
        final List<Savings> savingsList = savingsService.getAllSavings();
        model.addAttribute("savingsList", savingsList);

        final Float savingBalance  = savingsService.getSavingBalance();
        model.addAttribute("savingBalance", savingBalance);
        return "savings";
    }

    @GetMapping("/newSavings")
    public String showNewSavingsPage(Model model) {
        Savings savings = new Savings();
        model.addAttribute("savings", savings);
        return "new-savings";

    }
    
    @PostMapping(value = "/saveSavings")
    public String saveSavings(@ModelAttribute("savings") Savings savings) {
        savingsService.addSavings(savings);
        return "redirect:/savings";
    }

    @RequestMapping("/deleteSavings/{id}")
    public String deleteSavings(@PathVariable(name = "id") Long id) {
        savingsService.deleteSavings(id);
        return "redirect:/savings";
    }
}
