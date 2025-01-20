# 음료수 뽑기 시스템 유스케이스

## 1. 시스템 개요
- 1인 1일 1회 참여 가능 (휴대폰 번호 기준)
- 매일 자정 참여 이력 초기화

## 2. 유스케이스

### UC-01: 메인 페이지 접속
**액터**: 사용자

**기본 흐름**:
1. 사용자가 URL 접속
2. 시스템이 메인 페이지 표시
    - 전체 참여 현황 표시
    - 휴대폰 번호 입력 폼 표시

### UC-02: 뽑기 실행
**액터**: 사용자

**기본 흐름**:
1. 사용자가 휴대폰 번호 입력
2. 사용자가 뽑기 버튼 클릭
3. 시스템이 참여 자격 검증
4. 시스템이 당첨 여부 결정 (20% 확률)
5. 시스템이 결과 화면 표시

**대체 흐름**:
- 3a. 이미 참여한 번호인 경우
    1. "오늘은 이미 참여했습니다" 메시지 표시
    2. 유스케이스 종료

- 3b. 잘못된 번호 형식
    1. "올바른 휴대폰 번호를 입력하세요" 메시지 표시
    2. 기본 흐름 1로 복귀

### UC-03: 일일 초기화
**액터**: 시스템

**기본 흐름**:
1. 매일 자정에 실행
2. 당일 참여 데이터 백업
3. 참여 이력 초기화

## 3. 데이터 구조

### 참여 이력 테이블
```sql
CREATE TABLE participants (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    phone_number VARCHAR(20),
    participation_time TIMESTAMP,
    winning_item VARCHAR(50),
    participation_date DATE,
    INDEX idx_phone_date (phone_number, participation_date)
);
```

### 상품 테이블
```sql
CREATE TABLE items (
    id BIGINT PRIMARY KEY,
    name VARCHAR(50),
    remaining_quantity INT
);
```

## 4. API 엔드포인트

### 4.1 뽑기 실행
```
POST /api/raffle
Request:
{
    "phoneNumber": "010-1234-5678"
}

Response:
{
    "success": true,
    "message": "축하합니다! 콜라에 당첨되었습니다!",
    "item": "콜라"  // 당첨시에만
}
```

## 5. 성능 고려사항

### 5.1 데이터베이스
- 일일 참여 데이터는 파티셔닝
- 재고는 Redis에 캐싱

### 5.2 API 서버
- t3.small 2대로 시작
- 오토스케일링 설정 (CPU 70% 기준)

### 5.3 모니터링
- API 응답시간
- 에러율
- 재고 상태