package allumettes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JoueurRapideTest {

	// précision pour les comparaisons réelle
	public final static double EPSILON = 0.001;
	private Joueur joueur;
	private jeuPrincipal jeu;
	String nom ;
	
	@Before
	public void setUp() throws Exception {
		nom = "Alice";
		joueur = new JoueurRapide(nom);
		jeu = new jeuPrincipal();
	}

	@Test
	public void testGetPrise() {
		for (int i=0 ; i < 3 ; i++){
		assertEquals( joueur.getPrise(jeu), 3,EPSILON );
		}
	}

	@Test
	public void testGetNom() {
		assertEquals( nom , joueur.getNom());
	}

}
