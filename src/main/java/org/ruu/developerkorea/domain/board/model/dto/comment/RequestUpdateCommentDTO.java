package org.ruu.developerkorea.domain.board.model.dto.comment;

import lombok.Builder;
import lombok.Getter;
import org.ruu.developerkorea.domain.board.domain.comment.Comment;

@Getter
@Builder
public class RequestUpdateCommentDTO {

    private Long postId;
    private Long commentId;
    private String text;

}
