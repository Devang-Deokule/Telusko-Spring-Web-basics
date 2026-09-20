package com.devang.SpringBootWeb1;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home() {
        System.out.println("Home method called");
        return "index";
    }

    @RequestMapping("add")
    public String add(@RequestParam("num1") int num, int num2, HttpSession session){

        int result = num + num2;

        session.setAttribute("result", result);

        return "result";
    }

}
