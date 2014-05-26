package fr.projetS2_2013_2014_groupe3.competences;

import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.jeu.Perso;
import fr.projetS2_2013_2014_groupe3.jeu.Personnage;
import fr.projetS2_2013_2014_groupe3.jeu.Position;


public class BouleDeFeu extends Competence {
	
	
	
	public BouleDeFeu(){
		super(new Partie(),"Boule de feu", 20,3, TypeAttaque.OFFENSIVE);
	}
	
	public BouleDeFeu(Partie partie){
		super(partie, "Boule de feu", 20,3, TypeAttaque.OFFENSIVE);
	}

	@Override
	public boolean utiliserCompetence(Personnage lanceur, Position cible) {
		
		Direction directionCompetence = this.determinerDirectionCible(lanceur, cible);
		Perso laCible = this.determinerPremiereCibleSurPassage(directionCompetence, lanceur);
		
		if(directionCompetence != Direction.NULLE && laCible instanceof Personnage){
			((Personnage) laCible).enleverVie(this.obtenirPuissance());
			return true;
		}
		
		return false;
	}

	  
	
}
