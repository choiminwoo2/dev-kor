package org.ruu.developerkorea.domain.board.model.dto.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import org.ruu.developerkorea.domain.board.domain.comment.Comment;

@Getter
@Builder
public class RequestUpdateCommentDTO {

    @JsonIgnore
    private Long postId;
    private Long commentId;
    private String text;

}
