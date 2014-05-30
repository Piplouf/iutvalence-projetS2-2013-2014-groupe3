package fr.projetS2_2013_2014_groupe3.menu.carte;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/** Bouton qui comporte les cartes*/
@SuppressWarnings("serial")
public class BoutonCarte extends JButton implements ActionListener{
	
	private MenuCarte ecran;
	
	private CarteMenu carte;
	
	private static CarteMenu carteCourante;
	
	public BoutonCarte(MenuCarte ecranCourant){
		
		this.setPreferredSize(new Dimension(120,120));
		this.ecran = ecranCourant;
		this.carte = new CarteMenu();
		BoutonCarte.carteCourante = new CarteMenu();
		this.setEnabled(false);
		
	}
	
	public BoutonCarte(MenuCarte ecranCourant, CarteMenu laCarte){
		
		
		this.ecran = ecranCourant;
		this.carte = laCarte;
		BoutonCarte.carteCourante = new CarteMenu();
		InitGUI();
		
	}
	
	public void InitGUI(){
		
		this.setPreferredSize(new Dimension(120,120));
		this.setText(this.carte.obtenirNom());
		this.addActionListener(this);
	}
	
	/** Change la carte courante choisi par le joueur*/
	public void changerBoutonCarteCourante(){
		ecran.obtenirBoutonCarte().modifierCarte(carteCourante);
		ecran.obtenirBoutonCarte().setIcon(ecran.obtenirBoutonCarte().obtenirCarteMenuCourante().obtenirImage());
		ecran.obtenirBoutonCarte().setText(BoutonCarte.carteCourante.obtenirNom());
	}
	
	public void modifierCarte(CarteMenu carte){
		this.carte = carte;
	}
	
	public CarteMenu obtenirCarteMenuCourante(){
		return BoutonCarte.carteCourante;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(carteCourante.obtenirNom() != carte.obtenirNom()){
			carteCourante = carte;
			ecran.obtenirBoutonCarte().setEnabled(true);
			ecran.obtenirBoutonValidation().setEnabled(true);
		}
	changerBoutonCarteCourante();
		
		
	}

	
}
