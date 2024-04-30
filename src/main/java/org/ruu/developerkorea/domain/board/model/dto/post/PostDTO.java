package org.ruu.developerkorea.domain.board.model.dto.post;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostDTO {

    private Long postId;
    private String title;
    private String content;
    private String writer;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private int commentCount;
}
