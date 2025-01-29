package org.example.blog.Repo;

import org.example.blog.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepo extends JpaRepository<Blog,Long> {
    Blog findByTitle(String title);
}
