package es.urjc.hotelo.configuration;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	/*@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// Public pages 
		// Ver hoteles, ver actividades, iniciar sesión
		http.authorizeRequests().antMatchers(
				"/", 
				"/principalHoteles", 
				"/principalActividades", 
				"/hotel/{id}", 
				"/actividad/{id}", 
				"/login", 
				"/loginerror" ).permitAll();

		
		// Private pages (all other pages) 
		// Añadir hoteles, añadir actividades, reservar, ver mis reservas, eliminar hoteles, eliminar actividades
		http.authorizeRequests().anyRequest().authenticated();
		
		// Login form
		http.formLogin().loginPage("/login");
		http.formLogin().usernameParameter("username");
		http.formLogin().passwordParameter("password");
		http.formLogin().defaultSuccessUrl("/");
		http.formLogin().failureUrl("/loginerror");
		
		// Logout
		http.logout().logoutUrl("/logout");
		http.logout().logoutSuccessUrl("/");
		
		// Disable CSRF at the moment
		http.csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// User
		
		auth.inMemoryAuthentication().withUser("user").password("{noop}pass").roles("USER");
		
		auth.inMemoryAuthentication().withUser("admin").password("{noop}adminpass").roles("USER", "ADMIN");

	}
	
	
	
}
