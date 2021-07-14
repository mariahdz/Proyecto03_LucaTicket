//package com.proyectos.grupo01.security;
//
//
//
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//import io.jsonwebtoken.Jwts;
//
//public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
//	
//	private final String HEADER_AUTHORIZACION_KEY = "Authorization";
//	private final String TOKEN_BEARER_PREFIX = "Bearer ";
//	private final String SUPER_SECRET_KEY = "mySecretKey";
//	
//
//
//	public JWTAuthorizationFilter(AuthenticationManager authManager) {
//		super(authManager);
//	}
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
//			throws IOException, ServletException {
//		String header = req.getHeader(HEADER_AUTHORIZACION_KEY);
//		if (header == null || !header.startsWith(TOKEN_BEARER_PREFIX)) {
//			chain.doFilter(req, res);
//			return;
//		}
//		UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		chain.doFilter(req, res);
//	}
//
//	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
//		String token = request.getHeader(HEADER_AUTHORIZACION_KEY);
//		if (token != null) {
//			// Se procesa el token y se recupera el usuario.
//			String user = Jwts.parser()
//						.setSigningKey(SUPER_SECRET_KEY)
//						.parseClaimsJws(token.replace(TOKEN_BEARER_PREFIX, ""))
//						.getBody()
//						.getSubject();
//
//			if (user != null) {
//				return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
//			}
//			return null;
//			}
//		return null;
//	}
//	
//	 public static Authentication getAuthentication(HttpServletRequest request) {
//	        String token = request.getHeader(HEADER_STRING);
//	        if (token != null) {
//	            // parse the token.
//	            String user = Jwts.parser()
//	                    .setSigningKey(SECRET)
//	                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
//	                    .getBody()
//	                    .getSubject();
//
//	            return user != null ?
//	                    new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList()) :
//	                        null;
//	        }
//	        return null;
//	    }
//
//}
