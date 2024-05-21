package org.ruu.developerkorea.domain.board.repository;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.ruu.developerkorea.domain.board.domain.board.Board;
import org.ruu.developerkorea.domain.board.domain.board.QBoard;
import org.ruu.developerkorea.domain.board.domain.board.QCategory;
import org.ruu.developerkorea.domain.board.domain.post.QPost;
import org.ruu.developerkorea.domain.board.repository.support.Querydsl5RepositorySupport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import static org.springframework.util.StringUtils.hasText;

@Repository
public class BoardRepositoryImpl extends Querydsl5RepositorySupport implements BoardRepositoryCustoms {

    public BoardRepositoryImpl() {
        super(Board.class);
    }

    private final QBoard board = QBoard.board;
    private final QPost post = QPost.post;
    private final QCategory qCategory = QCategory.category;

    public Page<Tuple> findBoardByUrl(
            String url,
            String category,
            Pageable pageable) {

        return applyPagination(pageable, query -> query.
                select(board, post)
                .from(board)
                .leftJoin(board.posts, post)
                .leftJoin(board.categories, qCategory)
                .where(
                        eqUrl(url),
                        eqCategory(category))
        );
    }

    public BooleanExpression eqCategory(String category) {
        return hasText(category) ? qCategory.name.eq(category) : null;
    }

    public BooleanExpression eqUrl(String url) {
        return hasText(url) ? board.url.eq(url) : null;
    }

}
