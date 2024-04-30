package org.ruu.developerkorea.domain.board.model.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.ruu.developerkorea.domain.board.domain.comment.Comment;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCommentDTO {

    private Long commentId;

    private String commentText;

    private String commentWriter;

    public static ResponseCommentDTO of(Comment comment) {
        return ResponseCommentDTO.builder()
                .commentId(comment.getId())
                .commentText(comment.getText())
                .commentWriter(comment.getWriter())
                .build();
    }

}
