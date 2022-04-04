/*AS(ALIAS) : 별칭*/
/*1. 결과 테이블에 표현할 컬럼명을 변경하고자 할 때*/
/*2. 길고 복잡한 컬럼명을 쉽게 사용하기 위해서*/

/*SELECT절 : 컬럼명 뒤에 AS 또는 한 칸 띄어쓰고 작성한다.*/

/*선수이름과 생일 조회*/
SELECT PLAYER_NAME AS 선수이름, BIRTH_DATE 생년월일 FROM PLAYER;

/*SELECT절에서 사용한 ALIAS는 다른 절에서 사용할 수 없다.*/
/*
 * SQL 실행 순서
 * 1 : FROM
 * 2 : WHERE
 * 3 : SELECT
 * */
SELECT PLAYER_NAME AS "선수 이름", BIRTH_DATE 생년월일 
FROM PLAYER
WHERE PLAYER_NAME = '김성환';

/*PLAYER 테이블에서 BACK_NO를 "등 번호"로, NICKNAME을 "선수 별명"으로 변경하여 검색*/
SELECT BACK_NO "등 번호", NICKNAME "선수 별명" FROM PLAYER;

/*CONCATENATION(연결)*/
/* '안녕' || '하세요' */

/*PLAYER 테이블에서 이름과 영어이름을 조회한다.*/
SELECT PLAYER_NAME || '의 영어 이름은' || E_PLAYER_NAME || '입니다.' AS 자기소개 FROM PLAYER;

/*누구누구의 별명은 머머이다.*/
SELECT PLAYER_NAME || '의 별명은 ' || NICKNAME || '이다.' FROM PLAYER;

/*누구누구의 포지션은 머머이다.*/
SELECT PLAYER_NAME || '의 포지션은 ' || "POSITION" || '이다.' FROM PLAYER;

/*LIKE : 포함된 문자열 값을 찾고, 문자의 개수에 제한을 줄 수 있다.*/
/* % : 모든 것 */
/* _ : 글자 수*/

/*
 * 예시
 * * '%A' : A로 끝나는 모든 값(FDNMSKA, 123FNDSA, ...)
 * * 'A%' : A로 시작하는 모든 값(ADSF, A2193DK, AAA, ADD, ...)
 * * 'A__' : A로 시작하면서 3글자인 값(ABC, AAA, ADD, ...)
 * * '_A' : A로 끝나면서 2글자인 값(FA, VA, DA, ...)
 * * '%A%' : A가 포함된 값(APPLE, BANANA, TASK, ...)
 * */

/*'천마'로 끝나는 팀 이름 찾기*/
SELECT TEAM_NAME 
FROM TEAM
/*WHERE NOT TEAM_NAME LIKE '%천마';*/
WHERE TEAM_NAME LIKE '%천마';

/*PLAYER 테이블에서 김씨 찾기*/
SELECT * FROM PLAYER
WHERE PLAYER_NAME LIKE '김%';

/*PLAYER 테이블에서 김씨 두 자(외 자) 찾기 */
SELECT * FROM PLAYER
WHERE PLAYER_NAME LIKE '김_';

/*PLAYER 테이블에서 김씨와 이씨 찾기*/
SELECT * FROM PLAYER
WHERE PLAYER_NAME LIKE '김%' OR PLAYER_NAME LIKE '이%';

/*PLAYER 테이블에서 이씨가 아닌 사람 찾기*/
SELECT * FROM PLAYER
WHERE PLAYER_NAME NOT LIKE '이%';

/*PLAYER 테이블에서 세 자가 아닌 김씨 찾기*/
SELECT * FROM PLAYER
WHERE NOT PLAYER_NAME LIKE '___' AND PLAYER_NAME LIKE '김%';

SELECT * FROM TBL_FLOWER;

/*NOT NULL 제약 조건*/
ALTER TABLE TBL_FLOWER MODIFY (FLOWER_PRICE NOT NULL);
ALTER TABLE TBL_FLOWER DROP CONSTRAINT SYS_C007169;

/*PLATER 테이블에서 POSITION이 NULL인 선수 검색*/
SELECT * FROM PLAYER
WHERE "POSITION" IS NULL;

/*별명이 NULL이 아닌 선수들만 조회한다.*/
SELECT PLAYER_NAME || '의 별명은 ' || NICKNAME || '이다.' AS 소개 FROM PLAYER
WHERE NICKNAME IS NOT NULL;

/*PLAYER 테이블에서 POSITION이 NULL이면 '미정'으로 결과 출력하기*/
SELECT NVL("POSITION", '미정') FROM PLAYER
WHERE "POSITION" IS NULL;

/*
 * PLAYER 테이블에서 NATION이 NULL이 아니면 '등록', NULL이면 '미등록'으로 변경한다.
 * 선수 이름과 선수 별명도 조회한다.
 * */
SELECT PLAYER_NAME, NVL(NICKNAME, '별명 없음') AS NICKNAME, NVL2(NATION, '등록', '미등록') NATION  
FROM PLAYER;

/*숫자형 함수*/

