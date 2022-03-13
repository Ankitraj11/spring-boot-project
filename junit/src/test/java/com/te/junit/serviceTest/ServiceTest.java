package com.te.junit.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.junit.dto.UserDto;
import com.te.junit.repository.UserRepository;
import com.te.junit.response.UserResponse;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ServiceTest {

	
	private ObjectMapper objectMapper=new ObjectMapper();
	
	@MockBean
	private UserRepository userRepository;
	
	
	@Test
	public void addUserTest() throws JsonMappingException, JsonProcessingException {
		
		UserDto userDto=new UserDto();
		userDto.setUserId(1);
		userDto.setAge(24);
		userRepository.save(userDto);
		Optional< UserDto>  findById=userRepository.findByUserId(1);
		String writeValueAsString =objectMapper.writeValueAsString(findById);
		UserDto readvalueDto=objectMapper.readValue(writeValueAsString, UserDto.class);
		assertEquals(24, readvalueDto.getAge());
		
	}
}
