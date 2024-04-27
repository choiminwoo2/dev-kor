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

    private String name;
    private String description;
    @JsonIgnore
    private String pwd;
}
