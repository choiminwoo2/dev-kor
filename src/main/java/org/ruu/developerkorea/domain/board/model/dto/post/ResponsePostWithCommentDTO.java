package org.ruu.developerkorea.domain.board.model.dto.post;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import org.ruu.developerkorea.domain.board.domain.comment.Comment;
import org.ruu.developerkorea.domain.board.domain.post.Post;
import org.ruu.developerkorea.domain.board.model.dto.board.ResponseBoardDTO;
import org.ruu.developerkorea.domain.board.model.dto.comment.ResponseCommentDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class ResponsePostWithCommentDTO {

    private Long id;
    private ResponseBoardDTO responseBoardDTO;
    private String title;
    private String content;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateAt;
    private List<ResponseCommentDTO> comments;
    public static ResponsePostWithCommentDTO of(Post post, List<Comment> comments) {
        List<ResponseCommentDTO> responseComments = comments.stream()
                .map(ResponseCommentDTO::of)
                .toList();

        return ResponsePostWithCommentDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .updateAt(LocalDateTime.now())
                .responseBoardDTO(ResponseBoardDTO.builder()
                        .name(post.getBoard().getName())
                        .description(post.getBoard().getDescription())
                        .build())
                .comments(responseComments)
                .build();
    }
}
