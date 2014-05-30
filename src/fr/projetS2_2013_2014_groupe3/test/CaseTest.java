package fr.projetS2_2013_2014_groupe3.test;

import junit.framework.*;
import fr.projetS2_2013_2014_groupe3.competences.Competence;
import fr.projetS2_2013_2014_groupe3.competences.Embrasement;
import fr.projetS2_2013_2014_groupe3.competences.Laser;
import fr.projetS2_2013_2014_groupe3.competences.PluieGuerisseuse;
import fr.projetS2_2013_2014_groupe3.competences.Poison;
import fr.projetS2_2013_2014_groupe3.exceptions.NumeroJoueurErronne;
import fr.projetS2_2013_2014_groupe3.exceptions.PositionErronne;
import fr.projetS2_2013_2014_groupe3.jeu.Case;
import fr.projetS2_2013_2014_groupe3.jeu.Partie;
import fr.projetS2_2013_2014_groupe3.jeu.Personnage;
import fr.projetS2_2013_2014_groupe3.jeu.Position;

public class CaseTest extends TestCase{

	public CaseTest(String text){
		super(text);
	}

	public void testCreation() {

		Partie partie = new Partie();

		Competence[] compe = new Competence[Personnage.NOMBRE_DE_COMPETENCES_PAR_DEFAUT];

		compe[0] = new Poison(partie);
		compe[1] = new Embrasement(partie);
		compe[2] = new Laser(partie);
		compe[3] = new PluieGuerisseuse(partie);

		Personnage perso = new Personnage("Riven", 100, 100, 30, 3, compe, 1);

		try {
			@SuppressWarnings("unused")
			Case c1 = new Case(perso, 0, new Position(1, 4));

			fail("Création case avec numero joueur incorrect detectée");
		} catch (PositionErronne e) {
		} catch (NumeroJoueurErronne e) {
		}
		assertTrue(true);

		try {
			@SuppressWarnings("unused")
			Case c2 = new Case(true, new Position(-2, 3));
			fail("Création case avec position incorrect detectée");
		} catch (PositionErronne e) {
		}
		assertTrue(true);
		
		try {
			@SuppressWarnings("unused")
			Case c3 = new Case(perso, perso.obtenirNumeroDAppartenanceJoueur(), new Position(3,-1));
			fail("Création case avec position incorrect detectée");
		} catch (PositionErronne e) {
		} catch (NumeroJoueurErronne e) {
		}
		assertTrue(true);
	}

	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTest(new CaseTest("testCreation"));
		return (Test) suite;
	}

}
