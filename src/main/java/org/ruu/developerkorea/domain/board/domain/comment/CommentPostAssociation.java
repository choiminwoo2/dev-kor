package org.ruu.developerkorea.domain.board.domain.comment;

import jakarta.persistence.*;
import lombok.*;
import org.ruu.developerkorea.domain.board.domain.post.Post;

@Entity
@Table(name = "POST_COMMENT")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
@Getter
public class CommentPostAssociation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_COMMENT_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    @ToString.Exclude
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "COMMENT_ID")
    @ToString.Exclude
    private Comment comment;

}
