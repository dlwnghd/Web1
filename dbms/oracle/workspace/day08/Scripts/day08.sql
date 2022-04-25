/*�����*/
/*PLAYER ���̺����� Ű�� NULL�� �������� Ű�� 170���� �����Ͽ� ��� ���ϱ�(NULL ����)*/
SELECT ROUND(AVG(NVL(HEIGHT, 170)), 2) "��� Ű" FROM PLAYER;

/*�ǹ�*/
/*PLAYER ���̺����� �� �� �ִ� ������*/
SELECT TEAM_ID, MAX(WEIGHT) || 'kg' "�ִ� ������" FROM PLAYER
GROUP BY TEAM_ID
ORDER BY 1;

/*���*/
/*AVG �Լ��� ���� �ʰ� PLAYER ���̺����� �������� ��� Ű ���ϱ�(NULL ������)*/
SELECT SUM(HEIGHT) / COUNT(HEIGHT) "��� Ű" FROM PLAYER;

/*�÷�Ƽ��*/
/*DEPT ���̺��� LOC�� ��� �޿��� �ݿø��� ���� �� LOC�� SAL �� ���� ��ȸ*/
SELECT * FROM DEPT;
SELECT * FROM EMP;

SELECT ROUND(AVG(SAL)), SUM(SAL) FROM DEPT D, EMP E
WHERE D.DEPTNO = E.DEPTNO
GROUP BY LOC;

SELECT ROUND(AVG(SAL)), SUM(SAL) FROM DEPT D JOIN EMP E
ON D.DEPTNO = E.DEPTNO
GROUP BY LOC;

/*���̾�*/
/*PLAYER ���̺����� ���� �ִ� �������� ���� �˻�*/
SELECT * 
FROM PLAYER P JOIN TEAM T
ON P.TEAM_ID = T.TEAM_ID
AND (P.TEAM_ID, P.WEIGHT) IN (SELECT TEAM_ID, MAX(WEIGHT) FROM PLAYER GROUP BY TEAM_ID)
ORDER BY P.TEAM_ID;

/*������*/
/*EMP ���̺����� HIREDATE�� FORD�� �Ի�⵵�� ���� ��� ��ü ���� ��ȸ*/
SELECT * FROM EMP
WHERE TO_CHAR(HIREDATE, 'YYYY') = (SELECT TO_CHAR(HIREDATE, 'YYYY') FROM EMP WHERE ENAME = 'FORD');

SELECT * 
FROM EMP E1 JOIN (SELECT HIREDATE FROM EMP WHERE ENAME = 'FORD') E2
ON TO_CHAR(E1.HIREDATE, 'YYYY') = TO_CHAR(E2.HIREDATE, 'YYYY');

/*
 *   TRUNC(DATE, 'FORMAT')
 *
 *       DATE���� FORMAT�� �ۼ��� �κ� ���� ���� ����(�ʱ�ȭ)
 * 
 */
SELECT TRUNC(SYSDATE, 'Y') FROM DUAL;
SELECT TRUNC(SYSDATE, 'MM') FROM DUAL;

/*SUBSTR(�÷���, ���۹�ȣ, ����) : ���� ��ȣ���� ���̸�ŭ �ڸ���*/
/*SUBSTR(�÷���, ���۹�ȣ) : ���� ��ȣ���� ���������� �ڸ���*/

SELECT SUBSTR('BUSAPPLEBANANA', 1, 3)  FROM DUAL;
SELECT SUBSTR('BUSAPPLEBANANA', 4, 5)  FROM DUAL;
SELECT SUBSTR('BUSAPPLEBANANA', 9)  FROM DUAL;

/*
 * DATE Ÿ���� ���ڿ��� ����ȯ �� DEFAULT ������ �Ʒ��� ����
 * YY/MM/DD
 * 
 * ���� ������ �ٲٰ� �ʹٸ�, TO_CHAR(DATE, 'YYYY')�� ���� ������ �� ����Ѵ�.
 * */
SELECT SUBSTR(SYSDATE, 1, 2) FROM DUAL;
SELECT SUBSTR(TO_CHAR(SYSDATE, 'YYYY-MM-DD'), 1, 4) FROM DUAL;

SELECT * FROM EMP
WHERE HIREDATE LIKE (SELECT SUBSTR(HIREDATE, 1, 2) FROM EMP WHERE ENAME = 'FORD') || '%';


SELECT * FROM TEST001;
SELECT * FROM COPY_EMP;

/*SCOTT ������ �ִ� ���̺� �߿��� SALGRADE�� ������ �� GRADE �÷����� LEVEL�� ����*/
/*
 * ���� �ݴ�� �ٲٱ�
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

/*HR ������ DEPT ���̺��� ���� ���� �������� ����, ������ ���̺����� LOC�� ��� �޿� �˻�*/
create table copy_dept as select * from HR.DEPT;
create table copy_emp as select * from HR.EMP;

SELECT AVG() FROM copy_dept;