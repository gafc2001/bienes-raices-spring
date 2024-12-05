package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> getBlogs(){
        return this.blogRepository.findAll();
    }
    
    public Optional<Blog> findBlogById(Long id){
        return blogRepository.findById(id);
    }
    
    public Blog save(Blog blog){
       return blogRepository.save(blog);
    }
    
    public void deleteById(Long id){
        blogRepository.deleteById(id);
    }
    
}
