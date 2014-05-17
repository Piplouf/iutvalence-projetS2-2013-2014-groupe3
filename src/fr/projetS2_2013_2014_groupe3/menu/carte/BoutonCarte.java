package fr.projetS2_2013_2014_groupe3.menu.carte;
import java.awt.Dimension;

import javax.swing.JButton;


public class BoutonCarte extends JButton{
	
	private MenuCarte ecran;
	
	private static CarteMenu carte;
	
	public BoutonCarte(MenuCarte ecranCourant){
		
		this.setPreferredSize(new Dimension(120,120));
		this.ecran = ecranCourant;
		this.carte = new CarteMenu();
		this.setEnabled(false);
	}
	
	public BoutonCarte(MenuCarte ecranCourant, CarteMenu carte){
		
		this.setPreferredSize(new Dimension(120,120));
		this.ecran = ecranCourant;
	}
	
	public CarteMenu obtenirCarteMenu(){
		return this.carte;
	}

}
