package fr.projetS2_2013_2014_groupe3.jeu;



import java.awt.Button;
import java.awt.Graphics;

import javax.swing.JPanel;
 
public class Panneau extends JPanel {
	
 private Carte carte;
 
 public Panneau(Carte carte){
	 this.carte = carte;
 }
	
  public void paintComponent(Graphics g){

	  
    int posiX = this.getWidth()/7;
    int posiY = this.getHeight()/7; 
	 
    for(int x = 0; x < this.carte.obtenirTailleEnX(); x++)
    {
    	for(int y = 0; y < this.carte.obtenirTailleEnY(); y++)
    	{
    		if(this.carte.obtenirCarte()[x][y].estOccupe() instanceof Personnage)
    			g.fillOval(posiX + 5, posiY + 5, 40, 40);
    		posiX += 50;
    	}
    posiX =	this.getWidth()/7;
    posiY +=50;
    }
	  //g.drawRect(10, 10, 60, 60);
	  //g.fillRect(80, 80, 40, 40);
  }               
}
