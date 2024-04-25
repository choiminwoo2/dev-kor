package org.ruu.developerkorea.domain.board.model.dto.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

@Getter
public class RequestUpdatePostDTO {
    @JsonIgnore
    private Long id;
    private String title;
    private String content;

    public void setId(Long id) {
        this.id = id;
    }
}
