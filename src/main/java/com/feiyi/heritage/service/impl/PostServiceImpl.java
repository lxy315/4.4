package com.feiyi.heritage.service.impl;

import com.feiyi.heritage.entity.Post;
import com.feiyi.heritage.entity.PostFavorite;
import com.feiyi.heritage.entity.User;
import com.feiyi.heritage.repository.PostFavoriteRepository;
import com.feiyi.heritage.repository.PostRepository;
import com.feiyi.heritage.repository.UserRepository;
import com.feiyi.heritage.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostFavoriteRepository postFavoriteRepository;

    @Override
    @Transactional
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAllOrderByCreateTimeDesc();
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("帖子不存在"));
    }

    @Override
    @Transactional
    public Post updatePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    @Transactional
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Post likePost(Long postId, Long userId) {
        Post post = getPostById(postId);
        post.setLikes(post.getLikes() + 1);
        return postRepository.save(post);
    }

    @Override
    @Transactional
    public Post unlikePost(Long postId, Long userId) {
        Post post = getPostById(postId);
        if (post.getLikes() > 0) {
            post.setLikes(post.getLikes() - 1);
            return postRepository.save(post);
        }
        return post;
    }

    @Override
    @Transactional
    public Post favoritePost(Long postId, Long userId) {
        Post post = getPostById(postId);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("用户不存在"));

        if (!postFavoriteRepository.existsByPostIdAndUserId(postId, userId)) {
            PostFavorite favorite = new PostFavorite();
            favorite.setPost(post);
            favorite.setUser(user);
            postFavoriteRepository.save(favorite);
        }

        return post;
    }

    @Override
    @Transactional
    public Post unfavoritePost(Long postId, Long userId) {
        Post post = getPostById(postId);
        postFavoriteRepository.findByPostIdAndUserId(postId, userId)
                .ifPresent(postFavoriteRepository::delete);
        return post;
    }

    @Override
    public boolean isPostFavorited(Long postId, Long userId) {
        return postFavoriteRepository.existsByPostIdAndUserId(postId, userId);
    }
} 