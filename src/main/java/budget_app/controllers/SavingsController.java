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
        System.out.println(savings);
        savingsService.addSavings(savings);
        return "redirect:/savings";
    }

    @RequestMapping("/deleteSaving/{id}")
    public String deleteSaving(@PathVariable(name = "id") Long id) {
        System.out.println(id);
        savingsService.deleteSavings(id);
        return "redirect:/savings";
    }
}
