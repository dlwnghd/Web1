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

/*���� ������ ��������*/
select `AUTO_INCREMENT` from information_schema.TABLES
where TABLE_SCHEMA = 'test' and TABLE_NAME = 'guest';

/*���ڿ� ��ġ��*/
select concat(userId, ', ', userAge, '��') info from guest;

/*���� ��¥*/
select now() from dual;

/*��¥�� string���� ����*/
select date_format(now(), '%Y�� %m�� %d�� %H:%i:%s') from dual;

/*NULL�� ��� ���ϴ� ������ ��ü*/
update guest
set birth = null;

select userId, userPw, userAge, ifnull(birth, '�̵��') birth from guest;

/*
 * guest ��Ű�� ����
 * member ���̺� ����
 * ȸ����ȣ(auto_increment, PK), �̸�, ���� �÷� �߰�
 * �����ʹ� 3�� �߰��Ѵ�.
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
