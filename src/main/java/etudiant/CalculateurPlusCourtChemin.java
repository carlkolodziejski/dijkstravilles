package etudiant;

import java.util.ArrayList;

import jfc.ICalculateurPlusCourtChemin;
import jfc.Ville;
/**
 * Les instances de cette classe permette de calculer un plus court chemine entre deux villes en utilisant l'algorithme de Dijkstra.
 * @author Jean-François Condotta, 04 juin 2023.
 *
 */
public class CalculateurPlusCourtChemin implements ICalculateurPlusCourtChemin{

	@Override
	public ArrayList<Ville> plusCourtChemin(ArrayList<Ville> toutesLesVilles, Ville villeDepart, Ville villeArrivee) {
		
		ArrayList<Ville> chemin=new ArrayList<Ville>();
		// A modifier
		// Supprimer les deux lignes suivantes et mettre votre code.
		chemin.add(villeDepart);
		chemin.add(villeArrivee);
		
		return chemin;
	}

}
