package fr.projetS2_2013_2014_groupe3.jeuEnCours;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.menu.principal.Fenetre;

public class BoutonAttaquer extends JButton {
	
	private Fenetre fen;
	
	private Partie partie;
	
	private InterfacePartie ecran;

	public BoutonAttaquer(Fenetre fen, Partie partie, InterfacePartie ecranEnCours) {
		
		super("Attaquer");
		this.fen = fen;
		this.partie = partie;
		this.ecran = ecranEnCours;
		
		this.setPreferredSize(new Dimension(400,50));
		this.setEnabled(false);
		
		this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

}
