
public class Personnage {
	
	private int vie;
	
	private String Nom;
	
	private int vieMax;
	
	private int puissance;
	
	private Competence[] competences;
	
	private int capaciteDeDeplacement;
	
	private final static int NOMBRE_DE_COMPETENCES_PAR_DEFAUT = 4;
	
	public Personnage(int vie, Competence[] competencesVoulues, int capaciteDeplacement ){
		this.vie = vie;
		this.vieMax = vie;
		this.competences = competencesVoulues;
		this.capaciteDeDeplacement = capaciteDeplacement;
	}
	
}
