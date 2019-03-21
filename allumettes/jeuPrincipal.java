package allumettes;

public class jeuPrincipal implements Jeu {
	//nb initiale d'allumette
	private int allumettes = 13;
	public jeuPrincipal() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getNombreAllumettes() {
		// TODO Auto-generated method stub
		return allumettes;
	}

	@Override
	public void retirer(int nbPrises) throws CoupInvalideException {
		// getion de l'exeption : 
		
		
		//coup valide
		if( nbPrises > getNombreAllumettes()){
			throw new CoupInvalideException(nbPrises , ">" + getNombreAllumettes()); 
		}
		
		
		if( nbPrises > this.PRISE_MAX){
			throw new CoupInvalideException(nbPrises , ">" + Jeu.PRISE_MAX); 
		}
		if( nbPrises <= 0){
			throw new CoupInvalideException( nbPrises, "<1"); 
		}
		
		allumettes -= nbPrises;
	}

}
