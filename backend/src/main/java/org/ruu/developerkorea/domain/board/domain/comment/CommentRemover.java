package org.ruu.developerkorea.domain.board.domain.comment;

import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.repository.CommentAndBoardRepository;
import org.ruu.developerkorea.domain.board.repository.CommentRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CommentRemover {

    private final CommentRepository commentRepository;

    @Transactional
    public void removeComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

}
