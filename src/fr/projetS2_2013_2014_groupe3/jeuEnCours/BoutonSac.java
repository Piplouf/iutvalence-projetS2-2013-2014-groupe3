package fr.projetS2_2013_2014_groupe3.jeuEnCours;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.menu.principal.Fenetre;
import fr.projetS2_2013_2014_groupe3.menu.sac.MenuSac;

/** Bouton qui modifier la partie en mode sac*/
@SuppressWarnings("serial")
public class BoutonSac extends JButton {
	
	private Fenetre fen;
	
	private Partie partie;
	
	private InterfacePartie ecran;

	public BoutonSac(Fenetre fenetre, Partie laPartie, InterfacePartie lEcran) {
		
		super("Sac");
		this.fen = fenetre;
		this.partie = laPartie;
		this.ecran = lEcran;
		this.setPreferredSize(new Dimension(400,50));
		
		this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			
			if(!partie.obtenirJoueurCourant().obtenirSac().lotObjets.isEmpty())
				fen.modifierPanneau(new MenuSac(fen,partie));
			else{
				ecran.obtenirPersoSel().setText("Le sac est vide");
				ecran.obtenirBoutonAttaquer().setEnabled(false);
				ecran.obtenirBoutonDeplacer().setEnabled(false);
			}	
			}
			
		});
	}

}
