package com.crud.practiceCRUD.requestdto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {
	private Long id;
	  private String firstName;
	  private String lastName;
	  private String gender;
	  private Long libraryManagementId;
//	  private String designationName;
	  private String email;
	  private String contactNumber;
	  private Double availability;

}
