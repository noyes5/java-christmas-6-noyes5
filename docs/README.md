## 기능 구현 목록

## 금액 할인
- [X] 크리스마스 기간 할인
- [ ] 평일 할인
- [ ] 주말 할인
- [ ] 특별 할인

## 증정 
- [ ] 총 주문금액이 일정금액(12만원) 이상이면 샴페인을 증정한다.

## 할인 정책
- [ ] 총 주문 금액이 10000원 이상부터 이벤트가 적용된다.
- [ ] 특정 날짜를 선택하면 해당하는 할인 정책이 적용된다.

## 배지
- [ ] 총 혜택금액에 따른 이벤트 배지를 부여한다.
- [ ] 유저가 배지를 가지도록 한다.

## 입력
- [ ] 식당 예상 방문 날짜 입력메시지를 출력하고 입력받는다.
- [ ] 입력값이 에러인 경우 에러를 출력하고 다시 입력을 받는다.
  - [ ] 날짜가 숫자가 아닌경우
  - [ ] 1이상 31이하의 숫자가 아닌경우
  - [ ] 모든 에러메시지는 <code>[ERROR]</code> 로 시작한다.
- [ ] 주문할 메뉴와 개수 입력메시지를 출력하고 입력받는다.
- [ ] 입력값이 에러인 경우 에러를 출력하고 다시 입력을 받는다.
  - [ ] 올바른 형식이 아닐 경우
  - [ ] 메뉴판에 없는 메뉴를 입력하는 경우
  - [ ] 메뉴의 갯수가 1 이상이 아닌 경우
  - [ ] 총 메뉴의 갯수가 20개 이하가 아닌 경우
  - [ ] 중복 메뉴가 입력된 경우
  - [ ] 음료만 주문한 경우
  - [ ] 모든 에러메시지는 <code>[ERROR]</code> 로 시작한다.

## 출력
- [ ] 이벤트 플래너 방문 메시지를 출력한다.
- [ ] 주문 메뉴를 출력한다.
  - [ ] 한 줄에 하나씩 메뉼르 출력
- [ ] 할인 전 총 주문금액을 출력한다.
- [ ] 증정 메뉴를 출력한다.
  - [ ] 증정메뉴가 없는 경우 "없음"을 출력한다.
- [ ] 혜택 내역을 출력한다.
  - [ ] 적용된 이벤트 내역을 순서대로 출력한다.
  - [ ] 헤택이 없는 경우 "없음"을 출력한다.
- [ ] 총 혜택 금액을 출력한다.
  - [ ] 혜택금액 = 할인내역 + 증정메뉴 금액 
- [ ] 할인 후 예상 결제 금액을 출력한다.
  - [ ] 결제 금액 = 총 주문금액 - 할인 금액 
- [ ] 다음달(12월) 이벤트 배지를 출력한다. 
  - [ ] 이벤트 배지가 부여되지 않은 경우 "없음"을 출력한다.


## 추가 요구사항
