package fr.projetS2_2013_2014_groupe3.menu.personnage;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;


public class BoutonPersonnage extends JButton{
	
	private PersonnageMenu perso;
	
	private MenuPersonnage ecranPerso;
	
	public BoutonPersonnage(){
		this.setPreferredSize(new Dimension(120,120));
	}
	
	public BoutonPersonnage(final PersonnageMenu perso, MenuPersonnage ecran, int x, int y){
		
		this.ecranPerso = ecran;
		this.perso = perso;
		this.setIcon(perso.obtenirImage());
		this.setPreferredSize(new Dimension(x,y));
		
		
		this.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
					ecranPerso.modifierCaracteristiques("<html>Nom : "+perso.obtenirPerso().obtenirNom()+"<br>"+
						"Vie : "+perso.obtenirPerso().obtenirVie()+"<br>"+
						"Puissance : "+perso.obtenirPerso().obtenirPuissance()+"<br>"+
						"Capacité de déplacement : "+perso.obtenirPerso().obtenirNombreDeplacement()+"<br>"+
						"Compétences :<br>"+perso.obtenirPerso().obtenirCompetence(0)+"<br>"+
						perso.obtenirPerso().obtenirCompetence(1)+"<br>"+perso.obtenirPerso().obtenirCompetence(2)+"<br>"+
						perso.obtenirPerso().obtenirCompetence(3)+"<br>"
						);
					
					if(ecranPerso.ajouterJoueurEquipe(perso))
						griser();
				}
			
		});
		
		this.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
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
			public void mouseExited(MouseEvent arg0) {
				ecranPerso.modifierCaracteristiques("");
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}
	
	public void griser(){
		this.setEnabled(false);
	}
	
	public PersonnageMenu obtenirPersonnageMenu(){
		return this.perso;
	}
}