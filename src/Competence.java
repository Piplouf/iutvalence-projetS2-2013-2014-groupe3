
public abstract class Competence {
	
	private String nom;
	
	private int puissance;
	
	public Competence(String nom, int puissance){
		this.nom = nom;
		this.puissance = puissance;
	}
	
	public abstract void utiliserCompetence(Personnage cible);
	
	public int obtenirPuissance(){
		return this.puissance;
	}

}
