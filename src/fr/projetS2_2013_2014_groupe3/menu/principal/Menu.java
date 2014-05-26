package fr.projetS2_2013_2014_groupe3.menu.principal;



import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import fr.projetS2_2013_2014_groupe3.menu.personnage.MenuPersonnage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends JPanel implements ActionListener {
	
	private JPanel menu;
	
	private Fenetre fenetre;
	
	private JButton jouer;
	
	private JButton option;
	
	private JButton quitter;
	
	
  public Menu(Fenetre fen){
	  
    this.fenetre = fen;
	this.menu = new JPanel();
    
    JPanel conteneur1 = new JPanel();
    JPanel conteneur2 = new JPanel();
    JPanel conteneur3 = new JPanel();
    JPanel conteneur4 = new JPanel();
    JPanel conteneurFinal = new JPanel();
    conteneurFinal.setLayout(new GridLayout(4,1));
        
    this.jouer = new JButton("Jouer");
    this.jouer.setPreferredSize(new Dimension(200,50));
    this.option = new JButton("Options");
    this.option.setPreferredSize(new Dimension(200,50));
    this.quitter = new JButton("Quitter");
    this.quitter.setPreferredSize(new Dimension(200,50));
    
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
    
    this.jouer.addActionListener(this);
    this.option.addActionListener(this);
    this.quitter.addActionListener(this);
   
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
  
  public void actionPerformed(ActionEvent event){
	  
	  JComponent source = (JComponent) event.getSource();

		if (source == this.jouer)
		{
			this.fenetre.modifierPanneau(
					new MenuPersonnage(this.fenetre, this.fenetre.obtenirPartie(), 0));
			return;
		}

		if (source == this.option)
		{
			changerMenuEnMenuOption();
			return;
		}

		if (source == this.quitter)
		{
			this.fenetre.dispose();
			return;
		}
  }

}
