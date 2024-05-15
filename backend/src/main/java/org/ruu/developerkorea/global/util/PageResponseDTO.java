package org.ruu.developerkorea.global.util;

import org.hibernate.mapping.List;

public class PageResponseDTO<T> {

    private int page;
    private int size;
    private int total;
    private T data;

}
