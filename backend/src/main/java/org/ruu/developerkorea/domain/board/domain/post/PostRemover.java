package org.ruu.developerkorea.domain.board.domain.post;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.repository.PostRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostRemover {

    private final PostRepository postRepository;

    @Transactional
    public void remove(Long id) {
        postRepository.deleteById(id);
    }
}
