/* group is a reserve word in sql lol */
create table student_groups (
 student_group_id integer primary key,
 name varchar(255)
);

create table students (
    student_id      integer primary key,
    name            varchar(255),
    student_group_id   integer null references student_groups(student_group_id)
);

insert into student_groups (student_group_id, name) values (1, 'intro');
insert into student_groups (student_group_id, name) values (2, 'intermediate');
insert into student_groups (student_group_id, name) values (3, 'advanced');


insert into students (student_id, name, student_group_id) values (1, 'Sue', 1);
insert into students (student_id, name, student_group_id) values (2, 'Joe', 2);
insert into students (student_id, name, student_group_id) values (3, 'Tom', null);
insert into students (student_id, name, student_group_id) values (4, 'Jerry', 2);