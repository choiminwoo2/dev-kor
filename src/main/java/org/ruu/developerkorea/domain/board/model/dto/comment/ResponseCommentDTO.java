package org.ruu.developerkorea.domain.board.model.dto.comment;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.ruu.developerkorea.domain.board.domain.comment.Comment;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCommentDTO {

    private Long commentId;

    private String commentText;

    private String commentWriter;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateAt;

    public static ResponseCommentDTO of(Comment comment) {
        return ResponseCommentDTO.builder()
                .commentId(comment.getId())
                .commentText(comment.getText())
                .commentWriter(comment.getWriter())
                .updateAt(comment.getUpdatedAt())
                .build();
    }

}
