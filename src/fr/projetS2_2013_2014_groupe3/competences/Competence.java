package fr.projetS2_2013_2014_groupe3.competences;

import java.util.ArrayList;
import java.util.Iterator;

import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.jeu.Perso;
import fr.projetS2_2013_2014_groupe3.jeu.Personnage;
import fr.projetS2_2013_2014_groupe3.jeu.PersonnageVide;
import fr.projetS2_2013_2014_groupe3.jeu.Position;

public abstract class Competence {

	private String nom;

	private int puissance;

	private Partie partie;

	private int portee;
	
	private TypeAttaque type;

	public Competence(Partie partie, String nom, int puissance, int portee, TypeAttaque type) {
		this.partie = partie;
		this.nom = nom;
		this.puissance = puissance;
		this.portee = portee;
		this.type = type;
	}

	public abstract boolean utiliserCompetence(Personnage lanceur,
			Position cible);

	public int obtenirPuissance() {
		return this.puissance;
	}

	public void modifierPartie(Partie partie) {
		this.partie = partie;
	}
	
	public int obtenirPortee(){
		return this.portee;
	}

	public String toString() {
		return (this.nom);
	}

	public Partie obtenirPartie() {
		return this.partie;
	}

	public Direction determinerDirectionCible(Personnage lanceur, Position cible) {

		Position posPersonnage = this.partie.obtenirCarte()
				.obtenirPositionPersonnage(lanceur);
		Position posCible = cible;

		if (posPersonnage.obtenirX() - posCible.obtenirX() != 0
				&& posPersonnage.obtenirY() - posCible.obtenirY() != 0)
			return Direction.NULLE;
		if (posPersonnage.obtenirX() - posCible.obtenirX() > 0
				&& posPersonnage.obtenirY() - posCible.obtenirY() == 0)
			return Direction.HAUT;
		if (posPersonnage.obtenirX() - posCible.obtenirX() < 0
				&& posPersonnage.obtenirY() - posCible.obtenirY() == 0)
			return Direction.BAS;
		if (posPersonnage.obtenirX() - posCible.obtenirX() == 0
				&& posPersonnage.obtenirY() - posCible.obtenirY() < 0)
			return Direction.DROITE;
		if (posPersonnage.obtenirX() - posCible.obtenirX() == 0
				&& posPersonnage.obtenirY() - posCible.obtenirY() > 0)
			return Direction.GAUCHE;

		return Direction.NULLE;
	}

	public Perso determinerPremiereCibleSurPassage(
			Direction directionCompetence, Personnage lanceur) {

		int nombreCaseParcouru = 1;
		Perso perso = new PersonnageVide();

		switch (directionCompetence) {

		case HAUT: {
			while (nombreCaseParcouru != (this.portee + 1)
					&& perso instanceof PersonnageVide && (this.retournerPositionPersonnageEnX(lanceur) - nombreCaseParcouru) > 0) {
				perso = this.partie.obtenirCarte().obtenirCarte()[this
						.retournerPositionPersonnageEnX(lanceur)
						- nombreCaseParcouru][this
						.retournerPositionPersonnageEnY(lanceur)].estOccupe();
				if (this.nEstPasDansLaMemeEquipe(perso))
					perso = new PersonnageVide();
				nombreCaseParcouru++;
			}
			return perso;
		}
		case BAS: {
			while (nombreCaseParcouru != (this.portee + 1)
					&& perso instanceof PersonnageVide && (this.retournerPositionPersonnageEnX(lanceur) + nombreCaseParcouru) < 8) {
				perso = this.partie.obtenirCarte().obtenirCarte()[this
						.retournerPositionPersonnageEnX(lanceur)
						+ nombreCaseParcouru][this
						.retournerPositionPersonnageEnY(lanceur)].estOccupe();
				if (this.nEstPasDansLaMemeEquipe(perso))
					perso = new PersonnageVide();
				nombreCaseParcouru++;
			}
			return perso;
		}
		case DROITE: {
			while (nombreCaseParcouru != (this.portee + 1)
					&& perso instanceof PersonnageVide && (this.retournerPositionPersonnageEnY(lanceur) + nombreCaseParcouru) < 8) {
				perso = this.partie.obtenirCarte().obtenirCarte()[this
						.retournerPositionPersonnageEnX(lanceur)][this
						.retournerPositionPersonnageEnY(lanceur)
						+ nombreCaseParcouru].estOccupe();
				if (this.nEstPasDansLaMemeEquipe(perso))
					perso = new PersonnageVide();
				nombreCaseParcouru++;
			}
			return perso;
		}
		case GAUCHE: {
			while (nombreCaseParcouru != (this.portee + 1)
					&& perso instanceof PersonnageVide && (this.retournerPositionPersonnageEnY(lanceur) - nombreCaseParcouru) > 0) {
				perso = this.partie.obtenirCarte().obtenirCarte()[this
						.retournerPositionPersonnageEnX(lanceur)][this
						.retournerPositionPersonnageEnY(lanceur)
						- nombreCaseParcouru].estOccupe();
				if (this.nEstPasDansLaMemeEquipe(perso))
					perso = new PersonnageVide();
				nombreCaseParcouru++;
			}
			return perso;
		}
		default:
			return new PersonnageVide();
		}
	}
	
