package com.feiyi.heritage.service;

import com.feiyi.heritage.entity.Post;
import java.util.List;

public interface PostService {
    Post createPost(Post post);
    List<Post> getAllPosts();
    Post getPostById(Long id);
    Post updatePost(Post post);
    void deletePost(Long id);
    Post likePost(Long postId, Long userId);
    Post unlikePost(Long postId, Long userId);
    Post favoritePost(Long postId, Long userId);
    Post unfavoritePost(Long postId, Long userId);
    boolean isPostFavorited(Long postId, Long userId);
} 