package com.companionly.prototype.controllers;

import com.companionly.prototype.models.Post;
import com.companionly.prototype.models.Reply;
import com.companionly.prototype.models.User;
import com.companionly.prototype.services.PostService;
import com.companionly.prototype.services.ReplyService;
import com.companionly.prototype.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/forum/post")
public class PostDetailController {

    @Autowired
    private PostService postService;

    @Autowired
    private ReplyService replyService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public String viewPost(@PathVariable Long id, Model model) {
        Optional<Post> post = postService.getPostById(id);
        post.ifPresent(value -> model.addAttribute("post", value));
        return post.isPresent() ? "post" : "redirect:/forum";
    }

    @PostMapping("/addReply")
    public String addReply(@RequestParam Long postId,
                           @RequestParam String content,
                           @AuthenticationPrincipal UserDetails userDetails) {

        if (userDetails == null) {
            return "redirect:/login"; // Redirect to login if not authenticated
        }

        Optional<Post> postOptional = postService.getPostById(postId);
        Optional<User> userOptional = userRepository.findByEmail(userDetails.getUsername());

        if (postOptional.isEmpty() || userOptional.isEmpty()) {
            return "redirect:/forum?error=invalid_data";
        }

        // ✅ Set post, user, and content
        Reply reply = new Reply();
        reply.setPost(postOptional.get());
        reply.setUser(userOptional.get());  // 🛠 Attach the user
        reply.setReplyContent(content);

        replyService.addReply(reply);  // ✅ Save reply

        return "redirect:/forum/post/" + postId;
    }
}
