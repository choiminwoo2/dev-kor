package org.ruu.developerkorea.domain.board.model.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.ruu.developerkorea.domain.board.domain.comment.Comment;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestAppenderCommentDTO {

    private Long postId;

    private String writer;

    private String text;

    public Comment toEntity(RequestAppenderCommentDTO dto){
        return Comment.builder()
                .text(dto.getText())
                .writer(dto.getWriter())
                .build();
    }

}
