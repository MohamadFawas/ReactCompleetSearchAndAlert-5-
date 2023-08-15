package com.crud.practiceCRUD.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.practiceCRUD.entity.Employee;
import com.crud.practiceCRUD.entity.Library_management;
import com.crud.practiceCRUD.repository.EmployeeRepository;
import com.crud.practiceCRUD.requestdto.EmployeeRequest;
import com.crud.practiceCRUD.responce.EmployeeResponse;
import com.crud.practiceCRUD.service.EmployeeService;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	  private EmployeeRepository employeeRepository;

	  @Transactional
	  public void saveEmployee(EmployeeRequest employeeRequest) {
	    Employee employee = new Employee();
	    BeanUtils.copyProperties(employeeRequest, employee);
	    Library_management library_management = new Library_management();
	    library_management.setId(employeeRequest.getLibraryManagementId());
//	    employee.setLibrary_management(library_management);
	    employee.setLibraryManagement(library_management);
	    employeeRepository.save(employee);
	  }

	  @Override
	  public boolean isEmployeeExistsByEmail(String email) {
	    return employeeRepository.existsByEmailIgnoreCase(email);
	  }

	  @Override
	  public boolean isEmployeeExistsByContactNumber(String contactNumber) {
	    return employeeRepository.existsByContactNumberIgnoreCase(contactNumber);
	  }

	  @Override
	  public boolean existByEmployee(Long id) {
	    return employeeRepository.existsById(id);
	  }

	  @Transactional
	  public List<EmployeeResponse> getAllEmployee() {
	    List<EmployeeResponse> employeeResponses = new ArrayList<>();
	    List<Employee> employees = employeeRepository.findAll();
	    for (Employee employee : employees) {
	      EmployeeResponse employeeResponse = new EmployeeResponse();
	      BeanUtils.copyProperties(employee, employeeResponse);
//	      employeeResponse.setLibrary_managementId(employee.getLibrary_management().getId());
	      employeeResponse.setLibraryManagementId(employee.getLibraryManagement().getId());
//	      employeeResponse.setDesignationName(employee.getDesignation().getName());
	      employeeResponses.add(employeeResponse);
	    }
	    return employeeResponses;
	  }

	  @Transactional
	  public EmployeeResponse getEmployeeById(Long id) {

	    Employee employee = employeeRepository.findById(id).get();
	    EmployeeResponse employeeResponse = new EmployeeResponse();
	    BeanUtils.copyProperties(employee, employeeResponse);
	    //employeeResponse.setLibrary_managementId(employee.getLibrary_management().getId());
	    employeeResponse.setLibraryManagementId(employee.getLibraryManagement().getId());
//	    employeeResponse.setDesignationName(employee.getDesignation().getName());

	    return employeeResponse;
	  }

//	  @Override
//	  public List<Employee> getAllEmployeeByDesignationId(Long id) {
//	    return employeeRepository.findByLibrary_managementId(id);
//	  }

	  @Override
	  public boolean isUpdatedEmployeeEmailExist(Long id, String email) {
	    return employeeRepository.existsByEmailIgnoreCase(email);
	  }

	  @Override
	  public boolean isUpdatedEmployeeContactNumberExist(Long id, String contactNumber) {
	    return employeeRepository.existsByContactNumberIgnoreCase(contactNumber);
	  }

	  @Override
	  public void deleteEmployee(Long id) {
	    employeeRepository.deleteById(id);

	  }

	@Override
	public List<Employee> getAllEmployeeBylibraryManagementId(Long id) {
		return employeeRepository.findByLibraryManagementId(id);
	}

	 
}
