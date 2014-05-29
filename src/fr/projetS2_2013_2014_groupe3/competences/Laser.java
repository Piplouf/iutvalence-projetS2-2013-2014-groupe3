package fr.projetS2_2013_2014_groupe3.competences;

import java.util.ArrayList;

import fr.projetS2_2013_2014_groupe3.jeu.Case;
import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.jeu.Personnage;
import fr.projetS2_2013_2014_groupe3.jeu.Position;

public class Laser extends Competence {

	
	public Laser(Partie partie){
		super(partie,"Laser",15,5, TypeAttaque.OFFENSIVE);
	}
	@Override
	public boolean utiliserCompetence(Personnage lanceur, Position cible) {
		
		ArrayList<Personnage> persos = new ArrayList<Personnage>();
		persos = this.obtenirPersonnageDansLaZoneTrouvee(this.determinerPersonnageDansUneLigneDroite(this.determinerDirectionCible(lanceur, cible), lanceur));
		
		if(this.determinerDirectionCible(lanceur, cible) != Direction.NULLE){
			for(Personnage perso : persos)
				perso.enleverVie(this.obtenirPuissance());
		return true;
		}
		return false;
	}
	@Override
	public ArrayList<Case> retournerZoneAffecterParAttaque(Personnage lanceur,
			Position cible) {
		// TODO Auto-generated method stub
		return this.determinerPersonnageDansUneLigneDroite(this.determinerDirectionCible(lanceur, cible), lanceur);
	}

}
