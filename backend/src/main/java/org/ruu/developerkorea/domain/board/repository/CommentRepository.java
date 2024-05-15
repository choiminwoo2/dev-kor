package org.ruu.developerkorea.domain.board.repository;

import org.ruu.developerkorea.domain.board.domain.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
