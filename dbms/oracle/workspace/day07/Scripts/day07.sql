/*JOIN*/
/*EMP 테이블 사원번호로 DEPT 테이블의 지역 출력*/
SELECT * FROM EMP;	-- EMP 테이블의 정보 전체 출력
SELECT * FROM DEPT;	-- DEPT 테이블의 정보 전체 출력

SELECT EMPNO, ENAME, DNAME, LOC FROM DEPT JOIN EMP	-- DEPT 테이블과 EMP 테이블을 연결해서 EMPNO, ENAME, DNAME, LOC를 출력 
ON EMP.DEPTNO = DEPT.DEPTNO;	-- EMP의 DEPTNO와 DEPT의 DEPTNO가 일치하게 연결

/*PLAYER 테이블에서 송종국 선수가 속한 팀의 전화번호 출력하기*/
/*PLAYER 테이블의 컬럼 : TEAM_ID*/
/*TEAM 테이블의 컬럼 : TEAM_ID*/
SELECT * FROM PLAYER;	-- PLAYER 테이블의 정보 전체 출력
SELECT * FROM TEAM;		-- TEAM 테이블의 정보 전체 출력
SELECT COUNT(TEAM_ID) FROM PLAYER;	-- PLAYER 테이블의 TEAM_ID의 갯수 출력
/*TEAM 테이블을 선행테이블로 지정!*/
SELECT COUNT(TEAM_ID) FROM TEAM;	-- TEAM 테이블의 TEAM_ID의 갯수 출력

/*ON절 없이 JOIN만 사용 불가!*/
SELECT * FROM TEAM T JOIN PLAYER P	-- TEAM(T) 테이블과 PLAYER(P) 테이블을 연결해서 전체 출력
ON P.TEAM_ID = T.TEAM_ID	-- P의 TEAM_ID와 T의 TEAM_ID가 일치하게 연결
WHERE PLAYER_NAME = '송종국';	-- PLAYER_NAME이 '송중국'인 칼럼

SELECT P.TEAM_ID, PLAYER_NAME, TEL FROM TEAM T JOIN PLAYER P	-- TEAM(T) 테이블과 PLAYER(P) 테이블을 연결해서 P.TEAM_ID, PLAYER_NAME, TEL 출력
ON P.TEAM_ID = T.TEAM_ID AND PLAYER_NAME = '송종국';	-- P의 TEAM_ID와 T의 TEAM_ID가 일치하고 PLAYER_NAME이 '송중국'인 칼럼과 연결

/*JOBS 테이블에서 JOB_ID로 직원들의 JOB_TITLE, EMAIL, 성, 이름 출력*/
SELECT * FROM JOBS;	-- JOBS 테이블의 정보 전체 출력
SELECT * FROM EMPLOYEES;	-- EMPLOYEES 테이블의 정보 전체 출력

/*선행 테이블로 지정!*/
SELECT COUNT(JOB_ID) FROM JOBS;	-- JOBS 테이블의 JOB_ID 갯수 출력
SELECT COUNT(JOB_ID) FROM EMPLOYEES;	-- EMPLOYEES 테이블의 JOB_ID 갯수 출력

SELECT JOB_TITLE, EMAIL, LAST_NAME || ' ' || FIRST_NAME AS NAME	--JOB_TITLE, EMAIL, NAME(LAST_NAME || ' ' || FIRST_NAME) 출력
FROM JOBS J JOIN EMPLOYEES E	--JOBS(J) 테이블과 EMPLOYEES(E) 테이블을 연결
ON J.JOB_ID = E.JOB_ID;	-- J의 JOB_ID와 E의 JOB_ID가 일치하는 칼럼과 연결

/*EMP 테이블의 SAL를 SALGRADE 등급으로 나누기*/
SELECT * FROM EMP;	-- EMP 테이블의 정보 전체 출력
SELECT * FROM SALGRADE;	-- SALGRADE 테이블의 정보 전체 출력

SELECT GRADE, EMPNO, ENAME, SAL FROM SALGRADE S JOIN EMP E	-- SALGRADE(S)와 EMP(E) 테이블을 연결하여 GRADE, EMPNO, ENAME, SAL 출력
ON E.SAL BETWEEN S.LOSAL AND S.HISAL	-- E의 SAL이 S의 LOSAL과 S.HISAL 사이인 칼럼과 연결
ORDER BY GRADE DESC;	-- GRADE를 기준으로 내림차순 정렬

