package net.javaguides.springboot.model;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "demandes")
public class Demande {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long demandeID;

	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;

	public Demande() {
		super();
	}

	public Demande(Long demandeID, Date date) {
		super();
		this.demandeID = demandeID;
		this.date = date;
	}

	public Long getDemandeID() {
		return demandeID;
	}

	public void setDemandeID(Long demandeID) {
		this.demandeID = demandeID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Demande [demandeID=" + demandeID + ", date=" + date + "]";
	}
	
	
}
