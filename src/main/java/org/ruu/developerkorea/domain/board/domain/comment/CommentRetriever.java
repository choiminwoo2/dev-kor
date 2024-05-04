package org.ruu.developerkorea.domain.board.domain.comment;

import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.model.dto.comment.ResponseCommentDTO;
import org.ruu.developerkorea.domain.board.repository.CommentAndBoardRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CommentRetriever {

    private final CommentAndBoardRepository commentAndBoardRepository;

    public List<ResponseCommentDTO> retrieveAllCommentsByPostID(final Long id) {
        return commentAndBoardRepository.findCommentByPostId(id)
                .stream().map(comment -> ResponseCommentDTO.builder()
                        .commentWriter(comment.getWriter())
                        .commentText(comment.getText())
                        .commentId(comment.getId())
                        .updateAt(comment.getUpdatedAt())
                        .build())
                .toList();
    }
}
