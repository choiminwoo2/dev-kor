package org.ruu.developerkorea.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.domain.post.PostAppender;
import org.ruu.developerkorea.domain.board.domain.post.PostRemover;
import org.ruu.developerkorea.domain.board.domain.post.PostRetriever;
import org.ruu.developerkorea.domain.board.domain.post.PostRewrite;
import org.ruu.developerkorea.domain.board.model.dto.post.RequestAppendPostDTO;
import org.ruu.developerkorea.domain.board.model.dto.post.RequestUpdatePostDTO;
import org.ruu.developerkorea.domain.board.model.dto.post.ResponsePostDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostAppender postAppender;
    private final PostRewrite postRewrite;
    private final PostRemover postRemover;
    private final PostRetriever postRetriever;

    public Long createPost(RequestAppendPostDTO requestAppendPostDTO) {
        return postAppender.write(requestAppendPostDTO);
    }

    public Long updatePost(RequestUpdatePostDTO requestUpdatePostDTO) {
        return postRewrite.rewrite(requestUpdatePostDTO);
    }

    public void deletePost(Long id) {
        postRemover.remove(id);

    }

    public ResponsePostDTO findPostById(Long id) {
        return postRetriever.retrievePostById(id);
    }
}
