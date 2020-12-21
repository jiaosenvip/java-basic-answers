select dept_name, avg(salary) as avg_salary
from instructor 
group by dept_name
order by avg(salary) desc;