package org.example.blog.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.blog.Model.Blog;
import org.example.blog.Repo.BlogRepo;
import org.example.blog.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Enumeration;

//import static jdk.internal.net.http.common.Log.logHeaders;

@Controller
@RequestMapping
public class BlogController {
    @Autowired
    private BlogService blogService;
//    @Autowired
//    private BlogRepo blogRepo;
    @PostMapping("/blogs")
    public ResponseEntity<String> addBlog(@RequestBody Blog blog, @RequestHeader("loggedinuser") String loggedinuser) {
        blog.setEmail(loggedinuser);
        blogService.addBlog(blog);
        return ResponseEntity.ok("Blog added successfully");
    }
    @GetMapping("/blogs")
    public ResponseEntity<Iterable<Blog>> getBlogs() {
        return ResponseEntity.ok(blogService.getBlogs());
    }
    @GetMapping("/blogs/{title}")
    public ResponseEntity<String> getBlog(@PathVariable String title) {
        return ResponseEntity.ok(blogService.getBlog(title));
    }
    @PutMapping("/blogs/{title}")
    public ResponseEntity<String> updateBlog(@PathVariable String title, @RequestBody Blog blog) {
        blogService.updateBlog(title, blog);
        return ResponseEntity.ok("Blog updated successfully");
    }
    @DeleteMapping("/blogs/{title}")
    public ResponseEntity<String> deleteBlog(@PathVariable String title) {
        blogService.deleteBlog(title);
        return ResponseEntity.ok("Blog deleted successfully");
    }
}
