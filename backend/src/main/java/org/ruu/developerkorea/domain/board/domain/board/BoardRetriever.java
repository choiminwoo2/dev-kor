package org.ruu.developerkorea.domain.board.domain.board;

import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.model.dto.board.ResponseBoardWithPostDTO;
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

    public ResponseBoardWithPostDTO retrieveBoardByUrl(String url) {
        return boardRepository.findByUrl(url);
    }
}
