package fr.ecn.medev.monopoly;
import java.util.Scanner;

/**
 * Point d'entrée : lance une simulation de Monopoly simplifié.
 *
 * <p>Usage : {@code java fr.ecn.medev.monopoly.Monopoly [limiteTours] [joueur1 joueur2 ...]}</p>
 */
public class Monopoly {

    /** Limite de tours utilisée si aucun argument n'est donné. */
    public static final int LIMITE_TOURS = 50;

    /**
     * @param args {@code args[0]} = limite de tours (optionnel), puis les noms des joueurs
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Plateau plateau = new Plateau();
        int joueurEnCours = 0;
        int nbJoueurs = 0;
        int nbTours = 0;

        while ( nbJoueurs<=0 || nbJoueurs>5){
            System.out.print("Combien de joueur vont jouer ? (entre 0 et 5) : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Erreur : tu dois entrer un nombre entier !");
                scanner.next(); // Élimine la saisie incorrecte
                System.out.print("Réessaie : ");
            }
            nbJoueurs = scanner.nextInt();
        }
   
        for (int i = 0; i < nbJoueurs; i++) {
            System.out.print("Nom du joueur " + (i + 1) + " : ");
            String nom = scanner.next();
            plateau.ajouterJoueur(nom);
        }

        System.out.print("Super, la partie peut commencer !\n");
        System.out.print("Avec, comme joueurs : ");
        for (Joueur joueur : plateau.getJoueurs()) {
            System.out.print(joueur.getNom() + " ");
        }
        System.out.println();

        // Tour de jeu
        while (nbTours < LIMITE_TOURS)
        {
            Joueur joueurActuel = plateau.getJoueurs().get(joueurEnCours);
            System.out.println("Tour " + (nbTours + 1) + ", c'est au tour de " + joueurActuel.getNom() + " !");
            
           joueurActuel.tourDeJeu(plateau);
           if (joueurActuel.getFortune() < 0) {
                System.out.println(joueurActuel.getNom() + " est éliminé !");
                plateau.supprimerJoueur(joueurActuel.getNom());
                if (plateau.getJoueurs().size() == 1) {
                    System.out.println(plateau.getJoueurs().get(0).getNom() + " a gagné la partie !");
                    break;
                }
            } else {
                System.out.println(joueurActuel.getNom() + " a maintenant " + joueurActuel.getFortune() + "$.");
            } 

            joueurEnCours = (joueurEnCours + 1) % plateau.getJoueurs().size();
            if (joueurEnCours == 0) {
                nbTours++;
            }
        }

        plateau.affiche();


        scanner.close();
        
    }
}
