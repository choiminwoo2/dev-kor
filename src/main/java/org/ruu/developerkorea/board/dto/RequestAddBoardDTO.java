package org.ruu.developerkorea.board.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.ruu.developerkorea.board.domain.Board;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestAddBoardDTO {

    @NotNull
    private String name;

    public static Board toEntity(final RequestAddBoardDTO requestAddBoardDTO) {
        return Board.builder()
                .name(requestAddBoardDTO.getName())
                .build();
    }
}
