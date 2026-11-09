package fr.ecn.medev.monopoly;

/**
 * Case pouvant être achetée par un joueur : elle a un prix et un propriétaire.
 *
 * <p>Parties 1.1, 1.2 et 1.3 du sujet.</p>
 */
public abstract class Achetable extends Case {

    /** Prix d'achat de la case. */
    protected final int prix;

    /** Propriétaire actuel, {@code null} si la case est libre. */
    protected Joueur proprietaire;

    /**
     * @param nom  nom de la case
     * @param prix prix d'achat
     */
    protected Achetable(String nom, int prix) {
        super(nom);
        this.prix = prix;
        this.proprietaire = null;
    }

    public int getPrix() {
        return prix;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    /**
     * Fait de {@code acheteur} le propriétaire de la case.
     *
     * @param acheteur joueur qui achète la case
     */
    public void acheter(Joueur acheteur) {
        // TODO 1.1 : vérifier que la case est libre, débiter l'acheteur, changer le propriétaire
        throw new UnsupportedOperationException("TODO 1.1 acheter()");
    }

    /**
     * Remet la case sans propriétaire (utilisé lors de l'élimination d'un joueur, 4.3).
     */
    public void liberer() {
        // TODO 4.3 : retirer le propriétaire (Constructible retirera aussi ses maisons/hôtels)
        throw new UnsupportedOperationException("TODO 4.3 liberer()");
    }

    /**
     * Calcule le loyer dû par {@code visiteur} qui tombe sur la case (1.3).
     * Le loyer est nul si la case n'a pas de propriétaire ou si le visiteur en est le propriétaire.
     *
     * @param visiteur joueur qui tombe sur la case
     * @return le montant du loyer
     */
    public abstract int calculLoyer(Joueur visiteur);

    /**
     * Exemple attendu : {@code Gare de Lyon (coût : 20000) - sans propriétaire}.
     */
    @Override
    public String toString() {
        // TODO 1.2
        return nom + " (coût : " + prix + ")";
    }
}
