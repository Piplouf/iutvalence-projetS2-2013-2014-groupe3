package fr.projetS2_2013_2014_groupe3.jeuEnCours;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import fr.projetS2_2013_2014_groupe3.competences.Competence;
import fr.projetS2_2013_2014_groupe3.competences.CompetenceVide;
import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.jeu.Personnage;
import fr.projetS2_2013_2014_groupe3.jeu.Position;
import fr.projetS2_2013_2014_groupe3.menu.principal.Fenetre;

public class MenuAttaque extends JPanel implements KeyListener {

	private Personnage perso;

	private Fenetre fen;

	private InterfacePartie ecran;

	private Partie partie;

	private static Competence competencesVoulantEtreLancer;

	public MenuAttaque(Fenetre fen, Partie partie, InterfacePartie ecran,
			Personnage perso) {

		this.perso = perso;
		this.fen = fen;
		this.partie = partie;
		this.ecran = ecran;
		MenuAttaque.competencesVoulantEtreLancer = new CompetenceVide(this.partie);

		InitGUI();
		this.addKeyListener(this);
	}

	public void InitGUI() {

		GridLayout grille = new GridLayout(2, 2);
		grille.setHgap(5);
		grille.setVgap(5);

		this.setLayout(grille);

		for (Competence compe : this.perso.obtenirCompetences()) {
			compe.modifierPartie(this.partie);
			this.add(new JPanel().add(new BoutonCompetence(this.fen,
					this.partie, this, this.perso, compe)));
		}
	}

	public void rendreLesCompetencesDiponibles() {

		for (Component compo : this.getComponents()) {
			compo.setEnabled(true);
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

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent event) {
		char touchePressee = event.getKeyChar();
		this.ecran.modifierMenuAttaqueEnMenuJoueur();

	}

}
