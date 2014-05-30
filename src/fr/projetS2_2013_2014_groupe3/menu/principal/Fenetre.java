package fr.projetS2_2013_2014_groupe3.menu.principal;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.projetS2_2013_2014_groupe3.jeu.Partie;

/** La fenetre principale du jeu, celle qui sera change a chaque fois que cela est necessaire*/
@SuppressWarnings("serial")
public class Fenetre extends JFrame implements Runnable{
	
	private Partie partie;
	
	public Fenetre(Partie partie){
		
		this.partie = partie;
	}
	
	/** Initialisation de la fenetre*/
	public void initGUI(){
		
		this.setTitle("Kingdom Snickers");
	    this.setSize(1000, 600);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    
		this.setContentPane(new Menu(this));
		this.setVisible(true);
	}
	
	public Partie obtenirPartie(){
		return this.partie;
	}
	
	/** Permet de changer le JPanel principal de la fenetre et ainsi de passer d'un menu à un autre*/
	public void modifierPanneau(JPanel panneau){
		this.setContentPane(panneau);
	    this.setVisible(true);
	}
	
	/** Refresh toute la fenetre*/
	public void refresh(){
		this.getContentPane().validate();
		this.setVisible(true);
		
	}

	@Override
	/** ininitialise l'interface graphique quand on appelle le thread*/
	public void run() {
		
		this.initGUI();
		
	}

}
