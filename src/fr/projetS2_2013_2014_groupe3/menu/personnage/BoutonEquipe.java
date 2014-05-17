package fr.projetS2_2013_2014_groupe3.menu.personnage;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import fr.projetS2_2013_2014_groupe3.jeu.Personnage;


public class BoutonEquipe extends JButton{

	private MenuPersonnage ecranPerso;
	
	private PersonnageMenu perso;
	
	public BoutonEquipe(final PersonnageMenu personnage, MenuPersonnage ecran){
		
		this.ecranPerso = ecran;
		this.perso = personnage;
		this.setPreferredSize(new Dimension(120,120));
		
		if(perso.obtenirPerso().obtenirNom() == "Null")
			this.setEnabled(false);
		
		this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				ecranPerso.retirerJoueurEquipe(retournerBouton(),obtenirPerso());
			}

		});
		
		this.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if(retournerBouton().isEnabled())
					ecranPerso.modifierCaracteristiques("<html>Nom : "+perso.obtenirPerso().obtenirNom()+"<br>"+
						"Vie : "+perso.obtenirPerso().obtenirVie()+"<br>"+
						"Puissance : "+perso.obtenirPerso().obtenirPuissance()+"<br>"+
						"Capacité de déplacement : "+perso.obtenirPerso().obtenirNombreDeplacement()+"<br>"+
						"Compétences :<br>"+perso.obtenirPerso().obtenirCompetence(0)+"<br>"+
						perso.obtenirPerso().obtenirCompetence(1)+"<br>"+perso.obtenirPerso().obtenirCompetence(2)+"<br>"+
						perso.obtenirPerso().obtenirCompetence(3)+"<br>"
						);
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
					ecranPerso.modifierCaracteristiques("");
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public BoutonEquipe retournerBouton(){
		return this;
	}
	
	public PersonnageMenu obtenirPerso(){
		return this.perso;
	}
	
	public void modifierPerso(Personnage personnage){
		this.perso.modifierPerso(personnage);
	}
}
