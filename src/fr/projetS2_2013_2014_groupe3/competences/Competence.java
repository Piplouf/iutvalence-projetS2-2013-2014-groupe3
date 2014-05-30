package fr.projetS2_2013_2014_groupe3.competences;

import java.util.ArrayList;
import fr.projetS2_2013_2014_groupe3.jeu.Case;
import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.jeu.Perso;
import fr.projetS2_2013_2014_groupe3.jeu.Personnage;
import fr.projetS2_2013_2014_groupe3.jeu.PersonnageVide;
import fr.projetS2_2013_2014_groupe3.jeu.Position;

/**
 * Classe abstraite contenant toutes les méthodes nécessaire 
 * pour le développement d'autres compétences
 *
 */
public abstract class Competence {

	private String nom;

	private int puissance;

	private Partie partie;

	private int portee;

	private TypeAttaque type;
	
	private int coutEnergie;

	/** Le super constructeur de toutes les autres classes */
	public Competence(Partie partie, String nom, int puissance, int portee,
			TypeAttaque type, int cout) {
		this.partie = partie;
		this.nom = nom;
		this.puissance = puissance;
		this.portee = portee;
		this.type = type;
		this.coutEnergie = cout;
	}

	/** Méthode abstraite appellé lorsqu'on utiliser une compétence */
	public abstract boolean utiliserCompetence(Personnage lanceur,
			Position cible);

	/** Méthode abstraite utilisée pour obtenir la zone que l'attaque affectera*/
	public abstract ArrayList<Case> retournerZoneAffecterParAttaque(
			Personnage lanceur, Position cible);

	public int obtenirPuissance() {
		return this.puissance;
	}

	public void modifierPartie(Partie partie) {
		this.partie = partie;
	}

	public int obtenirPortee() {
		return this.portee;
	}

	public String toString() {
		return (this.nom);
	}

	public Partie obtenirPartie() {
		return this.partie;
	}
	
	public int obtenirCout(){
		return this.coutEnergie;
	}

	/** Permet de détermine la direction de la cible par rapport au lanceur*/
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

	/** Determine la premiere cible sur une ligne droite dans la direction donné*/
	public ArrayList<Case> determinerPremiereCibleSurPassage(
			Direction directionCompetence, Personnage lanceur) {

		int nombreCaseParcouru = 1;
		Perso perso = new PersonnageVide();
		ArrayList<Case> cases = new ArrayList<Case>();

		switch (directionCompetence) {

		case HAUT: {
			while (nombreCaseParcouru != (this.portee + 1)
					&& perso instanceof PersonnageVide
					&& (this.retournerPositionPersonnageEnX(lanceur) - nombreCaseParcouru) >= 0) {
				perso = this.partie.obtenirCarte().obtenirCarte()[this
						.retournerPositionPersonnageEnX(lanceur)
						- nombreCaseParcouru][this
						.retournerPositionPersonnageEnY(lanceur)].estOccupe();
				cases.add(this.partie.obtenirCarte().obtenirCarte()[this
						.retournerPositionPersonnageEnX(lanceur)
						- nombreCaseParcouru][this
						.retournerPositionPersonnageEnY(lanceur)]);
				if (this.nEstPasDansLaMemeEquipe(perso))
					return cases;
				perso = new PersonnageVide();
				nombreCaseParcouru++;
			}
			return cases;
		}
		case BAS: {
			while (nombreCaseParcouru != (this.portee + 1)
					&& perso instanceof PersonnageVide
					&& (this.retournerPositionPersonnageEnX(lanceur) + nombreCaseParcouru) < this.partie.obtenirCarte().obtenirTailleEnX()) {
				int x = this.retournerPositionPersonnageEnX(lanceur);
				int y = this.retournerPositionPersonnageEnY(lanceur);
				perso = this.partie
						.obtenirCarte()
						.obtenirCase(
								this.retournerPositionPersonnageEnX(lanceur)
										+ nombreCaseParcouru,
								this.retournerPositionPersonnageEnY(lanceur))
						.estOccupe();
				Case laCase = this.partie.obtenirCarte().obtenirCase(
						x + nombreCaseParcouru, y);
				cases.add(laCase);
				if (this.nEstPasDansLaMemeEquipe(perso))
					return cases;
				perso = new PersonnageVide();
				nombreCaseParcouru++;
			}
			return cases;
		}
		case DROITE: {
			while (nombreCaseParcouru != (this.portee + 1)
					&& perso instanceof PersonnageVide
					&& (this.retournerPositionPersonnageEnY(lanceur) + nombreCaseParcouru) < this.partie.obtenirCarte().obtenirTailleEnY()) {
				perso = this.partie.obtenirCarte().obtenirCarte()[this
						.retournerPositionPersonnageEnX(lanceur)][this
						.retournerPositionPersonnageEnY(lanceur)
						+ nombreCaseParcouru].estOccupe();
				cases.add(this.partie.obtenirCarte().obtenirCarte()[this
						.retournerPositionPersonnageEnX(lanceur)][this
						.retournerPositionPersonnageEnY(lanceur)
						+ nombreCaseParcouru]);
				if (this.nEstPasDansLaMemeEquipe(perso))
					return cases;
				perso = new PersonnageVide();
				nombreCaseParcouru++;
			}
			return cases;
		}
		case GAUCHE: {
			while (nombreCaseParcouru != (this.portee + 1)
					&& perso instanceof PersonnageVide
					&& (this.retournerPositionPersonnageEnY(lanceur) - nombreCaseParcouru) >= 0) {
				perso = this.partie.obtenirCarte().obtenirCarte()[this
						.retournerPositionPersonnageEnX(lanceur)][this
						.retournerPositionPersonnageEnY(lanceur)
						- nombreCaseParcouru].estOccupe();
				cases.add(this.partie.obtenirCarte().obtenirCarte()[this
						.retournerPositionPersonnageEnX(lanceur)][this
						.retournerPositionPersonnageEnY(lanceur)
						- nombreCaseParcouru]);
				if (this.nEstPasDansLaMemeEquipe(perso))
					return cases;
				perso = new PersonnageVide();
				nombreCaseParcouru++;
			}
			return cases;
		}
		default:
			return cases;
		}
	}

