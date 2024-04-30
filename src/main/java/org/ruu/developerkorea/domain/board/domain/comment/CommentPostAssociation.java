package org.ruu.developerkorea.domain.board.domain.comment;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.ruu.developerkorea.domain.board.domain.post.Post;

@Entity
@Table(name = "POST_COMMENT")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CommentPostAssociation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_COMMENT_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMMENT_ID")
    private Comment comment;

}
