package com.user.login.loginuser;

import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.user.login.loginuser.repo.LoginRepository;
import com.user.login.loginuser.userdetails.Login;
import com.user.login.loginuser.userdetails.SignUp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(LoginController.class)
class LoginUserApplicationTests {

	@Mock
	private RestTemplate restTemplate;
	@Mock
	LoginController loginController;
	@MockBean
	LoginRepository repository;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testAddUser() throws JsonProcessingException, Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

	//	URI uri = URI.create("http://localhost:" + 8080 + "/signUp");
		SignUp signup = new SignUp("zack", "zzz", "dumy5", "CH", "87656757");

		
		  Mockito.when(loginController.signUpUser(signup)) .thenReturn(new
		  ResponseEntity<>("User registered", HttpStatus.CREATED));
		 
		mockMvc
				.perform(post("/api/signUp").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(signup)).characterEncoding("utf-8"))
				.andExpect(status().isCreated()).andReturn();

	}
	
	@Test
	public void testLoginUser() throws JsonProcessingException, Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

	//	URI uri = URI.create("http://localhost:" + 8080 + "/signUp");
		Login login = new Login();
		login.setUserName("Sowbaghya");
		login.setPassword("dummy");
		

		Mockito.when(loginController.loginUser(login))
				.thenReturn(new ResponseEntity<>("valid user", HttpStatus.OK));
		 mockMvc
				.perform(post("/api/login").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(login)).characterEncoding("utf-8"))
				.andExpect(status().isOk()).andReturn();

	}

}
