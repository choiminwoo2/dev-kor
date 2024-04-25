package org.ruu.developerkorea.domain.board.model.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    Long postId;
    String title;
    String content;
    String writer;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
