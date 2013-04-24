create table menu(
menu_id int primary key,
menu_name varchar2(50) unique not null,
menu_pid int ,
menu_url varchar2(50)
);

create sequence seq_menu;

insert  into  menu (menu_id,menu_name,menu_url) values(seq_menu.nextval,'鲜活海鲜','http://www.google.com.hk');
insert  into  menu (menu_id,menu_name,menu_url) values(seq_menu.nextval,'农家菜','http://www.google.com.hk');
insert  into  menu (menu_id,menu_name,menu_url) values(seq_menu.nextval,'肉类','http://www.google.com.hk');
insert  into  menu (menu_id,menu_name,menu_url) values(seq_menu.nextval,'蔬菜','http://www.google.com.hk');
insert  into  menu (menu_id,menu_name,menu_url) values(seq_menu.nextval,'腌制食品','http://www.google.com.hk');
