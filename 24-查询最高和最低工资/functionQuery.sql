select dept_name,MAX(salary) as max_salary,MIN(salary) as min_salary
from instructor
group by dept_name;