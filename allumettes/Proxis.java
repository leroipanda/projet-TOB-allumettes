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
		//on met le meme nombre d'allumettes entre le proxis et le jeu 
		while( jeuProxis.getNombreAllumettes() != jeu.getNombreAllumettes()){
			try{
				jeuProxis.retirer(1);
			}
			catch(CoupInvalideException e){
				//pas possible en theorie
			}
			
		}
		
		
		//on sauvegarde l'etat avant du jeuProxis
		int jeuProxisAvant = jeuProxis.getNombreAllumettes();
		int coup = joueur.getPrise(jeuProxis);
		if( jeuProxis.getNombreAllumettes() !=jeuProxisAvant ) {
			//je joueur � retirer des allumettes
			throw new OperationInterditeException();
		}
		return coup;
	}

}
