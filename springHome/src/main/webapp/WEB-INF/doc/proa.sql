--회원 테이블

--create user proa identified by 1234 account unlock
--default tablespace users;
--
--grant resource, connect to proa;
drop table member;

create table member(
    mno number not null,
    email varchar2(40) not null,
    pwd varchar2(20) not null,
    mname varchar2(50) not null,
    cre_date date not null,
    mod_date date not null
);

alter table member
add constraint member_mno_pk primary key(MNO);

alter table member
add constraint member_email_uk unique(EMAIL);

create SEQUENCE member_mno_seq
  INCREMENT BY 1
  start with 1;

insert into member
(mno, email, pwd, mname, cre_date, mod_date)
values(member_mno_seq.nextval, 's1@test.com', '1111', '이상윤', sysdate, sysdate);

insert into member
(mno, email, pwd, mname, cre_date, mod_date)
values(member_mno_seq.nextval, 's2@test.com', '1111', '이상윤2', sysdate, sysdate);

insert into member
(mno, email, pwd, mname, cre_date, mod_date)
values(member_mno_seq.nextval, 's3@test.com', '1111', '이상윤3', sysdate, sysdate);

insert into member
(mno, email, pwd, mname, cre_date, mod_date)
values(member_mno_seq.nextval, 's4@test.com', '1111', '이상윤4', sysdate, sysdate);

insert into member
(mno, email, pwd, mname, cre_date, mod_date)
values(member_mno_seq.nextval, 's5@test.com', '1111', '이상윤5', sysdate, sysdate);

SELECT * FROM member;

commit;