/*EMPLOYEES 테이블에서 HIREDATE가 2003~2005년까지인 사원의 정보와 부서명 출력*/
SELECT * FROM EMPLOYEES;	-- EMPLOYEES의 정보 전체 출력
SELECT * FROM DEPARTMENTS;	-- DEPARTMENTS의 정보 전체 출력

/*자동 형변환
 * 
 * DATE타입을 문자열과 비교할 땐 자동 형변환이 가능하다.
 * 대신 문자열 형식은 'YYYY-MM-DD', 'YYYYMMDD'로 작성해야 한다.
 * */
SELECT * FROM DEPARTMENTS D JOIN EMPLOYEES E	--DEPARTMENTS(D)와 EMPLOYEES(E) 테이블을 연결하여 전체 정보 출력
ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 	--D의 DEPARTMENT_ID와 E의 DEPARTMENT_ID가 일치하는 칼럼과 연결
AND HIRE_DATE BETWEEN '20030101' AND '20051231';	--그리고 HIRE_DATE가 '20030101'과 '20051231'사이인 칼럼과 연결

SELECT * FROM DEPARTMENTS D JOIN EMPLOYEES E	--DEPARTMENTS(D)와 EMPLOYEES(E) 테이블을 연결하여 전체 정보 출력
ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 	--D의 DEPARTMENT_ID와 E의 DEPARTMENT_ID가 일치하는 칼럼과 연결
AND HIRE_DATE BETWEEN '2003-01-01' AND '2005-12-31';	--그리고 HIRE_DATE가 '2003-01-01'과 '2005-12-31'사이인 칼럼과 연결

/*해당 일자까지 포함*/
SELECT * FROM DEPARTMENTS D JOIN EMPLOYEES E	--DEPARTMENTS(D)와 EMPLOYEES(E) 테이블을 연결하여 전체 정보 출력
ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 	--D의 DEPARTMENT_ID와 E의 DEPARTMENT_ID가 일치하는 칼럼과 연결
AND HIRE_DATE BETWEEN TO_DATE('2003-01-01', 'YYYY-MM-DD') AND TO_DATE('2005-12-24', 'YYYY-MM-DD');
--그리고 HIRE_DATE가 '2003-01-01'을 날짜형 데이터로 형 변환한 값과
--'2005-12-31'을 날짜형 데이터로 형 변환한 값 사이의 값을 가진 칼럼과 연결

/*해당 월 이전까지 포함*/
SELECT * FROM DEPARTMENTS D JOIN EMPLOYEES E	--DEPARTMENTS(D)와 EMPLOYEES(E) 테이블을 연결하여 전체 정보 출력
ON D.DEPARTMENT_ID = E.DEPARTMENT_ID	--D의 DEPARTMENT_ID와 E의 DEPARTMENT_ID가 일치하는 칼럼과 연결
AND HIRE_DATE BETWEEN TO_DATE('2003-01', 'YYYY-MM') AND TO_DATE('2005-12', 'YYYY-MM');
--그리고 HIRE_DATE가 '2003-01'을 날짜형 데이터로 형 변환한 값과
--'2005-12'을 날짜형 데이터로 형 변환한 값 사이의 값을 가진 칼럼과 연결

/*JOB_TITLE 중 'Manager'라는 문자열이 포함된 직업들의 평균 연봉을 JOB_TITLE별로 출력*/
SELECT * FROM JOBS;
SELECT * FROM EMPLOYEES;

SELECT JOB_TITLE, AVG(SALARY) 평균연봉 FROM JOBS J JOIN EMPLOYEES E
ON J.JOB_ID = E.JOB_ID AND JOB_TITLE LIKE '%Manager%'
GROUP BY JOB_TITLE;

/*EMP 테이블에서 ENAME에 L이 있는 사원들의 DNAME과 LOC 출력*/
SELECT * FROM EMP;
SELECT * FROM DEPT;

SELECT ENAME, DNAME, LOC FROM DEPT D JOIN EMP E
ON E.DEPTNO = D.DEPTNO AND ENAME LIKE '%L%';

