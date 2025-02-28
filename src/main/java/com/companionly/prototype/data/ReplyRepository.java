package com.companionly.prototype.data;

import com.companionly.prototype.models.Post;
import com.companionly.prototype.models.Reply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

    List<Reply> findByPost(Post post);
}
