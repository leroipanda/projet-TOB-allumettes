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
		allumettes -= nbPrises;
		
		
	}

}
