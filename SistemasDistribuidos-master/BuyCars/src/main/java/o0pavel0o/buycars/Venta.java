package o0pavel0o.buycars;

import o0pavel0o.buycars.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Venta {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    
    private String fechaVenta;
    private Double precio;
    

    @OneToOne
    private Usuario usuario;
    
    
    @OneToOne
    private Coche coche;
    
    /**
     * Constructores
     */
    protected Venta(){}



	public Venta(String fechaVenta, Double precio) {
		
		this.fechaVenta = fechaVenta;
		this.precio = precio;
		this.usuario = new Usuario();
		this.coche = new Coche();
	}



	public Coche getCoche() {
		return coche;
	}



	public void setCoche(Coche coche) {
		this.coche = coche;
	}



	public String getFechaVenta() {
		return fechaVenta;
	}



	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
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


	
	

    
    
}
