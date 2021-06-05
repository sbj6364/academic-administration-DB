# Academic Administration DB
> Database for academic administration of Sejong Univ.



### Outline | 개요

세종 학사관리 데이터베이스에 대한 요구사항은 다음과 같다.

- 모든 학생은 학생번호를 부여하여 식별하며 학생이름, 학생주소. 학생전화번호. 학생이메일, 전공 학과, 지도교수 정보, 등록금 납부 계좌 정보를 가진다. 학생은 부전공을 1개까지 신청할 수 있다. 학생은 한학기에 최대 10학점까지만 수강 할 수 있다.
- 교수는 소속학과가 반드시 있어야 하고, 학생을 반드시 담당해야 하며, 강좌에 대한 강의를 반드시 해야 한다. 교수는 1개 이상의 복수 학과에 소속이 가능하다.
- 모든 교수는 교수번호를 부여하여 식별하며 교수이름, 교수주소, 교수전화번호. 교수이메일. 소속 학과번호 정보를 가진다.
- 교수와 학생은 학생번호와 교수번호를 이용한 지도 관계를 가지며, 해당 관계에는 현재 학년/학기 정보를 포함한다.
- 학과는 학과번호를 부여하여 식별하며 학과명, 학과전화번호, 학과사무실 정보를 가진다. 해당 학과에서 개설하는 강좌가 반드시 1개 이상 존재해야 하며, 동시에 학과장이 1명 있어야 한다.

- 강좌는 강좌번호, 분반번호, 강의하는 교수, 강좌이름, 강의요일, 강의교시, 취득학점 (1-4), 강좌시간 (1-6), 개설 학과, 강의실 정보가 필요하다.

- 수강내역은 학생번호, 강좌번호. 교수번호를 부여하여 식별하며 출석점수, 중간고사점수, 기말고사점수, 기타 점수, 총점 (0 ~ 100), 평점 (A ~ F) 정보를 가진다.

- 학생은 1개 이상의 동아리에 가입이 가능하다. 동아리는 동아리 번호, 동아리 이름, 소속 학생 숫자, 회장 학생 정보, 동아리 지도 교수 정보, 동아리방 정보 등을 가져야 한다.

- 학생별 등록금 납부 내역을 기록해야 한다. 학생 번호, 등록금 납부 연도, 등록금 납부 학기, 등록금 총액, 납부 총액, 마지막 납부 일자가 기록되야 한다. 납부 총액이 등록금 총액 보다 작을 경우에는 수강내역 “신규 삽입”에서 “등록금 미납”오류를 표시해야 한다.

> 위의 기능 요구사항을 구현하기 위해서 필요한 속성이 있다면, 반영하여 스키마 디자인 시에 **추가** 가능. Project는 2인 1조로 진행되지만, 타과 수업인 관계로 본인은 1인 1팀으로 혼자 진행하게 되었다. ~~우리 과는 왜 DB 안열어줘요?????~~



#### [Details | 세부 설계](./details.md)

> 본 내용에 대한 세부적인 설계 사항이다.



### Development Tools | 개발 언어 및 개발 도구

- **DBMS** : MySQL 8.0.15 or later
- **Language** : JAVA (Oracle JAVA SE 11 이상)
- **Tool** : Eclipse

 

### Environment | 개발 환경

- 사용자 인터페이스는 반드시 GUI (Graphical User Interface)를 사용한다. 단, GUI 구동에 필요한 라이브러리는 기본 JDK에 포함되어 있는 것으로 한정한다. (별도의 설치가 필요한 GUI package는 인정되지 않고 0점 처리됨)
- 개발도구는 반드시 Eclipse를 사용한다. (이외의 다른 개발도구로 만들어진 소스코드는 채점하지 않고 0점 처리됨)

 

### Requirements Statement & Schema Definition | 요구사항 명세서 및 스키마 정의서

> [Details](./details.md)

