package com.crud.practiceCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.practiceCRUD.common.responce.BaseResponse;
import com.crud.practiceCRUD.common.responce.ContentResponse;
import com.crud.practiceCRUD.error.Constants;
import com.crud.practiceCRUD.error.ValidationFailerresponce;
import com.crud.practiceCRUD.requestdto.EmployeeRequest;
import com.crud.practiceCRUD.service.BookService;
import com.crud.practiceCRUD.service.EmployeeService;

@RestController
@CrossOrigin
public class EmployeeController {
	@Autowired
	  private EmployeeService employeeService;
	
	@Autowired
	private ValidationFailerresponce validationFailerresponce;
	@Autowired
	private BookService bookService;
	
	 @PostMapping("/poste1")
	  public ResponseEntity<Object> saveEmployee(@RequestBody EmployeeRequest employeeRequest) {
	    if (employeeService.isEmployeeExistsByEmail(employeeRequest.getEmail())) {
	   
	    	return ResponseEntity.ok(new BaseResponse(validationFailerresponce.getValidationBookAlreadyExists(),
					validationFailerresponce.getFailureCode()));
	    }
	    if (employeeService.isEmployeeExistsByContactNumber(employeeRequest.getContactNumber())) {
	      
	      return ResponseEntity.ok(new BaseResponse(validationFailerresponce.getValidationBookAlreadyExists(),
					validationFailerresponce.getFailureCode()));
	    }
	    
	    employeeService.saveEmployee(employeeRequest);
	    return ResponseEntity.ok(new BaseResponse(validationFailerresponce.getSaveBookSuccessMessage(),
				validationFailerresponce.getCommonSuccessCode()));
	  }
	

	 
	 @GetMapping("/getAlle1")
	  public ResponseEntity<Object> getAllEmployees() {
	    
		 return ResponseEntity.ok(new ContentResponse<>(Constants.BOOKs, employeeService.getAllEmployee(),
					validationFailerresponce.getGetAllBookSuccessMessage(),
					validationFailerresponce.getCommonSuccessCode()));
	  }
	 
	 @GetMapping("/getIde1/{id}")
	  public ResponseEntity<Object> getEmployeeById(@PathVariable Long id) {
	    if (!employeeService.existByEmployee(id)) {
	      
	    	return ResponseEntity.ok(new BaseResponse(validationFailerresponce.getValidationBookAlreadyExists(),
					validationFailerresponce.getFailureCode()));
	    }
	    
	    return ResponseEntity.ok(new ContentResponse<>(Constants.BOOKs, employeeService.getEmployeeById(id),
				validationFailerresponce.getGetAllBookSuccessMessage(),
				validationFailerresponce.getCommonSuccessCode()));
	  }
	 
	 
	 @PutMapping("/update1/{id}")
	  public ResponseEntity<Object> updateEmployee(@PathVariable Long id,@RequestBody EmployeeRequest employeeRequest) {
	    if (!employeeService.existByEmployee(employeeRequest.getId())) {
	  
	    	return ResponseEntity.ok(new BaseResponse(validationFailerresponce.getValidationBookAlreadyExists(),
					validationFailerresponce.getFailureCode()));
	    }
	    if (employeeService.isUpdatedEmployeeEmailExist(employeeRequest.getId(),
	        employeeRequest.getEmail())) {
	    	return ResponseEntity.ok(new BaseResponse(validationFailerresponce.getValidationBookAlreadyExists(),
					validationFailerresponce.getFailureCode()));
	    }
	    
	    employeeService.saveEmployee(employeeRequest);
	    return ResponseEntity.ok(new BaseResponse(validationFailerresponce.getSaveBookSuccessMessage(),
				validationFailerresponce.getCommonSuccessCode()));
	  }
	 
	 @DeleteMapping("/delete1/{id}")
	  public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) {
	    if (!employeeService.existByEmployee(id)) {
	      
	    	return ResponseEntity.ok(new BaseResponse(validationFailerresponce.getValidationBookAlreadyExists(),
					validationFailerresponce.getFailureCode()));
	    }
	    
	    
	    employeeService.deleteEmployee(id);
		return ResponseEntity.ok(new BaseResponse(validationFailerresponce.getDeleteSuccessMessage(),
				validationFailerresponce.getCommonSuccessCode()));
	  }
	 
	 @GetMapping("/libraryid/{id}")
	  public ResponseEntity<Object> getEmployeeByLibraryManagementId(@PathVariable Long id) {
	    if (!bookService.existByLibrary_management(id)) {
	      
	    	return ResponseEntity.ok(new BaseResponse(validationFailerresponce.getValidationBookAlreadyExists(),
					validationFailerresponce.getFailureCode()));
	    }
		return ResponseEntity.ok(new ContentResponse<>(Constants.BOOKs, employeeService.getAllEmployeeBylibraryManagementId(id),
				validationFailerresponce.getGetAllBookSuccessMessage(),
				validationFailerresponce.getCommonSuccessCode()));
	    
//	    return ResponseEntity.ok(
//	        new ContentResponse<>(Constants.EMPLOYEE, employeeService.getAllEmployeeByDesignationId(id),
//	            RequestStatus.SUCCESS.getStatus(), validationFailureResponseCode.getCommonSuccessCode(),
//	            validationFailureResponseCode.getGetEmployeeByIdSuccessMessage()));
//	  
	    
	 }
	}

