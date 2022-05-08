package o0pavel0o.buycars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public UserRepositoryAuthenticationProvider authenticationProvider;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
    	// Public pages
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/loginerror").permitAll();
        http.authorizeRequests().antMatchers("/logout").permitAll();
        http.authorizeRequests().antMatchers("/anuncio/{id}").permitAll();
        http.authorizeRequests().antMatchers("/comprar/{id}").permitAll();
        http.authorizeRequests().antMatchers("/vender/{id}").permitAll();
        http.authorizeRequests().antMatchers("/nuevoUsuario").permitAll();
        http.authorizeRequests().antMatchers("/anuncios").permitAll();
        http.authorizeRequests().antMatchers("/anuncios/{id}").permitAll();
        http.authorizeRequests().antMatchers("/anuncios/").permitAll();
        http.authorizeRequests().antMatchers("/cache").permitAll();
        http.authorizeRequests().antMatchers("/email").permitAll();
        //http.authorizeRequests().antMatchers("/usuario/nuevo").permitAll();
       

        // Private pages (all other pages)
        http.authorizeRequests().antMatchers("/home").hasAnyRole("USER","ADMIN");
        
    	
    	
        // Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("username");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/home");
        http.formLogin().failureUrl("/loginerror");
        
        
        // Logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
    	auth.authenticationProvider(authenticationProvider);
   
    }

}
