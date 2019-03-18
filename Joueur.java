package allumettes;

abstract class Joueur {
	

	private String nom;

	public Joueur(String nm) {
		nom = nm ;
	}
	
	//fonction qui return le nom de l'objet 
	public String getNom(){
		return nom;
	}
	
	//fonction qui revoie ce que le joueur prend.
	abstract int getPrise(jeuPrincipal jeu);

}
