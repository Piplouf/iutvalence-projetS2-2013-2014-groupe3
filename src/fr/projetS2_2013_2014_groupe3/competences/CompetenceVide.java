package fr.projetS2_2013_2014_groupe3.competences;

import java.util.ArrayList;

import fr.projetS2_2013_2014_groupe3.jeu.Case;
import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.jeu.Personnage;
import fr.projetS2_2013_2014_groupe3.jeu.Position;

public class CompetenceVide extends Competence {

	public CompetenceVide(Partie partie) {
		super(partie, "Vide", 0, 0, TypeAttaque.OFFENSIVE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean utiliserCompetence(Personnage lanceur, Position cible) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Case> retournerZoneAffecterParAttaque(Personnage lanceur,
			Position cible) {
		// TODO Auto-generated method stub
		return null;
	}

}
