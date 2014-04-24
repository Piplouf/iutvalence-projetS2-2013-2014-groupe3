
public class BouleDeFeu extends Competence {
	
	public BouleDeFeu(){
		super("Boule de feu",20);
	}
	
	public void utiliserCompetence(Personnage cible) {
		cible.enleverVie(this.obtenirPuissance());
		
	}

	  
	
}
