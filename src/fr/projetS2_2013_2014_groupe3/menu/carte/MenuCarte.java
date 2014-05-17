package fr.projetS2_2013_2014_groupe3.menu.carte;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.menu.principal.Fenetre;

public class MenuCarte extends JPanel {

	private Fenetre fen;

	private Partie partie;

	private BoutonValidationCarte boutonValidation;
	
	private BoutonCarte boutonCarte;

	public MenuCarte(Fenetre fenetre, Partie partieEnCours) {

		this.fen = fenetre;
		this.partie = partieEnCours;
		this.boutonCarte = new BoutonCarte(this);
		
		JPanel fin = new JPanel();
		JPanel boutonValider = new JPanel();
		JPanel centre = new JPanel();

		this.boutonValidation = new BoutonValidationCarte(this);
		this.boutonValidation.setPreferredSize(new Dimension(200, 50));

		boutonValider.add(this.boutonValidation);

		JLabel texteCarte = new JLabel("<html>Séléction de la carte <br><br></html>");
		texteCarte.setFont(new Font("Arial", Font.BOLD, 16));
		JPanel texteJou = new JPanel();
		texteJou.add(texteCarte);
		
		JPanel choixCarte = new JPanel();
		choixCarte.add(this.boutonCarte);

		centre.add(texteJou);
		centre.setLayout(new BoxLayout(centre, BoxLayout.Y_AXIS));
		centre.add(new SelecteurDeCarte(this));
		centre.add(new JLabel("<html><br><br>"));
		centre.add(choixCarte);
		centre.add(new JLabel("<html><br><br>"));
		centre.add(boutonValider);

		fin.add(centre);

		this.add(fin);
	}
	
	public Partie obtenirPartie(){
		return this.partie;
	}
	
	public BoutonCarte obtenirBoutonCarte(){
		return this.boutonCarte;
	}
	
	public Fenetre obtenirFenetre(){
		return this.fen;
	}

}
