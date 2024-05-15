package org.ruu.developerkorea.domain.board.domain.board;

import jakarta.persistence.*;
import lombok.*;
import org.ruu.developerkorea.domain.board.domain.BaseEntity;
import org.ruu.developerkorea.domain.board.domain.post.Post;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_ID")
    private Long id;

    @Column(name = "BOARD_NAME", nullable = false, unique = true, updatable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(name = "BOARD_PWD", nullable = false, length = 25)
    private String pwd;

    @Column(nullable = false, length = 100)
    private String url;

    @OneToMany(mappedBy = "board", cascade = CascadeType.PERSIST)
    private List<Post> posts = new ArrayList<>();

    public void rewriteBoard(String description) {
        this.description = description;
    }
}
