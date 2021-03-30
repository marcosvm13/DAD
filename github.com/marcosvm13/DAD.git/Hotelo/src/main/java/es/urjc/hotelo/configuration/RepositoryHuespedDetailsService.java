package es.urjc.hotelo.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import es.urjc.hotelo.entity.Huesped;
import es.urjc.hotelo.repository.HuespedRepository;



@Service
public class RepositoryHuespedDetailsService implements UserDetailsService {

	@Autowired
	private HuespedRepository userRepository;
		
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Huesped user = userRepository.findByNombreHuesped(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));

		List<GrantedAuthority> roles = new ArrayList<>();
		for (String role : user.getRoles()) {
			roles.add(new SimpleGrantedAuthority("ROLE_" + role));
		}

		return new org.springframework.security.core.userdetails.User(user.getNombreHuesped(), 
				user.getHashContraseya(), roles);

	}
	
	
}