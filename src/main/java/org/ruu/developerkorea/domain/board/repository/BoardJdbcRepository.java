package org.ruu.developerkorea.domain.board.repository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ruu.developerkorea.domain.board.domain.Board;
import org.ruu.developerkorea.global.error.BusinessLogicException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BoardJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    @Transactional
    @Nullable
    public Long save(Board board) {
        String sql = "INSERT INTO board (BOARD_NAME, DESCRIPTION) VALUES (?, ?)";
        int update = jdbcTemplate.update(sql, board.getName(), board.getDescription());
        String query = "SELECT BOARD_ID FROM board WHERE BOARD_NAME = ?";
        Long id = jdbcTemplate.queryForObject(query, Long.class, board.getName());
        if (update == 0) {
            throw new BusinessLogicException("non existent data");
        }

        return id;
    }

    public Long update(Board board) {
        String sql = "UPDATE board SET DESCRIPTION = ? WHERE BOARD_ID = ?";
        int update = jdbcTemplate.update(sql, board.getDescription(), board.getId());
        if (update == 0) {

            throw new BusinessLogicException("non existent data");
        }
        return board.getId();
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
        if (existBoard == null || !existBoard.equals(id)) {
            return;
        }
        String sql = "DELETE FROM board WHERE BOARD_ID = ?";
        jdbcTemplate.update(sql, id);
    }

}
