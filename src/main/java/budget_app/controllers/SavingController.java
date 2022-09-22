package budget_app.controllers;

import budget_app.models.Saving;
import budget_app.services.SavingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@org.springframework.stereotype.Controller
public class SavingController {
    @Autowired
    SavingService savingService;

    @GetMapping("/savings")
    public String viewSavingPage(Model model) {
        final List<Saving> savingList = savingService.getAllSavings();
        model.addAttribute("savingList", savingList);

        final Float savingBalance  = savingService.getSavingBalance();
        model.addAttribute("savingBalance", savingBalance);
        return "saving";
    }

    @GetMapping("/newSaving")
    public String showNewSavingPage(Model model) {
        Saving savings = new Saving();
        model.addAttribute("saving", savings);
        return "new-saving";

    }
    
    @PostMapping(value = "/saveSaving")
    public String saveSaving(@ModelAttribute("saving") Saving savings) {
        savingService.addSaving(savings);
        return "redirect:/saving";
    }

    @RequestMapping("/deleteSaving/{id}")
    public String deleteSaving(@PathVariable(name = "id") Long id) {
        savingService.deleteSaving(id);
        return "redirect:/saving";
    }

    @GetMapping("/editSaving/{id}")
    public ModelAndView showEditSavingPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit-saving");
        Saving saving = savingService.getSavingById(id);
        mav.addObject("saving", saving);
        return mav;
    }

    @RequestMapping("/updateSaving/{id}")
    public String updateSaving(@ModelAttribute("saving") Saving saving) {
        savingService.addSaving(saving);
        return "redirect:/savings";
    }
}
