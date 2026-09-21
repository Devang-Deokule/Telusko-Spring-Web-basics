package com.devang.SpringBootWeb1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home() {
        System.out.println("Home method called");
        return "index";
    }

    @RequestMapping("add")
    public ModelAndView add(@RequestParam("num1") int num, int num2, ModelAndView mv){

        int result = num + num2;

        mv.addObject("result", result);
        mv.setViewName("result");

        return mv;
    }

}
