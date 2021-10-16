//package com.test.springsecurityconfig;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//@SuppressWarnings("deprecation")
////@Configuration
////@Order(1)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//		return source;
//	}
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
////		http.csrf().disable().authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();  // Api based Security
////	}
//
////	
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
////		http.csrf().disable().authorizeRequests().antMatchers("/auth1/**").fullyAuthenticated().and().httpBasic();// Api based Security
////	}
////	
//
////	@Autowired
////	UserDetailsService customeUserDetailsService;
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
////		http.csrf().disable().authorizeRequests().antMatchers("/auth1/**").hasAnyRole("ADMIN").anyRequest().fullyAuthenticated().and().httpBasic();// Role Based Security
//
//		http.cors();
//
////		http.csrf().disable().authorizeRequests()
////		.antMatchers("/auth1/**").hasAnyRole("TEST")
////		.antMatchers("/auth2/**").hasAnyRole("USER")
////		.anyRequest().fullyAuthenticated().and().httpBasic();// Role Based Security
//
//		// .antMatchers("/**").hasAnyRole("ADMIN")
//	}
//
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("admin").password("admin123").roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("user").password("user123").roles("USER");
//		auth.inMemoryAuthentication().withUser("test").password("test123").roles("TEST");
//		;
////		auth.userDetailsService(customeUserDetailsService);
//
//	}
//
//	@Bean
//	public static NoOpPasswordEncoder passwordEncoder() {
//		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//	}
//
//}
