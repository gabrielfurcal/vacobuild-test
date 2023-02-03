package com.vacobuild.blog.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.vacobuild.blog.models.Category;
import com.vacobuild.blog.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> findAll() throws Exception {
        try {
            return categoryRepository.findAll();
        } catch (Exception ex) {
            log.error("Error at getting categories: {}", ex.getMessage());
            throw new Exception("Error at getting categories");
        }
    }
}
