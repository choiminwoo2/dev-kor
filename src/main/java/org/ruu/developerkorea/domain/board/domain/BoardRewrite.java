package org.ruu.developerkorea.domain.board.domain;

import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.model.dto.RequestUpdateBoardDTO;
import org.ruu.developerkorea.domain.board.model.mapper.BoardMapper;
import org.ruu.developerkorea.domain.board.repository.BoardJdbcRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BoardRewrite {

    private final BoardJdbcRepository boardRepository;


    public Long update(RequestUpdateBoardDTO requestUpdateBoardDTO) {
        return boardRepository.update(BoardMapper.INSTANCE.requestUpdateBoardDTOToBoard(requestUpdateBoardDTO));
    }
}
