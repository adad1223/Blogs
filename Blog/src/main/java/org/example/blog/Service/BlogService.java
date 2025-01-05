package org.example.blog.Service;

import org.example.blog.Model.Blog;
import org.example.blog.Repo.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
    @Autowired
    private BlogRepo blogRepo;
    public void addBlog(Blog blog) {
        blogRepo.save(blog);
    }

    public Iterable<Blog> getBlogs() {
        return blogRepo.findAll();
    }

    public String getBlog(String title) {
        Blog blog = blogRepo.findByTitle(title);
        return blog.getContent();
    }

    public void updateBlog(String title, Blog blog) {
        Blog blog1 = blogRepo.findByTitle(title);
        blog1.setContent(blog.getContent());
        blogRepo.save(blog1);
    }

    public void deleteBlog(String title) {
        Blog blog = blogRepo.findByTitle(title);
        blogRepo.delete(blog);
    }

}
