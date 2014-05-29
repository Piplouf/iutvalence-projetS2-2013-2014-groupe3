package fr.projetS2_2013_2014_groupe3.menu.principal;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.projetS2_2013_2014_groupe3.jeu.Partie;


public class Fenetre extends JFrame implements Runnable{
	
	private Partie partie;
	
	public Fenetre(Partie partie){
		
		this.partie = partie;
	}
	
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
	
	public void modifierPanneau(JPanel panneau){
		this.setContentPane(panneau);
	    this.setVisible(true);
	}
	
	public void refresh(){
		this.getContentPane().validate();
		this.setVisible(true);
		
	}

	@Override
	public void run() {
		
		this.initGUI();
		
	}

}
