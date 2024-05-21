package org.ruu.developerkorea.domain.board.model.dto.board;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ResponseBoardDTO {

    private Long id;
    private String name;
    private String description;
    private String url;
    @JsonIgnore
    private String pwd;
}