package com.feiyi.heritage.repository;

import com.feiyi.heritage.entity.PostFavorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostFavoriteRepository extends JpaRepository<PostFavorite, Long> {
    Optional<PostFavorite> findByPostIdAndUserId(Long postId, Long userId);
    boolean existsByPostIdAndUserId(Long postId, Long userId);
} 