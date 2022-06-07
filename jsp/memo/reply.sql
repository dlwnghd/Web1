create table tbl_reply(
	reply_number int unsigned auto_increment primary key,
	reply_content varchar(700),
	board_number int unsigned,
	member_number int unsigned,
	foreign key (board_number) references tbl_board(board_number) on delete cascade,
	foreign key (member_number) references tbl_member(member_number) on delete cascade
);

select * from tbl_reply;