package fr.ecn.medev.monopoly;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Plateau de 40 cases et liste des joueurs en jeu.
 *
 * <p>Parties 2 et 4 du sujet.</p>
 */
public class Plateau {

    /** Nombre de cases du plateau. */
    public static final int NB_CASES = 40;

    private final ArrayList<Case> plateau;
    private final LinkedList<Joueur> joueurs;

    /** Nombre maximal de tours complets (strictement positif). */
    private final int limiteTours;
    /** Nombre de tours complets déjà joués. */
    private int nbToursJoues;

    /**
     * @param limiteTours nombre maximal de tours complets (doit être &gt; 0)
     * @throws IllegalArgumentException si {@code limiteTours <= 0}
     */
    public Plateau(int limiteTours) {
        if (limiteTours <= 0) {
            throw new IllegalArgumentException("La limite de tours doit être strictement positive");
        }
        this.limiteTours = limiteTours;
        this.nbToursJoues = 0;
        this.plateau = new ArrayList<>();
        this.joueurs = new LinkedList<>();
        initPlateau();
    }

    /**
     * Remplit le plateau avec les 40 cases.
     */
    private void initPlateau() {
        // TODO 2 : créer les 40 cases (Départ, terrains, gares, prison, chance...)
        plateau.add(new CaseSpeciale("Départ"));
    }

    public ArrayList<Case> getCases() {
        return plateau;
    }

    public LinkedList<Joueur> getJoueurs() {
        return joueurs;
    }

    /**
     * Ajoute un joueur positionné sur la case Départ.
     *
     * @param nom nom du joueur
     */
    public void ajouterJoueur(String nom) {
        joueurs.add(new Joueur(nom, plateau.get(0), this));
    }

    /**
     * Compte les gares possédées par {@code j} (2.1).
     *
     * @param j joueur
     * @return nombre de gares possédées
     */
    public int nbGares(Joueur j) {
        // TODO 2.1
        throw new UnsupportedOperationException("TODO 2.1 nbGares()");
    }

    /**
     * Affiche le plateau via les toString() des cases (2.2),
     * puis les joueurs, leur fortune et leurs propriétés (4.2).
     */
    public void affiche() {
        // TODO 2.2 puis 4.2
        for (Case c : plateau) {
            System.out.println(c);
        }
    }

    /**
     * Renvoie la case située {@code d} cases après {@code depart}, de façon circulaire (2.3).
     *
     * @param depart case de départ
     * @param d      nombre de cases à avancer
     * @return la case d'arrivée
     */
    public Case avance(Case depart, int d) {
        // TODO 2.3
        throw new UnsupportedOperationException("TODO 2.3 avance()");
    }

    /**
     * @return vrai s'il ne reste qu'un joueur ou si la limite de tours est atteinte (4.1)
     */
    public boolean finDePartie() {
        // TODO 4.1
        throw new UnsupportedOperationException("TODO 4.1 finDePartie()");
    }

    /**
     * Fait jouer tous les joueurs jusqu'à la fin de partie (4.3). Les joueurs en défaut
     * de paiement sont éliminés et leurs propriétés libérées.
     */
    public void tourDeJeu() {
        // TODO 4.3
        throw new UnsupportedOperationException("TODO 4.3 Plateau.tourDeJeu()");
    }
}
