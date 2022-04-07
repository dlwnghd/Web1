/*브론즈*/
/*PLAYER 테이블에서 키가 NULL인 선수들은 키를 170으로 변경하여 평균 구하기(NULL 포함)*/
SELECT AVG(NVL(HEIGHT,170)) AS "평균 키" FROM PLAYER;

/*실버*/
/*PLAYER 테이블에서 팀 별 최대 몸무게*/
SELECT TEAM_ID, MAX(WEIGHT) || 'kg' AS "최대 몸무게" FROM PLAYER
GROUP BY TEAM_ID
ORDER BY 1;

/*골드*/
/*AVG 함수를 쓰지 않고 PLAYER 테이블에서 선수들의 평균 키 구하기(NULL 미포함)*/
SELECT ROUND(SUM(HEIGHT)/COUNT(HEIGHT),1) AS "평균 키", ROUND(AVG(HEIGHT),1) AS "AVG"  FROM PLAYER;

/*플래티넘*/
/*DEPT 테이블의 LOC별 평균 급여를 반올림한 값과 각 LOC별 SAL 총 합을 조회*/
SELECT * FROM DEPT;
SELECT * FROM EMP;

SELECT D.LOC, ROUND(AVG(E.SAL)), SUM(E.SAL) FROM DEPT D JOIN EMP E
ON D.DEPTNO = E.DEPTNO
GROUP BY LOC;

/*다이아*/
/*PLAYER 테이블에서 팀별 최대 몸무게인 선수 검색*/
SELECT * FROM PLAYER;
SELECT * FROM TEAM;

SELECT * 
FROM PLAYER P JOIN TEAM T
ON P.TEAM_ID = T.TEAM_ID
AND (P.TEAM_ID, P.WEIGHT) IN (SELECT TEAM_ID, MAX(WEIGHT) FROM PLAYER GROUP BY TEAM_ID)
ORDER BY P.TEAM_ID;



/*마스터*/
/*EMP 테이블에서 HIREDATE가 FORD의 입사년도와 같은 사원 전체 정보 조회*/
SELECT * FROM EMP;
SELECT * FROM DEPT;

SELECT * FROM EMP E JOIN (SELECT HIREDATE FROM EMP WHERE ENAME = 'FORD') E2
ON E.HIREDATE = E2.HIREDATE;

SELECT * 
FROM EMP E1 JOIN (SELECT HIREDATE FROM EMP WHERE ENAME = 'FORD') E2
ON TO_CHAR(E1.HIREDATE, 'YYYY') = TO_CHAR(E2.HIREDATE, 'YYYY');