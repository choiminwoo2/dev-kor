package org.ruu.developerkorea.domain.board.domain;

import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.dto.RequestAddBoardDTO;
import org.ruu.developerkorea.domain.board.repository.BoardRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BoardAppender {

    private final BoardRepository boardRepository;

    public void append(RequestAddBoardDTO requestAddBoardDTO) {

        boardRepository.save(RequestAddBoardDTO.toEntity(requestAddBoardDTO));
    }
}
