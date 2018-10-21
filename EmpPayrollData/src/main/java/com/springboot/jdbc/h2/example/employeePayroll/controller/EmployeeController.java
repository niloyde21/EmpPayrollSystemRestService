package com.springboot.jdbc.h2.example.employeePayroll.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jdbc.h2.example.employeePayroll.Employee;
import com.springboot.jdbc.h2.example.employeePayroll.EmployeeJdbcRepository;
import com.springboot.jdbc.h2.example.employeePayroll.StaffInformation;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeJdbcRepository repository;
	
	@RequestMapping("/findEmployees")
	//@GET
    public List<Employee> getEmployees() 
    {
		List<Employee> employeesList = repository.findAll();
		//employeesList.add(new Employee(1,"lokesh","gupta","howtodoinjava@gmail.com"));
		return employeesList;
    }
	
	@RequestMapping("/findEmployee")
	//@GET
    public Employee getEmployee(@RequestParam("empId") Integer empId) 
    {
		Employee employee = repository.findById(empId);
		//employeesList.add(new Employee(1,"lokesh","gupta","howtodoinjava@gmail.com"));
		return employee;
    }
	
	
	@RequestMapping(value = "/validateEmployee", method = RequestMethod.POST)
    public Employee validateEmployee(@RequestBody Employee employee) 
    {
		if(repository.isUserExists(employee.getUserName(), employee.getPassword())) {
			return repository.findByUserNameAndPassword(employee.getUserName(), employee.getPassword());
		} else {
			employee.setId(0);
			return employee;
		}
		//employeesList.add(new Employee(1,"lokesh","gupta","howtodoinjava@gmail.com"));
		
    }
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ResponseEntity<Employee> update(@RequestBody Employee employee) {

//	    if (car != null) {
//	        car.setMiles(car.getMiles() + 100);
//	    }
		employee.setId(repository.maxEmpId() + 1);
	    repository.insert(employee);
	    // TODO: call persistence layer to update
	    return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/validateStaffInformation", method = RequestMethod.POST)
    public StaffInformation validateStaffInformation(@RequestBody StaffInformation staffInformation) 
    {
		if(repository.isStaffExists(staffInformation.getEmail(), staffInformation.getTelephone())) {
			staffInformation.setId(-1);
		} else {
			staffInformation.setId(1);			
		}
		return staffInformation;
		//employeesList.add(new Employee(1,"lokesh","gupta","howtodoinjava@gmail.com"));
		
    }
	
	
	@RequestMapping(value = "/addStaffInformation", method = RequestMethod.POST)
	public ResponseEntity<StaffInformation> addStaffInformation(@RequestBody StaffInformation staffInformation) {
		staffInformation.setId(repository.maxStaffId() + 1);
		repository.insertStaffInfo(staffInformation);
	    // TODO: call persistence layer to update
	    return new ResponseEntity<StaffInformation>(staffInformation, HttpStatus.OK);
	}

	@RequestMapping(value = "/updateStaffSalary", method = RequestMethod.POST)
	public ResponseEntity<StaffInformation> updateStaffSalary(@RequestBody StaffInformation staffInformation) {
	    repository.updateStaffInfoSalary(staffInformation);
	    // TODO: call persistence layer to update
	    return new ResponseEntity<StaffInformation>(staffInformation, HttpStatus.OK);
	}
	
	@RequestMapping("/findStaffInfoById")
	//@GET
    public StaffInformation getStaffInfoById(@RequestParam("empId") Integer empId) 
    {
		StaffInformation staffInformation = repository.findStaffInfoById(empId);
		//employeesList.add(new Employee(1,"lokesh","gupta","howtodoinjava@gmail.com"));
		return staffInformation;
    }
}
