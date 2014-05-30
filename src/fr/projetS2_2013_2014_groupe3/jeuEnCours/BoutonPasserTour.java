package fr.projetS2_2013_2014_groupe3.jeuEnCours;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.projetS2_2013_2014_groupe3.jeu.Partie;

/** Bouton qui indiquer si le joueur veut passer son tour*/
@SuppressWarnings("serial")
public class BoutonPasserTour extends JButton implements ActionListener{
	
	private Partie partie;
	
	private InterfacePartie ecran;

	public BoutonPasserTour(final Partie partie, InterfacePartie ecranEnCours) {
		
		super("Passer tour");
		this.partie = partie;
		this.ecran = ecranEnCours;
		
		this.setPreferredSize(new Dimension(400,50));
		
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		partie.modifierNumeroJoueur();
		ecran.obtenirFenetre().modifierPanneau(new InterfacePartie(ecran.obtenirFenetre(),partie));
		partie.redonnerEnergieATousLesPersonnages();
		
	}

}
