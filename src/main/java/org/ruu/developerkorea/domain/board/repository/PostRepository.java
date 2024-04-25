package org.ruu.developerkorea.domain.board.repository;

import org.ruu.developerkorea.domain.board.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
