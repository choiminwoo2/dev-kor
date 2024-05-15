package org.ruu.developerkorea.domain.board.domain.comment;

import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.domain.post.Post;
import org.ruu.developerkorea.domain.board.model.dto.comment.RequestAppenderCommentDTO;
import org.ruu.developerkorea.domain.board.model.dto.comment.ResponseCommentDTO;
import org.ruu.developerkorea.domain.board.model.mapper.CommentMapper;
import org.ruu.developerkorea.domain.board.repository.CommentRepository;
import org.ruu.developerkorea.domain.board.repository.CommentAndBoardRepository;
import org.ruu.developerkorea.domain.board.repository.PostRepository;
import org.ruu.developerkorea.global.error.EntityNotFoundException;
import org.ruu.developerkorea.global.error.ErrorType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CommentAppender {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final CommentAndBoardRepository commentAndBoardRepository;

    @Transactional
    public ResponseCommentDTO append(RequestAppenderCommentDTO requestAppenderCommentDTO) {
        Comment comment = CommentMapper.INSTANCE.RequestAppendCommentToComment(requestAppenderCommentDTO);
        Comment comments = commentRepository.save(comment);
        Post post = postRepository.findById(requestAppenderCommentDTO.getPostId()).orElse(null);
        if(post == null){
            throw new EntityNotFoundException(ErrorType.ENTITY_NOT_FOUND);
        }
        CommentPostAssociation commentPostAssociation = CommentPostAssociation.builder()
                .comment(comments)
                .post(post)
                .build();
        commentAndBoardRepository.save(commentPostAssociation);

        return ResponseCommentDTO.builder()
                .commentWriter(comments.getWriter())
                .commentId(comments.getId())
                .commentText(comments.getText())
                .updateAt(comments.getUpdatedAt())
                .build();
    }
}
