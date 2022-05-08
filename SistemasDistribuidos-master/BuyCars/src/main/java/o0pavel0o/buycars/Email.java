package o0pavel0o.buycars;

public class Email {

	
	private String para;
	private String asunto;
	private String comentario;
	
	
	
	

	public Email() {
		
	}
	
	
	
	
	public Email(String cuenta, String asunto, String comentario) {

		this.para = cuenta;
		this.asunto = asunto;
		this.comentario = comentario;
	}
	
	
	
	
	public String getPara() {
		return para;
	}




	public void setPara(String para) {
		this.para = para;
	}




	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}




	
	
	
	
	
}
