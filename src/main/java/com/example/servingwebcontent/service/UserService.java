package com.example.servingwebcontent.service;

import com.example.servingwebcontent.domain.Balance;
import com.example.servingwebcontent.domain.Role;
import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.repos.BalanceRepo;
import com.example.servingwebcontent.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@SessionAttributes({"user"})
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BalanceRepo balanceRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public Iterable<User> find() {
        Iterable<User> users = userRepo.findAll();
        return users;
    }

    public User findById(Long id) {
        return userRepo.findById(id).get();
    }

    public User saveUser(String fullName, String username, String password, String money, Map<String, String> form, User user) {
        user.setFullName(fullName);
        user.setUsername(username);
        user.setPassword(password);
        user.setMoney(Double.parseDouble(money));
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect((Collectors.toSet()));
        user.getRoles().clear();
        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        if (user.getRoles().contains(Role.USER) && user.getBalance() == null) {
            Balance balance = new Balance();
            balanceRepo.save(balance);
            user.setBalance(balance);
        }
        userRepo.save(user);

        return user;
    }
}