	public ArrayList<Personnage> determinerPersonnageDansUneLigneDroite(Direction direction, Personnage lanceur){
		
		ArrayList<Personnage> liste = new ArrayList<Personnage>();
		int nombreCaseParcouru = 1;
		
		Perso perso = new PersonnageVide();
		
		switch (direction) {

		case HAUT: {
			while (nombreCaseParcouru != (this.portee + 1)
					&& (this.retournerPositionPersonnageEnX(lanceur) - nombreCaseParcouru) > 0) {
				perso = this.partie.obtenirCarte().obtenirCarte()[this
						.retournerPositionPersonnageEnX(lanceur)
						- nombreCaseParcouru][this
						.retournerPositionPersonnageEnY(lanceur)].estOccupe();
				if (this.nEstPasDansLaMemeEquipe(perso))
					liste.add((Personnage) perso);
				nombreCaseParcouru++;
			}
			return liste;
		}
		case BAS: {
			while (nombreCaseParcouru != (this.portee + 1)
					&& (this.retournerPositionPersonnageEnX(lanceur) + nombreCaseParcouru) < 8) {
				perso = this.partie.obtenirCarte().obtenirCarte()[this
						.retournerPositionPersonnageEnX(lanceur)
						+ nombreCaseParcouru][this
						.retournerPositionPersonnageEnY(lanceur)].estOccupe();
				if (this.nEstPasDansLaMemeEquipe(perso))
					liste.add((Personnage) perso);
				nombreCaseParcouru++;
			}
			return liste;
		}
		case DROITE: {
			while (nombreCaseParcouru != (this.portee + 1)
					&& (this.retournerPositionPersonnageEnY(lanceur) + nombreCaseParcouru) < 8) {
				perso = this.partie.obtenirCarte().obtenirCarte()[this
						.retournerPositionPersonnageEnX(lanceur)][this
						.retournerPositionPersonnageEnY(lanceur)
						+ nombreCaseParcouru].estOccupe();
				if (this.nEstPasDansLaMemeEquipe(perso))
					liste.add((Personnage) perso);
				nombreCaseParcouru++;
			}
			return liste;
		}
		case GAUCHE: {
			while (nombreCaseParcouru != (this.portee + 1)
					&& (this.retournerPositionPersonnageEnY(lanceur) - nombreCaseParcouru) > 0) {
				perso = this.partie.obtenirCarte().obtenirCarte()[this
						.retournerPositionPersonnageEnX(lanceur)][this
						.retournerPositionPersonnageEnY(lanceur)
						- nombreCaseParcouru].estOccupe();
				if (this.nEstPasDansLaMemeEquipe(perso))
					liste.add((Personnage) perso);
				nombreCaseParcouru++;
			}
			return liste;
		}
		default:
			return liste;
		}
	}

	
	public ArrayList<Personnage> determinerPersonnageDansUneZoneSpherique(int portee, Position posDepart){
		
		ArrayList<Personnage> liste = new ArrayList<Personnage>();
		Perso perso = new PersonnageVide();
		int modifX = 0;
		int modifY = 0;
		int arretX = 0;
		
		for(int j = -this.portee; j <= this.portee; j++){
			int axeY = (posDepart.obtenirY() - this.portee + modifY);
			for(int axeX = (posDepart.obtenirX() - modifX); axeX <= (posDepart.obtenirX() + this.portee  - arretX); axeX++){
					if(axeX <= 0 || axeX >= 8 || axeY <= 0 || axeY >= 8)
						;
					else{
					perso = this.partie.obtenirCarte().obtenirCarte()[axeX][axeY].estOccupe();
					if(this.nEstPasDansLaMemeEquipe(perso))
						liste.add((Personnage) perso);
					}
					axeY++;
				}
				int parite = j%2;
				if(parite == 0){
					modifY++;
					arretX++;
				}
				else{
					modifX++;
				}
			}
		return liste;
	}
	
	public boolean nEstPasDansLaMemeEquipe(Perso perso){
		if(this.type == TypeAttaque.OFFENSIVE)
		return (perso instanceof Personnage
		&& !(((Personnage) perso)
				.obtenirNumeroDAppartenanceJoueur() == this.partie
				.obtenirNumJoueur()));
		else
			return (perso instanceof Personnage
					&& (((Personnage) perso)
							.obtenirNumeroDAppartenanceJoueur() == this.partie
							.obtenirNumJoueur()));
	}
	
	public int retournerPositionPersonnageEnX(Personnage perso) {
		return this.partie.obtenirCarte().obtenirPositionPersonnage(perso)
				.obtenirX();
	}

	public int retournerPositionPersonnageEnY(Personnage perso) {
		return this.partie.obtenirCarte().obtenirPositionPersonnage(perso)
				.obtenirY();
	}

}
