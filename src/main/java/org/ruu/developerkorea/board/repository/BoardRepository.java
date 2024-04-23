package org.ruu.developerkorea.board.repository;

import org.ruu.developerkorea.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
