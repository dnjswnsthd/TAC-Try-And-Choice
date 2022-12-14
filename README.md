# Try And Choice
<!-- ## <img src="https://cdn-icons-png.flaticon.com/512/4394/4394574.png" width="23"> &nbsp; <strong>목차</strong>
---
1. [기획 의도](#b새로운-소비-주체인-mz세대를-타겟으로-잡아보자b)
2. [주제선정 배경](#img-srchttpscdn-icons-pngflaticoncom51228592859734png-width23-nbspstrong주제-선정-배경strong)
3. [목표](#img-srchttpscdn-icons-pngflaticoncom51232143214721png-width23-nbspstrong목표strong)
4. [사용 스택](#img-srchttpscdn-icons-pngflaticoncom512591591576png-width23-nbspstrong기간strong)
5. [기간](#img-srchttpscdn-icons-pngflaticoncom512591591576png-width23-nbspstrong기간strong)
6. [역할](#img-srchttpscdn-icons-pngflaticoncom51265966596902png-width23-nbspstrong역할strong)
7. [DB_ERD](#img-srchttpscdn-icons-pngflaticoncom512689689319png-width23-nbspstrongdberdstrong)
8. [협업 준비 - 공유 Oracle, github(sourcetree)](#img-srchttpscdn-icons-pngflaticoncom512689689319png-width23-nbspstrong협업-준비---공유-oracle-githubsourcetreestrong)
9. [Project Structure](#img-srchttpscdn-icons-pngflaticoncom512645645979png-width23-nbspstrongproject-structurestrong)
10. [개발 일정](#img-srchttpscdn-icons-pngflaticoncom512771771496png-width23-nbspstrong개발-일정strong)
11. [동작 원리](#img-srchttpscdn-icons-pngflaticoncom512762762620png-width23-nbspstrong동작-원리strong)
12. [기능 소개](#img-srchttpscdn-icons-pngflaticoncom51227252725783png-width23-nbspstrong기능-소개strong)
13. [오류 해결](#img-srchttpscdn-icons-pngflaticoncom512807807241png-width23-nbspstrong오류-해결strong) -->
## <img src="https://cdn-icons-png.flaticon.com/512/1436/1436664.png" width="23"> &nbsp;<strong>기획 의도 - 웹 프로젝트</strong>
### <b>새로운 소비 주체인 MZ세대를 타겟으로 잡아보자</b>
MZ세대의 특징
- 1980-2010년 사이의 출생자
- 개인의 취향과 경험 중시
- 타인의 소비경험에도 민감하게 반응
- 이전 세대에 비해 브랜드 충성도 낮음
- 미디어 플랫폼에 익숙
- '디지털 원주민'이라고도 불림

---
## <img src="https://cdn-icons-png.flaticon.com/512/1436/1436664.png" width="23"> &nbsp;<strong>기획 의도 - 머신러닝 프로젝트</strong>
### <b>소비 등록에서의 번거로움을 해결하자</b>

- 하루하루 등록하지 않고 카드사에서 받은 결제 내역 엑셀 파일을 업로드 함으로서 소비 등록이 가능
- 서비스에 맞게 카테고리를 자동분류 하여 데이터베이스에 저장이 가능

---
## <img src="https://cdn-icons-png.flaticon.com/512/1012/1012248.png" width="23"> &nbsp;<strong>주제 선정 배경</strong>

<details>
  <summary>자세히 보기</summary>


### <b>BNK 부산은행의 부족한 점</b>
![bnkhome](./readme_img/bnkhome.png)<!-- 경로 재지정 필요 -->
- 생애주기별, 고객별 추천 상품을 제안하고 있지만
- 개개인의 라이프 스타일이나 소비 패턴에 딱 맞는 추천은 제공하고 있지 않다

![bnkhome_card](./readme_img/bnkhome_card.png)
<!-- 경로 재지정 필요 -->
- 카드 비교 탭에서 볼 수 있는 화면
- 카드 비교가 가능하지만 텍스트 위주여서 한눈에 알아보긴 어렵다

### <b>타 서비스의 부족한 점</b>
![bnkhome_card_gorilla](./readme_img/bnkhome_card_gorilla.png)
<!-- 경로 재지정 필요 -->
### CARD GORILLA (카드 고릴라)
- 카드 혜택 비교 사이트
- 카드 선호 순위를 중점으로 보여준다
- 카드 비교가 가능하지만 텍스트 위주

</details>

---

## <img src="https://cdn-icons-png.flaticon.com/512/860/860511.png" width="23"> &nbsp;<strong>목표</strong>
### 직접 카드사용을 체험하고 이를 알기 쉽게 전달해 고객이 적절한 카드를 선택할 수 있게 하자!!

---
## <img src="https://cdn-icons-png.flaticon.com/512/2444/2444286.png" width="23"> &nbsp;<strong>사용 스택</strong>

|분류|스택|
|---|---|
|Frontend|<img src="https://img.shields.io/badge/css-1572B6?style=flat-square&logo=css3&logoColor=white"/>&nbsp;<img src="https://img.shields.io/badge/javascript-F7DF1E?style=flat-square&logo=JavaScript&logoColor=black">&nbsp;<img src="https://img.shields.io/badge/bootstrap-7952B3?style=flat-square&logo=Bootstrap&logoColor=white">||
|backend|<img src="https://img.shields.io/badge/Spring-6DB33F?style=flat-square&logo=Spring&logoColor=white"/>&nbsp;<img src="https://img.shields.io/badge/swagger-85EA2D?style=flat-square&logo=Swagger&logoColor=black"/>&nbsp;<img src="https://img.shields.io/badge/flask-000000?style=flat-square&logo=Flask&logoColor=white"/>|spring - 2.7.3|
|collaboration & management|<img src="https://img.shields.io/badge/git-F05032?style=flat-square&logo=Git&logoColor=white"/>&nbsp;<img src="https://img.shields.io/badge/github-181717?style=flat-square&logo=GitHub&logoColor=white"/>&nbsp;<img src="https://img.shields.io/badge/notion-000000?style=flat-square&logo=Notion&logoColor=white">||
|DB|<img src="https://img.shields.io/badge/oracle-F80000?style=flat-square&logo=Oracle&logoColor=white">||
---
## <img src="https://cdn-icons-png.flaticon.com/512/591/591576.png" width="23"> &nbsp;<strong>기간 - 웹 프로젝트</strong>
준비 : 2022-08-08 ~ 2022-08-28<br>
개발 : 2022-08-29 ~ 2022-09-08

---

## <img src="https://cdn-icons-png.flaticon.com/512/591/591576.png" width="23"> &nbsp;<strong>기간 - 머신러닝 프로젝트</strong>
준비 : 2022-09-19 ~ 2022-09-22<br>
개발 : 2022-09-23 ~ 2022-09-27

---
## <img src="https://cdn-icons-png.flaticon.com/512/6596/6596902.png" width="23"> &nbsp;<strong>역할 - 웹 프로젝트</strong>
|이름|역할|비고|
|---|---|---|
|송원준|조장|개발 환경 구축, 회원가입(소비등록) &, 마이페이지 구현, 카드간 할인, 비교 페이지 구현|
|류기탁|조원|소비패턴 분석, 패턴 비교 구현, 파일 업로드 구현, 인터셉터 구현, 영상 편집|
|박소연|조원|카드 할인 상세, 페이지 구현, 디자인 수정, 발표자료 작성|
|배은지|조원|로그인 페이지, 디자인 수정, 시연 영상 녹음|
|이화정|조원|관리자 페이지, 카테고리 관리 & 카드 관리 구현|

---

## <img src="https://cdn-icons-png.flaticon.com/512/6596/6596902.png" width="23"> &nbsp;<strong>역할 - 머신러닝 프로젝트</strong>
|이름|역할|비고|
|---|---|---|
|송원준|조장|개발 환경 구축(FLASK), Excel 업로드 구현|
|류기탁|조원|데이터 전처리, 영상 편집|
|박소연|조원|머신러닝 분류 모델링 구현, 발표자료 작성, 발표|
|배은지|조원|데이터 전처리, 발표자료 작성|
|이화정|조원|머신러닝 예측 모델링 구현ing|

---
## <img src="https://cdn-icons-png.flaticon.com/512/138/138932.png" width="23"> &nbsp;<strong>DB_ERD</strong>

<details>
  <summary>자세히 보기</summary>

![DB_ERD](./readme_img/DB_ERD.png)

</details>

---
## <img src="https://cdn-icons-png.flaticon.com/512/1534/1534938.png" width="23"> &nbsp;<strong>협업 준비 - 공유 Oracle, github(sourcetree)</strong>

<details>
  <summary>자세히 보기</summary>

<img src="https://img.shields.io/badge/oracle-F80000?style=flat-square&logo=Oracle&logoColor=white">

![oracle_cloud](./readme_img/oracle_cloud.png)
<br><br>
<img src="https://img.shields.io/badge/sourcetree-0052CC?style=flat-square&logo=Sourcetree&logoColor=white">

![sourcetree](./readme_img/sourcetree.png)

</details>

---

## <img src="https://cdn-icons-png.flaticon.com/512/645/645979.png" width="23"> &nbsp;<strong>Project Structure</strong>

<details>
  <summary>자세히 보기</summary>

![project_structure](./readme_img/project_structure.png)

</details>

---

## <img src="https://cdn-icons-png.flaticon.com/512/771/771496.png" width="23"> &nbsp;<strong>개발 일정 - 웹 프로젝트</strong>

<details>
  <summary>자세히 보기</summary>

![schedule](./readme_img/schedule.png)

---

## <img src="https://cdn-icons-png.flaticon.com/512/771/771496.png" width="23"> &nbsp;<strong>개발 일정 - 머신러닝 프로젝트</strong>

![schedule2](./readme_img/schedule2.png)

</details>

---

## <img src="https://cdn-icons-png.flaticon.com/512/675/675780.png" width="23"> &nbsp;<strong>동작 원리</strong>

<details>
  <summary>자세히 보기</summary>

![principle](./readme_img/principle.png)

---


## <img src="https://cdn-icons-png.flaticon.com/512/675/675780.png" width="23"> &nbsp;<strong>동작 원리</strong>

![principle](./readme_img/principle2.png)

</details>

---

## <img src="https://cdn-icons-png.flaticon.com/512/824/824956.png" width="23"> &nbsp;<strong>기능 소개</strong>
### <b>회원가입</b>

<details>
  <summary>자세히 보기</summary>
1. 개인 정보 등록

![membership1](./readme_img/membership1.png)

2. 카드 정보 등록
- 사용할 카드를 선택

![membership2](./readme_img/membership2.png)


3. 회원 가입 완료 후 소비 정도 입력 창 클릭!

![membership3](./readme_img/membership3.png)

4. 달력에 소비 내역 자유롭게 입력 가능

![membership4](./readme_img/membership4.gif)

</details>

### <b>카드 비교</b>

<details>
  <summary>자세히 보기</summary>
CARD 클릭

![header_card](./readme_img/header_card.png)


1. 체험할 카드 선택하기
- 메인화면에서 체험해보고 싶은 카드 클릭

![card0](./readme_img/card0.png)


2. 선택한 카드 체험하기
- 체험해보고자 하는 카드의 정보와 본인의 소비 내역 간략히 소개

![card1](./readme_img/card1.png)


3. 선택한 카드와 내 카드 비교 체험하기
- 체험해보고자 하는 카드와 내가 사용중인 카드를 유형별로 비교하여 장 단점을 시각화하여 한눈에 알 수 있게끔 해준다.

![card2](./readme_img/card2.png)

- 시현 영상

![card3](./readme_img/card3.gif)

</details>

### <b>소비 분석</b>

<details>
  <summary>자세히 보기</summary>

ANALYSE 클릭

![header_analysis](./readme_img/header_analysis.png)


1. 유형별, 일별 분석 보기
- 본인의 소비 유형별 분석을 파이 차트로 보여주고,
일별 소비를 라인 차트로 보여준다. 

![analysis1](./readme_img/analysis1.png)


2. 동년배들과의 소비 유형 비교
- 왼쪽 소비 유형별 분석 클릭시 동년배들과의 소비 유형을 한눈에 알아 볼 수 있게 나타냈다.

![analysis2](./readme_img/analysis2.png)


3. 동년배들과의 일별 소비 비교
- 오른쪽 일별 분석 클릭시 동년배들과 일별 소비를 비교하여 간단하게 나타내었다.

![analysis3](./readme_img/analysis3.png)

- 시현 영상

![analysis4](./readme_img/analysis4.gif)

</details>

### <b>소비 수정</b>
<details>
  <summary>자세히 보기</summary>

MYPAGE 클릭

![header_mypage](./readme_img/header_mypage.png)
\\

1. 캘린더 내에서 소비 내역 실시간 수정 가능

![calender1](./readme_img/calender1.png)

</details>

### <b>머신러닝 기능 소개</b>

<details>
  <summary>자세히 보기</summary>

- 엑셀파일 등록하면 카테고리를 머신러닝 기반으로 분류 후 데이터베이스에 저장


![table](./readme_img/table.gif)

</details>

---

## <img src="https://cdn-icons-png.flaticon.com/512/4329/4329979.png" width="23"> &nbsp;<strong>Trouble Shooting</strong>
<details>
  <summary>자세히 보기</summary>

![resolved_error](./readme_img/resolved_error.png)

</details>

