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
        cases.add(new CaseSpeciale("Départ"));
        ajouterTerrain("Boulevard de Belleville", 6000, 10000, 50000, 200, 1000, 5000);
        cases.add(new CaseSpeciale("Caisse de communauté"));
        ajouterTerrain("Rue Lecourbe", 6000, 10000, 50000, 400, 2000, 10000);
        cases.add(new CaseSpeciale("Impôt sur le revenu"));
        cases.add(new Gare("Gare Montparnasse", 20000));
        ajouterTerrain("Rue de Vaugirard", 10000, 10000, 50000, 600, 3000, 15000);
        cases.add(new CaseSpeciale("Chance"));
        ajouterTerrain("Rue de Courcelles", 10000, 10000, 50000, 600, 3000, 15000);
        ajouterTerrain("Avenue de la République", 12000, 10000, 50000, 800, 4000, 20000);
        cases.add(new CaseSpeciale("Prison / simple visite"));
        ajouterTerrain("Boulevard de la Villette", 14000, 15000, 75000, 1000, 5000, 25000);
        cases.add(new CaseSpeciale("Compagnie d'électricité"));
        ajouterTerrain("Avenue de Neuilly", 14000, 15000, 75000, 1000, 5000, 25000);
        ajouterTerrain("Rue de Paradis", 16000, 15000, 75000, 1200, 6000, 30000);
        cases.add(new Gare("Gare de Lyon", 20000));
        ajouterTerrain("Avenue Mozart", 18000, 15000, 75000, 1400, 7000, 35000);
        cases.add(new CaseSpeciale("Caisse de communauté"));
        ajouterTerrain("Boulevard Saint-Michel", 18000, 15000, 75000, 1400, 7000, 35000);
        ajouterTerrain("Place Pigalle", 20000, 15000, 75000, 1600, 8000, 40000);
        cases.add(new CaseSpeciale("Parc gratuit"));
        ajouterTerrain("Avenue Matignon", 22000, 20000, 100000, 1800, 9000, 45000);
        cases.add(new CaseSpeciale("Chance"));
        ajouterTerrain("Boulevard Malesherbes", 22000, 20000, 100000, 1800, 9000, 45000);
        ajouterTerrain("Avenue Henri-Martin", 24000, 20000, 100000, 2000, 10000, 50000);
        cases.add(new Gare("Gare du Nord", 20000));
        ajouterTerrain("Faubourg Saint-Honoré", 26000, 20000, 100000, 2200, 11000, 55000);
        ajouterTerrain("Place de la Bourse", 26000, 20000, 100000, 2200, 11000, 55000);
        cases.add(new CaseSpeciale("Compagnie des eaux"));
        ajouterTerrain("Rue La Fayette", 28000, 20000, 100000, 2400, 12000, 60000);
        cases.add(new CaseSpeciale("Allez en prison"));
        ajouterTerrain("Avenue de Breteuil", 30000, 25000, 125000, 2600, 13000, 65000);
        ajouterTerrain("Avenue Foch", 30000, 25000, 125000, 2600, 13000, 65000);
        cases.add(new CaseSpeciale("Caisse de communauté"));
        ajouterTerrain("Boulevard des Capucines", 32000, 25000, 125000, 2800, 14000, 70000);
        cases.add(new Gare("Gare Saint-Lazare", 20000));
        cases.add(new CaseSpeciale("Chance"));
        ajouterTerrain("Avenue des Champs-Élysées", 35000, 25000, 125000, 3500, 17500, 87500);
        cases.add(new CaseSpeciale("Taxe de luxe"));
        ajouterTerrain("Rue de la Paix", 40000, 25000, 125000, 5000, 25000, 125000);
    }

    /**
     * Ajoute un terrain avec ses prix et loyers.
     */
    private void ajouterTerrain(String nom, int prix, int prixMaison, int prixHotel,
                               int loyerBase, int loyerParMaison, int loyerParHotel) {
        cases.add(new Constructible(nom, prix, prixMaison, prixHotel,
                loyerBase, loyerParMaison, loyerParHotel));
    }

    public ArrayList<Case> getCases() {
        return cases;
    }

    /**
     * Renvoie la case située à l'indice indiqué.
     *
     * @param indice indice de la case dans le plateau
     * @return la case à cet indice
     * @throws IndexOutOfBoundsException si l'indice est hors des limites de la liste
     */
    public Case getCase(int indice) {
        return cases.get(indice);
    }

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    public int getNbToursJoues() {
        return nbToursJoues;
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
        ajouterJoueur(new Joueur(nom, "Pion", 0));
    }

    /**
     * Supprime un joueur et remet en vente toutes ses propriétés.
     *
     * @param nom nom du joueur à supprimer
     */
    public void supprimerJoueur(String nom) {
        if (nom == null) {
            throw new IllegalArgumentException("Le nom du joueur ne peut pas être null");
        }

        Joueur joueurASupprimer = null;
        for (Joueur joueur : joueurs) {
            if (nom.equals(joueur.getNom())) {
                joueurASupprimer = joueur;
                break;
            }
        }
        if (joueurASupprimer == null) {
            return;
        }

        for (Case uneCase : cases) {
            if (uneCase instanceof Achetable achetable
                    && joueurASupprimer.equals(achetable.getProprietaire())) {
                achetable.liberer();
            }
        }
        joueurs.remove(joueurASupprimer);
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
     * Renvoie la case située après un déplacement circulaire depuis un indice donné.
     *
     * @param position indice de la case de départ
     * @param deplacement nombre de cases à avancer
     * @return l'indice de la case d'arrivée
     * @throws IndexOutOfBoundsException si la position n'est pas un indice valide
     */
    public int avance(int position, int deplacement) {
        if (position < 0 || position >= NB_CASES) {
            throw new IndexOutOfBoundsException("Indice de départ hors des limites du plateau : " + position);
        }
        int deplacementNormalise = Math.floorMod(deplacement, NB_CASES);
        return (int) (((long) position + deplacementNormalise) % NB_CASES);
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
