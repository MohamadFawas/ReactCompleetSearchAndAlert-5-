package com.crud.practiceCRUD.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.crud.practiceCRUD.common.responce.BaseResponse;
import com.crud.practiceCRUD.common.responce.ContentResponse;
import com.crud.practiceCRUD.error.Constants;
import com.crud.practiceCRUD.error.ValidationFailerresponce;
import com.crud.practiceCRUD.requestdto.BookRequestDto;
import com.crud.practiceCRUD.service.BookService;

@RestController
@CrossOrigin("http://localhost:3000")
public class BookController {

	@Autowired
	private BookService bookService;
	// private static final Logger logger
	// =LoggerFactory.getLogger(BookController.class);

	@Autowired
	private ValidationFailerresponce validationFailerresponce;
	// @Autowired
	// private Statuses statuses;

	@PostMapping("/post")
	public ResponseEntity<Object> saveLibrary_management(@RequestBody BookRequestDto bookRequestDto) {
		if (bookService.existsIndexNumberIgnoreCase(bookRequestDto.getIndexNumber())) {
			return ResponseEntity.ok(new BaseResponse(validationFailerresponce.getValidationBookAlreadyExists(),
					validationFailerresponce.getFailureCode()));
		}
		
			
			  if (bookService.isUpdatedLibrary_managementIndexNumberExist(bookRequestDto.getId(),
					  bookRequestDto.getName())) {
				  return ResponseEntity.ok(new BaseResponse(
							validationFailerresponce.getCommonSuccessCode(),validationFailerresponce.getSaveBookSuccessMessage()));
			  }

		bookService.saveLibrary_management(bookRequestDto);
		return ResponseEntity.ok(new BaseResponse(validationFailerresponce.getCommonSuccessCode(), validationFailerresponce.getSaveBookSuccessMessage()
				));
	}

	@GetMapping("/getAll")
	public ResponseEntity<Object> getAllLibrary_management() {
		return ResponseEntity.ok(new ContentResponse<>(Constants.BOOKs, bookService.getAllLibrary_management(),
				validationFailerresponce.getGetAllBookSuccessMessage(),
				validationFailerresponce.getCommonSuccessCode()));

	}

	@GetMapping("/getId/{id}")
	public ResponseEntity<Object> getLibrary_managementById(@PathVariable Long id) {
		if (!(bookService.existByLibrary_management(id))) {
			return ResponseEntity.ok(new BaseResponse(validationFailerresponce.getErrorNotFoundIdMessage(),
					validationFailerresponce.getErrorNotFoundIdCode()));
		}

		return ResponseEntity.ok(new ContentResponse<>(Constants.BOOK, bookService.getLibrary_managementById(id),
				validationFailerresponce.getGetByIdBookSuccessMessage(),
				validationFailerresponce.getCommonSuccessCode()));

	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateLibrary_management(@PathVariable Long id, @RequestBody BookRequestDto bookRequestDto) {
//		if ((bookService.existsIndexNumberIgnoreCase(bookRequestDto.getIndexNumber()))) {
//			return ResponseEntity.ok(new BaseResponse(validationFailerresponce.getErrorNotFoundIdMessage(),
//					validationFailerresponce.getErrorNotFoundIdCode()));
//		}

		bookService.saveLibrary_management(bookRequestDto);
		return ResponseEntity.ok(new BaseResponse(validationFailerresponce.getCommonSuccessCode(), 
				validationFailerresponce.getSaveBookSuccessMessage()));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteLibrary_management(@PathVariable Long id) {
		if (!(bookService.existByLibrary_management(id))) {
			return ResponseEntity.ok(new BaseResponse(validationFailerresponce.getErrorNotFoundIdMessage(),
					validationFailerresponce.getErrorNotFoundIdCode()));
		}
		bookService.deleteLibrary_management(id);
		return ResponseEntity.ok(new BaseResponse(validationFailerresponce.getCommonSuccessCode(), 
				validationFailerresponce.getDeleteSuccessMessage()));
	}
	
//	 @PostMapping("/upload")
//	  public ResponseEntity<String> importCSV(@RequestParam("file") MultipartFile file) {
//	      try {
//	    	  bookService.importProjectStatuss(file);
//	          return ResponseEntity.ok("CSV data imported successfully.");
//	      } catch (IOException e) {
//	          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while importing CSV.");
//	      }
//	  }
	
	 @PostMapping("/upload")
	  public ResponseEntity<Object> importProjectStatuses(@RequestParam("file") MultipartFile file)
	      throws IOException {

	    if (!bookService.importProjectStatusesFromCsv(file)) {
//	      logger.info("Cannot Import ProjectStatus");
	    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while importing CSV.");
	    }

	  //  bookService.importProjectStatusesFromCsv(file);
//	    logger.info("Employee imported successfully");
	    return ResponseEntity.ok(new BaseResponse(validationFailerresponce.getDeleteSuccessMessage(),
				validationFailerresponce.getCommonSuccessCode()));

	  }

}
