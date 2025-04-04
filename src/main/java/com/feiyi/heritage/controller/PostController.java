package com.feiyi.heritage.controller;

import com.feiyi.heritage.entity.Post;
import com.feiyi.heritage.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "*")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(postService.createPost(post));
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
        post.setId(id);
        return ResponseEntity.ok(postService.updatePost(post));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/like")
    public ResponseEntity<Post> likePost(@PathVariable Long id, @RequestParam Long userId) {
        return ResponseEntity.ok(postService.likePost(id, userId));
    }

    @PostMapping("/{id}/unlike")
    public ResponseEntity<Post> unlikePost(@PathVariable Long id, @RequestParam Long userId) {
        return ResponseEntity.ok(postService.unlikePost(id, userId));
    }

    @PostMapping("/{id}/favorite")
    public ResponseEntity<Post> favoritePost(@PathVariable Long id, @RequestParam Long userId) {
        return ResponseEntity.ok(postService.favoritePost(id, userId));
    }

    @PostMapping("/{id}/unfavorite")
    public ResponseEntity<Post> unfavoritePost(@PathVariable Long id, @RequestParam Long userId) {
        return ResponseEntity.ok(postService.unfavoritePost(id, userId));
    }

    @GetMapping("/{id}/favorite")
    public ResponseEntity<Boolean> isPostFavorited(@PathVariable Long id, @RequestParam Long userId) {
        return ResponseEntity.ok(postService.isPostFavorited(id, userId));
    }
} 