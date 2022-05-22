package fr.humanbooster.franck.katchaka.business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nom;

	@OneToMany(mappedBy = "genre")
	private List<Personne> personnes;

	@OneToMany(mappedBy = "genreRecherche")
	private List<Personne> personnesRecherchant;
	
	public Genre(String nom) {
		this();
		this.nom = nom;
	}
}
