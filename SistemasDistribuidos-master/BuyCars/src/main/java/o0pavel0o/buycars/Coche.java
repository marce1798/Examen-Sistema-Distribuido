package o0pavel0o.buycars;
import o0pavel0o.buycars.*;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "COCHE")
public class Coche {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	    
    private String matricula;
    private String marca;
    private String modelo;
    private String combustible;
    private String color;
    private String potencia;
    private double kilometros;
    private int plazas;
    private double precio;
    
    @OneToOne
    private Categoria categoria;
   // private List<String> equipamientoExtra;
    
    
  //Constructor necesario para la carga de la BBDD
    protected Coche(){}




	public Coche(String matricula, String marca, String modelo, String combustible, String color, String potencia,
			double kilometros, int plazas, double precio) {
		
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.combustible = combustible;
		this.color = color;
		this.potencia = potencia;
		this.kilometros = kilometros;
		this.plazas = plazas;
		this.precio = precio;
		this.categoria = new Categoria();
		
	}




	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getMatricula() {
		return matricula;
	}




	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}




	public String getMarca() {
		return marca;
	}




	public void setMarca(String marca) {
		this.marca = marca;
	}




	public String getModelo() {
		return modelo;
	}




	public void setModelo(String modelo) {
		this.modelo = modelo;
	}




	public String getCombustible() {
		return combustible;
	}




	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}




	public String getColor() {
		return color;
	}




	public void setColor(String color) {
		this.color = color;
	}




	public String getPotencia() {
		return potencia;
	}




	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}




	public Double getKilometros() {
		return kilometros;
	}




	public void setKilometros(float kilometros) {
		this.kilometros = kilometros;
	}




	public int getPlazas() {
		return plazas;
	}




	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}




	public Double getPrecio() {
		return precio;
	}




	public void setPrecio(double precio) {
		this.precio = precio;
	}




	public Categoria getCategoria() {
		return categoria;
	}




	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}




	public void setKilometros(double kilometros) {
		this.kilometros = kilometros;
	}


    
	

	/*public List<String> getEquipamientoExtra() {
		return equipamientoExtra;
	}




	public void setEquipamientoExtra(List<String> equipamientoExtra) {
		this.equipamientoExtra = equipamientoExtra;
	}*/





    

    
    
	
	
	
    
	
}

