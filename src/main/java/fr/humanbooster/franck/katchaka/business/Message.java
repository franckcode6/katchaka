package fr.humanbooster.franck.katchaka.business;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String contenu;

	private Date dateEnvoi;

	private Date dateLecture;

	@ManyToOne()
	private VieCommune vieCommune;

	@ManyToOne
	private Personne expediteur;

	@ManyToOne
	private Personne destinataire;
}
