/*	FLOWER
	-------------------------------------------
	FLOWER_NAME : VARCHAR2(1000) : PRIMARY KEY
	FLOWER_COLOR : VARCHAR2(1000) : PRIMARY KEY
	-------------------------------------------
	FLOWER_PRICE : NUMBER


	POT
	-------------------------------------------
	POT_NUMBER : NUMBER : PRIMARY KEY
	-------------------------------------------
	POT_COLOR : VARCHAR2(1000)
	POT_SHAPE : VARCHAR2(1000)
	FLOWER_NAME : VARCHAR2(1000) : FOREIGN KEY
	FLOWER_COLOR : VARCHAR2(1000) : FOREIGN KEY*/

CREATE TABLE FLOWER(
	FLOWER_NAME VARCHAR2(1000),
	FLOWER_COLOR VARCHAR2(1000),
	FLOWER_PRICE NUMBER,
	CONSTRAINT PK_FLOWER PRIMARY KEY(FLOWER_NAME, FLOWER_COLOR) /*조합키일 경우 CONSTRAINT 명령어를 통해 PK를 설정한다.*/
);

/*테이블명 변경*/
ALTER TABLE FLOWER RENAME TO TBL_FLOWER;	-- FLOWER 테이블을 TBL_FLOWER으로 바꿈 

-- TBL_POT 테이블 생성
CREATE TABLE TBL_POT(
	POT_NUMBER NUMBER PRIMARY KEY,
	POT_COLOR VARCHAR2(1000),
	POT_SHAPE VARCHAR2(1000),
	FLOWER_NAME VARCHAR2(1000),
	FLOWER_COLOR VARCHAR2(1000),
	CONSTRAINT FK_POT FOREIGN KEY(FLOWER_NAME, FLOWER_COLOR) REFERENCES TBL_FLOWER(FLOWER_NAME, FLOWER_COLOR)
);

--DROP TABLE TBL_POT;

SELECT * FROM TBL_FLOWER;
SELECT * FROM TBL_POT;
SELECT POT_COLOR FROM TBL_POT;

/*
 * 1. 요구사항 분석
 * 		- 반려동물
 * 			식별번호, 종류, 이름, 나이, 병명
 * 
 * 		- 주인
 * 			이름, 나이, 주소, 핸드폰 번호
 * 
 * 2. 개념적 설계
 * 3. 논리적 설계
 * 4. 물리적 설계
 * 		
 *		TBL_PET 
 * 		--------------------------------------------
 * 		PET_NUMBER : NUMBER : PRIMARY KEY
 * 		--------------------------------------------
 * 		PET_TYPE : VARCHAR2
 * 		PET_NAME : VARCHAR2
 * 		PET_AGE : NUMBER
 * 		PET_REASON : VARCHAR2
 * 		OWNER_NAME : VARCHAR2  : FOREIGN KEY
 * 		OWNER_PHONE: VARCHAR2 : FOREIGN KEY
 * 		
 * 		TBL_OWNER
 * 		--------------------------------------------
 * 		OWNER_NAME : VARHCHAR2 : PRIMARY KEY
 * 		OWNER_PHONE  : VARHCHAR2 : PRIMARY KEY
 * 		--------------------------------------------
 * 		OWNER_AGE : NUMBER
 * 		OWNER_ADDRESS : VARCHAR2
 * 
 * 5. 구현
 * */


CREATE TABLE TBL_OWNER(
	OWNER_NAME VARCHAR2 (1000),
	OWNER_PHONE VARCHAR2 (1000),
	OWNER_AGE NUMBER,
	OWNER_ADDRESS VARCHAR2 (2000),
	CONSTRAINT PK_OWNER PRIMARY KEY(OWNER_NAME, OWNER_PHONE)
);

CREATE TABLE TBL_PET(
	PET_NUMBER NUMBER PRIMARY KEY,
	PET_TYPE VARCHAR2 (1000),
	PET_NAME VARCHAR2 (1000),	
	PET_AGE NUMBER,
	PET_REASON VARCHAR2 (1000),
	OWNER_NAME VARCHAR2 (1000),
	OWNER_PHONE VARCHAR2 (1000),
	CONSTRAINT FK_PET FOREIGN KEY(OWNER_NAME, OWNER_PHONE) REFERENCES TBL_OWNER (OWNER_NAME, OWNER_PHONE) ON DELETE CASCADE
);

INSERT INTO TBL_OWNER
VALUES('한동석', '5111', 20, '남양주');

SELECT * FROM TBL_OWNER;

INSERT INTO TBL_PET
VALUES(1, '고양이', '톰', 1, '방광염', '한동석', '5111');

SELECT * FROM TBL_PET;

DELETE FROM TBL_OWNER WHERE OWNER_NAME = '한동석' AND OWNER_PHONE = '5111';

/*DROP TABLE TBL_PET;
DROP TABLE TBL_OWNER;*/

SELECT * FROM TBL_OWNER;
SELECT * FROM TBL_PET;

SELECT * FROM TBL_STUDENT;

INSERT INTO TBL_STUDENT
(STUDENT_NUMBER, STUDENT_CODE, STUDENT_NAME, STUDENT_MAJOR, STUDENT_BIRTH, STUDENT_COUPLE)
VALUES(1, 'hds1234', '한동석', '컴퓨터공학', TO_DATE('1988-12-04', 'YYYY-MM-DD'), 'N');

INSERT INTO TBL_STUDENT
VALUES(2, 'hgd1111', '홍길동', '세무회계학', 'M', TO_DATE('2000-05-04', 'YYYY-MM-DD'), 'Y');

INSERT INTO TBL_STUDENT
VALUES(3, 'hgd1234', '홍길동', '물리학과', 'M', TO_DATE('2005-05-04', 'YYYY-MM-DD'), 'Y');

UPDATE TBL_STUDENT 
SET STUDENT_GENDER = 'M'
WHERE STUDENT_NUMBER = 1;

/*홍길동 학생은 여자친구와 헤어졌다.*/
UPDATE TBL_STUDENT 
SET STUDENT_COUPLE = 'N'
WHERE STUDENT_NUMBER = 2;

DELETE FROM TBL_STUDENT;

/*홍길동 학생이 해킹보안학과로 전과했다.*/
SELECT STUDENT_NUMBER FROM TBL_STUDENT
WHERE STUDENT_NAME = '홍길동';

UPDATE TBL_STUDENT 
SET STUDENT_MAJOR = '해킹보안학과'
WHERE STUDENT_NUMBER = 2;

SELECT * FROM TBL_STUDENT;

/*홍길동 학생이 자퇴했다.*/
SELECT STUDENT_NUMBER  FROM TBL_STUDENT
WHERE STUDENT_NAME = '홍길동' AND STUDENT_MAJOR = '해킹보안학과';

DELETE FROM TBL_STUDENT WHERE STUDENT_NUMBER = 2;








