package org.ruu.developerkorea.domain.board.domain.board;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_ID")
    private Long id;

    @Column(name = "BOARD_NAME", nullable = false, unique = true, updatable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(name="BOARD_PWD", nullable = false, length = 25)
    private String pwd;

    public void rewriteBoard(String description){
            this.description = description;
    }
}
