package com.companionly.prototype.controllers;

import com.companionly.prototype.models.Post;
import com.companionly.prototype.models.User;
import com.companionly.prototype.data.UserRepository;
import com.companionly.prototype.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ForumViewController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserRepository userRepository;  // ✅ Corrected import

    // ✅ Mapping to load the forum page (fixes 404 error)
    @GetMapping("/forum")
    public String viewForum(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "forum";  // ✅ This must match forum.html in /templates
    }

    @PostMapping("/forum/addPost")
    public String createPost(@RequestParam String title,
                             @RequestParam String content,
                             @AuthenticationPrincipal UserDetails userDetails) {

        if (userDetails == null) {
            System.out.println("❌ UserDetails is NULL! Redirecting to login.");
            return "redirect:/login";  // Redirect to login if not authenticated
        }

        // ✅ Fetch the user from the database
        Optional<User> userOptional = userRepository.findByEmail(userDetails.getUsername());
        if (userOptional.isEmpty()) {
            return "redirect:/forum?error=user_not_found";
        }

        // ✅ Create and save the post
        Post post = new Post();
        post.setPostTitle(title);
        post.setPostContent(content);
        post.setUser(userOptional.get());  // ✅ Set the user for the post
        postService.createPost(post);

        return "redirect:/forum";
    }
}
