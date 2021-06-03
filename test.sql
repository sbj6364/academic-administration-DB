show databases;

use mysql;
select host, user, authentication_string from user;
set global validate_password.policy=LOW;

SHOW VARIABLES LIKE 'validate_password%';
set global validate_password.length= 4 ;
set global validate_password.length= 4 ;

use sejong;
show tables;

-- drop table lecture;

-- delete from student;
-- delete from professor;

select count(*) from student;
select count(*) from professor;
select count(*) from department;
select count(*) from lecture;
select count(*) from course;
select count(*) from club;
select count(*) from club_member;
select count(*) from tuition;

########## Professor
select * from lecture;

select * from lecture
where prof_id = 130001 and year=2021 and semester=1;


select * from student
where prof_id = 130003;

select * from course
where student_id = 17011806;

select * from department
where id = (select dept_id from student s
			where s.id = 17011806);
            
########### Student
    
select l.*, c.gpa from lecture l, course c
where l.year=2021 and l.semester=1
	and c.student_id = 17011806 and l.id=c.lecture_id and l.class_id = c.class_id;
    
select lecture_id from course c
where c.student_id = 17011806;
            