package org.ruu.developerkorea.domain.board.domain.board;

import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.repository.BoardJdbcRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BoardRemover {

    private final BoardJdbcRepository boardRepository;

    public void remove(Long id) {
        boardRepository.delete(id);
    }
}
