package org.ruu.developerkorea.domain.board.model.dto.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.ruu.developerkorea.domain.board.model.dto.post.PostDTO;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
public class ResponseBoardWithPostDTO {

    String boardName;
    String boardDescription;

    List<PostDTO> list;

}
