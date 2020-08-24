package com.tsi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import com.tsi.dto.Employee;

public class EmployeeDAOImpl extends NamedParameterJdbcDaoSupport implements EmployeeDAO {

	private DataSource ds;
	
	public void setDs(DataSource dataSource) {
      setDataSource(dataSource);
	}
	
	
	
	private String status = "";
	Employee emp = null;
	private String query = "";
	List<Employee> emplist = null;

	@Override
	public String Add(Employee employee) {

		try {
			emp = search(employee.getEno());
			if (emp == null) {
				query = "insert into Employee value :ENO, :ENAME, :ESAL, :EADDR";
				Map<String, Object> paramMap = new HashMap<String, Object>();
				paramMap.put("ENO", employee.getEno());
				paramMap.put("ENAME", employee.getEname());
				paramMap.put("ESAL", employee.getEsal());
				paramMap.put("EADDR", employee.getEaddr());

				int rowCount = getNamedParameterJdbcTemplate().update(query, paramMap);
				if (rowCount == 1) {
					status = " Employee Insertion sucessfully";
				} else {
					status = " Employee Insertion failure";
				}

			} else {

				status = "Employee existed already";
			}
		} catch (Exception e) {
			status = " Employee Insertion failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Employee search(int eno) {
		try {

			query = "Select * from Employee where  :ENO ";
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("ENO", eno);
			emplist = getNamedParameterJdbcTemplate().query(query, paramMap,(rs, index) -> {
				Employee emp1 = new Employee();
				emp1.setEno(rs.getInt("ENO"));
				emp1.setEname(rs.getString("ENAME"));
				emp1.setEsal(rs.getFloat("ESAL"));
				emp1.setEaddr(rs.getString("EADDR"));
				return emp1;
			});


			if (!emplist.isEmpty()) {
				emp = emplist.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return emp;
	}

	@Override
	public String update(Employee employee) {
		try {

			emp = search(employee.getEno());
			if (emp == null) {
				status = "Employee not found";
			} else {

				query = "update Employee set :ENO , :ENAME , :ESAL , :EADDR where :ENO=?";
				Map<String, Object> paramMap = new HashMap<String, Object>();
				paramMap.put("ENO", employee.getEno());
				paramMap.put("ENAME", employee.getEname());
				paramMap.put("ESAL", employee.getEsal());
				paramMap.put("EADDR", employee.getEaddr());

				int rowcount = getNamedParameterJdbcTemplate().update(query, paramMap);
				if (rowcount == 1) {
					System.out.println("Employee Update Correct");
				} else {
					System.out.println("Employee Updation failure");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public String delete(int eno) {
		try {
			query = "delete from Employee where  :ENO ";
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("ENO", eno);
			int rowcount = getNamedParameterJdbcTemplate().update(query, paramMap);
			if (rowcount == 1) {
				status = " Employee Deletion Sucessful";
			} else {
				status = "Employee Deletion failure";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

}