/*축구 선수들 중에서 각 팀 별로 키가 가장 큰 선수들 출력*/
SELECT TEAM_ID, MAX(HEIGHT) M FROM PLAYER
GROUP BY TEAM_ID;

SELECT P1.TEAM_ID, PLAYER_NAME, HEIGHT, WEIGHT, BIRTH_DATE
FROM
	(
		SELECT TEAM_ID, MAX(HEIGHT) M FROM PLAYER
		GROUP BY TEAM_ID
	) P1 
JOIN PLAYER P2
ON P1.TEAM_ID = P2.TEAM_ID AND P1.M = P2.HEIGHT
ORDER BY 1;

/*축구 선수들 중에서 각 팀 별로 키가 가장 큰 선수들 출력*/
/*위 문제에서 JOIN을 사용하지 않고 조회*/
/*FROM 절에서 2개 이상의 테이블을 작성할 때 A, B와 같이 ,로 구분할 수 있다.*/
/*(A, B) IN ((C, D)) -> A = C AND B = D*/
SELECT * FROM PLAYER
WHERE (TEAM_ID, HEIGHT) IN (SELECT TEAM_ID, MAX(HEIGHT) FROM PLAYER GROUP BY TEAM_ID)
ORDER BY 3;

/*EMP 테이블에서 각 사원의 매니저 이름 조회*/
SELECT * FROM EMP;

SELECT E1.ENAME 사원, E2.ENAME 매니저 FROM EMP E1 JOIN EMP E2
ON E1.MGR = E2.EMPNO;



-------------------------------------------------------------------------------------------
/*브론즈*/
/*PLAYER 테이블에서 키가 NULL인 선수들은 키를 170으로 변경하여 평균 구하기(NULL 포함)*/
SELECT * FROM PLAYER
WHERE HEIGHT = NULL;

UPDATE PLAYER 
SET HEIGHT = 170
WHERE HEIGHT IS NULL;

SELECT AVG(HEIGHT) FROM PLAYER;

/*실버*/
/*PLAYER 테이블에서 팀 별 최대 몸무게*/
SELECT P.TEAM_ID, MAX(WEIGHT) FROM PLAYER P
GROUP BY TEAM_ID;

/*골드*/
/*AVG 함수를 쓰지 않고 PLAYER 테이블에서 선수들의 평균 키 구하기(NULL 포함)*/
SELECT SUM(HEIGHT) / COUNT(NVL(HEIGHT,0)) AS "평균 키" FROM PLAYER;

/*플래티넘*/
/*DEPT 테이블의 LOC별 평균 급여를 반올림한 값과 각 LOC별 SAL 총 합을 조회*/
SELECT * FROM DEPT;
SELECT * FROM EMP;

SELECT LOC, ROUND(AVG(SAL)) AS "평균 급여 반올림한 값", SUM(SAL) AS "LOC별 SAL 총 합"  FROM (SELECT * FROM EMP E JOIN DEPT D
ON E.DEPTNO = D.DEPTNO)
GROUP BY LOC;

/*다이아*/
/*PLAYER 테이블에서 팀별 최대 몸무게인 선수 출력*/

/*축구 선수들 중에서 각 팀 별로 키가 가장 큰 선수들 출력*/
SELECT P1.TEAM_ID, PLAYER_NAME, HEIGHT, WEIGHT, BIRTH_DATE
FROM
	(
		SELECT TEAM_ID, MAX(WEIGHT) M FROM PLAYER
		GROUP BY TEAM_ID
	) P1 
JOIN PLAYER P2
ON P1.TEAM_ID = P2.TEAM_ID AND P1.M = P2.WEIGHT
ORDER BY 1;

/*마스터*/
/*EMP 테이블에서 HIREDATE가 FORD의 입사년도와 같은 사원 전체 정보 조회*/
SELECT * FROM (SELECT E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM, D.DEPTNO, D.DNAME, D.LOC FROM EMP E JOIN DEPT D
ON E.DEPTNO = D.DEPTNO)
WHERE HIREDATE = 
(
	SELECT HIREDATE FROM EMP E2
	WHERE ENAME = 'FORD'
);

-- 부족하다고 느낀 풀이
SELECT * FROM EMP E1
WHERE HIREDATE = 
(
	SELECT HIREDATE FROM EMP E2
	WHERE ENAME = 'FORD'
);





-------------------------------------------------------------------------------------------