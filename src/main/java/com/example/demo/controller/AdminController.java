package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @GetMapping("administrador")
    public String administrador(){
        return "administrador";
    }

    @PostMapping("administrador")
    public String administrador(@RequestParam String username,
                                @RequestParam String password,
                                HttpServletRequest request,
                                Model model){
        if ("admin".equals(username) && "admin".equals(password)){
            HttpSession session= request.getSession();
            session.setAttribute("username",username);
            return "redirect:/dashboard";
        }else {
            model.addAttribute("error",true);
            return "administrador";
        }
    }
    @GetMapping("/dashboard")
    public String dashboard(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            model.addAttribute("username", session.getAttribute("username"));
            return "dashboard";
        }
        return "redirect:/administrador";
    }
}
