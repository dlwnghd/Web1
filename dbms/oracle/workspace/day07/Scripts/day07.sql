/*JOIN*/
/*EMP ���̺� �����ȣ�� DEPT ���̺��� ���� ���*/
SELECT * FROM EMP;	-- EMP ���̺��� ���� ��ü ���
SELECT * FROM DEPT;	-- DEPT ���̺��� ���� ��ü ���

SELECT EMPNO, ENAME, DNAME, LOC FROM DEPT JOIN EMP	-- DEPT ���̺�� EMP ���̺��� �����ؼ� EMPNO, ENAME, DNAME, LOC�� ��� 
ON EMP.DEPTNO = DEPT.DEPTNO;	-- EMP�� DEPTNO�� DEPT�� DEPTNO�� ��ġ�ϰ� ����

/*PLAYER ���̺��� ������ ������ ���� ���� ��ȭ��ȣ ����ϱ�*/
/*PLAYER ���̺��� �÷� : TEAM_ID*/
/*TEAM ���̺��� �÷� : TEAM_ID*/
SELECT * FROM PLAYER;	-- PLAYER ���̺��� ���� ��ü ���
SELECT * FROM TEAM;		-- TEAM ���̺��� ���� ��ü ���
SELECT COUNT(TEAM_ID) FROM PLAYER;	-- PLAYER ���̺��� TEAM_ID�� ���� ���
/*TEAM ���̺��� �������̺�� ����!*/
SELECT COUNT(TEAM_ID) FROM TEAM;	-- TEAM ���̺��� TEAM_ID�� ���� ���

/*ON�� ���� JOIN�� ��� �Ұ�!*/
SELECT * FROM TEAM T JOIN PLAYER P	-- TEAM(T) ���̺�� PLAYER(P) ���̺��� �����ؼ� ��ü ���
ON P.TEAM_ID = T.TEAM_ID	-- P�� TEAM_ID�� T�� TEAM_ID�� ��ġ�ϰ� ����
WHERE PLAYER_NAME = '������';	-- PLAYER_NAME�� '���߱�'�� Į��

SELECT P.TEAM_ID, PLAYER_NAME, TEL FROM TEAM T JOIN PLAYER P	-- TEAM(T) ���̺�� PLAYER(P) ���̺��� �����ؼ� P.TEAM_ID, PLAYER_NAME, TEL ���
ON P.TEAM_ID = T.TEAM_ID AND PLAYER_NAME = '������';	-- P�� TEAM_ID�� T�� TEAM_ID�� ��ġ�ϰ� PLAYER_NAME�� '���߱�'�� Į���� ����

/*JOBS ���̺��� JOB_ID�� �������� JOB_TITLE, EMAIL, ��, �̸� ���*/
SELECT * FROM JOBS;	-- JOBS ���̺��� ���� ��ü ���
SELECT * FROM EMPLOYEES;	-- EMPLOYEES ���̺��� ���� ��ü ���

/*���� ���̺�� ����!*/
SELECT COUNT(JOB_ID) FROM JOBS;	-- JOBS ���̺��� JOB_ID ���� ���
SELECT COUNT(JOB_ID) FROM EMPLOYEES;	-- EMPLOYEES ���̺��� JOB_ID ���� ���

SELECT JOB_TITLE, EMAIL, LAST_NAME || ' ' || FIRST_NAME AS NAME	--JOB_TITLE, EMAIL, NAME(LAST_NAME || ' ' || FIRST_NAME) ���
FROM JOBS J JOIN EMPLOYEES E	--JOBS(J) ���̺�� EMPLOYEES(E) ���̺��� ����
ON J.JOB_ID = E.JOB_ID;	-- J�� JOB_ID�� E�� JOB_ID�� ��ġ�ϴ� Į���� ����

/*EMP ���̺��� SAL�� SALGRADE ������� ������*/
SELECT * FROM EMP;	-- EMP ���̺��� ���� ��ü ���
SELECT * FROM SALGRADE;	-- SALGRADE ���̺��� ���� ��ü ���

SELECT GRADE, EMPNO, ENAME, SAL FROM SALGRADE S JOIN EMP E	-- SALGRADE(S)�� EMP(E) ���̺��� �����Ͽ� GRADE, EMPNO, ENAME, SAL ���
ON E.SAL BETWEEN S.LOSAL AND S.HISAL	-- E�� SAL�� S�� LOSAL�� S.HISAL ������ Į���� ����
ORDER BY GRADE DESC;	-- GRADE�� �������� �������� ����

