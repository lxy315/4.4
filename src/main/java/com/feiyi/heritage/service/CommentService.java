package com.feiyi.heritage.service;

import com.feiyi.heritage.entity.Comment;
import java.util.List;

public interface CommentService {
    Comment createComment(Comment comment);
    List<Comment> getCommentsByPostId(Long postId);
    Comment getCommentById(Long id);
    Comment updateComment(Comment comment);
    void deleteComment(Long id);
} 