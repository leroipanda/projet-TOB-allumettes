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
		System.out.print("nombre d'allumettes prisent ?");
		int nbPris= 4  ;
		boolean sortir = false;
		do {
			
			sortir = true;
		try {
			//reader.reset();
			reader.nextLine();
			nbPris = reader.nextInt();
		}
		catch(InputMismatchException e) {
			sortir = false;
			System.out.print("vous devez donner un entier");
		}
		
		}while(!sortir);
		return nbPris;
	}

}
