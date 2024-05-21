package org.ruu.developerkorea.domain.board.domain.board;

import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.model.dto.board.ResponseBoardDTO;
import org.ruu.developerkorea.domain.board.model.dto.board.ResponseBoardWithPostDTO;
import org.ruu.developerkorea.domain.board.repository.BoardJdbcRepository;
import org.ruu.developerkorea.domain.board.repository.BoardRepository;
import org.ruu.developerkorea.domain.board.repository.PostRepository;
import org.ruu.developerkorea.global.error.BusinessException;
import org.ruu.developerkorea.global.error.EntityNotFoundException;
import org.ruu.developerkorea.global.error.ErrorType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class BoardRetriever {

    private final BoardRepository boardRepository;

    public List<Board> retrieveBoard() {
        return boardRepository.findAll();
    }

    public ResponseBoardDTO retrieveBoardByUrl(String url) {
        Board board = boardRepository.findByUrl(url)
                .orElseThrow(() -> new EntityNotFoundException(ErrorType.ENTITY_NOT_FOUND));


        return ResponseBoardDTO.builder()
                .id(board.getId())
                .description(board.getDescription())
                .url(board.getUrl())
                .name(board.getName())
                .build();
    }
}
