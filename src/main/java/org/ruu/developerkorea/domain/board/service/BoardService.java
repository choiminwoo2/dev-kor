package org.ruu.developerkorea.domain.board.service;


import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.domain.BoardAppender;
import org.ruu.developerkorea.domain.board.domain.BoardRewrite;
import org.ruu.developerkorea.domain.board.model.dto.RequestAppendBoardDTO;
import org.ruu.developerkorea.domain.board.model.dto.RequestUpdateBoardDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardAppender boardAppender;
    private final BoardRewrite boardRewrite;


    public Long insertBoard(RequestAppendBoardDTO requestAppendBoardDTO) {
        return boardAppender.append(requestAppendBoardDTO);
    }

    public Long updateBoard(RequestUpdateBoardDTO requestUpdateBoardDTO) {
        return boardRewrite.update(requestUpdateBoardDTO);
    }
}
