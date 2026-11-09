package fr.ecn.medev.monopoly;

import java.util.ArrayList;

/**
 * Plateau de 40 cases et liste des joueurs en jeu.
 *
 * <p>Parties 2 et 4 du sujet.</p>
 */
public class Plateau {

    /** Nombre de cases du plateau. */
    public static final int NB_CASES = 40;

    private final ArrayList<Case> cases;
    private final ArrayList<Joueur> joueurs;

    /** Nombre maximal de tours complets (strictement positif). */
    private final int limiteTours;
    /** Nombre de tours complets déjà joués. */
    private int nbToursJoues;

    /**
     * Crée un plateau avec la limite de tours par défaut.
     */
    public Plateau() {
        this(50);
    }

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
        this.cases = new ArrayList<>();
        this.joueurs = new ArrayList<>();
        initPlateau();
    }

    /**
     * Remplit le plateau avec les 40 cases.
     */
    private void initPlateau() {
        // TODO 2 : créer les 40 cases (Départ, terrains, gares, prison, chance...)
        cases.add(new CaseSpeciale("Départ"));
    }

    public ArrayList<Case> getCases() {
        return cases;
    }

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    /**
     * Ajoute un joueur à la partie.
     *
     * @param joueur joueur à ajouter
     */
    public void ajouterJoueur(Joueur joueur) {
        if (joueur == null) {
            throw new IllegalArgumentException("Le joueur ne peut pas être null");
        }
        joueurs.add(joueur);
    }

    /**
     * Ajoute un joueur positionné sur la case Départ.
     *
     * @param nom nom du joueur
     */
    public void ajouterJoueur(String nom) {
        ajouterJoueur(new Joueur(nom, cases.get(0), this));
    }

    /**
     * Compte les cases achetables appartenant au joueur.
     *
     * @param joueur joueur dont on compte les propriétés
     * @return nombre de cases achetables possédées par le joueur
     */
    public int nbCasesJoueur(Joueur joueur) {
        if (joueur == null) {
            throw new IllegalArgumentException("Le joueur ne peut pas être null");
        }
        int nombre = 0;
        for (Case uneCase : cases) {
            if (uneCase instanceof Achetable achetable
                    && joueur.equals(achetable.getProprietaire())) {
                nombre++;
            }
        }
        return nombre;
    }

    /**
     * Compte les gares possédées par {@code j} (2.1).
     *
     * @param j joueur
     * @return nombre de gares possédées
     */
    public int nbGares(Joueur j) {
        int nombre = 0;
        for (Case uneCase : cases) {
            if (uneCase instanceof Gare gare && j.equals(gare.getProprietaire())) {
                nombre++;
            }
        }
        return nombre;
    }

    /**
     * Affiche le plateau via les toString() des cases (2.2),
     * puis les joueurs, leur fortune et leurs propriétés (4.2).
     */
    public void affiche() {
        for (int i = 0; i < cases.size(); i++) {
            System.out.println(i + " : " + cases.get(i));
        }
        System.out.println("Joueurs :");
        for (Joueur joueur : joueurs) {
            System.out.println(joueur + " - position : " + joueur.getPosition());
            for (Case uneCase : cases) {
                if (uneCase instanceof Achetable achetable
                        && joueur.equals(achetable.getProprietaire())) {
                    System.out.println("  Propriété : " + uneCase);
                }
            }
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
        if (cases.isEmpty()) {
            throw new IllegalStateException("Le plateau ne contient aucune case");
        }
        int position = cases.indexOf(depart);
        if (position < 0) {
            throw new IllegalArgumentException("La case de départ n'appartient pas à ce plateau");
        }
        int deplacement = Math.floorMod(d, cases.size());
        return cases.get((position + deplacement) % cases.size());
    }

    /**
     * Déplace un joueur du nombre de cases demandé, de façon circulaire.
     *
     * @param joueur joueur à déplacer
     * @param nbCases nombre de cases à parcourir
     */
    public void avance(Joueur joueur, int nbCases) {
        if (joueur == null) {
            throw new IllegalArgumentException("Le joueur ne peut pas être null");
        }
        joueur.setPosition(avance(joueur.getPosition(), nbCases));
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
