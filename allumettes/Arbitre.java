package allumettes;

public class Arbitre {
	
	private Joueur Joueur1 ;
	private Joueur Joueur2 ;
	//private int nbAllumetetsAvant;
	private boolean TourJ1;
	private boolean TricheDetecte = false ; 
	private boolean arbitreConfiant ;
	public Arbitre(Joueur j1,Joueur j2,boolean confiant) {
		//on affecte les joueurs 
		arbitreConfiant = confiant;
		if(confiant) {
		//System.out.println("je suis confiant");	
		Joueur1 = j1;
		Joueur2 = j2;
		}
		else {
			//on met le proxis
			Joueur1 = new Proxis(j1);
			Joueur2 = new Proxis(j2);
	}
		
	}
		public void arbitrer( jeuPrincipal Jeu){
			while(Jeu.getNombreAllumettes() > 0 && !TricheDetecte){
				//la partie est en cours : 
				SautDeligne(Jeu);
				//c'est le tour de J1
				TourJ1 = true;
				jouerTour(Joueur1,Jeu);
				SautDeligne(Jeu);
				
				if (Jeu.getNombreAllumettes() >0 && !TricheDetecte) {
				//c'est le tour de J2
			     TourJ1 = false;
				jouerTour(Joueur2,Jeu);
				
				
				}
			}
			//la partie est fini 
			//On regarde si il y a de la triche
			if(!TricheDetecte) {
			//on determine le gagnant 
			//System.out.println("-----fin de la partie ------" );
			if(TourJ1) {
				System.out.println(Joueur1.getNom()+ " a perdu !" );
				System.out.println(Joueur2.getNom()+ " a gagné !" );
			
			           }
			else {
				System.out.println(Joueur2.getNom()+ " a perdu !" );
				System.out.println(Joueur1.getNom()+ " a gagné !" );
				
			     }
			}
			
		}
		private void SautDeligne(jeuPrincipal Jeu){
			if(Jeu.getNombreAllumettes() >0){
				System.out.println();
			}
		}
		
		private void jouerTour(Joueur joueur,jeuPrincipal Jeu) {
			
		
			
			//tant que le coup n'est pas valide on recommence : 
			int coup =0; // variable qui stocke le coup du joueur avant verification 
			boolean sortir = false ;
			do{
			System.out.println("Nombre d'allumettes restantes : " + Jeu.getNombreAllumettes());
			System.out.println("Au tour de "+joueur.getNom()+"." );	
			
			sortir = true;
				try{
				
				 coup  = joueur.getPrise(Jeu);
				 if(!TricheDetecte) {
						String motAllumette;
						if(coup < 2 ){
							motAllumette=" allumette.";
						}
						else{
							motAllumette = " allumettes.";
						}
						
					System.out.println(joueur.getNom()+ " prend "+coup + motAllumette  );
				 }
				 Jeu.retirer(coup);
				 
				 
				 
			     }
				catch(CoupInvalideException e ){
					System.out.println("Erreur ! "+ e.getMessage());
					System.out.println("Recommencez !");
					sortir = false;
				 }	
				catch(OperationInterditeException e) {
					if (!arbitreConfiant) {
				
					TricheDetecte = true;
					System.out.println("Partie abandonnée car " +joueur.getNom() + " a triché !" );
					
					
					}
				}
			
			}while(!sortir);
			
		    
			/*if(!TricheDetecte) {
				String motAllumette;
				if(coup == 1 ){
					motAllumette=" allumette.";
				}
				else{
					motAllumette = " allumettes.";
				}
				
			System.out.println(joueur.getNom()+ " prend "+coup + motAllumette  );
			
			
			}*/
			
		}
		
		
}
		
	


