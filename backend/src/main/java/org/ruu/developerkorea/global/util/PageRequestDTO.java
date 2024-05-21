package org.ruu.developerkorea.global.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PageRequestDTO  {

    private static final int START_PAGE = 1;
    private static final int PAGE_SIZE = 30;

    @Builder.Default
    private int page = START_PAGE;

    @Builder.Default
    private int size = PAGE_SIZE;

    private String categories;

    private List<Link> links = new ArrayList<>();


    @Getter
    public static class Link{

        private String url;
        private String queryString;

        public Link(String url, String queryString) {
            this.url = url;
            this.queryString = queryString;
        }

    }

}
