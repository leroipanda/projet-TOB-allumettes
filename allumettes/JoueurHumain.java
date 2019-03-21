package allumettes;
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
		return reader.nextInt();
		
	}

}
