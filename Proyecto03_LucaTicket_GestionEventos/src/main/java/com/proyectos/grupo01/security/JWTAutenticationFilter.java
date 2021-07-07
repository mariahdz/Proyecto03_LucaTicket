package com.proyectos.grupo01.security;


import java.io.IOException;
import java.util.Collections;
import java.util.Date;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.web.filter.OncePerRequestFilter;


import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.SignatureAlgorithm;


public class JWTAutenticationFilter extends OncePerRequestFilter {

	static final long EXPIRATIONTIME = 864_000_000; // 10 days
	static final String SECRET = "ThisIsASecret";
	static final String TOKEN_PREFIX = "Bearer";
	static final String HEADER_STRING = "Authorization";



			public static void addAuthentication(HttpServletResponse res, String username) {
				String jwt = createToken(username);
			
				res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + jwt);
			}
			
			
			
			public static Authentication getAuthentication(HttpServletRequest request) {
					String token = request.getHeader(HEADER_STRING);
						if (token != null) {
								// parse the token.
							String user = Jwts.parser()
									.setSigningKey(SECRET)
									.parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
									.getBody()
									.getSubject();
			
			
			
			return user != null ?
					new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList()) :
						null;
					}
					return null;
				}



			public static String createToken(String username) {
			String jwt = Jwts.builder()
					.setSubject(username)
					.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
					.signWith(SignatureAlgorithm.HS512, SECRET)
					.compact();
		
		
		
			return jwt;
		}



			@Override
			protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
					FilterChain filterChain) throws ServletException, IOException {
				// TODO Auto-generated method stub
				
			}


/*
			
			protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
				try {
					if (checkJWTToken(request, response)) {
						Claims claims = validateToken(request);
					if (claims.get("authorities") != null) {
						setUpSpringAuthentication(claims);
					} else {
						SecurityContextHolder.clearContext();
					}
				}
					chain.doFilter(request, response);
				} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
						response.setStatus(HttpServletResponse.SC_FORBIDDEN);
						((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
				return;
				}
			}
			
			private boolean checkJWTToken(HttpServletRequest request, HttpServletResponse res) {
				String authenticationHeader = request.getHeader(HEADER_STRING);
					if (authenticationHeader == null || !authenticationHeader.startsWith(TOKEN_PREFIX))
						return false;
					return true;
			}
			
			private void setUpSpringAuthentication(Claims claims) {
				@SuppressWarnings("unchecked")
				List<String> authorities = (List<String>) claims.get("authorities");
				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
						authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
				SecurityContextHolder.getContext().setAuthentication(auth);



		}
			
			private Claims validateToken(HttpServletRequest request) {
				String jwtToken = request.getHeader(HEADER_STRING).replace(TOKEN_PREFIX, "");
				return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();
		}*/





}