- 요구사항 명세서에는 데이터베이스 설계에 필요한 사용자 요구사항을 항목별로 정리한다. (사용자 인터페이스 및 구현될 삽입/삭제/변경/검색 기능과 관련된 요구사항도 모두 정리할 것)
- 스키마 정의는 MySQL의 EER Diagram 도구를 활용해서 작성한다.
- 프로그램의 테스팅을 위해서 스키마 설계를 한 후에 각 테이블에 대한 “샘플” 데이터를 만든다. (샘플 데이터는 각 테이블 당 최소한 25개 이상으로 각자가 만들어 넣음)

 

### Requirements | 개발 요구사항

> 모든 내용은 하나의 창 안에서 작동해야 한다.

1. 사용자 계정은 madang/madang 으로 코드에 포함시킨다. 즉, 프로그램을 구동하면 바로 MySQL로 접속되어 사용 가능해야 함.
   - Eclipse의 JAVA Project 이름은 반드시 제출자의 “학번”으로 정한다.
     예) 학번이 18013001 인 경우 제출하는 압축파일 안의 프로젝트 디렉토리 명이 반드시 18013001 이어야 함.

2. MySQL 접속 코드는 중간고사 시에 제공된 샘플코드와 “동일”한 코드를 사용한다. (이외의 접속 코드 사용시에는 0점 처리됨)
   
3. 접속 후에는 관리자/교수/학생에 대한 기능을 구현한다. 단, 채점의 용이성을 위해서 관리자/일반사용자 모두 madang 계정을 이용한다. 즉, madang 계정으로 자동 로그인 한후, GUI 화면에서 관리자/교수/학생을 택하여 다음 화면으로 넘어가는 형태로 구현한다.

4. **Manager**: 관리자에 대해서 다음의 기능을 구현한다.

   - 데이터베이스 초기화 기능

   - 데이터베이스에 포함된 모든 테이블에 대한 입력/삭제/변경 기능

     > 단, 삭제/변경은 “1개”의 고정된 특정 조건이 아닌 “조건식”을 입력 받아서 삭제/변경하는 방식으로 구현해야 함

   - 전체 테이블 보기 기능 : 모든 테이블의 내용을 보여주는 기능

5. **Professor**: 교수 사용자에 대해서 다음의 기능을 구현한다.
   - 입력된 연도/학기에 본인이 강의했던 과목에 대한 모든 정보를 보여주는 기능
   - 위에서 표시된 과목 정보 중에서 하나를 “클릭”하면 해당 과목을 수강하는 (혹은 수강했던) 모든 학생에 대한 정보를 보여주는 기능
   - 현재 본인이 “지도”하는 학생에 대한 정보를 보여주는 기능
   - 위에서 표시된 학생 정보 중에서 하나를 “클릭”하면 해당 학생이 수강했던 (혹은 수강하고 있는) 모든 과목에 대한 “성적” 정보를 보여주는 기능
   - 본인이 소속된 학과에 대한 정보(학과장 정보 포함)를 보여주는 기능
   - 현재 학기에 대한 “강의 시간표” 표시 기능 : 현재 학기에 강의하는 과목을 시간표 형태로 표시함. 시간표는 요일/교시
   - 현재 본인이 강의하는 과목에 대한 성적 입력 기능
   
6. **Student**: 학생 사용자에 대해서 다음의 기능을 구현한다.
   - 입력된 연도/학기에 본인이 수강했던 과목에 대한 모든 정보를 보여주는 기능
   - 현재 학기에 본인이 수강하는 모든 과목을 시간표 형태로 표시하는 기능
   - 본인이 소속된 동아리에 대한 정보를 보여주는 기능
     단, 동아리 회장의 경우에는 동아리에 “속한” 모든 학생들에 대한 정보를 보여주는 기능이 구현되어야 함
   - 본인의 성적표를 보여주는 기능 : 과목번호/과목명/취득학점/평점은 반드시 표시되어야 하며, GPA (grade point average)도 표시되어야 한다.



