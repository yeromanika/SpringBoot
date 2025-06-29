package springBoot.controller;

import springBoot.model.User;
import springBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("user", new User());
        return "users";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam Long id, Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("user", userService.getUserById(id));
        return "users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    // Пример нового endpoint'а
    @GetMapping("/by-email")
    @ResponseBody
    public User getUserByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }
}