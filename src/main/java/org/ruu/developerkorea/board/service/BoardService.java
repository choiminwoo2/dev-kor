package org.ruu.developerkorea.board.service;


import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.board.domain.BoardAppender;
import org.ruu.developerkorea.board.dto.RequestAddBoardDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardAppender boardAppender;

    public void insertBoard(RequestAddBoardDTO requestAddBoardDTO) {
        boardAppender.append(requestAddBoardDTO);
    }
}
