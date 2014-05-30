package fr.projetS2_2013_2014_groupe3.jeuEnCours;

import java.awt.GridLayout;
import javax.swing.JPanel;

import fr.projetS2_2013_2014_groupe3.competences.Competence;
import fr.projetS2_2013_2014_groupe3.competences.CompetenceVide;
import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.jeu.Personnage;

/** Menu d'attaque comportant les quatres techniques de chaque personnage*/
@SuppressWarnings("serial")
public class MenuAttaque extends JPanel {

	private Personnage perso;

	private InterfacePartie ecran;

	private Partie partie;

	private static Competence competencesVoulantEtreLancer;

	public MenuAttaque( Partie partie, InterfacePartie ecran,
			Personnage perso) {

		this.perso = perso;
		this.partie = partie;
		this.ecran = ecran;
		MenuAttaque.competencesVoulantEtreLancer = new CompetenceVide(this.partie);

		InitGUI();
	}

	/**  Initialise l'interface graphique*/
	public void InitGUI() {

		GridLayout grille = new GridLayout(2, 2);
		grille.setHgap(5);
		grille.setVgap(5);

		this.setLayout(grille);

		for (Competence compe : this.perso.obtenirCompetences()) {
			compe.modifierPartie(this.partie);
			this.add(new JPanel().add(new BoutonCompetence(this, compe)));
		}
	}

	public void modifierMenuAttaqueEnMenuJoueur() {
		this.ecran.modifierMenuAttaqueEnMenuJoueur();
	}

	public void refreshInterfacePartie() {
		this.ecran.refresh();
	}

	public void modifierEstEnModeAttaque() {
		this.ecran.estEnModeAttaque(false);

	}

	public void modifierCompetenceVoulantEtreLancer(Competence nouvelle) {
		MenuAttaque.competencesVoulantEtreLancer = nouvelle;
	}
	
	public Competence obtenirCompetenceVoulantEtreLancer(){
		return MenuAttaque.competencesVoulantEtreLancer;
	}

	public Personnage obtenirPerso(){
		return this.perso;
	}

}
