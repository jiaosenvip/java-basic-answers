create view comp_spring_2018 as
(
    select C.course_id,building,room_number
    from course C, section S
    where C.course_id = S.course_id
    and C.dept_name = 'Comp. Sci.'
    and S.semester = 'Spring'
    and S.year = '2018'
);

create view comp_spring_2018_taylor as
(
    select course_id,  room_number
    from comp_spring_2018
    where building = 'Taylor'
);