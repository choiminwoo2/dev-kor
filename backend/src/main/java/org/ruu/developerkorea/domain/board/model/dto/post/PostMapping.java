package org.ruu.developerkorea.domain.board.model.dto.post;

import org.ruu.developerkorea.domain.board.domain.board.Board;

import java.time.LocalDateTime;

public interface PostMapping {

    Long getId();
    Board getBoard();
    String getContent();
    String getTitle();
    String getWriter();
    LocalDateTime getUpdatedAt();
    long getCommentCount();

}
