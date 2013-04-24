
数据库实在scott 用户下创建表

create  table report(
report_id int primary key,
report_title varchar2(50) not null,
report_time  date,
report_context varchar2(1000) not null
);

create sequence seq_report_id;
create sequence seq_rider_id;


create table rider(
report_id int not null,
rider_id int primary key,
rider_name varchar2(100) not null,
rider_url varchar2(100) not null
);
ALTER TABLE rider ADD CONSTRAINT FK_reder_id FOREIGN KEY(report_id) REFERENCES report(report_id);


用户登录账号： admin

密码： xiaoyu