package methodo.exo;

import java.util.ArrayList;
import java.util.List;

public class Franchise {
    private List<Restaurant>_restaurants;  
    private double _chiffreAffaireFranchise;
    private List<Plat>_plats;

    public double GetChiffreAffaire() {
        for (int i = 0; i < _restaurants.size(); i++) {
            this._chiffreAffaireFranchise += _restaurants.get(i).GetChiffreAffaire();
        }
        return this._chiffreAffaireFranchise;
    }

    public Restaurant GetRestaurant(int index) {
        return this._restaurants.get(index);
    }

    public int GetNbRestaurants() {
        return this._restaurants.size();
    }

    private void TousLesRestosPrennentCommande(double commande) {
        for (Restaurant restaurant : _restaurants) {
            restaurant.TousLesServeursPrennentCommande(commande);;
        }
    }

    private void SetNbServeursTousLesRestaurant(int nbServeurs) {
        for (Restaurant restaurant : _restaurants) {
            restaurant.SetServeurs(nbServeurs);
        }
    }

    public Franchise(int nbRestaurants) {
        this._chiffreAffaireFranchise = 0;
        this._restaurants = new ArrayList<Restaurant>();

        // Ajout d'un nombre donné de restaurants d'un nombre donné de serveurs
        for(int i = 0; i < nbRestaurants; i++) {
            this._restaurants.add(new Restaurant());
        }
    }

    public Franchise() {
        this._chiffreAffaireFranchise = 0;
        this._restaurants = new ArrayList<Restaurant>();
        this._plats = new ArrayList<Plat>();
    }

    // Reset le C.A de la frachise et de ses restaurants
    private void ResetCA() {
        this._chiffreAffaireFranchise = 0;
        // Reset CA de chaque restaurant de la franchise
        for (Restaurant restaurant : _restaurants) {
            restaurant.ResetCA();
        }
    }
    
    // Tous les serveurs de tous les restaurants de la franchise prennent commande
    public void FranchiseCommander(int nbServeurs, double commande) {
        this.ResetCA();
        this.SetNbServeursTousLesRestaurant(nbServeurs);
        this.TousLesRestosPrennentCommande(commande);
    }

    public void AddPlat(Plat platToAdd) {
        Plat plat = new Plat(platToAdd.getId(), platToAdd.getPrix());
        this._plats.add(plat);
    }

    public void ModifPrixPlat(int indexPlat, double nouveauPrix) {
        this._plats.get(indexPlat).setPrix(nouveauPrix);
    }

    public List<Plat> GetMenu() {
        return _plats;
    }
}
