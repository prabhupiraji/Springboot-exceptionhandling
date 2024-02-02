package com.employee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="employeedata")
public class EmployeeModel {
 @Id
Long id;
String name;
String email;
Long mobileNo;
String dateOfBirth;

}
