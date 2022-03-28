package methodo.exo;

import java.util.ArrayList;
import java.util.List;

public class Serveur {
    private Restaurant _restaurant;
    private  double _chiffreAffaire;
    private List<Table> _tables;
    private List<Commande>_commandes;

    public double GetChiffreAffaire() {
        return _chiffreAffaire;
    }

    public Serveur(Restaurant restaurant) {
        this._restaurant = restaurant;
        this._chiffreAffaire = 0;
        this._tables = new ArrayList<Table>();
        this._commandes = new ArrayList<Commande>();
    }

    public Serveur() {
        this._chiffreAffaire = 0;
        this._tables = new ArrayList<Table>();
        this._commandes = new ArrayList<Commande>();
    }

    public void PrendreCommande(double commande) {
        this._chiffreAffaire += commande;
    }

    public void PrendreTable(Table table) {
        this._tables.add(table);
    }

    public List<Table> GetTables() {
        return this._tables;
    }

    public void PrendreCommande() {
        this._commandes.add(new Commande(this));
    }

    public void PrendreCommandeNourriture(Commande commande) {
        this._restaurant.GetCuisine().AddCommande(commande);
    }

    public void PrendreCommandeBoisson(Commande commande) {
    }

    public void SetCommandePayee(int indexCommande) {
        this._commandes.get(indexCommande).SetEstPayee(true);
    }

    public void SetCommandeNonPayee(int indexCommande) {
        this._commandes.get(indexCommande).SetEstPayee(false);
        this._commandes.get(indexCommande).SetEpinglee();
    }

    public List<Commande>GetCommandes() {
        return this._commandes;
    }

    public void PasserCommandeRestaurant(Commande commandeAPasser) {
        this._restaurant.AddCommandeATranmettre(commandeAPasser);
    }


}
