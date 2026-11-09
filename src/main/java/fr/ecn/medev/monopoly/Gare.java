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
        int loyer= this.getProprietaire().nbGares()*LOYER_PAR_GARE;
        return loyer;
    }
}

