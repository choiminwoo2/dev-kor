package org.ruu.developerkorea.board.domain;

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

    @Column(name = "BOARD_NAME", nullable = false, unique = true)
    private String name;


}
