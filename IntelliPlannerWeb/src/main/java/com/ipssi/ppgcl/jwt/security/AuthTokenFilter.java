package com.ipssi.ppgcl.jwt.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ipssi.ppgcl.services.JwtUserDetailService;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class AuthTokenFilter extends OncePerRequestFilter {

	private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	JwtUserDetailService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String requestTokenHeader  = request.getHeader("Authorization");
		String username = null;
		String token = null;

		if (requestTokenHeader != null && StringUtils.hasText(requestTokenHeader) && requestTokenHeader.startsWith("Bearer ")) {
			token = requestTokenHeader.substring(7, requestTokenHeader.length());
			try {
				username = jwtUtils.getUsernameFromToken(token);
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			} catch (ExpiredJwtException e) {
				System.out.println("JWT Token has expired");
			}
		} else {
			logger.warn("JWT Token does not begin with Bearer String");
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

			if (jwtUtils.validateToken(token, userDetails)) {

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}

		filterChain.doFilter(request, response);
	}

}
