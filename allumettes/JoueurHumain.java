package allumettes;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JoueurHumain extends Joueur {
	
	private Scanner reader = new Scanner(System.in);
	public JoueurHumain(String nm) {
		super(nm);
		// TODO Auto-generated constructor stub
	}

	@Override
	int getPrise(jeuPrincipal jeu) {
		System.out.print("Combien prenez-vous d'allumettes ? ");
		int nbPris= 4  ;
		boolean sortir = false;
		do {
			
			sortir = true;
		try {
			//reader.reset();
			//reader.nextLine();
			nbPris = reader.nextInt();
		}
		catch(InputMismatchException e) {
			sortir = false;
			
			System.out.println("Vous devez donner un entier.");
			reader.nextLine();
			System.out.print("Combien prenez-vous d'allumettes ? ");
		}
		
		}while(!sortir);
		return nbPris;
	}

}
