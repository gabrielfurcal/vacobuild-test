package com.vacobuild.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vacobuild.blog.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
