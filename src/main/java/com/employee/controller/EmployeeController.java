package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.customexception.ControllerException;
import com.employee.customexception.NoIdException;
import com.employee.globalexceptionhandler.GlobalExceptionExample;
import com.employee.model.EmployeeModel;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
EmployeeService employeeService;

	@PostMapping("/createEmployee")
 public ResponseEntity<EmployeeModel> createEmployee(@RequestBody EmployeeModel employeeModel){
	 
	 return  new ResponseEntity<EmployeeModel> (employeeService.create(employeeModel),HttpStatus.OK);
 }
	@GetMapping("/getallemployees")
	public  ResponseEntity<?> getEmployees(){
		try {
		return  new ResponseEntity<List<EmployeeModel>> (employeeService.getAllEmployee(),HttpStatus.OK);
		}
		catch (NoIdException e) {
			ControllerException exception=new ControllerException(e.getStatus(),e.getMessage());
			return  new ResponseEntity<ControllerException>(exception,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/updateemployee/{id}")
public ResponseEntity<?> updateEmployee(@RequestBody EmployeeModel employeeModel ,@PathVariable long id) {
	try {
		EmployeeModel employeeModel2 = employeeService .updateEmployee(employeeModel,id);
		return new ResponseEntity<EmployeeModel> (employeeModel2,HttpStatus.CREATED);
		
	    } 
	catch (NoIdException e) {
		ControllerException exception=new ControllerException(e.getStatus(),e.getMessage());
		return  new ResponseEntity<ControllerException>(exception,HttpStatus.BAD_REQUEST);
	}
				 	
	 	
}  
	
	//using @controlleradvice and ExceptionHandler called as global exception handling
	@DeleteMapping("/deleteemployee/{id}")
	public void deleteEmployee(@PathVariable long id) {
		
		employeeService.deleteEmployeeById(id);
		
	}
	
}
