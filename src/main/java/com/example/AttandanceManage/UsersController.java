package com.example.AttandanceManage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
}
