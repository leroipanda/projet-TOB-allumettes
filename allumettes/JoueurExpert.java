package allumettes;

import java.util.Random; 

public class JoueurExpert extends Joueur {

	
	Random rnd = new Random();
	public JoueurExpert(String nm) {
		super(nm);
		// TODO Auto-generated constructor stub
	}

	@Override
	int getPrise(jeuPrincipal jeu) {
		
		switch(jeu.getNombreAllumettes() % 4) {
		case(3):
			return 2;	
		case(2):
			return 1;
		case(1): 
			int priseMaxPossible = Math.min(Jeu.PRISE_MAX, jeu.getNombreAllumettes());
		return rnd.nextInt(priseMaxPossible)+1;
		default :
			return 3;
		}
	}

}
