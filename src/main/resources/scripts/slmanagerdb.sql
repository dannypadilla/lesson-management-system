/* group is a reserve word in sql lol */
create table student_groups (
 student_group_id integer primary key,
 name varchar(255)
);

insert into student_groups (student_group_id, name) values (1, 'intro');
insert into student_groups (student_group_id, name) values (2, 'intermediate');
insert into student_groups (student_group_id, name) values (3, 'advanced');

create table students (
    student_id			integer primary key,
    name				varchar(255),
    parents_name			varchar(255),
    parents_email		varchar(255),
    student_group_id	integer null,
    foreign key (student_group_id) references student_groups(student_group_id)
);

insert into students (student_id, name, parents_name, parents_email, student_group_id) values (1, 'Sue', 'Sally', 'isally@live.com', 1);
insert into students (student_id, name, parents_name, parents_email, student_group_id) values (2, 'Joe', 'Bob', 'iamBob@yahoo.com', 2);
insert into students (student_id, name, parents_name, parents_email, student_group_id) values (3, 'Tom', 'Jim', 'king@hotmail.com', null);
insert into students (student_id, name, parents_name, parents_email, student_group_id) values (4, 'Jerry', 'Jose', 'elJose@aol.com', 2);