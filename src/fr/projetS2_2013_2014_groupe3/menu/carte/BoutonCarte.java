package fr.projetS2_2013_2014_groupe3.menu.carte;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class BoutonCarte extends JButton{
	
	private MenuCarte ecran;
	
	private CarteMenu carte;
	
	private static CarteMenu carteCourante;
	
	public BoutonCarte(MenuCarte ecranCourant){
		
		this.setPreferredSize(new Dimension(120,120));
		this.ecran = ecranCourant;
		this.carte = new CarteMenu();
		this.carteCourante = new CarteMenu();
		this.setEnabled(false);
		
	}
	
	public BoutonCarte(MenuCarte ecranCourant, CarteMenu laCarte){
		
		
		this.ecran = ecranCourant;
		this.carte = laCarte;
		this.carteCourante = new CarteMenu();
		InitGUI();
		
	}
	
	public void InitGUI(){
		
		this.setPreferredSize(new Dimension(120,120));
		this.setText(this.carte.obtenirNom());
		this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				if(carteCourante.obtenirNom() != carte.obtenirNom()){
					carteCourante = carte;
					ecran.obtenirBoutonCarte().setEnabled(true);
					ecran.obtenirBoutonValidation().setEnabled(true);
				}
			changerBoutonCarteCourante();
				
			}
			
		});
	}
	
	public void changerBoutonCarteCourante(){
		ecran.obtenirBoutonCarte().modifierCarte(carteCourante);
		ecran.obtenirBoutonCarte().setIcon(ecran.obtenirBoutonCarte().obtenirCarteMenuCourante().obtenirImage());
		ecran.obtenirBoutonCarte().setText(this.carteCourante.obtenirNom());
	}
	
	public void modifierCarte(CarteMenu carte){
		this.carte = carte;
	}
	
	public CarteMenu obtenirCarteMenuCourante(){
		return this.carteCourante;
	}

	
}
