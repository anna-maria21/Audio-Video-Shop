package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.service.FilmService;
import com.example.servingwebcontent.service.MusicService;
import com.example.servingwebcontent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @Autowired
    MusicService musicService;

    @Autowired
    FilmService filmService;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String home(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("musics", musicService.find(null));
        model.addAttribute("films", filmService.find(null));
        model.addAttribute("user", user);
        return "home";
    }

    @GetMapping("/my")
    public String getMyPage(@AuthenticationPrincipal User user,/* @RequestParam HttpSession httpSession,*/ Model model) {
        model.addAttribute("user",  userService.findById(user.getId()));
        return "myPage";
    }
}