	/** Determine toutes les cases dans une ligne droite dans une direction donné */
	public ArrayList<Case> determinerPersonnageDansUneLigneDroite(
			Direction direction, Personnage lanceur) {

		ArrayList<Case> liste = new ArrayList<Case>();
		int nombreCaseParcouru = 1;

		switch (direction) {

		case HAUT: {
			while (nombreCaseParcouru != (this.portee + 1)
					&& (this.retournerPositionPersonnageEnX(lanceur) - nombreCaseParcouru) >= 0) {
				liste.add(this.partie.obtenirCarte().obtenirCarte()[this
						.retournerPositionPersonnageEnX(lanceur)
						- nombreCaseParcouru][this
						.retournerPositionPersonnageEnY(lanceur)]);
				nombreCaseParcouru++;
			}
			return liste;
		}
		case BAS: {
			while (nombreCaseParcouru != (this.portee + 1)
					&& (this.retournerPositionPersonnageEnX(lanceur) + nombreCaseParcouru) < this.partie
							.obtenirCarte().obtenirTailleEnX()) {
				liste.add(this.partie.obtenirCarte().obtenirCarte()[this
						.retournerPositionPersonnageEnX(lanceur)
						+ nombreCaseParcouru][this
						.retournerPositionPersonnageEnY(lanceur)]);
				nombreCaseParcouru++;
			}
			return liste;
		}
		case DROITE: {
			while (nombreCaseParcouru != (this.portee + 1)
					&& (this.retournerPositionPersonnageEnY(lanceur) + nombreCaseParcouru) < this.partie
							.obtenirCarte().obtenirTailleEnY()) {
				liste.add(this.partie.obtenirCarte().obtenirCarte()[this
						.retournerPositionPersonnageEnX(lanceur)][this
						.retournerPositionPersonnageEnY(lanceur)
						+ nombreCaseParcouru]);
				nombreCaseParcouru++;
			}
			return liste;
		}
		case GAUCHE: {
			while (nombreCaseParcouru != (this.portee + 1)
					&& (this.retournerPositionPersonnageEnY(lanceur) - nombreCaseParcouru) >= 0) {
				liste.add(this.partie.obtenirCarte().obtenirCarte()[this
						.retournerPositionPersonnageEnX(lanceur)][this
						.retournerPositionPersonnageEnY(lanceur)
						- nombreCaseParcouru]);
				nombreCaseParcouru++;
			}
			return liste;
		}
		default:
			return liste;
		}
	}

	/** Determine toutes les cases autour de la position cible dans un cercle de la portée indiquer*/
	public ArrayList<Case> determinerPersonnageDansUneZoneSpherique(
			Personnage lanceur, Position posDepart, int portee) {

		int calculDeplacement = 0;
		calculDeplacement = Math.abs(posDepart.obtenirX()
				- this.retournerPositionPersonnageEnX(lanceur));
		calculDeplacement += Math.abs(posDepart.obtenirY()
				- this.retournerPositionPersonnageEnY(lanceur));

		ArrayList<Case> liste = new ArrayList<Case>();
		int modifX = 0;
		int modifY = 0;
		int arretX = 0;

		if (this.portee + 1 >= calculDeplacement) {
			for (int j = -portee; j <= portee; j++) {
				int axeY = (posDepart.obtenirY() - portee + modifY);
				for (int axeX = (posDepart.obtenirX() - modifX); axeX <= (posDepart
						.obtenirX() + portee - arretX); axeX++) {
					if (!(axeX < 0
							|| axeX >= this.partie.obtenirCarte()
									.obtenirTailleEnX() || axeY < 0 || axeY >= this.partie
							.obtenirCarte().obtenirTailleEnY()))
						liste.add(this.partie.obtenirCarte().obtenirCarte()[axeX][axeY]);
					axeY++;
				}
				int parite = j % 2;
				if (parite == 0) {
					modifY++;
					arretX++;
				} else {
					modifX++;
				}
			}
		}
		return liste;
	}

