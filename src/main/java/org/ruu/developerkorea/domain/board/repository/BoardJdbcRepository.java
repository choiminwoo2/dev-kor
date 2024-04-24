package org.ruu.developerkorea.domain.board.repository;

import lombok.RequiredArgsConstructor;
import org.ruu.developerkorea.domain.board.domain.Board;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public Long save(Board board) {
        String sql = "INSERT INTO board (BOARD_NAME, DESCRIPTION) VALUES (?, ?)";
        jdbcTemplate.update(sql, board.getName(), board.getDescription());
        String query = "SELECT BOARD_ID FROM board WHERE BOARD_NAME = ?";

        return jdbcTemplate.queryForObject(query, Long.class, board.getName());
    }

    public List<Board> findAll() {
        String sql = "SELECT * FROM board";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Board.class));
    }

    public Board findById(Long id) {
        String sql = "SELECT * FROM board WHERE BOARD_ID = ?";
        jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Board.class), id);
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Board.class), id);
    }

    public void delete(Long id) {
        String selectQuery = "SELECT * FROM BOARD WHERE BOARD_ID = ?";
        Long existBoard = jdbcTemplate.queryForObject(selectQuery, Long.class, id);
        if(existBoard == null || !existBoard.equals(id)) {
            return;
        }
        String sql = "DELETE FROM board WHERE BOARD_ID = ?";
        jdbcTemplate.update(sql, id);
    }

}
