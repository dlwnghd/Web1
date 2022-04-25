/*HR ������ DEPT ���̺��� ���� ���� �������� ����, ������ ���̺����� LOC�� ��� �޿� �˻�*/
/*
 * SQL> conn hr/hr
 * SQL> grant select on dept to baby;
 * SQL> grant select on emp to baby;
 * */
CREATE TABLE COPY_DEPT AS SELECT * FROM HR.DEPT;
SELECT * FROM COPY_DEPT;

CREATE TABLE SALARY_OF_LOCATION AS 
(SELECT LOC, ROUND(AVG(SAL), 2) "AVG"
FROM COPY_DEPT D JOIN HR.EMP E
ON D.DEPTNO = E.DEPTNO
GROUP BY LOC);

SELECT * FROM SALARY_OF_LOCATION;

/*VIEW, ��ȸ�� ��� ���̺��� ORDER BY�� �ۼ��ؼ��� �ȵȴ�.*/
/*PLAYER ���̺����� ���� �÷� �߰��� �� �����*/
SELECT * FROM PLAYER;
SELECT TRUNC((SYSDATE - BIRTH_DATE) / 365) FROM PLAYER;

CREATE VIEW VIEW_PLAYER
AS
(SELECT TRUNC((SYSDATE - BIRTH_DATE) / 365) AGE, PLAYER.* FROM PLAYER);

SELECT * FROM VIEW_PLAYER;

SELECT * FROM VIEW_PLAYER
WHERE AGE < 30;

/*EMPLOYEES ���̺����� ��� �̸��� �� ����� �Ŵ��� �̸��� �ִ� VIEW �����*/
/*FIRST_NAME�� LAST_NAME�� CONCATENATION�� ����Ͽ� �������ش�.*/
CREATE VIEW VIEW_EMPLOYEES AS
(
   SELECT 
      E1.FIRST_NAME || ' ' || E1.LAST_NAME EMPLOYEE_NAME,
      E2.FIRST_NAME || ' ' || E2.LAST_NAME MANAGER_NAME,
      J.JOB_TITLE
   FROM EMPLOYEES E1, EMPLOYEES E2, JOBS J 
   WHERE E1.MANAGER_ID = E2.EMPLOYEE_ID AND E2.JOB_ID = J.JOB_ID
);

SELECT * FROM VIEW_EMPLOYEES
ORDER BY MANAGER_NAME;

/*PLAYER ���̺��� TEAM_NAME �÷��� �߰��� VIEW �����*/
CREATE VIEW VIEW_TEAM AS
SELECT T.TEAM_NAME, P.* FROM PLAYER P JOIN TEAM T
ON P.TEAM_ID = T.TEAM_ID;

CREATE VIEW VIEW_TEAM AS
SELECT T.TEAM_NAME, P.* FROM PLAYER P JOIN TEAM T
ON P.TEAM_ID = T.TEAM_ID;

SELECT * FROM VIEW_TEAM;












