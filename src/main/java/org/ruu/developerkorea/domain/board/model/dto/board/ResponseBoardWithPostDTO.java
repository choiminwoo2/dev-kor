package org.ruu.developerkorea.domain.board.model.dto.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.ruu.developerkorea.domain.board.model.dto.post.PostDTO;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@ToString
public class ResponseBoardWithPostDTO {

    private String boardName;
    private String boardDescription;
    private String boardUrl;

    private List<PostDTO> list;
}
