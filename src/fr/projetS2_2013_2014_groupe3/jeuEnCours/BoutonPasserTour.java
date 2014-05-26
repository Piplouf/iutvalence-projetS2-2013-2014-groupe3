package fr.projetS2_2013_2014_groupe3.jeuEnCours;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.menu.principal.Fenetre;

public class BoutonPasserTour extends JButton {
	
	private Fenetre fen;
	
	private Partie partie;
	
	private InterfacePartie ecran;

	public BoutonPasserTour(Fenetre fen, final Partie partie, InterfacePartie ecranEnCours) {
		
		super("Passer tour");
		this.fen = fen;
		this.partie = partie;
		this.ecran = ecranEnCours;
		
		this.setPreferredSize(new Dimension(400,50));
		
		this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				partie.modifierNumeroJoueur();
				ecran.obtenirFenetre().modifierPanneau(new InterfacePartie(ecran.obtenirFenetre(),partie));
				
			}
			
		});
	}

}
