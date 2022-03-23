package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.domain.Balance;
import com.example.servingwebcontent.domain.Role;
import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.repos.BalanceRepo;
import com.example.servingwebcontent.repos.UserRepo;
import com.example.servingwebcontent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userService.find());
        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@RequestParam Long id, Model model) {
        model.addAttribute("userToEdit", userService.findById(id));
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String fullName,
            @RequestParam String money,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user,
            @RequestParam("userCur") User curUser,
            Model model) {
        User newUser = userService.saveUser(fullName, username, password, money, form, user);
        if (curUser.getRoles().contains(Role.ADMIN)) {
            return "redirect:/user";
        } else {
            model.addAttribute("user", newUser);
            return "myPage";
        }
    }
}
