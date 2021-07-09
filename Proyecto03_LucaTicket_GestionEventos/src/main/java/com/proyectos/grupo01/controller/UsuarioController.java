package com.proyectos.grupo01.controller;
//
//import java.util.List;



//
//
//
//import org.springframework.web.bind.annotation.RestController;
//
//import com.proyectos.grupo01.model.User;
//import com.proyectos.grupo01.repository.EventoRepository;
//import com.proyectos.grupo01.repository.EventoRepositoryImpl;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//
//
//@RestController
//public class UsuarioController {
//
//	private UserRepository usuarioRepository;
//	
//
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//	public UsuarioController(EventoRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
//		this.usuarioRepository =  (UserRepository) usuarioRepository;
//		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//	}
//	
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
//
//	@PostMapping("/users/")
//	public void saveUsuario(@RequestBody User user) {
//		user.setPwd(bCryptPasswordEncoder.encode(user.getPwd()));
//		usuarioRepository.save(user);
//	}
//////
////	@GetMapping("/users/")
////	public List<Usuario> getAllUsuarios() {
////		return usuarioRepository.findAll();
////	}
////
////	@GetMapping("/users/{username}")
////	public Usuario getUsuario(@PathVariable String username) {
////		return usuarioRepository.findByUsername(username);
////	}
//}