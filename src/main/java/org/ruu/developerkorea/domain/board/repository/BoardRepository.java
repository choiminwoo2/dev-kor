package org.ruu.developerkorea.domain.board.repository;

import org.ruu.developerkorea.domain.board.domain.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Board findByUrl(final String url);
}
