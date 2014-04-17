
public class Case {
	
	private boolean estPleine;
	
	private Personnage estOccupe;

	public Case(){
		this.estOccupe = null;
		this.estPleine = false;
	}
	
	/**
	 * Renvoi true si la case est pleine
	 * et false si elle ne l'est pas
	 */
	public boolean estPleine(){
		return this.estPleine;
	}
	
	/**
	 * Renvoi true si la case est occupe par un personnage
	 * et false si elle n'est pas occupe
	 * @return
	 */
	public Personnage estOccupe(){
		return this.estOccupe;
	}
	
	public void modifierEstPleine(boolean modif){
		this.estPleine = modif;
	}
	
	public void modifierEstOccupe(Personnage perso){
		this.estOccupe = perso;
	}
}


