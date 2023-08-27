package com.sheryians.major.Controller;


import com.sheryians.major.Repository.RoleRepository;
import com.sheryians.major.Repository.UserRepository;
import com.sheryians.major.global.GolbalDara;
import com.sheryians.major.model.Role;
import com.sheryians.major.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/login")
    public String login() {
        GolbalDara.cart.clear();
        return "login";
    }

    @GetMapping("/register")
    public String registerGet() {
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute("user") User user
            ,HttpServletRequest request) throws ServletException {

        String passwprd = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(passwprd));

       List<Role> roleList = new ArrayList<>();
        roleList.add(roleRepository.findById(2).get());

        user.setRoles(roleList);

        userRepository.save(user);
        request.login(user.getEmail(), passwprd);
        return  "redirect:/";

    }
}
