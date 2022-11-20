# kotlin-lotto

## 문자열 덧셈 계산기
### 기능 목표
* 문자열 입력
  * 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열 전달
  * 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자 지정 가능
  * 숫자 이외의 값 전달하는 경우 RuntimeException 예외
* 계산
  * 음수 전달하는 경우 RuntimeException 예외
  * 문자열 계산기의 모든 숫자 합산


## 로또 (자동)
### 기능 목표
* 로또 구입 금액 입력
  * 숫자가 아니면 예외 발생
  * 음수 또는 양의 정수가 아닌 숫자 입력시 예외 발생
* 로또 자동 발급
  * 로또 하나당 6개의 1~45사이의 랜덤 숫자 리스트
* 로또 구매
  * 로또 1장의 가격 1000원보다 작으면 예외
  * 로또 금액이 1000의 배수가 아닌 경우 예외
* 지난 주 당첨 번호 입력
  * 6개의 숫자 입력(구분자는 ,)
  * 입력형식에 맞지 않을시 예외
  * 6개의 숫자가 1~45 사이의 숫자가 아니면 예외
  * 숫자를 6개보다 많거나 적게 입력시 예외
* 당첨 통계
  * 발급받은 로또 리스트와 , 지난주 당첨 번호를 파라미터로 받는다
  * 6개 일치 개수 구하기
  * 5개 일치 개수 구하기
  * 4개 일치 개수 구하기
  * 3개 일치 개수 구하기
  * 수익률 구하기
* 발급받은 로또 번호 출력
  * 발급받은 로또 리스트 출력
* 당첨 통계 출력
  * 당첨 통계를 출력
  * 수익률 출력
