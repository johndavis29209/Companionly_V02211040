package com.companionly.prototype.services;

import com.companionly.prototype.models.Post;
import com.companionly.prototype.models.Reply;
import com.companionly.prototype.data.ReplyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    public List<Reply> getRepliesForPost(Post post) {
        return replyRepository.findByPost(post);
    }

    public Reply addReply(Reply reply) {
        return replyRepository.save(reply);
    }

    public void deleteReply(Long id) {
        replyRepository.deleteById(id);
    }
}
