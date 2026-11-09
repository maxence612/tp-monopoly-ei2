package fr.ecn.medev.monopoly;

/**
 * Exception levée lorsqu'un joueur n'a pas assez d'argent pour payer.
 *
 * <p>Partie 3.2 du sujet.</p>
 */
public class NoMoreMoney extends Exception {

    /**
     * @param message description du défaut de paiement
     */
    public NoMoreMoney(String message) {
        super(message);
    }
}
