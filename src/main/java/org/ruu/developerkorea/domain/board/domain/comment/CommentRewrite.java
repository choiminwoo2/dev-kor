package org.ruu.developerkorea.domain.board.domain.comment;

import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.model.dto.comment.RequestUpdateCommentDTO;
import org.ruu.developerkorea.domain.board.model.mapper.CommentMapper;
import org.ruu.developerkorea.domain.board.repository.CommentRepository;
import org.ruu.developerkorea.global.error.BusinessLogicException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CommentRewrite {

    private final CommentRepository commentRepository;

    @Transactional
    public Long rewrite(RequestUpdateCommentDTO requestUpdateCommentDTO){
        Comment comment = commentRepository.findById(requestUpdateCommentDTO.getCommentId()).orElse(null);
        if(comment == null){
            throw new BusinessLogicException("comment not found");
        }
        comment.changeComment(requestUpdateCommentDTO.getText());

        return comment.getId();
    }
}
