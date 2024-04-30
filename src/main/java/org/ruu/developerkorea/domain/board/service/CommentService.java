package org.ruu.developerkorea.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.domain.comment.CommentAppender;
import org.ruu.developerkorea.domain.board.model.dto.comment.RequestAppenderCommentDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentAppender commentAppender;

    public Long insertComment(RequestAppenderCommentDTO requestAppenderCommentDTO) {
        return commentAppender.append(requestAppenderCommentDTO);
    }
}