/*EMPLOYEES ���̺��� HIREDATE�� 2003~2005������� ����� ������ �μ��� ���*/
SELECT * FROM EMPLOYEES;	-- EMPLOYEES�� ���� ��ü ���
SELECT * FROM DEPARTMENTS;	-- DEPARTMENTS�� ���� ��ü ���

/*�ڵ� ����ȯ
 * 
 * DATEŸ���� ���ڿ��� ���� �� �ڵ� ����ȯ�� �����ϴ�.
 * ��� ���ڿ� ������ 'YYYY-MM-DD', 'YYYYMMDD'�� �ۼ��ؾ� �Ѵ�.
 * */
SELECT * FROM DEPARTMENTS D JOIN EMPLOYEES E	--DEPARTMENTS(D)�� EMPLOYEES(E) ���̺��� �����Ͽ� ��ü ���� ���
ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 	--D�� DEPARTMENT_ID�� E�� DEPARTMENT_ID�� ��ġ�ϴ� Į���� ����
AND HIRE_DATE BETWEEN '20030101' AND '20051231';	--�׸��� HIRE_DATE�� '20030101'�� '20051231'������ Į���� ����

SELECT * FROM DEPARTMENTS D JOIN EMPLOYEES E	--DEPARTMENTS(D)�� EMPLOYEES(E) ���̺��� �����Ͽ� ��ü ���� ���
ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 	--D�� DEPARTMENT_ID�� E�� DEPARTMENT_ID�� ��ġ�ϴ� Į���� ����
AND HIRE_DATE BETWEEN '2003-01-01' AND '2005-12-31';	--�׸��� HIRE_DATE�� '2003-01-01'�� '2005-12-31'������ Į���� ����

/*�ش� ���ڱ��� ����*/
SELECT * FROM DEPARTMENTS D JOIN EMPLOYEES E	--DEPARTMENTS(D)�� EMPLOYEES(E) ���̺��� �����Ͽ� ��ü ���� ���
ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 	--D�� DEPARTMENT_ID�� E�� DEPARTMENT_ID�� ��ġ�ϴ� Į���� ����
AND HIRE_DATE BETWEEN TO_DATE('2003-01-01', 'YYYY-MM-DD') AND TO_DATE('2005-12-24', 'YYYY-MM-DD');
--�׸��� HIRE_DATE�� '2003-01-01'�� ��¥�� �����ͷ� �� ��ȯ�� ����
--'2005-12-31'�� ��¥�� �����ͷ� �� ��ȯ�� �� ������ ���� ���� Į���� ����

/*�ش� �� �������� ����*/
SELECT * FROM DEPARTMENTS D JOIN EMPLOYEES E	--DEPARTMENTS(D)�� EMPLOYEES(E) ���̺��� �����Ͽ� ��ü ���� ���
ON D.DEPARTMENT_ID = E.DEPARTMENT_ID	--D�� DEPARTMENT_ID�� E�� DEPARTMENT_ID�� ��ġ�ϴ� Į���� ����
AND HIRE_DATE BETWEEN TO_DATE('2003-01', 'YYYY-MM') AND TO_DATE('2005-12', 'YYYY-MM');
--�׸��� HIRE_DATE�� '2003-01'�� ��¥�� �����ͷ� �� ��ȯ�� ����
--'2005-12'�� ��¥�� �����ͷ� �� ��ȯ�� �� ������ ���� ���� Į���� ����

/*JOB_TITLE �� 'Manager'��� ���ڿ��� ���Ե� �������� ��� ������ JOB_TITLE���� ���*/
SELECT * FROM JOBS;	-- JOBS ���̺��� ��ü ���� ���
SELECT * FROM EMPLOYEES;	-- EMPLOYEES ���̺��� ��ü ���� ���

SELECT JOB_TITLE, AVG(SALARY) ��տ��� FROM JOBS J JOIN EMPLOYEES E	-- 
ON J.JOB_ID = E.JOB_ID AND JOB_TITLE LIKE '%Manager%'
GROUP BY JOB_TITLE;

