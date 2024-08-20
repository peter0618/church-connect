-- member (회원 정보) 테이블 생성
DROP TABLE IF EXISTS member;
CREATE TABLE member (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT 'Primary Key',
    name VARCHAR(100) NOT NULL COMMENT '회원 이름',
    birth_date DATE NOT NULL COMMENT '생년월일',
    phone_number VARCHAR(15) NOT NULL COMMENT '전화번호',
    registration_date DATE NULL COMMENT '등록일',
    position VARCHAR(50) NOT NULL DEFAULT '성도' COMMENT '직분',
    cell_name VARCHAR(100) NULL COMMENT '셀이름',
    address VARCHAR(255) NULL COMMENT '주소',
    family_info TEXT NULL COMMENT '가족 정보',
    note TEXT NULL COMMENT '비고',
    gender ENUM('MALE', 'FEMALE') NOT NULL COMMENT '성별',
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성 일시',
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정 일시',
    deleted_at TIMESTAMP NULL DEFAULT NULL COMMENT '삭제 일시 (논리 삭제)'
) COMMENT '회원 정보 테이블';