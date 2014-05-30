package fr.projetS2_2013_2014_groupe3.competences;

import java.util.ArrayList;

import fr.projetS2_2013_2014_groupe3.jeu.Case;
import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.jeu.Personnage;
import fr.projetS2_2013_2014_groupe3.jeu.Position;

/** Attaque de base en ligne droite infligeant 20 points de degats */
public class BouleDeFeu extends Competence {

	public BouleDeFeu() {
		super(new Partie(), "Boule de feu", 20, 3, TypeAttaque.OFFENSIVE,0);
	}

	public BouleDeFeu(Partie partie) {
		super(partie, "Boule de feu", 20, 3, TypeAttaque.OFFENSIVE,0);
	}

	@Override
	public boolean utiliserCompetence(Personnage lanceur, Position cible) {

		Direction directionCompetence = this.determinerDirectionCible(lanceur,
				cible);
		ArrayList<Personnage> laCible = this
				.obtenirPersonnageDansLaZoneTrouvee(this
						.determinerPremiereCibleSurPassage(directionCompetence,
								lanceur));

		if (!(laCible.size() == 0)) {
			for (Personnage perso : laCible)
				perso.enleverVie(this.obtenirPuissance());
			return true;
		}

		return false;
	}

	@Override
	public ArrayList<Case> retournerZoneAffecterParAttaque(Personnage lanceur,
			Position cible) {
		return this.determinerPremiereCibleSurPassage(
				this.determinerDirectionCible(lanceur, cible), lanceur);
	}
}
