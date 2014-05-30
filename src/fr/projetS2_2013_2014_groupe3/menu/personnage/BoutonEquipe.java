package fr.projetS2_2013_2014_groupe3.menu.personnage;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import fr.projetS2_2013_2014_groupe3.jeu.Personnage;

/** Bouton correspondant aux personnages de l'equipe du joueur, quand on clique dessus on enleve le personnage
 * associée à ce bouton de l'equipe*/
@SuppressWarnings("serial")
public class BoutonEquipe extends JButton implements ActionListener, MouseListener{

	private MenuPersonnage ecranPerso;
	
	private PersonnageMenu perso;
	
	public BoutonEquipe(final PersonnageMenu personnage, MenuPersonnage ecran){
		
		this.ecranPerso = ecran;
		this.perso = personnage;
		this.setPreferredSize(new Dimension(120,120));
		
		if(perso.obtenirPerso().obtenirNom() == "Null")
			this.setEnabled(false);
		else
			this.setIcon(this.perso.obtenirImage());
		
		this.addActionListener(this);
		
		this.addMouseListener(this);
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

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if(retournerBouton().isEnabled())
			ecranPerso.modifierCaracteristiques(perso.obtenirPerso().toString());
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		ecranPerso.retirerJoueurEquipe(retournerBouton(),obtenirPerso());
		
	}
}
