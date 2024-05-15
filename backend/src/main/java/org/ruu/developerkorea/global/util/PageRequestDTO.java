package org.ruu.developerkorea.global.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO  {

    private static final int START_PAGE = 1;
    private static final int PAGE_SIZE = 30;

    @Builder.Default
    private int page = START_PAGE;

    @Builder.Default
    private int size = PAGE_SIZE;

    private String categories;

}
