package com.crud.practiceCRUD.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.crud.practiceCRUD.entity.Library_management;
import com.crud.practiceCRUD.requestdto.BookRequestDto;
import com.crud.practiceCRUD.responce.BookResponceDto;
import com.crud.practiceCRUD.responce.search.LibraryManagementSearch;

public interface BookService {
	public void saveLibrary_management(BookRequestDto bookRequestDto ); 
	public List<BookResponceDto> getAllLibrary_management();
	
	public boolean existsIndexNumberIgnoreCase(String indexNumber);
	public boolean existByLibrary_management(Long id);
	
	public BookResponceDto getLibrary_managementById(Long id);
	
	//public boolean getLibrary_managementById(Long id);
	public void deleteLibrary_management(Long id);
	public boolean isUpdatedLibrary_managementIndexNumberExist(Long id, String indexNumber);
	
//	void importProjectStatuss(MultipartFile file) throws IOException;
	
	public boolean importProjectStatusesFromCsv(MultipartFile file) ;
	
//	List<BookResponceDto> multiSearchBook(LibraryManagementSearch libraryManagementSearch);
}
