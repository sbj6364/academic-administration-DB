show databases;

use mysql;
select host, user, authentication_string from user;
set global validate_password.policy=LOW;

SHOW VARIABLES LIKE 'validate_password%';
set global validate_password.length= 4 ;
set global validate_password.length= 4 ;

use madang;
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
select * from student;
select * from professor;
select * from department;
select * from lecture;
select * from course;
select * from club;
select * from club_member;
select * from tuition;

# 교수) 입력 연도/학기에 따른 강의 과목 보기
select * from lecture
where prof_id = 130003 and year=2021 and semester=1;

# 교수) 지도 학생 보기
select * from student
where prof_id = 130001;


# 교수) 학생 성적 보기
select l.name as '과목명', l.class_id as '분반' , c.* from course c, lecture l
where c.student_id = 17011806 and c.lecture_id = l.id and c.class_id = l.class_id;

# 교수) 소속 학과 보기
select * from department
where id = (select dept_id from professor
			where id = 130004);



            
########### Student

# 입력 연도/학기에 따른 수강 과목 보기 
select l.*, c.gpa from lecture l, course c
where l.year=2021 and l.semester=1
	and c.student_id = 17011806 and l.id=c.lecture_id and l.class_id = c.class_id;

#     
select lecture_id from course c
where c.student_id = 17011806;
            
            
delete from student
where id = 17011826;

show databases;

select