/*절대값*/
SELECT ABS(-10) FROM DUAL;

/*양의 정수(1), 영(0), 음의 정수(-1)*/
SELECT SIGN(4), SIGN(0), SIGN(-4) FROM DUAL;

/*나머지*/
SELECT MOD(10, 3) FROM DUAL;

/*값보다 큰 최근접 정수 : 올림*/
SELECT CEIL(3.14), CEIL(-3.14) FROM DUAL;

/*값보다 작은 최근접 정수 : 내림*/
SELECT FLOOR(3.14), FLOOR(-3.14) FROM DUAL;

/*버림*/
SELECT TRUNC(3.9), TRUNC(-3.9) FROM DUAL;

/*반올림*/
SELECT ROUND(3.4555555555616) FROM DUAL;
SELECT ROUND(3.4555555555616, 2) FROM DUAL;
SELECT ROUND(3.4555555555616, 1) FROM DUAL;

/*HEIGHT와 WEIGHT를 실수로 가정한다.*/
/*PLAYER 테이블에서 키는 소수점 둘 째자리까지 반올림, 몸무게는 소수점 버림으로 조회*/
/*키 또는 몸무게가 NULL이라면 원하는 수치로 변경시키도록 조회한다.*/
/*키 값 뒤에 cm를 붙여주고, 몸무게 값 뒤에 kg을 붙여준다.*/
SELECT PLAYER_NAME "선수 이름", NVL(ROUND(HEIGHT, 2), '184') || 'cm' 키, NVL(TRUNC(WEIGHT), 75) || 'kg' 몸무게 
FROM PLAYER;

/*
 * 집계 함수
 * 		여러 개의 값을 하나의 값으로 집계하여 나타낸다.
 * 		※ NULL은 포함하지 않는다.
 * 		※ WHERE 절에서는 사용할 수 없다.
 * */
/*
 * 평균 : AVG()
 * 최대값 : MAX()
 * 최소값 : MIN()
 * 총 합 : SUM()
 * 개수 : COUNT()
 * */
SELECT AVG(HEIGHT), MAX(HEIGHT), SUM(HEIGHT), MIN(HEIGHT), COUNT(HEIGHT) FROM PLAYER;
SELECT * FROM PLAYER;

/*PLAYER 테이블에서 HEIGHT 총 개수 검색(NULL을 포함해서 COUNT)*/
SELECT COUNT(NVL(HEIGHT, 0)) FROM PLAYER;

/*
 * 정렬 (ORDER BY) 
 * 		ASC : 오름 차순(DEFAULT)
 * 		DESC : 내림 차순
 * */

SELECT * FROM PLAYER
ORDER BY HEIGHT;

SELECT * FROM PLAYER
WHERE HEIGHT IS NOT NULL
ORDER BY HEIGHT DESC;

SELECT * FROM PLAYER
WHERE WEIGHT IS NOT NULL AND HEIGHT IS NOT NULL
ORDER BY HEIGHT ASC, WEIGHT DESC;

/*비추천, DBMS 버전별로 인식 못하는 문제 생김*/
SELECT * FROM PLAYER
WHERE HEIGHT IS NOT NULL
ORDER BY 12 DESC;

/*
 * PLAYER 테이블에서 키 순, 몸무게 순으로 오름 차순 검색
 * NULL이 아닌 값만 검색
 * 컬럼의 번호로 정렬한다.
 * 첫번째 컬럼 값이 같으면, 두번째 정렬을 진행한다.
 * */
SELECT * FROM PLAYER
WHERE WEIGHT IS NOT NULL AND HEIGHT IS NOT NULL
ORDER BY 12, 13;

/*
 * GROUP BY : ~별(예 : 포지션 별 평균 키)
 * GROUP BY 컬럼명 HAVING 조건식
 * WHERE절에서 우선적으로 처리할 조건식을 작성해야 속도가 향상된다.
 * */

/*PLAYER 테이블에서 포지션 종류 검색*/
SELECT "POSITION" FROM PLAYER
GROUP BY "POSITION"
HAVING "POSITION" IS NOT NULL;

SELECT "POSITION" FROM PLAYER
WHERE "POSITION" IS NOT NULL
GROUP BY "POSITION";

/*PLAYER 테이블에서 몸무게가 80이상인 선수들의 평균 키가 180이상인 포지션 검색*/
SELECT "POSITION", AVG(HEIGHT), MIN(WEIGHT) FROM PLAYER
WHERE WEIGHT >= 80
GROUP BY "POSITION" 
HAVING AVG(HEIGHT) >= 180;

/*EMPLOYEES 테이블에서 JOB_ID별 평균 SALARY가 10000미만인 JOB_ID 검색*/
/*JOB_ID는 알파벳 순으로 정렬(오름 차순)*/
SELECT JOB_ID, AVG(SALARY) FROM EMPLOYEES
GROUP BY JOB_ID
HAVING AVG(SALARY) < 10000
ORDER BY 2;

/*
 * PLAYER 테이블에서 전체 평균 키와 포지션별 평균 키 구하기
 * */










