package o0pavel0o.buycars;
import o0pavel0o.buycars.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import o0pavel0o.buycars.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Anuncio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id = -1;

	private String nombre;
	private String asunto;
	private Double precio;
	
	@OneToOne
	private Usuario usuario;
	
	@OneToOne
	private Coche coche;

	
	
	public Anuncio() {}

	public Anuncio(String nombre, String asunto, Double precio) {
		super();
		this.nombre = nombre;
		this.asunto = asunto;
		this.precio = precio;
		
		this.usuario = new Usuario();
		this.coche = new Coche();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	
	public Coche getCoche() {
		return coche;
	}

	public void setCoche(Coche coche) {
		this.coche = coche;
	}

	@Override
	public String toString() {
		return "Anuncio [nombre=" + nombre + ", asunto=" + asunto + ", precio=" + precio + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}