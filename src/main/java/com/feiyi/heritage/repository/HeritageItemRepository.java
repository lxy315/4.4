package com.feiyi.heritage.repository;

import com.feiyi.heritage.entity.HeritageItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeritageItemRepository extends JpaRepository<HeritageItem, Long> {
    List<HeritageItem> findByCategory(String category);
    List<HeritageItem> findByNameContaining(String name);
} 