/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller.admin;

import com.example.demo.model.Anuncio;
import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jtorr
 */

@RequestMapping("/admin/blog")
@Controller
public class BlogAdminController {
    
    @Autowired
    private BlogService blogService;
    
    @GetMapping({"","/"})
    public String anuncios(Model model){
        List<Blog> blogs = blogService.getBlogs();
        model.addAttribute("blog",blogs);
        return "admin/blog/index";
    }
    
}
