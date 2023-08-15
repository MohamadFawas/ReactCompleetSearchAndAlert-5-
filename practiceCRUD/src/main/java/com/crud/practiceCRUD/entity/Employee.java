package com.crud.practiceCRUD.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Employee {

	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private Long id;
	  private String firstName;
	  private String lastName;
	  private String gender;
	  @ManyToOne
	  @JoinColumn(name = "library_managementId", nullable = false)
	  private Library_management libraryManagement;
	  private String email;
	  private String contactNumber;
	  private Double availability;
}
