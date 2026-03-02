-- create structure database
create table classes (
	id serial primary key,
	name varchar(100) not null unique,
	code varchar(3) not null,
	created_at timestamp default current_timestamp
);

create table students (
	id serial primary key,
	name varchar(100) not null unique,
	age int not null,
	gpa numeric(2,1) default null,
	is_active boolean default true,
	class_id int not null,
	constraint fk_class
		foreign key (class_id)
		references classes(id)
		on delete cascade
);

-- insert data
insert into classes(name, code)
values
	('English', 'E'),
	('Math', 'M'),
	('History', 'H');
insert into students(name, age, gpa, class_id)
VALUES
    ('Tran Thi B', 21, 1.1, 1),
    ('Le Van C', 19, 8.9, 2),
    ('Pham Thi D', 22, 8.0, 1);
insert into students(name, age, gpa, is_active, class_id)
VALUES
    ('Nhuyen HU Lo', 21, 1.1, false, 1),
    ('Le Van B', 19, 8.9, false, 2);

-- 2.Lấy tất cả sinh viên có điểm GPA > 5 và có name bắt đầu bằng L
select * from students where gpa > 5 and name like 'L%';

-- 4. Lấy ra top 5 sinh viên có điểm cao nhất
select * from students order by gpa desc limit 2;

-- 5. Xóa tất cả sinh viên không còn hoạt động (is_active = false)
delete from students where is_active = false;

-- 3. Cộng 1 điểm cho tất cả các sinh viên của lớp có mã code là C01.  - gợi ý tìm hiểu join
select students.gpa + 1 as new_gpa, students.name, classes.code
from students
join classes on students.class_id = classes.id
where classes.code = 'M'

-- 6. Đếm số lượng sinh viên của từng lớp - Gợi ý: group by having
select classes.name, count(*) as total_students
from students
join classes on students.class_id = classes.id.
group by classes.name;



