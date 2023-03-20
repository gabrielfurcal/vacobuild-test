package com.vacobuild.blog;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.vacobuild.blog.services.BlogService;

public class BlogServiceTest {
    @Test
    @DisplayName("Test should pass when comment do not contains swear words")
    void shouldNotContainSwearWordsInsideComment() {
        BlogService blogService = new BlogService(null, null);
        Assertions.assertFalse(blogService.containsSwearWords("This is a clean comment"));
    }

    @Test
    @DisplayName("Test should pass when comment do not contains swear words")
    void shouldFailWhenCommentContainsSwearWords() {
        BlogService blogService = new BlogService(null, null);
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            blogService.containsSwearWords("This is shitty comment");
        });
        assertTrue(exception.getMessage().contains("Comments contains unacceptable language"));
    }
}
