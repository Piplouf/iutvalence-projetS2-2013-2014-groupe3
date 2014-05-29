package fr.projetS2_2013_2014_groupe3.jeuEnCours;

import java.awt.GridLayout;

import javax.swing.JPanel;

import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.menu.principal.Fenetre;

public class MenuJoueur extends JPanel {
	
	private Fenetre fenetre;
	
	private Partie partie;
	
	private InterfacePartie ecran;
	
	public MenuJoueur(Fenetre fen, Partie partie, InterfacePartie ecran){
		
		this.fenetre = fen;
		this.partie = partie;
		this.ecran = ecran;
		
		InitGUI();
	}
	
	public void InitGUI(){
		
		GridLayout grille = new GridLayout(2,2);
		grille.setHgap(5);
		grille.setVgap(5);
		
		this.setLayout(grille);
		
		this.add(this.ecran.obtenirBoutonAttaquer());
		this.add(this.ecran.obtenirBoutonDeplacer());
		this.add(new BoutonSac(fenetre, partie, ecran));
		this.add(new BoutonPasserTour(fenetre, partie, ecran));
	}

}
