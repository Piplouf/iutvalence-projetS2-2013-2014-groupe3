package fr.projetS2_2013_2014_groupe3.competences;

import java.util.ArrayList;

import fr.projetS2_2013_2014_groupe3.jeu.Case;
import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.jeu.Personnage;
import fr.projetS2_2013_2014_groupe3.jeu.Position;

public class Embrasement extends Competence {
	
	
	public Embrasement(Partie partie){
		super(partie, "Embrasement", 15, 3, TypeAttaque.OFFENSIVE);
	}

	@Override
	public boolean utiliserCompetence(Personnage lanceur, Position cible) {
		
		Direction directionCompetence = this.determinerDirectionCible(lanceur,
				cible);
		ArrayList<Personnage> laCible = this
				.obtenirPersonnageDansLaZoneTrouvee(this
						.determinerPersonnageDansUnCone(directionCompetence,
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
		return this
				.determinerPersonnageDansUnCone(this.determinerDirectionCible(lanceur,
						cible),
						lanceur);
	}

}
