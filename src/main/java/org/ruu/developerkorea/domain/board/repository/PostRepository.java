package org.ruu.developerkorea.domain.board.repository;

import org.ruu.developerkorea.domain.board.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p" +
            " from Post p join fetch p.board b" +
            " where p.id = :id" +
            " and b.url = :boardUrl")
    Optional<Post> findPostByIdWithBoard(Long id, String boardUrl);
}
