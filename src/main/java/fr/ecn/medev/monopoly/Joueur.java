package fr.ecn.medev.monopoly;

/**
 * Joueur : nom, fortune, position sur le plateau et référence au plateau.
 *
 * <p>Partie 3 du sujet.</p>
 */
public class Joueur {

    /** Fortune initiale de chaque joueur. */
    public static final int FORTUNE_INITIALE = 100000;

    private final String nom;
    private int fortune;
    private Case position;
    private final Plateau plateau;

    /**
     * Crée un joueur avec une fortune de {@value #FORTUNE_INITIALE}.
     *
     * @param nom      nom du joueur
     * @param position case de départ
     * @param plateau  plateau sur lequel il joue
     */
    public Joueur(String nom, Case position, Plateau plateau) {
        this.nom = nom;
        this.fortune = FORTUNE_INITIALE;
        this.position = position;
        this.plateau = plateau;
    }

    public String getNom() {
        return nom;
    }

    public int getFortune() {
        return fortune;
    }

    public Case getPosition() {
        return position;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    /**
     * Lance un dé à 6 faces (code fourni par le sujet).
     *
     * @return un entier entre 1 et 6
     */
    public static int lanceLeDe() {
        return ((int) Math.floor(Math.random() * 6)) + 1;
    }

    /**
     * @return le nombre de gares possédées par ce joueur (3.1)
     */
    public int nbGares() {
        return plateau.nbGares(this);
    }

    /**
     * Paie la somme {@code x} au joueur {@code j} (3.2).
     *
     * @param x somme à payer
     * @param j joueur bénéficiaire
     * @throws NoMoreMoney si la fortune est insuffisante
     */
    public void payer(int x, Joueur j) throws NoMoreMoney {
        // TODO 3.2
        throw new UnsupportedOperationException("TODO 3.2 payer()");
    }

    /**
     * Joue un tour pour ce joueur (3.3) : lance le dé, avance, affiche
     * « Le joueur XX est en YY », achète si le dé est impair, paie le loyer.
     *
     * @throws NoMoreMoney si le joueur ne peut pas payer le loyer
     */
    public void tourDeJeu() throws NoMoreMoney {
        // TODO 3.3
        throw new UnsupportedOperationException("TODO 3.3 Joueur.tourDeJeu()");
    }

    @Override
    public String toString() {
        return nom + " (fortune : " + fortune + ")";
    }
}
