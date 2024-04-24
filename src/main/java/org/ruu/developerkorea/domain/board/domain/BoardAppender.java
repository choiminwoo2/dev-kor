package org.ruu.developerkorea.domain.board.domain;

import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.model.dto.RequestAppendBoardDTO;
import org.ruu.developerkorea.domain.board.model.mapper.BoardMapper;
import org.ruu.developerkorea.domain.board.repository.BoardJdbcRepository;
import org.ruu.developerkorea.domain.board.repository.BoardRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BoardAppender {

    private final BoardJdbcRepository boardRepository;

    public void append(RequestAppendBoardDTO requestAppendBoardDTO) {

        Board board = BoardMapper.INSTANCE.requestAppendBoardToBoard(requestAppendBoardDTO);
        boardRepository.save(board);
    }
}
