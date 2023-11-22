package com.example.BlogPost.controller;

import com.example.BlogPost.DTO.BlogDTO;
import com.example.BlogPost.entity.Blog;
import com.example.BlogPost.service.BlogService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/{blogId}")
    public Blog viewBlog(@PathVariable Integer blogId) {
        return blogService.viewBlog(blogId).orElseThrow(() -> new EntityNotFoundException("Invaild ID"));
    }

    @PatchMapping("/{blogId}")
    public Blog editBlog(@PathVariable Integer blogId, @RequestBody BlogDTO form) {  // @PathVariable 및 @RequestBody 사용
        Blog blog = blogService.viewBlog(blogId).orElseThrow(() -> new EntityNotFoundException("Invaild ID"));
        if (form.getBlog_name() == null) {
            throw new EntityNotFoundException("Invalid Input");
        } else if (form.getBlog_name().isBlank()){
            throw new EntityNotFoundException("Invalid Input");
        }

        blog.setBlog_name(form.getBlog_name());
        blog.setAbout_blog(form.getAbout_blog());
        blog.setProfilePicture(form.getProfilePicture());

        blogService.editBlog(blog);
        return blog;
    }
}
