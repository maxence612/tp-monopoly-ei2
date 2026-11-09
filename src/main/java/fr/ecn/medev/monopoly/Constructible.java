package fr.ecn.medev.monopoly;

/**
 * Terrain constructible : on peut y bâtir des maisons et des hôtels.
 * Loyer : L = L0 + a·nm + b·nh.
 *
 * <p>Parties 1.1, 1.2 et 1.3 du sujet.</p>
 */
public class Constructible extends Achetable {

    /** Loyer du terrain nu (L0). */
    private final int loyerBase;
    /** Supplément de loyer par maison (a). */
    private final int loyerParMaison;
    /** Supplément de loyer par hôtel (b). */
    private final int loyerParHotel;

    /** Nombre de maisons (nm). */
    private int nbMaisons;
    /** Nombre d'hôtels (nh). */
    private int nbHotels;

    /**
     * @param nom            nom du terrain
     * @param prix           prix d'achat
     * @param loyerBase      L0
     * @param loyerParMaison a
     * @param loyerParHotel  b
     */
    public Constructible(String nom, int prix, int loyerBase, int loyerParMaison, int loyerParHotel) {
        super(nom, prix);
        this.loyerBase = loyerBase;
        this.loyerParMaison = loyerParMaison;
        this.loyerParHotel = loyerParHotel;
        this.nbMaisons = 0;
        this.nbHotels = 0;
    }

    public int getNbMaisons() {
        return nbMaisons;
    }

    public int getNbHotels() {
        return nbHotels;
    }

    /**
     * Construit une maison sur le terrain.
     * TODO 1.1 : définir les règles (coût, maximum de maisons, seul le propriétaire construit...)
     * et les noter dans le rapport (hypothèses).
     */
    public void construireMaison() {
        throw new UnsupportedOperationException("TODO 1.1 construireMaison()");
    }

    /**
     * Construit un hôtel sur le terrain.
     * TODO 1.1 : définir les règles (ex. 4 maisons requises remplacées par un hôtel).
     */
    public void construireHotel() {
        throw new UnsupportedOperationException("TODO 1.1 construireHotel()");
    }

    @Override
    public int calculLoyer(Joueur visiteur) {
        // TODO 1.3 : 0 si pas de propriétaire ou visiteur == propriétaire,
        //            sinon loyerBase + loyerParMaison * nbMaisons + loyerParHotel * nbHotels
        throw new UnsupportedOperationException("TODO 1.3 Constructible.calculLoyer()");
    }

    @Override
    public void liberer() {
        // TODO 4.3 : super.liberer() + retirer maisons et hôtels
        throw new UnsupportedOperationException("TODO 4.3 Constructible.liberer()");
    }

    /**
     * Exemple attendu : {@code Rue Crébillon (coût : 45000) - propriétaire : Bidule, 2 maisons, loyer = 1500}.
     */
    @Override
    public String toString() {
        // TODO 1.2
        return super.toString();
    }
}