- 주의! : “입력” 기능의 경우 반드시 하나의 윈도우 안에서 모든 데이터를 기입하고 버튼 클릭 한번으로 입력되도록 구현함.  
  <u>*ex) 입력해야할 속성이 4개라면, 속성1/속성2/속성3/속성4에 대한 입력값을 하나의 GUI 윈도우에서 입력받아야 하며, 저장/취소 버튼이 있어서 저장 (즉, 입력 실행) 혹은 취소 (입력 취소) 기능이 구현되어야 함.*</u>

- 오류 처리 : 제약조건을 벗어난 입력값에 대해서는 적절한 오류 메시지를 표시하고 저장이 안 되어야 한다. 또한, 프로그램을 종료해서도 안됨.

- 데이터베이스 초기화 기능은 다음의 SQL을 이용해서 구현함

  - `drop table if exists`
  - `create table`
  - `insert into`

- 시간표 표시 예시

  ![time-table](./img/time_table.png)

   

### Submission

1. **소스코드** (데이터베이스 초기화 코드 포함)
2. **최종보고서** (학번/이름, 요구사항 분석 내용, 스키마 설계, 프로그램 구조, 테스팅 방법 등을 모두 포함하여 자유 양식으로 작성함)
3. [주의] 최종보고서 안의 테스팅 방법은 구현된 모든 기능을 포함해야 한다.
4. 스키마 설계 부분은 MySQL의 EER Diagram 도구를 사용함

 

### Submission Method

1. 최종보고서 파일을 과제물이 포함된 workspace 프로젝트 디렉토리로 복사하고, 해당 디렉토리 전체를 압축한 후에, 블랙보드 과제 게시판을 통해서 제출한다.
2. 제출 마감 : **2021년 06월 08일(15주차 화요일) 자정**
3. 2인 1조로 구현했을 경우에는 2명 모두 제출해야 함.
4. 같은 팀원이 제출한 소스코드가 완전히 동일하지 않고 틀릴 경우에는 해당 팀원 모두에 대해서 0점 처리함
5. 제출시한을 넘겨서 제출할 경우에는 **“0”**점 처리됨

 

### Scoring (30%)

1. 최종 완료보고서 : 전체성적대비 5%, 100점 만점
2. 최종 소스코드 : 전체성적대비 25%, 100점 만점
3. 프로젝트에 관련된 모든 “5. 개발요구사항” 1) ~ 8)을 반드시 만족하여 구현해야 하며, **요구사항과 틀리게 구현된 소스는 해당 부분을** **0**점 처리함

 

*** 주의 : **프로그램을 복사하여 제출하는 경우에는 원본과 복사본을 불문하고 모두 **FA**학점 처리됨!









#### 2021.06.01. 보충수업 내용

> 수업 영상 [youtube live](https://www.youtube.com/watch?v=3tFKFw2-5Mg)

- 채점 기준 - 테이블 수, 이런거 상관 없음. 스키마 디자인 (테이블 형태, 속성, 관계 등등)에 대해서는 점수부여 X
- 삭제 변경 시 조건식이랑 속성 관계연산자 값의 형태만 유지하면 됨
- 올려준 건 minimum 요구사항. 필요한 속성이 있다면 위의 기본 요구사항에 반영하여 스키마 디자인 시 "추가" 할 수 있음
- 교수 사진 부분 뺐음!!
- [java에서 외부sql 파일 실행](https://pythonq.com/so/java/1468176)
- 테이블 6~7개 나올 거임..
- 기말고사는 중간보다 더 쉬울 것이다.
- 동아리 회장 -> 검색해서 알 수 있음. 이사람이 회장인 경우 버튼을 넣으면 된다. 아니면 다 주고, 누르면 검색해볼 수도 있다.
- 강좌번호 주키, 동아리번호 주키, 등록금 납부 
- 새 학과 만들 때는 강의도 함께 개설해야 함. (강의를 넣고, 학과)
- 최종 성적은 절대평가이며, 분반 별 별도로 부여함

