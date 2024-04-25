package org.ruu.developerkorea.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.domain.post.PostAppender;
import org.ruu.developerkorea.domain.board.model.dto.post.RequestAppendPostDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostAppender postAppender;

    public Long createPost(RequestAppendPostDTO requestAppendPostDTO) {
        return postAppender.write(requestAppendPostDTO);
    }

}
