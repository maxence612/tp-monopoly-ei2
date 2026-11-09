package fr.ecn.medev.monopoly;

/**
 * Case non achetable (Départ, Prison, Chance, Caisse de communauté, Parc gratuit...).
 * Dans cette version simplifiée, elle n'a aucun effet sur le joueur.
 *
 * <p>Partie 1.1 du sujet.</p>
 */
public class CaseSpeciale extends Case {

    /**
     * @param nom nom de la case (ex. "Départ")
     */
    public CaseSpeciale(String nom) {
        super(nom);
    }
}
