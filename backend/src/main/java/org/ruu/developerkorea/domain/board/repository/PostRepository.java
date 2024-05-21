package org.ruu.developerkorea.domain.board.repository;

import org.ruu.developerkorea.domain.board.domain.post.Post;
import org.ruu.developerkorea.domain.board.model.dto.post.PostDTO;
import org.ruu.developerkorea.domain.board.model.dto.post.PostMapping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p" +
            " from Post p join fetch p.board b" +
            " where p.id = :id" +
            " and b.url = :boardUrl")
    Optional<Post> findPostByIdWithBoard(Long id, String boardUrl);

    @Query("select p.id as id, p.content as content, p.title as title, p.writer as writer, p.updatedAt as updatedAt, " +
            "(select count(cp.comment.id) from CommentPostAssociation cp where cp.post.id = p.id) as commentCount " +
            "from Post p join fetch Board b on b.id = p.board.id " +
            "where b.url = :boardUrl " +
            "order by p.id DESC")
    Page<PostMapping> findPostByBoardUrlWithPagination(String boardUrl, Pageable pageable);

    @Query("select new org.ruu.developerkorea.domain.board.model.dto.post.PostDTO(p.id, p.title, p.content, p.writer, p.updatedAt, " +
            "(select count(cp) from CommentPostAssociation cp where cp.post.id = p.id) ) " +
            "from Post p join fetch Board b on b.id = p.board.id " +
            "where b.url = :boardUrl " +
            "order by p.id DESC")
    Page<PostDTO> findPostByBoardUrlWithPagination2(String boardUrl, Pageable pageable);
}
