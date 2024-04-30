package org.ruu.developerkorea.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.domain.comment.CommentAppender;
import org.ruu.developerkorea.domain.board.domain.comment.CommentRewrite;
import org.ruu.developerkorea.domain.board.model.dto.comment.RequestAppenderCommentDTO;
import org.ruu.developerkorea.domain.board.model.dto.comment.RequestUpdateCommentDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentAppender commentAppender;
    private final CommentRewrite commentRewrite;

    public Long insertComment(RequestAppenderCommentDTO requestAppenderCommentDTO) {
        return commentAppender.append(requestAppenderCommentDTO);
    }

    public Long updateComment(RequestUpdateCommentDTO requestUpdateCommentDTO) {
        return commentRewrite.rewrite(requestUpdateCommentDTO);
    }
}
