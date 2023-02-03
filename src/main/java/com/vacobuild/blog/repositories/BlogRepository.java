package com.vacobuild.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vacobuild.blog.models.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    
}
