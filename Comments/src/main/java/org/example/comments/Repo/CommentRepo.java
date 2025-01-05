package org.example.comments.Repo;

import org.example.comments.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Long> {

    List<Comment> findByParent(String parent); // Ensure the method name matches the field name in the entity
}