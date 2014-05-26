package fr.projetS2_2013_2014_groupe3.menu.principal;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import fr.projetS2_2013_2014_groupe3.jeu.Options;
import fr.projetS2_2013_2014_groupe3.menu.personnage.MenuPersonnage;


@SuppressWarnings("serial")
public class MenuOption extends JPanel implements ActionListener, ChangeListener{
	
	private JSlider slideLuminosite;

	private JLabel luminosite;
	
	private JButton retour;
	
	private JPanel menu;
	
	private Fenetre fenetre;
	
	private Options option;
	
	public MenuOption(Fenetre fen){
		
		this.fenetre = fen;
	    this.menu = new JPanel();
	    
	    JPanel conteneur1 = new JPanel();
	    JPanel conteneur2 = new JPanel();
	    JPanel conteneur3 = new JPanel();
	    JPanel conteneur4 = new JPanel();
	    JPanel conteneurFinal = new JPanel();
	    conteneurFinal.setLayout(new GridLayout(4,1));
	        
	    
	    JLabel vide = new JLabel();
	    this.luminosite = new JLabel();
	    luminosite.setText("Réglage luminosité");
	    
	    this.slideLuminosite = new JSlider();
	    this.retour = new JButton("Retour");
	    this.retour.setPreferredSize(new Dimension(200,50));
	      
	    conteneur1.add(luminosite);
	    conteneur2.add(slideLuminosite);
	    conteneur3.add(this.retour);
	    conteneur4.add(vide);
	    
	    conteneurFinal.add(conteneur4);
	    conteneurFinal.add(conteneur1);
	    conteneurFinal.add(conteneur2);
	    conteneurFinal.add(conteneur3);
	    
	    menu.add(conteneurFinal);
	    
	    this.add(menu);
	    this.setVisible(true);
	    
	    this.slideLuminosite.addChangeListener((ChangeListener) this);
	    this.retour.addActionListener(this);
	}
	
	public Fenetre obtenirFenetre(){
		return this.fenetre;
	}
	
	public void changerMenuEnMenuPrincipal(){
		this.menu.removeAll();
	  	this.menu.add(new Menu(this.fenetre).obtenirMenu());
	  	this.menu.repaint();
	  	this.fenetre.modifierPanneau(this.menu);
	}
	
	public void changerLuminosite(int reglage){
		this.luminosite.setText(Integer.toString(reglage));
		this.menu.setVisible(true);
	}
	
	 class ActionListenerLuminosite implements ChangeListener {
		 
		 public void stateChanged(ChangeEvent event){
			 changerLuminosite(((JSlider)event.getSource()).getValue());
		      }
	}
	 
	 class BoutonListenerQuitter implements ActionListener{
		 
		    public void actionPerformed(ActionEvent arg0) {
		    	changerMenuEnMenuPrincipal();
		    }
		  }

	@Override
	public void actionPerformed(ActionEvent event) {
		JComponent source = (JComponent) event.getSource();

		if (source == this.retour)
		{
			changerMenuEnMenuPrincipal();
			return;
		}
		
	}

	@Override
	public void stateChanged(ChangeEvent event) {
		JComponent source = (JComponent) event.getSource();

		if (source == this.slideLuminosite)
		{
			this.changerLuminosite(((JSlider)event.getSource()).getValue());
			return;
		}
		
	}
}
