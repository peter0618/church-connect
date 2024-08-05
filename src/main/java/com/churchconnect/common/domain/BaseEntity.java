package com.churchconnect.common.domain;

import java.util.Date;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class BaseEntity {
    protected Date createdAt; // 생성 일시
    protected Date updatedAt; // 수정 일시
    protected Date deletedAt; // 삭제 일시 (논리 삭제)
}
