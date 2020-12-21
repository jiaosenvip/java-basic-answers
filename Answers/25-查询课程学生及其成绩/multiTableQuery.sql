select S.ID, S.name, T.course_id, grade
from student as S left join takes as T
on S.ID = T.ID
where T.course_id in (
	select course_id
	from course
	where dept_name = 'Biology' and S.ID = T.ID
);