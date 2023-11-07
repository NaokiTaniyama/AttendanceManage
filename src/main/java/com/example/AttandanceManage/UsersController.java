package com.example.AttandanceManage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
public class UsersController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public String index(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }

    @GetMapping("/users/add")
    public String add(Model model){
        return "add";
    }

    @PostMapping("/users/create")
    public String create(@ModelAttribute User user, @RequestParam("userName") String userName,
                               @RequestParam("password") String password,
                                @RequestParam("roleList") String roleList,Model model){
        //フォームから受け取った値をuserクラスに入れる
        user.setName(userName);
        user.setPassword(password);
        user.setRole(roleList);
        userRepository.insert(user);
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }

    @GetMapping("/users/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("Hello", "こんにちは");
        model.addAttribute("user", userRepository.findById(id));
        return "edit";
    }

    @PostMapping("/users/update/{id}")
    public String update(@ModelAttribute User user,  @RequestParam("userName") String userName,
                         @RequestParam("password") String password,
                         @RequestParam("roleList") String roleList,@PathVariable int id, Model model){
        user.setName(userName);
        user.setPassword(password);
        user.setRole(roleList);
        user.setId(id);
        userRepository.update(user);
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }


}
