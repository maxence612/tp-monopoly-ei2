package fr.ecn.medev.monopoly;

/**
 * Case abstraite du plateau. Toutes les cases ont un nom.
 *
 * <p>Partie 1.1 du sujet.</p>
 */
public abstract class Case {

    /** Nom affiché de la case. */
    protected final String nom;

    /**
     * Crée une case nommée.
     *
     * @param nom nom de la case
     */
    protected Case(String nom) {
        this.nom = nom;
    }

    /**
     * @return le nom de la case
     */
    public String getNom() {
        return nom;
    }

    /**
     * Représentation textuelle de la case, utilisée pour afficher le plateau (1.2).
     * Exemple : {@code Départ}.
     *
     * @return la description de la case
     */
    @Override
    public String toString() {
        return nom;
    }
}
