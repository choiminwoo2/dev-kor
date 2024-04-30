package org.ruu.developerkorea.domain.board.domain.comment;

import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.domain.post.Post;
import org.ruu.developerkorea.domain.board.model.dto.comment.RequestAppenderCommentDTO;
import org.ruu.developerkorea.domain.board.model.mapper.CommentMapper;
import org.ruu.developerkorea.domain.board.repository.CommentRepository;
import org.ruu.developerkorea.domain.board.repository.CommentAndBoardRepository;
import org.ruu.developerkorea.domain.board.repository.PostRepository;
import org.ruu.developerkorea.global.error.BusinessLogicException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CommentAppender {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final CommentAndBoardRepository commentAndBoardRepository;

    @Transactional
    public Long append(RequestAppenderCommentDTO requestAppenderCommentDTO) {
        Comment comment = CommentMapper.INSTANCE.RequestAppendCommentToComment(requestAppenderCommentDTO);
        Comment comments = commentRepository.save(comment);
        Post post = postRepository.findById(requestAppenderCommentDTO.getPostId()).orElse(null);
        if(post == null){
            throw new BusinessLogicException("PostAndComment not found");
        }
        CommentPostAssociation commentPostAssociation = CommentPostAssociation.builder()
                .comment(comments)
                .post(post)
                .build();
        commentAndBoardRepository.save(commentPostAssociation);

        return comments.getId();
    }
}
