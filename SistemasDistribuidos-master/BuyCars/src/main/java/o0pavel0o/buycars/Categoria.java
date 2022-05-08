package o0pavel0o.buycars;

import javax.persistence.*;

@Entity
public class Categoria {

	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    private String tipoCategoria;
   
	 
    
	  //Constructor necesario para la carga de la BBDD
	    protected Categoria(){}


	public Categoria(String tipoCategoria) {
	
		this.tipoCategoria = tipoCategoria;
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTipoCategoria() {
		return tipoCategoria;
	}


	public void setTipoCategoria(String tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}


	
	
	@Override
	public String toString() {
		return "Categoria [tipoCategoria=" + tipoCategoria + "]";
	}   
	  
	
	    
}
