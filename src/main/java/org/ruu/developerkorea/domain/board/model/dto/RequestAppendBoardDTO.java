package org.ruu.developerkorea.domain.board.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.ruu.developerkorea.domain.board.domain.Board;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestAppendBoardDTO {

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @NotNull
    @Size(min = 1, max = 1000)
    private String description;

    private String board_pwd;

}
