package com.vacobuild.blog.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vacobuild.blog.DTOs.BlogDTO;
import com.vacobuild.blog.services.BlogService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/posts/")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @GetMapping
    public ResponseEntity<List<BlogDTO>> findAllBlogs() {
        try {
            return ResponseEntity.ok(blogService.findAll());
        } catch(Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("{blogId}")
    public ResponseEntity<BlogDTO> findAllBlogs(@PathVariable("blogId") Long id) {
        try {
            return ResponseEntity.ok(blogService.findById(id));
        } catch(Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<BlogDTO> createBlog(@RequestBody BlogDTO blog) {
        try {
            return ResponseEntity.ok(blogService.save(blog));
        } catch(Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("{blogId}")
    public ResponseEntity<BlogDTO> editBlog(@RequestBody BlogDTO blog, @PathVariable("blogId") Long id) {
        try {
            return ResponseEntity.ok(blogService.save(blog, id));
        } catch(Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllBlogs() {
        try {
            blogService.deleteAll();
            return ResponseEntity.ok().build();
        } catch(Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("{blogId}")
    public ResponseEntity<?> deleteBlogById(@PathVariable("blogId") Long id) {
        try {
            blogService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch(Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
