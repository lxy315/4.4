package com.feiyi.heritage.repository;

import com.feiyi.heritage.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT c FROM Comment c WHERE c.post.id = ?1 ORDER BY c.createTime DESC")
    List<Comment> findByPostIdOrderByCreateTimeDesc(Long postId);
} 