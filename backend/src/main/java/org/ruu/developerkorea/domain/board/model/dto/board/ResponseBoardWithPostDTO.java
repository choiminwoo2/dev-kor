package org.ruu.developerkorea.domain.board.model.dto.board;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.ruu.developerkorea.domain.board.domain.board.Category;
import org.ruu.developerkorea.domain.board.model.dto.post.PostDTO;

import java.util.List;

@Builder
@Getter
@ToString
@AllArgsConstructor
public class ResponseBoardWithPostDTO {

    private String boardName;
    private String boardDescription;
    private String boardUrl;

    private List<PostDTO> list;


}
