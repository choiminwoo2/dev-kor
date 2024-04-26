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

    Long postId;
    String title;
    String content;
    String writer;
    LocalDate createdAt;
    LocalDate updatedAt;
}
