package org.ruu.developerkorea.domain.board.service;


import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.domain.BoardAppender;
import org.ruu.developerkorea.domain.board.model.dto.RequestAppendBoardDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardAppender boardAppender;

    public void insertBoard(RequestAppendBoardDTO requestAppendBoardDTO) {
        boardAppender.append(requestAppendBoardDTO);
    }
}
