package allumettes;

public class jeuPrincipal implements Jeu {
	//nb initiale d'allumette
	private int allumettes = 20;
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
		
		if( nbPrises > this.PRISE_MAX){
			throw new CoupInvalideException(nbPrises , "superieur à la limite de "+ getNombreAllumettes()); 
		}
		if( nbPrises <0){
			throw new CoupInvalideException( nbPrises, "inferieur à la limite de 0"); 
		}
		
		allumettes -= nbPrises;
	}

}
