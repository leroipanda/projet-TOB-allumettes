package allumettes;



public class JoueurRapide extends Joueur {

	

	public JoueurRapide(String nm) {
		super(nm);
		// TODO Auto-generated constructor stub
	}

	@Override
	int getPrise(jeuPrincipal jeu) {
		// TODO Auto-generated method stub
		return Math.min(3,jeu.getNombreAllumettes());
		
	}

	
}