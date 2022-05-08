package o0pavel0o.AnunciosRest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AnunciosRest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id = -1;
	private String title;
	
	@Column(length = 50000)
	private String description;

	public AnunciosRest() {}

	public AnunciosRest(String nombre, String description) {
		super();
		this.title = nombre;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "AnunciosRest [id=" + id + ", title=" + title + ", description=" + description + "]";
	}

}
