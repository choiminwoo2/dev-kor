package org.ruu.developerkorea.domain.board.domain.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ruu.developerkorea.domain.board.domain.comment.Comment;
import org.ruu.developerkorea.domain.board.model.dto.post.ResponsePostWithCommentDTO;
import org.ruu.developerkorea.domain.board.repository.PostRepository;
import org.ruu.developerkorea.global.error.EntityNotFoundException;
import org.ruu.developerkorea.global.error.ErrorType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class PostRetriever {

    private final PostRepository postRepository;

    @Transactional
    public ResponsePostWithCommentDTO retrievePostById(Long postId, String boardUrl) {
        Optional<Post> result = postRepository.findPostByIdWithBoard(postId, boardUrl);
        if(result.isEmpty()){
            //TODO 일관적인 Exception 처리는 나중에...
            throw new EntityNotFoundException(ErrorType.ENTITY_NOT_FOUND);
        }
        Post post = result.get();
        List<Comment> comments = new ArrayList<>();
        post.getPostAndComment().forEach( commentPost ->{
            comments.add(commentPost.getComment());
        });

        return ResponsePostWithCommentDTO.of(post, comments);
    }
}
