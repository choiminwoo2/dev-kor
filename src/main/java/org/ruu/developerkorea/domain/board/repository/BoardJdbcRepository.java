package org.ruu.developerkorea.domain.board.repository;

import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.domain.Board;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public void save(Board board) {
        String sql = "INSERT INTO board (BOARD_NAME, DESCRIPTION) VALUES (?, ?)";
        jdbcTemplate.update(sql, board.getName(), board.getDescription());
    }

}
