package org.ruu.developerkorea.domain.board.domain;

import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.model.dto.RequestAppendBoardDTO;
import org.ruu.developerkorea.domain.board.model.mapper.BoardMapper;
import org.ruu.developerkorea.domain.board.repository.BoardJdbcRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BoardAppender {

    private final BoardJdbcRepository boardRepository;

    public Long append(RequestAppendBoardDTO requestAppendBoardDTO) {

        Board board = BoardMapper.INSTANCE.requestAppendBoardDTOToBoard(requestAppendBoardDTO);
        return boardRepository.save(board);
    }
}
