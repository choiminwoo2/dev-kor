package org.ruu.developerkorea.slice.board;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ruu.developerkorea.annotation.RepositoryTest;
import org.ruu.developerkorea.domain.board.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RepositoryTest
public class BoardRepositoryTest {

    @Autowired
    TestEntityManager entityManager;


    @Test
    public void insertTest() {
        //given
        Board board = Board.builder()
                .name("커뮤니티")
                .description("유저와 대화를 나눕니다.")
                .build();
        entityManager.persist(board);
        entityManager.flush();
        entityManager.clear();
        //when
        Board board1 = entityManager.find(Board.class, 1L);

        Assertions.assertThat(board1).isNotNull();
        Assertions.assertThat(board1.getName()).isEqualTo(board.getName());
        Assertions.assertThat(board1.getDescription()).isEqualTo(board.getDescription());


    }
}
