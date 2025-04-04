package com.feiyi.heritage.service;

import com.feiyi.heritage.entity.HeritageItem;
import com.feiyi.heritage.repository.HeritageItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeritageItemService {
    @Autowired
    private HeritageItemRepository heritageItemRepository;

    public List<HeritageItem> getAllHeritageItems() {
        return heritageItemRepository.findAll();
    }

    public Optional<HeritageItem> getHeritageItemById(Long id) {
        return heritageItemRepository.findById(id);
    }

    public List<HeritageItem> getHeritageItemsByCategory(String category) {
        return heritageItemRepository.findByCategory(category);
    }

    public List<HeritageItem> searchHeritageItems(String keyword) {
        return heritageItemRepository.findByNameContaining(keyword);
    }

    public HeritageItem createHeritageItem(HeritageItem heritageItem) {
        return heritageItemRepository.save(heritageItem);
    }

    public HeritageItem updateHeritageItem(HeritageItem heritageItem) {
        return heritageItemRepository.save(heritageItem);
    }

    public void deleteHeritageItem(Long id) {
        heritageItemRepository.deleteById(id);
    }
} 