package org.ruu.developerkorea.domain.board.domain.post;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.domain.board.Board;
import org.ruu.developerkorea.domain.board.model.dto.post.RequestAppendPostDTO;
import org.ruu.developerkorea.domain.board.model.mapper.PostMapper;
import org.ruu.developerkorea.domain.board.repository.BoardRepository;
import org.ruu.developerkorea.domain.board.repository.PostRepository;
import org.ruu.developerkorea.global.error.EntityNotFoundException;
import org.ruu.developerkorea.global.error.ErrorType;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PostAppender {

    private final PostRepository postRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public Long write(RequestAppendPostDTO requestAppendPostDTO) {

        Board board = boardRepository.findByUrl(requestAppendPostDTO.getUrl())
                .orElseThrow(() -> new EntityNotFoundException(ErrorType.ENTITY_NOT_FOUND));
        Post post = PostMapper.INSTANCE.requestAppendPostDTOToPost(requestAppendPostDTO);
        post.setBoard(board);

        return postRepository.save(post).getId();
    }
}
