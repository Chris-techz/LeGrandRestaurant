package methodo.exo;

import java.util.ArrayList;
import java.util.List;

public class Serveur {
    private  double _chiffreAffaire;
    private List<Table> _tables;

    public double GetChiffreAffaire() {
        return _chiffreAffaire;
    }

    public Serveur() {
        this._chiffreAffaire = 0;
        this._tables = new ArrayList<Table>();
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

    public int GetNbTables() {
        return this._tables.size();
    }

}
