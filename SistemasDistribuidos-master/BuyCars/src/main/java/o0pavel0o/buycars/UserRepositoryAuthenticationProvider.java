package o0pavel0o.buycars;
import o0pavel0o.buycars.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@ComponentScan
@Component
public class UserRepositoryAuthenticationProvider implements AuthenticationProvider {
	

    @Autowired
	private UsuarioRepository userRepository;
	
    
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
	Usuario user = userRepository.findByEmail(auth.getName());
	
	//Comprobamos si el usuario existe
	if (user == null) {
		throw new BadCredentialsException("Usuario no encontrado");
	}
		
		
	
	//Comprobamos si el password es correcto
	String password = (String) auth.getCredentials();
	    //Comparo las dos password, la almacenada y la escrita
		if (!new BCryptPasswordEncoder().matches(password, user.getPassword())) {
		throw new BadCredentialsException("Usuario o password incorrecto");
		}
		
		
		//recorremos las lista para buscar todos los roles que tiene el usuario
		List<GrantedAuthority> roles = new ArrayList<>();
			for (String role : user.getRoles()) {
			roles.add(new SimpleGrantedAuthority(role));
			}

			
	return new UsernamePasswordAuthenticationToken(user.getNombre(), password, roles);
}


	@Override
	public boolean supports(Class<?> authenticationObject) {
		return true;
	}



}