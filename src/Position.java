
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
}
