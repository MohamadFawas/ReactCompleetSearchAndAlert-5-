package com.crud.practiceCRUD.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.practiceCRUD.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	 public boolean existsByEmailIgnoreCase(String email);

	  public boolean existsByContactNumberIgnoreCase(String contactNumber);
	  
	  //public boolean eistsByLibrary_managementId(Long id);

	  public List<Employee> findByLibraryManagementId(Long library_managementId);

}
