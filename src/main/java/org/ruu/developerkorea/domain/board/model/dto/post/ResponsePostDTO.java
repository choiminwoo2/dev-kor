package org.ruu.developerkorea.domain.board.model.dto.post;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import org.ruu.developerkorea.domain.board.domain.post.Post;
import org.ruu.developerkorea.domain.board.model.dto.board.ResponseBoardDTO;

import java.time.LocalDateTime;

@Getter
@Builder
public class ResponsePostDTO {
    private Long id;
    private ResponseBoardDTO responseBoardDTO;
    private String title;
    private String content;
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateAt;

    public static ResponsePostDTO of(Post post) {
        return ResponsePostDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .updateAt(LocalDateTime.now())
                .responseBoardDTO(ResponseBoardDTO.builder()
                        .name(post.getBoard().getName())
                        .description(post.getBoard().getDescription())
                        .build())
                .build();
    }

}
