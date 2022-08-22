package budget_app.controllers;

import budget_app.models.Savings;
import budget_app.services.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class HomeController {
    @Autowired
    SavingsService savingsService;

    @GetMapping("/home")
    public String vewHomePage(Model model) {
        final List<Savings> savingsList = savingsService.getAllSavings();
        model.addAttribute("savingsList", savingsList);
        return "home";
    }
}
