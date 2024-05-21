package org.ruu.developerkorea.slice.board;

import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ruu.developerkorea.annotation.RepositoryTest;
import org.ruu.developerkorea.domain.board.domain.board.Board;
import org.springframework.beans.factory.annotation.Autowired;

@RepositoryTest
public class BoardRepositoryTest {

    @Autowired
    private EntityManager entityManager;


    private Board board;
    @BeforeEach
    public void setUp() {
        board = Board.builder()
                .name("Q&A")
                .description("유저와 대화를 나눕니다.")
                .pwd("1234")
                .build();
        entityManager.persist(board);
    }

    @Test
    public void createBoardTest() {
        //given
        Board board1 = Board.builder()
                .name("커뮤니티")
                .description("유저와 대화를 나눕니다.")
                .pwd("1234")
                .build();
        entityManager.persist(board1);
        entityManager.flush();
        entityManager.clear();
        //when
        Board result = entityManager.find(Board.class, 2L);

        Assertions.assertThat(board1).isNotNull();
        Assertions.assertThat(board1.getName()).isEqualTo(result.getName());
        Assertions.assertThat(board1.getDescription()).isEqualTo(result.getDescription());
    }

    @Test
    public void updateBoard() {
        //given
        board.rewriteBoard("컨텐츠를 바꿉니다.");
        entityManager.flush();
        entityManager.clear();
        Board board1 = entityManager.find(Board.class, 1L);

        Assertions.assertThat(board1).isNotNull();
        Assertions.assertThat(board1.getDescription()).isEqualTo(board.getDescription());
    }

}
