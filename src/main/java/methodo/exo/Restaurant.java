package methodo.exo;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List <Serveur>_serveurs;
    private double _chiffreAffaireRestaurant;

    public double GetChiffreAffaire() {
        for (int i = 0; i < _serveurs.size(); i++) {
            this._chiffreAffaireRestaurant += _serveurs.get(i).GetChiffreAffaire();
        }
        return this._chiffreAffaireRestaurant;
    }

    public Serveur GetServeur(int index) {
        return this._serveurs.get(index);
    }

    public int GetNbServeurs() {
        return this._serveurs.size();
    }

    public void TousLesServeursPrennentCommande(double commande) {
        for (Serveur serveur : _serveurs) {
            serveur.PrendreCommande(commande);
        }
    }

    //ctor quand un restaurant ouvre avec un nombre donné de serveurs
    public Restaurant(int nbServeurs) {
        this._chiffreAffaireRestaurant = 0;
        this._serveurs = new ArrayList<Serveur>();

        // Ajout d'un nombre donnée de serveurs
        for (int i = 0; i < nbServeurs; i++) {
            this._serveurs.add(new Serveur());
        }
    }

    //ctor quand un restaurant ouvre sans serveur
    public Restaurant() {
        this._chiffreAffaireRestaurant = 0;
        this._serveurs = new ArrayList<Serveur>();
    }

    public void SetNbServeurs(int nbServeurs) {
        _serveurs.clear();
        for (int i = 0; i < nbServeurs; i++) {
            this._serveurs.add(new Serveur());
        }
    }

    public void ResetCA() {
        this._chiffreAffaireRestaurant = 0;
    }
}
