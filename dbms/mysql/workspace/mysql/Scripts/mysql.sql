create database test;
use test;

create table guest(
   userNum int unsigned auto_increment primary key,
   userId varchar(1000),
   userPw varchar(1000),
   userAge tinyint unsigned
);

select * from guest;

alter table guest add column(birth date);

insert into guest(userId, userPw, userAge, birth)
values('hds1234', '1234', 20, '2002-12-04');

delete from guest where userId = 'hds1234';

insert into guest(userId, userPw, userAge, birth)
values('hds1234', hex(aes_encrypt('1234', 'abc')), 20, '2002-12-04');

select userNum, userId, aes_decrypt(unhex(userPw), 'abc') from guest;

/*현재 시퀀스 가져오기*/
select `AUTO_INCREMENT` from information_schema.TABLES
where TABLE_SCHEMA = 'test' and TABLE_NAME = 'guest';

/*문자열 합치기*/
select concat(userId, ', ', userAge, '살') info from guest;

/*현재 날짜*/
select now() from dual;

/*날짜를 string으로 변경*/
select date_format(now(), '%Y년 %m월 %d일 %H:%i:%s') from dual;

/*NULL일 경우 원하는 값으로 대체*/
update guest
set birth = null;

select userId, userPw, userAge, ifnull(birth, '미등록') birth from guest;

/*
 * guest 스키마 생성
 * member 테이블 생성
 * 회원번호(auto_increment, PK), 이름, 생일 컬럼 추가
 * 데이터는 3개 추가한다.
 * */

create database guest;
use guest;

create table `member`(
   userNum int unsigned auto_increment primary key,
   userId varchar(1000),
   userPw varchar(1000),
   userAge tinyint unsigned
);

select * from `member`;

alter table guest add column(birth date);
alter table `member` add column(birth date unsigned auto_increment primary key);
alter table `member` drop column birth;
alter table guest add column(auto_increment primary key name date);
