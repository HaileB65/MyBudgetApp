package budget_app.controllers;

import budget_app.models.Checking;
import budget_app.services.CheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller
public class CheckingController {
    @Autowired
    CheckingService checkingService;

    @GetMapping("/checking")
    public String viewCheckingAccountPage(Model model) {
        final List<Checking> checkingList = checkingService.getAllChecking();
        model.addAttribute("checkingList", checkingList);
        return "checking";
    }

    @GetMapping("/newChecking")
    public String viewNewCheckingPage(Model model) {
        Checking checking = new Checking();
        model.addAttribute("checking", checking);
        return "new-checking";
    }

    @PostMapping(value = "/saveChecking")
    public String saveChecking(@ModelAttribute("checking") Checking checking) {
        checkingService.addChecking(checking);
        return "redirect:/checking";
    }

    @RequestMapping("/deleteChecking/{id}")
    public String deleteChecking(@PathVariable(name = "id") Long id) {
        checkingService.deleteChecking(id);
        return "redirect:/checking";
    }
}