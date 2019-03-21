package allumettes;

public class Proxis extends Joueur {
	
	private Joueur joueur ;
	private jeuPrincipal jeuProxis = new jeuPrincipal();
	
	public Proxis(Joueur joueu) {
		super(joueu.getNom());
		joueur = joueu;
		// TODO Auto-generated constructor stub
	}

	@Override
	int getPrise(jeuPrincipal jeu) {
		//on sauvegarde l'etat avant du jeuProxis
		int jeuProxisAvant = jeuProxis.getNombreAllumettes();
		int coup = joueur.getPrise(jeuProxis);
		if( jeuProxis.getNombreAllumettes() !=jeuProxisAvant ) {
			//je joueur à retirer des allumettes
			throw new OperationInterditeException();
		}
		return coup;
	}

}
