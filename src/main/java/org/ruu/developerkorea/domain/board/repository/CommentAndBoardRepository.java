package org.ruu.developerkorea.domain.board.repository;

import org.ruu.developerkorea.domain.board.domain.comment.CommentPostAssociation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentAndBoardRepository extends JpaRepository<CommentPostAssociation, Long> {
}
