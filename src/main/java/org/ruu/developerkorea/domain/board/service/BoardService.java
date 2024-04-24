package org.ruu.developerkorea.domain.board.service;


import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.domain.BoardAppender;
import org.ruu.developerkorea.domain.board.model.dto.RequestAppendBoardDTO;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardAppender boardAppender;

    @Nullable
    public Long insertBoard(RequestAppendBoardDTO requestAppendBoardDTO) {
        return boardAppender.append(requestAppendBoardDTO);

    }
}
