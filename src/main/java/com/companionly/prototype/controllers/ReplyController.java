package com.companionly.prototype.controllers;

import com.companionly.prototype.models.Post;
import com.companionly.prototype.models.Reply;
import com.companionly.prototype.services.PostService;
import com.companionly.prototype.services.ReplyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/replies")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @Autowired
    private PostService postService;

    @GetMapping("/{postId}")
    public ResponseEntity<List<Reply>> getRepliesForPost(@PathVariable Long postId) {
        Optional<Post> post = postService.getPostById(postId);
        return post.map(value -> ResponseEntity.ok(replyService.getRepliesForPost(value)))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Reply> addReply(@RequestBody Reply reply) {
        Reply createdReply = replyService.addReply(reply);
        return new ResponseEntity<>(createdReply, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReply(@PathVariable Long id) {
        replyService.deleteReply(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
