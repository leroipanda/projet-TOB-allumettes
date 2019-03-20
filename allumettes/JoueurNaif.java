//faire en sorte que le Preise ma soit bien global 

package allumettes;
import java.util.Random; 

public class JoueurNaif extends Joueur{
	 Random rnd = new Random();
	  
	 
	public JoueurNaif(String nm) {
		super(nm);
		System.out.println("-------");
		
	}
	
	@Override
	public int getPrise(jeuPrincipal jeu){ 
		// 
		int priseMaxPossible = Math.min(Jeu.PRISE_MAX, jeu.getNombreAllumettes());
		


		
		return rnd.nextInt(priseMaxPossible)+1;
		
	}
}
