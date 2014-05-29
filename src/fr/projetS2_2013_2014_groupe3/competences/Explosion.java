package fr.projetS2_2013_2014_groupe3.competences;

import java.util.ArrayList;
import java.util.Iterator;

import fr.projetS2_2013_2014_groupe3.jeu.Case;
import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.jeu.Perso;
import fr.projetS2_2013_2014_groupe3.jeu.Personnage;
import fr.projetS2_2013_2014_groupe3.jeu.Position;

public class Explosion extends Competence {

	public Explosion(Partie partie) {
		super(partie,"Explosion",15,2,TypeAttaque.OFFENSIVE);
	}

	@Override
	public boolean utiliserCompetence(Personnage lanceur, Position cible) {
		
		ArrayList<Personnage> listePersos = this
				.obtenirPersonnageDansLaZoneTrouvee(this
						.determinerPersonnageDansUneZoneSpherique(lanceur,
								cible, 4));

		for (Personnage perso : listePersos)
			perso.rajouterVie(this.obtenirPuissance());

		return false;
	}

	@Override
	public ArrayList<Case> retournerZoneAffecterParAttaque(Personnage lanceur,
			Position cible) {
		// TODO Auto-generated method stub
		return this
				.determinerPersonnageDansUneZoneSpherique(lanceur,
						cible, 4);
	}

}
