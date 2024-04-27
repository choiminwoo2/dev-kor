package org.ruu.developerkorea.domain.board.domain.post;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.model.dto.post.RequestUpdatePostDTO;
import org.ruu.developerkorea.domain.board.model.mapper.PostMapper;
import org.ruu.developerkorea.domain.board.repository.PostRepository;
import org.ruu.developerkorea.global.error.BusinessLogicException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PostRewrite {

    private final PostRepository postRepository;

    @Transactional
    public Long rewrite(RequestUpdatePostDTO requestUpdatePostDTO) {
        Optional<Post> result = postRepository.findById(requestUpdatePostDTO.getId());
        if (result.isEmpty()){
            throw new BusinessLogicException("Post not found");
        }
        Post post = result.get();

        post.changePost(requestUpdatePostDTO.getTitle(), requestUpdatePostDTO.getContent());

        return post.getId();
    }
}
