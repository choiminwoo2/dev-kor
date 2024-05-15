package org.ruu.developerkorea.domain.board.domain.comment;

import jakarta.persistence.*;
import lombok.*;
import org.ruu.developerkorea.domain.board.domain.BaseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID")
    private Long id;

    @Column(name = "COMMENT_TEXT")
    private String text;

    @Column(name = "COMMENT_WRITER")
    private String writer;

    @ToString.Exclude
    @OneToMany(mappedBy = "comment", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<CommentPostAssociation> commentAndPost = new ArrayList<>();

    public void addCommentAndPost(CommentPostAssociation... commentPostAssociation){
        Collections.addAll(this.commentAndPost, commentPostAssociation);
    }

    public void changeComment(String text){
        this.text = text;
    }

}
