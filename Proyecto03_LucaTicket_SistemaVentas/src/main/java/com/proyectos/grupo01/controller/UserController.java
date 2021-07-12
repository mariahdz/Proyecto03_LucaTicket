//package com.proyectos.grupo01.controller;
//
//
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.proyectos.grupo01.model.User;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//
//
//
//
///*
// * AUTENTICACION
// * 
// * Este controlador REST implementa el proceso de autenticación mediante un login usuario/contraseña:
// * 
// */
//
//@RestController
//public class UserController {
//	
//	
//	/*
//	 * el método login(...) interceptará las peticiones POST al endpoint /user
//	 * y recibirá como parámetros El usuario y contraseña. 
//	 * Como se puede observar, para este ejemplo no se realiza ninguna validación de usuario y contraseña, 
//	 * por lo que para cualquier valor de dichos parámetros dejaremos paso. 
//	 * Obviamente, para un proyecto real, en este punto deberíamos autenticar el usuario 
//	 * contra nuestra base de datos o contra cualquier proveedor externo.
//	 */
//	@PostMapping("user")
//	public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
//		
//		String token = getJWTToken(username);
//		User user = new User();
//		user.setUser(username);
//		//No encriptado
//		user.setPwd(pwd);
//		user.setToken(token);		
//		return user;
//		
//	}
//
//	/*
//	 * El método getJWTToken(...) se usa para construir el token, 
//	 * delegando en la clase de utilidad Jwts que incluye información sobre su expiración 
//	 * y un objeto de GrantedAuthority de Spring.
//	 * Este objeto lo usaremos para autorizar las peticiones a los recursos protegidos.
//	 *  
//	 */
//	private String getJWTToken(String username) {
//		String secretKey = "mySecretKey";
//		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
//				.commaSeparatedStringToAuthorityList("ROLE_USER");
//		
//		String token = Jwts
//				.builder()
//				.setId("softtekJWT")
//				.setSubject(username)
//				.claim("authorities",
//						grantedAuthorities.stream()
//								.map(GrantedAuthority::getAuthority)
//								.collect(Collectors.toList()))
//				.setIssuedAt(new Date(System.currentTimeMillis()))
//				.setExpiration(new Date(System.currentTimeMillis() + 600000))
//				.signWith(SignatureAlgorithm.HS512,
//						secretKey.getBytes()).compact();
//
//		return "Bearer " + token;
//	}
//
//}
