
public class Case {
	
	private boolean estPleine;
	
	private Perso estOccupe;

	public Case(){
		this.estOccupe = new PersonnageVide();
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
	public Perso estOccupe(){
		return this.estOccupe;
	}
	
	public void modifierEstPleine(boolean modif){
		this.estPleine = modif;
	}
	
	public void modifierEstOccupe(Perso perso){
			this.estOccupe = perso;
	}
}


