package Geek.Blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    private Long comment_id = null;
    private String contents;
    private Long post_id;
    private Long author_id;
}
