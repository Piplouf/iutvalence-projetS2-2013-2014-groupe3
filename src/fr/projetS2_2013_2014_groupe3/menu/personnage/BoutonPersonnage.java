package fr.projetS2_2013_2014_groupe3.menu.personnage;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

/** Bouton du séléctionneur de personnage il s'ajoute a l'equipe quand on leurs clique dessus*/
@SuppressWarnings("serial")
public class BoutonPersonnage extends JButton implements ActionListener, MouseListener{
	
	private PersonnageMenu perso;
	
	private MenuPersonnage ecranPerso;
	
	public BoutonPersonnage(){
		this.setPreferredSize(new Dimension(120,120));
	}
	
	public BoutonPersonnage(final PersonnageMenu personnage, MenuPersonnage ecran, int x, int y){
		
		this.ecranPerso = ecran;
		this.perso = personnage;
		this.setIcon(perso.obtenirImage());
		this.setPreferredSize(new Dimension(x,y));
		
		
		this.addActionListener(this);
		this.addMouseListener(this);
		
	}
	
	public void griser(){
		this.setEnabled(false);
	}
	
	public PersonnageMenu obtenirPersonnageMenu(){
		return this.perso;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		ecranPerso.modifierCaracteristiques(perso.obtenirPerso().toString());
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(ecranPerso.ajouterJoueurEquipe(perso))
			griser();
		
	}
}
