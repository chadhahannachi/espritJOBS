package net.javaguides.springboot.model;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "offres")
public class Offre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long offreID;

	@Column
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date ddv;
	
	@Column
	private String apropos;

	public Offre() {
		super();
	}

	

	public Offre(Long offreID, Date ddv, String apropos) {
		super();
		this.offreID = offreID;
		this.ddv = ddv;
		this.apropos = apropos;
	}



	public Long getOffreID() {
		return offreID;
	}

	public void setOffreID(Long offreID) {
		this.offreID = offreID;
	}

	public Date getDdv() {
		return ddv;
	}

	public void setDdv(Date ddv) {
		this.ddv = ddv;
	}
	
	

	public String getApropos() {
		return apropos;
	}



	public void setApropos(String apropos) {
		this.apropos = apropos;
	}


	@Override
	public String toString() {
		return "Offre [offreID=" + offreID + ", ddv=" + ddv + ", apropos=" + apropos + "]";
	}


	

	
	
}
