/*
 * PLAYER ���̺����� ��ü ��� Ű�� �����Ǻ� ��� Ű ���ϱ�
 *
 * CASE��
 * 
 * CASE �÷��� WHEN �� THEN �÷��� �Ǵ� �� END
 * 
 * */

SELECT
	AVG(CASE "POSITION" WHEN 'GK' THEN HEIGHT END) GK,
	AVG(CASE "POSITION" WHEN 'DF' THEN HEIGHT END) DF,
	AVG(CASE "POSITION" WHEN 'FW' THEN HEIGHT END) FW,
	AVG(CASE "POSITION" WHEN 'MF' THEN HEIGHT END) MF,
	AVG(HEIGHT) "��ü ���Ű"
FROM PLAYER;

SELECT "POSITION", AVG(HEIGHT) FROM PLAYER
GROUP BY "POSITION";

/*
 *  SUB QUERY
 * 
 * 		FROM �� : IN LINE VIEW
 * 		SELECT �� : SCALAR
 * 		WHERE �� : SUB QUERY
 * 
 * */

 /*PLAYER ���̺����� ��ü ��� Ű�� �����Ǻ� ��� Ű ���ϱ�*/
SELECT "POSITION", AVG(HEIGHT), (SELECT AVG(HEIGHT) FROM PLAYER) "��ü ���Ű"
FROM PLAYER
WHERE "POSITION" IS NOT NULL
GROUP BY "POSITION";

/*PLAYER ���̺����� TEAM_ID�� 'K01'�� ���� �߿��� POSITION�� 'GK'�� ����*/
SELECT * FROM 
	(
		SELECT * FROM PLAYER WHERE TEAM_ID = 'K01'
	)
WHERE "POSITION" = 'GK'; 

/*PLAYER ���̺����� TEAM_ID�� 'K01'�� ���� �߿��� POSITION�� 'GK'�� ����*/
/*���������� ������� �ʴ´�.*/
SELECT * FROM PLAYER
WHERE TEAM_ID = 'K01' AND "POSITION" = 'GK';

/*
 * SQL ���� ����
 * 
 * FROM > WHERE > GROUP BY > HAVING > SELECT > ORDER BY
 * 
 * */

/*������ ������ �Ҽӵ� ���� ������ ��ȸ*/
SELECT TEAM_ID FROM PLAYER WHERE PLAYER_NAME = '������';

SELECT * FROM PLAYER
WHERE TEAM_ID = (SELECT TEAM_ID FROM PLAYER WHERE PLAYER_NAME = '������');

SELECT COUNT(TEAM_ID) FROM PLAYER
WHERE TEAM_ID = (SELECT TEAM_ID FROM PLAYER WHERE PLAYER_NAME = '������');

/*PLAYER ���̺����� ��� Ű���� ���� ���� �˻�*/
SELECT AVG(HEIGHT) FROM PLAYER;

SELECT PLAYER_NAME, HEIGHT FROM PLAYER
WHERE HEIGHT < (SELECT AVG(HEIGHT) FROM PLAYER);

SELECT MAX(HEIGHT)  FROM
(
	SELECT PLAYER_NAME, HEIGHT FROM PLAYER
	WHERE HEIGHT < (SELECT AVG(HEIGHT) FROM PLAYER)
);

/*����� �� ��� ������ 20120501 ~ 20120502 ���̿� �ִ� ����� ��ü ���� ��ȸ(���õ� ������ �����Ѵ�)*/
SELECT * FROM STADIUM;

SELECT STADIUM_ID FROM SCHEDULE
WHERE SCHE_DATE BETWEEN '20120501' AND '20120502';

SELECT * FROM STADIUM
WHERE STADIUM_ID IN
(
	SELECT STADIUM_ID FROM SCHEDULE
	WHERE SCHE_DATE BETWEEN '20120501' AND '20120502'
);

/*TCL��ư Ŭ���ؼ� None���� �����Ѵ�*/

/*PLAYER ���̺����� NICKNAME�� NULL�� �������� ���¹� ������ �г������� �ٲٱ�(�� �ϰ� ROLLBACK)*/
SELECT NICKNAME FROM PLAYER
WHERE PLAYER_NAME = '���¹�';

UPDATE PLAYER
SET NICKNAME = (SELECT NICKNAME FROM PLAYER WHERE PLAYER_NAME = '���¹�')
WHERE NICKNAME IS NULL;

SELECT * FROM PLAYER
WHERE NICKNAME = (SELECT NICKNAME FROM PLAYER WHERE PLAYER_NAME = '���¹�');

/*EMPLOYEES ���̺����� ��� �޿����� ���� ������� �޿��� 20% �λ�(�� �ϰ� ROLLBACK)*/
SELECT AVG(SALARY) FROM EMPLOYEES;

UPDATE EMPLOYEES
SET SALARY = SALARY * 1.2
WHERE SALARY < (SELECT AVG(SALARY) FROM EMPLOYEES);

SELECT * FROM EMPLOYEES
WHERE SALARY < (SELECT AVG(SALARY) FROM EMPLOYEES);

SELECT * FROM EMPLOYEES
WHERE FIRST_NAME = 'David';

/*PLAYER ���̺����� ��� Ű���� ū �������� ����(�� �ϰ� ROLLBACK)*/
SELECT COUNT(*) FROM PLAYER
WHERE HEIGHT > (SELECT AVG(HEIGHT) FROM PLAYER);

/*261*/
SELECT COUNT(*) FROM PLAYER;

DELETE PLAYER
WHERE HEIGHT > (SELECT AVG(HEIGHT) FROM PLAYER);

/*
 * ROWNUM
 * ��� �� �տ� 1���� 1�� �����ϴ� �������� �ٿ��ش�.
 * */
SELECT ROWNUM, EMPLOYEES.* FROM EMPLOYEES;

/*
 * AS
 * FROM������ ��� �ÿ��� AS�� ����ؼ��� �ȵǰ� �������θ� �����ؾ��Ѵ�.
 * 
 * */
SELECT ROWNUM, E.* FROM EMPLOYEES E;

/*
 * SQL ���� ����
 * 
 * FROM > WHERE > GROUP BY > HAVING > SELECT > ORDER BY
 * 
 * */

/*EMP ���̺����� SAL�� ������������ ������ �� ROWNUM�� �ٿ��� ��ȸ�Ѵ�.*/
SELECT ROWNUM, E.* FROM EMP E
ORDER BY SAL DESC;

/*���� 1�� ���� 5������ ��ȸ�Ѵ�.*/
SELECT ROWNUM, "RESULT".* FROM 
(SELECT * FROM EMP ORDER BY SAL DESC) "RESULT"
WHERE ROWNUM BETWEEN 1 AND 5;