	/** Détermine les cases qui forme un cone de la portée indiquer et dans la direction indiquer*/
	public ArrayList<Case> determinerPersonnageDansUnCone(Direction direction,
			Personnage lanceur) {

		ArrayList<Case> liste = new ArrayList<Case>();
		int depart, arrivee;

		switch (direction) {

		case HAUT: {
			depart = this.retournerPositionPersonnageEnY(lanceur);
			arrivee = this.retournerPositionPersonnageEnY(lanceur);
			int x = this.retournerPositionPersonnageEnX(lanceur) - 1;

			for (int nombreCaseParcouru = 1; nombreCaseParcouru < (this.portee + 1); nombreCaseParcouru++) {
				for (int yDep = depart; yDep <= arrivee; yDep++) {
					if (x >= 0 && yDep >= 0 && yDep < this.partie.obtenirCarte().obtenirTailleEnY())
						liste.add(this.partie.obtenirCarte().obtenirCarte()[x][yDep]);
				}
				depart--;
				arrivee++;
				x--;
			}
			return liste;
		}
		case BAS: {
			depart = this.retournerPositionPersonnageEnY(lanceur);
			arrivee = this.retournerPositionPersonnageEnY(lanceur);
			int x = this.retournerPositionPersonnageEnX(lanceur) + 1;

			for (int nombreCaseParcouru = 1; nombreCaseParcouru < (this.portee + 1); nombreCaseParcouru++) {
				for (int yDep = depart; yDep <= arrivee; yDep++) {
					if (x < this.partie.obtenirCarte().obtenirTailleEnX() && yDep >= 0 && yDep < this.partie.obtenirCarte().obtenirTailleEnY())
						liste.add(this.partie.obtenirCarte().obtenirCarte()[x][yDep]);
				}
				depart--;
				arrivee++;
				x++;
			}
			return liste;
		}
		case DROITE: {
			depart = this.retournerPositionPersonnageEnX(lanceur);
			arrivee = this.retournerPositionPersonnageEnX(lanceur);
			int y = this.retournerPositionPersonnageEnY(lanceur) + 1;

			for (int nombreCaseParcouru = 1; nombreCaseParcouru < (this.portee + 1); nombreCaseParcouru++) {
				for (int xDep = depart; xDep <= arrivee; xDep++) {
					if (y < this.partie.obtenirCarte().obtenirTailleEnY() && xDep >= 0 && xDep < this.partie.obtenirCarte().obtenirTailleEnX())
						liste.add(this.partie.obtenirCarte().obtenirCarte()[xDep][y]);
				}
				depart--;
				arrivee++;
				y++;
			}
			return liste;
		}
		case GAUCHE: {
			depart = this.retournerPositionPersonnageEnX(lanceur);
			arrivee = this.retournerPositionPersonnageEnX(lanceur);
			int y = this.retournerPositionPersonnageEnY(lanceur) - 1;

			for (int nombreCaseParcouru = 1; nombreCaseParcouru < (this.portee + 1); nombreCaseParcouru++) {
				for (int xDep = depart; xDep <= arrivee; xDep++) {
					if (y >= 0 && xDep >= 0 && xDep < this.partie.obtenirCarte().obtenirTailleEnX())
						liste.add(this.partie.obtenirCarte().obtenirCarte()[xDep][y]);
				}
				depart--;
				arrivee++;
				y--;
			}
			return liste;
		}
		default:
			return liste;
		}

	}

	/** Renvoi tous les personnages trouvés dans la zone passer en parametre */
	public ArrayList<Personnage> obtenirPersonnageDansLaZoneTrouvee(
			ArrayList<Case> cases) {

		ArrayList<Personnage> persos = new ArrayList<Personnage>();
		for (Case laCase : cases) {
			if (laCase.estOccupe() instanceof Personnage
					&& this.nEstPasDansLaMemeEquipe(laCase.estOccupe()))
				persos.add((Personnage) laCase.estOccupe());
		}

		return persos;
	}

	/** Vérifie si l'attaque est de type offensive que les persos ne sont pas dans la meme equipe
	 * sinon s'ils sont dans la meme equipe
	 * @param perso
	 * @return
	 */
	public boolean nEstPasDansLaMemeEquipe(Perso perso) {
		if (this.type == TypeAttaque.OFFENSIVE)
			return (perso instanceof Personnage && !(((Personnage) perso)
					.obtenirNumeroDAppartenanceJoueur() == this.partie
					.obtenirNumJoueur()));
		else
			return (perso instanceof Personnage && (((Personnage) perso)
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
