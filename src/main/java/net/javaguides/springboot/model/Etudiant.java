package net.javaguides.springboot.model;

//import java.util.ArrayList;
//import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "etudiants")
public class Etudiant {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long etudID;

  @Column//(length = 128, nullable = false)
  private String nom;

  @Column//(length = 256)
  private String prenom;

  @Column//(nullable = false)
  private String emailID;

  @Column
  private String niveau;
  
  @Column
  private String options;

  @Column
  private String competences;
  
  @Column
  private String adresses;
  
/*  @ManyToMany
  @JoinTable( name = "travailler",
  				joinColumns= @JoinColumn( name = "etudID" ),
  				inverseJoinColumns= @JoinColumn(name="entID") )
  private List<Entreprise> entreprises = new ArrayList<>();*/

public Etudiant() {
	super();
}

public Etudiant(Long etudID, String nom, String prenom, String emailID, String niveau, String options,
		String competences, String adresses) {
	super();
	this.etudID = etudID;
	this.nom = nom;
	this.prenom = prenom;
	this.emailID = emailID;
	this.niveau = niveau;
	this.options = options;
	this.competences = competences;
	this.adresses = adresses;
}

public Long getEtudID() {
	return etudID;
}

public void setEtudID(Long etudID) {
	this.etudID = etudID;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getEmailID() {
	return emailID;
}

public void setEmailID(String emailID) {
	this.emailID = emailID;
}

public String getNiveau() {
	return niveau;
}

public void setNiveau(String niveau) {
	this.niveau = niveau;
}

public String getOptions() {
	return options;
}

public void setOptions(String options) {
	this.options = options;
}

public String getCompetences() {
	return competences;
}

public void setCompetences(String competences) {
	this.competences = competences;
}

public String getAdresses() {
	return adresses;
}

public void setAdresses(String adresses) {
	this.adresses = adresses;
}


/*public List<Entreprise> getEntreprises() {
	return entreprises;
}

public void setEntreprises(List<Entreprise> entreprises) {
	this.entreprises = entreprises;
}*/

@Override
public String toString() {
	return "Etudiant [etudID=" + etudID + ", nom=" + nom + ", prenom=" + prenom + ", emailID=" + emailID + ", niveau="
			+ niveau + ", options=" + options + ", competences=" + competences + ", adresses=" + adresses + "]";
}
  

 

}
