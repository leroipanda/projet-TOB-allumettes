//faire en sorte que le Preise ma soit bien global 

package allumettes;
import java.util.Random; 

public class JoueurNaif extends Joueur{
	 Random rnd = new Random();
	  
	 
	public JoueurNaif(String nm) {
		super(nm);
		
	}
	
	@Override
	public int getPrise(jeuPrincipal jeu){ 
		// 
		return rnd.nextInt(Jeu.PRISE_MAX)+1;
		
	}
}
