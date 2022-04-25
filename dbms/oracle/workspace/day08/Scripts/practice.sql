/*�����*/
/*PLAYER ���̺����� Ű�� NULL�� �������� Ű�� 170���� �����Ͽ� ��� ���ϱ�(NULL ����)*/
SELECT AVG(NVL(HEIGHT,170)) AS "��� Ű" FROM PLAYER;

/*�ǹ�*/
/*PLAYER ���̺����� �� �� �ִ� ������*/
SELECT TEAM_ID, MAX(WEIGHT) || 'kg' AS "�ִ� ������" FROM PLAYER
GROUP BY TEAM_ID
ORDER BY 1;

/*���*/
/*AVG �Լ��� ���� �ʰ� PLAYER ���̺����� �������� ��� Ű ���ϱ�(NULL ������)*/
SELECT ROUND(SUM(HEIGHT)/COUNT(HEIGHT),1) AS "��� Ű", ROUND(AVG(HEIGHT),1) AS "AVG"  FROM PLAYER;

/*�÷�Ƽ��*/
/*DEPT ���̺��� LOC�� ��� �޿��� �ݿø��� ���� �� LOC�� SAL �� ���� ��ȸ*/
SELECT * FROM DEPT;
SELECT * FROM EMP;

SELECT D.LOC, ROUND(AVG(E.SAL)), SUM(E.SAL) FROM DEPT D JOIN EMP E
ON D.DEPTNO = E.DEPTNO
GROUP BY LOC;

/*���̾�*/
/*PLAYER ���̺����� ���� �ִ� �������� ���� �˻�*/
SELECT * FROM PLAYER;
SELECT * FROM TEAM;

SELECT * 
FROM PLAYER P JOIN TEAM T
ON P.TEAM_ID = T.TEAM_ID
AND (P.TEAM_ID, P.WEIGHT) IN (SELECT TEAM_ID, MAX(WEIGHT) FROM PLAYER GROUP BY TEAM_ID)
ORDER BY P.TEAM_ID;



/*������*/
/*EMP ���̺����� HIREDATE�� FORD�� �Ի�⵵�� ���� ��� ��ü ���� ��ȸ*/
SELECT * FROM EMP;
SELECT * FROM DEPT;

SELECT * FROM EMP E JOIN (SELECT HIREDATE FROM EMP WHERE ENAME = 'FORD') E2
ON E.HIREDATE = E2.HIREDATE;

SELECT * 
FROM EMP E1 JOIN (SELECT HIREDATE FROM EMP WHERE ENAME = 'FORD') E2
ON TO_CHAR(E1.HIREDATE, 'YYYY') = TO_CHAR(E2.HIREDATE, 'YYYY');