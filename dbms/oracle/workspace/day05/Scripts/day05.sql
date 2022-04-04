/*AS(ALIAS) : ��Ī*/
/*1. ��� ���̺� ǥ���� �÷����� �����ϰ��� �� ��*/
/*2. ��� ������ �÷����� ���� ����ϱ� ���ؼ�*/

/*SELECT�� : �÷��� �ڿ� AS �Ǵ� �� ĭ ���� �ۼ��Ѵ�.*/

/*�����̸��� ���� ��ȸ*/
SELECT PLAYER_NAME AS �����̸�, BIRTH_DATE ������� FROM PLAYER;

/*SELECT������ ����� ALIAS�� �ٸ� ������ ����� �� ����.*/
/*
 * SQL ���� ����
 * 1 : FROM
 * 2 : WHERE
 * 3 : SELECT
 * */
SELECT PLAYER_NAME AS "���� �̸�", BIRTH_DATE ������� 
FROM PLAYER
WHERE PLAYER_NAME = '�輺ȯ';

/*PLAYER ���̺��� BACK_NO�� "�� ��ȣ"��, NICKNAME�� "���� ����"���� �����Ͽ� �˻�*/
SELECT BACK_NO "�� ��ȣ", NICKNAME "���� ����" FROM PLAYER;

/*CONCATENATION(����)*/
/* '�ȳ�' || '�ϼ���' */

/*PLAYER ���̺��� �̸��� �����̸��� ��ȸ�Ѵ�.*/
SELECT PLAYER_NAME || '�� ���� �̸���' || E_PLAYER_NAME || '�Դϴ�.' AS �ڱ�Ұ� FROM PLAYER;

/*���������� ������ �Ӹ��̴�.*/
SELECT PLAYER_NAME || '�� ������ ' || NICKNAME || '�̴�.' FROM PLAYER;

/*���������� �������� �Ӹ��̴�.*/
SELECT PLAYER_NAME || '�� �������� ' || "POSITION" || '�̴�.' FROM PLAYER;

/*LIKE : ���Ե� ���ڿ� ���� ã��, ������ ������ ������ �� �� �ִ�.*/
/* % : ��� �� */
/* _ : ���� ��*/

/*
 * ����
 * * '%A' : A�� ������ ��� ��(FDNMSKA, 123FNDSA, ...)
 * * 'A%' : A�� �����ϴ� ��� ��(ADSF, A2193DK, AAA, ADD, ...)
 * * 'A__' : A�� �����ϸ鼭 3������ ��(ABC, AAA, ADD, ...)
 * * '_A' : A�� �����鼭 2������ ��(FA, VA, DA, ...)
 * * '%A%' : A�� ���Ե� ��(APPLE, BANANA, TASK, ...)
 * */

/*'õ��'�� ������ �� �̸� ã��*/
SELECT TEAM_NAME 
FROM TEAM
/*WHERE NOT TEAM_NAME LIKE '%õ��';*/
WHERE TEAM_NAME LIKE '%õ��';

/*PLAYER ���̺��� �达 ã��*/
SELECT * FROM PLAYER
WHERE PLAYER_NAME LIKE '��%';

/*PLAYER ���̺��� �达 �� ��(�� ��) ã�� */
SELECT * FROM PLAYER
WHERE PLAYER_NAME LIKE '��_';

/*PLAYER ���̺��� �达�� �̾� ã��*/
SELECT * FROM PLAYER
WHERE PLAYER_NAME LIKE '��%' OR PLAYER_NAME LIKE '��%';

/*PLAYER ���̺��� �̾��� �ƴ� ��� ã��*/
SELECT * FROM PLAYER
WHERE PLAYER_NAME NOT LIKE '��%';

/*PLAYER ���̺��� �� �ڰ� �ƴ� �达 ã��*/
SELECT * FROM PLAYER
WHERE NOT PLAYER_NAME LIKE '___' AND PLAYER_NAME LIKE '��%';

SELECT * FROM TBL_FLOWER;

/*NOT NULL ���� ����*/
ALTER TABLE TBL_FLOWER MODIFY (FLOWER_PRICE NOT NULL);
ALTER TABLE TBL_FLOWER DROP CONSTRAINT SYS_C007169;

/*PLATER ���̺��� POSITION�� NULL�� ���� �˻�*/
SELECT * FROM PLAYER
WHERE "POSITION" IS NULL;

/*������ NULL�� �ƴ� �����鸸 ��ȸ�Ѵ�.*/
SELECT PLAYER_NAME || '�� ������ ' || NICKNAME || '�̴�.' AS �Ұ� FROM PLAYER
WHERE NICKNAME IS NOT NULL;

/*PLAYER ���̺��� POSITION�� NULL�̸� '����'���� ��� ����ϱ�*/
SELECT NVL("POSITION", '����') FROM PLAYER
WHERE "POSITION" IS NULL;

/*
 * PLAYER ���̺��� NATION�� NULL�� �ƴϸ� '���', NULL�̸� '�̵��'���� �����Ѵ�.
 * ���� �̸��� ���� ���� ��ȸ�Ѵ�.
 * */
SELECT PLAYER_NAME, NVL(NICKNAME, '���� ����') AS NICKNAME, NVL2(NATION, '���', '�̵��') NATION  
FROM PLAYER;

