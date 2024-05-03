package org.ruu.developerkorea.domain.board.repository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ruu.developerkorea.domain.board.domain.board.Board;
import org.ruu.developerkorea.domain.board.model.dto.board.ResponseBoardWithPostDTO;
import org.ruu.developerkorea.domain.board.model.dto.post.PostDTO;
import org.ruu.developerkorea.global.error.BusinessLogicException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BoardJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    @Transactional
    @Nullable
    public Long save(Board board) {
        return null;
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
        String sql = "SELECT BOARD_ID, BOARD_NAME, DESCRIPTION FROM board";

        List<Board> boards = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Board.class));

        if (boards.isEmpty()) {
            throw new BusinessLogicException("query is empty");
        }
        return boards;
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

    @Nullable
    public ResponseBoardWithPostDTO findByUrl(String url) {
        String sql = "SELECT B.BOARD_NAME, " +
                "       B.DESCRIPTION, " +
                "       B.URL, " +
                "       P.POST_ID, " +
                "       P.POST_TITLE, " +
                "       P.POST_CONTENT, " +
                "       P.POST_WRITER, " +
                "       P.CREATED_AT, " +
                "       P.UPDATED_AT, " +
                "       (SELECT COUNT(*) AS CNT " +
                "        FROM COMMENT C " +
                "        JOIN POST_COMMENT PC ON C.COMMENT_ID = PC.COMMENT_ID " +
                "        GROUP BY PC.POST_ID " +
                "        HAVING PC.POST_ID = P.POST_ID) AS COMMENT_COUNT " +
                "FROM BOARD B " +
                "JOIN POST P ON B.BOARD_ID = P.BOARD_ID " +
                "WHERE B.URL = ?" +
                " ORDER BY P.POST_ID DESC";
        log.info("boardWithPostSQL = [{}]", sql);
        return jdbcTemplate.query(sql, rs -> {
            ResponseBoardWithPostDTO result = null;
            while (rs.next()) {
                if (result == null) {
                    result = ResponseBoardWithPostDTO.builder()
                            .boardName(rs.getString("BOARD_NAME"))
                            .boardDescription(rs.getString("DESCRIPTION"))
                            .boardUrl(rs.getString("URL"))
                            .list(new ArrayList<>())
                            .build();
                }
                LocalDate createdAt = LocalDate.from(rs.getTimestamp("CREATED_AT").toLocalDateTime());
                LocalDate updatedAt = LocalDate.from(rs.getTimestamp("UPDATED_AT").toLocalDateTime());
                result.getList().add(PostDTO.builder()
                        .postId(rs.getLong("POST_ID"))
                        .title(rs.getString("POST_TITLE"))
                        .content(rs.getString("POST_CONTENT"))
                        .writer(rs.getString("POST_WRITER"))
                        .updatedAt(updatedAt)
                        .commentCount(rs.getInt("COMMENT_COUNT"))
                        .build());
            }
            return result;
        }, url);
    }
}
