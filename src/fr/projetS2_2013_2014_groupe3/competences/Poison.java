package fr.projetS2_2013_2014_groupe3.competences;

import java.util.ArrayList;

import fr.projetS2_2013_2014_groupe3.jeu.Case;
import fr.projetS2_2013_2014_groupe3.jeu.Etat;
import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.jeu.Personnage;
import fr.projetS2_2013_2014_groupe3.jeu.Position;

/** Attaque en ligne qui empoisonne*/
public class Poison extends Competence {
	
	private int duree;
	
	
	public Poison(Partie partie){
		super(partie,"Poison",5,3,TypeAttaque.OFFENSIVE,10);
		this.duree = 3;
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
			for (Personnage perso : laCible){
				perso.modifierEtat(Etat.EMPOISONNE);;
				perso.modifierNombreDeTourEtat(this.duree);
			}
			return true;
		}

		return false;
	}

	@Override
	public ArrayList<Case> retournerZoneAffecterParAttaque(Personnage lanceur,
			Position cible) {
		// TODO Auto-generated method stub
		return this.determinerPremiereCibleSurPassage(
				this.determinerDirectionCible(lanceur, cible), lanceur);
	}

}
