package com.feiyi.heritage.controller;

import com.feiyi.heritage.entity.HeritageItem;
import com.feiyi.heritage.service.HeritageItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/heritage-items")
public class HeritageItemController {
    @Autowired
    private HeritageItemService heritageItemService;

    @GetMapping
    public ResponseEntity<List<HeritageItem>> getAllHeritageItems() {
        return ResponseEntity.ok(heritageItemService.getAllHeritageItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHeritageItemById(@PathVariable Long id) {
        return heritageItemService.getHeritageItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<HeritageItem>> getHeritageItemsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(heritageItemService.getHeritageItemsByCategory(category));
    }

    @GetMapping("/search")
    public ResponseEntity<List<HeritageItem>> searchHeritageItems(@RequestParam String keyword) {
        return ResponseEntity.ok(heritageItemService.searchHeritageItems(keyword));
    }

    @PostMapping
    public ResponseEntity<HeritageItem> createHeritageItem(@RequestBody HeritageItem heritageItem) {
        return ResponseEntity.ok(heritageItemService.createHeritageItem(heritageItem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HeritageItem> updateHeritageItem(@PathVariable Long id, @RequestBody HeritageItem heritageItem) {
        heritageItem.setId(id);
        return ResponseEntity.ok(heritageItemService.updateHeritageItem(heritageItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHeritageItem(@PathVariable Long id) {
        heritageItemService.deleteHeritageItem(id);
        return ResponseEntity.ok().build();
    }
} 