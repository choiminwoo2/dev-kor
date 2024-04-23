package org.ruu.developerkorea.domain.board.service;


import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.domain.BoardAppender;
import org.ruu.developerkorea.domain.board.dto.RequestAddBoardDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardAppender boardAppender;

    public void insertBoard(RequestAddBoardDTO requestAddBoardDTO) {
        boardAppender.append(requestAddBoardDTO);
    }
}
