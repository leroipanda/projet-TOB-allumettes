package allumettes;

/** Lance une partie des 13 allumettes en fonction des arguments fournis
 * sur la ligne de commande.
 * @author	Xavier Crégut
 * @version	$Revision: 1.5 $
 */
public class Partie  {
	
	
	/** Lancer une partie. En argument sont donnés les deux joueurs sous
	 * la forme nom@stratégie.
	 * @param args la description des deux joueurs
	 */
	public static void main(String[] args) {
		Joueur[] tabJoueur = new Joueur[2];
		try {
			verifierNombreArguments(args);
			
			
			
			boolean confiant =false ;
			if (args[0].equals("-confiant")){
				//System.out.println("je suis confiant");
				args[0] = args[1];
				args[1] = args[2];
				confiant = true;
			}
			
		//gestion des arguments en entrée 
			//on ajoute les 2 joueurs
			for(int i=0 ;i < 2 ;i++){
				//System.out.println(i);
				//on cherche si le symbole @ est present 
				if( args[i].contains("@")){
					//on sépare au niveau de l'@
					String[] argumentJoueur = args[i].split("@");
					//System.out.println(argumentJoueur[0]);
					//System.out.println(argumentJoueur[1]);
					//on ajoute le joueurs en fonction de sa difficulté
					switch(argumentJoueur[1]){
					
					case "Naif" : 
						tabJoueur[i] = new JoueurNaif(argumentJoueur[0]);
						break ; 
					case "Rapide" :
						tabJoueur[i] = new JoueurRapide(argumentJoueur[0]);
						break;
					case "Expert" :
						tabJoueur[i] = new JoueurExpert(argumentJoueur[0]);
						break;
					case "Humain" :
						tabJoueur[i] = new JoueurHumain(argumentJoueur[0]);
						break;
					case "Tricheur" :
						tabJoueur[i] = new JoueurTricheur(argumentJoueur[0]);
						break;
					default : 
						// lever expetion probleme de dificulte
					}
					
				}
				else{
					//ajouter l'exeption format invalide
				}
				
			}
			//on initialise l'arbitre
			Arbitre arbitre = new Arbitre(tabJoueur[0],tabJoueur[1],confiant);
			//on initialise la partie
			jeuPrincipal jeu = new jeuPrincipal();
			//on fait demarer la partie
			arbitre.arbitrer(jeu);
			
			
			

		} catch (ConfigurationException e) {
			System.out.println();
			System.out.println("Erreur : " + e.getMessage());
			afficherUsage();
			System.exit(1);
		}
	}

	private static void verifierNombreArguments(String[] args) {
		final int nbJoueurs = 2;
		if (args.length < nbJoueurs) {
			throw new ConfigurationException("Trop peu d'arguments : "
					+ args.length);
		}
		if (args.length > nbJoueurs + 1) {
			throw new ConfigurationException("Trop d'arguments : "
					+ args.length);
		}
	}

	/** Afficher des indications sur la manière d'exécuter cette classe. */
	public static void afficherUsage() {
		System.out.println("\n" + "Usage :"
				+ "\n\t" + "java allumettes.Partie joueur1 joueur2"
				+ "\n\t\t" + "joueur est de la forme nom@stratégie"
				+ "\n\t\t" + "strategie = naif | rapide | expert | humain | tricheur"
				+ "\n"
				+ "\n\t" + "Exemple :"
				+ "\n\t" + "	java allumettes.Partie Xavier@humain "
					   + "Ordinateur@naif"
				+ "\n"
				);
	}

}
