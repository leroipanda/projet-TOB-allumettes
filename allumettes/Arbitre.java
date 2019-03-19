package allumettes;

public class Arbitre {
	
	private Joueur Joueur1 ;
	private Joueur Joueur2 ;
	private boolean TourJ1 = false ;
	public Arbitre(Joueur j1,Joueur j2) {
		//on affecte les joueurs 
		Joueur1 = j1;
		Joueur2 = j2;
	}
		public void arbitrer( jeuPrincipal Jeu){
			while(Jeu.getNombreAllumettes() != 0 ){
				//la partie est en cours : 
				
				//on alterne le tour du joueur 1 et 2 
				
				
				int coup ; // variable qui stocke le coup du joueur avant verification 
				//c'est le tour du joueur 1
				TourJ1 = true;
				System.out.println("Tour de "+Joueur1.getNom()+ " :" +"( il reste " + Jeu.getNombreAllumettes() + " allumettes )" );
				//tant que le coup n'est pas valide on recommence : 
				
				do{
					
				coup  = Joueur1.getPrise(Jeu);
					
					
				}while(!coupValide(coup,Jeu));
				//le coup est valide 
				//on retire les allumettes
				try{
					 Jeu.retirer(coup);
				 }
				 catch(CoupInvalideException e ){
						System.out.println("ce n'est pas normal" );
					}
				System.out.println(Joueur1.getNom()+ " prends "+coup + " allumettes" );
				

				//on regarde si la partie n'est pas finie 
				if(Jeu.getNombreAllumettes() != 0 ){
					//c'est le tour du joueur 2
					TourJ1 =false;
					System.out.println("Tour de "+Joueur2.getNom()+ " :" +"( il reste " + Jeu.getNombreAllumettes() + " allumettes )" );
					do{
						
						coup  = Joueur2.getPrise(Jeu);
							
							
						}while(!coupValide(coup,Jeu));
						//le coup est valide 
					 //on retire les allumettes
					 try{
						 Jeu.retirer(coup);
					 }
					 catch(CoupInvalideException e ){
							System.out.println("ce n'est pas normal" );
						}
					 
						System.out.println(Joueur2.getNom()+ " prends "+coup + " allumettes" );
					
					
					
				}
				
				
				
				
				
			}
			//la partie est fini 
			//on determine le gagnant 
			System.out.println("-----fin de la partie ------" );
			if(TourJ1) {
				System.out.println(Joueur2.getNom()+ " gagne" );
			}
			else {
				System.out.println(Joueur1.getNom()+ " gagne" );
			}

			}
		
		public boolean coupValide(int coup ,jeuPrincipal Jeu){
			return coup <= Jeu.PRISE_MAX || coup > 0;
		}
		
	}


