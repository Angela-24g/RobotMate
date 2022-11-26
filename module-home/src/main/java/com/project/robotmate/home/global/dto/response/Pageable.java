package com.project.robotmate.home.global.dto.response;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Pageable {

    int totalCount;   // 전체 데이터의 개수(게시글의 개수)
    int page;       // 현재 페이지
    int startPage; // 시작 페이지
    int totalPage; // 전체 페이지수
    int endPage;   // 마지막 페이지
    int blockSize = 5;  // 네비게이터의 크기
    int pageSize = 10;  // 페이지의 크기
    boolean preView; // 뒤로가기
    boolean nextView; // 다음으로 가기

    public Pageable(int totalCount, int page){
        this.totalCount = totalCount;
        this.page = page <= 0 ? 1 : page;
        this.totalPage = calculateTotalPage();
        this.startPage = calculateStartPage();
        this.endPage = calculateEndPage();

        preView = startPage != 1;
        nextView = endPage != totalPage;
    }

    private int calculateTotalPage() {
        return (int) Math.ceil((double) this.totalCount / this.pageSize);
    }

    private int calculateStartPage() {
        return ( this.page-1 ) / this.blockSize * this.blockSize + 1;
    }

    private int calculateEndPage() {
        return Math.min( ( ( (this.page-1) / this.blockSize + 1 ) * this.blockSize ), this.totalPage );
    }

    public int getOffset() {
        if (this.page - 1 == 0) {
            return 0;
        }
        return ((this.page - 1) * this.pageSize) + 1;
    }
}
