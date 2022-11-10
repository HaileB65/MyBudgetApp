package budget_app.controllers;

import budget_app.models.User;
import budget_app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public String viewUserPage(Model model) {
        final List<User> usersList = userService.getAllUsers();
        model.addAttribute("usersList", usersList);
        return "users";
    }

    @GetMapping("/new")
    public String showNewCustomerPage(Model model) {
        model.addAttribute("user", new User());
        return "new-user";
    }

    @PostMapping(value = "/save")
    public String saveCustomer(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/editUserInstructions")
    public String showHowToEditGoalPage() {
        return "how-to-edit-user";
    }

    @GetMapping("/editUser/{id}")
    public ModelAndView showEditCustomerPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit-user");
        User user = userService.findUserById(id);
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping("/updateUser/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
}
