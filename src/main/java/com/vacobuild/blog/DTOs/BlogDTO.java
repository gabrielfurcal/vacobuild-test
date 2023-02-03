package com.vacobuild.blog.DTOs;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlogDTO {
    private Long id;
    private String title;
    private String contents;
    private Date timestamp;
    private Long categoryId;
}
