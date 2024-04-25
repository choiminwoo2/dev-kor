package org.ruu.developerkorea.domain.board.model.dto.board;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestUpdateBoardDTO {

    @NotNull
    private Long id;

    @Size(min = 2, max = 200)
    private String description;

    //TODO 커스텀 Validation 만들어야합니다.
    private String pwd;
}
