package org.ruu.developerkorea.domain.board.domain.board;

import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.model.dto.board.RequestUpdateBoardDTO;
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
