package methodo.exo;

public class Serveur {
    private  double _chiffreAffaire;

    public double GetChiffreAffaire() {
        return _chiffreAffaire;
    }

    public Serveur() {
        this._chiffreAffaire = 0;
    }

    public void PrendreCommande(double commande) {
        this._chiffreAffaire += commande;
    }
}
