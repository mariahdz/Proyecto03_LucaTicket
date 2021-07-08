package com.proyectos.grupo01;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

//import com.proyectos.grupo01.security.JWTAutenticationFilter;
//import com.proyectos.grupo01.security.JWTAuthorizationFilter;
		
/*
 * @autor Desiree
 * @version 07/07/2021
 * Test
 * 
 */
		
		
	//	@SpringBootTest
	//	@AutoConfigureMockMvc
	/*	public class JWTTest {
			
			@MockBean
			JWTAuthorizationFilter JWT;
			
			@MockBean
			JWTAutenticationFilter jwt;

		    @Autowired
		    private MockMvc mvc;

		    
		    @Test
		    public void shouldNotAllowAccessToUnauthenticatedUsers() throws Exception {
		        mvc.perform(MockMvcRequestBuilders.get("/test")).andExpect(status().isForbidden());
		    }
		    
		    @Test
		    public void shouldGenerateAuthToken() throws Exception {
	//	        String token = JWTAuthorizationFilter.createToken("john");
		        String token2 = jwt.createToken("jony");

		        assertNotNull(token2);
		        mvc.perform(MockMvcRequestBuilders.get("/test").header("Authorization", token2)).andExpect(status().isOk());
		    }
		    
		    @Test
		    public void nonexistentUserCannotGetToken() throws Exception {
		        String username = "nonexistentuser";
		        String password = "password";

		        String body = "{\"username\":\"" + username + "\", \"password\":\"" 
		                      + password + "\"}";

		        mvc.perform(MockMvcRequestBuilders.post("/v2/token")
		                .content(body))
		                .andExpect(status().isForbidden()).andReturn();
		    }
*/
	//	}
		



