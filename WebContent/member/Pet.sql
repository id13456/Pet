
/* Drop Tables */

DROP TABLE adminuser CASCADE CONSTRAINTS;
DROP TABLE border CASCADE CONSTRAINTS;
DROP TABLE contest CASCADE CONSTRAINTS;
DROP TABLE diary CASCADE CONSTRAINTS;
DROP TABLE petqna CASCADE CONSTRAINTS;
DROP TABLE shop CASCADE CONSTRAINTS;
DROP TABLE petuser CASCADE CONSTRAINTS;
DROP TABLE p_helper CASCADE CONSTRAINTS;
DROP TABLE p_out CASCADE CONSTRAINTS;


/* Create Tables */

CREATE TABLE adminuser
(
	adminid varchar2(20) NOT NULL,
	adminpwd varchar2(30) NOT NULL,
	adminname varchar2(30) NOT NULL,
	adminphone varchar2(20),
	adminemail varchar2(30),
	PRIMARY KEY (adminid)
);


CREATE TABLE border
(
	bseq number(10,0) NOT NULL,
	bgroup number(2,0) NOT NULL,
	btitle varchar2(100) NOT NULL,
	bcontent varchar2(1000) NOT NULL,
	bindate date DEFAULT sysdate NOT NULL,
	bid varchar2(20) NOT NULL,
	bview number(10,0),
	PRIMARY KEY (bseq)
);


CREATE TABLE contest
(
	conseq number(10,0) NOT NULL,
	conindate date DEFAULT sysdate NOT NULL,
	contitle varchar2(30) NOT NULL,
	concontent varchar2(1000) NOT NULL,
	conimg varchar2(50) NOT NULL,
	conlike number(19,0),
	conid varchar2(20),
	conview number(10,0),
	conanikind number(4,0),
	PRIMARY KEY (conseq)
);


CREATE TABLE diary
(
	dseq number(10,0) NOT NULL,
	did varchar2(20) NOT NULL,
	dindate date DEFAULT sysdate,
	dtitle varchar2(100) NOT NULL,
	dcontent varchar2(1000) NOT NULL,
	PRIMARY KEY (dseq)
);


CREATE TABLE petqna
(
	qseq number(10,0) NOT NULL,
	qgroup number(2,0) NOT NULL,
	qtitle varchar2(100) NOT NULL,
	qcontent varchar2(1000) NOT NULL,
	qindate date DEFAULT sysdate NOT NULL,
	qid varchar2(20) NOT NULL,
	qrep varchar2(10),
	qreply varchar2(1000),
	qreid varchar2(20),
	qview number(10,0),
	PRIMARY KEY (qseq)
);


CREATE TABLE petuser
(
	userid varchar2(20) NOT NULL,
	userpwd varchar2(30) NOT NULL,
	username varchar2(30) NOT NULL,
	userphone varchar2(20),
	useremail varchar2(30),
	user_zip_num varchar2(10),
	user_address varchar2(1000),
	user_pet1 number(2,0) NOT NULL,
	user_pet2 number(2,0),
	user_img varchar2(100),
	helperid varchar2(20),
	PRIMARY KEY (userid)
);


