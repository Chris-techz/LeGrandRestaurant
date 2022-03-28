package methodo.exo;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private int _nbTables;
    private double _chiffreAffaireRestaurant;
    private List <Table> _tables;
    private MaitreHotel _maitreHotel;
    private List <Serveur>_serveurs;

    public void DebutService() {
        this._tables = null;
    }

    public void FinService() {
        this._tables = new ArrayList<Table>();
        List<Table> tablesDesordre = new ArrayList<Table>();
        // Récupère chaque table de chaque serveur
        for (Serveur serveur : _serveurs) {
            for (Table table : serveur.GetTables()) {
                tablesDesordre.add(table);
            }
        }
        // Récupère chaque table du maitre d'hotel
        for (Table table : this._maitreHotel.GetTables()) {
            tablesDesordre.add(table);
        }

        // Range les tables dans l'odre dans la liste du restaurant
        int index = 0;
        int id = 0;
        try {
            while (this._tables.size() != this._nbTables) {
                if (tablesDesordre.get(index).GetId() == id) {
                    this._tables.add(tablesDesordre.get(index));
                    id++;
                    index = 0;
                }
                else {
                    index++;
                }
            }
        } catch (Exception e) {
            System.err.print("Index out of bounds !");
        }
    }

    public List<Serveur> GetServeurs() {
        return this._serveurs;
    }

    public void AssigneTableServeur(int idServeur, int idTable) {
        this._serveurs.get(idServeur).PrendreTable(this._tables.get(idTable));
        this._tables.remove(idTable);
    }

    public void AssigneTableMaitre() {
        this._maitreHotel.PrendreTables(this._tables);
    }

    public void TousLesServeursPrennentCommande(double commande) {
        for (Serveur serveur : _serveurs) {
            serveur.PrendreCommande(commande);
        }
    }

    public void SetNbServeurs(int nbServeurs) {
        _serveurs.clear();
        for (int i = 0; i < nbServeurs; i++) {
            this._serveurs.add(new Serveur());
        }
    }
    
    public MaitreHotel GetMaitre() {
        return this._maitreHotel;
    }

    public void SetTables(int nbTables) {
        this._nbTables = nbTables;
        this._tables.clear();

        for (int i = 0; i < nbTables; i++) {
            this._tables.add(new Table(i));
        }
    }

    public double GetChiffreAffaire() {
        for (int i = 0; i < GetServeurs().size(); i++) {
            this._chiffreAffaireRestaurant += GetServeurs().get(i).GetChiffreAffaire();
        }
        return this._chiffreAffaireRestaurant;
    }

    // ctor quand un restaurant ouvre avec un nombre donné de serveurs
    public Restaurant(int nbServeurs) {
        this._nbTables = 0;
        this._chiffreAffaireRestaurant = 0;
        this._tables = new ArrayList<Table>();
        this._maitreHotel = new MaitreHotel();
        this._serveurs = new ArrayList<Serveur>();

        // Ajout d'un nombre donné de serveurs
        for (int i = 0; i < nbServeurs; i++) {
            this.GetServeurs().add(new Serveur());
        }
    }

    // ctor quand un restaurant ouvre sans serveur
    public Restaurant() {
        this._chiffreAffaireRestaurant = 0;
        this._tables = new ArrayList<Table>();
        this._maitreHotel = new MaitreHotel();
        this._serveurs = new ArrayList<Serveur>();
    }

    public void ResetCA() {
        this._chiffreAffaireRestaurant = 0;
    }

}
