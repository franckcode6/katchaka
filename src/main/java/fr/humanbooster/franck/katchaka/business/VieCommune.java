package fr.humanbooster.franck.katchaka.business;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VieCommune {

	private static final int NB_CREDITS_PAR_DEFAUT = 500;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date dateDebut;

	private Date dateFin;

	private int nbCredits;

	@OneToMany(mappedBy = "vieCommune")
	private List<Message> messages;

	@OneToOne
	private Invitation invitation;

}
