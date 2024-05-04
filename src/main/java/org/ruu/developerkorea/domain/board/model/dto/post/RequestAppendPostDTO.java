package org.ruu.developerkorea.domain.board.model.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class RequestAppendPostDTO {

    private String url;
    private String title;
    private String content;
    private String writer;
}
