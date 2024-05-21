package org.ruu.developerkorea.domain.board.repository;

import com.querydsl.core.Tuple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardRepositoryCustoms {

    public Page<Tuple> findBoardByUrl(
            String url,
            String category,
            Pageable pageable);
}
