package com.vacobuild.blog;

import java.util.Date;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.vacobuild.blog.DTOs.BlogDTO;
import com.vacobuild.blog.models.Blog;
import com.vacobuild.blog.models.Category;
import com.vacobuild.blog.repositories.BlogRepository;
import com.vacobuild.blog.repositories.CategoryRepository;
import com.vacobuild.blog.services.BlogService;

public class BlogService2Test {
    private BlogRepository blogRepository = Mockito.mock(BlogRepository.class);
    private CategoryRepository categoryRepository = Mockito.mock(CategoryRepository.class);

    @Test
    @DisplayName("Should find Category By ID")
    void shouldFindBlogById() {
        BlogService blogService = new BlogService(blogRepository, categoryRepository);
        Blog blog = new Blog(123L, "How to develop connections", "bla bla bla bla bla bla", new Date(), 1L, new Category(1L, "Social"));
        BlogDTO expectedBlogResponse = new BlogDTO(123L, "How to develop connections", "bla bla bla bla bla bla", new Date(), 1L);
        Mockito.when(blogRepository.findById(123L)).thenReturn(Optional.of(blog));

        try {
            BlogDTO actualBlogResponse = blogService.findById(123L);

            Assertions.assertThat(actualBlogResponse.getId()).isEqualTo(expectedBlogResponse.getId());
            Assertions.assertThat(actualBlogResponse.getTitle()).isEqualTo(expectedBlogResponse.getTitle());
        } catch(Exception ex) {

        }
    }
}
