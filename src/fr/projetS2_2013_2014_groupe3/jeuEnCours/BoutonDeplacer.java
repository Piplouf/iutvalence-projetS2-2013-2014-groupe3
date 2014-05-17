package fr.projetS2_2013_2014_groupe3.jeuEnCours;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.menu.principal.Fenetre;

public class BoutonDeplacer extends JButton {
	
	private Fenetre fen;
	
	private Partie partie;
	
	private InterfacePartie ecran;

	public BoutonDeplacer(Fenetre fen, final Partie partie, final InterfacePartie ecranEnCours){
		
		super("Deplacer");
		this.fen = fen;
		this.partie = partie;
		this.ecran = ecranEnCours;
		
		this.setPreferredSize(new Dimension(400,50));
		this.setEnabled(false);
		
		this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
			if(!ecran.obtenirACliquerSurBoutonDeplacer()){
				ecran.modifierACliquerSurBoutonDeplacer(true);
			}
				
				
				
			}
			
		});
	}

}
