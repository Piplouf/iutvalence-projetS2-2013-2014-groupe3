package fr.projetS2_2013_2014_groupe3.test;

import fr.projetS2_2013_2014_groupe3.competences.Competence;
import fr.projetS2_2013_2014_groupe3.competences.Embrasement;
import fr.projetS2_2013_2014_groupe3.competences.Laser;
import fr.projetS2_2013_2014_groupe3.competences.PluieGuerisseuse;
import fr.projetS2_2013_2014_groupe3.competences.Poison;
import fr.projetS2_2013_2014_groupe3.jeu.Etat;
import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.jeu.Personnage;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PersonnageTest extends TestCase {
	
	public PersonnageTest(String text){
		super(text);
	}
	
	public void testEquals(){
		
		Partie partie = new Partie();

		Competence[] compe = new Competence[Personnage.NOMBRE_DE_COMPETENCES_PAR_DEFAUT];

		compe[0] = new Poison(partie);
		compe[1] = new Embrasement(partie);
		compe[2] = new Laser(partie);
		compe[3] = new PluieGuerisseuse(partie);

		Personnage perso1 = new Personnage("Riven", 100, 100, 30, 3, compe, 1);
		Personnage perso2 = new Personnage("Riven", 100, 100, 30, 3, compe, 1);
		assertEquals("Résultat attendu : true ",true, perso1.equals(perso2));
		
		perso2 = new Personnage("Riven", 100, 100, 30, 3, compe, 2);
		assertEquals("Résultat attendu : false ",false, perso1.equals(perso2));
		
		perso2 = new Personnage("Thresh", 100, 100, 30, 3, compe, 1);
		assertEquals("Résultat attendu : false ",false, perso1.equals(perso2));
		
	}
	
	public void testRetournerEtat(){
		
		Partie partie = new Partie();

		Competence[] compe = new Competence[Personnage.NOMBRE_DE_COMPETENCES_PAR_DEFAUT];

		compe[0] = new Poison(partie);
		compe[1] = new Embrasement(partie);
		compe[2] = new Laser(partie);
		compe[3] = new PluieGuerisseuse(partie);

		Personnage perso = new Personnage("Riven", 100, 100, 30, 3, compe, 1);
		assertEquals("Normal", perso.retournerEtat());
		perso.modifierEtat(Etat.EMPOISONNE);
		assertEquals("Empoisonné", perso.retournerEtat());
		
	}
	
	public void testRajouterVie(){
		
		Partie partie = new Partie();
		Competence[] compe = new Competence[Personnage.NOMBRE_DE_COMPETENCES_PAR_DEFAUT];
		compe[0] = new Poison(partie);
		compe[1] = new Embrasement(partie);
		compe[2] = new Laser(partie);
		compe[3] = new PluieGuerisseuse(partie);
		Personnage perso = new Personnage("Riven", 100, 100, 30, 3, compe, 1);
		
		perso.rajouterVie(10);
		assertEquals(100, perso.obtenirVie());
		perso.enleverVie(50);
		perso.rajouterVie(10);
		assertEquals(60, perso.obtenirVie());
	}
	
	public void testEnleverVie(){
		
		Partie partie = new Partie();
		Competence[] compe = new Competence[Personnage.NOMBRE_DE_COMPETENCES_PAR_DEFAUT];
		compe[0] = new Poison(partie);
		compe[1] = new Embrasement(partie);
		compe[2] = new Laser(partie);
		compe[3] = new PluieGuerisseuse(partie);
		Personnage perso = new Personnage("Riven", 100, 100, 30, 3, compe, 1);
		
		perso.enleverVie(200);
		assertEquals(0, perso.obtenirVie());
		perso.rajouterVie(15);
		perso.enleverVie(7);
		assertEquals(8, perso.obtenirVie());
	}
	
	
	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTest(new PersonnageTest("testEquals"));
		suite.addTest(new PersonnageTest("testRetournerEtat"));
		suite.addTest(new PersonnageTest("testEnleverVie"));
		suite.addTest(new PersonnageTest("testRajouterVie"));
		return (Test) suite;
	}
}
