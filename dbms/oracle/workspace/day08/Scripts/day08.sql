/*브론즈*/
/*PLAYER 테이블에서 키가 NULL인 선수들은 키를 170으로 변경하여 평균 구하기(NULL 포함)*/
SELECT ROUND(AVG(NVL(HEIGHT, 170)), 2) "평균 키" FROM PLAYER;

/*실버*/
/*PLAYER 테이블에서 팀 별 최대 몸무게*/
SELECT TEAM_ID, MAX(WEIGHT) || 'kg' "최대 몸무게" FROM PLAYER
GROUP BY TEAM_ID
ORDER BY 1;

/*골드*/
/*AVG 함수를 쓰지 않고 PLAYER 테이블에서 선수들의 평균 키 구하기(NULL 미포함)*/
SELECT SUM(HEIGHT) / COUNT(HEIGHT) "평균 키" FROM PLAYER;

/*플래티넘*/
/*DEPT 테이블의 LOC별 평균 급여를 반올림한 값과 각 LOC별 SAL 총 합을 조회*/
SELECT * FROM DEPT;
SELECT * FROM EMP;

SELECT ROUND(AVG(SAL)), SUM(SAL) FROM DEPT D, EMP E
WHERE D.DEPTNO = E.DEPTNO
GROUP BY LOC;

SELECT ROUND(AVG(SAL)), SUM(SAL) FROM DEPT D JOIN EMP E
ON D.DEPTNO = E.DEPTNO
GROUP BY LOC;

/*다이아*/
/*PLAYER 테이블에서 팀별 최대 몸무게인 선수 검색*/
SELECT * 
FROM PLAYER P JOIN TEAM T
ON P.TEAM_ID = T.TEAM_ID
AND (P.TEAM_ID, P.WEIGHT) IN (SELECT TEAM_ID, MAX(WEIGHT) FROM PLAYER GROUP BY TEAM_ID)
ORDER BY P.TEAM_ID;

/*마스터*/
/*EMP 테이블에서 HIREDATE가 FORD의 입사년도와 같은 사원 전체 정보 조회*/
SELECT * FROM EMP
WHERE TO_CHAR(HIREDATE, 'YYYY') = (SELECT TO_CHAR(HIREDATE, 'YYYY') FROM EMP WHERE ENAME = 'FORD');

SELECT * 
FROM EMP E1 JOIN (SELECT HIREDATE FROM EMP WHERE ENAME = 'FORD') E2
ON TO_CHAR(E1.HIREDATE, 'YYYY') = TO_CHAR(E2.HIREDATE, 'YYYY');

/*
 *   TRUNC(DATE, 'FORMAT')
 *
 *       DATE에서 FORMAT에 작성한 부분 이후 부터 버림(초기화)
 * 
 */
SELECT TRUNC(SYSDATE, 'Y') FROM DUAL;
SELECT TRUNC(SYSDATE, 'MM') FROM DUAL;

/*SUBSTR(컬럼명, 시작번호, 길이) : 시작 번호부터 길이만큼 자르기*/
/*SUBSTR(컬럼명, 시작번호) : 시작 번호부터 마지막까지 자르기*/

SELECT SUBSTR('BUSAPPLEBANANA', 1, 3)  FROM DUAL;
SELECT SUBSTR('BUSAPPLEBANANA', 4, 5)  FROM DUAL;
SELECT SUBSTR('BUSAPPLEBANANA', 9)  FROM DUAL;

/*
 * DATE 타입은 문자열로 형변환 시 DEFAULT 서식은 아래와 같다
 * YY/MM/DD
 * 
 * 만약 형식을 바꾸고 싶다면, TO_CHAR(DATE, 'YYYY')와 같이 변경한 뒤 사용한다.
 * */
SELECT SUBSTR(SYSDATE, 1, 2) FROM DUAL;
SELECT SUBSTR(TO_CHAR(SYSDATE, 'YYYY-MM-DD'), 1, 4) FROM DUAL;

SELECT * FROM EMP
WHERE HIREDATE LIKE (SELECT SUBSTR(HIREDATE, 1, 2) FROM EMP WHERE ENAME = 'FORD') || '%';


SELECT * FROM TEST001;
SELECT * FROM COPY_EMP;

/*SCOTT 계정에 있는 테이블 중에서 SALGRADE를 복사한 후 GRADE 컬럼명을 LEVEL로 변경*/
/*
 * 값을 반대로 바꾸기
 * 
 * 1 -> 5
 * 2 -> 4
 * 3 -> 3
 * 4 -> 2
 * 5 -> 1
 * 
 * */
SELECT * FROM SALGRADE;
create table copy_salgrade as select * from SCOTT.SALGRADE;
ALTER TABLE copy_salgrade RENAME COLUMN GRADE TO "LEVEL";
SELECT * FROM copy_salgrade;

UPDATE copy_salgrade
SET "LEVEL" = 6 - "LEVEL";

/*HR 계정의 DEPT 테이블을 새로 만든 계정으로 복사, 복사한 테이블에서 LOC별 평균 급여 검색*/
create table copy_dept as select * from HR.DEPT;
create table copy_emp as select * from HR.EMP;

SELECT AVG() FROM copy_dept;