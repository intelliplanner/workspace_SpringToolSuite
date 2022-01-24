package com.ipssi.ppgcl.jwt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ipssi.ppgcl.services.JwtUserDetailService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

//	@Autowired
//	BCryptPasswordEncoder bcrypt;

	@Autowired
	JwtUserDetailService userDetailService;

	@Autowired
	AuthTokenFilter authTokenFilter;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService);
	}

	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.cors().and().csrf().disable()
//		.exceptionHandling().authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED)).and()
//				.sessionManagement()
				.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers("/api/auth/authenticate").permitAll()
//				.antMatchers("/api/captcha/getCaptcha").permitAll()
				.antMatchers("/api/captcha/**").permitAll().antMatchers("/api/auth/register").permitAll()
				.antMatchers("/api/tpr/**").permitAll().antMatchers("/api/transporter/**").permitAll()
				.antMatchers("/api/master/**").permitAll().antMatchers(HttpMethod.GET, "/swagger-ui.html/**")
				.permitAll().antMatchers(HttpMethod.GET, "/webjars/**").permitAll()
				.antMatchers(HttpMethod.GET, "/swagger-resources/**").permitAll()
				.antMatchers(HttpMethod.GET, "/v2/api-docs/**").permitAll()

//				.antMatchers("/api/**").permitAll()

				.anyRequest().authenticated();
		http.addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class);

	}

}