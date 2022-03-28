package methodo.exo;

import java.util.ArrayList;
import java.util.List;

public class Cuisine {
    private List<Commande> _listeCommandes;

    public Cuisine() {
        this._listeCommandes = new ArrayList<Commande>();
    }

    public void AddCommande(Commande commande) {
        this._listeCommandes.add(commande);
    }

    public List<Commande> GetCommandes() {
        return this._listeCommandes;
    }
}
