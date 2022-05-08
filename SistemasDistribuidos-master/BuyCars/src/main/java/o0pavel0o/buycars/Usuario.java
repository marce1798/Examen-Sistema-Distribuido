package o0pavel0o.buycars;
import o0pavel0o.buycars.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Entity
@Component
@SessionScope
public class Usuario {

	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
	private String nombre = "";
	private int numAnuncios;
	private String direccion;
    private String email;
    private String telefono;
	
    private String password;
    
	@ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;
    
   



	/**
	 * Constructores
	 */
	protected Usuario(){}
	
	
	


	public Usuario(String nombre, String direccion, String email, String telefono,
			String password, String... roles) {
		
		this.nombre = nombre;
		this.numAnuncios = 0;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.password = new BCryptPasswordEncoder().encode(password);
		this.roles = new ArrayList<>(Arrays.asList(roles));
	
	}



    /**
     * Getters and Setters
     * @return
     */

	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void incAnuncios() {
		this.numAnuncios++;
	}

	public int getNumAnuncios() {
		return numAnuncios;
	}

	public void setNumAnuncios(int numAnuncios) {
		this.numAnuncios = numAnuncios;
	}

	
	public void setPassword(String passwordHash) {
		this.password =  new BCryptPasswordEncoder().encode(passwordHash);;
	}


	 public String getPassword() {
			return password;
		}


	public List<String> getRoles() {
		return roles;
	}


	public void setRoles(List<String> roles) {
		this.roles = roles;
	}


    
	



	
	
	
	

}