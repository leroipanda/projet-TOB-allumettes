package allumettes;

public class Arbitre {
	
	private Joueur Joueur1 ;
	private Joueur Joueur2 ;
	//private int nbAllumetetsAvant;
	private boolean TourJ1 = false ;
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
			while(Jeu.getNombreAllumettes() > 0){
				//la partie est en cours : 
				
				//on alterne le tour du joueur 1 et 2 
				
				
				int coup =0; // variable qui stocke le coup du joueur avant verification 
				//c'est le tour du joueur 1
				TourJ1 = true;
				//on garde le nombre d'allumettes precedents
				//nbAllumetetsAvant =Jeu.getNombreAllumettes(); 
				
				System.out.println("Nombre d'allumettes restantes : " + Jeu.getNombreAllumettes());
				System.out.println("Au tour de "+Joueur1.getNom() );
				
				//tant que le coup n'est pas valide on recommence : 
				boolean sortir = false ;
				do{
					
				
				sortir = true;
					try{
					 coup  = Joueur1.getPrise(Jeu);
					 Jeu.retirer(coup);
					 
				     }
					catch(CoupInvalideException e ){
						sortir = false;
					 }	
					catch(OperationInterditeException e) {
						if (!arbitreConfiant) {
					
						TricheDetecte = true;
						System.out.println("Partie abandonnée car " +Joueur1.getNom() + " a triché !" );
						
						
						}
					}
				
				}while(!sortir);
				
				//on quite si triche 
				if(TricheDetecte) {
					break;
				}
				/*
				//detection d'un tricheur 
				if(antiTriche(nbAllumetetsAvant,Jeu)) {
					TricheDetecte = true;
					System.out.println("Partie abandonnée car " + Joueur1.getNom() + " a triché !" );
					break;
				}
				*/
				


				System.out.println(Joueur1.getNom()+ " prend "+coup + " allumettes" );
				System.out.println();

				//on regarde si la partie n'est pas finie 
				if(Jeu.getNombreAllumettes() != 0 ){
					//c'est le tour du joueur 2
					TourJ1 =false;
					
					//on garde le nombre d'allumettes precedents
					//nbAllumetetsAvant =Jeu.getNombreAllumettes(); 
					
					System.out.println("Nombre d'allumettes restantes : " + Jeu.getNombreAllumettes());
					System.out.println("Au tour de "+Joueur2.getNom() );
					do{
						
						
						sortir = true;	
						try{
							coup  = Joueur2.getPrise(Jeu);
							 Jeu.retirer(coup);
						 }
						 catch(CoupInvalideException e ){
								sortir = false;
							}
						catch(OperationInterditeException e) {
							if (!arbitreConfiant) {
						
							TricheDetecte = true;
							System.out.println("Partie abandonnée car " +Joueur2.getNom() + " a triché !" );
							}
						}
							
						}while(!sortir);
					
					
					//on quite si triche 
					if(TricheDetecte) {
						break;
					}
					
					//detection d'un tricheur 
					/* if(antiTriche(nbAllumetetsAvant,Jeu)) {
						TricheDetecte = true;
						System.out.println("Partie abandonnée car " +Joueur2.getNom() + " a triché !" );
						break;
					}
					 
					 
						System.out.println(Joueur2.getNom()+ " prend "+coup + " allumettes" );
						System.out.println();
				        } */
			
			}
			}
			//la partie est fini 
			//On regarde si il y a de la triche
			if(!TricheDetecte) {
			//on determine le gagnant 
			System.out.println("-----fin de la partie ------" );
			if(TourJ1) {
				System.out.println(Joueur2.getNom()+ " gagne" );
			           }
			else {
				System.out.println(Joueur1.getNom()+ " gagne" );
			     }
			}
			
		}
}
		/* fonction inutile maintenant
		 * public boolean antiTriche(int allumetteAvant ,jeuPrincipal Jeu){
		
			return allumetteAvant-Jeu.getNombreAllumettes() > 3;
		}
		*/
	


