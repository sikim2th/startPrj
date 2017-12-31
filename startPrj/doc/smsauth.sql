 create table tbl_smsauth(
	seq int not null auto_increment,
	phone varchar(20) not null,
	temp_key varchar(6) not null,
	regdate timestamp not null default now(),
	primary key(seq)
 );
 
 insert into tbl_smsauth(phone, temp_key)
 values ('010-1111-2222', '123456');
 
 commit;