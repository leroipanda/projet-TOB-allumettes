package allumettes;

public class JoueurTricheur extends Joueur {

	public JoueurTricheur(String nm) {
		super(nm);
		// TODO Auto-generated constructor stub
	}

	@Override
	int getPrise(jeuPrincipal jeu) {
		
		while (jeu.getNombreAllumettes() >2) {
			try{
				jeu.retirer(1);
			    }
			    catch(CoupInvalideException e) {
			    	
			    }
		        }
		
		return 1;
	}

}