CREATE TABLE p_helper
(
	id varchar2(20) NOT NULL,
	pwd varchar2(30) NOT NULL,
	name varchar2(30) NOT NULL,
	sex number(2,0) NOT NULL,
	phone varchar2(20) NOT NULL,
	email varchar2(30),
	hgroup number(2,0) NOT NULL,
	hos_name varchar2(100),
	hos_address varchar2(1000),
	helper_img varchar2(50),
	helper_index varchar2(1000),
	helper_kind1 varchar2(10) NOT NULL,
	helper_kind2 varchar2(10) NOT NULL,
	helper_kind3 varchar2(10) NOT NULL,
	helper_kind4 varchar2(10) NOT NULL,
	helper_kind5 varchar2(10) NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE p_out
(
	outseq number(10,0) NOT NULL,
	outgroup number(2,0) NOT NULL,
	outimg varchar2(50) NOT NULL,
	outkind number(2,0) NOT NULL,
	outage number(3,0) NOT NULL,
	outsex number(3,0) NOT NULL,
	outindex varchar2(1000) NOT NULL,
	outid varchar2(20),
	outmatch number(2,0),
	outview number(10,0),
	outmatchid varchar2(20),
	outarea varchar2(50),
	outtitle varchar2(100),
	PRIMARY KEY (outseq)
);


CREATE TABLE shop
(
	exseq number(10,0) NOT NULL,
	extitle varchar2(30) NOT NULL,
	excontent varchar2(1000) NOT NULL,
	exindate date DEFAULT sysdate,
	exid varchar2(20),
	exmatch number(2,0) DEFAULT 1,
	eximg varchar2(50),
	exview number(10,0),
	exmatchid varchar2(20),
	exarea varchar2(50),
	PRIMARY KEY (exseq)
);



/* Create Foreign Keys */

ALTER TABLE diary
	ADD FOREIGN KEY (did)
	REFERENCES petuser (userid)
;

create sequence ex_seq start with 1 increment by 1 nocache;
create sequence d_seq start with 1 increment by 1 nocache;
create sequence con_seq start with 1 increment by 1 nocache;
create sequence q_seq start with 1 increment by 1 nocache;
create sequence b_seq start with 1 increment by 1 nocache;
create sequence out_seq start with 1 increment by 1 nocache;

drop sequence q_seq;

insert into petuser(userid, userpwd, username, userphone, useremail, user_zip_num, user_address, user_pet1, user_img) values('one', '1111', '김하나', '010-7754-5545', 'one@naver.com', '07677', '서울특별시 강서구 화곡동 24-176', 2, 'cat.jpg');
insert into petuser(userid, userpwd, username, userphone, useremail, user_zip_num, user_address, user_pet1, user_img) values('hong', '1234', '홍길동', '010-4567-5722', 'hong@naver.com', '06092', '서울특별시 강남구 선릉로126길 22', 2, 'cat0.jpg');

insert into shop(exseq, extitle, excontent, exindate, exid, exmatch, eximg, exview, exarea) 
values(ex_seq.nextval, '캣타워', '선반에 자꾸 올라가서 샀는데 우리집 아이 취향이 아닌지 이용하지 않네요ㅠㅠ 나눔합니다.', sysdate, 'one', 1, 'cattower.jpg', 0, '서울 강서구');

insert into p_helper(id, pwd, name, sex, phone, email, hgroup, hos_name, hos_address, helper_index, 
helper_kind1, helper_kind2, helper_kind3, helper_kind4, helper_kind5) 
values('petmom', '1234', '김병철', 1, '02-4562-7785', 'petmom@naver.com', 1, '대한동물병원', '서울특별시 강서구 화곡로 205', '컴포트대한동물병원은 반려동물들과 사람들에게 편안함과 위로가 모토입니다.', 'y', 'n', 'y', 'y', 'y');

insert into diary values(d_seq.nextval, 'one', sysdate, '예방접종', '종합백신');

insert into adminuser values('admin', 'admin', '관리자', '010-4565-7888', 'admin@daum.net');

insert into contest values(con_seq.nextval, sysdate, '냥이', '병원가는줄 모르고 신난 냥이', 'cat.jpg', 0, 'one', 0, 2);

insert into petqna(qseq, qgroup, qtitle, qcontent, qindate, qid, qrep) values(q_seq.nextval, 1, '고양이가 딸꾹질을 해요.', '자주는 아니지만 한번씩 하는데 사람과 같은 이유로 하는 걸까요..?? 급하게 먹는다던가...', sysdate, 'one', 'n');

insert into border values(b_seq.nextval, 1, '냥이 애교~~', '우리집 고양이 완전 개냥이에요 ㅎㅎㅎㅎㅎ 자기 안봐준다고 와서 머리박치기하고 애교떠는데 완전 귀여움', sysdate, 'one', 0);

insert into p_out(outseq, outgroup, 	outimg, outkind, 	outage, outsex, outindex, outid, outmatch, 	outview, outarea, outtitle) 
values(out_seq.nextval, 2, 'dog.jpg', 1, 2, 2, '저희 병원앞에 누가 두고갔네요... 상처를 치유해줄 가족분 구합니다.', 'petmom', 1, 0, '강서구', '건강하고 예쁜 아이');

commit

select * from petuser;

select * from shop;

select s.extitle as extitle, p.userid, p.userphone, p.useremail
from shop s, petuser p
where s.exmatchid = p.userid and exmatch=2 and s.exid='one'