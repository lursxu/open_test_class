package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xutu
 * @date 2020-07-30
 */
@Controller
public class MainController {


    /**
     * 跳转到首页页面
     */
    @GetMapping("/main")
    public String toMain(Model model) {
        return "/main";
    }

}
