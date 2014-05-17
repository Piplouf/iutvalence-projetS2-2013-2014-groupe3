package fr.projetS2_2013_2014_groupe3.menu.principal;



import java.awt.Button;
import java.awt.Cursor;
import java.awt.Dimension;

import fr.projetS2_2013_2014_groupe3.jeu.Position;

public class Bouton extends Button {

	private Position position;
	
	public Bouton(int x, int y){
		super("");
		this.setSize(50, 50);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
}
