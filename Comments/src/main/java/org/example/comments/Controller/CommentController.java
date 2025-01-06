package org.example.comments.Controller;


import org.example.comments.Model.Comment;
import org.example.comments.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CommentController {

    @Autowired
    private CommentService commentService;

    // Add a new comment
    @PostMapping("/comments")
    public Comment addComment(@RequestBody Comment comment,@RequestHeader("loggedinuser") String loggedinuser) {
        comment.setEmail(loggedinuser);
        return commentService.addComment(comment);
    }

    // Get comments for a specific blog post
    @GetMapping("/comments/{post_id}")
    public List<Comment> getCommentsByPostId(@PathVariable("post_id") String postId) {
        return commentService.getCommentsByPostId(postId);
    }
}
