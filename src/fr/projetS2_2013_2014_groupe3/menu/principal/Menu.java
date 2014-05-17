package fr.projetS2_2013_2014_groupe3.menu.principal;



import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.projetS2_2013_2014_groupe3.jeu.MenuOption;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends JPanel {
	
	private JPanel menu;
	
	private Fenetre fenetre;
	
	
  public Menu(Fenetre fen){
	  
    this.fenetre = fen;
	this.menu = new JPanel();
    
    JPanel conteneur1 = new JPanel();
    JPanel conteneur2 = new JPanel();
    JPanel conteneur3 = new JPanel();
    JPanel conteneur4 = new JPanel();
    JPanel conteneurFinal = new JPanel();
    conteneurFinal.setLayout(new GridLayout(4,1));
        
    BoutonMenu jouer = new BoutonMenu("Jouer",this);
    JButton option = new JButton("Options");
    option.setPreferredSize(new Dimension(200,50));
    JButton quitter = new JButton("Quitter");
    quitter.setPreferredSize(new Dimension(200,50));
    
    JLabel vide = new JLabel("<html><br><br><br><br><br><br></html>");
      
    conteneur4.add(vide);
    conteneur1.add(jouer);
    conteneur2.add(option);
    conteneur3.add(quitter);

    
    conteneurFinal.add(conteneur4);
    conteneurFinal.add(conteneur1);
    conteneurFinal.add(conteneur2);
    conteneurFinal.add(conteneur3);
    
    this.menu.add(conteneurFinal);
    
    this.add(menu);
    
    this.setVisible(true);
    
    option.addActionListener(new BoutonListenerOption());
   
  }
  
  public void changerMenuEnMenuOption(){
	this.menu.removeAll();
  	this.menu.add(new MenuOption(this.fenetre));
  	this.menu.repaint();
  	this.fenetre.modifierPanneau(this.menu);
  }
  
  public Fenetre obtenirFenetre(){
	  return this.fenetre;
  }
  
  public JPanel obtenirMenu(){
	  return this.menu;
  }
  
	 class BoutonListenerOption implements ActionListener{
		 
		    public void actionPerformed(ActionEvent arg0) {
		    	changerMenuEnMenuOption();      
		    }
		  }

}
