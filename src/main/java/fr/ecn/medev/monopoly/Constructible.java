package fr.ecn.medev.monopoly;
/**
 * Case constructible : on peut y construire des maisons puis un hotel.
 */
public class Constructible extends Achetable {

    private int prixMaison;
    private int prixHotel;
    private int nbMaison;
    private int nbHotel;
    private int loyerBase; // L0
    private int a;
    private int b;

    public Constructible(String nom, int prix, int prixMaison, int prixHotel,
                         int loyerBase, int a, int b) {
        super(nom, prix);
        this.prixMaison = prixMaison;
        this.prixHotel = prixHotel;
        this.loyerBase = loyerBase;
        this.a = a;
        this.b = b;
    }

    @Override
    public void acheter(Joueur acheteur) {
        setProprietaire(acheteur);
    }

    /**
     * Construit une maison. La 4e construction remplace les maisons par un hotel.
     */
    public void construire() {
        if (nbHotel > 0) {
            return;
        }
        if (nbMaison < 3) {
            nbMaison++;
        } else {
            nbMaison = 0;
            nbHotel = 1;
        }
    }

    /**
     * Loyer a payer : L0 + a * nombre de maisons + b * nombre d'hotels.
     */
    public int calculLoyer(Joueur visiteur) {
        if (this.getProprietaire() == null || visiteur == this.getProprietaire()) {
            return 0;
        }
        return loyerBase + a * nbMaison + b * nbHotel;
    }
    public void liberer(){
        super.liberer();
        nbMaison = 0;
        nbHotel = 0;
        
    }
    public int prix_maison(){
        if(nbMaison < 3){
            return prixMaison;
        }
        else{
            return prixHotel;
        }
    }
    
}


