package com.project.robotmate.home.global.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Pageable {

    long totalCount;   // 전체 데이터의 개수(게시글의 개수)
    int page;       // 현재 페이지
    int startPage; // 현재 블록 시작 페이지
    long totalPage; // 전체 페이지수
    int endPage;   // 현재 블록 마지막 페이지
    int blockSize = 5;  // 네비게이터의 크기
    long pageSize = 10;  // 페이지의 크기
    boolean preView; // 뒤로가기
    boolean nextView; // 다음으로 가기

    boolean isOverPage; // 토탈 페이지 보다 큰 페이지가 들어왔는지 여부

    @Builder
    public Pageable(long totalCount, int page){
        this.totalCount = totalCount;
        this.page = page <= 0 ? 1 : page;
        this.totalPage = calculateTotalPage();
        this.startPage = calculateStartPage();
        this.endPage = calculateEndPage();

        preView = startPage != 1;
        nextView = endPage != totalPage;
        isOverPage = totalPage < page;
    }

    private int calculateTotalPage() {
        return (int) Math.ceil((double) this.totalCount / this.pageSize);
    }

    private int calculateStartPage() {
        return ( this.page-1 ) / this.blockSize * this.blockSize + 1;
    }

    private int calculateEndPage() {
        return (int) Math.min( ((long) ((this.page - 1) / this.blockSize + 1) * this.blockSize ), this.totalPage );
    }

    public long getOffset() {
        if (this.page - 1 == 0) {
            return 0;
        }
        return ((this.page - 1) * this.pageSize);
    }
}
