package org.ruu.developerkorea.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.domain.comment.CommentAppender;
import org.ruu.developerkorea.domain.board.domain.comment.CommentRemover;
import org.ruu.developerkorea.domain.board.domain.comment.CommentRetriever;
import org.ruu.developerkorea.domain.board.domain.comment.CommentRewrite;
import org.ruu.developerkorea.domain.board.model.dto.comment.RequestAppenderCommentDTO;
import org.ruu.developerkorea.domain.board.model.dto.comment.RequestUpdateCommentDTO;
import org.ruu.developerkorea.domain.board.model.dto.comment.ResponseCommentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentAppender commentAppender;
    private final CommentRewrite commentRewrite;
    private final CommentRemover commentRemover;
    private final CommentRetriever commentRetriever;

    public ResponseCommentDTO insertComment(RequestAppenderCommentDTO requestAppenderCommentDTO) {
        return commentAppender.append(requestAppenderCommentDTO);
    }

    public ResponseCommentDTO updateComment(RequestUpdateCommentDTO requestUpdateCommentDTO) {
        return commentRewrite.rewrite(requestUpdateCommentDTO);
    }

    public Long deleteComment(Long id){
        commentRemover.removeComment(id);
        return id;
    }

    public List<ResponseCommentDTO> getComments(Long postId){
        return commentRetriever.retrieveAllCommentsByPostID(postId);
    }
}
