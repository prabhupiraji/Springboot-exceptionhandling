package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.customexception.NoIdException;
import com.employee.model.EmployeeModel;
import com.employee.repository.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
EmployeeRepo employeeRepo;

	public EmployeeModel create(EmployeeModel employeeModel) {
		// TODO Auto-generated method stub
		return employeeRepo.save(employeeModel);
	}

	public List<EmployeeModel> getAllEmployee() {
		
		List<EmployeeModel> listdata= employeeRepo.findAll();
		try{if(listdata.isEmpty()) {
			throw new NoIdException("603","no data is present db please save the some data and try again");
		}
		 return listdata;
		}
		catch(Exception e) {
			throw new NoIdException("602", "something went wrong in service layer"+ e.getMessage());
		 }
	}
	
//using custom exception
	public EmployeeModel updateEmployee(EmployeeModel employeeModel, long id) {
		
		try {
		     if(id<=0 || employeeModel.getId()==0) {
		      throw new NoIdException("601","Input id is empty please enter inputid");
		    }   
		   EmployeeModel savedEmployee = employeeRepo.save(employeeModel);
			return savedEmployee;	
		    }
		catch(Exception e) {
				throw new NoIdException("602", "something went wrong in service layer"+ e.getMessage());
			 }
		
	    }
	
	//using global exception handler
	public void deleteEmployeeById(long id) {
		
	if (employeeRepo.findById(id).isPresent()){
		 employeeRepo.deleteById(id);
	}
	else
		 throw new NoIdException("604","given id is not  present in db");
	
	}

}
