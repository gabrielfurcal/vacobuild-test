package com.vacobuild.blog.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

import com.vacobuild.blog.DTOs.BlogDTO;
import com.vacobuild.blog.models.Blog;
import com.vacobuild.blog.repositories.BlogRepository;
import com.vacobuild.blog.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class BlogService {
    private final BlogRepository blogRepository;
    private final CategoryRepository categoryRepository;

    public List<BlogDTO> findAll() throws Exception {
        try {
            var dbBlogs = blogRepository.findAll();
            var blogs = new ArrayList<BlogDTO>();

            dbBlogs.forEach(blog -> blogs.add(BlogDTO.builder()
                                            .id(blog.getId())
                                            .title(blog.getTitle())
                                            .contents(blog.getContents())
                                            .timestamp(blog.getTimestamp())
                                            .categoryId(blog.getCategoryId())
                                            .build()));
                                            
            return blogs;
            
        } catch (Exception ex) {
            log.error("Error at getting blogs: {}", ex.getMessage());
            throw new Exception("Error at getting blogs");
        }
    }

    public BlogDTO findById(Long id) throws Exception {
        try {
            var dbBlog = blogRepository.findById(id).orElseThrow(() -> new Exception("Blog not found"));
            return BlogDTO.builder()
                    .id(dbBlog.getId())
                    .title(dbBlog.getTitle())
                    .contents(dbBlog.getContents())
                    .timestamp(dbBlog.getTimestamp())
                    .categoryId(dbBlog.getCategoryId())
                    .build();
        } catch (Exception ex) {
            log.error("Error at getting blog {}: {}", Long.toString(id), ex.getMessage());
            throw new Exception("Error at getting blog: " + Long.toString(id));
        }
    }

    public BlogDTO save(BlogDTO blog) throws Exception {
        return save(blog, null);
    }

    public BlogDTO save(BlogDTO blog, Long id) throws Exception {
        try {
            Blog commitedBlog;

            if(id != null) {
                var dbBlog = blogRepository.findById(id);
                

                if(!dbBlog.isPresent()) {
                    throw new Exception("Blog does not exist");
                } else {
                    var dbBlogObj = dbBlog.get();
                    dbBlogObj.setTitle(blog.getTitle());
                    dbBlogObj.setContents(blog.getContents());

                    var category = categoryRepository.findById(blog.getCategoryId()).get();
                    dbBlogObj.setCategory(category);

                    commitedBlog =  blogRepository.save(dbBlogObj);
                }
            } else {
                var category = categoryRepository.findById(blog.getCategoryId()).get();

                var blogToInsert = Blog.builder()
                                    .title(blog.getTitle())
                                    .contents(blog.getContents())
                                    .timestamp(new Date())
                                    .category(category)
                                    .build();

                    commitedBlog =  blogRepository.save(blogToInsert);
            }

            return BlogDTO.builder()
                    .id(commitedBlog.getId())
                    .title(commitedBlog.getTitle())
                    .contents(commitedBlog.getContents())
                    .timestamp(commitedBlog.getTimestamp())
                    .categoryId(commitedBlog.getCategory().getId())
                    .build();
        } catch (Exception ex) {
            if(id == null) {
                log.error("Error at saving new blog: {}", ex.getMessage());
                throw new Exception("Error at saving new blog");
            } else {
                log.error("Error at saving blog {}: {}", Long.toString(id), ex.getMessage());
                throw new Exception("Error at saving blog: " + Long.toString(id));
            }
        }
    }

    public void deleteById(Long id) throws Exception {
        try {
            blogRepository.deleteById(id);
        } catch (Exception ex) {
            log.error("Error at deleting blog {}: {}", Long.toString(id), ex.getMessage());
            throw new Exception("Error at deleting blog: " + Long.toString(id));
        }
    }

    public void deleteAll() throws Exception {
        try {
            blogRepository.deleteAll();
        } catch (Exception ex) {
            log.error("Error at deleting blogs: {}", ex.getMessage());
            throw new Exception("Error at deleting blogs");
        }
    }
}