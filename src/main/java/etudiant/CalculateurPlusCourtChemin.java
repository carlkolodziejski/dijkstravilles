package etudiant;

import jfc.ICalculateurPlusCourtChemin;
import jfc.Ville;

import java.util.ArrayList;
import java.util.List;

/**
 * Les instances de cette classe permette de calculer un plus court chemine entre deux villes en utilisant l'algorithme de Dijkstra.
 *
 * @author Jean-François Condotta, 04 juin 2023.
 */
public class CalculateurPlusCourtChemin implements ICalculateurPlusCourtChemin {

    @Override
    public ArrayList<Ville> plusCourtChemin(ArrayList<Ville> toutesLesVilles, Ville villeDepart, Ville villeArrivee) {

        // Initialisation.
        ArrayList<Ville> chemin = new ArrayList<>();
        List<Sommet> sommets = new ArrayList<>();

        // On associe chaque ville à un sommet.
        for (Ville ville : toutesLesVilles) {
            sommets.add(new Sommet(ville));
        }

        Sommet sommetDepart = Sommet.getSommet(sommets, villeDepart);
        Sommet sommetArrivee = Sommet.getSommet(sommets, villeArrivee);

        // On initialise le coût du sommet correspondant à la ville de départ à 0.
        sommetDepart.setCout(0);

        chemin.add(villeDepart);
        chemin.add(villeArrivee);

        // Traitement.
        while (!sommets.isEmpty()) {
            Sommet s = Sommet.getSommetCoutMin(sommets);
            if (s == sommetArrivee) break;
            sommets.remove(s);

            // On met à jour les coûts des sommets voisins.
            for (Sommet v : Sommet.getSommetsVoisins(sommets, s)) {
                // On calcule le coût du sommet v en passant par le sommet s.
                int cout = s.getCout() + s.getVille().getDistanceMetres(v.getVille());

                // Si le coût calculé est inférieur au coût actuel du sommet v, on met à jour le coût et le prédécesseur du sommet v.
                if (cout < v.getCout()) {
                    v.setCout(cout);
                    v.setPredecesseur(s);
                }
            }
        }

        return chemin;
    }

}
