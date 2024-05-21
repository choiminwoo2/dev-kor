package org.ruu.developerkorea.domain.board.service;


import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.domain.board.*;
import org.ruu.developerkorea.domain.board.domain.post.PostRetriever;
import org.ruu.developerkorea.domain.board.model.dto.board.RequestAppendBoardDTO;
import org.ruu.developerkorea.domain.board.model.dto.board.RequestUpdateBoardDTO;
import org.ruu.developerkorea.domain.board.model.dto.board.ResponseBoardDTO;
import org.ruu.developerkorea.domain.board.model.dto.board.ResponseBoardWithPostDTO;
import org.ruu.developerkorea.domain.board.model.dto.post.PostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardAppender boardAppender;
    private final BoardRewrite boardRewrite;
    private final BoardRetriever boardRetriever;
    private final BoardRemover boardRemover;
    private final PostRetriever postRetriever;

    public Long insertBoard(RequestAppendBoardDTO requestAppendBoardDTO) {
        return boardAppender.append(requestAppendBoardDTO);
    }

    public Long updateBoard(RequestUpdateBoardDTO requestUpdateBoardDTO) {
        return boardRewrite.update(requestUpdateBoardDTO);
    }

    public List<Board> retrieveAllBoard() {
        return boardRetriever.retrieveBoard();
    }

    public void deleteBoard(Long id) {
        boardRemover.remove(id);
    }

    public ResponseBoardWithPostDTO displayBoardByUrl(String url) {

        ResponseBoardDTO boardDTO = boardRetriever.retrieveBoardByUrl(url);

        List<PostDTO> postDTOS = postRetriever.retrievePostByBoardUrl(url);


        return ResponseBoardWithPostDTO.builder()
                .boardName(boardDTO.getName())
                .boardDescription(boardDTO.getDescription())
                .boardUrl(boardDTO.getUrl())
                .list(postDTOS)
                .build();
    }
}
