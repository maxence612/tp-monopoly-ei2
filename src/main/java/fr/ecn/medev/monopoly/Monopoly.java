package fr.ecn.medev.monopoly;

/**
 * Point d'entrée : lance une simulation de Monopoly simplifié.
 *
 * <p>Usage : {@code java fr.ecn.medev.monopoly.Monopoly [limiteTours] [joueur1 joueur2 ...]}</p>
 */
public class Monopoly {

    /** Limite de tours utilisée si aucun argument n'est donné. */
    public static final int LIMITE_TOURS_DEFAUT = 50;

    /**
     * @param args {@code args[0]} = limite de tours (optionnel), puis les noms des joueurs
     */
    public static void main(String[] args) {
        int limiteTours = args.length > 0 ? Integer.parseInt(args[0]) : LIMITE_TOURS_DEFAUT;

        Plateau plateau = new Plateau(limiteTours);
        if (args.length > 1) {
            for (int i = 1; i < args.length; i++) {
                plateau.ajouterJoueur(args[i]);
            }
        } else {
            plateau.ajouterJoueur("Alice");
            plateau.ajouterJoueur("Bob");
            plateau.ajouterJoueur("Chloé");
        }

        plateau.affiche();
        // TODO 4.3 : décommenter quand Plateau.tourDeJeu() est prêt
        // plateau.tourDeJeu();
    }
}
