package org.ruu.developerkorea.domain.board.domain.board;

import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.model.dto.board.ResponseBoardDTO;
import org.ruu.developerkorea.domain.board.repository.BoardJdbcRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class BoardRetriever {

    private final BoardJdbcRepository boardRepository;


    public List<Board> retrieveBoard() {
        return boardRepository.findAll();
    }

    public ResponseBoardDTO retrieveBoardByName(String name) {
        return boardRepository.findByName(name);
    }
}
