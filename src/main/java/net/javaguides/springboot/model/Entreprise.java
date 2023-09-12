package net.javaguides.springboot.model;

//import java.util.ArrayList;
//import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "entreprises")
public class Entreprise {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long entID;
	
	@Column
	private String nom_en;
	
	@Column
	private String emailID_en;
	
	@Column
	private String num_tel_en;
	
	@Column
	private String adresse_en;
	
/*	 @ManyToMany
	  @JoinTable( name = "embaucher",
	  				joinColumns= @JoinColumn( name = "entID" ),
	  				inverseJoinColumns= @JoinColumn(name="etudID") )
	  private List<Etudiant> etudiants = new ArrayList<>();*/

	public Entreprise() {
		super();
	}

	public Entreprise(Long entID, String nom_en, String emailID_en, String num_tel_en, String adresse_en) {
		super();
		this.entID = entID;
		this.nom_en = nom_en;
		this.emailID_en = emailID_en;
		this.num_tel_en = num_tel_en;
		this.adresse_en = adresse_en;
	}

	public Long getEntID() {
		return entID;
	}

	public void setEntID(Long entID) {
		this.entID = entID;
	}

	public String getNom_en() {
		return nom_en;
	}

	public void setNom_en(String nom_en) {
		this.nom_en = nom_en;
	}

	public String getEmailID_en() {
		return emailID_en;
	}

	public void setEmailID_en(String emailID_en) {
		this.emailID_en = emailID_en;
	}

	public String getNum_tel_en() {
		return num_tel_en;
	}

	public void setNum_tel_en(String num_tel_en) {
		this.num_tel_en = num_tel_en;
	}

	public String getAdresse_en() {
		return adresse_en;
	}

	public void setAdresse_en(String adresse_en) {
		this.adresse_en = adresse_en;
	}
	

/*	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}*/

	@Override
	public String toString() {
		return "Entreprise [entID=" + entID + ", nom_en=" + nom_en + ", emailID_en=" + emailID_en + ", num_tel_en="
				+ num_tel_en + ", adresse_en=" + adresse_en + "]";
	}
	
	

}
