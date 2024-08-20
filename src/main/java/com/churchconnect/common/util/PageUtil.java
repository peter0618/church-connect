package com.churchconnect.common.util;

import lombok.Getter;

@Getter
public class PageUtil {
    // 고정된 값
    private final int pageNum;        // 현 페이지 번호
    private final long totalRowCount; // 전체 게시물 개수
    private final int pageListSize;   // 한 페이지에서 보여줄 게시물 (최대) 개수
    private final int blockListSize;  // 한 번에 보여줄 블럭 (최대) 개수

    // 계산 되는 값 - page
    private final int pageTotalCount; // 전체 페이지 개수

    // 계산 되는 값 - block
    private final int blockNum;       // 현 블럭의 블럭 번호 (몇 번째 블럭인가?)
    private final int blockStartNum;  // 현 블럭의 시작 페이지 번호
    private int blockEndNum;          // 현 블력의 종료 페이지 번호

    public PageUtil(int pageNum, long totalRowCount, int pageListSize, int blockListSize) {
        this.pageNum = pageNum;
        this.totalRowCount = totalRowCount;
        this.pageListSize = pageListSize;
        this.blockListSize = blockListSize;

        pageTotalCount = (int) Math.ceil(totalRowCount / (double) pageListSize);

        // 블럭 관련 필드 계산
        blockNum = pageNum % blockListSize == 0 ? pageNum / blockListSize : (pageNum / blockListSize) + 1;
        blockStartNum = ((blockNum - 1) * blockListSize) + 1;
        blockEndNum = blockNum * blockListSize;

        // 블럭 종료 페이지 번호 보정 (blockEndNum 은 pageTotalCount 보다 클수 없다)
        if (blockEndNum > pageTotalCount) {
            blockEndNum = pageTotalCount;
        }
    }
}
