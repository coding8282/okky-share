package org.okky.share;

import lombok.Getter;

import java.util.List;

import static java.lang.Math.ceil;

@Getter
public class PagingEnvelop {
    Paging paging;
    Object content;

    public PagingEnvelop(int limit, List<?> dtos, long totalCount) {
        this.paging = new Paging(limit, dtos.size(), totalCount);
        this.content = dtos;
    }

    @Getter
    public static class Paging {
        Integer totalResults;
        Integer pageResults;
        Integer finalPageNo;

        public Paging(int limit, int fetchedResults, long totalResults) {
            if (fetchedResults == 0) {
                this.totalResults = (int) totalResults;
                this.pageResults = fetchedResults;
                this.finalPageNo = 0;
            } else {
                int t = (int) totalResults;
                this.totalResults = t;
                this.pageResults = fetchedResults;
                this.finalPageNo = (int) ceil((t / (limit * 1d)));//ceil(t/w)
            }
        }
    }
}
