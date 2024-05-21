package org.ruu.developerkorea.global.util;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageResponseDTO<T> {

    private int page;
    private int size;
    private int total;
    private T data;

    private int start;
    private int end;

    private boolean prev;
    private boolean next;

    @Builder
    public PageResponseDTO(PageRequestDTO pageRequestDTO, T data, int total) {
        if(total <= 0){
            return;
        }
        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();

        this.total = total;
        this.data = data;

        this.end = (int)(Math.ceil((this.page/(double)this.size))) * 10;
        this.start = this.end - this.size + 1;

        int last = (int)(Math.ceil((total/(double)size)));

        this.end = this.end > last ? last : this.end;

        this.prev = this.page > 10;

        this.next = total > this.end * this.size;
    }
}
