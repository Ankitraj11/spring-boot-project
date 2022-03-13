package com.te.junit.controllerTes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.junit.dto.UserDto;
import com.te.junit.response.UserResponse;
import com.te.junit.service.UserService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ControllerTest {

	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	private ObjectMapper mapper=new ObjectMapper();
	@MockBean
	private UserService service;
	
	@BeforeEach
     void steUp() {
    	 mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
     }
     
     @Test
     void addUsertest() throws JsonProcessingException,UnsupportedEncodingException,Exception{
    	 UserDto data=new UserDto(1,"abc","abc",27);
    	 when(service.adduser(data)).thenReturn(data);
    	 String contentAsSring =mockMvc.perform(post("/addUser")
    			 .content(mapper.writeValueAsString(data))
    			 .contentType(MediaType.APPLICATION_JSON_VALUE)
    			 .accept(MediaType.APPLICATION_JSON_VALUE))
    			 .andExpect(status().isOk())
    			 .andReturn().getResponse()
    			 .getContentAsString();
    	 
    	 UserResponse userResponse=mapper.readValue(contentAsSring, UserResponse.class);
    	 assertEquals("user added successfully", userResponse.getMessage());
     }

}


