package o0pavel0o.buycars;

import o0pavel0o.buycars.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Compra {
	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long id;
	    
	    
	    private String fechaCompra;
	    private Double precio_compra;
	   
	    @OneToOne
	    private Usuario vendedor;
	    
	    @OneToOne
	    private Usuario comprador;
	    
	    @OneToOne
	    private Coche coche;
	    
	    
	    /**
	     * Constructores
	     */
	    
	    protected Compra(){}



	    
	    
		public Compra(String fechaCompra, Double precio) {
			
			this.fechaCompra = fechaCompra;
		    this.precio_compra = precio;
		    this.vendedor= new Usuario();
		    this.comprador = new Usuario();
		    this.coche = new Coche();
		}


        /**
         * Getters and Setters
         * 
         */


		public String getFechaCompra() {
			return fechaCompra;
		}



		public void setFechaCompra(String fechaCompra) {
			this.fechaCompra = fechaCompra;
		}





		public Double getPrecio_compra() {
			return precio_compra;
		}





		public void setPrecio_compra(Double precio_compra) {
			this.precio_compra = precio_compra;
		}





		public Usuario getVendedor() {
			return vendedor;
		}





		public void setVendedor(Usuario vendedor) {
			this.vendedor = vendedor;
		}





		public Usuario getComprador() {
			return comprador;
		}





		public void setComprador(Usuario comprador) {
			this.comprador = comprador;
		}





		public Coche getCoche() {
			return coche;
		}





		public void setCoche(Coche coche) {
			this.coche = coche;
		}





	    
	    

}

