package com.companionly.prototype.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatPageController {

    @GetMapping("/chat")
    public String showChatPage() {
        return "chat";  // Refers to chat.html in src/main/resources/templates/
    }
}