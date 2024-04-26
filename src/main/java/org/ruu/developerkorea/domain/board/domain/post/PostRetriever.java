package org.ruu.developerkorea.domain.board.domain.post;

import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.model.dto.post.ResponsePostDTO;
import org.ruu.developerkorea.domain.board.model.mapper.PostMapper;
import org.ruu.developerkorea.domain.board.repository.PostRepository;
import org.ruu.developerkorea.global.error.BusinessLogicException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PostRetriever {

    private final PostRepository postRepository;

    public ResponsePostDTO retrievePostById(Long postId, String boardName) {
        Optional<Post> result = postRepository.findPostByIdWithBoard(postId, boardName);
        if(result.isEmpty()){
            throw new BusinessLogicException("Post not found");
        }
        return ResponsePostDTO.of(result.get());
    }
}
