package fr.projetS2_2013_2014_groupe3.jeu;

public class ObjetVide extends Objet {

	public ObjetVide() {
		super("Vide", TypeObjet.DEFENSIF);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String utiliserObjet(Personnage perso) {
		return null;
	}

}