/*EMP ���̺��� ENAME�� L�� �ִ� ������� DNAME�� LOC ���*/
SELECT * FROM EMP;
SELECT * FROM DEPT;

SELECT ENAME, DNAME, LOC FROM DEPT D JOIN EMP E
ON E.DEPTNO = D.DEPTNO AND ENAME LIKE '%L%';

/*�౸ ������ �߿��� �� �� ���� Ű�� ���� ū ������ ���*/
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

/*�౸ ������ �߿��� �� �� ���� Ű�� ���� ū ������ ���*/
/*�� �������� JOIN�� ������� �ʰ� ��ȸ*/
/*FROM ������ 2�� �̻��� ���̺��� �ۼ��� �� A, B�� ���� ,�� ������ �� �ִ�.*/
/*(A, B) IN ((C, D)) -> A = C AND B = D*/
SELECT * FROM PLAYER
WHERE (TEAM_ID, HEIGHT) IN (SELECT TEAM_ID, MAX(HEIGHT) FROM PLAYER GROUP BY TEAM_ID)
ORDER BY 3;

/*EMP ���̺��� �� ����� �Ŵ��� �̸� ��ȸ*/
SELECT * FROM EMP;

SELECT E1.ENAME ���, E2.ENAME �Ŵ��� FROM EMP E1 JOIN EMP E2
ON E1.MGR = E2.EMPNO;



-------------------------------------------------------------------------------------------
/*�����*/
/*PLAYER ���̺��� Ű�� NULL�� �������� Ű�� 170���� �����Ͽ� ��� ���ϱ�(NULL ����)*/
SELECT * FROM PLAYER
WHERE HEIGHT = NULL;

UPDATE PLAYER 
SET HEIGHT = 170
WHERE HEIGHT IS NULL;

SELECT AVG(HEIGHT) FROM PLAYER;

/*�ǹ�*/
/*PLAYER ���̺��� �� �� �ִ� ������*/
SELECT P.TEAM_ID, MAX(WEIGHT) FROM PLAYER P
GROUP BY TEAM_ID;

/*���*/
/*AVG �Լ��� ���� �ʰ� PLAYER ���̺��� �������� ��� Ű ���ϱ�(NULL ����)*/
SELECT SUM(HEIGHT) / COUNT(NVL(HEIGHT,0)) AS "��� Ű" FROM PLAYER;

/*�÷�Ƽ��*/
/*DEPT ���̺��� LOC�� ��� �޿��� �ݿø��� ���� �� LOC�� SAL �� ���� ��ȸ*/
SELECT * FROM DEPT;
SELECT * FROM EMP;

SELECT LOC, ROUND(AVG(SAL)) AS "��� �޿� �ݿø��� ��", SUM(SAL) AS "LOC�� SAL �� ��"  FROM (SELECT * FROM EMP E JOIN DEPT D
ON E.DEPTNO = D.DEPTNO)
GROUP BY LOC;

/*���̾�*/
/*PLAYER ���̺��� ���� �ִ� �������� ���� ���*/

/*�౸ ������ �߿��� �� �� ���� Ű�� ���� ū ������ ���*/
SELECT P1.TEAM_ID, PLAYER_NAME, HEIGHT, WEIGHT, BIRTH_DATE
FROM
	(
		SELECT TEAM_ID, MAX(WEIGHT) M FROM PLAYER
		GROUP BY TEAM_ID
	) P1 
JOIN PLAYER P2
ON P1.TEAM_ID = P2.TEAM_ID AND P1.M = P2.WEIGHT
ORDER BY 1;

/*������*/
/*EMP ���̺��� HIREDATE�� FORD�� �Ի�⵵�� ���� ��� ��ü ���� ��ȸ*/
SELECT * FROM (SELECT E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM, D.DEPTNO, D.DNAME, D.LOC FROM EMP E JOIN DEPT D
ON E.DEPTNO = D.DEPTNO)
WHERE HIREDATE = 
(
	SELECT HIREDATE FROM EMP E2
	WHERE ENAME = 'FORD'
);

-- �����ϴٰ� ���� Ǯ��
SELECT * FROM EMP E1
WHERE HIREDATE = 
(
	SELECT HIREDATE FROM EMP E2
	WHERE ENAME = 'FORD'
);





-------------------------------------------------------------------------------------------