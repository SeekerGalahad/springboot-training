package com.springboot.training.controller;

import com.springboot.training.model.User;
import com.springboot.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Wagic
 * @Description:
 * @Date: 2019-04-26 15:39 by Wagic 创建
 */
@Controller
public class HelloController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String hello(ModelMap modelMap) {
        List<User> users = userService.getUsers();
        User user = users.get(0);
        modelMap.put("user", user);
        return "hello";
    }
    @RequestMapping("/index")
    public String index(ModelMap modelMap) {
        return "homepage/index";
    }
}