/*������ �Լ�*/

/*���밪*/
SELECT ABS(-10) FROM DUAL;

/*���� ����(1), ��(0), ���� ����(-1)*/
SELECT SIGN(4), SIGN(0), SIGN(-4) FROM DUAL;

/*������*/
SELECT MOD(10, 3) FROM DUAL;

/*������ ū �ֱ��� ���� : �ø�*/
SELECT CEIL(3.14), CEIL(-3.14) FROM DUAL;

/*������ ���� �ֱ��� ���� : ����*/
SELECT FLOOR(3.14), FLOOR(-3.14) FROM DUAL;

/*����*/
SELECT TRUNC(3.9), TRUNC(-3.9) FROM DUAL;

/*�ݿø�*/
SELECT ROUND(3.4555555555616) FROM DUAL;
SELECT ROUND(3.4555555555616, 2) FROM DUAL;
SELECT ROUND(3.4555555555616, 1) FROM DUAL;

/*HEIGHT�� WEIGHT�� �Ǽ��� �����Ѵ�.*/
/*PLAYER ���̺��� Ű�� �Ҽ��� �� °�ڸ����� �ݿø�, �����Դ� �Ҽ��� �������� ��ȸ*/
/*Ű �Ǵ� �����԰� NULL�̶�� ���ϴ� ��ġ�� �����Ű���� ��ȸ�Ѵ�.*/
/*Ű �� �ڿ� cm�� �ٿ��ְ�, ������ �� �ڿ� kg�� �ٿ��ش�.*/
SELECT PLAYER_NAME "���� �̸�", NVL(ROUND(HEIGHT, 2), '184') || 'cm' Ű, NVL(TRUNC(WEIGHT), 75) || 'kg' ������ 
FROM PLAYER;

/*
 * ���� �Լ�
 * 		���� ���� ���� �ϳ��� ������ �����Ͽ� ��Ÿ����.
 * 		�� NULL�� �������� �ʴ´�.
 * 		�� WHERE �������� ����� �� ����.
 * */
/*
 * ��� : AVG()
 * �ִ밪 : MAX()
 * �ּҰ� : MIN()
 * �� �� : SUM()
 * ���� : COUNT()
 * */
SELECT AVG(HEIGHT), MAX(HEIGHT), SUM(HEIGHT), MIN(HEIGHT), COUNT(HEIGHT) FROM PLAYER;
SELECT * FROM PLAYER;

/*PLAYER ���̺��� HEIGHT �� ���� �˻�(NULL�� �����ؼ� COUNT)*/
SELECT COUNT(NVL(HEIGHT, 0)) FROM PLAYER;

/*
 * ���� (ORDER BY) 
 * 		ASC : ���� ����(DEFAULT)
 * 		DESC : ���� ����
 * */

SELECT * FROM PLAYER
ORDER BY HEIGHT;

SELECT * FROM PLAYER
WHERE HEIGHT IS NOT NULL
ORDER BY HEIGHT DESC;

SELECT * FROM PLAYER
WHERE WEIGHT IS NOT NULL AND HEIGHT IS NOT NULL
ORDER BY HEIGHT ASC, WEIGHT DESC;

/*����õ, DBMS �������� �ν� ���ϴ� ���� ����*/
SELECT * FROM PLAYER
WHERE HEIGHT IS NOT NULL
ORDER BY 12 DESC;

/*
 * PLAYER ���̺��� Ű ��, ������ ������ ���� ���� �˻�
 * NULL�� �ƴ� ���� �˻�
 * �÷��� ��ȣ�� �����Ѵ�.
 * ù��° �÷� ���� ������, �ι�° ������ �����Ѵ�.
 * */
SELECT * FROM PLAYER
WHERE WEIGHT IS NOT NULL AND HEIGHT IS NOT NULL
ORDER BY 12, 13;

/*
 * GROUP BY : ~��(�� : ������ �� ��� Ű)
 * GROUP BY �÷��� HAVING ���ǽ�
 * WHERE������ �켱������ ó���� ���ǽ��� �ۼ��ؾ� �ӵ��� ���ȴ�.
 * */

/*PLAYER ���̺��� ������ ���� �˻�*/
SELECT "POSITION" FROM PLAYER
GROUP BY "POSITION"
HAVING "POSITION" IS NOT NULL;

SELECT "POSITION" FROM PLAYER
WHERE "POSITION" IS NOT NULL
GROUP BY "POSITION";

/*PLAYER ���̺��� �����԰� 80�̻��� �������� ��� Ű�� 180�̻��� ������ �˻�*/
SELECT "POSITION", AVG(HEIGHT), MIN(WEIGHT) FROM PLAYER
WHERE WEIGHT >= 80
GROUP BY "POSITION" 
HAVING AVG(HEIGHT) >= 180;

/*EMPLOYEES ���̺��� JOB_ID�� ��� SALARY�� 10000�̸��� JOB_ID �˻�*/
/*JOB_ID�� ���ĺ� ������ ����(���� ����)*/
SELECT JOB_ID, AVG(SALARY) FROM EMPLOYEES
GROUP BY JOB_ID
HAVING AVG(SALARY) < 10000
ORDER BY 2;

/*
 * PLAYER ���̺��� ��ü ��� Ű�� �����Ǻ� ��� Ű ���ϱ�
 * */










