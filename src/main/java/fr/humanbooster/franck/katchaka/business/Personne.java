package fr.humanbooster.franck.katchaka.business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@ToString
public class Personne {

	private static final int NB_CREDITS_INITIAL = 500;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	//@Pattern(regexp = "^([a-zA-Z0-9]*)", message = "Votre pseudo ne doit contenir que des lettres minuscules, majuscules ou des chiffres.")
	private String pseudo;

	@NotBlank
	@Size(min = 5, message = "Le mot de passe doit contenir au moins 5 caractères")
	private String motDePasse;

	@NotNull(message = "Merci de renseigner une adresse mail")
	//@Email
	private String email;

	@Past
	private LocalDate dateDeNaissance;

	@Size(min = 20, message = "La bio doit faire au moins 20 caractères")
	@Lob
	private String bio;

	private int nbCredits;

	private boolean estFumeur;

	@OneToMany(mappedBy = "expediteur")
	private List<Message> messagesRecus;

	@OneToMany(mappedBy = "destinataire")
	private List<Message> messagesEnvoyes;

	@OneToOne
	private Invitation destinatire;

	@OneToOne
	private Invitation expediteur;

	@ManyToOne
	@NotNull(message = "Merci de renseigner votre ville")
	private Ville ville;

	@ManyToMany
	@NotNull(message = "Merci de choisir au moins un intéret")
	private List<Interet> interets;

	@ManyToOne
	@NotNull(message = "Merci de renseigner un statut")
	private Statut statut;

	@ManyToOne
	@NotNull(message = "Merci de renseigner un genre")
	private Genre genre;

	@ManyToOne
	@NotNull(message = "Merci de renseigner le genre recherché")
	private Genre genreRecherche;

	public Personne() {
		this.interets = new ArrayList<>();
		this.nbCredits = NB_CREDITS_INITIAL;
	}

	public Personne(String pseudo, String email, String motDePasse, String bio, LocalDate dateDeNaissance,
			boolean fumeur, Ville ville, Genre genre, Genre genreRecherche, Statut statut, List<Interet>  interets) {
		this();
		this.pseudo = pseudo;
		this.email = email;
		this.motDePasse = motDePasse;
		this.bio = bio;
		this.dateDeNaissance = dateDeNaissance;
		this.estFumeur = fumeur;
		this.ville = ville;
		this.genre = genre;
		this.genreRecherche = genreRecherche;
		this.statut = statut;
		this.interets = interets;
	}
}
