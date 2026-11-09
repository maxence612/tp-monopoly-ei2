package fr.ecn.medev.monopoly;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un joueur du jeu Monopoly.
 */
public class Joueur {

    private String nom;

    private String icone;

    private int fortune;

    private List<Achetable> propriete;

    private int position;


    /**
     * Constructeur du joueur.
     *
     * @param nom nom du joueur
     * @param icone icône (pion) représentant le joueur
     * @param position position initiale du joueur sur le plateau
     */
    public Joueur(String nom, String icone, int position) {
        this.nom = nom;
        this.icone = icone;
        this.position = position;
        this.fortune = 100000;
        this.propriete = new ArrayList<>();
    }

    /**
     * Méthode permettant de lancer le dé du jeu.
     *
     * @return un entier aléatoire compris entre 1 et 6 inclus
     */
    public static int lanceLeDe() {
        return (int) Math.floor(Math.random() * 6) + 1;
    }

    /**
     * Retourne le nombre de propriétés du joueur qui sont des gares.
     *
     * @return le nombre de gares appartenant au joueur
     */
    public int getNbGares() {
        int nbGares = 0;
        for (Achetable unePropriete : this.propriete) {
            if (unePropriete instanceof Gare) {
                nbGares++;
            }
        }
        return nbGares;
    }

    /**
     * Permet au joueur de payer un montant à un destinataire.
     *
     * @param destinataire joueur à qui le montant est transféré (peut être null)
     * @param montant montant à payer
     * @throws NoMoreMoney si la fortune du joueur est inférieure au montant
     */
    public void payer(Joueur destinataire, int montant) {
        if (this.fortune < montant) {
            throw new Error("Le joueur " + this.nom + " n'a pas assez d'argent pour payer " + montant + "$.");
        }
        this.fortune -= montant;
        if (destinataire != null) {
            destinataire.setFortune(destinataire.getFortune() + montant);
        }
    }

    /**
     * Méthode exécutant le tour du joueur : elle lance le dé,
     * avance le joueur sur le plateau, puis gère l'achat ou le paiement
     * de la case se trouvant à la nouvelle position.
     *
     * @throws NoMoreMoney si le joueur ne dispose pas de la fortune suffisante
     *                     pour payer le loyer de la case possédée
     */
    public void tourDeJeu(Plateau plateau) {
        int de = lanceLeDe();
        int nouvellePosition = plateau.avance(this.position, de);
        System.out.println("avance de "+de+" cases");
        this.position = nouvellePosition;
        Case currentCase = plateau.getCase(this.position);
        System.out.println("Le joueur " + this.nom + " est en " + currentCase.getNom() + " >>>");
        if (currentCase instanceof Achetable) {
            Achetable achetable = (Achetable) currentCase;
            if (achetable.getProprietaire() == null) {
                if (de % 2 != 0 && this.fortune >= achetable.getPrix()) {
                    this.fortune -= achetable.getPrix();
                    achetable.setProprietaire(this);
                    this.propriete.add(achetable);
                }
            } else {
                this.payer(achetable.getProprietaire(), achetable.getLoyer());
            }
        }
    }

    /**
     * Affiche les informations complètes du joueur : nom, icône, fortune,
     * position courante et liste des propriétés possédées.
     */
    public void affiche() {
        System.out.println("Nom du joueur : " + this.nom);
        System.out.println("Icône : " + this.icone);
        System.out.println("Fortune : " + this.fortune + " €");
        System.out.println("Position : " + this.position);
        System.out.println("Propriétés possédées : " + this.propriete);
    }

    /**
     * @return le nom du joueur
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom le nouveau nom du joueur
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return l'icône (pion) du joueur
     */
    public String getIcone() {
        return icone;
    }

    /**
     * @param icone le nouvel icône (pion) du joueur
     */
    public void setIcone(String icone) {
        this.icone = icone;
    }

    /**
     * @return la fortune actuelle du joueur
     */
    public int getFortune() {
        return fortune;
    }

    /**
     * @param fortune la nouvelle fortune du joueur
     */
    public void setFortune(int fortune) {
        this.fortune = fortune;
    }

    /**
     * @return l'indice de la case courante du joueur sur le plateau
     */
    public int getPosition() {
        return position;
    }

    /**
     * @param position le nouvel indice de case du joueur
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * @return la liste des propriétés possédées par le joueur
     */
    public List<Achetable> getProprietes() {
        return propriete;
    }

    /**
     * @param propriete la nouvelle liste des propriétés du joueur
     */
    public void setProprietes(List<Achetable> propriete) {
        this.propriete = propriete;
    }

    
}
