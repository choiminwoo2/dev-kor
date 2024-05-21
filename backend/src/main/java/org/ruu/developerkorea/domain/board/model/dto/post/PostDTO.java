package org.ruu.developerkorea.domain.board.model.dto.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@ToString
public class PostDTO {

    private Long postId;
    private String title;
    private String content;
    private String writer;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd")
    private LocalDateTime updatedAt;
    private Long commentCount;

    public PostDTO(Long postId, String title, String content, String writer, LocalDateTime updatedAt, Long commentCount) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.updatedAt = updatedAt;
        this.commentCount = commentCount;
    }

    public PostDTO() {
    }
}
