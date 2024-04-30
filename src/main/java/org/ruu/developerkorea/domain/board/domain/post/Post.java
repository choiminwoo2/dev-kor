package org.ruu.developerkorea.domain.board.domain.post;

import jakarta.persistence.*;
import lombok.*;
import org.ruu.developerkorea.domain.board.domain.BaseEntity;
import org.ruu.developerkorea.domain.board.domain.board.Board;
import org.ruu.developerkorea.domain.board.domain.comment.Comment;
import org.ruu.developerkorea.domain.board.domain.comment.CommentPostAssociation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Builder
@ToString(exclude = "board")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_ID")
    private Board board;

    @OneToMany(mappedBy = "post", cascade = CascadeType.PERSIST)
    private List<CommentPostAssociation> postAndComment = new ArrayList<>();

    @Column(name = "POST_TITLE", nullable = false)
    private String title;

    @Column(name = "POST_CONTENT", nullable = false)
    private String content;

    @Column(name = "POST_WRITER", nullable = false, updatable = false)
    private String writer;

    public void setBoard(Board board) {
        this.board = board;
    }

    public void changePost(String title, String content){
        this.title = title;
        this.content = content;
    }

    public void addCommentAndPost(CommentPostAssociation... commentPostAssociation){
        Collections.addAll(this.postAndComment, commentPostAssociation);
    }


}
