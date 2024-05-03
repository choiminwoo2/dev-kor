package org.ruu.developerkorea.domain.board.repository;

import org.ruu.developerkorea.domain.board.domain.comment.Comment;
import org.ruu.developerkorea.domain.board.domain.comment.CommentPostAssociation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentAndBoardRepository extends JpaRepository<CommentPostAssociation, Long> {

    @Query("select cp from CommentPostAssociation cp where cp.post.id = :postId")
    public List<CommentPostAssociation> findAllByPostId(Long postId);

    @Query("select c from Comment c" +
            " join fetch c.commentAndPost cp" +
            " where cp.post.id = :postId")
    public List<Comment> findCommentByPostId(Long postId);

}
