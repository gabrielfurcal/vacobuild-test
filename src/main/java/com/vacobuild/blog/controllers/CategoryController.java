package com.vacobuild.blog.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vacobuild.blog.models.Category;
import com.vacobuild.blog.services.CategoryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAllCategories() {
        try {
            return ResponseEntity.ok(categoryService.findAll());
        } catch(Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
}