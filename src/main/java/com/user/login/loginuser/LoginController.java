package com.user.login.loginuser;

import java.io.IOException;

import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.user.login.loginuser.repo.LoginRepository;
import com.user.login.loginuser.userdetails.Login;
import com.user.login.loginuser.userdetails.SignUp;
import com.user.login.loginuser.userdetails.Users;

@RestController
public class LoginController {

	@Autowired
	private LoginRepository repository;

	@Autowired
	Validation validation;

	@PostMapping(value = "/api/signUp")
	public ResponseEntity<Object> signUpUser(@RequestBody SignUp signup) {

		if (validation.validateUser(signup)) {

			return new ResponseEntity<>("Fill the mandatory fields", HttpStatus.BAD_REQUEST);
		}

		if (repository.existsByUserName(signup.getUsername())) {
			return ResponseEntity.badRequest().body("Error: Username is already taken!");
		}

		if (repository.existsByEmail(signup.getEmail())) {
			return ResponseEntity.badRequest().body("Error: Email is already in use!");
		}

		Users user = new Users();
		user.setUserName(signup.getUsername());
		user.setEmail(signup.getEmail());
		user.setPassword(signup.getPassword());
		user.setPhoneNo(signup.getPhoneNo());
		user.setState(signup.getState());
		repository.save(user);

		return new ResponseEntity<>("User registered", HttpStatus.CREATED);
	}

	@PostMapping("/api/login")
	public ResponseEntity<Object> loginUser(@RequestBody Login login) {

		/*
		 * if (validation.validateLoginUser(login)) {
		 * 
		 * return new ResponseEntity<>("Fill the mandatory fields",
		 * HttpStatus.BAD_REQUEST); }
		 */

		Users user = repository.findByUserNameAndPassword(login.getUserName(), login.getPassword());

		if (user != null) {
			return new ResponseEntity<>("User login", HttpStatus.OK);

		}
		return new ResponseEntity<>("User not registered", HttpStatus.CONFLICT);
	}

	@PostMapping(value = "/api/uploadExcel", consumes = "multipart/form-data")
	public ResponseEntity<String> uploadExcel(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return ResponseEntity.badRequest().body("Please upload a file.");
		}

		try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
			Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
			for (Row row : sheet) {
				// Assuming the first column is username and the second is password
				String username = getCellValueAsString(row.getCell(0));
				String email = getCellValueAsString(row.getCell(1));
				String phoneNo = getCellValueAsString(row.getCell(2));
				String state = getCellValueAsString(row.getCell(3));
				String password = getCellValueAsString(row.getCell(4));
				// Create and save the user
				Users user = new Users();
				user.setUserName(username);
				user.setEmail(email);
				user.setPassword(password);
				user.setPhoneNo(phoneNo);
				user.setState(state);
				repository.save(user);

			}
		} catch (IOException e) {
			return ResponseEntity.status(500).body("Could not process the file: " + e.getMessage());
		}

		return ResponseEntity.ok("Users uploaded successfully.");
	}

	private String getCellValueAsString(Cell cell) {
		if (cell == null) {
			return null;
		}

		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case FORMULA:
			return cell.getCellFormula();
		default:
			return "";
		}
	}
}
