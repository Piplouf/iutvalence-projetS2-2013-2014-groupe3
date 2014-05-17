package fr.projetS2_2013_2014_groupe3.menu.carte;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class SelecteurDeCarte extends JPanel {

	private MenuCarte ecran;

	public SelecteurDeCarte(MenuCarte interfaceCarte){
		
		this.ecran = interfaceCarte;
		
		GridLayout grilleCarte = new GridLayout(1,5);
		grilleCarte.setHgap(5);
		grilleCarte.setVgap(5);
		
		JPanel toutesLesCartes = new JPanel();
		
		toutesLesCartes.setLayout(grilleCarte);
		
		toutesLesCartes.add(new BoutonCarte(ecran));	
		toutesLesCartes.add(new BoutonCarte(ecran));
		toutesLesCartes.add(new BoutonCarte(ecran));
		toutesLesCartes.add(new BoutonCarte(ecran));
		toutesLesCartes.add(new BoutonCarte(ecran));
		
		this.add(toutesLesCartes);
		
		
	}

}
