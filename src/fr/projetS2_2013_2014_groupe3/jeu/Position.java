package fr.projetS2_2013_2014_groupe3.jeu;

/** Position à deux dimensions */
public class Position {

		private int x;
		
		private int y;
		
		public Position(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		/**
		 * Permet d'obtenir l'absicsse de la position
		 * @return
		 */
		public int obtenirX(){
			return this.x;
		}
		
		/**
		 * Permet d'obtenir l'ordonnée de la position
		 * @return
		 */
		public int obtenirY(){
			return this.y;
		}
		
		public void modifierX(int x){
			this.x = x;
		}
		
		public void modifierY(int y){
			this.y = y;
		}
		
		public Position obtenirPosition(){
			return this;
		}
		
		/** Répresentation textuelle de la position */
		public String toString(){
			return "<html>X : "+this.obtenirX()+"<br>Y : "+this.obtenirY();
		}
}
