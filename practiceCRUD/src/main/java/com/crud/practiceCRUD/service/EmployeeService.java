package com.crud.practiceCRUD.service;

import java.util.List;

import com.crud.practiceCRUD.entity.Employee;
import com.crud.practiceCRUD.requestdto.EmployeeRequest;
import com.crud.practiceCRUD.responce.EmployeeResponse;

public interface EmployeeService {
	 public void saveEmployee(EmployeeRequest employeeRequest);

	  public boolean isEmployeeExistsByEmail(String email);

	  public boolean isEmployeeExistsByContactNumber(String contactNumber);

	  public boolean existByEmployee(Long id);

	  public List<EmployeeResponse> getAllEmployee();

	  public EmployeeResponse getEmployeeById(Long id);

	  public List<Employee> getAllEmployeeBylibraryManagementId(Long id);

	  public boolean isUpdatedEmployeeEmailExist(Long id, String email);

	  public boolean isUpdatedEmployeeContactNumberExist(Long id, String contactNumber);

	  public void deleteEmployee(Long id);

}
