package fr.ecn.medev.monopoly;

/**
 * Gare : loyer = 2500 × nombre de gares possédées par le propriétaire.
 *
 * <p>Parties 1.1 et 1.3 du sujet.</p>
 */
public class Gare extends Achetable {

    /** Loyer par gare possédée. */
    public static final int LOYER_PAR_GARE = 2500;

    /**
     * @param nom  nom de la gare
     * @param prix prix d'achat
     */
    public Gare(String nom, int prix) {
        super(nom, prix);
    }

    @Override
    public int calculLoyer(Joueur visiteur) {
        if (this.getProprietaire() == null || visiteur == this.getProprietaire()) {
            return 0;
        }
        return this.getProprietaire().getNbGares() * LOYER_PAR_GARE;
    }
}


