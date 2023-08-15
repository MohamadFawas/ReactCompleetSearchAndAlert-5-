package com.crud.practiceCRUD.serviceImp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.crud.practiceCRUD.entity.Library_management;
import com.crud.practiceCRUD.repository.BookRepository;
import com.crud.practiceCRUD.requestdto.BookRequestDto;
import com.crud.practiceCRUD.responce.BookResponceDto;
import com.crud.practiceCRUD.responce.search.LibraryManagementSearch;
import com.crud.practiceCRUD.service.BookService;
import com.querydsl.core.BooleanBuilder;

import jakarta.transaction.Transactional;

@Service
public class BookSeviceImp implements BookService {
	@Autowired
	private BookRepository bookRepository;

	@Transactional
	public void saveLibrary_management(BookRequestDto bookRequestDto) {
		// TODO Auto-generated method stub
		Library_management library_management=new Library_management();
		BeanUtils.copyProperties(bookRequestDto, library_management);
		bookRepository.save(library_management);
		
	}

	@Transactional
	public List<BookResponceDto> getAllLibrary_management() {
		List<BookResponceDto> bookResponceDtos=new ArrayList<>();
		List<Library_management> library_managements=bookRepository.findAll();
		
		for(Library_management library_management:library_managements) {
			BookResponceDto bookResponceDto=new BookResponceDto();
			BeanUtils.copyProperties(library_management , bookResponceDto);
			bookResponceDtos.add(bookResponceDto);
		}
		return bookResponceDtos;
	}

	@Override
	public boolean existsIndexNumberIgnoreCase(String indexNumber) {
		if(bookRepository.existsByIndexNumberIgnoreCase(indexNumber)) {
		return true;
		}
		return false;
	}

	@Override
	public BookResponceDto getLibrary_managementById(Long id) {
		Library_management library_management=bookRepository.findById(id).get();
		BookResponceDto bookResponceDto=new BookResponceDto();
		BeanUtils.copyProperties(library_management, bookResponceDto);
		
		return bookResponceDto;
	}

	@Override
	public boolean existByLibrary_management(Long id) {
		if(bookRepository.existsById(id)) {
			return true;
		}
		return false;
	}

	@Override
	public void deleteLibrary_management(Long id) {
//		bookRepository.deleteById(id);
		bookRepository.deleteById(id);
		
	}

	
	@Override
	public boolean importProjectStatusesFromCsv(MultipartFile file) {

	  try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

	    String line;

	    while ((line = reader.readLine()) != null) {

	      String[] data = line.split(",");

	      BookRequestDto bookRequestDto = new BookRequestDto();

	      bookRequestDto.setIndexNumber(data[1]);

	      bookRequestDto.setName(data[2]);
	      bookRequestDto.setTitle(data[3]);

	      Library_management library_management = new Library_management();
	      BeanUtils.copyProperties(bookRequestDto,library_management );
	
	      bookRepository.save(library_management);
	    }
	    return true; // Import successful

	  } catch (IOException e) {

	    e.printStackTrace();
	    return false; // Import failed
	  }

	}

	@Override
	public boolean isUpdatedLibrary_managementIndexNumberExist(Long id, String indexNumber) {
		
//		 return bookRepository.existsByNameIgnoreCaseAndIdNot(name, id);
		return bookRepository.existsByIndexNumberIgnoreCaseAndIdNot(indexNumber, id);
	}

	

//	@Override
//	public List<BookResponceDto> multiSearchBook(LibraryManagementSearch libraryManagementSearch) {
//		BooleanBuilder booleanBuilder =new BooleanBuilder();
//		
//		return null;
//	}
	
	

//	@Transactional
//	public void importProjectStatuss(MultipartFile file) throws IOException {
//		        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
//		            String line;
//		            String csvSplitBy = ","; // Change the separator if needed
//
//		            List<Library_management> lmList = new ArrayList<>();
//		            while ((line = br.readLine()) != null) {
//		                String[] data = line.split(csvSplitBy);
//		                // Assuming your CSV has columns in the following order: ID, Name, Email
//		                Library_management library_management = new Library_management();
//		                library_management.setIndexNumber(data[1]);
//		                library_management.setName(data[2]);
//		                library_management.setTitle(data[3]);
//		
//		                lmList.add(library_management);
//		            }
//		            bookRepository.saveAll(lmList);
//		        }
//		    }
//	


	

}
