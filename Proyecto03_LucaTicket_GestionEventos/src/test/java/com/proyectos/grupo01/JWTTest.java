package com.proyectos.grupo01;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.proyectos.grupo01.model.User;
import com.proyectos.grupo01.security.JWTAuthorizationFilter;
		
		
		
		@SpringBootTest
		@AutoConfigureMockMvc
		public class JWTTest {
			
			@MockBean
			JWTAuthorizationFilter JWT;

		    @Autowired
		    private MockMvc mvc;

		    @Test
		    public void shouldNotAllowAccessToUnauthenticatedUsers() throws Exception {
		        mvc.perform(MockMvcRequestBuilders.get("/test")).andExpect(status().isForbidden());
		    }

		}
		



