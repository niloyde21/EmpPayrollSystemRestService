package com.springboot.jdbc.h2.example.employeePayroll;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeJdbcRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	class EmployeeRowMapper implements RowMapper<Employee> {
		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee emp = new Employee();
			emp.setId(rs.getInt("id"));
			emp.setUserName(rs.getString("userName"));
			emp.setPassword(rs.getString("password"));
			return emp;
		}

	}

	public List<Employee> findAll() {
		return jdbcTemplate.query("select * from empCredentials", new EmployeeRowMapper());
	}

	public Employee findById(Integer id) {
		return jdbcTemplate.queryForObject("select * from empCredentials where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Employee>(Employee.class));
	}
	
	public Employee findByUserNameAndPassword(String userName, String password) {
		return jdbcTemplate.queryForObject("select * from empCredentials where username = ? and password = ?", new Object[] { userName, password },
				new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	public int deleteById(long id) {
		return jdbcTemplate.update("delete from empCredentials where id=?", new Object[] { id });
	}

	public int insert(Employee employee) {
		return jdbcTemplate.update("insert into empCredentials (id, userName, password) " + "values(?,  ?, ?)",
				new Object[] { employee.getId(), employee.getUserName(), employee.getPassword() });
	}

	public int update(Employee employee) {
		return jdbcTemplate.update("update empCredentials " + " set userName = ?, password = ? " + " where id = ?",
				new Object[] { employee.getUserName(), employee.getPassword(), employee.getId() });
	}
	
	  public boolean isUserExists(String username, String password) {

	        String sql = "SELECT count(*) FROM empCredentials WHERE username = ? AND password = ?";
		boolean result = false;

		int count = jdbcTemplate.queryForObject(
	                        sql, new Object[] { username, password }, Integer.class);
				
		if (count > 0) {
			result = true;
		}

		return result;
	  }
	  
	  public boolean isStaffExists(String email, String phoneNumber) {

	        String sql = "SELECT count(*) FROM Staff_information WHERE Email = ? AND Telephone = ?";
		boolean result = false;

		int count = jdbcTemplate.queryForObject(
	                        sql, new Object[] { email, phoneNumber }, Integer.class);
				
		if (count > 0) {
			result = true;
		}

		return result;
	  }
	  
	  public int maxEmpId() {

	        String sql = "SELECT max(id) FROM empCredentials";
		boolean result = false;

		int id = jdbcTemplate.queryForObject(
	                        sql, Integer.class);

		return id;
	  }
	  
	  public int maxStaffId() {
		  int id = 0;
	        String sql = "SELECT max(id) FROM Staff_information";
		boolean result = false;
		try {
		id = jdbcTemplate.queryForObject(
	                        sql, Integer.class);
		}catch(NullPointerException e) {
			
		}

		return id;
	  }
	  
	  
		public int insertStaffInfo(StaffInformation staffInformation) {
			return jdbcTemplate.update("insert into Staff_information (id,first_name,surname,Dob,Email,Telephone,Address,Department,Image,Salary,Gender,Address2,Post_code,Designation,Status,job_title,Apartment,Date_hired) " + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
					new Object[] { staffInformation.getId(), staffInformation.getFirst_name(), staffInformation.getSurname(), staffInformation.getDob(), staffInformation.getEmail(), 
							staffInformation.getTelephone(), staffInformation.getAddress(), staffInformation.getDepartment(), staffInformation.getImage()
							, staffInformation.getSalary(), staffInformation.getGender(), staffInformation.getAddress2(), staffInformation.getPost_code()
							, staffInformation.getDesignation(), staffInformation.getStatus(), staffInformation.getJob_title(), staffInformation.getApartment(),
							staffInformation.getDate_hired()});
		}
		
		public StaffInformation findStaffInfoById(Integer id) {
			return jdbcTemplate.queryForObject("select * from Staff_information where id=?", new Object[] { id },
					new BeanPropertyRowMapper<StaffInformation>(StaffInformation.class));
		}
		
		public int updateStaffInfoSalary(StaffInformation staffInformation) {
			return jdbcTemplate.update("update Staff_information set Salary = ? where id = ?",
					new Object[] {  staffInformation.getSalary(), staffInformation.getId()});
		}

}
